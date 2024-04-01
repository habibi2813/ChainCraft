
package net.mcreator.chaincraft.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.chaincraft.world.inventory.CoinCreatorGuiMenu;
import net.mcreator.chaincraft.procedures.UsdtcreateProcedure;
import net.mcreator.chaincraft.procedures.SolcreateProcedure;
import net.mcreator.chaincraft.procedures.EthcreateProcedure;
import net.mcreator.chaincraft.procedures.DogecreateProcedure;
import net.mcreator.chaincraft.procedures.BtccreateProcedure;
import net.mcreator.chaincraft.procedures.AdacreateProcedure;
import net.mcreator.chaincraft.ChaincraftMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CoinCreatorGuiButtonMessage {
	private final int buttonID, x, y, z;

	public CoinCreatorGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CoinCreatorGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CoinCreatorGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CoinCreatorGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = CoinCreatorGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EthcreateProcedure.execute();
		}
		if (buttonID == 1) {

			UsdtcreateProcedure.execute();
		}
		if (buttonID == 2) {

			BtccreateProcedure.execute();
		}
		if (buttonID == 3) {

			SolcreateProcedure.execute();
		}
		if (buttonID == 4) {

			DogecreateProcedure.execute();
		}
		if (buttonID == 5) {

			AdacreateProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ChaincraftMod.addNetworkMessage(CoinCreatorGuiButtonMessage.class, CoinCreatorGuiButtonMessage::buffer, CoinCreatorGuiButtonMessage::new, CoinCreatorGuiButtonMessage::handler);
	}
}

package net.mcreator.chaincraft.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.chaincraft.configuration.CoincapConfiguration;
import net.mcreator.chaincraft.ChaincraftMod;

@Mod.EventBusSubscriber(modid = ChaincraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChaincraftModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CoincapConfiguration.SPEC, "coin_cap.toml");
		});
	}
}

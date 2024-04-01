package net.mcreator.chaincraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.chaincraft.world.inventory.CoinCreatorGuiMenu;
import net.mcreator.chaincraft.network.CoinCreatorGuiButtonMessage;
import net.mcreator.chaincraft.ChaincraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CoinCreatorGuiScreen extends AbstractContainerScreen<CoinCreatorGuiMenu> {
	private final static HashMap<String, Object> guistate = CoinCreatorGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox supply_for_creator;
	EditBox test;
	Button button_eth;
	Button button_usdt;
	Button button_btc;
	Button button_sol;
	Button button_doge;
	Button button_ada;

	public CoinCreatorGuiScreen(CoinCreatorGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 232;
	}

	private static final ResourceLocation texture = new ResourceLocation("chaincraft:textures/screens/coin_creator_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		supply_for_creator.render(guiGraphics, mouseX, mouseY, partialTicks);
		test.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (supply_for_creator.isFocused())
			return supply_for_creator.keyPressed(key, b, c);
		if (test.isFocused())
			return test.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		supply_for_creator.tick();
		test.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.chaincraft.coin_creator_gui.label_coin_creator"), 122, 13, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.chaincraft.coin_creator_gui.label_read_wiki"), 4, 4, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		supply_for_creator = new EditBox(this.font, this.leftPos + 95, this.topPos + 29, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_creator")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_creator").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_creator").getString());
				else
					setSuggestion(null);
			}
		};
		supply_for_creator.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_creator").getString());
		supply_for_creator.setMaxLength(32767);
		guistate.put("text:supply_for_creator", supply_for_creator);
		this.addWidget(this.supply_for_creator);
		test = new EditBox(this.font, this.leftPos + 28, this.topPos + 104, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.test")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.test").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.test").getString());
				else
					setSuggestion(null);
			}
		};
		test.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.test").getString());
		test.setMaxLength(32767);
		guistate.put("text:test", test);
		this.addWidget(this.test);
		button_eth = Button.builder(Component.translatable("gui.chaincraft.coin_creator_gui.button_eth"), e -> {
			if (true) {
				ChaincraftMod.PACKET_HANDLER.sendToServer(new CoinCreatorGuiButtonMessage(0, x, y, z));
				CoinCreatorGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 207, 40, 20).build();
		guistate.put("button:button_eth", button_eth);
		this.addRenderableWidget(button_eth);
		button_usdt = Button.builder(Component.translatable("gui.chaincraft.coin_creator_gui.button_usdt"), e -> {
			if (true) {
				ChaincraftMod.PACKET_HANDLER.sendToServer(new CoinCreatorGuiButtonMessage(1, x, y, z));
				CoinCreatorGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 52, this.topPos + 207, 46, 20).build();
		guistate.put("button:button_usdt", button_usdt);
		this.addRenderableWidget(button_usdt);
		button_btc = Button.builder(Component.translatable("gui.chaincraft.coin_creator_gui.button_btc"), e -> {
			if (true) {
				ChaincraftMod.PACKET_HANDLER.sendToServer(new CoinCreatorGuiButtonMessage(2, x, y, z));
				CoinCreatorGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 106, this.topPos + 207, 40, 20).build();
		guistate.put("button:button_btc", button_btc);
		this.addRenderableWidget(button_btc);
		button_sol = Button.builder(Component.translatable("gui.chaincraft.coin_creator_gui.button_sol"), e -> {
			if (true) {
				ChaincraftMod.PACKET_HANDLER.sendToServer(new CoinCreatorGuiButtonMessage(3, x, y, z));
				CoinCreatorGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 154, this.topPos + 207, 40, 20).build();
		guistate.put("button:button_sol", button_sol);
		this.addRenderableWidget(button_sol);
		button_doge = Button.builder(Component.translatable("gui.chaincraft.coin_creator_gui.button_doge"), e -> {
			if (true) {
				ChaincraftMod.PACKET_HANDLER.sendToServer(new CoinCreatorGuiButtonMessage(4, x, y, z));
				CoinCreatorGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 202, this.topPos + 207, 46, 20).build();
		guistate.put("button:button_doge", button_doge);
		this.addRenderableWidget(button_doge);
		button_ada = Button.builder(Component.translatable("gui.chaincraft.coin_creator_gui.button_ada"), e -> {
			if (true) {
				ChaincraftMod.PACKET_HANDLER.sendToServer(new CoinCreatorGuiButtonMessage(5, x, y, z));
				CoinCreatorGuiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 255, this.topPos + 207, 40, 20).build();
		guistate.put("button:button_ada", button_ada);
		this.addRenderableWidget(button_ada);
	}
}

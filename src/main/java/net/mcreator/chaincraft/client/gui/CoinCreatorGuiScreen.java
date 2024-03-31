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

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CoinCreatorGuiScreen extends AbstractContainerScreen<CoinCreatorGuiMenu> {
	private final static HashMap<String, Object> guistate = CoinCreatorGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox coin_name;
	EditBox coin_symbole;
	EditBox coin_supply;
	EditBox supply_for_team;
	EditBox creator_wallet_adress;
	EditBox Wallet_password;
	Button button_create_coin;

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
		coin_name.render(guiGraphics, mouseX, mouseY, partialTicks);
		coin_symbole.render(guiGraphics, mouseX, mouseY, partialTicks);
		coin_supply.render(guiGraphics, mouseX, mouseY, partialTicks);
		supply_for_team.render(guiGraphics, mouseX, mouseY, partialTicks);
		creator_wallet_adress.render(guiGraphics, mouseX, mouseY, partialTicks);
		Wallet_password.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (coin_name.isFocused())
			return coin_name.keyPressed(key, b, c);
		if (coin_symbole.isFocused())
			return coin_symbole.keyPressed(key, b, c);
		if (coin_supply.isFocused())
			return coin_supply.keyPressed(key, b, c);
		if (supply_for_team.isFocused())
			return supply_for_team.keyPressed(key, b, c);
		if (creator_wallet_adress.isFocused())
			return creator_wallet_adress.keyPressed(key, b, c);
		if (Wallet_password.isFocused())
			return Wallet_password.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		coin_name.tick();
		coin_symbole.tick();
		coin_supply.tick();
		supply_for_team.tick();
		creator_wallet_adress.tick();
		Wallet_password.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.chaincraft.coin_creator_gui.label_coin_creator"), 115, 4, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		coin_name = new EditBox(this.font, this.leftPos + 88, this.topPos + 17, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.coin_name")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_name").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_name").getString());
				else
					setSuggestion(null);
			}
		};
		coin_name.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_name").getString());
		coin_name.setMaxLength(32767);
		guistate.put("text:coin_name", coin_name);
		this.addWidget(this.coin_name);
		coin_symbole = new EditBox(this.font, this.leftPos + 88, this.topPos + 38, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.coin_symbole")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_symbole").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_symbole").getString());
				else
					setSuggestion(null);
			}
		};
		coin_symbole.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_symbole").getString());
		coin_symbole.setMaxLength(32767);
		guistate.put("text:coin_symbole", coin_symbole);
		this.addWidget(this.coin_symbole);
		coin_supply = new EditBox(this.font, this.leftPos + 88, this.topPos + 59, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.coin_supply")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_supply").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_supply").getString());
				else
					setSuggestion(null);
			}
		};
		coin_supply.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.coin_supply").getString());
		coin_supply.setMaxLength(32767);
		guistate.put("text:coin_supply", coin_supply);
		this.addWidget(this.coin_supply);
		supply_for_team = new EditBox(this.font, this.leftPos + 88, this.topPos + 80, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_team")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_team").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_team").getString());
				else
					setSuggestion(null);
			}
		};
		supply_for_team.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.supply_for_team").getString());
		supply_for_team.setMaxLength(32767);
		guistate.put("text:supply_for_team", supply_for_team);
		this.addWidget(this.supply_for_team);
		creator_wallet_adress = new EditBox(this.font, this.leftPos + 88, this.topPos + 101, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.creator_wallet_adress")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.creator_wallet_adress").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.creator_wallet_adress").getString());
				else
					setSuggestion(null);
			}
		};
		creator_wallet_adress.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.creator_wallet_adress").getString());
		creator_wallet_adress.setMaxLength(32767);
		guistate.put("text:creator_wallet_adress", creator_wallet_adress);
		this.addWidget(this.creator_wallet_adress);
		Wallet_password = new EditBox(this.font, this.leftPos + 88, this.topPos + 122, 118, 18, Component.translatable("gui.chaincraft.coin_creator_gui.Wallet_password")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.Wallet_password").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.Wallet_password").getString());
				else
					setSuggestion(null);
			}
		};
		Wallet_password.setSuggestion(Component.translatable("gui.chaincraft.coin_creator_gui.Wallet_password").getString());
		Wallet_password.setMaxLength(32767);
		guistate.put("text:Wallet_password", Wallet_password);
		this.addWidget(this.Wallet_password);
		button_create_coin = Button.builder(Component.translatable("gui.chaincraft.coin_creator_gui.button_create_coin"), e -> {
		}).bounds(this.leftPos + 107, this.topPos + 143, 82, 20).build();
		guistate.put("button:button_create_coin", button_create_coin);
		this.addRenderableWidget(button_create_coin);
	}
}

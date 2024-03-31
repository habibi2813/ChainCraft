
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.chaincraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.chaincraft.world.inventory.CoinCreatorGuiMenu;
import net.mcreator.chaincraft.ChaincraftMod;

public class ChaincraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChaincraftMod.MODID);
	public static final RegistryObject<MenuType<CoinCreatorGuiMenu>> COIN_CREATOR_GUI = REGISTRY.register("coin_creator_gui", () -> IForgeMenuType.create(CoinCreatorGuiMenu::new));
}

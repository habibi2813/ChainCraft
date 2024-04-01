
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.chaincraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.chaincraft.ChaincraftMod;

public class ChaincraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChaincraftMod.MODID);
	public static final RegistryObject<CreativeModeTab> CHAIN_CRAFT = REGISTRY.register("chain_craft",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.chaincraft.chain_craft")).icon(() -> new ItemStack(ChaincraftModBlocks.COIN_CREATOR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ChaincraftModBlocks.COIN_CREATOR.get().asItem());
			}).withSearchBar().build());
}

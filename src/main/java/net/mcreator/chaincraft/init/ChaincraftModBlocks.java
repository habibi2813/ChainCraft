
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.chaincraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.chaincraft.block.CoinCreatorBlock;
import net.mcreator.chaincraft.ChaincraftMod;

public class ChaincraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ChaincraftMod.MODID);
	public static final RegistryObject<Block> COIN_CREATOR = REGISTRY.register("coin_creator", () -> new CoinCreatorBlock());
}


/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deaceased.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.deaceased.potion.WrappedMobEffect;
import net.mcreator.deaceased.potion.WarppeddelayMobEffect;
import net.mcreator.deaceased.potion.ThreatenedMobEffect;
import net.mcreator.deaceased.potion.OrderMobEffect;
import net.mcreator.deaceased.potion.GaleMobEffect;
import net.mcreator.deaceased.potion.EnemystunMobEffect;
import net.mcreator.deaceased.DeaceasedMod;

public class DeaceasedModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DeaceasedMod.MODID);
	public static final RegistryObject<MobEffect> WRAPPED = REGISTRY.register("wrapped", () -> new WrappedMobEffect());
	public static final RegistryObject<MobEffect> WARPPEDDELAY = REGISTRY.register("warppeddelay", () -> new WarppeddelayMobEffect());
	public static final RegistryObject<MobEffect> ORDER = REGISTRY.register("order", () -> new OrderMobEffect());
	public static final RegistryObject<MobEffect> ENEMYSTUN = REGISTRY.register("enemystun", () -> new EnemystunMobEffect());
	public static final RegistryObject<MobEffect> GALE = REGISTRY.register("gale", () -> new GaleMobEffect());
	public static final RegistryObject<MobEffect> THREATENED = REGISTRY.register("threatened", () -> new ThreatenedMobEffect());
}

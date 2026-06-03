
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deaceased.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.deaceased.DeaceasedMod;

public class DeaceasedModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeaceasedMod.MODID);
	public static final RegistryObject<SoundEvent> GUTEXPLODES = REGISTRY.register("gutexplodes", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "gutexplodes")));
	public static final RegistryObject<SoundEvent> FACEFLY = REGISTRY.register("facefly", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "facefly")));
	public static final RegistryObject<SoundEvent> FACEAMBT = REGISTRY.register("faceambt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "faceambt")));
	public static final RegistryObject<SoundEvent> FACEPAIN = REGISTRY.register("facepain", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "facepain")));
	public static final RegistryObject<SoundEvent> FACEDAMAGED = REGISTRY.register("facedamaged", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "facedamaged")));
	public static final RegistryObject<SoundEvent> FACEOPEN = REGISTRY.register("faceopen", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "faceopen")));
	public static final RegistryObject<SoundEvent> WRAO = REGISTRY.register("wrao", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "wrao")));
	public static final RegistryObject<SoundEvent> STONETHROW = REGISTRY.register("stonethrow", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "stonethrow")));
	public static final RegistryObject<SoundEvent> DIGGERAMBT_TOP = REGISTRY.register("diggerambt_top", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "diggerambt_top")));
	public static final RegistryObject<SoundEvent> DIGGERAMBT_DOWN = REGISTRY.register("diggerambt_down", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "diggerambt_down")));
	public static final RegistryObject<SoundEvent> DIGGERHURT = REGISTRY.register("diggerhurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "diggerhurt")));
	public static final RegistryObject<SoundEvent> DIVE = REGISTRY.register("dive", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "dive")));
	public static final RegistryObject<SoundEvent> DOVEUP = REGISTRY.register("doveup", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "doveup")));
	public static final RegistryObject<SoundEvent> DIGDIVE = REGISTRY.register("digdive", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "digdive")));
	public static final RegistryObject<SoundEvent> SPEW = REGISTRY.register("spew", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "spew")));
	public static final RegistryObject<SoundEvent> GUARDIANAMBTS = REGISTRY.register("guardianambts", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "guardianambts")));
	public static final RegistryObject<SoundEvent> STUNNERAMBT = REGISTRY.register("stunnerambt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "stunnerambt")));
	public static final RegistryObject<SoundEvent> STUNNERHURT = REGISTRY.register("stunnerhurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "stunnerhurt")));
	public static final RegistryObject<SoundEvent> STUNNERIMPACT = REGISTRY.register("stunnerimpact", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "stunnerimpact")));
	public static final RegistryObject<SoundEvent> STUNNERCHARGE = REGISTRY.register("stunnercharge", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "stunnercharge")));
	public static final RegistryObject<SoundEvent> STUNNERDEATH = REGISTRY.register("stunnerdeath", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("deaceased", "stunnerdeath")));
}

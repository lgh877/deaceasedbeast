
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deaceased.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.deaceased.DeaceasedMod;

public class DeaceasedModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DeaceasedMod.MODID);
	public static final RegistryObject<SimpleParticleType> TOUGUE = REGISTRY.register("tougue", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GUTSFACE = REGISTRY.register("gutsface", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GUTSFLAYED = REGISTRY.register("gutsflayed", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GOPART = REGISTRY.register("gopart", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> GOPART_2 = REGISTRY.register("gopart_2", () -> new SimpleParticleType(false));
}

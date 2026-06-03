
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deaceased.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.deaceased.client.particle.TougueParticle;
import net.mcreator.deaceased.client.particle.GutsflayedParticle;
import net.mcreator.deaceased.client.particle.GutsfaceParticle;
import net.mcreator.deaceased.client.particle.GopartParticle;
import net.mcreator.deaceased.client.particle.Gopart2Particle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeaceasedModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(DeaceasedModParticleTypes.TOUGUE.get(), TougueParticle::provider);
		event.registerSpriteSet(DeaceasedModParticleTypes.GUTSFACE.get(), GutsfaceParticle::provider);
		event.registerSpriteSet(DeaceasedModParticleTypes.GUTSFLAYED.get(), GutsflayedParticle::provider);
		event.registerSpriteSet(DeaceasedModParticleTypes.GOPART.get(), GopartParticle::provider);
		event.registerSpriteSet(DeaceasedModParticleTypes.GOPART_2.get(), Gopart2Particle::provider);
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deaceased.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.deaceased.client.renderer.ThefaceRenderer;
import net.mcreator.deaceased.client.renderer.ThediggerRenderer;
import net.mcreator.deaceased.client.renderer.StunnerRenderer;
import net.mcreator.deaceased.client.renderer.GuardianRenderer;
import net.mcreator.deaceased.client.renderer.FlayedmantailRenderer;
import net.mcreator.deaceased.client.renderer.FlayedmansectionsRenderer;
import net.mcreator.deaceased.client.renderer.FlayedmanheadRenderer;
import net.mcreator.deaceased.client.renderer.BuggerRenderer;
import net.mcreator.deaceased.client.renderer.BoulderRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DeaceasedModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DeaceasedModEntities.THEFACE.get(), ThefaceRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.BOULDER.get(), BoulderRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.THEDIGGER.get(), ThediggerRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.FLAYEDMANHEAD.get(), FlayedmanheadRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.FLAYEDMANSECTIONS.get(), FlayedmansectionsRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.FLAYEDMANTAIL.get(), FlayedmantailRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.GOO.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.GUARDIAN.get(), GuardianRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.BUGGER.get(), BuggerRenderer::new);
		event.registerEntityRenderer(DeaceasedModEntities.STUNNER.get(), StunnerRenderer::new);
	}
}

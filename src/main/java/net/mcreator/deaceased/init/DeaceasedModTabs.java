
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deaceased.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.deaceased.DeaceasedMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeaceasedModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeaceasedMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(DeaceasedModItems.THEFACE_SPAWN_EGG.get());
			tabData.accept(DeaceasedModItems.BOULDER_SPAWN_EGG.get());
			tabData.accept(DeaceasedModItems.THEDIGGER_SPAWN_EGG.get());
			tabData.accept(DeaceasedModItems.FLAYEDMANHEAD_SPAWN_EGG.get());
			tabData.accept(DeaceasedModItems.FLAYEDMANSECTIONS_SPAWN_EGG.get());
			tabData.accept(DeaceasedModItems.FLAYEDMANTAIL_SPAWN_EGG.get());
			tabData.accept(DeaceasedModItems.GUARDIAN_SPAWN_EGG.get());
			tabData.accept(DeaceasedModItems.STUNNER_SPAWN_EGG.get());
		}
	}
}

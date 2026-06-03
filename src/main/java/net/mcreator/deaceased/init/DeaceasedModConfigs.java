package net.mcreator.deaceased.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.deaceased.configuration.DeceasedmobsConfiguration;
import net.mcreator.deaceased.DeaceasedMod;

@Mod.EventBusSubscriber(modid = DeaceasedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeaceasedModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeceasedmobsConfiguration.SPEC, "deceasedmobs_common.toml");
		});
	}
}

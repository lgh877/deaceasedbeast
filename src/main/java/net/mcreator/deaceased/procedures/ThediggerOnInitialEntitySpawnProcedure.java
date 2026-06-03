package net.mcreator.deaceased.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.deaceased.entity.ThediggerEntity;
import net.mcreator.deaceased.configuration.DeceasedmobsConfiguration;

public class ThediggerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < (double) DeceasedmobsConfiguration.BSC.get()) {
			if (entity instanceof ThediggerEntity animatable)
				animatable.setTexture("assainminer");
			if (entity instanceof ThediggerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ThediggerEntity.DATA_assasin, true);
		}
	}
}

package net.mcreator.deaceased.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.deaceased.entity.GuardianEntity;
import net.mcreator.deaceased.configuration.DeceasedmobsConfiguration;

public class GuardianOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putUUID("id", entity.getUUID());
		if (entity instanceof GuardianEntity _datEntSetI)
			_datEntSetI.getEntityData().set(GuardianEntity.DATA_head_count,
					(int) Mth.nextDouble(RandomSource.create(), (double) DeceasedmobsConfiguration.GBN.get() - (double) DeceasedmobsConfiguration.GBR.get(), (double) DeceasedmobsConfiguration.GBN.get()));
	}
}

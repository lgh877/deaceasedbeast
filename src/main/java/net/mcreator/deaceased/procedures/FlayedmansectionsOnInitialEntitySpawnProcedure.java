package net.mcreator.deaceased.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FlayedmansectionsOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
			entity.noPhysics = true;
			entity.setNoGravity(true);
		}
	}
}

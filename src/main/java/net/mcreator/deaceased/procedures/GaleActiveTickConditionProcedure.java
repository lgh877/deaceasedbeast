package net.mcreator.deaceased.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.deaceased.entity.ThefaceEntity;
import net.mcreator.deaceased.entity.BoulderEntity;

import java.util.List;
import java.util.Comparator;

public class GaleActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator)) {
						if (!(entityiterator instanceof ThefaceEntity) && !(entityiterator instanceof BoulderEntity)) {
							entityiterator.setDeltaMovement(new Vec3((Mth.nextInt(RandomSource.create(), 1, 5)), (Mth.nextInt(RandomSource.create(), 1, 5)), (Mth.nextInt(RandomSource.create(), 1, 5))));
						}
					}
				}
			}
		}
	}
}

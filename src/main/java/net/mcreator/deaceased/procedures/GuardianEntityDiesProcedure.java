package net.mcreator.deaceased.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.deaceased.init.DeaceasedModParticleTypes;
import net.mcreator.deaceased.DeaceasedMod;

import java.util.List;
import java.util.Comparator;

public class GuardianEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 1, false, false));
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:gutexplodes")), SoundSource.NEUTRAL, 5, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:gutexplodes")), SoundSource.NEUTRAL, 5, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (DeaceasedModParticleTypes.GUTSFACE.get()), x, (y + 1), z, 40, 1, 2, 1, 1);
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof LivingEntity) {
						entityiterator.getPersistentData().putDouble("aoe_x", (entity.getX() - entityiterator.getX()));
						entityiterator.getPersistentData().putDouble("aoe_y", ((entity.getY() + entity.getBbHeight()) - (entityiterator.getY() + entityiterator.getBbHeight())));
						entityiterator.getPersistentData().putDouble("aoe_z", (entity.getZ() - entityiterator.getZ()));
						entityiterator.getPersistentData().putDouble("distance", 0);
						DeaceasedMod.queueServerWork(1, () -> {
							for (int index0 = 0; index0 < 20; index0++) {
								if (world.isEmptyBlock(BlockPos.containing(entity.getX() + entityiterator.getPersistentData().getDouble("aoe_x") * entityiterator.getPersistentData().getDouble("distance"),
										entity.getY() + entity.getBbHeight() + entityiterator.getPersistentData().getDouble("aoe_y") * entityiterator.getPersistentData().getDouble("distance"),
										entity.getZ() + entityiterator.getPersistentData().getDouble("aoe_z") * entityiterator.getPersistentData().getDouble("distance")))) {
									entityiterator.getPersistentData().putBoolean("behind_wall", false);
									entityiterator.getPersistentData().putDouble("distance", (entityiterator.getPersistentData().getDouble("distance") - 0.05));
								} else {
									entityiterator.getPersistentData().putBoolean("behind_wall", true);
								}
								DeaceasedMod.queueServerWork(1, () -> {
									if (entityiterator.getPersistentData().getBoolean("behind_wall") == false) {
										entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entityiterator.getYRot() + 180)) * 1.25 * (-1.1)), ((Math.sin(Math.toRadians(0 - entityiterator.getXRot())) + 0.5) * 1.12),
												(Math.cos(Math.toRadians(entityiterator.getYRot())) * 1.25 * (-1.3))));
									}
								});
							}
						});
					}
				}
			}
		}
	}
}

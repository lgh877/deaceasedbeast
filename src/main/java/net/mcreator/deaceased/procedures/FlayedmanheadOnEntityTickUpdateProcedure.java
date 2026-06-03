package net.mcreator.deaceased.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.deaceased.entity.FlayedmantailEntity;
import net.mcreator.deaceased.entity.FlayedmansectionsEntity;
import net.mcreator.deaceased.entity.FlayedmanheadEntity;
import net.mcreator.deaceased.DeaceasedMod;

import java.util.List;
import java.util.Comparator;

public class FlayedmanheadOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yawStart = 0;
		double size = 0;
		Entity followedEntity = null;
		double followDistance = 0.7;
		entity.noPhysics = true;;
		size = 2;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FIRE) {
			entity.setSecondsOnFire(5);
		}
		if (entity instanceof FlayedmansectionsEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof FlayedmanheadEntity) {
						if ((entity instanceof FlayedmansectionsEntity _datEntI ? _datEntI.getEntityData().get(FlayedmansectionsEntity.DATA_sectionnum) : 0) != 0) {
							if (entity.getPersistentData().hasUUID("id") && entityiterator.getPersistentData().hasUUID("id")) {
								if (entity.getPersistentData().getUUID("id").equals(entityiterator.getPersistentData().getUUID("id"))
										&& (entity instanceof FlayedmansectionsEntity _datEntI ? _datEntI.getEntityData().get(FlayedmansectionsEntity.DATA_sectionnum) : 0) == 1) {
									followedEntity = entityiterator;
								}
							}
						}
					} else {
						if (entityiterator instanceof FlayedmansectionsEntity) {
							if ((entity instanceof FlayedmansectionsEntity _datEntI ? _datEntI.getEntityData().get(FlayedmansectionsEntity.DATA_sectionnum) : 0) != 0
									&& (entityiterator instanceof FlayedmansectionsEntity _datEntI ? _datEntI.getEntityData().get(FlayedmansectionsEntity.DATA_sectionnum) : 0) != 0) {
								if (entity.getPersistentData().hasUUID("id") && entityiterator.getPersistentData().hasUUID("id")) {
									if (entity.getPersistentData().getUUID("id").equals(entityiterator.getPersistentData().getUUID("id"))
											&& (entityiterator instanceof FlayedmansectionsEntity _datEntI ? _datEntI.getEntityData().get(FlayedmansectionsEntity.DATA_sectionnum) : 0)
													+ 1 == (entity instanceof FlayedmansectionsEntity _datEntI ? _datEntI.getEntityData().get(FlayedmansectionsEntity.DATA_sectionnum) : 0)) {
										followedEntity = entityiterator;
									}
								}
							}
						}
					}
				}
			}
		} else {
			if (entity instanceof FlayedmantailEntity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof FlayedmansectionsEntity) {
							if ((entity instanceof FlayedmantailEntity _datEntI ? _datEntI.getEntityData().get(FlayedmantailEntity.DATA_endnum) : 0) != 0) {
								if (entity.getPersistentData().hasUUID("id") && entityiterator.getPersistentData().hasUUID("id")) {
									if (entity.getPersistentData().getUUID("id").equals(entityiterator.getPersistentData().getUUID("id"))
											&& (entityiterator instanceof FlayedmansectionsEntity _datEntI ? _datEntI.getEntityData().get(FlayedmansectionsEntity.DATA_sectionnum) : 0)
													+ 1 == (entity instanceof FlayedmantailEntity _datEntI ? _datEntI.getEntityData().get(FlayedmantailEntity.DATA_endnum) : 0)) {
										followedEntity = entityiterator;
									}
								}
							}
						}
					}
				}
			}
		}
		if (!(followedEntity == null)) {
			if (followedEntity.isOnFire()) {
				entity.setSecondsOnFire(2);
			}
		}
		if (!(followedEntity == null)) {
			if (followedEntity instanceof FlayedmanheadEntity && !followedEntity.isAlive() || followedEntity.isOnFire() && !followedEntity.isAlive()) {
				if (entity.isAlive()) {
					entity.setSecondsOnFire(2);
					DeaceasedMod.queueServerWork(2, () -> {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 100);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 3, 1, 1, 1, 0.01);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
				return;
			}
		}
		if (followedEntity == null || !followedEntity.isAlive()) {
			DeaceasedMod.queueServerWork(3, () -> {
				if (entity.isAlive()) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 100);
				}
			});
			return;
		}
		Vec3 look = followedEntity.getLookAngle();
		if (look.lengthSqr() < 0.0001) {
			look = new Vec3(0, 0, 1);
		}
		look = look.normalize();
		double targetX = followedEntity.getX() - look.x * followDistance;
		double targetZ = followedEntity.getZ() - look.z * followDistance;
		/* =========================
		Y POSITION RESOLUTION
		========================= */
		// Always start from leader height
		// --- Alex-style vertical probing ---
		double desiredY = followedEntity.getY();
		double verticalOffset = 0;
		// Probe DOWN (floor)
		double down = 0;
		while (down > -2.5 && !world.getBlockState(BlockPos.containing(targetX, desiredY + down, targetZ)).isSolid()) {
			down -= 0.25;
		}
		// Probe UP (ceiling)
		double up = 0;
		while (up < 2.5 && world.getBlockState(BlockPos.containing(targetX, desiredY + up, targetZ)).isSolid()) {
			up += 0.25;
		}
		// Choose small, safe vertical correction
		if (down > -2.5 && up < 2.5) {
			verticalOffset = Mth.clamp(down + 0.25, -0.4, 0.4);
		}
		double targetY = desiredY + verticalOffset;
		// Otherwise (overhang, gap, tunnel) → stay at leader Y
		/* =========================
		MOVEMENT
		========================= */
		// --- Absolute positioning (Alex-style) ---
		entity.setDeltaMovement(Vec3.ZERO);
		entity.moveTo(targetX, targetY, targetZ, entity.getYRot(), 0);
		// Hard correction if stuck or too far
		double dist = entity.distanceTo(followedEntity);
		if (dist > 1.2) {
			entity.teleportTo(targetX, targetY, targetZ);
			entity.setDeltaMovement(Vec3.ZERO);
			return;
		}
		entity.setYRot((float) (entity.getYRot() + RotetopointProcedure.execute(entity) / 2));
		entity.setXRot(0);
		entity.setYBodyRot(entity.getYRot());
		entity.setYHeadRot(entity.getYRot());
		entity.yRotO = entity.getYRot();
		entity.xRotO = 0;
		if (entity instanceof LivingEntity living) {
			living.yBodyRotO = living.getYRot();
			living.yHeadRotO = living.getYRot();
		}
		if (entity instanceof Mob mob && followedEntity instanceof LivingEntity target) {
			mob.setTarget(target);
		}
	}
}

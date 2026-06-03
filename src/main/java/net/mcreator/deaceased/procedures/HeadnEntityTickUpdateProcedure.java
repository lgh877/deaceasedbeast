package net.mcreator.deaceased.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.deaceased.init.DeaceasedModEntities;
import net.mcreator.deaceased.entity.GooEntity;
import net.mcreator.deaceased.entity.FlayedmansectionsEntity;
import net.mcreator.deaceased.entity.FlayedmanheadEntity;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class HeadnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ArrayList<Object> sections = new ArrayList<>();
		Entity target = null;
		boolean exist_target = false;
		boolean spitting = false;
		boolean lock = false;
		if (entity instanceof LivingEntity) {// Call every tick in head entity
			CompoundTag data = entity.getPersistentData();
			// Init buffer
			if (!data.contains("ringIndex")) {
				data.putInt("ringIndex", 0);
				for (int i = 0; i < 64; i++) {
					data.putFloat("ringYaw_" + i, entity.getYRot());
				}
			}
			// Update buffer only when moving
			Vec3 motion = entity.getDeltaMovement();
			if (motion.lengthSqr() > 0.0005) {
				int index = (data.getInt("ringIndex") + 1) & 63;
				data.putInt("ringIndex", index);
				data.putFloat("ringYaw_" + index, entity.getYRot());
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof FlayedmansectionsEntity) {
					if (entity.getPersistentData().hasUUID("id") && entityiterator.getPersistentData().hasUUID("id")) {
						if (entity.getPersistentData().getUUID("id").equals(entityiterator.getPersistentData().getUUID("id"))) {
							{
								sections.add(entityiterator);
							}
						}
					}
				}
			}
		}
		if (sections.size() > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, (int) (sections.size() * 0.4), false, false));
			if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.ARMOR))
				_livingEntity13.getAttribute(Attributes.ARMOR).setBaseValue((sections.size() * 0.75));
		}
		if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown) : 0) > 0) {
			if (entity instanceof FlayedmanheadEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlayedmanheadEntity.DATA_countdown, (int) ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown) : 0) - 1));
		}
		if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown2) : 0) > 0) {
			if (entity instanceof FlayedmanheadEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlayedmanheadEntity.DATA_countdown2, (int) ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown2) : 0) - 1));
		}
		if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown3) : 0) > 0) {
			if (entity instanceof FlayedmanheadEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlayedmanheadEntity.DATA_countdown3, (int) ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown3) : 0) - 1));
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
					if (lock == false) {
						target = entityiterator;
						if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown2) : 0) == 0) {
							if (entity instanceof FlayedmanheadEntity _datEntSetL)
								_datEntSetL.getEntityData().set(FlayedmanheadEntity.DATA_spitting, true);
						}
					}
					exist_target = true;
				} else {
					exist_target = false;
				}
			}
		}
		if ((entity instanceof FlayedmanheadEntity _datEntL28 && _datEntL28.getEntityData().get(FlayedmanheadEntity.DATA_spitting)) == true) {
			if ((entity instanceof FlayedmanheadEntity _datEntL29 && _datEntL29.getEntityData().get(FlayedmanheadEntity.DATA_lock)) == false) {
				if (entity instanceof FlayedmanheadEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FlayedmanheadEntity.DATA_lock, true);
				if (entity instanceof FlayedmanheadEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FlayedmanheadEntity.DATA_countdown, 70);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 50, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 50, 0, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:spew")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:spew")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof FlayedmanheadEntity) {
					((FlayedmanheadEntity) entity).setAnimation("spew");
				}
			}
		}
		if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown) : 0) == 0) {
			if ((entity instanceof FlayedmanheadEntity _datEntL37 && _datEntL37.getEntityData().get(FlayedmanheadEntity.DATA_lock)) == true) {
				if (entity instanceof FlayedmanheadEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FlayedmanheadEntity.DATA_lock, false);
				if (entity instanceof FlayedmanheadEntity _datEntSetL)
					_datEntSetL.getEntityData().set(FlayedmanheadEntity.DATA_spitting, false);
				if (entity instanceof FlayedmanheadEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FlayedmanheadEntity.DATA_countdown2, 200);
				return;
			}
		}
		if ((entity instanceof FlayedmanheadEntity _datEntL41 && _datEntL41.getEntityData().get(FlayedmanheadEntity.DATA_lock)) == true || entity instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(MobEffects.WEAKNESS)) {
			if (!(target == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((target.getX()), (target.getY()), (target.getZ())));
			}
			if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown2) : 0) == 0) {
				if (entity.isAlive()) {
					if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown) : 0) <= 50) {
						if (world instanceof ServerLevel projectileLevel && target != null) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new GooEntity(DeaceasedModEntities.GOO.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 8, 0);
							_entityToSpawn.setPos(entity.getX() + entity.getLookAngle().x, entity.getY() + entity.getLookAngle().y + 1.5, entity.getZ() + entity.getLookAngle().z);
							_entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.6f, 35);
							// 🔴 STORE TARGET UUID
							_entityToSpawn.getPersistentData().putUUID("TargetUUID", target.getUUID());
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if ((entity instanceof FlayedmanheadEntity _datEntI ? _datEntI.getEntityData().get(FlayedmanheadEntity.DATA_countdown3) : 0) == 0) {
							if (entity instanceof FlayedmanheadEntity _datEntSetI)
								_datEntSetI.getEntityData().set(FlayedmanheadEntity.DATA_countdown3, 2);
						}
					}
				}
			}
		}
	}
}

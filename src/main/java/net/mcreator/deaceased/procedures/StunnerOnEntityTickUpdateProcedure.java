package net.mcreator.deaceased.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.deaceased.init.DeaceasedModMobEffects;
import net.mcreator.deaceased.entity.StunnerEntity;
import net.mcreator.deaceased.DeaceasedMod;

import java.util.List;
import java.util.Comparator;

public class StunnerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
					if (entity instanceof StunnerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_c, 1);
				}
			}
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("mob_ai", 0);
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_a, 0);
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_b, 0);
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_c, 0);
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_activehitbox, 0);
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_tt, 0);
		}
		if (entity.getPersistentData().getDouble("mob_ai") > 0) {
			entity.getPersistentData().putDouble("mob_ai", (entity.getPersistentData().getDouble("mob_ai") - 1));
		}
		if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_honeyman_c) : 0) == 1) {
			if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_honeyman_a) : 0) == 0) {
				if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_honeyman_b) : 0) == 0) {
					if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_tt) : 0) == 0) {
						if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
							if (entity.isAlive()) {
								if (!(entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(DeaceasedModMobEffects.ENEMYSTUN.get()))) {
									if (entity instanceof StunnerEntity _datEntSetI)
										_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_a, 0);
									if (entity instanceof StunnerEntity _datEntSetI)
										_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_b, 1);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stunnercharge")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stunnercharge")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									DeaceasedMod.queueServerWork(20, () -> {
										if (entity instanceof StunnerEntity _datEntSetI)
											_datEntSetI.getEntityData().set(StunnerEntity.DATA_tt, 1);
									});
									if (entity instanceof StunnerEntity) {
										((StunnerEntity) entity).setAnimation("charge");
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_tt) : 0) == 1) {
			if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_honeyman_b) : 0) == 1) {
				if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_honeyman_a) : 0) == 0) {
					if (entity instanceof StunnerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StunnerEntity.DATA_tt, 0);
					if (entity instanceof StunnerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_a, 1);
				}
			}
		}
		if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_honeyman_a) : 0) == 1) {
			if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_honeyman_b) : 0) == 1) {
				if (entity instanceof StunnerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_a, 0);
				if (entity.isAlive()) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
						if ((((StunnerEntity) entity).animationprocedure).equals("charge")) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							entity.setDeltaMovement(
									new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.25 * 1.2), ((Math.sin(Math.toRadians(0 - entity.getXRot())) + 0.55) * 1.1), (Math.cos(Math.toRadians(entity.getYRot())) * 1.25 * 1.38)));
							entity.getPersistentData().putDouble("mob_ai", 49);
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("mob_ai") == 36) {
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_activehitbox, 1);
		}
		if (entity.getPersistentData().getDouble("mob_ai") == 1) {
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_activehitbox, 0);
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_b, 0);
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_honeyman_c, 0);
			entity.getPersistentData().putDouble("mob_ai", 0);
		}
		if ((entity instanceof StunnerEntity _datEntI ? _datEntI.getEntityData().get(StunnerEntity.DATA_activehitbox) : 0) == 1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stunnerimpact")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stunnerimpact")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof StunnerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StunnerEntity.DATA_activehitbox, 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
						if (entityiterator instanceof LivingEntity _livEnt64 && _livEnt64.isBlocking()) {
							entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entityiterator.getYRot() + 180)) * 1.25 * 1.1), ((Math.sin(Math.toRadians(0 - entityiterator.getXRot())) + 0.5) * 1),
									(Math.cos(Math.toRadians(entityiterator.getYRot())) * 1.25 * 1.3)));
							entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("deaceased:blastdmg"))), entity),
									(float) (entity instanceof LivingEntity _livingEntity69 && _livingEntity69.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity69.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(DeaceasedModMobEffects.ENEMYSTUN.get(), 140, 0, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 30, false, false));
							if (entity instanceof StunnerEntity) {
								((StunnerEntity) entity).setAnimation("stunned");
							}
						} else {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("deaceased:blastdmg"))), entity),
									(float) (entity instanceof LivingEntity _livingEntity75 && _livingEntity75.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity75.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0));
							entityiterator.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entityiterator.getYRot() + 180)) * 1.25 * (-1.1)), ((Math.sin(Math.toRadians(0 - entityiterator.getXRot())) + 0.5) * 1.12),
									(Math.cos(Math.toRadians(entityiterator.getYRot())) * 1.25 * (-1.3))));
						}
					}
				}
			}
		}
	}
}

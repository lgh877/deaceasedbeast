package net.mcreator.deaceased.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.deaceased.entity.ThediggerEntity;
import net.mcreator.deaceased.configuration.DeceasedmobsConfiguration;
import net.mcreator.deaceased.WaveEffect;

public class ThediggerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		double distToTarget = 0;
		double ex = 0;
		double ez = 0;
		double ey = 0;
		double safex = 0;
		double safey = 0;
		double safez = 0;
		if (entity.isAlive()) {
			if (!((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 1)) {
				if (Math.random() < 0.005) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:diggerambt_top")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:diggerambt_top")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
			if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_animationclock) : 0) > 0) {
				if (entity instanceof ThediggerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThediggerEntity.DATA_animationclock, (int) ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_animationclock) : 0) - 1));
			}
			if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_attackcooldown) : 0) > 0) {
				if (entity instanceof ThediggerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThediggerEntity.DATA_attackcooldown, (int) ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_attackcooldown) : 0) - 1));
			}
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
				distToTarget = entity.distanceTo(target);;
				if (target != null && ((ThediggerEntity) entity).getEntityData().get(ThediggerEntity.DATA_attackcooldown) == 0 && ((ThediggerEntity) entity).getEntityData().get(ThediggerEntity.DATA_state) == 0
						&& !((ThediggerEntity) entity).getEntityData().get(ThediggerEntity.DATA_actionlock)) {
					((ThediggerEntity) entity).getEntityData().set(ThediggerEntity.DATA_state, 1);
				}
			} else {
				if (entity instanceof ThediggerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThediggerEntity.DATA_state, 0);
			}
			if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 1) {
				if ((entity instanceof ThediggerEntity _datEntL14 && _datEntL14.getEntityData().get(ThediggerEntity.DATA_actionlock)) == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:digdive")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:digdive")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 30, false, false));
					if (entity instanceof ThediggerEntity) {
						((ThediggerEntity) entity).setAnimation("dig");
					}
					if (entity instanceof ThediggerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ThediggerEntity.DATA_animationclock, 38);
					if (entity instanceof ThediggerEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ThediggerEntity.DATA_actionlock, true);
				}
				if ((entity instanceof ThediggerEntity _datEntL20 && _datEntL20.getEntityData().get(ThediggerEntity.DATA_actionlock)) == true) {
					if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_animationclock) : 0) == 0) {
						if (!(target == null)) {
							if (Math.random() < 0.005) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:diggerambt_down")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:diggerambt_down")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
							entity.setInvisible(true);
							world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY() - 0.35, entity.getZ()), Block.getId((world.getBlockState(BlockPos.containing(x, entity.getY() - 0.35, z)))));
							if (distToTarget <= 8) {
								if (entity instanceof ThediggerEntity _datEntSetI)
									_datEntSetI.getEntityData().set(ThediggerEntity.DATA_state, 2);
								if (entity instanceof ThediggerEntity _datEntSetL)
									_datEntSetL.getEntityData().set(ThediggerEntity.DATA_actionlock, false);
							}
						}
					}
				}
			}
			if ((entity instanceof ThediggerEntity _datEntL33 && _datEntL33.getEntityData().get(ThediggerEntity.DATA_actionlock)) == false) {
				if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 2) {
					if (!(target == null)) {
						if (entity instanceof ThediggerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThediggerEntity.DATA_attackcooldown, 40);
						if (entity instanceof ThediggerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThediggerEntity.DATA_state, 3);
					}
				}
			}
			if ((entity instanceof ThediggerEntity _datEntL38 && _datEntL38.getEntityData().get(ThediggerEntity.DATA_actionlock)) == false) {
				if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 3) {
					if (!(target == null)) {
						if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_animationclock) : 0) == 0) {
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_state, 4);
						}
					}
				}
			}
			if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 4) {
				if (!(target == null)) {
					if ((entity instanceof ThediggerEntity _datEntL45 && _datEntL45.getEntityData().get(ThediggerEntity.DATA_actionlock)) == false) {
						if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_animationclock) : 0) == 0) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:dive")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:dive")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof ThediggerEntity) {
								((ThediggerEntity) entity).setAnimation("hide");
							}
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_safex, (int) entity.getX());
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_safey, (int) entity.getY());
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_safez, (int) entity.getZ());
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 30, false, false));
							ex = target.getX() + Math.random() - 0.5 * 6;
							ez = target.getZ() + Math.random() - 0.5 * 6;
							Level level = target.level();
							BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos(ex, target.getY(), ez);
							// Scan downward from player Y to find solid ground
							while (checkPos.getY() > level.getMinBuildHeight() && level.getBlockState(checkPos).isAir()) {
								checkPos.move(0, -1, 0);
							}
							// If ground found, pop just above it
							if (!level.getBlockState(checkPos).isAir()) {
								ey = checkPos.getY() + 1;
							} else {
								// Fallback: use player's Y
								ey = target.getY();
							}
							{
								Entity _ent = entity;
								_ent.teleportTo(ex, ey, ez);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(ex, ey, ez, _ent.getYRot(), _ent.getXRot());
							}
							if (entity instanceof ThediggerEntity _datEntSetL)
								_datEntSetL.getEntityData().set(ThediggerEntity.DATA_safepo, true);
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_animationclock, 10);
							if (entity instanceof ThediggerEntity _datEntSetL)
								_datEntSetL.getEntityData().set(ThediggerEntity.DATA_actionlock, true);
							if (entity instanceof ThediggerEntity) {
								((ThediggerEntity) entity).setAnimation("empty");
							}
							if (entity instanceof ThediggerEntity) {
								((ThediggerEntity) entity).setAnimation("pop");
							}
						}
					}
				}
				if ((entity instanceof ThediggerEntity _datEntL64 && _datEntL64.getEntityData().get(ThediggerEntity.DATA_actionlock)) == true) {
					if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_animationclock) : 0) == 0) {
						entity.setInvisible(false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:doveup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:doveup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						BlockPos center = new BlockPos((int) x, (int) y - 1, (int) z);
						if (world instanceof Level level) {
							if ((entity instanceof ThediggerEntity _datEntL68 && _datEntL68.getEntityData().get(ThediggerEntity.DATA_assasin)) == true) {
								WaveEffect.createShockwave(level, center, (int) (double) DeceasedmobsConfiguration.BAWA.get(), (int) (double) DeceasedmobsConfiguration.BDAD.get(), (LivingEntity) entity, (LivingEntity) target);
							} else {
								WaveEffect.createShockwave(level, center, (int) (double) DeceasedmobsConfiguration.AWA.get(), (int) (double) DeceasedmobsConfiguration.DAD.get(), (LivingEntity) entity, (LivingEntity) target);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 8, 9, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 90, 6, false, false));
						if (entity instanceof ThediggerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThediggerEntity.DATA_state, 5);
						if ((entity instanceof ThediggerEntity _datEntL72 && _datEntL72.getEntityData().get(ThediggerEntity.DATA_assasin)) == true) {
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_attackcooldown, 60);
						} else {
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_attackcooldown, 90);
						}
						if (entity instanceof ThediggerEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ThediggerEntity.DATA_actionlock, false);
					}
				}
			}
			if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 5) {
				if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_attackcooldown) : 0) == 0) {
					if ((entity instanceof ThediggerEntity _datEntL78 && _datEntL78.getEntityData().get(ThediggerEntity.DATA_actionlock)) == false) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 30, false, false));
						if (entity instanceof ThediggerEntity) {
							((ThediggerEntity) entity).setAnimation("dig");
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:digdive")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:digdive")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof ThediggerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThediggerEntity.DATA_animationclock, 38);
						if (entity instanceof ThediggerEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ThediggerEntity.DATA_actionlock, true);
					}
					if ((entity instanceof ThediggerEntity _datEntL84 && _datEntL84.getEntityData().get(ThediggerEntity.DATA_actionlock)) == true) {
						if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_animationclock) : 0) == 0) {
							if (entity instanceof ThediggerEntity) {
								((ThediggerEntity) entity).setAnimation("empty");
							}
							if ((entity instanceof ThediggerEntity _datEntL87 && _datEntL87.getEntityData().get(ThediggerEntity.DATA_safepo)) == true) {
								if (!world.isClientSide()) {
									{
										Entity _ent = entity;
										_ent.teleportTo((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_safex) : 0),
												(entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_safey) : 0),
												(entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_safez) : 0));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_safex) : 0),
													(entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_safey) : 0),
													(entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_safez) : 0), _ent.getYRot(), _ent.getXRot());
									}
									if (entity instanceof ThediggerEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ThediggerEntity.DATA_safex, 0);
									if (entity instanceof ThediggerEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ThediggerEntity.DATA_safey, 0);
									if (entity instanceof ThediggerEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ThediggerEntity.DATA_safez, 0);
								}
								if (entity instanceof ThediggerEntity _datEntSetL)
									_datEntSetL.getEntityData().set(ThediggerEntity.DATA_safepo, false);
							}
							if (entity instanceof ThediggerEntity) {
								((ThediggerEntity) entity).setAnimation("hide");
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 30, false, false));
							if (entity instanceof ThediggerEntity _datEntSetL)
								_datEntSetL.getEntityData().set(ThediggerEntity.DATA_actionlock, false);
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_attackcooldown, 12);
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_state, 6);
						}
					}
				}
			}
			if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_state) : 0) == 6) {
				if ((entity instanceof ThediggerEntity _datEntL103 && _datEntL103.getEntityData().get(ThediggerEntity.DATA_actionlock)) == false) {
					if ((entity instanceof ThediggerEntity _datEntI ? _datEntI.getEntityData().get(ThediggerEntity.DATA_attackcooldown) : 0) == 0) {
						entity.level().broadcastEntityEvent(entity, (byte) 60);
						if (entity instanceof ThediggerEntity) {
							((ThediggerEntity) entity).setAnimation("pop");
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 125, 30, false, false));
						if ((entity instanceof ThediggerEntity _datEntL107 && _datEntL107.getEntityData().get(ThediggerEntity.DATA_assasin)) == true) {
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_attackcooldown, 100);
						} else {
							if (entity instanceof ThediggerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ThediggerEntity.DATA_attackcooldown, 120);
						}
						if (entity instanceof ThediggerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThediggerEntity.DATA_state, 0);
					}
				}
			}
			if (!(entity instanceof Mob mob) || !(mob.getTarget() instanceof LivingEntity)) {
				if (entity instanceof ThediggerEntity digger) {
					digger.getEntityData().set(ThediggerEntity.DATA_state, 0);
					digger.getEntityData().set(ThediggerEntity.DATA_actionlock, false);
					digger.getEntityData().set(ThediggerEntity.DATA_animationclock, 0);
					digger.getEntityData().set(ThediggerEntity.DATA_attackcooldown, 5);
				}
			}
		}
		if ((entity instanceof ThediggerEntity _datEntL111 && _datEntL111.getEntityData().get(ThediggerEntity.DATA_assasin)) == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1, false, false));
		}
	}
}

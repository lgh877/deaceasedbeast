package net.mcreator.deaceased.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.deaceased.init.DeaceasedModParticleTypes;
import net.mcreator.deaceased.init.DeaceasedModMobEffects;
import net.mcreator.deaceased.init.DeaceasedModEntities;
import net.mcreator.deaceased.entity.ThefaceEntity;
import net.mcreator.deaceased.entity.ThediggerEntity;
import net.mcreator.deaceased.configuration.DeceasedmobsConfiguration;
import net.mcreator.deaceased.ServerLevelRelatedUtils;
import net.mcreator.deaceased.DeaceasedMod;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class FacetickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ArrayList<Object> mobs = new ArrayList<>();
		ArrayList<Object> nonobmobs = new ArrayList<>();
		Entity targetmob = null;
		Entity chosenmobs = null;
		Entity target = null;
		double dsx = 0;
		double px = 0;
		double dist = 0;
		double py = 0;
		double dsz = 0;
		double pz = 0;
		double dsy = 0;
		double horizontalpower = 0;
		double endz = 0;
		double endy = 0;
		double endx = 0;
		double dx = 0;
		double T = 0;
		double dy = 0;
		double startz = 0;
		double dz = 0;
		double verticlepower = 0;
		double starty = 0;
		double sdist = 0;
		double startx = 0;
		double steps = 0;
		double speedmultiplier = 0;
		double targetx = 0;
		double targety = 0;
		double targetz = 0;
		double disttotarget = 0;
		double targetinstancedist = 0;
		speedmultiplier = (-1) * 0.7 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
		if (speedmultiplier < -180) {
			speedmultiplier = -180;
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100) * 40 >= (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(DeaceasedModMobEffects.THREATENED.get(), 15, 0));
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator)) {
						if (entityiterator instanceof LivingEntity) {
							entityiterator.getPersistentData().putBoolean("behind_wallT", false);
						}
					}
					if (entityiterator.getPersistentData().getBoolean("behind_wallT") == false) {
						if (!(entityiterator == entity)) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
								if (entityiterator.isAlive()) {
									targetmob = entityiterator;
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(28 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
								}
							});
							if (!(entity instanceof LivingEntity _livEnt62 && _livEnt62.hasEffect(DeaceasedModMobEffects.THREATENED.get()))) {
								if (entityiterator.getPersistentData().getBoolean("behind_wall") == false) {
									if (!(entityiterator == entity) && !(entityiterator instanceof ThefaceEntity) && !(entityiterator instanceof ThediggerEntity)
											&& !(entityiterator instanceof LivingEntity _livEnt67 && _livEnt67.hasEffect(DeaceasedModMobEffects.WARPPEDDELAY.get())) && !entity.isNoGravity()) {
										if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
											{
												mobs.add(entityiterator);
											}
										} else {
											if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("deceasedcraft:tag")))
													|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("deceasedcraft:external_entity")))) {
												{
													nonobmobs.add(entityiterator);
												}
											}
										}
									} else {
										if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_stonecount) : 0) <= 0) {
											if (entity instanceof ThefaceEntity _datEntSetI)
												_datEntSetI.getEntityData().set(ThefaceEntity.DATA_stonecount, 500);
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = DeaceasedModEntities.BOULDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
													entityToSpawn.setDeltaMovement(0, 0, 0);
												}
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = DeaceasedModEntities.BOULDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
													entityToSpawn.setDeltaMovement(0, 0, 0);
												}
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = DeaceasedModEntities.BOULDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
													entityToSpawn.setDeltaMovement(0, 0, 0);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_stonecount) : 0) <= 0) {
				if (mobs.size() == 0) {
					if (entity instanceof ThefaceEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ThefaceEntity.DATA_stonecount, 75);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = DeaceasedModEntities.BOULDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
			}
			if (!(entity instanceof LivingEntity _livEnt86 && _livEnt86.hasEffect(DeaceasedModMobEffects.THREATENED.get()))) {
				if (mobs.size() > 0) {
					if (chosenmobs == null) {
						chosenmobs = mobs.get((int) Mth.nextDouble(RandomSource.create(), 0, mobs.size() - 1)) instanceof Entity _entity91 ? _entity91 : null;
					}
				}
			}
			if (mobs.size() == 0 && nonobmobs.size() > 0) {
				if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_forcecount) : 0) <= 0) {
					if (entity instanceof ThefaceEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ThefaceEntity.DATA_forcecount, 100);
					if ((nonobmobs.get((int) Mth.nextDouble(RandomSource.create(), 0, nonobmobs.size() - 1)) instanceof Entity _entity98 ? _entity98 : null) instanceof Mob _entity
							&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
			if ((entity instanceof ThefaceEntity _datEntL101 && _datEntL101.getEntityData().get(ThefaceEntity.DATA_shot)) == false) {
				if (entity instanceof LivingEntity _livEnt102 && _livEnt102.hasEffect(DeaceasedModMobEffects.THREATENED.get())) {
					chosenmobs = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
				}
				if (!(chosenmobs == null) && chosenmobs.isAlive()) {
					if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown2) : 0) == 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:wrao")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:wrao")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof ThefaceEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown, (int) (200 - speedmultiplier));
						if (entity instanceof ThefaceEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown2, -1);
						if (entity instanceof ThefaceEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ThefaceEntity.DATA_shot, true);
					}
				}
			}
			if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_stonecount) : 0) > 0) {
				if (entity instanceof ThefaceEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThefaceEntity.DATA_stonecount, (int) ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_stonecount) : 0) - 1));
			}
			if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_forcecount) : 0) > 0) {
				if (entity instanceof ThefaceEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThefaceEntity.DATA_forcecount, (int) ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_forcecount) : 0) - 1));
			}
			if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown) : 0) > 0) {
				if (entity instanceof ThefaceEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown, (int) ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown) : 0) - 1));
			}
			if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown) : 0) == 0) {
				if (entity instanceof ThefaceEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ThefaceEntity.DATA_shot, false);
			}
			if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown2) : 0) > 0) {
				if (entity instanceof ThefaceEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown2, (int) ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown2) : 0) - 1));
			}
			if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown3) : 0) > 0) {
				if (entity instanceof ThefaceEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown3, (int) ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown2) : 0) - 1));
			}
			if (!(targetmob == null)) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(targetmob == entityiterator)) {
							if (entity instanceof ThefaceEntity _datEntSetL)
								_datEntSetL.getEntityData().set(ThefaceEntity.DATA_lockc2, true);
						} else {
							if (entity instanceof ThefaceEntity _datEntSetL)
								_datEntSetL.getEntityData().set(ThefaceEntity.DATA_lockc2, false);
						}
					}
				}
				if ((entity instanceof ThefaceEntity _datEntL133 && _datEntL133.getEntityData().get(ThefaceEntity.DATA_lockc2)) == true || entity instanceof LivingEntity _livEnt134 && _livEnt134.hasEffect(DeaceasedModMobEffects.THREATENED.get())) {
					if (entity instanceof LivingEntity _livEnt135 && _livEnt135.hasEffect(DeaceasedModMobEffects.THREATENED.get())) {
						chosenmobs = targetmob;
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (targetmob == entityiterator) {
								if (mobs.size() > 0) {
									if (entity instanceof ThefaceEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ThefaceEntity.DATA_doable, 1);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 0, false, false));
								}
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 0, false, false));
							}
						}
					}
				} else {
					if (entity instanceof ThefaceEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ThefaceEntity.DATA_doable, 0);
				}
				if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_doable) : 0) == 1 || entity instanceof LivingEntity _livEnt144 && _livEnt144.hasEffect(DeaceasedModMobEffects.THREATENED.get())) {
					if ((entity instanceof ThefaceEntity _datEntL145 && _datEntL145.getEntityData().get(ThefaceEntity.DATA_open)) == false) {
						if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
							if (entity.isAlive()) {
								if ((chosenmobs instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity || chosenmobs instanceof Player) {
									if (entity instanceof ThefaceEntity) {
										((ThefaceEntity) entity).setAnimation("open");
									}
									if (entity instanceof ThefaceEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown2, 120);
									if (entity instanceof ThefaceEntity _datEntSetI)
										_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown3, 30);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 0, false, false));
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 30, false, false));
									if (entity instanceof ThefaceEntity _datEntSetL)
										_datEntSetL.getEntityData().set(ThefaceEntity.DATA_open, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:faceopen")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:faceopen")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (chosenmobs instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 30, 3, false, false));
									if (chosenmobs instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 30, false, false));
									if (chosenmobs instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(DeaceasedModMobEffects.WARPPEDDELAY.get(), 30, 0, false, false));
									chosenmobs.getPersistentData().putUUID("wrapped_by", entity.getUUID());
								}
							}
						}
					}
				}
				if ((entity instanceof ThefaceEntity _datEntI ? _datEntI.getEntityData().get(ThefaceEntity.DATA_countdown3) : 0) == 0) {
					if (entity instanceof ThefaceEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown3, -1);
					if (entity instanceof ThefaceEntity _datEntSetL)
						_datEntSetL.getEntityData().set(ThefaceEntity.DATA_shot, false);
					DeaceasedMod.queueServerWork((int) (5 + (double) DeceasedmobsConfiguration.FCD.get()), () -> {
						if (entity instanceof ThefaceEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ThefaceEntity.DATA_open, false);
						if (entity instanceof ThefaceEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown3, -1);
						if (entity instanceof ThefaceEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ThefaceEntity.DATA_countdown2, -1);
					});
				}
				if (entity.isAlive()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity _livEnt173 && _livEnt173.hasEffect(DeaceasedModMobEffects.WRAPPED.get())) {
								if (!(entityiterator instanceof LivingEntity _livEnt174 && _livEnt174.hasEffect(DeaceasedModMobEffects.WARPPEDDELAY.get()))) {
									if (entityiterator.getPersistentData().hasUUID("wrapped_by")) {
										if (entityiterator.getPersistentData().getUUID("wrapped_by").equals(entity.getUUID())) {
											DeaceasedMod.queueServerWork(5, () -> {
												entityiterator.getPersistentData().remove("wrapped_by");
											});
											if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100) * 40 >= (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stonethrow")), SoundSource.NEUTRAL, 2, 5);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stonethrow")), SoundSource.NEUTRAL, 2, 5, false);
													}
												}
											} else {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stonethrow")), SoundSource.NEUTRAL, 2, 1);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:stonethrow")), SoundSource.NEUTRAL, 2, 1, false);
													}
												}
											}
											if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100) * 40 >= (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(DeaceasedModMobEffects.GALE.get(), 80, 0, false, false));
											}
											if (entityiterator instanceof LivingEntity _entity)
												_entity.removeEffect(DeaceasedModMobEffects.WRAPPED.get());
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(DeaceasedModMobEffects.WARPPEDDELAY.get(), 120, 0, false, false));
											if (targetmob == entityiterator) {
												double vx = entityiterator.getX() - entity.getX();
												double vy = (entityiterator.getY() + entityiterator.getBbHeight() / 2) - (entity.getY() + entity.getBbHeight() / 2);
												double vz = entityiterator.getZ() - entity.getZ();
												// Normalize
												double vdist = Math.sqrt(vx * vx + vy * vy + vz * vz);
												if (vdist == 0)
													vdist = 0.01;
												vx /= vdist;
												vy /= vdist;
												vz /= vdist;
												// Rage strength
												boolean rage = ((entity instanceof LivingEntity liv ? liv.getMaxHealth() : 0) * 0.4) >= (entity instanceof LivingEntity liv ? liv.getHealth() : 0);
												// Base power
												double throwStrength = rage ? 2.8 : 1.9;
												double verticalBoost = rage ? 1.1 : 0.6;
												// Final velocity
												Vec3 throwVec = new Vec3(vx * throwStrength, vy * 0.3 + verticalBoost, vz * throwStrength);
												entityiterator.setDeltaMovement(throwVec);
												entityiterator.hurtMarked = true;
											} else {
												targetx = targetmob.getX();
												targety = targetmob.getY();
												targetz = targetmob.getZ();
												dx = entityiterator.getX() - targetx;
												dy = entity.getY() - targety;
												dz = entityiterator.getZ() - targetz;
												dist = Math.sqrt(dz * dz + dy * dy + dx * dx);
												dx = dx / dist;
												dy = dy / dist;
												dz = dz / dist;
												dx = dx * (-1);
												dz = dz * (-1);
												horizontalpower = Math.min(3, 0.4 + dist * 0.05);
												verticlepower = 0.25 + (targety - entityiterator.getY()) * 0.07;
												verticlepower = Math.max(-0.3, Math.min(verticlepower, 3));
												entityiterator.setDeltaMovement(new Vec3((dx * horizontalpower * 2), verticlepower, (dz * horizontalpower * 2)));
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(targetmob == null)) {
					if (entityiterator.getPersistentData().hasUUID("wrapped_by")) {
						if (entityiterator.getPersistentData().getUUID("wrapped_by").equals(entity.getUUID())) {
							if (targetmob == entityiterator) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("deaceased:choke"))), entity), 1);
							}
							startx = entity.getX() + 0;
							starty = entity.getY() + 2;
							startz = entity.getZ() + 0;
							endx = entityiterator.getX() + 0;
							endy = entityiterator.getY() + entityiterator.getBbHeight() / 2;
							endz = entityiterator.getZ() + 0;
							dsx = endx - startx;
							dsy = endy - starty;
							dsz = endz - startz;
							sdist = Math.sqrt(dsx * dsx + dsy * dsy + dsz * dsz);
							steps = sdist / 0.2;
							double progress = entity.getPersistentData().getDouble("tongueProgress");
							if (progress < 1)
								progress += 0.1; // extend speed (adjustable)
							if (progress > 1)
								progress = 1;
							entity.getPersistentData().putDouble("tongueProgress", progress);
							for (int index1 = 0; index1 < (int) (steps * progress); index1++) {
								T = (double) index1 / (double) steps;
								px = startx + T * dsx;
								py = starty + dsy * T;
								pz = startz + dsz * T;
								double spread = 0.8 * (1 - T); // max 0.3 at start, 0 at the end
								double offsetX = (Math.random() - 0.5) * 2 * spread;
								double offsetY = (Math.random() - 0.5) * 2 * spread;
								double offsetZ = (Math.random() - 0.5) * 2 * spread;
								if (world instanceof ServerLevel _level)
									ServerLevelRelatedUtils.sendParticles(_level, DeaceasedModParticleTypes.TOUGUE.get(), px, py, pz, 1, 0, 0, 0, 0);
							}
						}
					}
				}
			}
		}
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 100) * 40 >= (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			if (entity instanceof ThefaceEntity animatable)
				animatable.setTexture("theface_damaged");
		}
	}
}

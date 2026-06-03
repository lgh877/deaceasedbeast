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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.deaceased.init.DeaceasedModParticleTypes;
import net.mcreator.deaceased.init.DeaceasedModMobEffects;
import net.mcreator.deaceased.init.DeaceasedModEntities;
import net.mcreator.deaceased.entity.GuardianEntity;
import net.mcreator.deaceased.entity.BuggerEntity;
import net.mcreator.deaceased.ServerLevelRelatedUtils;
import net.mcreator.deaceased.DeaceasedMod;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class GuardianOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ArrayList<Object> intancehead = new ArrayList<>();
		ArrayList<Object> onhead = new ArrayList<>();
		double endz = 0;
		double endy = 0;
		double endx = 0;
		double startz = 0;
		double dsx = 0;
		double starty = 0;
		double sdist = 0;
		double dsz = 0;
		double startx = 0;
		double dsy = 0;
		double px = 0;
		double py = 0;
		double pz = 0;
		double T = 0;
		double steps = 0;
		double ex = 0;
		double ey = 0;
		double ez = 0;
		double dist_pull = 0;
		double exg = 0;
		double eyg = 0;
		double ezg = 0;
		double distpullsafe = 0;
		double targetdist = 0;
		Entity targetmob = null;
		Entity instancehead_entity = null;
		Entity target = null;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
			targetdist = entity.distanceTo(target);;
			if (targetdist <= 20 && (entity instanceof GuardianEntity _datEntL3 && _datEntL3.getEntityData().get(GuardianEntity.DATA_open)) == false
					&& (entity instanceof GuardianEntity _datEntL4 && _datEntL4.getEntityData().get(GuardianEntity.DATA_lock)) == false) {
				for (int index0 = 0; index0 < (int) (entity instanceof GuardianEntity _datEntI ? _datEntI.getEntityData().get(GuardianEntity.DATA_head_count) : 0); index0++) {
					if (index0 > 0) {
						DeaceasedMod.queueServerWork((int) (Math.random() * 12), () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.exit")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.exit")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel _serverLevel) {
								Entity entityinstance = DeaceasedModEntities.BUGGER.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
								if (entityinstance != null) {
									entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(DeaceasedModMobEffects.ORDER.get(), 60, 0, false, false));
									entityinstance.getPersistentData().putUUID("id", entity.getUUID());
									if (entityinstance instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
									_serverLevel.addFreshEntity(entityinstance);
								}
							}
						});
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.exit")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.exit")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _serverLevel) {
							Entity entityinstance = DeaceasedModEntities.BUGGER.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
							if (entityinstance != null) {
								entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(DeaceasedModMobEffects.ORDER.get(), 10, 0, false, false));
								entityinstance.getPersistentData().putUUID("id", entity.getUUID());
								if (entityinstance instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
								_serverLevel.addFreshEntity(entityinstance);
							}
						}
					}
				}
				if (entity instanceof GuardianEntity _datEntSetI)
					_datEntSetI.getEntityData().set(GuardianEntity.DATA_countdown, 250);
				if (entity instanceof GuardianEntity _datEntSetL)
					_datEntSetL.getEntityData().set(GuardianEntity.DATA_open, true);
			}
		}
		if ((entity instanceof GuardianEntity _datEntI ? _datEntI.getEntityData().get(GuardianEntity.DATA_countdown) : 0) > 0) {
			if (entity instanceof GuardianEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GuardianEntity.DATA_countdown, (int) ((entity instanceof GuardianEntity _datEntI ? _datEntI.getEntityData().get(GuardianEntity.DATA_countdown) : 0) - 1));
		}
		if ((entity instanceof GuardianEntity _datEntL30 && _datEntL30.getEntityData().get(GuardianEntity.DATA_open)) == true) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getPersistentData().hasUUID("id")) {
						if (entityiterator.getPersistentData().getUUID("id").equals(entity.getUUID())) {
							if (!(entityiterator == entity)) {
								{
									intancehead.add(entityiterator);
								}
								instancehead_entity = entityiterator;
								{
									for (Object arraylistiterator : intancehead) {
										if (!entity.isAlive()) {
											if ((arraylistiterator instanceof Entity _entity39 ? _entity39 : null) instanceof BuggerEntity _datEntSetL)
												_datEntSetL.getEntityData().set(BuggerEntity.DATA_rage, true);
										}
									}
								}
								if (entity instanceof GuardianEntity _datEntSetI)
									_datEntSetI.getEntityData().set(GuardianEntity.DATA_head_count, (int) intancehead.size());
								startx = entity.getX() + 0;
								starty = entity.getY() + 1;
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
									double spread = 0.3 * (1 - T); // max 0.3 at start, 0 at the end
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
			if (intancehead.size() > 0) {
				{
					for (Object arraylistiterator : intancehead) {
						exg = entity.getX() - (arraylistiterator instanceof Entity _entity55 ? _entity55 : null).getX();
						eyg = entity.getY() - (arraylistiterator instanceof Entity _entity59 ? _entity59 : null).getY();
						ezg = entity.getZ() - (arraylistiterator instanceof Entity _entity63 ? _entity63 : null).getZ();
						distpullsafe = Math.sqrt(Math.pow(ex, 2) + Math.pow(ey, 2) + Math.pow(ez, 2));
						if (distpullsafe > 16) {
							(arraylistiterator instanceof Entity _entity66 ? _entity66 : null).setDeltaMovement(new Vec3((exg / distpullsafe), (eyg / distpullsafe), (ezg / distpullsafe)));
						}
					}
				}
			}
			if (intancehead.size() == 0) {
				if ((entity instanceof GuardianEntity _datEntL70 && _datEntL70.getEntityData().get(GuardianEntity.DATA_lock)) == false) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL),
							((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 128, 128, 128), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null))), 1000);
				}
			}
		}
		if ((entity instanceof GuardianEntity _datEntL74 && _datEntL74.getEntityData().get(GuardianEntity.DATA_open)) == true) {
			if ((entity instanceof GuardianEntity _datEntL75 && _datEntL75.getEntityData().get(GuardianEntity.DATA_lock)) == false) {
				if ((entity instanceof GuardianEntity _datEntI ? _datEntI.getEntityData().get(GuardianEntity.DATA_countdown) : 0) == 0) {
					if (entity instanceof GuardianEntity) {
						((GuardianEntity) entity).setAnimation("retract");
					}
					if (entity instanceof GuardianEntity _datEntSetL)
						_datEntSetL.getEntityData().set(GuardianEntity.DATA_lock, true);
					if (entity instanceof GuardianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GuardianEntity.DATA_countdown, 50);
					if (entity instanceof GuardianEntity _datEntSetL)
						_datEntSetL.getEntityData().set(GuardianEntity.DATA_open, false);
				}
				if ((entity instanceof GuardianEntity _datEntI ? _datEntI.getEntityData().get(GuardianEntity.DATA_countdown) : 0) < 20) {
					{
						for (Object arraylistiterator : intancehead) {
							ex = entity.getX() - (arraylistiterator instanceof Entity _entity84 ? _entity84 : null).getX();
							ey = entity.getY() - (arraylistiterator instanceof Entity _entity88 ? _entity88 : null).getY();
							ez = entity.getZ() - (arraylistiterator instanceof Entity _entity92 ? _entity92 : null).getZ();
							dist_pull = Math.sqrt(Math.pow(ex, 2) + Math.pow(ey, 2) + Math.pow(ez, 2));
							(arraylistiterator instanceof Entity _entity95 ? _entity95 : null).setDeltaMovement(new Vec3((ex / dist_pull), (ey / dist_pull), (ez / dist_pull)));
						}
					}
				}
			}
		}
		if ((entity instanceof GuardianEntity _datEntL98 && _datEntL98.getEntityData().get(GuardianEntity.DATA_lock)) == true) {
			if (entity instanceof GuardianEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GuardianEntity.DATA_head_count, (int) intancehead.size());
			{
				for (Object arraylistiterator : intancehead) {
					if (!(arraylistiterator instanceof Entity _entity102 ? _entity102 : null).level().isClientSide())
						(arraylistiterator instanceof Entity _entity102 ? _entity102 : null).discard();
				}
			}
			if (entity instanceof GuardianEntity _datEntSetL)
				_datEntSetL.getEntityData().set(GuardianEntity.DATA_lock, false);
		}
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.setDeltaMovement(new Vec3(0, 5, 0));
		}
	}
}

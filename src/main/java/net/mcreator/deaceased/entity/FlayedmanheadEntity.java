
package net.mcreator.deaceased.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.deaceased.procedures.HeadnEntityTickUpdateProcedure;
import net.mcreator.deaceased.procedures.FlayedmanheadOnInitialEntitySpawnProcedure;
import net.mcreator.deaceased.init.DeaceasedModEntities;

import javax.annotation.Nullable;

public class FlayedmanheadEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_sections = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_ringindex = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_ringyaw = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Yrot = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_countdown = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_countdown2 = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_spitting = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_lock = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_countdown3 = SynchedEntityData.defineId(FlayedmanheadEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public FlayedmanheadEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(DeaceasedModEntities.FLAYEDMANHEAD.get(), world);
	}

	public FlayedmanheadEntity(EntityType<FlayedmanheadEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setMaxUpStep(1.2f);
		noCulling = true;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "centipedehead_main");
		this.entityData.define(DATA_sections, 10);
		this.entityData.define(DATA_ringindex, 0);
		this.entityData.define(DATA_ringyaw, 0);
		this.entityData.define(DATA_Yrot, 0);
		this.entityData.define(DATA_countdown, 0);
		this.entityData.define(DATA_countdown2, 0);
		this.entityData.define(DATA_spitting, false);
		this.entityData.define(DATA_lock, false);
		this.entityData.define(DATA_countdown3, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, (float) 0.5));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("deaceased:facedamaged"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.death"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		FlayedmanheadOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("Datasections", this.entityData.get(DATA_sections));
		compound.putInt("Dataringindex", this.entityData.get(DATA_ringindex));
		compound.putInt("Dataringyaw", this.entityData.get(DATA_ringyaw));
		compound.putInt("DataYrot", this.entityData.get(DATA_Yrot));
		compound.putInt("Datacountdown", this.entityData.get(DATA_countdown));
		compound.putInt("Datacountdown2", this.entityData.get(DATA_countdown2));
		compound.putBoolean("Dataspitting", this.entityData.get(DATA_spitting));
		compound.putBoolean("Datalock", this.entityData.get(DATA_lock));
		compound.putInt("Datacountdown3", this.entityData.get(DATA_countdown3));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Datasections"))
			this.entityData.set(DATA_sections, compound.getInt("Datasections"));
		if (compound.contains("Dataringindex"))
			this.entityData.set(DATA_ringindex, compound.getInt("Dataringindex"));
		if (compound.contains("Dataringyaw"))
			this.entityData.set(DATA_ringyaw, compound.getInt("Dataringyaw"));
		if (compound.contains("DataYrot"))
			this.entityData.set(DATA_Yrot, compound.getInt("DataYrot"));
		if (compound.contains("Datacountdown"))
			this.entityData.set(DATA_countdown, compound.getInt("Datacountdown"));
		if (compound.contains("Datacountdown2"))
			this.entityData.set(DATA_countdown2, compound.getInt("Datacountdown2"));
		if (compound.contains("Dataspitting"))
			this.entityData.set(DATA_spitting, compound.getBoolean("Dataspitting"));
		if (compound.contains("Datalock"))
			this.entityData.set(DATA_lock, compound.getBoolean("Datalock"));
		if (compound.contains("Datacountdown3"))
			this.entityData.set(DATA_countdown3, compound.getInt("Datacountdown3"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		HeadnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	private PlayState attackingPredicate(AnimationState event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level().getGameTime();
		}
		if (this.swinging && this.lastSwing + 4L <= level().getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().forceAnimationReset();
			return event.setAndContinue(RawAnimation.begin().thenPlay("bite"));
		}
		return PlayState.CONTINUE;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(FlayedmanheadEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}

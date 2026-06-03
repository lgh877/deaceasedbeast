
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deaceased.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.deaceased.entity.ThefaceEntity;
import net.mcreator.deaceased.entity.ThediggerEntity;
import net.mcreator.deaceased.entity.StunnerEntity;
import net.mcreator.deaceased.entity.GuardianEntity;
import net.mcreator.deaceased.entity.GooEntity;
import net.mcreator.deaceased.entity.FlayedmantailEntity;
import net.mcreator.deaceased.entity.FlayedmansectionsEntity;
import net.mcreator.deaceased.entity.FlayedmanheadEntity;
import net.mcreator.deaceased.entity.BuggerEntity;
import net.mcreator.deaceased.entity.BoulderEntity;
import net.mcreator.deaceased.DeaceasedMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeaceasedModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeaceasedMod.MODID);
	public static final RegistryObject<EntityType<ThefaceEntity>> THEFACE = register("theface",
			EntityType.Builder.<ThefaceEntity>of(ThefaceEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(ThefaceEntity::new)

					.sized(1.5f, 3f));
	public static final RegistryObject<EntityType<BoulderEntity>> BOULDER = register("boulder",
			EntityType.Builder.<BoulderEntity>of(BoulderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BoulderEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<ThediggerEntity>> THEDIGGER = register("thedigger",
			EntityType.Builder.<ThediggerEntity>of(ThediggerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(ThediggerEntity::new)

					.sized(0.6f, 1.2f));
	public static final RegistryObject<EntityType<FlayedmanheadEntity>> FLAYEDMANHEAD = register("flayedmanhead",
			EntityType.Builder.<FlayedmanheadEntity>of(FlayedmanheadEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(120).setUpdateInterval(3).setCustomClientFactory(FlayedmanheadEntity::new)

					.sized(0.9f, 1.5f));
	public static final RegistryObject<EntityType<FlayedmansectionsEntity>> FLAYEDMANSECTIONS = register("flayedmansections",
			EntityType.Builder.<FlayedmansectionsEntity>of(FlayedmansectionsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlayedmansectionsEntity::new)

					.sized(0.7f, 1f));
	public static final RegistryObject<EntityType<FlayedmantailEntity>> FLAYEDMANTAIL = register("flayedmantail",
			EntityType.Builder.<FlayedmantailEntity>of(FlayedmantailEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlayedmantailEntity::new)

					.sized(0.7f, 1f));
	public static final RegistryObject<EntityType<GooEntity>> GOO = register("goo",
			EntityType.Builder.<GooEntity>of(GooEntity::new, MobCategory.MISC).setCustomClientFactory(GooEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<GuardianEntity>> GUARDIAN = register("guardian",
			EntityType.Builder.<GuardianEntity>of(GuardianEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(GuardianEntity::new)

					.sized(1.2f, 0.7f));
	public static final RegistryObject<EntityType<BuggerEntity>> BUGGER = register("bugger",
			EntityType.Builder.<BuggerEntity>of(BuggerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BuggerEntity::new)

					.sized(0.8f, 0.8f));
	public static final RegistryObject<EntityType<StunnerEntity>> STUNNER = register("stunner",
			EntityType.Builder.<StunnerEntity>of(StunnerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StunnerEntity::new)

					.sized(1.2f, 0.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ThefaceEntity.init();
			BoulderEntity.init();
			ThediggerEntity.init();
			FlayedmanheadEntity.init();
			FlayedmansectionsEntity.init();
			FlayedmantailEntity.init();
			GuardianEntity.init();
			BuggerEntity.init();
			StunnerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(THEFACE.get(), ThefaceEntity.createAttributes().build());
		event.put(BOULDER.get(), BoulderEntity.createAttributes().build());
		event.put(THEDIGGER.get(), ThediggerEntity.createAttributes().build());
		event.put(FLAYEDMANHEAD.get(), FlayedmanheadEntity.createAttributes().build());
		event.put(FLAYEDMANSECTIONS.get(), FlayedmansectionsEntity.createAttributes().build());
		event.put(FLAYEDMANTAIL.get(), FlayedmantailEntity.createAttributes().build());
		event.put(GUARDIAN.get(), GuardianEntity.createAttributes().build());
		event.put(BUGGER.get(), BuggerEntity.createAttributes().build());
		event.put(STUNNER.get(), StunnerEntity.createAttributes().build());
	}
}

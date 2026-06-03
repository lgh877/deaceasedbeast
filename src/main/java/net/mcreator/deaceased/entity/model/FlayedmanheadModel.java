package net.mcreator.deaceased.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.deaceased.entity.FlayedmanheadEntity;

public class FlayedmanheadModel extends GeoModel<FlayedmanheadEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlayedmanheadEntity entity) {
		return new ResourceLocation("deaceased", "animations/centipedesections_head_main.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlayedmanheadEntity entity) {
		return new ResourceLocation("deaceased", "geo/centipedesections_head_main.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlayedmanheadEntity entity) {
		return new ResourceLocation("deaceased", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(FlayedmanheadEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}

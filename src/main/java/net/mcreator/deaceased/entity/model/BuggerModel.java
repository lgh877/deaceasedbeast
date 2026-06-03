package net.mcreator.deaceased.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.deaceased.entity.BuggerEntity;

public class BuggerModel extends GeoModel<BuggerEntity> {
	@Override
	public ResourceLocation getAnimationResource(BuggerEntity entity) {
		return new ResourceLocation("deaceased", "animations/bugger.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BuggerEntity entity) {
		return new ResourceLocation("deaceased", "geo/bugger.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BuggerEntity entity) {
		return new ResourceLocation("deaceased", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(BuggerEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("bone");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}

package net.mcreator.deaceased.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.deaceased.entity.GuardianEntity;

public class GuardianModel extends GeoModel<GuardianEntity> {
	@Override
	public ResourceLocation getAnimationResource(GuardianEntity entity) {
		return new ResourceLocation("deaceased", "animations/guardian.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GuardianEntity entity) {
		return new ResourceLocation("deaceased", "geo/guardian.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GuardianEntity entity) {
		return new ResourceLocation("deaceased", "textures/entities/" + entity.getTexture() + ".png");
	}

}

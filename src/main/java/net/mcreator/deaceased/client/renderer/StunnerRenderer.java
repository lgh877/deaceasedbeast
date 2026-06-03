
package net.mcreator.deaceased.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.deaceased.entity.model.StunnerModel;
import net.mcreator.deaceased.entity.layer.StunnerLayer;
import net.mcreator.deaceased.entity.StunnerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class StunnerRenderer extends GeoEntityRenderer<StunnerEntity> {
	public StunnerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new StunnerModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new StunnerLayer(this));
	}

	@Override
	public RenderType getRenderType(StunnerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, StunnerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}

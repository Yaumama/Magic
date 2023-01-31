package net.yaumama.magic.item.client;

import net.minecraft.resources.ResourceLocation;
import net.yaumama.magic.MagicMod;
import net.yaumama.magic.item.custom.MagicGloves;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MagicGlovesModel extends AnimatedGeoModel<MagicGloves> {
    @Override
    public ResourceLocation getModelResource(MagicGloves object) {
        return new ResourceLocation(MagicMod.MOD_ID, "geo/magic_gloves.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MagicGloves object) {
        return new ResourceLocation(MagicMod.MOD_ID, "textures/item/magic_gloves_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MagicGloves animatable) {
        return new ResourceLocation(MagicMod.MOD_ID, "animations/magic_gloves.animation.json");
    }
}

package net.yaumama.magic.item.client;

import net.yaumama.magic.item.custom.MagicGloves;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class MagicGlovesRenderer extends GeoItemRenderer<MagicGloves> {
    public MagicGlovesRenderer() {
        super(new MagicGlovesModel());
    }
}

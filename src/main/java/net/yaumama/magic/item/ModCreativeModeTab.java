package net.yaumama.magic.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MAGIC_TAB = new CreativeModeTab("magictab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MAGIC_DUST.get());
        }
    };
}

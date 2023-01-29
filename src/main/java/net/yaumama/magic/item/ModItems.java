package net.yaumama.magic.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yaumama.magic.MagicMod;

public class ModItems {
    public static final  DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MagicMod.MOD_ID);

    public static final RegistryObject<Item> MAGIC_SILK = ITEMS.register("magic_silk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAGIC_TAB)));
    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAGIC_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

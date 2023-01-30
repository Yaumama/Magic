package net.yaumama.magic.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.yaumama.magic.MagicMod;
import net.yaumama.magic.block.ModBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MagicMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MAGIC_STONES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MAGIC_STONE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.MAGIC_DEEPSLATE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAGIC_STONE = CONFIGURED_FEATURE.register("magic_stone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_MAGIC_STONES.get(), 9)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURE.register(eventBus);
    }
}

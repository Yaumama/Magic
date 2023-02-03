package net.yaumama.magic.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.yaumama.magic.MagicMod;

@Mod.EventBusSubscriber(modid = MagicMod.MOD_ID, value = Dist.CLIENT)
public class ClientHandler {
    public static void setup() {
        MinecraftForge.EVENT_BUS.register(CastSpells.get());
    }
}

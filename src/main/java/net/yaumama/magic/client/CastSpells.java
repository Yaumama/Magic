package net.yaumama.magic.client;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.yaumama.magic.item.ModItems;
import net.yaumama.magic.item.custom.MagicGloves;
import net.yaumama.magic.networking.ModMessages;
import net.yaumama.magic.networking.packet.CastSpellC2SPacket;

public class CastSpells {
    private static CastSpells instance;

    public static CastSpells get() {
        if (instance == null) {
            instance = new CastSpells();
        }
        return instance;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onClick(InputEvent.InteractionKeyMappingTriggered event) {
        if (event.isCanceled()) { return; }
        Minecraft mc = Minecraft.getInstance();
        Player plr = mc.player;
        if (plr == null) { return; }

        if (event.isAttack()) {
            ItemStack item = plr.getMainHandItem();
            if (item.getItem() instanceof MagicGloves) {
                event.setCanceled(true);
                event.setSwingHand(false);
                ModMessages.sendToServer(new CastSpellC2SPacket());
            }
        }
    }
}

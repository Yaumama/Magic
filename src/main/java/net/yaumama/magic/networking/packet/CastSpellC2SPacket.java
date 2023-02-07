package net.yaumama.magic.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.yaumama.magic.capabilities.PlayerMagicProvider;
import net.yaumama.magic.spells.ModSpells;

import java.util.function.Supplier;

public class CastSpellC2SPacket {
    public  CastSpellC2SPacket() {

    }

    public  CastSpellC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            player.getCapability(PlayerMagicProvider.PLAYER_MAGIC).ifPresent(magic -> {
                new ModSpells().castSpell(magic.getSelectedSpell(), level, player);
            });
        });
        return true;
    }
}

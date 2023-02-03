package net.yaumama.magic.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

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
            ServerPlayer plr = context.getSender();
            ServerLevel level = plr.getLevel();


            Entity ent = EntityType.FIREBALL.spawn(level, null, null, plr.blockPosition().above(1),
                    MobSpawnType.COMMAND, true, false);
            ent.hurtMarked = true;
            ent.setDeltaMovement(plr.getLookAngle().multiply(2, 2, 2));
        });
        return true;
    }
}

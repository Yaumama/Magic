package net.yaumama.magic.spells;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ModSpells {
    public String[] spells = {"fireball", "arrow"};

    public Arrow createArrow(Level worldIn, LivingEntity shooter) {
        Arrow arrowentity = new Arrow(worldIn, shooter);
        return arrowentity;
    }
    public Arrow customeArrow(Arrow arrow) {
        return arrow;
    }

    public void castSpell(String spell, ServerLevel level, ServerPlayer player) {
        if (spell == "fireball") {
            Entity ent = EntityType.FIREBALL.spawn(level, null, null, player.blockPosition().above(1),
                    MobSpawnType.COMMAND, true, false);
            Vec3 velocity = player.getLookAngle().multiply(5, 5, 5);
            ent.hurtMarked = true;
            ent.moveTo(ent.position().add(player.getLookAngle().multiply(0.5, 0.5, 0.5)));
            ent.setDeltaMovement(velocity);
        }

        if (spell == "arrow") {
            Arrow abstractarrowentity = createArrow(level, player);
            abstractarrowentity = customeArrow(abstractarrowentity);
            abstractarrowentity.shootFromRotation(player, player.getXRot(), player.getYRot(),
                    0.0F, 1.0F * 3.0F, 1.0F);

            abstractarrowentity.setBaseDamage(2.5);
            abstractarrowentity.tickCount = 35;
            abstractarrowentity.isNoGravity();

            level.addFreshEntity(abstractarrowentity);
        }
    }
}

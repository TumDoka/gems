package tumdoka.gems.events;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tumdoka.gems.item.Items;

public class AttackEntity implements AttackEntityCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (!(entity instanceof LivingEntity le)){
            return ActionResult.PASS;
        }
        le = (LivingEntity) entity;
        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.TopazRing)){
            entity.setFireTicks(entity.getFireTicks() + 100);
        }
        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.JadeAmulet) && le.getGroup() == EntityGroup.UNDEAD && !world.isClient()) {
            le.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0, false, false), player);
        }
        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.AventurineNecklace)) {
            NbtCompound nbt = TrinketsApi.getTrinketComponent(player).get().getEquipped(Items.AventurineNecklace).get(0).getRight().getNbt();
            if (nbt.getByte("gems.timer") == 10){
                player.heal(1f);
                nbt.putByte("gems.timer", (byte) 0);
            }
        }
        return ActionResult.PASS;
    }
}

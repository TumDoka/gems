package tumdoka.gems.item.bijouterie;

import dev.emi.trinkets.api.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class AquamarineEarrings extends TrinketItem {
    public AquamarineEarrings(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity.isTouchingWater()){
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1, 0, false, true));
        }
    }
}

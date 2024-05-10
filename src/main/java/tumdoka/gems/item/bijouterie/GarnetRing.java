package tumdoka.gems.item.bijouterie;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class GarnetRing extends TrinketItem {

    public GarnetRing(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if (!stack.hasNbt()){
            return false;
        }
        return stack.getNbt().getBoolean("gems.berserk");
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!stack.hasNbt()){
            NbtCompound nbt = new NbtCompound();
            stack.setNbt(nbt);
        }
        PlayerEntity player = (PlayerEntity) entity;
        if (stack.getNbt().getInt("gems.timer") >= 600){
            stack.getNbt().putBoolean("gems.berserk", true);
        }
        if (stack.getNbt().getBoolean("gems.berserk") && player.getHealth() <= 8){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 2), player);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1), player);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), player);
            stack.getNbt().putBoolean("gems.berserk", false);
            stack.getNbt().putInt("gems.timer", 0);
        }
        if (!stack.getNbt().getBoolean("gems.berserk")){
            stack.getNbt().putInt("gems.timer", stack.getNbt().getInt("gems.timer") + 1);
        }
    }
}

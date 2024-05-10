package tumdoka.gems.item.bijouterie;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;

import java.util.UUID;

public class AventurineNecklace extends TrinketItem {

    public AventurineNecklace(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!stack.hasNbt()){
            NbtCompound nbt = new NbtCompound();
            stack.setNbt(nbt);
        }
        NbtCompound nbt = stack.getNbt();

        if (nbt.getByte("gems.timer") != 10){
            nbt.putByte("gems.timer", (byte) (nbt.getByte("gems.timer") + 1));
        }
    }
}

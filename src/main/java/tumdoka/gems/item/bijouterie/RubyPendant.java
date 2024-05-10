package tumdoka.gems.item.bijouterie;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import tumdoka.gems.item.Items;

import java.util.List;

public class RubyPendant extends TrinketItem {
    public RubyPendant(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        List<Entity> entities = world.getOtherEntities(user, new Box(user.getX() + 20, user.getY() + 20, user.getZ() + 20, user.getX() - 20, user.getY() - 20, user.getZ() - 20));
        for (int i = 0; i < entities.size(); i++){
            if (entities.get(i) instanceof LivingEntity le){
                le = (LivingEntity) entities.get(i);
                le.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20, 1, false, false), user);
            }
        }
        user.getItemCooldownManager().set(Items.RubyPendant, 60);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}

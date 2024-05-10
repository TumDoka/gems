package tumdoka.gems.item.omnistuff;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Pair;
import tumdoka.gems.GemsUtil;

import java.util.ArrayList;

public class OmniSword extends SwordItem {
    public OmniSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    ArrayList<Pair<StatusEffect, StatusEffect>> effects = GemsUtil.omniSwordEffects;

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target != null && attacker != null) {
            target.setStatusEffect(new StatusEffectInstance(effects.get(attacker.getRandom().nextInt(effects.size())).getLeft(), 100, 0), attacker);
            attacker.setStatusEffect(new StatusEffectInstance(effects.get(attacker.getRandom().nextInt(effects.size())).getRight(), 100, 0), attacker);
        }
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }
}

package tumdoka.gems.item.omnistuff;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tumdoka.gems.GemsUtil;

import java.util.ArrayList;

public class OmniPickaxe extends PickaxeItem {
    public OmniPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    NbtCompound nbt;
    int i = 0;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!stack.hasNbt()){
            nbt = new NbtCompound();
            nbt.putString("gems.mode", "nothing");
            stack.setNbt(nbt);
        }
        if (i != 2){
            i++;
        } else {
            i = 0;
        }
        nbt = stack.getNbt();
        if (i == 0){
            nbt.putString("gems.mode", "nothing");
            if (stack.getEnchantments().contains(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH), 1))){
                stack.getEnchantments().remove(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH), 1));
            } if (stack.getEnchantments().contains(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.FORTUNE), 3))){
                stack.getEnchantments().remove(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.FORTUNE), 3));
            }
        } else if (i == 1) {
            nbt.putString("gems.mode", "silk_touch");
            if (stack.getEnchantments().contains(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH), 1))){
                stack.getEnchantments().remove(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH), 1));
            } if (stack.getEnchantments().contains(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.FORTUNE), 3))){
                stack.getEnchantments().remove(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.FORTUNE), 3));
            }
            stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
        } else if (i == 2){
            nbt.putString("gems.mode", "fortune");
            if (stack.getEnchantments().contains(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH), 1))){
                stack.getEnchantments().remove(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH), 1));
            } if (stack.getEnchantments().contains(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.FORTUNE), 3))){
                stack.getEnchantments().remove(EnchantmentHelper.createNbt(EnchantmentHelper.getEnchantmentId(Enchantments.FORTUNE), 3));
            }
            stack.addEnchantment(Enchantments.FORTUNE, 3);
        }
        return TypedActionResult.success(stack);
    }
}

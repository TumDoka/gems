package tumdoka.gems.item;

import net.minecraft.block.GrindstoneBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GemItem extends Item {

    int hardness;
    Item polishedVar;
    public GemItem(Settings settings, int hardness, Item polishedVar) {
        super(settings);
        this.hardness = hardness;
        this.polishedVar = polishedVar;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos bp = context.getBlockPos();
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack is = context.getStack();
        if(!(world.getBlockState(bp).getBlock() instanceof GrindstoneBlock)){
            return ActionResult.PASS;
        }
        player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE, 1, 1.5f);
        if(!world.isClient) {
            if (!player.isSneaking()) {
                return ActionResult.PASS;
            }
            if(player.getRandom().nextInt(100) >= hardness){
                is.decrement(1);
                player.getInventory().insertStack(polishedVar.getDefaultStack());
            }
        }
        return ActionResult.SUCCESS;
    }
}

package tumdoka.gems.item;

import net.minecraft.block.Block;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tumdoka.gems.GemsUtil;

public class Geode extends Item {

    private byte type;

    public Geode(Settings settings, byte type) {
        super(settings);
        this.type = type;
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos bp = context.getBlockPos();
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if(!(world.getBlockState(bp).getBlock() instanceof StonecutterBlock)){
            return ActionResult.PASS;
        }
        player.playSound(SoundEvents.UI_STONECUTTER_TAKE_RESULT, 1, 1.5f);
        if (!world.isClient){
            if (player.isSneaking()){
                Block.dropStack(world, bp, GemsUtil.getItem(player.getRandom(), type));
                ItemStack is = context.getStack();
                is.decrement(1);
            }
        }
        return ActionResult.SUCCESS;
    }
}

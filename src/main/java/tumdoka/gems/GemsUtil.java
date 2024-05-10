package tumdoka.gems;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Pair;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import tumdoka.gems.item.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class GemsUtil {

    public static ArrayList<ItemStack> defaultList = new ArrayList<ItemStack>();
    public static ArrayList<ItemStack> preciousList = new ArrayList<ItemStack>();
    public static ArrayList<Pair<StatusEffect, StatusEffect>> omniSwordEffects = new ArrayList<>();
    public static HashMap<Block, Block> logs = new HashMap<Block, Block>();
    public static HashMap<String, StatusEffect> effects = new HashMap<String, StatusEffect>();
    private static ItemStack defPrice = new ItemStack(net.minecraft.item.Items.EMERALD, 24);

    public static ItemStack getItem(Random rnd, int type){

        defaultList.add(new ItemStack(Items.Aquamarine));
        defaultList.add(new ItemStack(Items.Topaz));
        defaultList.add(new ItemStack(Items.Ruby));
        defaultList.add(new ItemStack(Items.Aventurine));
        defaultList.add(new ItemStack(Items.Jade));
        defaultList.add(new ItemStack(Items.Opal));
        defaultList.add(new ItemStack(Items.Garnet));
        defaultList.add(net.minecraft.item.Items.DIAMOND.getDefaultStack());
        defaultList.add(net.minecraft.item.Items.EMERALD.getDefaultStack());
        defaultList.add(new ItemStack(net.minecraft.item.Items.QUARTZ, rnd.nextInt(32)));
        defaultList.add(new ItemStack(net.minecraft.item.Items.AMETHYST_SHARD, rnd.nextInt(32)));

        preciousList.add(new ItemStack(net.minecraft.item.Items.DIAMOND, rnd.nextInt(14)));
        preciousList.add(new ItemStack(net.minecraft.item.Items.EMERALD, rnd.nextInt(30)));
        preciousList.add(new ItemStack(net.minecraft.item.Items.ECHO_SHARD, rnd.nextInt(3)));
        preciousList.add(new ItemStack(net.minecraft.item.Items.DISC_FRAGMENT_5, rnd.nextInt(3)));
        preciousList.add(new ItemStack(net.minecraft.item.Items.MUSIC_DISC_11));
        preciousList.add(new ItemStack(net.minecraft.item.Items.SNIFFER_EGG));
        preciousList.add(new ItemStack(net.minecraft.item.Items.NETHERITE_SCRAP, rnd.nextInt(4)));
        preciousList.add(new ItemStack(Items.Omnishard));

        if (type == 1) {
            return preciousList.get(rnd.nextInt(preciousList.size()));
        }
        return defaultList.get(rnd.nextInt(defaultList.size()));
    }

    public static void fillLists(){
        logs.put(Blocks.ACACIA_LOG, Blocks.ACACIA_PLANKS);
        logs.put(Blocks.OAK_LOG, Blocks.OAK_PLANKS);
        logs.put(Blocks.SPRUCE_LOG, Blocks.SPRUCE_PLANKS);
        logs.put(Blocks.BIRCH_LOG, Blocks.BIRCH_PLANKS);
        logs.put(Blocks.JUNGLE_LOG, Blocks.JUNGLE_PLANKS);
        logs.put(Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS);
        logs.put(Blocks.MANGROVE_LOG, Blocks.MANGROVE_PLANKS);
        logs.put(Blocks.CHERRY_LOG, Blocks.CHERRY_PLANKS);
        logs.put(Blocks.WARPED_STEM, Blocks.WARPED_PLANKS);
        logs.put(Blocks.CRIMSON_STEM, Blocks.CRIMSON_PLANKS);

        effects.put("effect.minecraft.absorption", StatusEffects.ABSORPTION);
        effects.put("effect.minecraft.fire_resistance", StatusEffects.FIRE_RESISTANCE);
        effects.put("effect.minecraft.jump_boost", StatusEffects.JUMP_BOOST);
        effects.put("effect.minecraft.jump_boost", StatusEffects.SPEED);

        omniSwordEffects.add(new Pair<>(StatusEffects.POISON, StatusEffects.REGENERATION));
        omniSwordEffects.add(new Pair<>(StatusEffects.SLOWNESS, StatusEffects.SPEED));
        omniSwordEffects.add(new Pair<>(StatusEffects.WEAKNESS, StatusEffects.STRENGTH));
        omniSwordEffects.add(new Pair<>(StatusEffects.WITHER, StatusEffects.ABSORPTION));
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Aquamarine),
                    defPrice,
                    3, 15, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Topaz),
                    defPrice,
                    3, 15, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Aventurine),
                    defPrice,
                    3, 15, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Ruby),
                    defPrice,
                    3, 15, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Jade),
                    defPrice,
                    3, 15, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Opal),
                    defPrice,
                    3, 15, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Garnet),
                    defPrice,
                    3, 15, 0.05f
            ));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.Omnishard),
                    new ItemStack(net.minecraft.item.Items.EMERALD, 64),
                    1, 15, 0.05f
            ));
        });
    }
}

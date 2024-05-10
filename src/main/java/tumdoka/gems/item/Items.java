package tumdoka.gems.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import tumdoka.gems.Gems;
import tumdoka.gems.item.bijouterie.*;
import tumdoka.gems.item.omnistuff.*;

public class Items {

    //polished stones
    public static final Item PolishedAquamarine = registerItem("polished_aquamarine", new Item(new FabricItemSettings()));
    public static final Item PolishedTopaz = registerItem("polished_topaz", new Item(new FabricItemSettings()));
    public static final Item PolishedAventurine = registerItem("polished_aventurine", new Item(new FabricItemSettings()));
    public static final Item PolishedRuby = registerItem("polished_ruby", new Item(new FabricItemSettings()));
    public static final Item PolishedJade = registerItem("polished_jade", new Item(new FabricItemSettings()));
    public static final Item PolishedOpal = registerItem("polished_opal", new Item(new FabricItemSettings()));
    public static final Item PolishedGarnet = registerItem("polished_garnet", new Item(new FabricItemSettings()));
    public static final Item Omniessence = registerItem("omniessence", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    //bijouterie
    public static final Item AquamarineEarring = registerItem("aquamarine_earrings", new AquamarineEarrings(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item TopazRing = registerItem("topaz_ring", new TopazRing(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item AventurineNecklace = registerItem("aventurine_necklace", new AventurineNecklace(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item RubyPendant = registerItem("ruby_pendant", new RubyPendant(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item JadeAmulet = registerItem("jade_amulet", new JadeAmulet(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item MinersAmulet = registerItem("miners_amulet", new MinersAmulet(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item GarnetRing = registerItem("garnet_ring", new GarnetRing(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON).maxDamage(50)));
    //stones
    public static final Item Aquamarine = registerItem("aquamarine", new GemItem(new FabricItemSettings(), 75, PolishedAquamarine));
    public static final Item Topaz = registerItem("topaz", new GemItem(new FabricItemSettings(), 80, PolishedTopaz));
    public static final Item Aventurine = registerItem("aventurine", new GemItem(new FabricItemSettings(), 80, PolishedAventurine));
    public static final Item Ruby = registerItem("ruby", new GemItem(new FabricItemSettings(), 90, PolishedRuby));
    public static final Item Jade = registerItem("jade", new GemItem(new FabricItemSettings(), 55, PolishedJade));
    public static final Item Opal = registerItem("opal", new GemItem(new FabricItemSettings(), 55, PolishedOpal));
    public static final Item Garnet = registerItem("garnet", new GemItem(new FabricItemSettings(), 75, PolishedGarnet));
    public static final Item Omnishard = registerItem("omnishard", new GemItem(new FabricItemSettings().rarity(Rarity.EPIC), 99, Omniessence));
    //Geodes
    public static final Item Geode = registerItem("geode", new Geode(new FabricItemSettings(), (byte) 0));
    public static final Item RichGeode = registerItem("rich_geode", new Geode(new FabricItemSettings(), (byte) 1));
    //Stuff
    public static final Item GeologistsPickaxe = registerItem("geologists_hammer", new PickaxeItem(StonesMaterials.COPPER_MATERIAL, 2, -2.8f, new FabricItemSettings()));
    public static final Item Omnipickaxe = registerItem("omnipickaxe", new OmniPickaxe(StonesMaterials.OMNI_MATERIAL, 0, -2.8f, new FabricItemSettings()));
    public static final Item Omniaxe = registerItem("omniaxe", new OmniAxe(StonesMaterials.OMNI_MATERIAL, 5.0f, -3.0f, new FabricItemSettings()));
    public static final Item Omnisword = registerItem("omnisword", new OmniSword(StonesMaterials.OMNI_MATERIAL, 3, -2.4f, new FabricItemSettings()));

    public static void registerModItems(){
        Gems.LOGGER.info("registering items for " + Gems.MODID);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Gems.MODID, name), item);
    }


}

package tumdoka.gems.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tumdoka.gems.Gems;

public class ItemGroup {
    public static final net.minecraft.item.ItemGroup stones_group = Registry.register(Registries.ITEM_GROUP, new Identifier(Gems.MODID, "gems"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gems.itemgroup"))
                    .icon(() -> new ItemStack(Items.AventurineNecklace)).entries((displayContext, entries) -> {
                        entries.add(Items.Geode);
                        entries.add(Items.RichGeode);
                        entries.add(Items.GeologistsPickaxe);
                        entries.add(Items.Omnipickaxe);
                        entries.add(Items.Omniaxe);
                        entries.add(Items.Omnisword);

                        entries.add(Items.Aquamarine);
                        entries.add(Items.Topaz);
                        entries.add(Items.Aventurine);
                        entries.add(Items.Ruby);
                        entries.add(Items.Jade);
                        entries.add(Items.Opal);
                        entries.add(Items.Garnet);
                        entries.add(Items.Omnishard);

                        entries.add(Items.PolishedAquamarine);
                        entries.add(Items.PolishedTopaz);
                        entries.add(Items.PolishedAventurine);
                        entries.add(Items.PolishedRuby);
                        entries.add(Items.PolishedJade);
                        entries.add(Items.PolishedOpal);
                        entries.add(Items.PolishedGarnet);
                        entries.add(Items.Omniessence);

                        entries.add(Items.AquamarineEarring);
                        entries.add(Items.TopazRing);
                        entries.add(Items.AventurineNecklace);
                        entries.add(Items.RubyPendant);
                        entries.add(Items.JadeAmulet);
                        entries.add(Items.MinersAmulet);
                        entries.add(Items.GarnetRing.getDefaultStack());
                    }).build());
    public static void registerItemGroup(){
        Gems.LOGGER.info("registering item group for " + Gems.MODID);
    }
}

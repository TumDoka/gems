package tumdoka.gems.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import tumdoka.gems.item.Items;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Items.Aquamarine, Models.GENERATED);
        itemModelGenerator.register(Items.PolishedAquamarine, Models.GENERATED);
        itemModelGenerator.register(Items.AquamarineEarring, Models.GENERATED);
        itemModelGenerator.register(Items.Aventurine, Models.GENERATED);
        itemModelGenerator.register(Items.AventurineNecklace, Models.GENERATED);
        itemModelGenerator.register(Items.PolishedAventurine, Models.GENERATED);
        itemModelGenerator.register(Items.Topaz, Models.GENERATED);
        itemModelGenerator.register(Items.PolishedTopaz, Models.GENERATED);
        itemModelGenerator.register(Items.TopazRing, Models.GENERATED);
        itemModelGenerator.register(Items.Ruby, Models.GENERATED);
        itemModelGenerator.register(Items.PolishedRuby, Models.GENERATED);
        itemModelGenerator.register(Items.RubyPendant, Models.GENERATED);
        itemModelGenerator.register(Items.Jade, Models.GENERATED);
        itemModelGenerator.register(Items.PolishedJade, Models.GENERATED);
        itemModelGenerator.register(Items.JadeAmulet, Models.GENERATED);
        itemModelGenerator.register(Items.Opal, Models.GENERATED);
        itemModelGenerator.register(Items.PolishedOpal, Models.GENERATED);
        itemModelGenerator.register(Items.MinersAmulet, Models.GENERATED);
        itemModelGenerator.register(Items.Garnet, Models.GENERATED);
        itemModelGenerator.register(Items.PolishedGarnet, Models.GENERATED);
        itemModelGenerator.register(Items.GarnetRing, Models.GENERATED);
        itemModelGenerator.register(Items.Omnishard, Models.GENERATED);
        itemModelGenerator.register(Items.Omniessence, Models.GENERATED);
        itemModelGenerator.register(Items.Geode, Models.GENERATED);
        itemModelGenerator.register(Items.RichGeode, Models.GENERATED);
        itemModelGenerator.register(Items.GeologistsPickaxe, Models.HANDHELD);
        itemModelGenerator.register(Items.Omniaxe, Models.HANDHELD);
        itemModelGenerator.register(Items.Omnipickaxe, Models.HANDHELD);
        itemModelGenerator.register(Items.Omnisword, Models.HANDHELD);
    }
}

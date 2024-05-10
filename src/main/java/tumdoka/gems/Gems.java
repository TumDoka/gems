package tumdoka.gems;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tumdoka.gems.events.AttackEntity;
import tumdoka.gems.item.ItemGroup;
import tumdoka.gems.item.Items;

public class Gems implements ModInitializer {

	public static final String MODID = "gems";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);


	@Override
	public void onInitialize() {
		Items.registerModItems();
		AttackEntityCallback.EVENT.register(new AttackEntity());
		ItemGroup.registerItemGroup();
		GemsUtil.registerTrades();
		GemsUtil.fillLists();
		LOGGER.info("Initializing gems");
	}
}
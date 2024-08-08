package mod.azure.azurepaxels;

import mod.azure.azurepaxels.services.CommonRegistry;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class NeoForgeCommonRegistry implements CommonRegistry {

    @Override
    public <T extends Item> Supplier<T> registerItem(String modID, String itemName, Supplier<T> item) {
        return NeoForgeMod.ITEM_DEFERRED_REGISTER.register(itemName, item);
    }
}

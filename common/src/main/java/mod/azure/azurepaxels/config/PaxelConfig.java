package mod.azure.azurepaxels.config;


import mod.azure.azurelib.common.api.common.config.Config;
import mod.azure.azurelib.common.internal.common.config.Configurable;
import mod.azure.azurepaxels.CommonMod;

@Config(id = CommonMod.MOD_ID)
public class PaxelConfig {
    @Configurable
    @Configurable.Synchronized
    public int paxel_wood_minespeed = 30;
    @Configurable
    @Configurable.Synchronized
    public int paxel_stone_minespeed = 30;
    @Configurable
    @Configurable.Synchronized
    public int paxel_iron_minespeed = 30;
    @Configurable
    @Configurable.Synchronized
    public int paxel_gold_minespeed = 30;
    @Configurable
    @Configurable.Synchronized
    public int paxel_diamond_minespeed = 30;
    @Configurable
    @Configurable.Synchronized
    public int paxel_netherrite_minespeed = 30;

    @Configurable
    @Configurable.Synchronized
    public int paxel_wood_durability = 59;
    @Configurable
    @Configurable.Synchronized
    public int paxel_stone_durability = 131;
    @Configurable
    @Configurable.Synchronized
    public int paxel_iron_durability = 250;
    @Configurable
    @Configurable.Synchronized
    public int paxel_gold_durability = 32;
    @Configurable
    @Configurable.Synchronized
    public int paxel_diamond_durability = 1561;
    @Configurable
    @Configurable.Synchronized
    public int paxel_netherrite_durability = 2031;

}

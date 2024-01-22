package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class minecraftle implements CommandExecutor {

    private final main plugin;

    public minecraftle(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = plugin.getConfig();

        if (commandSender instanceof Player player){

            Inventory inv = Bukkit.createInventory(player, InventoryType.CRAFTING, "Minecraftle in Minecarft");
            player.openWorkbench(null, true);

            /* Add the following items in the inventory :
            - Oak Planks
            - Cobblestone
            - Stone
            - Glass
            - White Wool
            - Stick
            - Coal
            - Diamond
            - Gold Ingot
            - Iron Ingot
            - Redstone Dust
            - Quartz
            - Oak Slab
            - Oak Log
            - Iron Nugget
            - Redstone Torch
            - String
            - Leather
             */

            Material[] possibleItems = {Material.STICK, Material.TORCH, Material.CRAFTING_TABLE, Material.FURNACE,
                    Material.CHEST, Material.LADDER, Material.OAK_FENCE, Material.OAK_BOAT, Material.OAK_SLAB,
                    Material.COBBLESTONE_SLAB, Material.STONE_SLAB, Material.OAK_SIGN, Material.OAK_DOOR,
                    Material.IRON_DOOR, Material.OAK_WOOD, Material.NOTE_BLOCK, Material.DIAMOND_BLOCK,
                    Material.GOLD_BLOCK, Material.IRON_BLOCK, Material.COAL_BLOCK, Material.STONE_BRICKS,
                    Material.OAK_STAIRS, Material.COBBLESTONE_STAIRS, Material.STONE_STAIRS, Material.COBBLESTONE_WALL,
                    Material.REDSTONE_BLOCK, Material.QUARTZ_BLOCK, Material.DIORITE, Material.CHISELED_BOOKSHELF,
                    Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE,
                    Material.DIAMOND_PICKAXE, Material. WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE,
                    Material.GOLDEN_AXE, Material.DIAMOND_AXE, Material.WOODEN_SHOVEL, Material.STONE_SHOVEL,
                    Material.IRON_SHOVEL, Material.GOLDEN_SHOVEL, Material.DIAMOND_SHOVEL, Material.WOODEN_HOE,
                    Material.STONE_HOE, Material.IRON_HOE, Material.GOLDEN_HOE, Material.DIAMOND_HOE,
                    Material.FISHING_ROD, Material.COMPASS, Material.CLOCK, Material.BUCKET, Material.SHEARS,
                    Material.LEATHER_HELMET, Material.IRON_HELMET, Material.GOLDEN_HELMET, Material.DIAMOND_HELMET,
                    Material.LEATHER_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLDEN_CHESTPLATE,
                    Material.DIAMOND_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.IRON_LEGGINGS,
                    Material.GOLDEN_LEGGINGS, Material.DIAMOND_LEGGINGS, Material.LEATHER_BOOTS, Material.IRON_BOOTS,
                    Material.GOLDEN_BOOTS, Material.DIAMOND_BOOTS, Material.WOODEN_SWORD, Material.STONE_SWORD,
                    Material.IRON_SWORD, Material.GOLDEN_SWORD, Material.DIAMOND_SWORD, Material.BOW,
                    Material.LEATHER_HORSE_ARMOR, Material.SHIELD, Material.OAK_PRESSURE_PLATE,
                    Material.STONE_PRESSURE_PLATE, Material.HEAVY_WEIGHTED_PRESSURE_PLATE,
                    Material.LIGHT_WEIGHTED_PRESSURE_PLATE, Material.OAK_TRAPDOOR, Material.OAK_FENCE_GATE,
                    Material.OAK_BUTTON, Material.STONE_BUTTON, Material.LEVER, Material.REPEATER,
                    Material.REDSTONE_TORCH, Material.JUKEBOX, Material.PISTON, Material.MINECART, Material.RAIL,
                    Material.POWERED_RAIL, Material.TRIPWIRE_HOOK, Material.ACTIVATOR_RAIL, Material.DAYLIGHT_DETECTOR,
                    Material.DROPPER, Material.HOPPER, Material.IRON_TRAPDOOR, Material.OBSERVER, Material.BOWL,
                    Material.WHITE_BED, Material.PAINTING, Material.GLASS_PANE, Material.IRON_BARS, Material.GOLD_NUGGET,
                    Material.IRON_NUGGET, Material.IRON_INGOT, Material.ITEM_FRAME, Material.WHITE_CARPET,
                    Material.WHITE_BANNER, Material.CAMPFIRE, Material.BARREL, Material.COMPOSTER,
                    Material.SMITHING_TABLE, Material.STONECUTTER, Material.GRINDSTONE, Material.LOOM, Material.CHAIN,
                    Material.WHITE_WOOL, Material.GLASS_BOTTLE, Material.CAULDRON};

            Random randomNumber = new Random();
            Material randomItem = possibleItems[randomNumber.nextInt(possibleItems.length)];

            config.set("minecraftle_game." + player.getUniqueId(), randomItem);

        }

        plugin.saveConfig();
        return true;
    }
}

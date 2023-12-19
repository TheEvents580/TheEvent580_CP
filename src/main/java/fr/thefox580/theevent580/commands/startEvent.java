package fr.thefox580.theevent580.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class startEvent implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player){

            Inventory gui = Bukkit.createInventory(player, 27, "Are you sure to start ?");

            ItemStack yes = new ItemStack(Material.LIME_CONCRETE);
            ItemStack no = new ItemStack(Material.RED_CONCRETE);
            ItemStack blank = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

            ItemMeta yes_meta = yes.getItemMeta();
            yes_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "YES");
            ArrayList<String> yes_lore = new ArrayList<>();
            yes_lore.add(ChatColor.GREEN  + "Yes, everyone is ready to start");
            yes_meta.setLore(yes_lore);
            yes.setItemMeta(yes_meta);

            ItemMeta no_meta = no.getItemMeta();
            no_meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "NO");
            ArrayList<String> no_lore = new ArrayList<>();
            no_lore.add(ChatColor.RED + "No, everyone is not ready to start");
            no_meta.setLore(no_lore);
            no.setItemMeta(no_meta);

            ItemMeta blank_meta = blank.getItemMeta();
            blank_meta.setDisplayName("");
            blank.setItemMeta(blank_meta);

            ItemStack[] menu_items = {
                    blank, blank, blank, blank, blank, blank, blank, blank, blank,
                    blank, blank, yes  , blank, blank, blank, no   , blank, blank,
                    blank, blank, blank, blank, blank, blank, blank, blank, blank}
                    ;
            gui.setContents(menu_items);

            player.openInventory(gui);
        }

        return true;
    }
}

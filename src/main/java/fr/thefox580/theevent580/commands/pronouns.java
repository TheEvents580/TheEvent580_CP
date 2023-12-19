package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class pronouns implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        // Try to make a menu with pronouns 1 & 2

        if (commandSender instanceof Player player){

            Inventory gui = Bukkit.createInventory(player, 45, "Choose you pronouns :");

            ItemStack he = new ItemStack(Material.RED_CONCRETE);
            ItemStack she = new ItemStack(Material.ORANGE_CONCRETE);
            ItemStack they = new ItemStack(Material.YELLOW_CONCRETE);
            ItemStack any = new ItemStack(Material.LIME_CONCRETE);

            ItemStack him = new ItemStack(Material.GREEN_CONCRETE);
            ItemStack her = new ItemStack(Material.CYAN_CONCRETE);
            ItemStack them = new ItemStack(Material.LIGHT_BLUE_CONCRETE);
            ItemStack all = new ItemStack(Material.BLUE_CONCRETE);

            ItemStack blank = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

            ItemStack close = new ItemStack(Material.BARRIER);

            ItemMeta he_meta = he.getItemMeta();
            he_meta.setDisplayName(ChatColor.WHITE + "He");
            ArrayList<String> he_lore = new ArrayList<>();
            he_lore.add(ChatColor.YELLOW + "Click here to set \"He\" as your 1st pronoun");
            he_meta.setLore(he_lore);
            he.setItemMeta(he_meta);

            ItemMeta she_meta = she.getItemMeta();
            she_meta.setDisplayName(ChatColor.WHITE + "She");
            ArrayList<String> she_lore = new ArrayList<>();
            she_lore.add(ChatColor.YELLOW + "Click here to set \"She\" as your 1st pronoun");
            she_meta.setLore(she_lore);
            she.setItemMeta(she_meta);

            ItemMeta they_meta = they.getItemMeta();
            they_meta.setDisplayName(ChatColor.WHITE + "They");
            ArrayList<String> they_lore = new ArrayList<>();
            they_lore.add(ChatColor.YELLOW + "Click here to set \"They\" as your 1st pronoun");
            they_meta.setLore(they_lore);
            they.setItemMeta(they_meta);

            ItemMeta any_meta = any.getItemMeta();
            any_meta.setDisplayName(ChatColor.WHITE + "Any");
            ArrayList<String> any_lore = new ArrayList<>();
            any_lore.add(ChatColor.YELLOW + "Click here to set \"Any\" as your 1st pronoun");
            any_meta.setLore(any_lore);
            any.setItemMeta(any_meta);

            ItemMeta him_meta = him.getItemMeta();
            him_meta.setDisplayName(ChatColor.WHITE + "Him");
            ArrayList<String> him_lore = new ArrayList<>();
            him_lore.add(ChatColor.YELLOW + "Click here to set \"Him\" as your 2nd pronoun");
            him_meta.setLore(him_lore);
            him.setItemMeta(him_meta);

            ItemMeta her_meta = her.getItemMeta();
            her_meta.setDisplayName(ChatColor.WHITE + "Her");
            ArrayList<String> her_lore = new ArrayList<>();
            her_lore.add(ChatColor.YELLOW + "Click here to set \"Her\" as your 2nd pronoun");
            her_meta.setLore(her_lore);
            her.setItemMeta(her_meta);

            ItemMeta them_meta = them.getItemMeta();
            them_meta.setDisplayName(ChatColor.WHITE + "Them");
            ArrayList<String> them_lore = new ArrayList<>();
            them_lore.add(ChatColor.YELLOW + "Click here to set \"Them\" as your 2nd pronoun");
            them_meta.setLore(them_lore);
            them.setItemMeta(them_meta);

            ItemMeta all_meta = all.getItemMeta();
            all_meta.setDisplayName(ChatColor.WHITE + "All");
            ArrayList<String> all_lore = new ArrayList<>();
            all_lore.add(ChatColor.YELLOW + "Click here to set \"All\" as your 2nd pronoun");
            all_meta.setLore(all_lore);
            all.setItemMeta(all_meta);

            ItemMeta blank_meta = blank.getItemMeta();
            blank_meta.setDisplayName("");
            blank.setItemMeta(blank_meta);

            ItemMeta close_meta = close.getItemMeta();
            close_meta.setDisplayName(ChatColor.RED + "Close Menu");
            close.setItemMeta(close_meta);

            ItemStack[] menu_items = {
                    blank, blank, blank, blank, blank, blank, blank, blank, blank,
                    blank, blank, he   , she  , blank, him  , her  , blank, blank,
                    blank, blank, they , any  , blank, them , all  , blank, blank,
                    blank, blank, blank, blank, close, blank, blank, blank, blank,
                    blank, blank, blank, blank, blank, blank, blank, blank, blank
            };
            gui.setContents(menu_items);

            player.openInventory(gui);
        }

        return true;
    }
}

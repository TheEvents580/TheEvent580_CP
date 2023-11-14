package fr.thefox580.theevent580.listeners;

import fr.thefox580.theevent580.main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeaveEvent implements Listener {

    private final main advMain;

    public onLeaveEvent(main advMain) {
        this.advMain = advMain;
    }

    @EventHandler
    public void playerLeavesEvent(PlayerQuitEvent event){
        event.setQuitMessage("");
        Player player = event.getPlayer();
        TextColor color = TextColor.color(255, 255, 255);
        Component component = Component.translatable("%nox_uuid%"+player.getUniqueId()+",true,0,-1,1","\uD83D\uDC64");


        if (player.hasPermission("group.spectators")){
            color = TextColor.color(85, 85, 85);
        }
        else if (player.hasPermission("group.rouge")) {
            color = TextColor.color(255, 85, 85);
        } else if (player.hasPermission("group.orange")) {
            color = TextColor.color(255, 170, 0);
        } else if (player.hasPermission("group.jaune")) {
            color = TextColor.color(255, 255, 85);
        } else if (player.hasPermission("group.vert")) {
            color = TextColor.color(85, 255, 85);
        } else if (player.hasPermission("group.bleu_clair")) {
            color = TextColor.color(85, 255, 255);
        } else if (player.hasPermission("group.bleu")) {
            color = TextColor.color(85, 85, 255);
        } else if (player.hasPermission("group.violet")) {
            color = TextColor.color(170, 0, 170);
        } else if (player.hasPermission("group.rose")) {
            color = TextColor.color(255, 85, 255);
        } else {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.hasPermission("theevent580.staff")) {
                    p.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Staff" + ChatColor.RESET + "] Player "
                            + player.getName() + "has left the server but isn't assigned to a color (1st time playing / New color not assigned ? / Server not whitelisted ?)");
                }
            }
        }
        Component message = Component.text('[')
                .append(Component.text('-', TextColor.color(255, 85, 85)))
                .append(Component.text("] ", TextColor.color(255, 255, 255)))
                .append(component)
                .append(Component.text(" "+player.getName(), color));
        advMain.adventure().players().sendMessage(message);
    }
}

package fr.thefox580.theevent580.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeaveEvent implements Listener {

    @EventHandler
    public void playerLeavesEvent(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("group.spectators")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ChatColor.DARK_GRAY +player.getName());
        }
        else if (player.hasPermission("group.rouge")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ChatColor.RED +player.getName());
        }
        else if (player.hasPermission("group.orange")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ ChatColor.GOLD +player.getName());
        }
        else if (player.hasPermission("group.jaune")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ ChatColor.YELLOW +player.getName());
        }
        else if (player.hasPermission("group.vert")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ ChatColor.GREEN +player.getName());
        }
        else if (player.hasPermission("group.bleu_clair")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ ChatColor.AQUA +player.getName());
        }
        else if (player.hasPermission("group.bleu")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ ChatColor.DARK_BLUE +player.getName());
        }
        else if (player.hasPermission("group.violet")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ ChatColor.DARK_PURPLE +player.getName());
        }
        else if (player.hasPermission("group.rose")){
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+ ChatColor.LIGHT_PURPLE +player.getName());
        }
        else{
            event.setQuitMessage("["+ ChatColor.RED +"-"+ChatColor.RESET +"] "+player.getName());
            for (Player p : Bukkit.getOnlinePlayers()){
                if (p.hasPermission("theevent580.staff")){
                    p.sendMessage("["+ChatColor.RED +ChatColor.BOLD +"TheEvent580 - Staff"+ChatColor.RESET +"] Player "
                            + player.getName() + "has left the server but isn't assigned to a color (1st time playing / New color not assigned ? / Server not whitelisted ?)");
                }
            }
        }

    }

}

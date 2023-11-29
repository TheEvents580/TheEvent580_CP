package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class getTotalPoints implements CommandExecutor {

    private final main plugin;
    private final main advMain;

    public getTotalPoints(main plugin) {
        this.plugin = plugin;
        this.advMain = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = Bukkit.getPlayer(strings[0]);
        if (player != null){
            if (player.isOnline()){
                long totalPointsPlayer = this.plugin.getConfig().getInt("total_points."+player.getUniqueId());

                if (commandSender instanceof Player){
                    Player sender = Bukkit.getPlayer(commandSender.getName());

                    TextColor color = TextColor.color(255, 255, 255); //Set color of text to white (base for if the player doesn't have a team)
                    Component component = Component.translatable("%nox_uuid%"+sender.getUniqueId()+",false,0,-1,1","\uD83D\uDC64"); //Setup custom player head


                    if (player.hasPermission("group.spectators")){ //If the player is a spectator
                        color = TextColor.color(85, 85, 85); //Set the color to dark gray

                    }
                    else if (player.hasPermission("group.rouge")) { //If the player is in red team
                        color = TextColor.color(255, 85, 85); //Set the color to red

                    }
                    else if (player.hasPermission("group.orange")) { //If the player is in orange team
                        color = TextColor.color(255, 170, 0); //Set the color to orange

                    }
                    else if (player.hasPermission("group.jaune")) { //If the player is in yellow team
                        color = TextColor.color(255, 255, 85); //Set the color to yellow

                    }
                    else if (player.hasPermission("group.vert")) { //If the player is in lime / green team
                        color = TextColor.color(85, 255, 85); //Set the color to lime / green

                    }
                    else if (player.hasPermission("group.bleu_clair")) { //If the player is in light blue team
                        color = TextColor.color(85, 255, 255); //Set the color to light blue

                    }
                    else if (player.hasPermission("group.bleu")) { //If the player is in blue team
                        color = TextColor.color(0, 0, 170); //Set the color to blue

                    }
                    else if (player.hasPermission("group.violet")) { //If the player is in purple team
                        color = TextColor.color(170, 0, 170); //Set the color to purple

                    }
                    else if (player.hasPermission("group.rose")) { //If the player is in pink team
                        color = TextColor.color(255, 85, 255); //Set the color to pink

                    }

                    advMain.adventure().player(sender).sendMessage(Component.text("Player ")
                            .append(component)
                            .append(Component.text(' ')
                            .append(Component.text(sender.getName(), TextColor.color(color))
                            .append(Component.text(" currently has " + totalPointsPlayer + " points", TextColor.color(255, 255, 255))))));
                }
                else {
                    commandSender.sendMessage("Player " + player.getName() + " currently has " + totalPointsPlayer + " points");
                }
            }
        }

        return true;
    }
}

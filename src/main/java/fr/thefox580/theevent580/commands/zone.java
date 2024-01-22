package fr.thefox580.theevent580.commands;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class zone implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {


        if (commandSender instanceof Player player) {

            double input_x;
            double input_y;
            double input_z;

            if (strings.length == 6) {
                input_x = Integer.parseInt(strings[4]);
                input_z = Integer.parseInt(strings[5]);
            } else {
                input_x = player.getLocation().getX();
                input_z = player.getLocation().getX();
            }


            int R = Integer.parseInt(strings[1]);
            int G = Integer.parseInt(strings[2]);
            int B = Integer.parseInt(strings[3]);

            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromBGR(B, G, R), 2.0F);

            int size = Integer.parseInt(strings[0]);

            for (int i = -60; i <= 300; i = i + 3){

                Location location = new Location(player.getWorld(), input_x, i, input_z);

                for (double i1 = 0; i1 <= Math.PI; i1 += Math.PI / 10) {
                    double radius = Math.sin(i1) * size;
                    for (double a = 0; a < Math.PI * 2; a+= Math.PI / 10) {
                        double x = Math.cos(a) * radius;
                        double z = Math.sin(a) * radius;
                        location.add(x, i, z);
                        player.getWorld().spawnParticle(Particle.REDSTONE, location, 10, dustOptions);
                        location.subtract(x, i, z);
                    }
                }

            }

        }

        return true;
    }
}

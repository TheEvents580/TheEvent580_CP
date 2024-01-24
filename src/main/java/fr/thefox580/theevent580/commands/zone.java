/* This command is deprecated for now.
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

            if (strings.length == 7) {
                input_x = Integer.parseInt(strings[4]);
                input_y = Integer.parseInt(strings[5]);
                input_z = Integer.parseInt(strings[6]);
            } else {
                input_x = player.getLocation().getX();
                input_y = player.getLocation().getY();
                input_z = player.getLocation().getZ();
            }

            input_y = Math.round(input_y);

            int R = Integer.parseInt(strings[1]);
            int G = Integer.parseInt(strings[2]);
            int B = Integer.parseInt(strings[3]);

            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromBGR(B, G, R), 4.0F);

            double radius = Integer.parseInt(strings[0]);

            for (double i = input_y - 20; i <= input_y + 50; i = i + 3){

                Location location = new Location(player.getWorld(), input_x, i, input_z);

                double a = Math.PI;

                for (double j = 0 ; j < 100; j++){

                    if (a <  -Math.PI/4) a = Math.PI;

                    double x = Math.cos(a) * radius;
                    double z = Math.sin(a) * radius;

                    a -= 0.1;

                    location.add(x, i, z);
                    player.getWorld().spawnParticle(Particle.REDSTONE, location, 3, dustOptions);
                    location.subtract(x, i, z);
                }


                //for (double a = -1; a < 1; a += 0.1) {

                //    double x = Math.cos(a) * radius;
                //    double z = Math.sin(a) * radius;

                //    location.add(x, i, z);
                //    player.getWorld().spawnParticle(Particle.REDSTONE, location, 3, dustOptions);
                //    location.subtract(x, i, z);
                //}
            }

        }
        return true;
    }
}
*/
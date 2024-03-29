package fr.thefox580.theevent580.listeners;

import fr.thefox580.theevent580.main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onMessage implements Listener {
    // Next 4 lines of code > Setting up Adventure

    private final main advMain;

    public onMessage(main advMain) {
        this.advMain = advMain;
    }

    @EventHandler
    public void onPlayerMessage(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String messageContent = event.getMessage();
        boolean bannedWordInMessage = isBannedWordInMessage(messageContent);
        FileConfiguration config = this.advMain.getConfig();

        Component componentPlayer = Component.translatable("%nox_uuid%" + player.getUniqueId() + ",false,0,-1,1", "\uD83D\uDC64"); //Setup custom player head
        TextColor colorPlayer = TextColor.color(255, 255, 255); //Set color of text to white (base for if the player doesn't have a team)
        String teamPlayer = "タ"; //Set the tag of the player's team

        if (player.hasPermission("group.spectator")){
            colorPlayer = TextColor.color(85, 85, 85); //Set color of text to red
            teamPlayer = "露"; //Set the tag of the player's team
        } else if (player.hasPermission("group.rouge")) { //If the player is in team red
            colorPlayer = TextColor.color(255, 85, 85); //Set color of text to red
            teamPlayer = "ラ"; //Set the tag of the player's team

        } else if (player.hasPermission("group.orange")) { //If the player is in team orange
            colorPlayer = TextColor.color(255, 170, 0); //Set color of text to orange
            teamPlayer = "ャ"; //Set the tag of the player's team

        } else if (player.hasPermission("group.jaune")) { //If the player is in team yellow
            colorPlayer = TextColor.color(255, 255, 85); //Set color of text to yellow
            teamPlayer = "ギ"; //Set the tag of the player's team

        } else if (player.hasPermission("group.vert")) { //If the player is in team lime / green
            colorPlayer = TextColor.color(85, 255, 85); //Set color of text to lime / green
            teamPlayer = "画"; //Set the tag of the player's team

        } else if (player.hasPermission("group.bleu_clair")) { //If the player is in team light blue
            colorPlayer = TextColor.color(85, 255, 255); //Set color of text to light blue
            teamPlayer = "動"; //Set the tag of the player's team

        } else if (player.hasPermission("group.bleu")) { //If the player is in team blue
            colorPlayer = TextColor.color(0, 0, 170); //Set color of text to blue
            teamPlayer = "像"; //Set the tag of the player's team

        } else if (player.hasPermission("group.violet")) { //If the player is in team purple
            colorPlayer = TextColor.color(170, 0, 170); //Set color of text to purple
            teamPlayer = "の"; //Set the tag of the player's team

        } else if (player.hasPermission("group.rose")) { //If the player is in team pink
            colorPlayer = TextColor.color(255, 85, 255); //Set color of text to pink
            teamPlayer = "目"; //Set the tag of the player's team
        }

        if (player.hasPermission("op")){
            teamPlayer += "リ"; //Set the tag of the player's team
        }

        if (bannedWordInMessage){

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.RED + "One word in your message is banned due to not being PG"));

        }

        else if (messageContent.equals(":skull:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('☠')).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":darkredlove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(170, 0, 0))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":redlove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(255, 85, 85))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":orangelove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(255, 170, 0))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":yellowlove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(255, 255, 85))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":limelove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(85, 255, 85))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":greenlove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(0, 170, 0))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":cyanlove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(0, 170, 170))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":lightbluelove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(85, 255, 255))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":bluelove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(85, 85, 255))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":darkbluelove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(0, 0, 170))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":purplelove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(170, 0, 170))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else if (messageContent.equals(":pinklove:")){

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text('❤', TextColor.color(255, 85, 255))).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }

        }

        else {

            String message = Component.text(teamPlayer, TextColor.color(255, 255, 255)) //Set custom message
                    .append(Component.text(' ')) //Set custom message
                    .append(componentPlayer) //Set custom message
                    .append(Component.text( ' ' + config.getString("pronoun_1." + player.getUniqueId()) + '/' + config.getString("pronoun_2." + player.getUniqueId())))
                    .append(Component.text(' ' + player.getName(), colorPlayer)) //Set custom message
                    .append(Component.text(" > ", TextColor.color(255, 255, 255))) //Set custom message
                    .append(Component.text(messageContent)).toBuilder().build().content(); //Set custom message

            for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                loopPlayer.sendMessage(message);
            }
        }

        //event.setMessage("");
        event.setCancelled(true);

    }

    private static boolean isBannedWordInMessage(String messageContent) {
        boolean bannedWordInMessage = false;
        int index = 0;

        String[] bannedWords = {"kys", "shit", "nigge", "fuck", "nigga", "nigger", "niggas", "niggers"}; //Set an Array with death messages

        for (int i = 0; i <= bannedWords.length - 1; i++) {

            if (messageContent.contains(bannedWords[i])) {
                bannedWordInMessage = true;
                index = i;
            }
        }
        return bannedWordInMessage;
    }
}

package fr.thefox580.theevent580.listeners;

import fr.thefox580.theevent580.main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

public class onDeathEvent implements Listener {
    private final main advMain;

    public onDeathEvent(main advMain) {
        this.advMain = advMain;
    }

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event){
        Player player = event.getEntity();
        event.setDeathMessage("");

        TextColor colorPlayer;

        if (player.hasPermission("group.rouge")) {
            colorPlayer = TextColor.color(255, 85, 85);
        } else if (player.hasPermission("group.orange")) {
            colorPlayer = TextColor.color(255, 170, 0);
        } else if (player.hasPermission("group.jaune")) {
            colorPlayer = TextColor.color(255, 255, 85);
        } else if (player.hasPermission("group.vert")) {
            colorPlayer = TextColor.color(85, 255, 85);
        } else if (player.hasPermission("group.bleu_clair")) {
            colorPlayer = TextColor.color(85, 255, 255);
        } else if (player.hasPermission("group.bleu")) {
            colorPlayer = TextColor.color(85, 85, 255);
        } else if (player.hasPermission("group.violet")) {
            colorPlayer = TextColor.color(170, 0, 170);
        } else if (player.hasPermission("group.rose")) {
            colorPlayer = TextColor.color(255, 85, 255);

        Component componentPlayer = Component.translatable("%nox_uuid%"+player.getUniqueId()+",true,0,-1,1","\uD83D\uDC64");

        if (player.getKiller() != null){
            Player killer = player.getKiller();
            Component componentKiller = Component.translatable("%nox_uuid%"+killer.getUniqueId()+",true,0,-1,1","\uD83D\uDC64");

            TextColor colorKiller;

            if (killer.hasPermission("group.rouge")) {
                colorKiller = TextColor.color(255, 85, 85);
            } else if (killer.hasPermission("group.orange")) {
                colorKiller = TextColor.color(255, 170, 0);
            } else if (killer.hasPermission("group.jaune")) {
                colorKiller = TextColor.color(255, 255, 85);
            } else if (killer.hasPermission("group.vert")) {
                colorKiller = TextColor.color(85, 255, 85);
            } else if (killer.hasPermission("group.bleu_clair")) {
                colorKiller = TextColor.color(85, 255, 255);
            } else if (killer.hasPermission("group.bleu")) {
                colorKiller = TextColor.color(85, 85, 255);
            } else if (killer.hasPermission("group.violet")) {
                colorKiller = TextColor.color(170, 0, 170);
            } else if (killer.hasPermission("group.rose")) {
                colorKiller = TextColor.color(255, 85, 255);

                Component message = getKillerPlayerComponent(componentPlayer, player, colorPlayer, componentKiller, killer, colorKiller);
                advMain.adventure().players().sendMessage(message);
        } else if (player.getLastDamageCause().getEntityType() != null){
                Component message = getKillerNonPlayerComponent(player, componentPlayer, colorPlayer);

                advMain.adventure().players().sendMessage(message);
                }
            }
        }
    }

    @NotNull
    private static Component getKillerPlayerComponent(Component componentPlayer, Player player, TextColor colorPlayer, Component componentKiller, Player killer, TextColor colorKiller) {
        return Component.text('[')
                .append(Component.text('☠', TextColor.color(255, 85, 85)))
                .append(Component.text("] ", TextColor.color(255, 255, 255)))
                .append(componentPlayer)
                .append(Component.text(" "+ player.getName(), colorPlayer))
                .append(Component.text(" was killed by ",TextColor.color(255, 255, 255)))
                .append(componentKiller)
                .append(Component.text(" "+ killer.getName(), colorKiller));
    }

    @NotNull
    private static Component getKillerNonPlayerComponent(Player player, Component componentPlayer, TextColor colorPlayer) {
        String killerEntity = player.getLastDamageCause().getEntityType().name();

        return Component.text('[')
                .append(Component.text('☠', TextColor.color(255, 85, 85)))
                .append(Component.text("] ", TextColor.color(255, 255, 255)))
                .append(componentPlayer)
                .append(Component.text(" "+ player.getName(), colorPlayer))
                .append(Component.text(" was killed by " + killerEntity,TextColor.color(255, 255, 255)));
    }
}


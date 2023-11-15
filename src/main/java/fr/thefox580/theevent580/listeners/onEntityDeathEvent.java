package fr.thefox580.theevent580.listeners;

import fr.thefox580.theevent580.main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class onEntityDeathEvent implements Listener {
    // Next 4 lines of code : Setting up Adventure

    private final main advMain;

    public onEntityDeathEvent(main advMain) {
        this.advMain = advMain;
    }

    @EventHandler
    public void entityDeathEvent(EntityDeathEvent event){ //On entity death
        LivingEntity victim = event.getEntity(); //Get what is the victim
        if (victim instanceof Player){ //If the victim is a player

            TextColor colorVictim = TextColor.color(255, 255, 255); //Set color of text to white (base for if the player doesn't have a team)

            if (victim.hasPermission("group.rouge")) { //If the player is in team red
                colorVictim = TextColor.color(255, 85, 85); //Set color of text to red

            } else if (victim.hasPermission("group.orange")) { //If the player is in team orange
                colorVictim = TextColor.color(255, 170, 0); //Set color of text to orange

            } else if (victim.hasPermission("group.jaune")) { //If the player is in team yellow
                colorVictim = TextColor.color(255, 255, 85); //Set color of text to yellow

            } else if (victim.hasPermission("group.vert")) { //If the player is in team lime / green
                colorVictim = TextColor.color(85, 255, 85); //Set color of text to lime / green

            } else if (victim.hasPermission("group.bleu_clair")) { //If the player is in team light blue
                colorVictim = TextColor.color(85, 255, 255); //Set color of text to light blue

            } else if (victim.hasPermission("group.bleu")) { //If the player is in team blue
                colorVictim = TextColor.color(85, 85, 255); //Set color of text to blue

            } else if (victim.hasPermission("group.violet")) { //If the player is in team purple
                colorVictim = TextColor.color(170, 0, 170); //Set color of text to purple

            } else if (victim.hasPermission("group.rose")) { //If the player is in team pink
                colorVictim = TextColor.color(255, 85, 255); //Set color of text to pink
            }
            Component componentVictim = Component.translatable("%nox_uuid%"+victim.getUniqueId()+",true,0,-1,1","\uD83D\uDC64"); //Setup custom victim head

            EntityDamageEvent.DamageCause killerCause = event.getEntity().getLastDamageCause().getCause(); //Get the cause of death
            EntityType killerType = event.getEntity().getLastDamageCause().getEntityType(); //Get the Entity who killed the player

            if (killerCause == EntityDamageEvent.DamageCause.ENTITY_ATTACK){ //If the attack type is a punch - normal attack
                if (killerType == EntityType.PLAYER){ // If the killer is a Player

                    Player killerPlayer = event.getEntity().getKiller(); //Get the player

                    Component componentKiller = Component.translatable("%nox_uuid%"+killerPlayer.getUniqueId()+",false,0,-1,1","\uD83D\uDC64"); //Setup custom killer head
                    TextColor colorKiller = TextColor.color(255, 255, 255); //Set color of text to white (base for if the player doesn't have a team)

                    if (killerPlayer.hasPermission("group.rouge")) { //If the player is in team red
                        colorKiller = TextColor.color(255, 85, 85); //Set color of text to red
                    }
                    else if (killerPlayer.hasPermission("group.orange")) { //If the player is in team orange
                        colorKiller = TextColor.color(255, 170, 0); //Set color of text to orange
                    }
                    else if (killerPlayer.hasPermission("group.jaune")) { //If the player is in team yellow
                        colorKiller = TextColor.color(255, 255, 85); //Set color of text to yellow
                    }
                    else if (killerPlayer.hasPermission("group.vert")) { //If the player is in team lime / green
                        colorKiller = TextColor.color(85, 255, 85); //Set color of text to lime / green
                    }
                    else if (killerPlayer.hasPermission("group.bleu_clair")) { //If the player is in team light blue
                        colorKiller = TextColor.color(85, 255, 255); //Set color of text to light blue
                    }
                    else if (killerPlayer.hasPermission("group.bleu")) { //If the player is in team blue
                        colorKiller = TextColor.color(85, 85, 255); //Set color of text to blue
                    }
                    else if (killerPlayer.hasPermission("group.violet")) { //If the player is in team purple
                        colorKiller = TextColor.color(170, 0, 170); //Set color of text to purple
                    }
                    else if (killerPlayer.hasPermission("group.rose")) { //If the player is in team pink
                        colorKiller = TextColor.color(255, 85, 255); //Set color of text to pink
                    }

                    Component message = Component.text('[') //Setup custom death message
                            .append(Component.text('☠', TextColor.color(255, 85, 85))) /* ☠ */
                            .append(Component.text("] ", TextColor.color(255, 255, 255))) //I mean
                            .append(componentVictim) //Add custom victim head to message
                            .append(Component.text(' '+ victim.getName(), colorVictim)) //Add victim's name
                            .append(Component.text(" was killed by ",TextColor.color(255, 255, 255))) //Do I need to explain what this does ?
                            .append(componentKiller) //Add custom killer head to message
                            .append(Component.text(' '+ killerPlayer.getName(), colorKiller)); //Add killer's name
                    advMain.adventure().players().sendMessage(message); //Send message
                }
                else { //Else if it's not a player (mob)

                    String killerEntity = event.getEntity().getLastDamageCause().getEntityType().name(); //Get the name of the entity who killed the player

                    Component message = Component.text('[') //Setup custom death message
                            .append(Component.text('☠', TextColor.color(255, 85, 85))) /* ☠ */
                            .append(Component.text("] ", TextColor.color(255, 255, 255))) //I mean
                            .append(componentVictim) //Add custom victim head to message
                            .append(Component.text(' '+ victim.getName(), colorVictim)) //Add victim's name
                            .append(Component.text(" was killed by ",TextColor.color(255, 255, 255))) //Do I need to explain what this does ?
                            .append(Component.text(killerEntity)); //Add mob's name
                    advMain.adventure().players().sendMessage(message); //Send message
                }
            }
            else if (killerCause == EntityDamageEvent.DamageCause.PROJECTILE) { //If the attack type is a projectile (arrow...)
                if (killerType == EntityType.PLAYER){ // If the killer is a Player

                    Player killerPlayer = event.getEntity().getKiller(); //Get the player

                    Component componentKiller = Component.translatable("%nox_uuid%"+killerPlayer.getUniqueId()+",false,0,-1,1","\uD83D\uDC64"); //Setup custom killer head
                    TextColor colorKiller = TextColor.color(255, 255, 255); //Set color of text to white (base for if the player doesn't have a team)

                    if (killerPlayer.hasPermission("group.rouge")) { //If the player is in team red
                        colorKiller = TextColor.color(255, 85, 85); //Set color of text to red
                    }
                    else if (killerPlayer.hasPermission("group.orange")) { //If the player is in team orange
                        colorKiller = TextColor.color(255, 170, 0); //Set color of text to orange
                    }
                    else if (killerPlayer.hasPermission("group.jaune")) { //If the player is in team yellow
                        colorKiller = TextColor.color(255, 255, 85); //Set color of text to yellow
                    }
                    else if (killerPlayer.hasPermission("group.vert")) { //If the player is in team lime / green
                        colorKiller = TextColor.color(85, 255, 85); //Set color of text to lime / green
                    }
                    else if (killerPlayer.hasPermission("group.bleu_clair")) { //If the player is in team light blue
                        colorKiller = TextColor.color(85, 255, 255); //Set color of text to light blue
                    }
                    else if (killerPlayer.hasPermission("group.bleu")) { //If the player is in team blue
                        colorKiller = TextColor.color(85, 85, 255); //Set color of text to blue
                    }
                    else if (killerPlayer.hasPermission("group.violet")) { //If the player is in team purple
                        colorKiller = TextColor.color(170, 0, 170); //Set color of text to purple
                    }
                    else if (killerPlayer.hasPermission("group.rose")) { //If the player is in team pink
                        colorKiller = TextColor.color(255, 85, 255); //Set color of text to pink
                    }

                    Component message = Component.text('[') //Setup custom death message
                            .append(Component.text('☠', TextColor.color(255, 85, 85))) /* ☠ */
                            .append(Component.text("] ", TextColor.color(255, 255, 255))) //I mean
                            .append(componentVictim) //Add custom victim head to message
                            .append(Component.text(' '+ victim.getName(), colorVictim)) //Add victim's name
                            .append(Component.text(" was shot by ",TextColor.color(255, 255, 255))) //Do I need to explain what this does ?
                            .append(componentKiller) //Add custom killer head to message
                            .append(Component.text(' '+ killerPlayer.getName(), colorKiller)); //Add killer's name
                    advMain.adventure().players().sendMessage(message); //Send message
                }
                else { //Else if it's not a player (mob)

                    String killerEntity = event.getEntity().getLastDamageCause().getEntityType().name(); //Get the name of the entity who killed the player

                    Component message = Component.text('[') //Setup custom death message
                            .append(Component.text('☠', TextColor.color(255, 85, 85))) /* ☠ */
                            .append(Component.text("] ", TextColor.color(255, 255, 255))) //I mean
                            .append(componentVictim) //Add custom victim head to message
                            .append(Component.text(' '+ victim.getName(), colorVictim)) //Add victim's name
                            .append(Component.text(" was shot by ",TextColor.color(255, 255, 255))) //Do I need to explain what this does ?
                            .append(Component.text(killerEntity)); //Add mob's name
                    advMain.adventure().players().sendMessage(message); //Send message
                }
            }
            else if (killerCause == EntityDamageEvent.DamageCause.VOID){ //If the attack type is the void

                    Component message = Component.text('[') //Setup custom death message
                            .append(Component.text('☠', TextColor.color(255, 85, 85))) /* ☠ */
                            .append(Component.text("] ", TextColor.color(255, 255, 255))) //I mean
                            .append(componentVictim) //Add custom victim head to message
                            .append(Component.text(' '+ victim.getName(), colorVictim)) //Add victim's name
                            .append(Component.text(" fell out of the world",TextColor.color(255, 255, 255))); //Do I need to explain what this does ?
                    advMain.adventure().players().sendMessage(message); //Send message
            }
            else if (killerCause == EntityDamageEvent.DamageCause.FALL) { //If the attack type is fall damage

                Component message = Component.text('[') //Setup custom death message
                        .append(Component.text('☠', TextColor.color(255, 85, 85))) /* ☠ */
                        .append(Component.text("] ", TextColor.color(255, 255, 255))) //I mean
                        .append(componentVictim) //Add custom victim head to message
                        .append(Component.text(' '+ victim.getName(), colorVictim)) //Add victim's name
                        .append(Component.text(" fell from too high",TextColor.color(255, 255, 255))); //Do I need to explain what this does ?
                advMain.adventure().players().sendMessage(message); //Send message

            }
        }
    }
}

package gg.alexav.sharedInventory;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Collection;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String playerName = event.getPlayer().getName();
        SharedInventory.getPluginLogger().info("Player died! " + playerName);
        Component message = Component.text(playerName + " has died! Farewell inventories..").color(NamedTextColor.RED);
        Bukkit.broadcast(message);

        // clear player inventories
        Collection<? extends Player> allPlayers = Bukkit.getServer().getOnlinePlayers();
        allPlayers.forEach((player) -> {
           player.getInventory().clear();
        });
    }
}

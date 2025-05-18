package gg.alexav.sharedInventory;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SharedInventory extends JavaPlugin {
    private static Logger pluginLogger;

    @Override
    public void onEnable() {
        // logger
        pluginLogger = getLogger();

        // register events
        getServer().getPluginManager().registerEvents(new DeathListener(), this);

        // loggies
        getLogger().info("SharedInventory plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("SharedInventory plugin disabled");
    }

    public static Logger getPluginLogger() {
        return pluginLogger;
    }
}

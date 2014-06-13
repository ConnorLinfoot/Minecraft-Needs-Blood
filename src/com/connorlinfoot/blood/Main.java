package com.connorlinfoot.blood;

import com.connorlinfoot.blood.Commands.BloodCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;


public class Main extends JavaPlugin implements Listener {
    private static Plugin instance;

    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        if(getConfig().getString( "Send Stats" ).equals("enabled" ) ) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
                console.sendMessage("MC Stats (Metrics) is enabled!");
            } catch (IOException e) {
                // Failed to submit the stats :-( <-- Dat face doe
            }
        }
        Bukkit.getPluginManager().registerEvents(new OnDamage(), this);
        getCommand("blood").setExecutor(new BloodCommand()); // /blood command
        getCommand("b").setExecutor(new BloodCommand()); // /b command


        console.sendMessage(ChatColor.GREEN + "====== Minecraft Needs Blood! ======");
        console.sendMessage(ChatColor.GREEN + "=========== VERSION: 3.0 ===========");
        console.sendMessage(ChatColor.GREEN + "======== BY CONNOR LINFOOT! ========");
    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getInstance() {
        return instance;
    }
}

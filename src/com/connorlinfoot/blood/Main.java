package com.connorlinfoot.blood;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
    public void onEnable() {
        Server server = getServer();

        ConsoleCommandSender console = server.getConsoleSender();
        console.sendMessage(ChatColor.GREEN + "====== Minecraft Needs Blood! ======");
        console.sendMessage(ChatColor.GREEN + "=========== VERSION: 1.0 ===========");
        console.sendMessage(ChatColor.GREEN + "======== BY CONNOR LINFOOT! ========");
        Bukkit.getPluginManager().registerEvents(new OnDamage(), this);

    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }
}

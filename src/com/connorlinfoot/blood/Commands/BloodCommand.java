package com.connorlinfoot.blood.Commands;

import com.connorlinfoot.blood.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class BloodCommand implements CommandExecutor {
        private Plugin instance = Main.getInstance();

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (label.equalsIgnoreCase("blood") || label.equalsIgnoreCase("b")) {
                if( args.length == 0 ){
                    sender.sendMessage("==== Minecraft Needs Blood ====");
                    sender.sendMessage("========= Version 3.0 =========");
                    if( sender.hasPermission("blood.toggle") ) sender.sendMessage("/blood <on/off> - Enables or Disables Blood");
                    if( sender.hasPermission("blood.old") ) sender.sendMessage("/blood old <on/off> - Enables or Disables Old Style Blood");
                    if( sender.hasPermission("blood.reload") ) sender.sendMessage("/blood reload - Reload Minecraft Needs Blood Config");
                } else {
                    if (args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("enable")) {
                        if (sender.hasPermission("blood.toggle")) {
                            // Enable Blood Here
                            instance.getConfig().set("Blood Enabled", "true");
                            instance.saveConfig();
                            sender.sendMessage("Blood has been enabled!");
                        }
                    } else if (args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("disable")) {
                        if (sender.hasPermission("blood.toggle")) {
                            // Disable Blood Here
                            instance.getConfig().set("Blood Enabled", "false");
                            instance.saveConfig();
                            sender.sendMessage("Blood has been disabled!");
                        }
                    }else if( args[0].equalsIgnoreCase("reload")){
                        if(sender.hasPermission("blood.reload")) {
                            instance.reloadConfig();
                            instance.saveConfig();
                            sender.sendMessage("Config Reloaded!");
                        }
                    } else if( args.length == 2) {
                        if( args[0].equalsIgnoreCase("old") ) {
                            if (args[1].equalsIgnoreCase("on") || args[1].equalsIgnoreCase("enable")) {
                                if(sender.hasPermission("blood.old")) {
                                    // Enable Blood Here
                                    instance.getConfig().set("Old Blood", "true");
                                    instance.saveConfig();
                                    sender.sendMessage("Old style blood has been enabled!");
                                }
                            } else if (args[1].equalsIgnoreCase("off") || args[1].equalsIgnoreCase("disable")) {
                                if(sender.hasPermission("blood.old")) {
                                    // Disable Blood Here
                                    instance.getConfig().set("Old Blood", "false");
                                    instance.saveConfig();
                                    sender.sendMessage("Old style blood has been disabled!");
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
}

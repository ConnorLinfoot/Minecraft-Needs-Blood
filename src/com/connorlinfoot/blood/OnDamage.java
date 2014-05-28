package com.connorlinfoot.blood;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class OnDamage implements Listener {
    Plugin instance = Main.getInstance();

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        Entity entity = e.getEntity();
        EntityType etype = entity.getType();
        String all = instance.getConfig().getString("Entitys.All");
        String allow = "false";
        String worldallow = "false";
        if( instance.getConfig().getString("Worlds").equalsIgnoreCase("all") )
            worldallow = "true";
        String world =  entity.getWorld().getName();
        String currentworld = instance.getConfig().getString("Worlds");
        List<String> worldList = Arrays.asList(currentworld.split(","));
        if(worldList.contains(world))
            worldallow = "true";

        if(worldallow.equals("true")) {
            if (all.equals("true")) allow = "true";

            if (etype == EntityType.BAT && instance.getConfig().getString("Entitys.Bat").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.BLAZE && instance.getConfig().getString("Entitys.Blaze").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.CAVE_SPIDER && instance.getConfig().getString("Entitys.Cave Spider").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.CHICKEN && instance.getConfig().getString("Entitys.Chicken").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.COW && instance.getConfig().getString("Entitys.Cow").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.CREEPER && instance.getConfig().getString("Entitys.Creeper").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.ENDERMAN && instance.getConfig().getString("Entitys.Enderman").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.GHAST && instance.getConfig().getString("Entitys.Ghast").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.GIANT && instance.getConfig().getString("Entitys.Giant").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.HORSE && instance.getConfig().getString("Entitys.Horse").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.IRON_GOLEM && instance.getConfig().getString("Entitys.Iron Golem").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.MAGMA_CUBE && instance.getConfig().getString("Entitys.Magma Cube").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.MUSHROOM_COW && instance.getConfig().getString("Entitys.Mushroom Cow").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.OCELOT && instance.getConfig().getString("Entitys.Ocelot").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.PIG && instance.getConfig().getString("Entitys.Pig").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.PLAYER && instance.getConfig().getString("Entitys.Player").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.SHEEP && instance.getConfig().getString("Entitys.Sheep").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.SILVERFISH && instance.getConfig().getString("Entitys.Silverfish").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.SKELETON && instance.getConfig().getString("Entitys.Skeleton").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.SLIME && instance.getConfig().getString("Entitys.Slime").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.SNOWMAN && instance.getConfig().getString("Entitys.Snowman").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.SPIDER && instance.getConfig().getString("Entitys.Spider").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.SQUID && instance.getConfig().getString("Entitys.Squid").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.VILLAGER && instance.getConfig().getString("Entitys.Villager").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.WITCH && instance.getConfig().getString("Entitys.Witch").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.WITHER && instance.getConfig().getString("Entitys.Wither").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.WOLF && instance.getConfig().getString("Entitys.Wolf").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.ZOMBIE && instance.getConfig().getString("Entitys.Zombie").equalsIgnoreCase("true"))
                allow = "true";
            if (etype == EntityType.PIG_ZOMBIE && instance.getConfig().getString("Entitys.Zombie Pigman").equalsIgnoreCase("true"))
                allow = "true";

            if (allow.equals("true")) {
                Location loc = entity.getLocation();
                Effect effect = Effect.STEP_SOUND;
                e.getEntity().getLocation().getWorld().playEffect(loc.add(0, 1, 0), effect, 152);
            }
        }
    }
}

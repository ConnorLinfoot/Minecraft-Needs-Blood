package com.connorlinfoot.blood;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class OnDamage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        //getServer().broadcastMessage("Ouch!");
        Entity entity = e.getEntity();
        Location loc = entity.getLocation();
        Effect effect = Effect.STEP_SOUND;
        e.getEntity().getLocation().getWorld().playEffect(loc.add(0, 1, 0), effect, 152);
    }
}

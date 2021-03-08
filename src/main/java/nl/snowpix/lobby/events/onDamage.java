package nl.snowpix.lobby.events;

import nl.snowpix.lobby.Lobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class onDamage implements Listener {

    @EventHandler
    public void OnPlayerDamage(EntityDamageEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

}

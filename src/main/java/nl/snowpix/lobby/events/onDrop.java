package nl.snowpix.lobby.events;

import nl.snowpix.lobby.Lobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class onDrop implements Listener {

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemPickUp(EntityPickupItemEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

}

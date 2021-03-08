package nl.snowpix.lobby.events;

import nl.snowpix.lobby.Lobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class onHungerChange implements Listener {

    @EventHandler
    public void PlayerHungerChange(FoodLevelChangeEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

}

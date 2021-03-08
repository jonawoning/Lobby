package nl.snowpix.lobby.events;

import nl.snowpix.lobby.Lobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class onLeafDecay implements Listener {

    @EventHandler
    private void OnLeafDecay(LeavesDecayEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

}

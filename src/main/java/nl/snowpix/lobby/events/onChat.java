package nl.snowpix.lobby.events;

import me.clip.placeholderapi.PlaceholderAPI;
import nl.snowpix.lobby.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChat implements Listener {

    @EventHandler
    private void OnPlayerChatEvent(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        if (Lobby.instance.getCConfig().ChatSystem){
            e.setFormat(Lobby.instance.getCConfig().Chat_Format.replace("%player_prefix%", PlaceholderAPI.setPlaceholders(player, "%vault_prefix%")));
        }
    }

}

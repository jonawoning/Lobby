package nl.snowpix.lobby.methods;

import nl.snowpix.lobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class ExtraMethods {

    public static void JoinMessage(Player player) {
        List<String> message = Lobby.instance.c.getStringList("JoinMessage");
        for(String messaga : message){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messaga));
        }
    }

}

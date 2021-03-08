package nl.snowpix.lobby.methods;

import nl.snowpix.lobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class BungeeCord {

    public static void sendPlayerToServer(Player player, String server) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(server);
            player.sendPluginMessage(Lobby.instance, "BungeeCord", b.toByteArray());
            b.close();
            out.close();
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.RED+"Error when trying to connect to "+server);
        }
    }



}

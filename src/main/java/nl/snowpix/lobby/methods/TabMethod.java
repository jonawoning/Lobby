package nl.snowpix.lobby.methods;

import com.nametagedit.plugin.NametagEdit;
import me.clip.placeholderapi.PlaceholderAPI;
import nl.snowpix.lobby.Lobby;
import org.bukkit.entity.Player;

public class TabMethod {

    public static void CheckTabPlayer(Player player){
        if (Lobby.instance.getCConfig().Use_TabPrefix){
            String PlayerPrefix = PlaceholderAPI.setPlaceholders(player, "%vault_prefix%");
            String TabPrefix = Lobby.instance.getCConfig().Tab_Format.replace("%player_prefix%", PlayerPrefix);
            NametagEdit.getApi().setNametag(player, TabPrefix, null);
        }
    }

}

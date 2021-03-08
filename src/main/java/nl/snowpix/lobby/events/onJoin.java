package nl.snowpix.lobby.events;

import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.api.ScoreBoard;
import nl.snowpix.lobby.methods.ExtraMethods;
import nl.snowpix.lobby.methods.TabMethod;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class onJoin implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.teleport(Lobby.instance.getCConfig().serverspawn);
        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.SURVIVAL);
        TabMethod.CheckTabPlayer(player);
        e.setJoinMessage(Lobby.instance.getCConfig().Join_Message.replace("%player%", player.getName()));
        ItemStack is2 = new ItemStack(Material.BOOK, 1);
        ItemMeta meta2 = is2.getItemMeta();
        meta2.setDisplayName("§8> §eServer Selector");
        is2.setItemMeta(meta2);
        player.getInventory().setItem(4, is2);
        player.getInventory().setItem(5, new ItemStack(Material.SNOW_BALL, 1));
        ExtraMethods.JoinMessage(player);
        if (!player.hasPermission(Lobby.instance.getCConfig().Staff_Perm)){
            for (int i = 0; i < Lobby.instance.getCConfig().staffmode.size(); i++ ){
                player.hidePlayer(Lobby.instance, Lobby.instance.getCConfig().staffmode.get(i));
            }
        }
        if (Lobby.instance.getCConfig().Use_Scoreboard){
            ScoreBoard.scoreboardcreatep(player);
        }
    }

}

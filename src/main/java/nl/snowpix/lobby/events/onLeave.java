package nl.snowpix.lobby.events;

import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.api.ScoreBuilder;
import nl.snowpix.lobby.commands.Fly;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeave implements Listener {

    @EventHandler
    private void onPlayerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        e.setQuitMessage(Lobby.instance.getCConfig().Leave_Message.replace("%player%", player.getName()));
        if (Lobby.instance.getCConfig().Use_Scoreboard){
            ScoreBuilder.removeScore(player);
        }
        onClick.cooldownsnowball.remove(player);
        Fly.fly_mode.remove(player);
        Lobby.instance.getCConfig().staffmode.remove(player);

    }

}

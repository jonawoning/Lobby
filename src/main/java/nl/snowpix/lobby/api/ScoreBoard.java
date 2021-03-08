package nl.snowpix.lobby.api;

import me.clip.placeholderapi.PlaceholderAPI;
import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.system.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.List;

public class ScoreBoard {

    public static void SBLOOPENABLE(){
        if (Lobby.instance.getCConfig().Use_Scoreboard){
            ScoreBoardLoop();
        }
    }

    public static void ScoreBoardLoop() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ScoreBuilder api = ScoreBuilder.getByPlayer(player);
                    if (ScoreBuilder.hasScore(player)) {
                        api.setTitle(Lobby.instance.getCConfig().Lobby_Scoreboard_Title);
                        List<String> Board = Lobby.instance.c.getStringList("Lobby_Scoreboard_Lines");
                        String onlineBungee = PlaceholderAPI.setPlaceholders(player, "%bungee_total%");
                        String Server_1 = PlaceholderAPI.setPlaceholders(player, "%bungee_"+ Lobby.instance.getCConfig().Server1 + "%");
                        String Server_2 = PlaceholderAPI.setPlaceholders(player, "%bungee_"+ Lobby.instance.getCConfig().Server2 + "%");
                        String Server_3 = PlaceholderAPI.setPlaceholders(player, "%bungee_"+ Lobby.instance.getCConfig().Server3 + "%");
                        String PlayerPing = PlaceholderAPI.setPlaceholders(player, "%player_ping%");
                        String PlayerPrefix = PlaceholderAPI.setPlaceholders(player, "%vault_prefix%");
                        int i = 1;
                        Collections.reverse(Board);
                        for (String string : Board) {
                            ChatColor.translateAlternateColorCodes('&', string);
                            String line = string.
                                    replace("%online%", String.valueOf(Bukkit.getOnlinePlayers().size())).
                                    replace("%bungee_total%", onlineBungee).
                                    replace("%player_name%", player.getName()).
                                    replace("%ping%", PlayerPing).
                                    replace("%player_prefix%", PlayerPrefix).
                                    replace("%Server1%", Server_1).
                                    replace("%Server2%", Server_2).
                                    replace("%Server3%", Server_3).
                                    replace("%prefix%", Lobby.instance.getCConfig().Prefix);
                            api.setSlot(i, line);
                            i++;
                        }

                    }
                }
            }
        }.runTaskTimerAsynchronously(Lobby.instance, 0L, 1L);
    }



    public static void scoreboardcreatep(Player player){
        if (ScoreBuilder.hasScore(player)){
            ScoreBuilder.removeScore(player);
        }else{
            ScoreBuilder.createScore(player);
        }
    }

}

package nl.snowpix.lobby.methods;

import nl.snowpix.lobby.Lobby;
import org.bukkit.Bukkit;

import java.io.File;

public class WorldReset {

    public static void WorldReset(){
        File file = new File("plugins//Lobby//" + Lobby.instance.getCConfig().World + "//spawns.yml");
        if (file.exists()){
            Bukkit.getWorld(Lobby.instance.getCConfig().World).setTime(6000L);
            Bukkit.getWorld(Lobby.instance.getCConfig().World).setGameRuleValue("doDaylightCycle", "false");
            Bukkit.getWorld(Lobby.instance.getCConfig().World).setStorm(false);
            Bukkit.getWorld(Lobby.instance.getCConfig().World).setGameRuleValue("doWeatherChange", "false");
            Bukkit.getWorld(Lobby.instance.getCConfig().World).setGameRuleValue("announceAdvancements", "false");
        }
    }

}

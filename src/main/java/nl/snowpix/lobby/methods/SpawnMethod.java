package nl.snowpix.lobby.methods;

import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.system.SystemColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SpawnMethod {

    public static void setSpawn(String spawnname, Player player){
            String wereldnaam = player.getLocation().getWorld().getName();
            if (wereldnaam.equalsIgnoreCase(Lobby.instance.getCConfig().World)){
                    SetspawnListener("lobby", Lobby.instance.getCConfig().World, player);
                }else {
                player.sendMessage(ChatColor.RED + "ERROR, this world is not the world like in the config!");
            }
        }


    public static void onEnableRLSP(String worldname){
        File file = new File("plugins//Lobby//" + worldname + "//spawns.yml");
        if (file.exists()){
            Bukkit.getWorld(worldname).setGameRuleValue("doWeatherChange", "false");
            Bukkit.getWorld(worldname).setGameRuleValue("announceAdvancements", "false");
            ReloadAllSpawns(worldname);
            System.out.println( SystemColors.TEXT_YELLOW + "[Lobby] " + SystemColors.TEXT_GREEN + "The spawns are succesfully loaded. World: " + Lobby.instance.getCConfig().World + SystemColors.TEXT_RESET);
        }else{
            System.out.println("!");
            System.out.println( SystemColors.TEXT_YELLOW + "[Lobby] " + SystemColors.TEXT_RED + "WARN! You need to set the spawn in the world " + Lobby.instance.getCConfig().World + SystemColors.TEXT_RESET);
            System.out.println("!");
        }
    }

    public static void ReloadAllSpawns(String worldname){
        RLSpawnLobby(worldname);
        if (worldname.equalsIgnoreCase(Lobby.instance.getCConfig().World)){
            System.out.println( SystemColors.TEXT_YELLOW + "[Lobby] " + SystemColors.TEXT_GREEN + "The spawns are succesfully loaded. World: " + Lobby.instance.getCConfig().World + SystemColors.TEXT_RESET);
        }
    }

    public static void ReloadSpawn(String spawnname, String worldname){
        if (spawnname.equalsIgnoreCase("lobby")){
            RLSpawnLobby(worldname);
        }


    }

    public static void RLSpawnLobby(String worldname) {
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(new File("plugins//Lobby//" + worldname + "//", "spawns.yml"));
        Lobby.instance.getCConfig().serverspawn = new Location(Bukkit.getWorld(cfg.getString("Spawns.lobby.Wereldnaam")), cfg.getDouble("Spawns.lobby.X"), cfg.getDouble("Spawns.lobby.Y"), cfg.getDouble("Spawns.lobby.Z"), (float)cfg.getDouble("Spawns.lobby.Yaw"), (float)cfg.getDouble("Spawns.lobby.Pitch"));
    }


    public static void SetspawnListener(String spawn,String worldname, Player player){
        String wereldnaam = player.getLocation().getWorld().getName();
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(new File("plugins//Lobby//" + worldname + "//", "spawns.yml"));
        File file = new File("plugins//Lobby//" + worldname + "//spawns.yml");
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        double yaw = player.getLocation().getYaw();
        double pitch = player.getLocation().getPitch();
        cfg.set("Spawns." + spawn + ".X", x);
        cfg.set("Spawns." + spawn + ".Y", y);
        cfg.set("Spawns." + spawn + ".Z", z);
        cfg.set("Spawns." + spawn + ".Yaw", yaw);
        cfg.set("Spawns." + spawn + ".Pitch", pitch);
        cfg.set("Spawns." + spawn + ".Wereldnaam", worldname);
        player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.GREEN +"You succesfully changed the spawn of §2" + spawn + "§a! - " + wereldnaam);
        try {
            cfg.save(file);
        } catch (IOException e){
            e.printStackTrace();
        }
        ReloadSpawn(spawn, worldname);
    }

}

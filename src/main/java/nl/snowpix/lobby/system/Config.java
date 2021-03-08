package nl.snowpix.lobby.system;

import me.clip.placeholderapi.PlaceholderAPI;
import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.commands.Fly;
import nl.snowpix.lobby.events.onClick;
import nl.snowpix.lobby.methods.ExtraMethods;
import nl.snowpix.lobby.methods.SpawnMethod;
import nl.snowpix.lobby.methods.WorldReset;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Config {

    public String Prefix;
    public String Lobby_Scoreboard_Title;
    public boolean ChatSystem;
    public String Chat_Format;
    public String Join_Message;
    public String Leave_Message;
    public String Server1;
    public String Server2;
    public String Server3;
    public String World;
    public boolean AntiBuild;
    public String Donator_Perm;
    public String Staff_Perm;
    public String Admin_Perm;
    public boolean Use_Scoreboard;
    public boolean Use_TabPrefix;
    public String Tab_Format;
    public String Item1_Display;
    public int Item1_Slot;
    public List<String> Item1_Lore;
    public Material Item1_Item;
    public String Item1_Server;
    public String Item2_Display;
    public int Item2_Slot;
    public Material Item2_Item;
    public String Item2_Server;
    public List<String> Item2_Lore;
    public ArrayList<Player> staffmode = new ArrayList<>();
    public Location serverspawn = new Location(Bukkit.getServer().getWorlds().get(0), 0, 5, 0);

    public void ReloadConfig(){
        ReloadConfigData();
        Lobby.instance.reloadConfig();
        Lobby.instance.getConfig().options().copyDefaults();
        Lobby.instance.saveDefaultConfig();
    }

    private void ReloadConfigData(){
        Prefix = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Prefix"));
        Lobby_Scoreboard_Title = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Lobby_Scoreboard_Title"));
        ChatSystem = Lobby.instance.c.getBoolean("Chat_System");
        Chat_Format = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Chat_Format"));
        Join_Message = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Join_Message"));
        Leave_Message = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Leave_Message"));
        Server1 = Lobby.instance.c.getString("Server1");
        Server2 = Lobby.instance.c.getString("Server2");
        Server3 = Lobby.instance.c.getString("Server3");
        World = Lobby.instance.c.getString("World");
        Donator_Perm = Lobby.instance.c.getString("Donator_Perm");
        Staff_Perm = Lobby.instance.c.getString("Staff_Perm");
        Admin_Perm = Lobby.instance.c.getString("Admin_Perm");
        Use_Scoreboard = Lobby.instance.c.getBoolean("Use_Scoreboard");
        Use_TabPrefix = Lobby.instance.c.getBoolean("Use_TabPrefix");
        Tab_Format = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Tab_Format"));
        staffmode.clear();
        Fly.fly_mode.clear();
        onClick.cooldownsnowball.clear();
        WorldReset.WorldReset();
        SpawnMethod.onEnableRLSP(World);
        AntiBuild = true;
        LoadguiItems();

    }

    private void LoadguiItems(){
        Item1_Display = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Item1_Display"));
        Item1_Slot = Lobby.instance.c.getInt("Item1_Slot");
        Item1_Item = Material.valueOf(Lobby.instance.c.getString("Item1_Item"));
        Item1_Server = Lobby.instance.c.getString("Item1_Server");
        Item2_Display = ChatColor.translateAlternateColorCodes('&', Lobby.instance.c.getString("Item2_Display"));
        Item2_Slot = Lobby.instance.c.getInt("Item2_Slot");
        Item2_Item = Material.valueOf(Lobby.instance.c.getString("Item2_Item"));
        Item2_Server = Lobby.instance.c.getString("Item2_Server");

    }

}

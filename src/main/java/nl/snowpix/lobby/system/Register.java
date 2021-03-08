package nl.snowpix.lobby.system;

import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.commands.*;
import nl.snowpix.lobby.events.*;
import nl.snowpix.lobby.gui.SelectorGUI;

public class Register {

    public static void RegisterEvents(){
        Lobby.instance.getServer().getPluginManager().registerEvents(new onChat(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new onJoin(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new onLeave(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new onDamage(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new onClick(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new onDrop(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new onHungerChange(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new SelectorGUI(), Lobby.instance);
        Lobby.instance.getServer().getPluginManager().registerEvents(new onLeafDecay(), Lobby.instance);
        Lobby.instance.getCommand("anti-build").setExecutor(new AntiBuild());
        Lobby.instance.getCommand("setspawn").setExecutor(new SetSpawn());
        Lobby.instance.getCommand("staff").setExecutor(new Staff());
        Lobby.instance.getCommand("fly").setExecutor(new Fly());
        Lobby.instance.getCommand("spawn").setExecutor(new Spawn());
        Lobby.instance.getServer().getMessenger().registerOutgoingPluginChannel(Lobby.instance, "BungeeCord");
    }

}

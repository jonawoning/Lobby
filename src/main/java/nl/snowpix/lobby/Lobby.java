package nl.snowpix.lobby;

import nl.snowpix.lobby.api.ScoreBoard;
import nl.snowpix.lobby.gui.SelectorGUI;
import nl.snowpix.lobby.system.Config;
import nl.snowpix.lobby.system.Register;
import nl.snowpix.lobby.system.SystemColors;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {

    public static Lobby instance;
    public FileConfiguration c;
    private Config config;
    private SelectorGUI selectorGUI;

    @Override
    public void onEnable() {
        instance = this;
        c = getConfig();
        config = new Config();
        selectorGUI = new SelectorGUI();
        config.ReloadConfig();
        Register.RegisterEvents();
        ScoreBoard.SBLOOPENABLE();
        System.out.println(SystemColors.TEXT_YELLOW + "[Lobby] " + SystemColors.TEXT_GREEN + "The plugin is successfully enabled." + SystemColors.TEXT_RESET);

    }

    @Override
    public void onDisable() {
        System.out.println(SystemColors.TEXT_YELLOW + "[Lobby] " + SystemColors.TEXT_GREEN + "The plugin is successfully disabled." + SystemColors.TEXT_RESET);
    }

    public Config getCConfig(){
        return config;
    }

    public SelectorGUI getSelectorGUI(){
        return selectorGUI;
    }

}

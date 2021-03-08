package nl.snowpix.lobby.commands;

import nl.snowpix.lobby.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.teleport(Lobby.instance.getCConfig().serverspawn);
        player.sendMessage(Lobby.instance.getCConfig().Prefix + "Je bent succesvol naar de spawn geteleporteerd.");
        return false;
    }
}

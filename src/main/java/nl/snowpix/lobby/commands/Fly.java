package nl.snowpix.lobby.commands;

import nl.snowpix.lobby.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    public static ArrayList<Player> fly_mode = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission(Lobby.instance.getCConfig().Staff_Perm)){
            if (!fly_mode.contains(player)){
                player.sendMessage(Lobby.instance.getCConfig().Prefix + "Je vliegmodus is nu §aaangezet§7!");
                player.setAllowFlight(true);
                player.setFlying(true);
                fly_mode.add(player);
            }else{
                player.sendMessage(Lobby.instance.getCConfig().Prefix + "Je vliegmodus is nu §cuitgezet§7!");
                player.setAllowFlight(false);
                player.setFlying(false);
                fly_mode.remove(player);
            }
        }else{
            player.sendMessage(Lobby.instance.getCConfig().Prefix + "§cGeen permissie.");
        }
        return false;
    }
}

package nl.snowpix.lobby.commands;

import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.methods.SpawnMethod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission(Lobby.instance.getCConfig().Admin_Perm)){
            if (args.length > 0){
                player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.RED + "Use: /setspawn or /set-spawn");
            }else{
                SpawnMethod.setSpawn("lobby", player);
            }
        }else{
            player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.RED + "You need the permission " + Lobby.instance.getCConfig().Admin_Perm + " for this..");
        }
        return false;
    }
}

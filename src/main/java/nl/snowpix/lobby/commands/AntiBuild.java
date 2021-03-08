package nl.snowpix.lobby.commands;

import nl.snowpix.lobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AntiBuild implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission(Lobby.instance.getCConfig().Admin_Perm)){
            if (args.length > 0){
                if (args[0].equalsIgnoreCase("on")){
                    if (Lobby.instance.getCConfig().AntiBuild){
                        player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.RED + "The anti-build is already on!");
                    }else{
                        Lobby.instance.getCConfig().AntiBuild = true;
                        player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.GREEN + "You succesfully enabled the anti-build!");
                    }
                }else if (args[0].equalsIgnoreCase("off")){
                    if (!Lobby.instance.getCConfig().AntiBuild){
                        player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.RED + "The anti-build is already off!");
                    }else{
                        Lobby.instance.getCConfig().AntiBuild = false;
                        player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.GREEN + "You succesfully disabled the anti-build!");
                    }
                }else{
                    player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.RED + "Use: /anti-build (on/off)");
                }
            }else{
                player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.RED + "Use: /anti-build (on/off)");
            }
        }else{
            player.sendMessage(Lobby.instance.getCConfig().Prefix + ChatColor.RED + "You need the permission " + Lobby.instance.getCConfig().Admin_Perm + " for this..");
        }
        return false;
    }
}

package nl.snowpix.lobby.commands;

import nl.snowpix.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Staff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission(Lobby.instance.getCConfig().Staff_Perm)){
            if (args.length > 0){
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target.hasPermission(Lobby.instance.getCConfig().Staff_Perm)){
                    if (target != null){
                        if (!Lobby.instance.getCConfig().staffmode.contains(target)){
                            Lobby.instance.getCConfig().staffmode.add(target);
                            player.sendMessage(Lobby.instance.getCConfig().Prefix + "§aJe hebt §2" + target.getName() + " §2in §astaffmode gezet!");
                            target.sendMessage(Lobby.instance.getCConfig().Prefix + "§aJe bent succesvol §2in §astaffmode gezet door §a" + player.getName() + "§a!");
                            target.sendTitle("§e§lSTAFF-MODE", "§7Je bent nu §2in §7staffmode!", 20, 35,20);
                            for (Player people : Bukkit.getOnlinePlayers()) {
                                if(!people.hasPermission(Lobby.instance.getCConfig().Staff_Perm))
                                    people.hidePlayer(Lobby.instance, target);
                            }
                            target.sendMessage(Lobby.instance.getCConfig().Prefix + "§7Andere staffleden in vanish:");
                            for(Player p : Lobby.instance.getCConfig().staffmode) {
                                target.sendMessage("- " + ChatColor.GRAY + p.getName());
                            }
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 2));
                        }else{
                            Lobby.instance.getCConfig().staffmode.remove(target);
                            player.sendMessage(Lobby.instance.getCConfig().Prefix + "§aJe hebt §2" + target.getName() + " §cuit §astaffmode gezet!");
                            target.sendMessage(Lobby.instance.getCConfig().Prefix + "§aJe bent succesvol §cuit §astaffmode gezet door §a" + player.getName() + "§a!");
                            target.sendTitle("§e§lSTAFF-MODE", "§7Je bent nu §cuit §7staffmode!", 20, 35,20);
                            for (Player people : Bukkit.getOnlinePlayers()) {
                                people.showPlayer(Lobby.instance, target);
                            }
                            target.sendMessage(Lobby.instance.getCConfig().Prefix + "§7Andere staffleden in vanish:");
                            for(Player p : Lobby.instance.getCConfig().staffmode) {
                                target.sendMessage("- " + ChatColor.GRAY + p.getName());
                            }
                            target.setAllowFlight(false);
                            target.setFlying(false);
                            target.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        }
                    }else{
                        player.sendMessage(Lobby.instance.getCConfig().Prefix + "§cERROR, deze speler naam klopt niet of is niet goed.");
                        player.sendMessage(Lobby.instance.getCConfig().Prefix + "§cGebruik: /staff (Speler)");
                    }
                }else{
                    player.sendMessage(Lobby.instance.getCConfig().Prefix + "§cDeze speler heeft geen staff perms..");
                }
            }else{
                if (!Lobby.instance.getCConfig().staffmode.contains(player)){
                    Lobby.instance.getCConfig().staffmode.add(player);
                    player.sendMessage(Lobby.instance.getCConfig().Prefix + "§aJe bent nu succesvol §2in §astaffmode!");
                    player.sendTitle("§e§lSTAFF-MODE", "§7Je bent nu §2in §7staffmode!", 20, 35,20);
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        if(!people.hasPermission(Lobby.instance.getCConfig().Staff_Perm))
                            people.hidePlayer(Lobby.instance, player);
                    }
                    player.sendMessage(Lobby.instance.getCConfig().Prefix + "§7Andere staffleden in vanish:");
                    for(Player p : Lobby.instance.getCConfig().staffmode) {
                        player.sendMessage("- " + ChatColor.GRAY + p.getName());
                    }
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 2));
                }else{
                    Lobby.instance.getCConfig().staffmode.remove(player);
                    player.sendMessage(Lobby.instance.getCConfig().Prefix + "§aJe bent nu succesvol §cuit §astaffmode!");
                    player.sendTitle("§e§lSTAFF-MODE", "§7Je bent nu §cuit §7staffmode!", 20, 35,20);
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.showPlayer(Lobby.instance, player);
                    }
                    player.sendMessage(Lobby.instance.getCConfig().Prefix + "§7Andere staffleden in vanish:");
                    for(Player p : Lobby.instance.getCConfig().staffmode) {
                        player.sendMessage("- " + ChatColor.GRAY + p.getName());
                    }
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                }
            }
        }else{
            player.sendMessage(Lobby.instance.getCConfig().Prefix + "§cGeen permissie.");
        }
        return false;
    }
}

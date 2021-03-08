package nl.snowpix.lobby.events;

import nl.snowpix.lobby.Lobby;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class onClick implements Listener {

    public static ArrayList<Player> cooldownsnowball = new ArrayList<>();

    @EventHandler
    public void OnRightClick(InventoryClickEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        if (Lobby.instance.getCConfig().AntiBuild){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnBlockClick(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (Lobby.instance.getCConfig().AntiBuild){
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR)){
                if (player.getInventory().getItemInMainHand().getType() == Material.BOOK){
                    Lobby.instance.getSelectorGUI().openInventory(player, "selector");
                    e.setCancelled(true);
                }
            }else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                if (player.getInventory().getItemInMainHand().getType() == Material.BOOK){
                    Lobby.instance.getSelectorGUI().openInventory(player, "selector");
                    e.setCancelled(true);
                }
            }else if (e.getAction().equals(Action.LEFT_CLICK_AIR)){
                if (player.getInventory().getItemInMainHand().getType() == Material.BOOK){
                    Lobby.instance.getSelectorGUI().openInventory(player, "selector");
                    e.setCancelled(true);
                }
            }else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
                if (player.getInventory().getItemInMainHand().getType() == Material.BOOK){
                    Lobby.instance.getSelectorGUI().openInventory(player, "selector");
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    private void TheBlockClick(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (Lobby.instance.getCConfig().AntiBuild){
            if (player.getInventory().getItemInMainHand().getType() != Material.SNOW_BALL){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void OnProjectHit(ProjectileHitEvent e){
        Player player = (Player) e.getEntity().getShooter();
        if (e.getEntity() instanceof Snowball){
            if (e.getHitBlock() != null){
                Location hittedblock = e.getHitBlock().getLocation();
                hittedblock.getWorld().createExplosion(hittedblock, 0.0F);
                cooldownsnowball.add(player);
                player.sendMessage(Lobby.instance.getCConfig().Prefix + "Je krijgt je snowball weer terug in 10 seconden!");
                new BukkitRunnable() {@Override public void run() {player.getInventory().setItem(5, new ItemStack(Material.SNOW_BALL, 1));{player.sendMessage(Lobby.instance.getCConfig().Prefix + "Je hebt je snowball terug gekregen!");{cooldownsnowball.remove(player); {player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, (float) 5, (float) 1);}}} }}.runTaskLater(Lobby.instance, 200);
            }else{
                Location hittedentity = e.getHitEntity().getLocation();
                hittedentity.getWorld().createExplosion(hittedentity, 0.0F);
                cooldownsnowball.add(player);
                player.sendMessage(Lobby.instance.getCConfig().Prefix + "Je krijgt je snowball weer terug in 10 seconden!");
                new BukkitRunnable() {@Override public void run() {player.getInventory().setItem(5, new ItemStack(Material.SNOW_BALL, 1));{player.sendMessage(Lobby.instance.getCConfig().Prefix + "Je hebt je snowball terug gekregen!");{cooldownsnowball.remove(player); {player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, (float) 5, (float) 1);}}} }}.runTaskLater(Lobby.instance, 200);
            }
        }
    }



}

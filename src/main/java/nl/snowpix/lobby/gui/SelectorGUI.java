package nl.snowpix.lobby.gui;

import me.clip.placeholderapi.PlaceholderAPI;
import nl.snowpix.lobby.Lobby;
import nl.snowpix.lobby.methods.BungeeCord;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectorGUI implements Listener {

    public void openInventory(Player player, String menu){
        if (menu.equalsIgnoreCase("selector")){
            SecInventory(player, "selector");
        }
    }

    public void SecInventory(Player player, String menu){
        if (menu.equalsIgnoreCase("selector")){
            Inventory selector = Bukkit.getServer().createInventory(player, 9, "Server Selector");
            String Server_1 = PlaceholderAPI.setPlaceholders(player, "%bungee_kingdom%");
            String Server_2 = PlaceholderAPI.setPlaceholders(player, "%bungee_os%");

            //Kingdom Item
            ItemStack kingdom = new ItemStack(Lobby.instance.getCConfig().Item1_Item);
            ItemMeta metakingdom = kingdom.getItemMeta();
            List<String> item1lore = Lobby.instance.c.getStringList("Item1_Lore");
            ArrayList<String> kingdomlore= new ArrayList<>();
            for(String text1 : item1lore){
                kingdomlore.add(ChatColor.translateAlternateColorCodes('&', text1).
                        replace("%online%", PlaceholderAPI.setPlaceholders(player, "%bungee_"+ Lobby.instance.getCConfig().Item1_Server+ "%")));
            }
            metakingdom.setLore(kingdomlore);
            metakingdom.setDisplayName(Lobby.instance.getCConfig().Item1_Display);
            kingdom.setItemMeta(metakingdom);

            //OorlogSimulatie Item
            ItemStack OorlogSimulatie = new ItemStack(Lobby.instance.getCConfig().Item2_Item);
            ItemMeta metaOorlogSimulatie = kingdom.getItemMeta();
            List<String> item2lore = Lobby.instance.c.getStringList("Item2_Lore");
            ArrayList<String> oslore = new ArrayList<>();
            for(String text2 : item2lore){
                oslore.add(ChatColor.translateAlternateColorCodes('&', text2).
                        replace("%online%", PlaceholderAPI.setPlaceholders(player, "%bungee_"+ Lobby.instance.getCConfig().Item2_Server+ "%")));
            }
            metaOorlogSimulatie.setLore(oslore);
            metaOorlogSimulatie.setDisplayName(Lobby.instance.getCConfig().Item2_Display);
            OorlogSimulatie.setItemMeta(metaOorlogSimulatie);

            selector.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE));
            selector.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE));
            selector.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE));
            selector.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE));
            selector.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE));
            selector.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE));
            selector.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE));
            selector.setItem(2, kingdom);
            selector.setItem(6, OorlogSimulatie);

            player.openInventory(selector);
        }
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("Server Selector")) {
            e.setCancelled(true);
            if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR)) || (e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE))) {
                return;
            }
            if (e.getSlot() == Lobby.instance.getCConfig().Item1_Slot && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Lobby.instance.getCConfig().Item1_Display))) {
                player.sendMessage(Lobby.instance.getCConfig().Prefix + "You are being send to " + Lobby.instance.getCConfig().Item1_Display + "§7...");
                BungeeCord.sendPlayerToServer(player, Lobby.instance.getCConfig().Item1_Server);
                player.closeInventory();
            } else if (e.getSlot() == Lobby.instance.getCConfig().Item2_Slot && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Lobby.instance.getCConfig().Item2_Display))) {
                player.sendMessage(Lobby.instance.getCConfig().Prefix + "You are being send to " + Lobby.instance.getCConfig().Item2_Display + "§7...");
                BungeeCord.sendPlayerToServer(player, Lobby.instance.getCConfig().Item2_Server);
                player.closeInventory();
            }
            return;
        }
    }

}

package ru.mineworld.core;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.potion.*;

public class EventCrossbreeding implements Listener
{
    private Main plugin;
    
    public EventCrossbreeding(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() instanceof AnvilInventory) {
            final AnvilInventory inv = (AnvilInventory)e.getInventory();
            if (e.getSlotType() != InventoryType.SlotType.RESULT) {
                return;
            }
            final HumanEntity human = e.getWhoClicked();
            final ItemStack item1 = inv.getItem(0);
            final ItemStack item2 = inv.getItem(1);
            if ((item1.getType() != Material.POTION || item2.getType() != Material.POTION) && (item1.getType() != Material.SPLASH_POTION || item2.getType() != Material.SPLASH_POTION)) {
                return;
            }
            if (item1 != null && item2 != null && Main.econ.getBalance((OfflinePlayer)human) >= this.plugin.getConfig().getInt("settings.potion-cost")) {
                human.setItemOnCursor(e.getInventory().getItem(2));
                e.getInventory().setItem(0, (ItemStack)null);
                e.getInventory().setItem(1, (ItemStack)null);
                final String succ = this.plugin.getConfig().getString("messages.prefix").replace('&', '§') + this.plugin.getConfig().getString("messages.usage-potion").replace('&', '§');
                human.sendMessage(succ);
                Main.econ.withdrawPlayer((OfflinePlayer)human, (double)this.plugin.getConfig().getInt("settings.potion-cost"));
            }
            else {
                final String fail = this.plugin.getConfig().getString("messages.prefix").replace('&', '§') + this.plugin.getConfig().getString("messages.no-money-potion").replace('&', '§');
                human.sendMessage(fail);
            }
        }
    }
    
    @EventHandler
    public void onAnvilPotion(final PrepareAnvilEvent e) {
        try {
            final AnvilInventory anvilInventory = e.getInventory();
            final InventoryView inventoryView = e.getView();
            final ItemStack[] items = anvilInventory.getContents();
            final ItemStack firstItem = items[0];
            final ItemStack secondItem = items[1];
            if (firstItem.getType() != Material.POTION && secondItem.getType() != Material.POTION) {
                return;
            }
            final PotionMeta firstPotionMeta = (PotionMeta)firstItem.getItemMeta();
            final PotionMeta secondPotionMeta = (PotionMeta)secondItem.getItemMeta();
            final PotionData firstPotionData = firstPotionMeta.getBasePotionData();
            final PotionData secondPotionData = secondPotionMeta.getBasePotionData();
            final PotionEffect firstPotionEffect = new PotionEffect(firstPotionData.getType().getEffectType(), 3000, Potion.fromItemStack(firstItem).getLevel());
            final PotionEffect secondPotionEffect = new PotionEffect(secondPotionData.getType().getEffectType(), 3000, Potion.fromItemStack(secondItem).getLevel());
            final ItemStack result = new ItemStack(Material.POTION);
            final PotionMeta potionMeta = (PotionMeta)result.getItemMeta();
            potionMeta.addCustomEffect(firstPotionEffect, true);
            potionMeta.addCustomEffect(secondPotionEffect, true);
            result.setItemMeta((ItemMeta)potionMeta);
            final Player player = (Player)inventoryView.getPlayer();
            e.setResult(result);
        }
        catch (Exception ex) {}
    }
    
    @EventHandler
    public void onAnvilSplashPotion(final PrepareAnvilEvent e) {
        try {
            final AnvilInventory anvilInventory = e.getInventory();
            final InventoryView inventoryView = e.getView();
            final ItemStack[] items = anvilInventory.getContents();
            final ItemStack firstItem = items[0];
            final ItemStack secondItem = items[1];
            if (firstItem.getType() != Material.SPLASH_POTION && secondItem.getType() != Material.SPLASH_POTION) {
                return;
            }
            final PotionMeta firstPotionMeta = (PotionMeta)firstItem.getItemMeta();
            final PotionMeta secondPotionMeta = (PotionMeta)secondItem.getItemMeta();
            final PotionData firstPotionData = firstPotionMeta.getBasePotionData();
            final PotionData secondPotionData = secondPotionMeta.getBasePotionData();
            final PotionEffect firstPotionEffect = new PotionEffect(firstPotionData.getType().getEffectType(), 3000, 1);
            final PotionEffect secondPotionEffect = new PotionEffect(secondPotionData.getType().getEffectType(), 3000, 1);
            final ItemStack result = new ItemStack(Material.SPLASH_POTION);
            final PotionMeta potionMeta = (PotionMeta)result.getItemMeta();
            potionMeta.addCustomEffect(firstPotionEffect, true);
            potionMeta.addCustomEffect(secondPotionEffect, true);
            result.setItemMeta((ItemMeta)potionMeta);
            final Player player = (Player)inventoryView.getPlayer();
            e.setResult(result);
        }
        catch (Exception ex) {}
    }
}

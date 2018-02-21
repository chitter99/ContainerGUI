package ch.chitters.container.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import ch.chitters.container.Main;
import ch.chitters.container.events.ContainerItemClickEvent;
import ch.chitters.container.gui.Container;
import ch.chitters.container.gui.ContainerItem;
import ch.chitters.container.utils.ContainerManager;

public class ContainerActionListener implements Listener {
	final Main main;
	public ContainerActionListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {	
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getClickedInventory();
		
		if(ContainerManager.hasContainer(player, inventory.getTitle())) {
			Container container = ContainerManager.getContainer(player, inventory.getTitle());
			ItemStack usedItem = e.getCurrentItem();
			for(ContainerItem item : container.items) {
				if(item.getItemStack().equals(usedItem)) {
					ContainerItemClickEvent event = new ContainerItemClickEvent();
					item.onClick(event);
					e.setCancelled(event.isCancelled());
				}
			}
		}
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		Player player = (Player) e.getPlayer();
		Inventory inventory = e.getInventory();
		
		if(ContainerManager.hasContainer(player, inventory.getTitle())) {
			Container container = ContainerManager.getContainer(player, inventory.getTitle());
			container.onClose();
			ContainerManager.removeContainer(player, inventory.getTitle());
		}
	}
}

package ch.chitters.container.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import ch.chitters.container.utils.ContainerManager;

public abstract class Container {
	protected String title;
	protected int size = 54;
	
	public List<ContainerItem> items = new ArrayList<ContainerItem>();

	protected final JavaPlugin plugin;
	protected final Player player;
	
	public Container(JavaPlugin plugin, Player player) {
		this.plugin = plugin;
		this.player = player;
		this.onLoad();
	}
	
	public JavaPlugin getPlugin() {
		return this.plugin;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void put(ContainerItem item) {
		this.put(item, items.size());
	}
	
	public void put(ContainerItem item, int index) {
		this.put(item, new ContainerVector(index));
	}
	
	public void put(ContainerItem item, int x, int y) {
		this.put(item, new ContainerVector(x, y));
	}
	
	public void put(ContainerItem item, ContainerVector vector) {
		item.assign(this, vector);
		this.items.add(item);
	}
	
	public Inventory getInventory() {
		if(!(this.size % 9 == 0) || this.size > 54 || this.size < 0) {
			throw new IllegalArgumentException("Inventory size must be a multiple of 9, not greater than 54 and positive");
		}
		Inventory inv = plugin.getServer().createInventory(null, this.size, this.title);
		for(ContainerItem item : items) {
			inv.setItem(item.getVector().getIndex(), item.getItemStack());
		}
		return inv;
	}
	
	public void show() {
		this.player.openInventory(this.getInventory());
		ContainerManager.registerContainer(player, title, this);
	}
	
	public void onLoad() { }
	public void onClose() { }
}

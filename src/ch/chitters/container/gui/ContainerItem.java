package ch.chitters.container.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.chitters.container.events.ContainerItemClickEvent;

public class ContainerItem {
	protected Material material = Material.BARRIER;
	protected int amount = 1;
	protected String displayName;
	protected List<String> lore = new ArrayList<String>();
	protected Container container;
	protected ContainerVector vector;
	
	public void assign(Container c, ContainerVector v) {
		this.container = c;
		this.vector = v;
		this.onLoad();
	}
	
	public ItemStack getItemStack() {
		ItemStack stack = new ItemStack(this.material);
		stack.setAmount(this.amount);
		if(!this.material.equals(Material.AIR)) {
			// Air does not have a ItemMeta
			ItemMeta meta = Bukkit.getItemFactory().getItemMeta(stack.getType());
			meta.setDisplayName(this.displayName);
			meta.setLore(this.lore);
			stack.setItemMeta(meta);
		}
		return stack;
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<String> getLore() {
		return lore;
	}

	public void setLore(List<String> lore) {
		this.lore = lore;
	}
	
	public Container getContainer() {
		return this.container;
	}
	
	public ContainerVector getVector() {
		return this.vector;
	}
	
	/* Container Item Builder Functions */
	public ContainerItem name(String n) {
		this.displayName = n;
		return this;
	}
	
	public ContainerItem amount(int a) {
		this.amount = a;
		return this;
	}
	
	public ContainerItem lore(String l) {
		this.lore.add(l);
		return this;
	}
	
	public ContainerItem material(Material m) {
		this.material = m;
		return this;
	}
	
	public ContainerItem type(Material m) {
		this.material = m;
		return this;
	}
	
	public void onLoad() { }
	public void onClick(ContainerItemClickEvent event) { }
}

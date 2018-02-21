package ch.chitters.container.gui.utils;

import org.bukkit.Material;

import ch.chitters.container.events.ContainerItemClickEvent;
import ch.chitters.container.gui.ContainerItem;

public class CloseContainerItem extends ContainerItem {	
	@Override
	public void onClick(ContainerItemClickEvent event) {		
		this.container.getPlayer().closeInventory();
	}
	
	@Override
	public CloseContainerItem name(String n) {
		this.displayName = n;
		return this;
	}
	
	@Override
	public CloseContainerItem amount(int a) {
		this.amount = a;
		return this;
	}
	
	@Override
	public CloseContainerItem lore(String l) {
		this.lore.add(l);
		return this;
	}
	
	@Override
	public CloseContainerItem material(Material m) {
		this.material = m;
		return this;
	}
	
	@Override
	public CloseContainerItem type(Material m) {
		this.material = m;
		return this;
	}
}

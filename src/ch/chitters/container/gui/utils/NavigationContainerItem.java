package ch.chitters.container.gui.utils;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ch.chitters.container.events.ContainerItemClickEvent;
import ch.chitters.container.gui.Container;
import ch.chitters.container.gui.ContainerItem;

public class NavigationContainerItem<T extends Container> extends ContainerItem {
	protected T target;
	protected Class<T> clazz;
	
	public NavigationContainerItem(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public NavigationContainerItem(T target) {
		this.target = target;
	}
	
	@Override
	public void onClick(ContainerItemClickEvent event) {		
		if(this.target == null) {
			try {
				this.target = this.clazz.getConstructor(JavaPlugin.class, Player.class).newInstance(this.container.getPlugin(), this.container.getPlayer());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				return;
			}
		}
		this.container.getPlayer().closeInventory();
		this.target.show();
	}
	
	public NavigationContainerItem<T> target(T t) {
		this.target = t;
		return this;
	}
	
	@Override
	public NavigationContainerItem<T> name(String n) {
		this.displayName = n;
		return this;
	}
	
	@Override
	public NavigationContainerItem<T> amount(int a) {
		this.amount = a;
		return this;
	}
	
	@Override
	public NavigationContainerItem<T> lore(String l) {
		this.lore.add(l);
		return this;
	}
	
	@Override
	public NavigationContainerItem<T> material(Material m) {
		this.material = m;
		return this;
	}
	
	@Override
	public NavigationContainerItem<T> type(Material m) {
		this.material = m;
		return this;
	}
}

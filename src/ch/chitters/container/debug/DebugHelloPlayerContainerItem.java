package ch.chitters.container.debug;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import ch.chitters.container.gui.ContainerItem;

public class DebugHelloPlayerContainerItem extends ContainerItem {	
	@Override
	public void onLoad() {
		this.displayName = "Welcome " + this.container.getPlayer().getDisplayName();
		this.material = Material.SAND;
		this.lore.add("This is the Lore!");
	}
}

package ch.chitters.container.debug;

import org.bukkit.Material;

import ch.chitters.container.events.ContainerItemClickEvent;
import ch.chitters.container.gui.ContainerItem;

public class DebugClickMeContainerItem extends ContainerItem {
	@Override
	public void onLoad() {
		this.displayName = "Click Me";
		this.material = Material.ARROW;
	}
	
	@Override
	public void onClick(ContainerItemClickEvent event) {
		this.container.getPlayer().closeInventory();
		this.container.getPlayer().sendMessage("Thank you for clicking!");
	}
}

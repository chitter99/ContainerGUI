package ch.chitters.container.debug;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ch.chitters.container.gui.Container;
import ch.chitters.container.gui.utils.NavigationContainerItem;

public class DebugContainer extends Container {	
	public DebugContainer(JavaPlugin plugin, Player player) {
		super(plugin, player);
		this.title = "Debug Container";
		this.size = 9;
	}

	@Override
	public void onLoad() {
		put(new DebugHelloPlayerContainerItem());
		put(new DebugClickMeContainerItem());
		put(new NavigationContainerItem<DebugMenuContainer>(DebugMenuContainer.class).type(Material.ENCHANTED_BOOK).name("Navigate to Menu"), 8);
	}
}

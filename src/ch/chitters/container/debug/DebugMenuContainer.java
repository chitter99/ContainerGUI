package ch.chitters.container.debug;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ch.chitters.container.gui.Container;
import ch.chitters.container.gui.ContainerItem;

public class DebugMenuContainer extends Container {	
	public DebugMenuContainer(JavaPlugin plugin, Player player) {
		super(plugin, player);
		this.title = "Debug Menu";
		this.size = 9;
	}

	@Override
	public void onLoad() {
		put(new ContainerItem().name("Apple").type(Material.APPLE).amount(21));
	}
}

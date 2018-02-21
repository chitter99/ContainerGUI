package ch.chitters.container;

import org.bukkit.plugin.java.JavaPlugin;

import ch.chitters.container.listeners.ContainerActionListener;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ContainerActionListener(this), this);
	}
}

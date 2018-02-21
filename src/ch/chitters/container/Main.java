package ch.chitters.container;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ch.chitters.container.debug.DebugContainer;
import ch.chitters.container.listeners.ContainerActionListener;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ContainerActionListener(this), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		new DebugContainer(this, (Player) sender).show();
		return true;
	}
}

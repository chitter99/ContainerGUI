package ch.chitters.container.utils;

import java.util.HashMap;

import org.bukkit.entity.Player;

import ch.chitters.container.gui.Container;

public class ContainerManager {
	static private HashMap<Player, HashMap<String, Container>> containers = new HashMap<Player, HashMap<String, Container>>();
	
	static public void registerContainer(Player player, String title, Container container) {
		if(!containers.containsKey(player)) {
			containers.put(player, new HashMap<String, Container>());
		} else {
			if(containers.get(player).containsKey(title)) {
				throw new IllegalArgumentException("Container is already registered");
			}
		}
		containers.get(player).put(title, container);
	}
	
	static public boolean hasContainer(Player player, String title) {
		if(!containers.containsKey(player)) {
			return false;
		}
		return containers.get(player).containsKey(title);
	}
	
	static public Container getContainer(Player player, String title) {
		return containers.get(player).get(title);
	}
	
	static public void removeContainer(Player player, String title) {
		containers.get(player).remove(title);
	}
}

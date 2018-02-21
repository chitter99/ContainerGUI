# ContainerGUI
Framework for easily creating Inventory User Interfaces.

# Example
![Example of Framework](https://github.com/chitter99/ContainerGUI/blob/master/screenshots/example1.png?raw=true)

HelloWorldPlugin.java
```java
class HelloWorldPlugin extends JavaPlugin {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    new HelloWorldContainer(this, (Player) sender).show();
    return true;
  }
}
```

HelloWorldContainer.java
```java
class HelloWorldContainer extends Container {
  public HelloWorldContainer(JavaPlugin plugin, Player player) {
    super(plugin, player);
  }
  
  @Override
  public void onLoad() {
    title = "Hello World";
    put(new ContainerItem().type(Material.PAPER).name("Hello World"));
    put(new ClickMeContainerItem());
    last(new CloseContainerItem().type(Material.BARRIER).name("Close"));
  }
}
```

ClickMeContainerItem.java
```java
class ClickMeContainerItem extends ContainerItem {
  @Override
  public void onLoad() {
    displayName = "Hello " + container.getPlayer().getDisplayName();
    material = Material.CHEST;
    lore.add("Just click me!");
  }
  @Override
  public void onClick(ContainerItemClickEvent event) {
    container.getPlayer().getInventory().addItem(new ItemStack(Material.BAKED_POTATO));
    container.getPlayer().sendMessage("Here you go!");
  }
}
```

# Installation
To install this Framework in your Spigot / Bukkit Server just put the latest Jar in the plugin directory.

# Setup
Follow this guide if you want to use this Framework in your plugin.

## Eclipse
* Download latest JAR
* Add JAR to your projects build path (Right Click Project Name -> Build Path -> Add External Archives...)
* Take a look at the examples to get an idea how this framework works


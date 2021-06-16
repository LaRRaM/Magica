package magica.plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Wizardry(), this);
		Charms charms = new Charms();
		charms.fireball();
	}
}

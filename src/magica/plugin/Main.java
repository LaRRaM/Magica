package magica.plugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Wizardry(this), this);
		Charms charms = new Charms();
		charms.fireball();
		File config = new File(getDataFolder() + File.separator + "config.yml");
//Files is exist
		if (!config.exists()){
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}

	}
}

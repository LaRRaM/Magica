package magica.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Wizardry implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void use(PlayerInteractEvent clk) {
//
		if(clk.getAction() != Action.RIGHT_CLICK_AIR && clk.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(clk.getPlayer().getItemInHand().getType() != Material.PAPER) return;
//		
		Player p = clk.getPlayer();
		ItemStack item = clk.getPlayer().getItemInHand();
//
		if(!item.getItemMeta().hasDisplayName()) return;
		if(!item.getItemMeta().hasLore()) return;
		clk.setCancelled(true);
//
		String lore = item.getItemMeta().getLore().get(0);
		Location loc = p.getLocation().add(0, 2, 0);
//
        double pitch = ((p.getLocation().getPitch() + 90) * Math.PI) / 180;
        double yaw = ((p.getLocation().getYaw() + 90) * Math.PI) / 180;
//
        double x = Math.sin(pitch) * Math.cos(yaw);
        double y = Math.sin(pitch) * Math.sin(yaw);
        double z = Math.cos(pitch);
//
        Vector vector = new Vector(x, z, y);
//
		switch(lore) {
			case ("FIREBALL"):
				SmallFireball fireball = p.getWorld().spawn(loc, SmallFireball.class);
				fireball.setDirection(vector.multiply(10));
				fireball.setBounce(false);
				fireball.setIsIncendiary(false);
				fireball.setYield(2);
				break;
			default:
				return;
		}
		
		
		
	}
}
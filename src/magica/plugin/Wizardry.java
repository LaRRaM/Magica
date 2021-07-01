package magica.plugin;

import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;


import org.bukkit.Sound;

public class Wizardry implements Listener{
	private Main plugin;
	public Wizardry (Main plugin) {this.plugin = plugin;}
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
//Config

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
        int price = Integer.parseInt(plugin.getConfig().getString("price"));
//wizardry
		switch(lore) {
			case ("FIREBALL"):
				if (p.getLevel() >= price){
					SmallFireball fireball = p.getWorld().spawn(loc, SmallFireball.class);
					fireball.setDirection(vector.multiply(10));
					fireball.setBounce(false);
					fireball.setIsIncendiary(false);
					fireball.setYield(2);
					p.playSound(p.getLocation(), Sound.ENTITY_GHAST_SHOOT, 10, 1);
					p.setLevel(p.getLevel() - price);
				} else {
					p.playSound(p.getLocation(), Sound.ENTITY_GHAST_DEATH, 10, 1);
					p.sendMessage(plugin.getConfig().getString("messages.lowExpMsg"));
				}
				break;
			case ("DEATH AREA"):
				if (p.getLevel() >= price){
					Collection<Entity> e = p.getWorld().getNearbyEntities(p.getLocation(), 8, 8, 8);

					for (Entity mob : e) {
						if(mob != p) {
							((Damageable)mob).damage(100);
						}
					}
					p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 10, 1);
					p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 10, 1);
					p.setLevel(p.getLevel() + (price + 2 * e.size()));
				} else {
					p.playSound(p.getLocation(), Sound.ENTITY_GHAST_DEATH, 10, 1);
					p.sendMessage(plugin.getConfig().getString("messages.lowExpMsg"));
				}
				break;
			default:
				return;
		}		
	}
}
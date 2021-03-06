package magica.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Charms{
	public Charms () {}
	public void fireball() {
		ItemStack fireball_rune = new ItemStack(Material.PAPER);
		ItemMeta meta = fireball_rune.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "FIREBALL");
		List<String> lore = new ArrayList<String>();
		lore.add("FIREBALL");
	
		meta.setLore(lore);
		meta.addEnchant(Enchantment.SILK_TOUCH, 3, true);
		
		fireball_rune.setItemMeta(meta);
		@SuppressWarnings("deprecation")
		ShapedRecipe recipe = new ShapedRecipe(fireball_rune);
//recipe
		recipe.shape(new String[] {"A B","   ","   "});
		recipe.setIngredient('A', Material.PAPER);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
//
		Bukkit.getServer().addRecipe(recipe);
	}
//
	public void darkArrow() {
		ItemStack item = new ItemStack(Material.PAPER);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.BLACK + "DARKARROW");
		List<String> lore = new ArrayList<String>();
		lore.add("DARKARROW");
		
	}
//
	public void deathArea() {
		ItemStack deatharea_rune = new ItemStack(Material.PAPER);
		ItemMeta meta = deatharea_rune.getItemMeta();
		meta.setDisplayName(ChatColor.BLACK + "Death area");
		List<String> lore = new ArrayList<String>();
		lore.add("DEATH AREA");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.SILK_TOUCH, 3, true);
		
		deatharea_rune.setItemMeta(meta);
		@SuppressWarnings("deprecation")
		ShapedRecipe recipe = new ShapedRecipe(deatharea_rune);
//recipe
		recipe.shape(new String[] {"A B","   ","   "});
		recipe.setIngredient('A', Material.PAPER);
		recipe.setIngredient('B', Material.WITHER_SKELETON_SKULL);
//
		Bukkit.getServer().addRecipe(recipe);
	}
}

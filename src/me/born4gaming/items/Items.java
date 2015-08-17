package me.born4gaming.items;


import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items implements Listener{

	ItemStack bow = new ItemStack(Material.BOW);
	ItemMeta metabow = bow.getItemMeta();
	ItemStack axe = new ItemStack(Material.IRON_AXE);
	ItemMeta metaaxe = axe.getItemMeta();
	@EventHandler
	public void onAxeThrow(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == axe.getType())
		{
			Item i = p.getWorld().dropItem(p.getLocation(), axe);
			
			i.setVelocity(p.getEyeLocation().getDirection().multiply(2));
			List<Entity> nearby = i.getNearbyEntities(1, 1, 1);
			nearby.remove(p);
			Random ran = new Random();
			
			int rantarget = ran.nextInt(nearby.size());
			
			
			
			
			Entity entitytarget = nearby.get(rantarget);
			
			if(entitytarget instanceof Player)
			{
				Player target = (Player) entitytarget;
				
				
				
				target.damage(100000D);
				target.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1, 1);
				
				
				
				
				
			}
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	@EventHandler
	public void onArrowShoot(ProjectileHitEvent e)
	{
		Entity hitter = e.getEntity();
		
		if(hitter instanceof Player)
		{
			hitter.getWorld().createExplosion(hitter.getLocation().getX(), hitter.getLocation().getY(), hitter.getLocation().getZ(), 3F, true, false);
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

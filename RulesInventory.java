package com.featuredepic.test;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RulesInventory {
	
	String inventoryName;
	int numberOfRules = 0, numberOfSlots;
	Inventory inventory;
	
	/**
	 * Creates a new Inventory to display
	 * Rules in.
	 * 
	 * @param  inventoryName  The Title of the Inventory.
	 * @param  numberOfSlots  The Number of Slots for Rules.
	 */
	public RulesInventory(String inventoryName, int numberOfSlots){
		this.inventoryName = inventoryName;
		this.numberOfSlots = numberOfSlots;
		inventory = Bukkit.createInventory(null, this.numberOfSlots, this.inventoryName);
	}
	
	/**
	 * Gets the Inventory object of the
	 * Rules Inventory.
	 * 
	 * @return  The Inventory.
	 */
	public Inventory getInventory(){
		return this.inventory;
	}
	
	/**
	 * Gets the Title of the Rules
	 * Inventory.
	 * 
	 * @return  The Title.
	 */
	public String getName(){
		return this.inventoryName;
	}
	
	/**
	 * Gets the Number of Slots that
	 * the Rules Inventory has.
	 * 
	 * @return  The Number of Slots.
	 */
	public int getNumberOfSlots(){
		return this.numberOfSlots;
	}
	
	/**
	 * Gets the Number of Rules in the
	 * Rules Inventory.
	 * 
	 * @return  The Number of Rules.
	 */
	public int getNumberOfRules(){
		return this.numberOfRules;
	}
	
	/**
	 * Adds a Rule to the Rules
	 * Inventory.
	 * 
	 * @param  rule  The Rule.
	 * @return       The Inventory
	 */
	public RulesInventory addRule(Rule rule){
		ItemStack item = new ItemStack(rule.getItem(), 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(rule.getName());
		meta.setLore(rule.getDescription());
		item.setItemMeta(meta);
		getInventory().setItem(this.numberOfRules, item);
		this.numberOfRules++;
		return this;
	}
	
	/**
	 * Adds several Rules to the Rules
	 * Inventory at once.
	 * 
	 * @param  rules  The List of Rules.
	 * @return        The Inventory.
	 */
	public RulesInventory addMultipleRules(List<Rule> rules){
		for(Rule rule : rules){
			addRule(rule);
		}
		return this;
	}
	
	/**
	 * Opens the Rules Inventory for
	 * a Player.
	 * 
	 * @param  p  The Player.
	 */
	public void openFor(Player p){
		p.closeInventory();
		p.openInventory(getInventory());
	}
	
	/**
	 * Opens the Rules Inventory for
	 * multiple Players.
	 * 
	 * @param  players  The Players.
	 */
	public void openFor(Player[] players){
		for(Player p : players){
			openFor(p);
		}
	}

}

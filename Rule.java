package com.featuredepic.test;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

/**
 * @author FeaturedEpic
 *
 */
public class Rule {

	private String name;
	private List<String> lore = new ArrayList<String>();
	private Material item;
	private ItemStack itemstack;

	/**
	 * Creates a new Rule with given name.
	 * 
	 * @param name
	 *            The name of the Rule
	 */
	public Rule(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the Rule.
	 * 
	 * @return The Name of the Rule.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the description of the Rule. The description is the lore of the item
	 * that represents the Rule in-game.
	 * 
	 * @return The Description of the Rule.
	 */
	public List<String> getDescription() {
		return this.lore;
	}

	/**
	 * Gets the item used in-game to represent the Rule in-game.
	 * 
	 * @return The Item used to Represent the Rule.
	 */
	public Material getItem() {
		return this.item;
	}

	/**
	 * Sets the name of the Rule.
	 * 
	 * @param name
	 *            The Name.
	 * @return The Rule.
	 */
	public Rule setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Sets the description of the Rule. The description is the lore of the item
	 * that represents the Rule in-game.
	 * 
	 * @param description
	 *            The Description.
	 * @return The Rule.
	 */
	public Rule setDescription(List<String> description) {
		this.lore = description;
		return this;
	}

	/**
	 * Adds a new line to the description of the Rule. The description is the
	 * lore of the item that represents the Rule in-game.
	 * 
	 * @param description
	 *            The Line of the Description.
	 * @return The Rule.
	 */
	public Rule addToDescription(String description) {
		this.lore.add(description);
		return this;
	}

	/**
	 * Sets the item of the Rule. The item is the visual representation of the
	 * Rule in-game.
	 * 
	 * @param item
	 *            The Item.
	 * @return The Rule.
	 */
	public Rule setItem(Material item) {
		this.item = item;
		return this;
	}

	/**
	 * Turns the Rule into a Usable Item Stack. You must run this method
	 * before adding it to the Rules Inventory.
	 * 
	 * @return The Rule.
	 */
	public Rule build() {
		ItemStack itemStack = new ItemStack(item, 1);
		ItemMeta meta = itemStack.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		itemStack.setItemMeta(meta);
		itemstack = itemStack;
		return this;
	}

	/**
	 * Gets the ItemStack of the Rule.
	 * 
	 * @return The Item Stack.
	 */
	public ItemStack getItemStack() {
		return itemstack;
	}

	/**
	 * Removes any Attributes from the Rule such as Attack Damage.
	 * 
	 * @return The Rule.
	 */
	public Rule removeAttribute() {
		net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(itemstack);
		NBTTagCompound tag;
		if (!nmsStack.hasTag()) {
			tag = new NBTTagCompound();
			nmsStack.setTag(tag);
		} else {
			tag = nmsStack.getTag();
		}
		NBTTagList am = new NBTTagList();
		tag.set("AttributeModifiers", am);
		nmsStack.setTag(tag);
		itemstack = CraftItemStack.asCraftMirror(nmsStack);
		return this;
	}

}

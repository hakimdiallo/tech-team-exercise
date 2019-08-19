package com.soul.backend.tech.team.exercise.model.dto;

/**
 * 
 * @author soudiall
 *
 */
public class Product {
	private int id;
	private String name;
	private String date;
	private int inventoryLevel;
	
	public Product() {
	}
	
	public Product(int id, String name, String date, int inventoryLevel) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.inventoryLevel = inventoryLevel;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getInventoryLevel() {
		return inventoryLevel;
	}
	public void setInventoryLevel(int inventoryLevel) {
		this.inventoryLevel = inventoryLevel;
	}
}

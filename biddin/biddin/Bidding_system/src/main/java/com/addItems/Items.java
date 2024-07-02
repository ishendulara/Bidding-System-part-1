package com.addItems;

public class Items {
	
	private int id;
	private String itemName;	
	private String description;
	private String startingPrice;	
	private String condition;
	private String duration;
	
	public Items(int id, String itemName, String description, String startingPrice, String condition, String duration) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.startingPrice = startingPrice;
		this.condition = condition;
		this.duration = duration;
	}

	public Items(String itemName, String description, String startingPrice, String condition, String duration) {
		super();
		this.itemName = itemName;
		this.description = description;
		this.startingPrice = startingPrice;
		this.condition = condition;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getDescription() {
		return description;
	}

	public String getStartingPrice() {
		return startingPrice;
	}

	public String getCondition() {
		return condition;
	}

	public String getDuration() {
		return duration;
	}
	
	
	

}

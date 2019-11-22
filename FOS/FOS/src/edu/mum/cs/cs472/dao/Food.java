package edu.mum.cs.cs472.dao;

import java.util.Date;

public class Food {
    private int foodId;

    private String name;
    private int calories;
    private String description;
    private String type;
    private double price;
    private int image_id;
    private String image_path;
    private int order_count;
    private Date created;

    public Food() {

    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public Food(int foodId, String name, int calories, String description, String type, double price, int image_id, String path, int order_count, Date created) {
        this.foodId = foodId;
        this.name = name;
        this.calories = calories;
        this.description = description;
        this.type = type;
        this.price = price;
        this.image_id = image_id;
        this.image_path = path;
        this.order_count = order_count;
        this.created = created;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", name=" + name + ", calories=" + calories + ", description=" + description
				+ ", type=" + type + ", price=" + price + ", image_id=" + image_id + ", image_path=" + image_path
				+ ", order_count=" + order_count + ", created=" + created + "]";
	}
    
}

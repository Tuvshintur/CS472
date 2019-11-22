package edu.mum.cs.cs472.service;

import edu.mum.cs.cs472.dao.Food;

import java.util.List;

public interface FoodService {
    public List<Food> getAllFood();

    public Food getFoodById(int foodId);

    public List<Food> getFoodByType(String type);

    public String newFood(Food newFood);

    public String updateFood(Food newFood);

    public String deleteFood(int foodId);

    public Food getFoodByFoodId(int foodId);
}

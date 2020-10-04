package com.mrvijay.mealrecipes.views.category;

import com.mrvijay.mealrecipes.models.Meals;

import java.util.List;

public interface CategoryView {

    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meals);
    void onErrorLoading(String message);
}

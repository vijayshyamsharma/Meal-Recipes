package com.mrvijay.mealrecipes.views.detail;

import com.mrvijay.mealrecipes.models.Meals;

public interface DetailView {

    void showLoading();
    void hideLoading();
    void onErrorLoading(String message);
    void setMeal(Meals.Meal meal);

}

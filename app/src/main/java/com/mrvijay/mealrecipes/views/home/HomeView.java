package com.mrvijay.mealrecipes.views.home;

import com.mrvijay.mealrecipes.models.CategoryData;

import java.util.List;

public interface HomeView {

    void setCatgeory(List<CategoryData.Category> catgeory);
    void showLoading();
    void hideLoading();
    void onErrorLoading(String message);

}

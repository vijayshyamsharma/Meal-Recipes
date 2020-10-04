package com.mrvijay.mealrecipes.views.category;

import com.mrvijay.mealrecipes.models.Meals;
import com.mrvijay.mealrecipes.others.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter {

    CategoryView categoryView;

    public CategoryPresenter(CategoryView categoryView)
    {
        this.categoryView=categoryView;
    }

    public void getMealByCategory(String category)
    {
        categoryView.showLoading();

        Call<Meals> mealsCall= Utils.getApi().getMealByCategory(category);

        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {

                categoryView.hideLoading();

                if(response.isSuccessful() && response.body()!=null)
                {
                    categoryView.setMeals(response.body().getMeals());
                }
                else {
                    categoryView.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {

                categoryView.hideLoading();
                categoryView.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}

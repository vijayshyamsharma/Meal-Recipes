package com.mrvijay.mealrecipes.views.detail;

import com.mrvijay.mealrecipes.models.Meals;
import com.mrvijay.mealrecipes.others.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {

    DetailView detailView;

    public DetailPresenter(DetailView detailView) {
        this.detailView = detailView;
    }

    public void getMealByName(String mealName)
    {
        detailView.showLoading();

        Call<Meals> mealsCall= Utils.getApi().getMealByName(mealName);

        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {

                detailView.hideLoading();

                if(response.isSuccessful() && response.body()!=null)
                {
                    detailView.setMeal(response.body().getMeals().get(0));
                }
                else
                {
                    detailView.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {

                detailView.hideLoading();

                detailView.onErrorLoading(t.getLocalizedMessage());

            }
        });
    }
}

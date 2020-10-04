package com.mrvijay.mealrecipes.views.home;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.mrvijay.mealrecipes.models.CategoryData;
import com.mrvijay.mealrecipes.others.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    HomeView homeView;

    public HomePresenter() {
    }

    public HomePresenter(HomeView homeView)
    {
        this.homeView=homeView;

    }

    void getCategory()
    {
        homeView.showLoading();

        Call<CategoryData> categoryDataCall= Utils.getApi().getCategories();

        categoryDataCall.enqueue(new Callback<CategoryData>() {
            @Override
            public void onResponse(Call<CategoryData> call, Response<CategoryData> response) {



                homeView.hideLoading();
                if(response.isSuccessful() && response.body()!=null)
                {
                    Log.d("dataStatus","success");

                    homeView.setCatgeory(response.body().getCategories());
                }
                else {
                    homeView.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<CategoryData> call, Throwable t) {

                homeView.hideLoading();
                homeView.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }




}

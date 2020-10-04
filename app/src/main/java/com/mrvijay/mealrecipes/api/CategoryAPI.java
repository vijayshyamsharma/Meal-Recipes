package com.mrvijay.mealrecipes.api;


import com.mrvijay.mealrecipes.models.CategoryData;
import com.mrvijay.mealrecipes.models.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryAPI {

    @GET("categories.php")
    Call<CategoryData> getCategories();

    @GET("filter.php")
    Call<Meals> getMealByCategory(@Query("c") String category);

    @GET("search.php")
    Call<Meals> getMealByName(@Query("s") String mealName);
}

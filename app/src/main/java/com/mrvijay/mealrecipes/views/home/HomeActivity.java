package com.mrvijay.mealrecipes.views.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mrvijay.mealrecipes.adapters.HomeViewPagerAdapter;
import com.mrvijay.mealrecipes.adapters.MealCategoryAdapter;
import com.mrvijay.mealrecipes.R;
import com.mrvijay.mealrecipes.models.CategoryData;
import com.mrvijay.mealrecipes.others.Utils;
import com.mrvijay.mealrecipes.views.category.CategoryActivity;


import java.io.Serializable;
import java.util.List;

public class HomeActivity extends AppCompatActivity  implements HomeView, MealCategoryAdapter.ItemClickListener {

    public static String EXTRA_CATEGORY="EXTRA_CATEGORY";
    public static String EXTRA_POS="EXTRA_POS";

    List<CategoryData.Category> datalist;

    RecyclerView recyclerView;
    ViewPager viewPager2;
    LinearLayout linearLayout;
    FrameLayout linearLayout1;

    MealCategoryAdapter mealCategoryAdapter;

    GridLayoutManager gridLayoutManager;

    HomePresenter homePresenter;

    HomeViewPagerAdapter homeViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.recyclerview_shimmerl);
        linearLayout1=findViewById(R.id.shimmerMeal);
        recyclerView=findViewById(R.id.recyclerCategory);
        viewPager2=findViewById(R.id.viewPagerHeader);




        homePresenter=new HomePresenter(this);

        homePresenter.getCategory();










    }

    void prepareRecyclerView(List<CategoryData.Category> arrayList)
    {

        datalist=arrayList;

        mealCategoryAdapter=new MealCategoryAdapter(this,arrayList,this);

        recyclerView.setAdapter(mealCategoryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));

        recyclerView.setHasFixedSize(true);

        recyclerView.setNestedScrollingEnabled(true);
        mealCategoryAdapter.notifyDataSetChanged();





    }

    void prepareViewPager(List<CategoryData.Category> arrayList)
    {
        homeViewPagerAdapter=new HomeViewPagerAdapter(this,arrayList,viewPager2);
        viewPager2.setAdapter(homeViewPagerAdapter);


        homeViewPagerAdapter.notifyDataSetChanged();


    }

    @Override
    public void setCatgeory(List<CategoryData.Category> catgeory) {

        prepareRecyclerView(catgeory);
        prepareViewPager(catgeory);


    }

    @Override
    public void showLoading() {


        linearLayout1.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        linearLayout1.setVisibility(View.GONE);
        linearLayout.setVisibility(View.GONE);
    }

    @Override
    public void onErrorLoading(String message) {

        Utils.showDialogMessage(this, "Title", message);

    }

    @Override
    public void onItemClick(int pos) {

        Intent intent=new Intent(HomeActivity.this, CategoryActivity.class);
        intent.putExtra(HomeActivity.EXTRA_CATEGORY,(Serializable)datalist);
        intent.putExtra(HomeActivity.EXTRA_POS,pos);
        startActivity(intent);

    }










    /*public void getData()
    {
        arrayList=new ArrayList<>();



        String url="https://www.themealdb.com/api/json/v1/1/categories.php";

        RequestQueue requestQueue=Volley.newRequestQueue(this);

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jsonObject=new JSONObject(response.toString());

                    JSONArray jsonArray=jsonObject.getJSONArray("categories");

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject temp=jsonArray.getJSONObject(i);
                        CategoryData categoryData=new CategoryData(temp.getString("strCategory"),temp.getString("strCategoryThumb"));
                        arrayList.add(categoryData);



                    }

                    prepareRecyclerView();





                }
                catch (Exception e){}







            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        requestQueue.add(stringRequest);
    }*/




}
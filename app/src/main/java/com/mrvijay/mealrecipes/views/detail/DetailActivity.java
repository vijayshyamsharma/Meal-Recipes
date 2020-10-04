package com.mrvijay.mealrecipes.views.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mrvijay.mealrecipes.R;
import com.mrvijay.mealrecipes.models.Meals;
import com.mrvijay.mealrecipes.others.Utils;
import com.google.android.material.appbar.MaterialToolbar;




public class DetailActivity extends AppCompatActivity implements DetailView {


    MaterialToolbar toolbar;

    ImageView mealImg;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ProgressBar progressBar;
    TextView mealCat;
    TextView mealCountry;
    TextView instructions;
    TextView youtube;
    TextView source;
    TextView ingredient;
    TextView measure;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar=findViewById(R.id.toolbar);
        mealImg=findViewById(R.id.mealThumb);
        collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar);
        progressBar=findViewById(R.id.progressBar);
        mealCat=findViewById(R.id.category);
        mealCountry=findViewById(R.id.country);
        instructions=findViewById(R.id.instructions);
        youtube=findViewById(R.id.youtube);
        source=findViewById(R.id.source);

        ingredient=findViewById(R.id.ingredient);
        measure=findViewById(R.id.measure);

        setupActionBar();



        Intent in=getIntent();

        String mealName=in.getStringExtra("EXTRA_DETAILS");

        DetailPresenter detailPresenter=new DetailPresenter(this);
        detailPresenter.getMealByName(mealName);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }



    private void setupActionBar()
    {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));


        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showLoading() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onErrorLoading(String message) {

        Utils.showDialogMessage(this,"Error",message);

    }

    @Override
    public void setMeal(Meals.Meal meal) {

        Glide.with(this).load(meal.getStrMealThumb()).placeholder(R.drawable.shadow_button_to_top).centerCrop().into(mealImg);
        collapsingToolbarLayout.setTitle(meal.getStrMeal());
        mealCat.setText(meal.getStrCategory());
        mealCountry.setText(meal.getStrArea());
        instructions.setText(meal.getStrInstructions());

        setIngredient(meal);
        setMeasure(meal);


        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(meal.getStrYoutube()!=null && !meal.getStrYoutube().isEmpty())
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(meal.getStrYoutube()));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(DetailActivity.this, "not available", Toast.LENGTH_SHORT).show();
                }

            }
        });

        source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(meal.getStrSource()!=null && !meal.getStrSource().isEmpty())
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(meal.getStrSource()));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(DetailActivity.this, "not available", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    void setIngredient(Meals.Meal meal)
    {


        if(meal.getStrIngredient1()!=null && meal.getStrIngredient1 ().length()!=0)ingredient.append("* "+meal.getStrIngredient1()+"\n");

       if(meal.getStrIngredient2()!=null && meal.getStrIngredient2().length()!=0)ingredient.append("* "+meal.getStrIngredient2()+"\n");

       if(meal.getStrIngredient3()!=null && meal.getStrIngredient3().length()!=0)ingredient.append("* "+meal.getStrIngredient3()+"\n");

        if(meal.getStrIngredient4()!=null && meal.getStrIngredient4().length()!=0)ingredient.append("* "+meal.getStrIngredient4()+"\n");

        if(meal.getStrIngredient5()!=null && meal.getStrIngredient5().length()!=0)ingredient.append("* "+meal.getStrIngredient5()+"\n");

    if(meal.getStrIngredient6()!=null && meal.getStrIngredient6().length()!=0)ingredient.append("* "+meal.getStrIngredient6()+"\n");

       if(meal.getStrIngredient7()!=null && meal.getStrIngredient7().length()!=0)ingredient.append("* "+meal.getStrIngredient7()+"\n");

      if(meal.getStrIngredient8()!=null && meal.getStrIngredient8().length()!=0)ingredient.append("* "+meal.getStrIngredient8()+"\n");

     if(meal.getStrIngredient9()!=null && meal.getStrIngredient9().length()!=0)ingredient.append("* "+meal.getStrIngredient9()+"\n");

      if(meal.getStrIngredient10()!=null && meal.getStrIngredient10().length()!=0)ingredient.append("* "+meal.getStrIngredient10()+"\n");

    if(meal.getStrIngredient11()!=null && meal.getStrIngredient11().length()!=0)ingredient.append("* "+meal.getStrIngredient11()+"\n");

       if(meal.getStrIngredient12()!=null && meal.getStrIngredient12().length()!=0)ingredient.append("* "+meal.getStrIngredient12()+"\n");

         if(meal.getStrIngredient13()!=null && meal.getStrIngredient13().length()!=0)ingredient.append("* "+meal.getStrIngredient13()+"\n");

         if(meal.getStrIngredient14()!=null && meal.getStrIngredient14().length()!=0)ingredient.append("* "+meal.getStrIngredient14()+"\n");

         if(meal.getStrIngredient15()!=null && meal.getStrIngredient15().length()!=0)ingredient.append("* "+meal.getStrIngredient15()+"\n");

       if(meal.getStrIngredient16()!=null && meal.getStrIngredient16().length()!=0)ingredient.append("* "+meal.getStrIngredient16()+"\n");

         if(meal.getStrIngredient17()!=null && meal.getStrIngredient17().length()!=0)ingredient.append("* "+meal.getStrIngredient17()+"\n");

        if(meal.getStrIngredient18()!=null && meal.getStrIngredient18().length()!=0)ingredient.append("* "+meal.getStrIngredient18()+"\n");

         if(meal.getStrIngredient19()!=null && meal.getStrIngredient19().length()!=0)ingredient.append("* "+meal.getStrIngredient19()+"\n");

         if(meal.getStrIngredient20()!=null && meal.getStrIngredient20().length()!=0)ingredient.append("* "+meal.getStrIngredient20()+"\n");


    }

    void setMeasure(Meals.Meal meal)
    {
        if(meal.getStrMeasure1()!=null && meal.getStrMeasure1().length()!=0)measure.append(": "+meal.getStrMeasure1()+"\n");

         if(meal.getStrMeasure2()!=null && meal.getStrMeasure2().length()!=0)measure.append(": "+meal.getStrMeasure2()+"\n");

      if(meal.getStrMeasure3()!=null && meal.getStrMeasure3().length()!=0)measure.append(": "+meal.getStrMeasure3()+"\n");

        if(meal.getStrMeasure4()!=null && meal.getStrMeasure4().length()!=0)measure.append(": "+meal.getStrMeasure4()+"\n");

   if(meal.getStrMeasure5()!=null && meal.getStrMeasure5().length()!=0)measure.append(": "+meal.getStrMeasure5()+"\n");

       if(meal.getStrMeasure6()!=null && meal.getStrMeasure6().length()!=0)measure.append(": "+meal.getStrMeasure6()+"\n");

       if(meal.getStrMeasure7()!=null && meal.getStrMeasure7().length()!=0)measure.append(": "+meal.getStrMeasure7()+"\n");

        if(meal.getStrMeasure8()!=null && meal.getStrMeasure8().length()!=0)measure.append(": "+meal.getStrMeasure8()+"\n");

      if(meal.getStrMeasure9()!=null && meal.getStrMeasure9().length()!=0)measure.append(": "+meal.getStrMeasure9()+"\n");

        if(meal.getStrMeasure10()!=null && meal.getStrMeasure10().length()!=0)measure.append(": "+meal.getStrMeasure10()+"\n");

       if(meal.getStrMeasure11()!=null && meal.getStrMeasure11().length()!=0)measure.append(": "+meal.getStrMeasure11()+"\n");

      if(meal.getStrMeasure12()!=null && meal.getStrMeasure12().length()!=0)measure.append(": "+meal.getStrMeasure12()+"\n");

       if(meal.getStrMeasure13()!=null && meal.getStrMeasure13().length()!=0)measure.append(": "+meal.getStrMeasure13()+"\n");

        if(meal.getStrMeasure14()!=null && meal.getStrMeasure14().length()!=0)measure.append(": "+meal.getStrMeasure14()+"\n");

        if(meal.getStrMeasure15()!=null && meal.getStrMeasure15().length()!=0)measure.append(": "+meal.getStrMeasure15()+"\n");

        if(meal.getStrMeasure16()!=null && meal.getStrMeasure16().length()!=0)measure.append(": "+meal.getStrMeasure16()+"\n");

        if(meal.getStrMeasure17()!=null && meal.getStrMeasure17().length()!=0)measure.append(": "+meal.getStrMeasure17()+"\n");

         if(meal.getStrMeasure18()!=null && meal.getStrMeasure18().length()!=0)measure.append(": "+meal.getStrMeasure18()+"\n");

         if(meal.getStrMeasure19()!=null && meal.getStrMeasure19().length()!=0)measure.append(": "+meal.getStrMeasure19()+"\n");

         if(meal.getStrMeasure20()!=null && meal.getStrMeasure20().length()!=0)measure.append(": "+meal.getStrMeasure20()+"\n");
    }






}
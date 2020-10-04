package com.mrvijay.mealrecipes.views.category;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrvijay.mealrecipes.R;
import com.mrvijay.mealrecipes.adapters.RecyclerViewMealByCategoryAdapter;
import com.mrvijay.mealrecipes.models.Meals;
import com.mrvijay.mealrecipes.others.Utils;
import com.mrvijay.mealrecipes.views.detail.DetailActivity;

import java.util.List;

public class CategoryFragment extends Fragment implements CategoryView, View.OnClickListener, RecyclerViewMealByCategoryAdapter.MealClickInterface {

    List<Meals.Meal> mealList;

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ImageView imageCat,imageCatBG;
    TextView textCat;

    AlertDialog.Builder builder;

    CardView cardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_category,container,false);

        recyclerView=view.findViewById(R.id.recyclerView);
        progressBar=view.findViewById(R.id.progressBar);
        imageCat=view.findViewById(R.id.imageCategory);
        imageCatBG=view.findViewById(R.id.imageCategoryBg);
        textCat=view.findViewById(R.id.textCategory);
        cardView=view.findViewById(R.id.cardCategory);

        cardView.setOnClickListener(this);



        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getArguments()!=null)
        {
            textCat.setText(getArguments().getString("EXTRA_DATA_DESC"));

            Glide.with(requireContext()).load(getArguments().getString("EXTRA_DATA_IMAGE")).into(imageCat);

            Glide.with(requireContext()).load(getArguments().getString("EXTRA_DATA_IMAGE")).into(imageCatBG);

            builder=new AlertDialog.Builder(getActivity())
                    .setTitle(getArguments().getString("EXTRA_DATA_NAME"))
                    .setMessage(getArguments().getString("EXTRA_DATA_DESC"));

            CategoryPresenter categoryPresenter=new CategoryPresenter(this);
            categoryPresenter.getMealByCategory(getArguments().getString("EXTRA_DATA_NAME"));


        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }



    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(getActivity(), "Error ", message);
    }

    @Override
    public void setMeals(List<Meals.Meal> meals) {

        mealList=meals;

        RecyclerViewMealByCategoryAdapter recyclerViewMealByCategoryAdapter=new RecyclerViewMealByCategoryAdapter(getActivity(),meals,this);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setClipToPadding(false);
        recyclerView.setAdapter(recyclerViewMealByCategoryAdapter);
        recyclerViewMealByCategoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

        int id=view.getId();

        switch (id)
        {
            case R.id.cardCategory:
                builder.setPositiveButton("CLOSE",(dialog,which)->dialog.dismiss());
                builder.show();
                break;
        }
    }

    @Override
    public void onMealClick(String mealName) {

        Intent intent=new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("EXTRA_DETAILS",mealName);
        startActivity(intent);


    }
}

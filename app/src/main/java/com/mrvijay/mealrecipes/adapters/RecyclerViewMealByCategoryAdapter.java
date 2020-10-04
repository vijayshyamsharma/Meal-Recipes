package com.mrvijay.mealrecipes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrvijay.mealrecipes.R;
import com.mrvijay.mealrecipes.models.Meals;

import java.util.List;

public class RecyclerViewMealByCategoryAdapter extends RecyclerView.Adapter<RecyclerViewMealByCategoryAdapter.MyViewHolder> {

    Context context;
    List<Meals.Meal> meals;

    MealClickInterface mealClickInterface;

    public RecyclerViewMealByCategoryAdapter() {
    }

    public RecyclerViewMealByCategoryAdapter(Context context, List<Meals.Meal> meals,MealClickInterface mealClickInterface) {
        this.context = context;
        this.meals = meals;
        this.mealClickInterface=mealClickInterface;
    }

    @NonNull
    @Override
    public RecyclerViewMealByCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_reycyclerview_item,parent,false);

        return new MyViewHolder(view,mealClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMealByCategoryAdapter.MyViewHolder holder, int position) {

        holder.mealName.setText(meals.get(position).getStrMeal());

        Glide.with(context).load(meals.get(position).getStrMealThumb()).placeholder(R.drawable.shadow_button_to_top).centerCrop().into(holder.mealImg);


    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView mealImg;
        TextView mealName;

        MealClickInterface mealClickInterface;

        public MyViewHolder(@NonNull View itemView,MealClickInterface mealClickInterface) {
            super(itemView);

            mealImg=itemView.findViewById(R.id.mealThumb);
            mealName=itemView.findViewById(R.id.mealName);
            this.mealClickInterface=mealClickInterface;

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            mealClickInterface.onMealClick(mealName.getText().toString());
        }
    }

    public interface MealClickInterface
    {
        void onMealClick(String mealName);
    }
}

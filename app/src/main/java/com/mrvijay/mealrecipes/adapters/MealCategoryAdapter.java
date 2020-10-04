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
import com.mrvijay.mealrecipes.models.CategoryData;


import java.util.List;

public class MealCategoryAdapter extends RecyclerView.Adapter<MealCategoryAdapter.MyViewHolder> {

    Context context;
    List<CategoryData.Category> arrayList;

    ItemClickListener itemClickListener;



    public MealCategoryAdapter(Context context, List<CategoryData.Category> arrayList,ItemClickListener itemClickListener) {

        this.context=context;
        this.arrayList=arrayList;
        this.itemClickListener=itemClickListener;


    }

    @NonNull
    @Override
    public MealCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(view,itemClickListener);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealCategoryAdapter.MyViewHolder holder, int position) {


        CategoryData.Category data=arrayList.get(position);

        holder.catname.setText(data.getStrCategory());

        Glide.with(context).load(data.getStrCategoryThumb()).placeholder(R.drawable.ic_circle).centerCrop().into(holder.catimg);



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView catimg;
        TextView catname;
        ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
            super(itemView);

            catimg=itemView.findViewById(R.id.categoryThumb);
            catname=itemView.findViewById(R.id.categoryName);
            this.itemClickListener=itemClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            itemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface ItemClickListener
    {
        void onItemClick(int pos);
    }

}

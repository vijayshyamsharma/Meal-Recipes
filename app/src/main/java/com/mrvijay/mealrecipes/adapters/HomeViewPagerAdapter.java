package com.mrvijay.mealrecipes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.mrvijay.mealrecipes.R;
import com.mrvijay.mealrecipes.models.CategoryData;

import java.util.ArrayList;
import java.util.List;

public class HomeViewPagerAdapter extends PagerAdapter {

    private List<CategoryData.Category> meals;
    private Context context;
    private ViewPager viewPager;


    public HomeViewPagerAdapter(Context context, List<CategoryData.Category> meals,ViewPager viewPager) {
        this.context = context;
        this.meals = meals;
        this.viewPager=viewPager;
    }

    public HomeViewPagerAdapter() {
    }


    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.upperviewpager,
                container,
                false
        );

       if (position==0)
       {
           viewPager.setPadding(16,0,40,0);
       }
       else if(position==(meals.size()-1))
       {
           viewPager.setPadding(40,0,16,0);
       }
       else if(position>0)
       {
           viewPager.setPadding(40,0,40,0);
       }

        ImageView mealThumb = view.findViewById(R.id.mealThumb);
        TextView mealName = view.findViewById(R.id.mealName);

        mealName.setText(meals.get(position).getStrCategory());

        Glide.with(context).load(meals.get(position).getStrCategoryThumb()).placeholder(R.drawable.ic_circle).centerCrop()
                .into(mealThumb);



        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public interface ClickListener {
        void onClick(View v, int position);
    }
}
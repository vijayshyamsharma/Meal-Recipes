package com.mrvijay.mealrecipes.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mrvijay.mealrecipes.models.CategoryData;
import com.mrvijay.mealrecipes.views.category.CategoryFragment;

import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    private List<CategoryData.Category> categories;

    public ViewPagerCategoryAdapter(FragmentManager fragmentManager, List<CategoryData.Category> categories)
    {
        super(fragmentManager);
        this.categories=categories;

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        CategoryFragment categoryFragment=new CategoryFragment();

        Bundle args=new Bundle();

        args.putString("EXTRA_DATA_NAME",categories.get(position).getStrCategory());
        args.putString("EXTRA_DATA_DESC",categories.get(position).getStrCategoryDescription());
        args.putString("EXTRA_DATA_IMAGE",categories.get(position).getStrCategoryThumb());

        categoryFragment.setArguments(args);

        return categoryFragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getStrCategory();
    }
}

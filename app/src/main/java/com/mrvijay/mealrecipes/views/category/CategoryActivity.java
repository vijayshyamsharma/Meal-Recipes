package com.mrvijay.mealrecipes.views.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.mrvijay.mealrecipes.R;
import com.mrvijay.mealrecipes.adapters.ViewPagerCategoryAdapter;
import com.mrvijay.mealrecipes.models.CategoryData;
import com.mrvijay.mealrecipes.views.home.HomeActivity;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    MaterialToolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    ViewPagerCategoryAdapter viewPagerCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        toolbar=findViewById(R.id.toolbarcategory);
        viewPager=findViewById(R.id.viewpagercategory);
        tabLayout=findViewById(R.id.tabscategory);


        initActionBar();
        initIntent();
    }

    private void initIntent()
    {
        Intent intent=getIntent();

        List<CategoryData.Category> categories=(List<CategoryData.Category>) intent.getSerializableExtra(HomeActivity.EXTRA_CATEGORY);
        int pos=intent.getIntExtra(HomeActivity.EXTRA_POS,0);

        viewPagerCategoryAdapter=new ViewPagerCategoryAdapter(getSupportFragmentManager(),categories);

        viewPager.setAdapter(viewPagerCategoryAdapter);

        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(pos,true);

        viewPagerCategoryAdapter.notifyDataSetChanged();


    }
    private void initActionBar()
    {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
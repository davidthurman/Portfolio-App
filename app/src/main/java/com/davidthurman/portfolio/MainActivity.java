package com.davidthurman.portfolio;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int currentMenuItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_menu_item:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.interests_menu_item:
                        viewPager.setCurrentItem(1);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(currentMenuItem).setChecked(false);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                currentMenuItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });
    }
}


package com.example.entreclub.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.entreclub.R;
import com.example.entreclub.utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


//Responsible for Recommendation,Messages,Icon

public class  MainActivity extends AppCompatActivity {
    private Context mContext = MainActivity.this;
    private static final int ACTIVITY_NUM = 0;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting");
        setupbottomnavigationview();
        setupviewpager();    }


    private void setupviewpager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RecommendationFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessageFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container); //container from centre viewpager
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_recom);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_iconfinal);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_message);    }


    //bottom navigation setup
    private void setupbottomnavigationview(){
        Log.d(TAG, "setupbottomnavigationview: Setting up Bottom Navigation View");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomnav);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enablenavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = ((Menu) menu).getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }

}

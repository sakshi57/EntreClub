package com.example.entreclub.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.entreclub.R;
import com.example.entreclub.Registration.RegistrationActivity;
import com.example.entreclub.utils.BottomNavigationViewHelper;
import com.example.entreclub.utils.RecyclerViewAdapter;
import com.example.entreclub.utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;


//Responsible for Recommendation,Messages,Icon

public class  MainActivity extends AppCompatActivity {
    private Context mContext = MainActivity.this;
    private static final int ACTIVITY_NUM = 0;
    private static final String TAG = "MainActivity";
    private Button b;
    private ImageButton b1;
    private ImageButton b2;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1 = (ImageButton)findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Recommendation.class);
                startActivity(i);
            }
        });

        //register btn
        b = (Button)findViewById(R.id.button2) ;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });

        b2 = (ImageButton)findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });

        Log.d(TAG, "onCreate: Starting");
        initImageLoader();
        setupbottomnavigationview();
       // setupviewpager();
        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        String services[] = {"Sakshi","Nikhil","Shruti","Vedang","Sagar","Anuj","Mallika"};
        String des[] = {"Glide supports fetching, decoding, and displaying video stills, images, and animated GIFs. Glide includes a flexible API that allows developers to plug in to almost any network stack. By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug in to Google's Volley project or Square's OkHttp library instead.","By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ","By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ","By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ","By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ","By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug ","By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug "};
        recycler_view.setAdapter(new RecyclerViewAdapter(services));




    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }



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

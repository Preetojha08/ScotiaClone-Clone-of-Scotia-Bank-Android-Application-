package com.example.scotiabankjavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    ImageView logoutBtn,profileBtn,seacrchBtn;
    boolean logoutFlag = true;
    Handler handler = new Handler();
    ViewPager2 viewPager2;
    LinearLayout move_money_ll;

    TextView homeGreeting_tv;
    Calendar calendar;
    String greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        viewPager2 = findViewById(R.id.viewpager_test);
        // Data for cards
        String[] cardNames = {"Debit Card", "Credit Card", "Forex Card"};
        String[] balances = {"$10,000.00", "$1500.78", "$5000.00"};

        // Create and set the adapter for ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(cardNames, balances);
        viewPager2.setAdapter(adapter);

        User user = new User();
        homeGreeting_tv = (TextView) findViewById(R.id.home_greeting_textview);
        // to Get current hour with help of Calendar Class
        calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String sirname = user.getFirstName() + " " + user.getLastName();

        // Determine the greeting message
        if (hour >= 5 && hour < 12) {
            greeting = "Good Morning, "+sirname;
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon, "+sirname;
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good Evening, "+sirname;
        } else {
            greeting = "Welcome, Sir!";
        }


        homeGreeting_tv.setText(greeting);


        seacrchBtn = (ImageView) findViewById(R.id.search_img_btn);


        move_money_ll=(LinearLayout) findViewById(R.id.home_move_money_layout);

        move_money_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,MoveMoneyActivity.class));
            }
        });

        if (logoutFlag)
        {
            Log.d("Logout", "Yeh kses run hoga agar ye wala hoga toh problem hogi"+logoutFlag);
            handler.postDelayed(runnable, 50000000);
        }
//        50000
        logoutBtn = (ImageView) findViewById(R.id.homeLogoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutFlag = false;
                logoutFunction();
            }
        });

        profileBtn = (ImageView) findViewById(R.id.homeProfileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });

    }
    public void logoutFunction() {
        Toast.makeText(HomeActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        Log.d("Logout", "Logout Successful jjjjj    "+logoutFlag);
        finish();
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //to logout the user
            logoutFunction();
        }
    };


}
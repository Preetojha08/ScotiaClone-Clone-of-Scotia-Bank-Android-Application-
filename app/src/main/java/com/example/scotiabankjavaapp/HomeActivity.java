package com.example.scotiabankjavaapp;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

//Save all the data in the shared Preference so ,uje intent se pass kar va na pade
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
        //        -----------------
        // Retrieve the passed User object, card names, and balances from the intent
        User user = (User) getIntent().getSerializableExtra("user");
        ArrayList<String> cardNames = (ArrayList<String>) getIntent().getSerializableExtra("cardNames");
        ArrayList<String> balances = (ArrayList<String>) getIntent().getSerializableExtra("balances");

        if (user != null) {
            // Prepare the user details to display in the TextView
            StringBuilder userInfo = new StringBuilder();
            userInfo.append("Username: ").append(user.getUsername()).append("\n")
                    .append("First Name: ").append(user.getFirstName()).append("\n")
                    .append("Last Name: ").append(user.getLastName()).append("\n")
                    .append("Email: ").append(user.getEmail()).append("\n")
                    .append("Date of Birth: ").append(user.getDob()).append("\n")
                    .append("Gender: ").append(user.getGender()).append("\n");

            // If cards are available, display the card details from the arrays
            if (cardNames != null && balances != null && cardNames.size() > 0) {
                userInfo.append("\nCard Details:\n");
                for (int i = 0; i < cardNames.size(); i++) {
                    userInfo.append("Card Name: ").append(cardNames.get(i)).append("\n")
                            .append("Balance: ").append(balances.get(i)).append("\n\n");
                }
            } else {
                userInfo.append("\nNo cards available.");
            }

            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            // Storing user data as key-value pairs
            editor.putString("username", user.getUsername());
            editor.putString("firstName", user.getFirstName());
            editor.putString("lastName", user.getLastName());
            editor.putString("email", user.getEmail());
            editor.putString("dob", user.getDob());
            editor.putString("gender", user.getGender());
            editor.putString("Userlogin".toString(), "true");
            // Commit the changes
            editor.apply();

//            // Display the information in the TextView
//            Toast.makeText(this, userInfo.toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "Card Name: "+cardNames.toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "Card Name: "+balances.toString(), Toast.LENGTH_SHORT).show();
        } else {
            // If no user data is passed, display an error message
            Toast.makeText(this, "User data not found", Toast.LENGTH_SHORT).show();
        }

        //-----------

        viewPager2 = findViewById(R.id.viewpager_test);
        // Data for cards
//        String[] cardNames = {"Debit Card", "Credit Card", "Forex Card"};
//        String[] balances = {"$10,000.00", "$1500.78", "$5000.00"};

        // Create and set the adapter for ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(cardNames, balances);
        viewPager2.setAdapter(adapter);

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
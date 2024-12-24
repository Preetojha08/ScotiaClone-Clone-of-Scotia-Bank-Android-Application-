package com.example.scotiabankjavaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn;
    EditText log_username_edt, log_password_edt;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String logincheck = sharedPreferences.getString("Userlogin", "");

        if (logincheck.equalsIgnoreCase("true")) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        // Initialize views
        log_username_edt = findViewById(R.id.login_edittext_username);
        log_password_edt = findViewById(R.id.login_edittext_password);
        btn = findViewById(R.id.login_button);

        // Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Set button click listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = log_username_edt.getText().toString().trim();
                String password = log_password_edt.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    validateLogin(username, password);
                }
            }
        });
    }

    private void validateLogin(String inputUsername, String inputPassword) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean isValidUser = false;

                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);

                    if (user != null && user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                        isValidUser = true;

                        // Log the user details
                        Log.d("MainActivity", "User Info: " +
                                "Username: " + user.getUsername() +
                                ", First Name: " + user.getFirstName() +
                                ", Last Name: " + user.getLastName() +
                                ", Email: " + user.getEmail() +
                                ", Date of Birth: " + user.getDob() +
                                ", Gender: " + user.getGender());

                        // Create arrays for card details
                        ArrayList<String> cardNames = new ArrayList<>();
                        ArrayList<String> balances = new ArrayList<>();

                        if (user.getCards() != null) {
                            for (String cardKey : user.getCards().keySet()) {
                                Card card = user.getCards().get(cardKey);
                                cardNames.add(card.getCardName());
                                balances.add(String.valueOf(card.getBalance())); // Convert balance to string
                            }
                        }

                        // Pass user and card details to the next activity
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("user", user); // Pass the User object
                        intent.putExtra("cardNames", cardNames); // Pass card names
                        intent.putExtra("balances", balances); // Pass card balances
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                        break;
                    }
                }

                if (!isValidUser) {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Database error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", "Database error: ", error.toException());
            }
        });
    }


}

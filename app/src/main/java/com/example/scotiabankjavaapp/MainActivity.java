package com.example.scotiabankjavaapp;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn;
    EditText log_username_edt, log_password_edt;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                        // Show the user details in a Toast
                        String userInfo = "Username: " + user.getUsername() + "\n" +
                                "First Name: " + user.getFirstName() + "\n" +
                                "Last Name: " + user.getLastName() + "\n" +
                                "Email: " + user.getEmail() + "\n" +
                                "Date of Birth: " + user.getDob() + "\n" +
                                "Gender: " + user.getGender();

                        // Add card details to the user information
                        StringBuilder cardInfo = new StringBuilder("\nCard Details:\n");
                        if (user.getCards() != null) {
                            for (String cardKey : user.getCards().keySet()) {
                                Card card = user.getCards().get(cardKey); // Get card details
                                cardInfo.append("Card Name: ").append(card.getCardName()).append("\n")
                                        .append("Balance: ").append(card.getBalance()).append("\n\n");
                            }
                        }

                        // Display both user and card details in Toast
                        Toast.makeText(MainActivity.this, userInfo + cardInfo.toString(), Toast.LENGTH_LONG).show();
                        // Display user and card details in Toast
                        Toast.makeText(MainActivity.this,cardInfo.toString(), Toast.LENGTH_LONG).show();


                        // Show success message
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        // Pass user data (including cards) to the next activity
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("user", user); // Pass the User object (which includes card details)
                        intent.putExtra("cards", user.getCards()); // Pass the Cards object (Map of cards)
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

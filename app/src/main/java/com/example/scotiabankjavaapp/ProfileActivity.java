package com.example.scotiabankjavaapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {


    ListView listViewAcc ;
    ListView listViewApp;
    ArrayAdapter<String> arrapp;
    ArrayAdapter<String> arracc;
    String[] accInfoItems={"Account Display","Manage Autodeposit","Manage Interac Registration","Manage Credit Score","Edit Transaction Limit" };
    String[] appInfoItems={"Application Theme","Application Language","Manage Widgets"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        arracc = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,accInfoItems);
        listViewAcc.setAdapter(arracc);

        arrapp.add("Application Theme");
        arrapp.add("Application Language");
        arrapp.add("Manage Widgets");

        arrapp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,appInfoItems);
        listViewApp.setAdapter(arrapp);


    }
}
package com.example.scotiabankjavaapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {


    ListView listViewAcc ;
    ListView listViewApp;
    ArrayAdapter<String> arrapp;
    ArrayAdapter<String> arracc;
    String[] accInfoItems={"Account Display","Manage Autodeposit","Manage Interac Registration","Manage Credit Score","Edit Transaction Limit" };
    String[] appInfoItems={"Application Theme","Application Language","Manage Widgets"};

    List<String> appInfo;
    List<String> accInfo;

    List<Integer> appInfoIcons;
    List<Integer> accInfoIcons;

    RecyclerViewAdapter recyclerViewAdapteracc;
    RecyclerViewAdapter recyclerViewAdapterapp;
    RecyclerView recyclerView_appInfo;
    RecyclerView recylerView_accInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

//        arracc = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,accInfoItems);
//        listViewAcc.setAdapter(arracc);
//
//        arrapp.add("Application Theme");
//        arrapp.add("Application Language");
//        arrapp.add("Manage Widgets");
//
//        arrapp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,appInfoItems);
//        listViewApp.setAdapter(arrapp);

        recylerView_accInfo=(RecyclerView)findViewById(R.id.accountrecyclerview);
        recyclerView_appInfo=(RecyclerView)findViewById(R.id.apprecyclerview);

        //Application Info Data
        appInfo = new ArrayList<>();
        appInfo.add("Application Theme");
        appInfo.add("Application Language");
        appInfo.add("Manage Widgets");

        appInfoIcons = new ArrayList<>();
        appInfoIcons.add(R.drawable.theme);
        appInfoIcons.add(R.drawable.banklanguage);
        appInfoIcons.add(R.drawable.appwidgets);

        //RecyclerView for Application Info
        recyclerViewAdapterapp = new RecyclerViewAdapter(this,appInfo,appInfoIcons);

        recyclerView_appInfo.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        recyclerView_appInfo.setAdapter(recyclerViewAdapterapp);

        //Account Info Data
        accInfo = new ArrayList<>();
        accInfo.add("Account Display");
        accInfo.add("Manage Autodeposit");
        accInfo.add("Manage Interac Registration");
        accInfo.add("Manage Credit Score");
        accInfo.add("Edit Transaction Limit");
        //Image List of Account Info
        accInfoIcons = new ArrayList<>();
        accInfoIcons.add(R.drawable.displayacc);
        accInfoIcons.add(R.drawable.autodeposit);
        accInfoIcons.add(R.drawable.accinteract);
        accInfoIcons.add(R.drawable.credit_score);
        accInfoIcons.add(R.drawable.acclimitedmoney);

        //RecyclerView for Account Info
        recyclerViewAdapteracc = new RecyclerViewAdapter(this,accInfo,accInfoIcons);

        recylerView_accInfo.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        recylerView_accInfo.setAdapter(recyclerViewAdapteracc);

    }
}
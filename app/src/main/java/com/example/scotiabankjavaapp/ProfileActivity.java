package com.example.scotiabankjavaapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.content.SharedPreferences;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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

    TextView pro_username_tv,pro_email_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        pro_email_tv = (TextView)findViewById(R.id.profile_display_email);
        pro_username_tv = (TextView) findViewById(R.id.profile_display_username);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        String firstName = sharedPreferences.getString("firstName", "Default First Name");
        String lastName = sharedPreferences.getString("lastName", "Default Last Name");
        String email = sharedPreferences.getString("email", "Default Email");

        String fullname = firstName+" "+lastName;
        pro_username_tv.setText(fullname);
        pro_email_tv.setText(email);

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
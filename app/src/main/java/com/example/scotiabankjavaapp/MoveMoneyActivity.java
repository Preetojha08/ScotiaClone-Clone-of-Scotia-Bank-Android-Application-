package com.example.scotiabankjavaapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MoveMoneyActivity extends AppCompatActivity {

    String[] interact={"Interact E-Transfer","Request E-Transfer","Manage E-Transfer"};
    String[] otherpay={"Transfer Between Accounts","Deposit a Cheque","Pay Bills"};
    String[] international={"Send Money Across The World"};

    RecyclerView recyclerView_interact;
    RecyclerView recyclerView_otherpay;
    RecyclerView recyclerView_international;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_money);

        recyclerView_interact = (RecyclerView) findViewById(R.id.move_money_interact_rv);
        recyclerView_otherpay = (RecyclerView) findViewById(R.id.move_money_other_pay_rv);
        recyclerView_international = (RecyclerView) findViewById(R.id.move_money_international_rv);

        List<String> interact_list = new ArrayList<>();
        List<String> other_pay_list = new ArrayList<>();
        List<String> international_list = new ArrayList<>();

        interact_list.add("Interact E-Transfer");
        interact_list.add("Request E-Transfer");
        interact_list.add("Manage E-Transfer");

        other_pay_list.add("Transfer Between Accounts");
        other_pay_list.add("Deposit a Cheque");
        other_pay_list.add("Pay Bills");

        international_list.add("Send Money Across The World");

        RecyclerViewAdapter adapter_interact = new RecyclerViewAdapter(this,interact_list,10);
        recyclerView_interact.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_interact.setAdapter(adapter_interact);

        RecyclerViewAdapter adapter_otherpay = new RecyclerViewAdapter(this,other_pay_list,10);
        recyclerView_otherpay.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_otherpay.setAdapter(adapter_otherpay);

        RecyclerViewAdapter adapter_international = new RecyclerViewAdapter(this,international_list,10);
        recyclerView_international.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView_international.setAdapter(adapter_international);



    }
}
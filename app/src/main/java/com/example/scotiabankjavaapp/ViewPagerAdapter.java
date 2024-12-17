package com.example.scotiabankjavaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder> {

    private String[] cardNames;
    private String[] balances;

    public ViewPagerAdapter(String[] cardNames, String[] balances) {
        this.cardNames = cardNames;
        this.balances = balances;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.Pager2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false);
        return new Pager2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.Pager2ViewHolder holder, int position) {
        holder.cardName.setText(cardNames[position]);
        holder.balance.setText(balances[position]);
    }

    @Override
    public int getItemCount() {
        return cardNames.length;
    }

    public class Pager2ViewHolder extends RecyclerView.ViewHolder {
        TextView cardName, balance;

        public Pager2ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardName = itemView.findViewById(R.id.cardTitle);  // Update cardTitle id to match in layout
            balance = itemView.findViewById(R.id.accountbalance);
        }
    }
}

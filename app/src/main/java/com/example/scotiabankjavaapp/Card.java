package com.example.scotiabankjavaapp;
import java.io.Serializable;

public class Card implements Serializable {
    private String cardName;
    private double balance;

    // Getters and setters
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

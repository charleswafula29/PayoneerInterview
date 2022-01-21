package com.charles.payoneertest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.charles.payoneertest.databinding.ActivityBankDetailsBinding;
import com.charles.payoneertest.pojos.ApplicableItem;
import com.charles.payoneertest.pojos.Payment;
import com.charles.payoneertest.utils.Utils;
import com.google.gson.Gson;

public class BankDetails extends AppCompatActivity {

    private ActivityBankDetailsBinding binding;
    private ApplicableItem applicableItem = new ApplicableItem();
    private Payment payment = new Payment();
    private final Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        applicableItem = gson.fromJson(intent.getStringExtra(Utils.SELECTED_CODE),ApplicableItem.class);
        payment = gson.fromJson(intent.getStringExtra(Utils.AMOUNT),Payment.class);

        if(applicableItem!=null){
            setCardDetails();
        }

    }

    @SuppressLint("SetTextI18n")
    private void setCardDetails() {
        binding.cardName.setText(applicableItem.getLabel());
        Utils.setBitmapFromUrl(applicableItem.getLinks().getLogo(), binding.cardLogo);
        Utils.setDynamicFields(applicableItem.getInputElements(), binding.container,this);
        binding.amount.setText(payment.getCurrency()+" "+payment.getAmount());
    }
}
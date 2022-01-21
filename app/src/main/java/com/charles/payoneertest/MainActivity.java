package com.charles.payoneertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.charles.payoneertest.databinding.ActivityMainBinding;
import com.charles.payoneertest.pojos.ApplicableItem;
import com.charles.payoneertest.pojos.CheckoutListResponse;
import com.charles.payoneertest.utils.GeneralAsyncTask;
import com.charles.payoneertest.utils.HTTPCallback;
import com.charles.payoneertest.utils.ProgressBarAnimation;
import com.charles.payoneertest.utils.Utils;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {
    private final Gson gson = new Gson();
    private CheckoutListResponse listResponse = new CheckoutListResponse();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        animateLoader();

        getCheckoutList();

        binding.find.setOnClickListener( v -> {
            if (listResponse!=null){
                Optional<ApplicableItem> applicableItem = listResponse.getNetworks().getApplicable()
                        .stream().parallel().filter(r -> r.getCode().contentEquals(binding.paymentMethod.getText().toString().toUpperCase().trim())).findFirst();

                if (!applicableItem.isPresent()){
                    showError(getString(R.string.not_records_found));
                }else {
                    Intent intent = new Intent(this,BankDetails.class);
                    intent.putExtra(Utils.SELECTED_CODE, gson.toJson(applicableItem.get()));
                    intent.putExtra(Utils.AMOUNT, gson.toJson(listResponse.getPayment()));
                    startActivity(intent);
                }

            }else {
                showError(getString(R.string.list_not_availabe));
                binding.loader.setVisibility(View.VISIBLE);
                getCheckoutList();
            }
        });

    }

    private void animateLoader() {
        binding.loader.setVisibility(View.VISIBLE);
        ProgressBarAnimation anim = new ProgressBarAnimation(binding.progressBar, 0, 100);
        anim.setDuration(1000);
        binding.progressBar.startAnimation(anim);
    }

    private void showError(String string) {
        Snackbar.make(binding.getRoot(), string, Snackbar.LENGTH_LONG).show();
    }

    private void getCheckoutList() {
        new GeneralAsyncTask(Utils.GET_CHECKOUT_LIST,
                new HTTPCallback() {
                    @Override
                    public void processFinish(String output) {
                        binding.loader.setVisibility(View.GONE);
                        listResponse = gson.fromJson(output, CheckoutListResponse.class);
                    }

                    @Override
                    public void processFailed(int responseCode, String output) {
                        Log.e( "processFailed: ", responseCode+"  "+output);
                        showError(output+" :"+responseCode);
                        binding.loader.setVisibility(View.GONE);
                    }
                }).execute();
    }
}
package com.charles.payoneertest.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.charles.payoneertest.R;
import com.charles.payoneertest.pojos.InputElementsItem;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class Utils {
    public static final String GET_CHECKOUT_LIST = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/listresult.json";
    public static final String SELECTED_CODE = "selected_code";
    public static final String AMOUNT = "amount";

    public static void setBitmapFromUrl(String src, ImageView cardLogo) {

        new ImageAsyncTask(src,
                new ImageHttpCallback() {
                    @Override
                    public void processFinish(Bitmap bitmap) {
                        cardLogo.setImageBitmap(bitmap);
                    }

                    @Override
                    public void processFailed(int responseCode) {

                    }
                }).execute();
    }

    public static void setDynamicFields(List<InputElementsItem> inputElements, LinearLayout container, Context context) {
        for(InputElementsItem item : inputElements){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            final View addView = layoutInflater.inflate(R.layout.dynamic_row, null);
            TextInputLayout layout = addView.findViewById(R.id.dynamic_layout);
            TextInputEditText title = addView.findViewById(R.id.dynamic_field);
            layout.setHint(item.getName());

            if (addView.getParent() != null) {
                ((ViewGroup) addView.getParent()).removeView(addView);
            }
            container.addView(addView);
        }
    }
}

package com.charles.payoneertest.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ImageAsyncTask extends AsyncTask<Void, Void,Bitmap> {

    public String requestURL="";
    public ImageHttpCallback  delegate = null;
    public int res_code=0;

    public ImageAsyncTask(String requestURL, ImageHttpCallback delegate) {
        this.requestURL = requestURL;
        this.delegate = delegate;
    }


    @Override
    protected Bitmap doInBackground(Void... voids) {

        try {
            Log.e("HTTP Request URL",requestURL);
            URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setReadTimeout(30000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod("GET");

            res_code= conn.getResponseCode();

            InputStream input = conn.getInputStream();
            return BitmapFactory.decodeStream(input);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if(res_code==HttpURLConnection.HTTP_OK){
            delegate.processFinish(bitmap);
        }else{
            delegate.processFailed(res_code);
        }
    }
}

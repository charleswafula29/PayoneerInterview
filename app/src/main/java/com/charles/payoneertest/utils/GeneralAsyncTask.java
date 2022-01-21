package com.charles.payoneertest.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GeneralAsyncTask extends AsyncTask<String, Void,String> {

    public String requestURL="";
    public HTTPCallback delegate = null;
    public int res_code=0;

    public GeneralAsyncTask(String requestURL, HTTPCallback delegate) {
        this.requestURL = requestURL;
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            Log.e("HTTP Request URL",requestURL);
            URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(30000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod("GET");

            res_code= conn.getResponseCode();

            InputStream inputStream = conn.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            StringBuilder stringBuilder = new StringBuilder();

            if (scanner.hasNext()){
                stringBuilder.append(scanner.next());
                while(scanner.hasNext()){
                    stringBuilder.append(" ");
                    stringBuilder.append(scanner.next());
                }

                conn.disconnect();
                return stringBuilder.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(res_code==HttpURLConnection.HTTP_OK){
            delegate.processFinish(s);
        }else{
            delegate.processFailed(res_code, s);
        }
    }
}

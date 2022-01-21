package com.charles.payoneertest.utils;

public interface HTTPCallback {
    void processFinish(String output);
    void processFailed(int responseCode, String output);
}

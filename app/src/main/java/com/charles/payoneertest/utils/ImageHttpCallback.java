package com.charles.payoneertest.utils;

import android.graphics.Bitmap;

public interface ImageHttpCallback {
    void processFinish(Bitmap bitmap);
    void processFailed(int responseCode);
}

package com.example.administrator.util;

import android.widget.Toast;

import com.example.administrator.App;


public final class ToastUtil {

    private ToastUtil() {

    }

    private static Toast mToast;

    public static void show(final String title) {
        showToast(title, Toast.LENGTH_SHORT);
    }

    public static void show(final String title, final boolean isLong) {
        showToast(title, Toast.LENGTH_LONG);
    }

    private static void showToast(final String title, final int dur) {
        if (mToast == null) {
            mToast = Toast.makeText(App.getInstance(), title, dur);
        } else {
            mToast.setText(title);
        }
        mToast.show();
    }

    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}

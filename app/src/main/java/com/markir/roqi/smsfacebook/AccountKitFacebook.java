package com.markir.roqi.smsfacebook;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.facebook.accountkit.AccountKit;

/**
 * Created by Roqi Markir on 3/16/2017.
 */

public class AccountKitFacebook extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Kitkat and lower has a bug that can cause in correct strict mode
            // warnings about expected activity counts
            enableStrictMode();
        }

        AccountKit.initialize(getApplicationContext());
    }

    public void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }
}

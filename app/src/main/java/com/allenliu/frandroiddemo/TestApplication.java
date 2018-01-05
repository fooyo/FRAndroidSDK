package com.allenliu.frandroiddemo;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import sg.fooyo.frandroidsdk.sdk.FRSDKMonitorListener;
import sg.fooyo.frandroidsdk.sdk.FooyoFRAndroidSDK;

/**
 * Created by allenliu on 2017/9/30.
 */

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

    }
}

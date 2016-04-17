package com.example.cmx.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.cmx.models.CMXUpdateBean;

/**
 * Created by HaRsH on 17-04-2016.
 */
public class CMXUtil {

    private Context context;
    private static CMXUtil cmxUtil;

    private CMXUtil () {}
    public static CMXUtil getInstance () {
        if (cmxUtil == null) {
            cmxUtil = new CMXUtil();
        }
        return cmxUtil;
    }

    public Context getContext() {
        return context;
    }


    public void setContext(Context context) {
        this.context = context;
    }

    public boolean isNetwork () {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || ( !networkInfo.isConnected() ))
            return false;

        return true;
    }
}

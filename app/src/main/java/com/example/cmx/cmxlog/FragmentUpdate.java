package com.example.cmx.cmxlog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cmx.LogUpdateRequest;
import com.example.cmx.OnTaskComplete;
import com.example.cmx.adapters.CMXLogUpdateAdapter;
import com.example.cmx.models.CMXUpdateBean;
import com.example.cmx.utilities.CMXUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HaRsH on 02-04-2016.
 */
public class FragmentUpdate extends Fragment implements OnTaskComplete {
    private ArrayList<String> aLFake;
    ListView listUpdates;
    String [] str = {"Harsh Soni","Bhavin Shah","Kishor Davra", "Deep Amin"};
    Context context;
    CMXUtil cmxUtil;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        cmxUtil = CMXUtil.getInstance();
        context = activity;
        cmxUtil.setContext(activity);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_layout_list,container,false);
        listUpdates = (ListView) rootView.findViewById(R.id.listUpdates);


        ArrayList<String> aLFake = null;//new ArrayList<>(Arrays.asList(str));
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.cmx_log_update_item,aLFake);


     //   if (cmxUtil.isNetwork()) {

            LogUpdateRequest cmxLogRequest = new LogUpdateRequest(this);
        cmxLogRequest.execute("https://cm-api.cmxlog.com/changes/13/titan?callback=myCallback&_=1460913536726");
           // if (aLFake != null)

       // }
        //listUpdates.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void processResponse(String response) {
        Log.d("frag" , response);
        aLFake = new ArrayList<>(Arrays.asList(str));
        listUpdates.setAdapter(new CMXLogUpdateAdapter(context,aLFake));
    }
}

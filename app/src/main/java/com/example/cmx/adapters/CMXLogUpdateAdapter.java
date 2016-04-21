package com.example.cmx.adapters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cmx.cmxlog.R;
import com.example.cmx.models.CMXUpdateBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HaRsH on 05-04-2016.
 */
public class CMXLogUpdateAdapter extends BaseAdapter{

    ArrayList <CMXUpdateBean> listBeans;
    Context thisContext;
    LayoutInflater inflater;
    ViewHolder viewHolder;

    public  CMXLogUpdateAdapter (Context context, ArrayList<CMXUpdateBean> list) {
        thisContext = context;
        listBeans = list;
        inflater  = LayoutInflater.from(thisContext);
    }
    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public CMXUpdateBean getItem(int position) {
        return listBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cmx_log_update_item , parent, false);
            viewHolder = new ViewHolder(convertView.findViewById(R.id.lytCmxLogUpdate));
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder  = (ViewHolder) convertView.getTag();
        }

        CMXUpdateBean cmxUpdateBean = getItem(position);
        viewHolder.txtId.setText(cmxUpdateBean.getProjectId());
        viewHolder.txtProject.setText(cmxUpdateBean.getProjectName());
        viewHolder.txtSubject.setText(cmxUpdateBean.getSubject());

        return convertView;
    }


private class ViewHolder  {
    TextView txtProject;
    TextView txtId;
    TextView txtLastUpdated;
    TextView txtSubject;

    public ViewHolder(View v) {
        txtId = (TextView)v.findViewById(R.id.txtProjectId);
        txtProject = (TextView)v.findViewById(R.id.txtProjectName);
        txtSubject = (TextView)v.findViewById(R.id.txtSubject);
    }

}

}


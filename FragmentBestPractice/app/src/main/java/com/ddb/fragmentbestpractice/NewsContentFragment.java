package com.ddb.fragmentbestpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by deepin on 17-3-1.
 */

public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceSate){
        view = inflater.inflate(R.layout.news_content_frag,parent,false);
        return view;
    }

    public void refresh(String title,String content){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView) view.findViewById(R.id.news_content);

        //刷新新闻标题和内容
        newsTitleText.setText(title);
        newsContentText.setText(content);
    }
}

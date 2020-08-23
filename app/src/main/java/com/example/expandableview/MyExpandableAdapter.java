package com.example.expandableview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExpandableAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> names;
    Map<String, List<String>> movies;

    public MyExpandableAdapter(Context context, List<String> names, Map<String, List<String>> movies) {
        this.context = context;
        this.names = names;
        this.movies = movies;
    }

    @Override
    public int getGroupCount() {
        return names.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return movies.get(names.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return names.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return movies.get(names.get(i)).get(i1);
    }


    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String lang = (String) getGroup(i);

        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.parent_list, viewGroup, false);
        }
        TextView textView = view.findViewById(R.id.parent);
        textView.setText(lang);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String topic = (String) getGroup(i);
        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.child_list, viewGroup, false);
        }
            TextView textView = view.findViewById(R.id.child);
            textView.setText(topic);


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}

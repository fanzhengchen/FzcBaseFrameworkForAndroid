package com.example.administrator.fzcbaseframework;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.example.administrator.util.FormatUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/21.
 */
public class MainAdapter extends BaseAdapter {
    private ArrayList<String> data;
    private Activity activity;
    private final int height = FormatUtil.pixOfDip(50);

    public MainAdapter(Activity activity) {
        this.activity = activity;
        data = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void appendData(ArrayList<String> data) {
        this.data.addAll(data);
    }

    public void appendFirst(ArrayList<String> data) {
        data.addAll(this.data);
        this.data = data;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
            view.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
        }
        return view;
    }
}

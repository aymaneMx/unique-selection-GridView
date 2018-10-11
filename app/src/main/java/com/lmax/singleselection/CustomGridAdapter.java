package com.lmax.singleselection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class CustomGridAdapter  extends BaseAdapter {

    private List<Item> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    private int selectedPosition = -1;

    public CustomGridAdapter(Context aContext,  List<Item> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }

    @SuppressLint("ResourceAsColor")
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.ItemNameView = convertView.findViewById(R.id.name);
            holder.ItemUrlView = convertView.findViewById(R.id.url);
            holder.Item = convertView.findViewById( R.id.ll1 );
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item Item = this.listData.get(position);
        holder.ItemNameView.setText(Item.getName());
        holder.ItemUrlView.setText("" + Item.getUrl());

        if (position == selectedPosition) {
            holder.Item.setBackgroundColor( ContextCompat.getColor(context,R.color.primary_dark));
        } else {
            holder.Item.setBackgroundColor( ContextCompat.getColor(context,R.color.primary_light));
        }

        return convertView;
    }


    static class ViewHolder {
        TextView ItemNameView;
        TextView ItemUrlView;
        LinearLayout Item;
    }

}
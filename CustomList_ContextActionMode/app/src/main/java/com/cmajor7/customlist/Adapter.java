package com.cmajor7.customlist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<String>
{
    private List<String> Titles =new ArrayList<>();
    private Context context;
    public Adapter(List<String> Titles,Context context)
    {
        super(context,R.layout.rows, Titles);
        this.context= context;
        this.Titles= Titles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =((Activity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.rows,parent,false);
        TextView TitleName =row.findViewById(R.id.title);
        TitleName.setText(Titles.get(position));
        return row;
    }
    public void removeItems(List<String> items)
    {
        for(String item : items)
        {
            Titles.remove(item);
        }
        notifyDataSetChanged();
    }
}
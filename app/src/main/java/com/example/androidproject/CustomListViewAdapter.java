package com.example.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<DataTypeItems> {


    public CustomListViewAdapter(@NonNull Context context, @NonNull List<DataTypeItems> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataTypeItems item = getItem(position);
        if(convertView == null){
            convertView =
                    LayoutInflater.from(getContext())
                            .inflate(R.layout.item_view, parent, false);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(item.getName());
        }
        return convertView;
    }
}

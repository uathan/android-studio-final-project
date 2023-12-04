package com.example.androidproject.RecycleView;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.DataTypeItems;
import com.example.androidproject.R;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<DataTypeItems> myTerms;

    public CustomRecyclerViewAdapter(ArrayList<DataTypeItems> myTerms) {
        this.myTerms = myTerms;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_view, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final DataTypeItems dataTypeItems = myTerms.get(position);
        final CustomViewHolder holder1 = (CustomViewHolder) holder;
        holder1.name.setText(dataTypeItems.getName());
        holder1.description.setText(dataTypeItems.getDescription());
    }

    @Override
    public int getItemCount() {
        return (myTerms != null ? myTerms.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView description;

        public CustomViewHolder(View view){
            super(view);
            this.name = view.findViewById(R.id.name2);
            this.description = view.findViewById(R.id.description2);
        }
    }
}

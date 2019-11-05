package com.izv.dam.retrofit.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.izv.dam.retrofit.R;
import com.izv.dam.retrofit.model.data.Type;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {

    private LayoutInflater inflater;
    private List<Type> typeList;

    public MainAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        if (typeList != null) {
            Type current = typeList.get(position);
            holder.tvItem.setText(current.toString());
        } else {
            holder.tvItem.setText("No user available");
        }
    }

    @Override
    public int getItemCount() {
        int elements = 0;
        if(typeList != null) {
            elements = typeList.size();
        }
        return elements;
    }

    public void setTypes(List<Type> typeList){
        this.typeList = typeList;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
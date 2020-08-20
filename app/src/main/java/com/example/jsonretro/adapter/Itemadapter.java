package com.example.jsonretro.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonretro.MainActivity;
import com.example.jsonretro.Model.Item;
import com.example.jsonretro.R;

import java.util.List;

public class Itemadapter extends RecyclerView.Adapter<Itemadapter.ItemViewHolder> {
    private List<Item> items;
    private RecyclerViewClickListener listener;

    public Itemadapter(RecyclerViewClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item,parent,false);
        return new ItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull Itemadapter.ItemViewHolder holder, int position) {
        Item item=items.get(position);
        Log.d("GG","" + item);
        holder.id.setText(item.getID());
        holder.name.setText(item.getName());
        holder.username.setText(item.getUsername());

    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    public int getItemCount() {
        return items.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(Item item);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView id, name, username;

        public ItemViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            username = (TextView) itemView.findViewById(R.id.username);
            itemView.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(items.get(getAdapterPosition()));
                }
            });

        }

    }

}

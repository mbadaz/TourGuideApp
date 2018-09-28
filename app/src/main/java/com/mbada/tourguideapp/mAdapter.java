package com.mbada.tourguideapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link mAdapter} is a {@link RecyclerView} adapter.
 */
public class mAdapter extends RecyclerView.Adapter<mAdapter.mViewHolder>{
    private final ArrayList<Attraction> attractions;
    private final OnItemClickListener listener;

    public mAdapter(ArrayList<Attraction> attractions, OnItemClickListener listener) {
        this.attractions = attractions;
        this.listener = listener;
    }

    public class mViewHolder extends RecyclerView.ViewHolder{
        final ImageView attractionImage;
        final TextView attractionTitle;
        mViewHolder(View itemView){
            super(itemView);
            this.attractionImage = itemView.findViewById(R.id.listItemImage);
            this.attractionTitle = itemView.findViewById(R.id.listItemTitle);
        }
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view,
                parent,false);
        return new mViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mAdapter.mViewHolder holder, final int position) {
        Attraction attraction = attractions.get(position);
        holder.attractionTitle.setText(attraction.getTitle());
        holder.attractionTitle.setSelected(true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
        holder.attractionImage.setImageResource(attraction.getImageId());

    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}

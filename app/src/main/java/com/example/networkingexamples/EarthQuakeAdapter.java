package com.example.networkingexamples;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EarthQuakeAdapter extends RecyclerView.Adapter<EarthQuakeAdapter.EarthQuakeViewHolder> {

    private List<EarthQuake> mItems;

    public EarthQuakeAdapter(List<EarthQuake> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public EarthQuakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_earth_quake, parent, false);
        return new EarthQuakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EarthQuakeViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class EarthQuakeViewHolder extends RecyclerView.ViewHolder {

        private TextView dateTimeTextView;
        private TextView depthTextView;
        private TextView latTextView;
        private TextView lngTextView;
        private TextView magTextView;
        private TextView srcTextView;

        public EarthQuakeViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTimeTextView = itemView.findViewById(R.id.text_view_date_time);
            depthTextView = itemView.findViewById(R.id.text_view_depth);
            latTextView = itemView.findViewById(R.id.text_view_lat);
            lngTextView = itemView.findViewById(R.id.text_view_lng);
            magTextView = itemView.findViewById(R.id.text_view_mag);
            srcTextView = itemView.findViewById(R.id.text_view_src);

        }

        public void bind(EarthQuake item) {
            dateTimeTextView.setText(item.getDaeTime());
            depthTextView.setText(String.valueOf(item.getDepth()));
            latTextView.setText(String.valueOf(item.getLat()));
            lngTextView.setText(String.valueOf(item.getLng()));
            magTextView.setText(String.valueOf(item.getMagnitude()));
            srcTextView.setText(item.getSource());
        }
    }
}

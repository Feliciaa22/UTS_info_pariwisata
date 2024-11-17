/*
package com.example.info_pariwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {
    private ArrayList<Wisata> wisataList;
    private ArrayList<Wisata> wisataListFull;
    private Context context;

    public WisataAdapter(ArrayList<Wisata> wisataList, Context context) {
        this.wisataList = wisataList;
        this.context = context;
        // Copy list untuk backup data asli
        wisataListFull = new ArrayList<>(wisataList);
    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_wisata, parent, false);
        return new WisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataViewHolder holder, int position) {
        Wisata wisata = wisataList.get(position);
        holder.titleWisata.setText(wisata.getTitle());
        holder.locationWisata.setText(wisata.getLocation());
        holder.imageWisata.setImageResource(wisata.getImageResource());
    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }

    public static class WisataViewHolder extends RecyclerView.ViewHolder {
        ImageView imageWisata;
        TextView titleWisata, locationWisata;

        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);
            imageWisata = itemView.findViewById(R.id.imageWisata);
            titleWisata = itemView.findViewById(R.id.titleWisata);
            locationWisata = itemView.findViewById(R.id.locationWisata);
        }
    }

    // Metode untuk memfilter daftar berdasarkan nama
    public void filter(String text) {
        wisataList.clear();
        if (text.isEmpty()) {
            wisataList.addAll(wisataListFull);
        } else {
            text = text.toLowerCase();
            for (Wisata item : wisataListFull) {
                if (item.getTitle().toLowerCase().contains(text)) {
                    wisataList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
*/
package com.example.info_pariwisata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {

    private ArrayList<Wisata> wisataList;
    private ArrayList<Wisata> wisataListFull;
    private Context context;

    public WisataAdapter(ArrayList<Wisata> wisataList, Context context) {
        this.wisataList = wisataList;
        this.context = context;
        // Copy list for backup of the original data
        wisataListFull = new ArrayList<>(wisataList);
    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_wisata, parent, false);
        return new WisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataViewHolder holder, int position) {
        Wisata wisata = wisataList.get(position);
        holder.titleWisata.setText(wisata.getTitle());
        holder.locationWisata.setText(wisata.getLocation());
        holder.imageWisata.setImageResource(wisata.getImageResource());


        // Set click listener for each item
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Memilih: " + wisata.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, detail_wisata.class);
            intent.putExtra("title", wisata.getTitle());
            intent.putExtra("location", wisata.getLocation());
            intent.putExtra("description", wisata.getDescription());
            intent.putExtra("image", wisata.getImageResource());
            intent.putExtra("latitude", wisata.getLatitude());
            intent.putExtra("longitude", wisata.getLongitude());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }

    // Method to filter the list based on title
    public void filter(String text) {
        wisataList.clear();
        if (text.isEmpty()) {
            wisataList.addAll(wisataListFull);
        } else {
            text = text.toLowerCase();
            for (Wisata item : wisataListFull) {
                if (item.getTitle().toLowerCase().contains(text)) {
                    wisataList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class WisataViewHolder extends RecyclerView.ViewHolder {
        ImageView imageWisata;
        TextView titleWisata, locationWisata;

        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);
            imageWisata = itemView.findViewById(R.id.imageWisata);
            titleWisata = itemView.findViewById(R.id.titleWisata);
            locationWisata = itemView.findViewById(R.id.locationWisata);
        }
    }
}

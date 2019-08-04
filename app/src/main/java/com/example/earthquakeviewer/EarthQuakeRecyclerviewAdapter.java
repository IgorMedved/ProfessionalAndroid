package com.example.earthquakeviewer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.earthquakeviewer.databinding.ListItemEarthquakeBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class EarthQuakeRecyclerviewAdapter extends RecyclerView.Adapter<EarthQuakeRecyclerviewAdapter.ViewHolder> {
    private List<EarthQuake> mEarthQuakes;
    private static final String TAG = EarthQuakeRecyclerviewAdapter.class.getSimpleName();
    private static final SimpleDateFormat TIME_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);
    private static final NumberFormat MAGNITUDE_FORMAT = new DecimalFormat("0.0");

    public EarthQuakeRecyclerviewAdapter (List<EarthQuake> earthQuakes) {
        mEarthQuakes = earthQuakes;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_earthquake, parent, false);
        ListItemEarthquakeBinding binding = ListItemEarthquakeBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        Log.d(TAG, "parent: " + parent);
        //Log.d(TAG, "view: " + view);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        EarthQuake earthQuake = mEarthQuakes.get(position);
        holder.binding.setEarthquake(earthQuake);
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mEarthQuakes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ListItemEarthquakeBinding binding;

        public ViewHolder (ListItemEarthquakeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setTimeformat(TIME_FORMAT);
            binding.setMagnitudeformat(MAGNITUDE_FORMAT);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

}

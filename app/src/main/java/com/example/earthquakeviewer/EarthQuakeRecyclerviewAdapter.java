package com.example.earthquakeviewer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class EarthQuakeRecyclerviewAdapter extends RecyclerView.Adapter<EarthQuakeRecyclerviewAdapter.ViewHolder> {
    private List<EarthQuake> mEarthQuakes;
    private static final String TAG = EarthQuakeRecyclerviewAdapter.class.getSimpleName();
    private static final SimpleDateFormat TIME_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    public EarthQuakeRecyclerviewAdapter (List<EarthQuake> earthQuakes) {
        mEarthQuakes = earthQuakes;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_earthquake, parent, false);
        Log.d(TAG, "parent: " + parent);
        Log.d(TAG, "view: " + view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.earthQuake = mEarthQuakes.get(position);
        holder.detailsView.setText(mEarthQuakes.get(position).getDetails());
        holder.magnitudeView.setText(Double.toString(mEarthQuakes.get(position).getMagnitude()));
        holder.dateView.setText(TIME_FORMAT.format(mEarthQuakes.get(position).getDate()));

    }

    @Override
    public int getItemCount() {
        return mEarthQuakes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView detailsView;
        public final TextView dateView;
        public final TextView magnitudeView;
        public EarthQuake earthQuake;

        public ViewHolder (View view) {
            super(view);
            detailsView = view.findViewById(R.id.details);
            dateView=view.findViewById(R.id.date);
            magnitudeView= view.findViewById(R.id.magnitude);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + detailsView.getText() + "'";
        }
    }

}

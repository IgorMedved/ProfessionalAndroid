package com.example.earthquakeviewer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.earthquakeviewer.EarthQuakeListFragment.TAG;

public class EarthQuakeRecyclerviewAdapter extends RecyclerView.Adapter<EarthQuakeRecyclerviewAdapter.ViewHolder> {
    private List<EarthQuake> mEarthQuakes;
    private static final String TAG = EarthQuakeRecyclerviewAdapter.class.getSimpleName();

    public EarthQuakeRecyclerviewAdapter (List<EarthQuake> earthQuakes) {
        mEarthQuakes = earthQuakes;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView view = (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_earthquake, parent, false);
        Log.d(TAG, "parent: " + parent);
        Log.d(TAG, "view: " + view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.earthQuake = mEarthQuakes.get(position);
        holder.detailsView.setText(mEarthQuakes.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return mEarthQuakes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView detailsView;
        public EarthQuake earthQuake;

        public ViewHolder (TextView view) {
            super(view);
            detailsView = view;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + detailsView.getText() + "'";
        }
    }

}

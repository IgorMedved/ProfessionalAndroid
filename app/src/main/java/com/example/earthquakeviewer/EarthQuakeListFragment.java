package com.example.earthquakeviewer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EarthQuakeListFragment extends Fragment {

    private List<EarthQuake> mEarthQuakes;
    static final String TAG = EarthQuakeListFragment.class.getSimpleName();
    private EarthQuakeRecyclerviewAdapter mEarthQuakeRecyclerviewAdapter;
    private RecyclerView mRecyclerView;

    public EarthQuakeListFragment() {
        mEarthQuakes = new ArrayList<>();
        mEarthQuakeRecyclerviewAdapter = new EarthQuakeRecyclerviewAdapter(mEarthQuakes);
        Log.d(TAG, "constructor");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earthquake_list, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.list);
        Log.d(TAG, "onCreateView");
        return  view;
    }

    void setEarthquakes(@NonNull List<EarthQuake> dummyQuakes) {
        for (EarthQuake quake: dummyQuakes) {
            mEarthQuakes.add(quake);
            mEarthQuakeRecyclerviewAdapter.notifyItemInserted(mEarthQuakes.size()-1);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");

        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mEarthQuakeRecyclerviewAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstance) {
        super.onActivityCreated(savedInstance);
        Log.d(TAG, "onActivityCreated");
    }
}

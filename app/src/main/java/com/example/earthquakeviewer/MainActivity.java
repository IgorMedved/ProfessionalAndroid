package com.example.earthquakeviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EarthQuakeListFragment mEarthQuakeListFragment;
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        FragmentManager fm = getSupportFragmentManager();


        if (savedInstanceState == null) {
            FragmentTransaction ft = fm.beginTransaction();
            mEarthQuakeListFragment = new EarthQuakeListFragment();
            ft.add(R.id.main_activity_frame, mEarthQuakeListFragment, EarthQuakeListFragment.TAG);
            ft.commitNow();
            Log.d(TAG, "finished transaction");
        } else {
            Log.d(MainActivity.class.getSimpleName(),"Trying to restore old state");
            mEarthQuakeListFragment = (EarthQuakeListFragment)fm.findFragmentByTag(EarthQuakeListFragment.TAG);
        }


        Log.d(TAG, "finished onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Date now = Calendar.getInstance().getTime();
        List<EarthQuake> dummyQuakes = new ArrayList<EarthQuake>(0);
        dummyQuakes.add(new EarthQuake("0", now, "San Jose", null, 7.3, null));
        dummyQuakes.add(new EarthQuake("1", now, "LA", null, 6.5, null));

        Log.d(TAG, "setting earthquakes");
        mEarthQuakeListFragment.setEarthquakes(dummyQuakes);
    }
}


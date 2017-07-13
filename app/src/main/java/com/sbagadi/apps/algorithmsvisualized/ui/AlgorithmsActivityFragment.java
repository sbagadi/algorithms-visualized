package com.sbagadi.apps.algorithmsvisualized.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbagadi.apps.algorithmsvisualized.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlgorithmsActivityFragment extends Fragment {

    public AlgorithmsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_algorithms, container, false);
    }
}

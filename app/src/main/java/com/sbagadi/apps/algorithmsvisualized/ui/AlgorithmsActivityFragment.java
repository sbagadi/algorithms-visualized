package com.sbagadi.apps.algorithmsvisualized.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbagadi.apps.algorithmsvisualized.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlgorithmsActivityFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public AlgorithmsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_algorithms, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.algorithms_recyclerView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AlgorithmsRecyclerViewAdapter adapter =
                new AlgorithmsRecyclerViewAdapter(generateAlgorithmNamesArray());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

    }

    /**
     * Generates an array of strings with the algorithm names.
     *
     * @return a {@link String[]} containing names of algorithms.
     */
    private static String[] generateAlgorithmNamesArray() {
        String[] algorithmNames = new String[5];
        algorithmNames[0] = "Bubble Sort";
        algorithmNames[1] = "Quick Sort";
        algorithmNames[2] = "Merge Sort";
        algorithmNames[3] = "Insertion Sort";
        algorithmNames[4] = "Selection Sort";

        return algorithmNames;
    }
}

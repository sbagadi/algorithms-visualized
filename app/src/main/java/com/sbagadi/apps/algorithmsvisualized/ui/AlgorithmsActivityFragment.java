package com.sbagadi.apps.algorithmsvisualized.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbagadi.apps.algorithmsvisualized.R;
import com.sbagadi.apps.algorithmsvisualized.data.Algorithm;
import com.sbagadi.apps.algorithmsvisualized.ui.algorithms.AlgorithmDetailsActivity;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlgorithmsActivityFragment extends Fragment implements
        AlgorithmsRecyclerViewAdapter.ItemViewHolder.OnItemClickListener {

    private RecyclerView mRecyclerView;

    private ArrayList<Algorithm> mAlgorithms;

    public AlgorithmsActivityFragment() {
        // Required empty public constructor.
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
        String[] algorithmNames =
                getActivity().getResources().getStringArray(R.array.algorithm_names);
        mAlgorithms = generateAlgorithmsList();
        AlgorithmsRecyclerViewAdapter adapter =
                new AlgorithmsRecyclerViewAdapter(mAlgorithms, AlgorithmsActivityFragment.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    //region OnItemClickListener implementation
    @Override
    public void onItemClick(View view, int position) {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), AlgorithmDetailsActivity.class);
            intent.putParcelableArrayListExtra(
                    AlgorithmDetailsActivity.ARG_ALGORITHMS,
                    mAlgorithms);
            intent.putExtra(AlgorithmDetailsActivity.ARG_PRIMARY_ITEM_POSITION, position);
            startActivity(intent);
        }
    }
    //endregion

    /**
     * Generates a list of algorithms from algorithm names and descriptions in strings array
     * resources.
     *
     * @return An array list of algorithms.
     */
    private ArrayList<Algorithm> generateAlgorithmsList() {
        String[] algorithmNames =
                getActivity().getResources().getStringArray(R.array.algorithm_names);
        String[] algorithmDescriptions =
                getActivity().getResources().getStringArray(R.array.algorithm_descriptions);

        ArrayList<Algorithm> algorithms = new ArrayList<>(5);
        for (int i = 0; i < algorithmNames.length; i++) {
            algorithms.add(new Algorithm(algorithmNames[i], algorithmDescriptions[i]));
        }

        return algorithms;
    }
}

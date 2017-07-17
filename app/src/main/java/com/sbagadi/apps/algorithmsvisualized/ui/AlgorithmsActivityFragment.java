package com.sbagadi.apps.algorithmsvisualized.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbagadi.apps.algorithmsvisualized.R;
import com.sbagadi.apps.algorithmsvisualized.ui.algorithms.AlgorithmDetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlgorithmsActivityFragment extends Fragment implements
        AlgorithmsRecyclerViewAdapter.ItemViewHolder.OnItemClickListener{

    private RecyclerView mRecyclerView;

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
        AlgorithmsRecyclerViewAdapter adapter =
                new AlgorithmsRecyclerViewAdapter(algorithmNames, AlgorithmsActivityFragment.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    //region OnItemClickListener implementation
    @Override
    public void onItemClick(View view, int position) {
        if (getActivity() != null) {
            // TODO: Start the algorithms detail activity.
            startActivity(new Intent(getActivity(), AlgorithmDetailsActivity.class));
        }
    }
    //endregion
}

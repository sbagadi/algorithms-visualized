package com.sbagadi.apps.algorithmsvisualized.ui.algorithms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sbagadi.apps.algorithmsvisualized.R;
import com.sbagadi.apps.algorithmsvisualized.data.Algorithm;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BubbleSortFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BubbleSortFragment extends AlgorithmFragment {
    private static final String ARG_ALGORITHMS = "algorithms";

    public BubbleSortFragment() {
        // Required empty public constructor.
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param algorithm An {@link Algorithm} .
     * @return A new instance of fragment BubbleSortFragment.
     */
    public static BubbleSortFragment newInstance(Algorithm algorithm) {
        BubbleSortFragment fragment = new BubbleSortFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ALGORITHMS, algorithm);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAlgorithm = getArguments().getParcelable(ARG_ALGORITHMS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        View rootView = inflater.inflate(R.layout.fragment_bubble_sort, container, false);
        ((TextView) rootView.findViewById(R.id.algorithm_name_textView))
                .setText(mAlgorithm.getName());
        return rootView;
    }

    @Override
    protected String getAlgorithmName() {
        return mAlgorithm.getName();
    }

    @Override
    protected String getAlgorithmDescription() {
        return mAlgorithm.getDescription();
    }

}

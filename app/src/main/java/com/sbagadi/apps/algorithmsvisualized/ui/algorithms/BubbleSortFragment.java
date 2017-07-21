package com.sbagadi.apps.algorithmsvisualized.ui.algorithms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbagadi.apps.algorithmsvisualized.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BubbleSortFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BubbleSortFragment extends AlgorithmFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BubbleSortFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BubbleSortFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BubbleSortFragment newInstance(String param1, String param2) {
        BubbleSortFragment fragment = new BubbleSortFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bubble_sort, container, false);
    }

    @Override
    protected String getAlgorithmName() {
        return getString(R.string.bubble_sort_name);
    }

    @Override
    protected String getAlgorithmDescription() {
        return getString(R.string.bubble_sort_description);
    }

}

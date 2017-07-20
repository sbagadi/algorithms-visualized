package com.sbagadi.apps.algorithmsvisualized.ui.algorithms;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbagadi.apps.algorithmsvisualized.R;

import static com.sbagadi.apps.algorithmsvisualized.util.LogUtils.makeLogTag;

/**
 * A {@link Fragment} to be used with {@link AlgorithmDetailsActivity} to embed content into the
 * activity.
 */
public abstract class AlgorithmFragment extends Fragment {

    private static final String TAG = makeLogTag(AlgorithmFragment.class);

    public AlgorithmFragment() {
        // Required empty public constructor.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

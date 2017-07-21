package com.sbagadi.apps.algorithmsvisualized.ui.algorithms;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.sbagadi.apps.algorithmsvisualized.R;

import static com.sbagadi.apps.algorithmsvisualized.util.LogUtils.LOGD;
import static com.sbagadi.apps.algorithmsvisualized.util.LogUtils.makeLogTag;

/**
 * A {@link Fragment} to be used with {@link AlgorithmDetailsActivity} to embed content into the
 * activity.
 */
public abstract class AlgorithmFragment extends Fragment {

    private static final String TAG = makeLogTag(AlgorithmFragment.class);

    protected AlgorithmFragmentContainer mContainer;

    public AlgorithmFragment() {
        // Required empty public constructor.
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AlgorithmFragmentContainer) {
            mContainer = (AlgorithmFragmentContainer) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement AlgorithmFragmentContainer");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContainer = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * Returns a {@link String} representing the algorithm's name.
     */
    protected abstract String getAlgorithmName();

    /**
     * Returns a {@link String} representing a description of the algorithm.
     */
    protected abstract String getAlgorithmDescription();

    /**
     * Container for the algorithm fragments.
     */
    interface AlgorithmFragmentContainer {

        /**
         * Returns the previous step action button.
         */
        ImageButton getPreviousStepButton();

        /**
         * Enables the previous step action button in the container.
         *
         * @param enabled set to true to enable the button, false to disable it.
         */
        void setPreviousStepButtonEnabled(boolean enabled);

        /**
         * Returns the next step action button.
         */
        ImageButton getNextStepButton();

        /**
         * Enables the next step action button in the container.
         *
         * @param enabled set to true to enable the button, false to disable it.
         */
        void setNextStepButtonEnabled(boolean enabled);

        /**
         * Returns the refresh action button.
         */
        ImageButton getRefreshButton();

        /**
         * Enables the refresh action button in the container.
         *
         * @param enabled set to true to enable the button, false to disable it.
         */
        void setRefreshButtonEnabled(boolean enabled);
    }
}

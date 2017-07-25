package com.sbagadi.apps.algorithmsvisualized.ui.algorithms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.sbagadi.apps.algorithmsvisualized.R;
import com.sbagadi.apps.algorithmsvisualized.data.Algorithm;

import java.util.ArrayList;

public class AlgorithmDetailsActivity extends AppCompatActivity implements
        AlgorithmFragment.AlgorithmFragmentContainer {

    public static final String ARG_ALGORITHMS = "algorithms";
    public static final String ARG_PRIMARY_ITEM_POSITION = "primary_item_position";

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private ImageButton mNextStepButton;
    private ImageButton mPreviousStepButton;
    private ImageButton mRefreshButton;

    private ArrayList<Algorithm> mAlgorithms;
    private int mPrimaryItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_details);

        if (getIntent() == null) {
            finish();
        }

        Intent intent = getIntent();
        if (intent == null || intent.getParcelableArrayListExtra(ARG_ALGORITHMS) == null) {
            finish();
            return;
        }

        mAlgorithms = intent.getParcelableArrayListExtra(ARG_ALGORITHMS);
        mPrimaryItemPosition = intent.getIntExtra(ARG_PRIMARY_ITEM_POSITION, 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mAlgorithms.get(mPrimaryItemPosition).getName());
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels) {
                // Do nothing.
            }

            @Override
            public void onPageSelected(int position) {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(mAlgorithms.get(position).getName());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Do nothing.
            }
        });
        mViewPager.setCurrentItem(mPrimaryItemPosition);

        mNextStepButton = (ImageButton) findViewById(R.id.next_setp_imageButton);
        mPreviousStepButton = (ImageButton) findViewById(R.id.previous_step_imageButton);
        mRefreshButton = (ImageButton) findViewById(R.id.refresh_imageButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_algorithm_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //region AlgorithmFragmentContainer implementation
    @Override
    public ImageButton getPreviousStepButton() {
        return mPreviousStepButton;
    }

    @Override
    public void setPreviousStepButtonEnabled(boolean enabled) {
        if (mPreviousStepButton != null) {
            mPreviousStepButton.setEnabled(enabled);
        }
    }

    @Override
    public ImageButton getNextStepButton() {
        return mNextStepButton;
    }

    @Override
    public void setNextStepButtonEnabled(boolean enabled) {
        if (mNextStepButton != null) {
            mNextStepButton.setEnabled(enabled);
        }
    }

    @Override
    public ImageButton getRefreshButton() {
        return mRefreshButton;
    }

    @Override
    public void setRefreshButtonEnabled(boolean enabled) {
        if (mRefreshButton != null) {
            mRefreshButton.setEnabled(enabled);
        }
    }
    //endregion

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            // TODO: Update the fragment that is to be instantiated based on position.
            return BubbleSortFragment.newInstance(mAlgorithms.get(position));
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return mAlgorithms.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mAlgorithms.get(position).getName();
        }
    }
}

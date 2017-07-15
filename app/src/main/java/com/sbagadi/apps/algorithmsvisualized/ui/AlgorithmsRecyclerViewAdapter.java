package com.sbagadi.apps.algorithmsvisualized.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sbagadi.apps.algorithmsvisualized.R;

/**
 * A {@link android.support.v7.widget.RecyclerView.Adapter} used to display the list of algorithm
 * names in a {@link RecyclerView}.
 */
public class AlgorithmsRecyclerViewAdapter extends
        RecyclerView.Adapter<AlgorithmsRecyclerViewAdapter.ItemViewHolder> {

    private String[] mAlgorithmNames;

    public AlgorithmsRecyclerViewAdapter(String[] algorithmNames) {
        mAlgorithmNames = algorithmNames;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView mAlgorithmNameTextView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            mAlgorithmNameTextView = (TextView) itemView.findViewById(R.id.algorithm_name_textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: Show the algorithm details page.
                }
            });
        }

        public TextView getAlgorithmNameTextView() {
            return mAlgorithmNameTextView;
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.algorithms_list_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.getAlgorithmNameTextView().setText(mAlgorithmNames[position]);
    }

    @Override
    public int getItemCount() {
        return mAlgorithmNames.length;
    }
}

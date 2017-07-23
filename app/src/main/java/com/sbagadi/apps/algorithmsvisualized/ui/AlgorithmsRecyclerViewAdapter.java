package com.sbagadi.apps.algorithmsvisualized.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sbagadi.apps.algorithmsvisualized.R;
import com.sbagadi.apps.algorithmsvisualized.data.Algorithm;

import java.util.ArrayList;

/**
 * A {@link android.support.v7.widget.RecyclerView.Adapter} used to display the list of algorithm
 * names in a {@link RecyclerView}.
 */
public class AlgorithmsRecyclerViewAdapter extends
        RecyclerView.Adapter<AlgorithmsRecyclerViewAdapter.ItemViewHolder> {

    private ArrayList<Algorithm> mAlgorithms;
    private ItemViewHolder.OnItemClickListener mItemClickListener;

    public AlgorithmsRecyclerViewAdapter(ArrayList<Algorithm> algorithms,
                                         ItemViewHolder.OnItemClickListener itemClickListener) {
        mAlgorithms = algorithms;
        mItemClickListener = itemClickListener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView mAlgorithmNameTextView;
        private final OnItemClickListener mListener;

        public ItemViewHolder(final View itemView, OnItemClickListener listener) {
            super(itemView);
            mListener = listener;
            mAlgorithmNameTextView = (TextView) itemView.findViewById(R.id.algorithm_name_textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(itemView, getAdapterPosition());
                }
            });
        }

        public TextView getAlgorithmNameTextView() {
            return mAlgorithmNameTextView;
        }

        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.algorithms_list_item, parent, false);
        return new ItemViewHolder(itemView, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.getAlgorithmNameTextView().setText(mAlgorithms.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mAlgorithms.size();
    }
}

package com.bahrani.gazebogrills;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aliba on 10/12/2016.
 */

public class ListAdapter extends RecyclerView.Adapter {
    private final ListFragment.onProductSelectedInterface mListener;
    public ListAdapter(ListFragment.onProductSelectedInterface listener) {
        mListener = listener;

    }

    @Nullable
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((ListViewHolder) holder).bindView(position);



    }

    @Override
    public int getItemCount() {
        return Products.names.length;
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(this);

        }

        public void bindView(int position) {
            mIndex = position;
            mTextView.setText(Products.names[position]);
            mImageView.setImageResource(Products.resourceIds[position]);

        }

        @Override
        public void onClick(View v) {

            mListener.onListProductSelected(mIndex);
        }
    }
}

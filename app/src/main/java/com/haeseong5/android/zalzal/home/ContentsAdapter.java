package com.haeseong5.android.zalzal.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.models.ContentsItem;

import java.util.ArrayList;

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.ViewHolder> {
    private ArrayList<ContentsItem> mContentsList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private ImageView ivThumb;
        private TextView tvTitle;
        private TextView tvSubTitle;
        public ViewHolder(View view) {
            super(view);
            ivThumb = view.findViewById(R.id.item_contents_iv_image);
            tvTitle =  view.findViewById(R.id.item_contents_tv_title);
            tvSubTitle = view.findViewById(R.id.item_contents_tv_sub_title);
        }
    }

    public ContentsAdapter(Context context, ArrayList<ContentsItem> contentsItems) {
        this.context = context;
        mContentsList = contentsItems;
    }

    @Override
    public ContentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contents, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(mContentsList.get(position).getTitle());
        holder.tvSubTitle.setText(mContentsList.get(position).getTitle());
//        Glide.with(context).load(mContentsList.get(position).getImgURL1()).into(holder.ivPhoto);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mContentsList.size();
    }
}

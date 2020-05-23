package com.haeseong5.android.zalzal.like.adapters;

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
import com.haeseong5.android.zalzal.like.models.LikeItem;

import java.util.ArrayList;

public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.ViewHolder> {
    private ArrayList<LikeItem> mLikeList;
    private OnItemClickListener mClickListener = null;
    private Context context;
    public interface OnItemClickListener {
        void onItemClick(int position) ;
    }
//    public void setOnItemClickListener(ContentsAdapter.OnItemClickListener listener) {
//        this.mClickListener = listener ;
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private ImageView ivThumb;
        private TextView tvTitle;
        private TextView tvWriter;
        private ImageView ivLike;
        public ViewHolder(View view) {
            super(view);
            ivThumb = view.findViewById(R.id.item_contents_iv_image);
            tvTitle =  view.findViewById(R.id.item_contents_tv_title);
            tvWriter = view.findViewById(R.id.item_contents_tv_writer);
            ivLike = view.findViewById(R.id.item_contents_iv_like);
        }
    }

    public LikesAdapter(OnItemClickListener listener, ArrayList<LikeItem> likeItems, Context context) {
        this.mClickListener = listener;
        this.mLikeList = likeItems;
        this.context = context;
    }

    @Override
    public LikesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contents, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvTitle.setText(mLikeList.get(position).getTitle());
        holder.tvWriter.setText(mLikeList.get(position).getWriter());
        Glide.with(context).load(mLikeList.get(position).getThumbnail()).into(holder.ivThumb);

        //item click listener
        holder.ivThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mLikeList.size();
    }
}

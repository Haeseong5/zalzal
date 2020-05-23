package com.haeseong5.android.zalzal.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.models.PickItem;

import java.util.ArrayList;

public class PickAdapter extends RecyclerView.Adapter<PickAdapter.ViewHolder> {
    private ArrayList<PickItem> mPickList;
    private Context context;
    private PickAdapter.OnItemClickListener mClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(int position) ;
    }

    public PickAdapter(OnItemClickListener listener, ArrayList<PickItem> pickItems, Context context) {
        this.mClickListener = listener ;
        this.mPickList = pickItems;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private ImageView ivThumb;
        private TextView tvTitle;
        private TextView tvSubTitle;
        public ViewHolder(View view) {
            super(view);
            ivThumb = view.findViewById(R.id.item_pick_iv_image);
            tvTitle =  view.findViewById(R.id.item_pick_tv_title);
            tvSubTitle = view.findViewById(R.id.item_pick_tv_sub_title);
        }
    }

    @Override
    public PickAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pick, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvTitle.setText(mPickList.get(position).getTitle());
        holder.tvSubTitle.setText(mPickList.get(position).getTitle());
        Glide.with(context).load(mPickList.get(position).getImage()).into(holder.ivThumb);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPickList.size();
    }
}

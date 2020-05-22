package com.haeseong5.android.zalzal.home.views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.haeseong5.android.zalzal.BaseActivity;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.adapters.ContentsAdapter;
import com.haeseong5.android.zalzal.home.models.ContentsItem;
import com.haeseong5.android.zalzal.home.models.PickItem;

import java.util.ArrayList;

public class ContentsActivity extends BaseActivity implements ContentsAdapter.OnItemClickListener {

    private RecyclerView rvContents;
    private ContentsAdapter mContentsAdpater;
    private ArrayList<ContentsItem> mContentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
        mContentsList = new ArrayList<>();
        setTestData();
        mContentsAdpater = new ContentsAdapter(this, mContentsList);
        initView();
    }

    private void initView(){
        rvContents = findViewById(R.id.contents_recycler_view);
        rvContents.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvContents.setAdapter(mContentsAdpater);
    }
    public static void start(Context c) {
        c.startActivity(new Intent(c, ContentsActivity.class));
    }
    void setTestData() {
        mContentsList.add(new ContentsItem(null, "Title1", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title2", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title3", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title4", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title5", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title1", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title2", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title3", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title4", "sub title", null));
        mContentsList.add(new ContentsItem(null, "Title5", "sub title", null));
    }

    @Override
    public void onItemClick(int position) {
        printToast(String.valueOf(position));
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }
}

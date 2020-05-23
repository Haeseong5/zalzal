package com.haeseong5.android.zalzal.home.views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.haeseong5.android.zalzal.BaseActivity;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.ContentsService;
import com.haeseong5.android.zalzal.home.adapters.ContentsAdapter;
import com.haeseong5.android.zalzal.home.interfaces.ContentsActivityView;
import com.haeseong5.android.zalzal.home.models.ContentsItem;
import com.haeseong5.android.zalzal.home.models.ContentsResponse;

import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class ContentsActivity extends BaseActivity implements ContentsActivityView,ContentsAdapter.OnItemClickListener {

    private static final String TAG = "ContentsActivity";
    private RecyclerView rvContents;
    private ContentsAdapter mContentsAdpater;
    private ArrayList<ContentsItem> mContentsList;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private int pick_id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
        Intent intent = getIntent();

        if (intent != null) {
            pick_id = intent.getIntExtra("pick_id", 0);
            tryGetContentsList(pick_id);
        }
        printLog(TAG,String.valueOf(pick_id));

        initView();
    }
    private void tryGetContentsList(int id){
        showProgressDialog();
        ContentsService contentsService = new ContentsService(this);
        contentsService.getContentsList(id);
    }

    private void initView(){
        rvContents = findViewById(R.id.contents_recycler_view);
        collapsingToolbarLayout = findViewById(R.id.contents_collapsing_toolbar_layout);
        rvContents.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }
    public static void start(Context c) {
        c.startActivity(new Intent(c, ContentsActivity.class));
    }


    @Override
    public void onItemClick(int position) {
        printToast(String.valueOf(position));
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("title", mContentsList.get(position).getTitle());
        intent.putExtra("keywords", mContentsList.get(position).getKeywords());
        intent.putExtra("writer", mContentsList.get(position).getWriter());
        intent.putExtra("url", mContentsList.get(position).getUrl());
        intent.putExtra("like", mContentsList.get(position).getLike());
        intent.putExtra("content", mContentsList.get(position).getContent());
        startActivity(intent);
    }

    @Override
    public void validateSuccess(String text, int code, boolean isSuccess, ContentsResponse.Result result) {
        printLog(TAG,text);
        printLog(TAG, String.valueOf(code));
        printLog(TAG, String.valueOf(isSuccess));
        hideProgressDialog();
        mContentsList = result.getContentsItems();
        mContentsAdpater = new ContentsAdapter(this, mContentsList);
        rvContents.setAdapter(mContentsAdpater);

    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();

    }
}

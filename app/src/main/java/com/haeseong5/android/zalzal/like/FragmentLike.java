package com.haeseong5.android.zalzal.like;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haeseong5.android.zalzal.BaseFragment;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.ContentsService;
import com.haeseong5.android.zalzal.home.views.VideoActivity;
import com.haeseong5.android.zalzal.like.adapters.LikesAdapter;
import com.haeseong5.android.zalzal.like.interfaces.LikeActivityView;
import com.haeseong5.android.zalzal.like.models.LikeItem;
import com.haeseong5.android.zalzal.like.models.LikeResponse;

import java.util.ArrayList;

import static com.haeseong5.android.zalzal.ApplicationClass.X_ACCESS_TOKEN;
import static com.haeseong5.android.zalzal.ApplicationClass.sSharedPreferences;

public class FragmentLike extends BaseFragment implements LikeActivityView, LikesAdapter.OnItemClickListener {
    private String TAG = "FragmentMe";
    private static FragmentLike instance = null;
    private View rootView;
    private RecyclerView likeRecyclerView;
    private LikesAdapter mLikesAdapter;
    private ArrayList<LikeItem> mLikeList;
    private TextView tvMessage;

    public static FragmentLike getInstance() {
        if (instance == null) {
            synchronized (FragmentLike.class) {
                if (instance == null) {
                    instance = new FragmentLike();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_like, container, false);
        initView();
        tryGetLikeList();
        //로그인 여부 체크
        final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
        Log.d("onNewIntent() jwt", jwtToken + "");
        return rootView;
    }

    private void initView() {
        initToolbar(rootView);
        tvToolbarTitle.setText("좋아요 누른\n영상 모음");
        tagsLayout.setVisibility(View.GONE);
        likeRecyclerView = rootView.findViewById(R.id.like_recycler_view);
        likeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        tvMessage = rootView.findViewById(R.id.like_message);
    }
    private void tryGetLikeList(){
        showProgressDialog();
        LikeService likeService = new LikeService(this);
        likeService.getLikes();
    }
    @Override
    public void validateSuccess(String text, int code, boolean isSuccess, LikeResponse.Result result) {
        printLog(TAG,text);
        printLog(TAG, String.valueOf(code));
        printLog(TAG, String.valueOf(isSuccess));
        printLog(TAG, String.valueOf(result.getLikeItems().get(0).getTitle()));


        if (code != 400){
            mLikeList = result.getLikeItems();
        }
        if (mLikeList == null || mLikeList.size() == 0){
            tvMessage.setText(text);
            tvMessage.setVisibility(View.VISIBLE);
        }else{
            likeRecyclerView.setVisibility(View.VISIBLE);
            tvMessage.setVisibility(View.GONE);
            mLikesAdapter = new LikesAdapter(this, mLikeList,getActivity());
            likeRecyclerView.setAdapter(mLikesAdapter);
        }
        hideProgressDialog();

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void onItemClick(int position) {
        printToast(String.valueOf(position));
        Intent intent = new Intent(getActivity(), VideoActivity.class);
        intent.putExtra("title", mLikeList.get(position).getTitle());
        intent.putExtra("keywords", mLikeList.get(position).getKeywords());
        intent.putExtra("writer", mLikeList.get(position).getWriter());
        intent.putExtra("url", mLikeList.get(position).getUrl());
        intent.putExtra("like", mLikeList.get(position).getLike());
        intent.putExtra("content", mLikeList.get(position).getContent());
        startActivity(intent);
    }
}

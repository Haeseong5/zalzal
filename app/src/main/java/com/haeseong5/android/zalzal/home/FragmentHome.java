package com.haeseong5.android.zalzal.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.models.ContentsItem;

import java.util.ArrayList;

public class FragmentHome extends Fragment {
    private String TAG = "FragmentHome";
    private static FragmentHome instance = null;
    private View rootView;
    private ContentsAdapter contentsAdapter;
    private ArrayList<ContentsItem> mContentsList;

    private RecyclerView.LayoutManager mLayoutManager;

    private RecyclerView rvHomeCafe, rvHomeCooking, rvHomeTraining;
    private TextView tvTag1, tvTag2, tvTag3;

    public static FragmentHome getInstance() {
        if (instance == null) {
            synchronized (FragmentHome.class) {
                if (instance == null) {
                    instance = new FragmentHome();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mContentsList = new ArrayList<>();
        contentsAdapter = new ContentsAdapter(getActivity(), mContentsList);
        initView();

        setTestData();
        return rootView;
    }

    private void initView(){
        tvTag1 = rootView.findViewById(R.id.exp_toolbar_tv_tag1);
        tvTag2 = rootView.findViewById(R.id.exp_toolbar_tv_tag2);
        tvTag3 = rootView.findViewById(R.id.exp_toolbar_tv_tag3);

        rvHomeCafe = rootView.findViewById(R.id.home_rv_home_cafe_1);
        rvHomeCooking = rootView.findViewById(R.id.home_rv_home_cooking_2);
        rvHomeTraining = rootView.findViewById(R.id.home_rv_home_training_3);

        rvHomeCafe.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvHomeCooking.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvHomeTraining.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rvHomeCafe.setAdapter(contentsAdapter);
        rvHomeCooking.setAdapter(contentsAdapter);
        rvHomeTraining.setAdapter(contentsAdapter);
    }

    void setTestData(){
        mContentsList.add(new ContentsItem(null, "Title1", "sub title"));
        mContentsList.add(new ContentsItem(null, "Title2", "sub title"));
        mContentsList.add(new ContentsItem(null, "Title3", "sub title"));
        mContentsList.add(new ContentsItem(null, "Title4", "sub title"));
        mContentsList.add(new ContentsItem(null, "Title5", "sub title"));
        mContentsList.add(new ContentsItem(null, "Title6", "sub title"));
        mContentsList.add(new ContentsItem(null, "Title7", "sub title"));
        mContentsList.add(new ContentsItem(null, "Title8", "sub title"));
    }

    @Override
    public void onResume() {
        super.onResume();
        contentsAdapter.notifyDataSetChanged();
    }
}
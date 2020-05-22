package com.haeseong5.android.zalzal.home.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haeseong5.android.zalzal.BaseFragment;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.adapters.ContentsAdapter;
import com.haeseong5.android.zalzal.home.adapters.PickAdapter;
import com.haeseong5.android.zalzal.home.models.PickItem;

import java.util.ArrayList;

public class FragmentHome extends BaseFragment implements PickAdapter.OnItemClickListener {
    private String TAG = "FragmentHome";
    private static FragmentHome instance = null;
    private View rootView;
    private PickAdapter pickAdapter;
    private ArrayList<PickItem> mPickList;

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
        mPickList = new ArrayList<>();
        pickAdapter = new PickAdapter(this, mPickList);
        initView();

        setTestData();
        return rootView;
    }

    private void initView(){
        initToolbar(rootView);
        tvToolbarTitle.setText(getString(R.string.home_title));
        tagsLayout.setVisibility(View.VISIBLE);

        tvTag1 = rootView.findViewById(R.id.exp_toolbar_tv_tag1);
        tvTag2 = rootView.findViewById(R.id.exp_toolbar_tv_tag2);
        tvTag3 = rootView.findViewById(R.id.exp_toolbar_tv_tag3);

        rvHomeCafe = rootView.findViewById(R.id.home_rv_home_cafe_1);
        rvHomeCooking = rootView.findViewById(R.id.home_rv_home_cooking_2);
        rvHomeTraining = rootView.findViewById(R.id.home_rv_home_training_3);

        rvHomeCafe.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvHomeCooking.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvHomeTraining.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rvHomeCafe.setAdapter(pickAdapter);
        rvHomeCooking.setAdapter(pickAdapter);
        rvHomeTraining.setAdapter(pickAdapter);
    }

    void setTestData(){
        mPickList.add(new PickItem(null, "Title1", "sub title"));
        mPickList.add(new PickItem(null, "Title2", "sub title"));
        mPickList.add(new PickItem(null, "Title3", "sub title"));
        mPickList.add(new PickItem(null, "Title4", "sub title"));
        mPickList.add(new PickItem(null, "Title5", "sub title"));
        mPickList.add(new PickItem(null, "Title6", "sub title"));
        mPickList.add(new PickItem(null, "Title7", "sub title"));
        mPickList.add(new PickItem(null, "Title8", "sub title"));
    }

    @Override
    public void onResume() {
        super.onResume();
        pickAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        printToast(String.valueOf(position));
        Intent intent = new Intent(getActivity(), ContentsActivity.class);
        startActivity(intent);
    }
}
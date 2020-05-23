package com.haeseong5.android.zalzal.home.views;


import android.content.Intent;
import android.os.Bundle;
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
import com.haeseong5.android.zalzal.home.HomeService;
import com.haeseong5.android.zalzal.home.adapters.PickAdapter;
import com.haeseong5.android.zalzal.home.interfaces.HomeActivityView;
import com.haeseong5.android.zalzal.home.models.PickItem;
import com.haeseong5.android.zalzal.home.models.PickResponse;

import java.util.ArrayList;

public class FragmentHome extends BaseFragment implements HomeActivityView, PickAdapter.OnItemClickListener {
    private String TAG = "FragmentHome";
    private static FragmentHome instance = null;
    private View rootView;
    private PickAdapter pickAdapter1, pickAdapter2, pickAdapter3;
    private ArrayList<PickItem> mPickList1, mPickList2, mPickList3;

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
//        pickAdapter1 = new PickAdapter(this, mPickList1);
//        pickAdapter2 = new PickAdapter(this, mPickList2);
//        pickAdapter3 = new PickAdapter(this, mPickList3);

        initView();
//        setTestData();

        tryGetPicks();
        return rootView;
    }

    private void tryGetPicks(){
        showProgressDialog();
        HomeService homeService = new HomeService(this);
        homeService.getPicks();
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

    }

//    void setTestData(){
//        mPickList.add(new PickItem(null, "Title1", "sub title"));
//        mPickList.add(new PickItem(null, "Title2", "sub title"));
//        mPickList.add(new PickItem(null, "Title3", "sub title"));
//        mPickList.add(new PickItem(null, "Title4", "sub title"));
//        mPickList.add(new PickItem(null, "Title5", "sub title"));
//        mPickList.add(new PickItem(null, "Title6", "sub title"));
//        mPickList.add(new PickItem(null, "Title7", "sub title"));
//        mPickList.add(new PickItem(null, "Title8", "sub title"));
//    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onItemClick(int pick_id) {
        printToast(String.valueOf(pick_id));
        Intent intent = new Intent(getActivity(), ContentsActivity.class);
        intent.putExtra("pick_id", pick_id);
        printToast(String.valueOf(pick_id));
        startActivity(intent);
    }

    @Override
    public void validateSuccess(String text, int code, boolean isSuccess, ArrayList<PickResponse.Pick> result) {
        printLog(TAG,text);
        printLog(TAG, String.valueOf(code));
        printLog(TAG, String.valueOf(isSuccess));
        printLog(TAG, String.valueOf(result.size()));
        printLog(TAG, String.valueOf(result.get(0).getPickItems().get(0).toString()));
        mPickList1 = result.get(0).getPickItems();
        mPickList2 = result.get(1).getPickItems();
        mPickList3 = result.get(2).getPickItems();
        printLog("mPickList", String.valueOf(result.get(0).getPickItems().size()));

        pickAdapter1 = new PickAdapter(this, mPickList1, getActivity());
        pickAdapter2 = new PickAdapter(this, mPickList2, getActivity());
        pickAdapter3 = new PickAdapter(this, mPickList3, getActivity());

        rvHomeCafe.setAdapter(pickAdapter1);
        rvHomeCooking.setAdapter(pickAdapter2);
        rvHomeTraining.setAdapter(pickAdapter3);

        pickAdapter1.notifyDataSetChanged();
        pickAdapter2.notifyDataSetChanged();
        pickAdapter3.notifyDataSetChanged();

        hideProgressDialog();
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();

    }
}
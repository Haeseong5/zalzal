package com.haeseong5.android.zalzal.pick;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haeseong5.android.zalzal.BaseFragment;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.adapters.ContentsAdapter;
import com.haeseong5.android.zalzal.home.models.ContentsItem;

import java.util.ArrayList;

public class FragmentPick extends BaseFragment implements ContentsAdapter.OnItemClickListener{
    private String TAG = "FragmentPick";
    private static FragmentPick instance = null;
    private View rootView;
    private ArrayList<ContentsItem> mContentsList;
    private ContentsAdapter mContentsAdapter;
    private RecyclerView recyclerView;
//    private DemoBottomSheetFragment bottomSheetFragment;
    public static FragmentPick getInstance() {
        if (instance == null) {
            synchronized (FragmentPick.class) {
                if (instance == null) {
                    instance = new FragmentPick();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_pick, container, false);
        mContentsList = new ArrayList<>();
        mContentsAdapter = new ContentsAdapter(this, mContentsList);
        initView();
//        bottomSheetFragment = new DemoBottomSheetFragment();
//        FragmentManager fragmentManager  = getActivity().getSupportFragmentManager();
//        bottomSheetFragment.show(fragmentManager, "DemoBottomSheetFragment");

        return rootView;
    }

    private void initView() {
        initToolbar(rootView);
        tvToolbarTitle.setText(R.string.pick_title);

        recyclerView = rootView.findViewById(R.id.pick_rv_contents_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(mContentsAdapter);
    }


    @Override
    public void onItemClick(int position) {

    }

//    public static class DemoBottomSheetFragment extends SuperBottomSheetFragment{
//        @org.jetbrains.annotations.Nullable
//        @Override
//        public View onCreateView(@NotNull LayoutInflater inflater, @org.jetbrains.annotations.Nullable ViewGroup container, @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
//            super.onCreateView(inflater, container, savedInstanceState);
//            return inflater.inflate(R.layout.bottom_sheet, container, false);
//        }
//    }

}
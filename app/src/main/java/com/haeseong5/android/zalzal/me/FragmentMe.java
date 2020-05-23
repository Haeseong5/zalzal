package com.haeseong5.android.zalzal.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haeseong5.android.zalzal.BaseActivity;
import com.haeseong5.android.zalzal.BaseFragment;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.adapters.ContentsAdapter;
import com.haeseong5.android.zalzal.home.models.ContentsItem;
import com.haeseong5.android.zalzal.pick.FragmentPick;

import java.util.ArrayList;

public class FragmentMe extends BaseFragment {
    private String TAG = "FragmentMe";
    private static FragmentMe instance = null;
    private View rootView;

    //    private DemoBottomSheetFragment bottomSheetFragment;
    public static FragmentMe getInstance() {
        if (instance == null) {
            synchronized (FragmentMe.class) {
                if (instance == null) {
                    instance = new FragmentMe();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_me, container, false);
        initView();
        return rootView;
    }

    private void initView() {

    }
}

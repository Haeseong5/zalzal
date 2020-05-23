package com.haeseong5.android.zalzal.like;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.haeseong5.android.zalzal.BaseFragment;
import com.haeseong5.android.zalzal.R;

public class FragmentLike extends BaseFragment {
    private String TAG = "FragmentMe";
    private static FragmentLike instance = null;
    private View rootView;

    //    private DemoBottomSheetFragment bottomSheetFragment;
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
        rootView = inflater.inflate(R.layout.fragment_me, container, false);
        initView();
        return rootView;
    }

    private void initView() {

    }
}

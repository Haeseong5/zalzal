package com.haeseong5.android.zalzal.me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haeseong5.android.zalzal.BaseActivity;
import com.haeseong5.android.zalzal.BaseFragment;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.adapters.ContentsAdapter;
import com.haeseong5.android.zalzal.home.models.ContentsItem;
import com.haeseong5.android.zalzal.login.LoginActivity;
import com.haeseong5.android.zalzal.login.interfaces.LoginActivityView;
import com.haeseong5.android.zalzal.pick.FragmentPick;

import java.util.ArrayList;

import static com.haeseong5.android.zalzal.ApplicationClass.X_ACCESS_TOKEN;
import static com.haeseong5.android.zalzal.ApplicationClass.sSharedPreferences;

public class FragmentMe extends BaseFragment {
    private String TAG = "FragmentMe";
    private static FragmentMe instance = null;
    private View rootView;

    private ImageView ivLogin, ivSignUp;
    private LinearLayout layout1, layout2;


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
        isLogin();
        return rootView;
    }

    private void initView() {
        ivLogin = rootView.findViewById(R.id.me_iv_login);
        ivSignUp = rootView.findViewById(R.id.me_iv_signup);
        layout1 = rootView.findViewById(R.id.me_not_login_layout);
        layout2 = rootView.findViewById(R.id.me_ok_login_layout);
        ivLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    void isLogin(){

        //로그인 여부 체크
        final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
        Log.d("onNewIntent() jwt", jwtToken + "");
        if (jwtToken != null) {
            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.VISIBLE);
        } else{//로그인되어있찌 않은 사용자가 앱으로 들어오면
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.GONE);
        }
    }


}

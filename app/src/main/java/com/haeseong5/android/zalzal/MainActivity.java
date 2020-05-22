package com.haeseong5.android.zalzal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.haeseong5.android.zalzal.home.views.FragmentHome;
import com.haeseong5.android.zalzal.pick.FragmentPick;

public class MainActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;     // Activity 내의 Fragment를 관리하기 위해서는 FragmentManager를 사용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBottomNavigationView();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //Fragment의 추가, 제거, 변경 등의 작업
//        fragmentTransaction.add(R.id.fragment_container, FragmentHome.getInstance()).commit(); //첫 프래그먼트 지정
        fragmentTransaction.replace(R.id.fragment_container, FragmentHome.getInstance()).commit(); //첫 프래그먼트 지정
    }

    protected void setBottomNavigationView()
    {
        bottomNavigationView = findViewById(R.id.main_bottom_navigation_view);
        bottomNavigationView.setItemIconTintList(null);

        // BottomNavigationView 메뉴를 선택할 때마다 위치가 변하지 않도록
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_menu1: {
                        replaceFragment(FragmentHome.getInstance());
                        break;
                    }
                    case R.id.navigation_menu2: {
                        replaceFragment(FragmentHome.getInstance());
                        break;
                    }
                    case R.id.navigation_menu3: {
                        replaceFragment(FragmentPick.getInstance());
                        break;
                    }
                    case R.id.navigation_menu4: {
                        replaceFragment(FragmentHome.getInstance());
                        break;
                    }
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
    }
}

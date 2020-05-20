package com.haeseong5.android.zalzal;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    public ProgressDialog mProgressDialog;
    public Toolbar mBaseToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Window window = getWindow();

        //상태바 반투명 만들기
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            int newUiOptions = getWindow().getDecorView().getSystemUiVisibility();
//            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
//            getWindow().getDecorView().setSystemUiVisibility(newUiOptions
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }
//        // Check if the version of Android is Lollipop or higher
//        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//            setWindowFlag(this, false);
//            getWindow().setStatusBarColor(ContextCompat.getColor(this, 0x00000000));
//        }

    // 상태바,소프트키 모두 투명상태로 만들기
//        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

//        상태바만 투명상태로 만들기
//        https://pupabu.tistory.com/6
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0x00000000); // transparent
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        super.onCreate(savedInstanceState);

    }

    private static void setWindowFlag(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        } else {
            winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        }
        win.setAttributes(winParams);
    }


    public void showCustomToast(final String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCanceledOnTouchOutside(false);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 3초가 지나면 다이얼로그 닫기
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        hideProgressDialog();
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
//                                showCustomToast(getString(R.string.network_error));
                            }
                        });
                    }
                };

                Timer timer = new Timer();
                timer.schedule(task, 10000);
            }
        });
        if (mProgressDialog.isShowing()) {
            thread.start();
        }


        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void hideKeyboard(EditText editText) {
        InputMethodManager inputManager = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        inputManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    public void printToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void printLog(String TAG, String log) {
        Log.d(TAG, log);
    }


    public class BackPressCloseHandler {

        private long backKeyPressedTime = 0;
        private Activity activity;

        public BackPressCloseHandler(Activity context) {
            this.activity = context;
        }

        public void onBackPressed() {
            if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis();
                showCustomToast(getString(R.string.backPressed));
                return;
            }
            if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                activity.finish();
            }
        }

    }
}

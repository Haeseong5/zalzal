package com.haeseong5.android.zalzal;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

@SuppressLint("Registered")
public class BaseFragment extends Fragment {
    public ProgressDialog mProgressDialog;
    public TextView tvToolbarTitle;
    public LinearLayout tagsLayout;

    public void initToolbar(View view){
        tvToolbarTitle = view.findViewById(R.id.exp_toolbar_tv_title);
        tagsLayout = view.findViewById(R.id.exp_toolbar_layout_tags);
    }
    public void showCustomToast(final String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    public void printToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void printLog(String TAG, String log) {
        Log.d(TAG, log);
    }

}

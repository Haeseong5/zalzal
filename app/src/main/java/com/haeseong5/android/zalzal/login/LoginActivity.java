package com.haeseong5.android.zalzal.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.haeseong5.android.zalzal.BaseActivity;
import com.haeseong5.android.zalzal.MainActivity;
import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.login.interfaces.LoginActivityView;



public class LoginActivity extends BaseActivity implements LoginActivityView {

    private final int RC_SIGN_IN = 100;
//    GoogleSignInClient mGoogleSignInClient;
//    private FirebaseAuth mAuth;

    BackPressCloseHandler mBackPressCloseHandler;
//    SignInButton mBtnGoogleSignIn;

    EditText mEtLoginEmail, mEtLoginPw;
    ImageView mIvLoginBtn, mIvKakaoBtn;

//    String mGoogleEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//
        mEtLoginEmail = findViewById(R.id.login_et_email);
        mEtLoginPw = findViewById(R.id.login_et_pw);
        mIvLoginBtn = findViewById(R.id.login_iv_btn);

        mBackPressCloseHandler = new BackPressCloseHandler(this);

        mIvLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trySignIn();
            }
        });
    }

    private void trySignIn() {
        String email = mEtLoginEmail.getText().toString();
        String pw = mEtLoginPw.getText().toString();

        if (email == null || email.length() == 0) {
            showCustomToast(getString(R.string.login_empty_email));
        } else if (pw == null || pw.length() == 0) {
            showCustomToast(getString(R.string.login_empty_pw));
        } else {
            showProgressDialog();
            LoginService loginService = new LoginService(this);
            loginService.postLogin(email, pw);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
////            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            try {
//                GoogleSignInAccount account = task.getResult(ApiException.class);
//                firebaseAuthWithGoogle(account);
//            } catch (ApiException e) {
//                hideProgressDialog();
////                Snackbar.make(findViewById(R.id.login_btn_google_sign_in), getString(R.string.googleSingInError), Snackbar.LENGTH_SHORT).show();
//
//            }
//        }
    }

//    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
//
//        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            mGoogleEmail = user.getEmail();
//                            tryPostValidateGoogleLogin(mGoogleEmail);
//                        } else {
//                            hideProgressDialog();
////                            Snackbar.make(findViewById(R.id.login_btn_google_sign_in), getString(R.string.googleSingInError), Snackbar.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }


    @Override
    public void validateSuccess(boolean isSuccess, int code, String message) {
        hideProgressDialog();
        if (code==200) {
            Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);
        }else if(code==400){
//            Intent signUpGoogleIntent = new Intent(LoginActivity.this, MainActivity.class);
//            signUpGoogleIntent.putExtra("email", mGoogleEmail);
//            startActivity(signUpGoogleIntent);
            Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);
        }else{
            showCustomToast(message);
            Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);
        }
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
//        switch (view.getId()) {
//            case R.id.login_btn_login:
//                trySignIn();
//                break;
//            case R.id.login_tv_signup:
//                Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
//                startActivity(signUpIntent);
//                break;
//            case R.id.login_ll_activity:
//                hideKeyboard(mEtLoginEmail);
//                hideKeyboard(mEtLoginPw);
//                break;
//            default:
//                break;
//        }
    }

    @Override
    public void onBackPressed() {
        mBackPressCloseHandler.onBackPressed();
    }
}



package com.haeseong5.android.zalzal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ContentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, ContentsActivity.class));
    }
}

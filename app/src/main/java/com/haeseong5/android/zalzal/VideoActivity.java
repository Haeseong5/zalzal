package com.haeseong5.android.zalzal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kr.co.prnd.YouTubePlayerView;

public class VideoActivity extends AppCompatActivity {
    private final String VIDEO_ID = "3QjxIwUemgo";
    private YouTubePlayerView mYouTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mYouTubePlayerView = findViewById(R.id.you_tube_player_view);
        mYouTubePlayerView.play(VIDEO_ID,null);
    }
}

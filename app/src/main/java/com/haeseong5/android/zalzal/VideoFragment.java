package com.haeseong5.android.zalzal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.co.prnd.YouTubePlayerView;

public class VideoFragment extends Fragment {
    private YouTubePlayerView mYouTubePlayerView;
    private final String VIDEO_ID = "m2SZ6RV_J7I";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        mYouTubePlayerView = rootView.findViewById(R.id.fragment_you_tube_player_view);
        mYouTubePlayerView.play(VIDEO_ID,null);
        return rootView;
    }
}

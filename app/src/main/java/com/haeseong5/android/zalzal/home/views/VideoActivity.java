package com.haeseong5.android.zalzal.home.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haeseong5.android.zalzal.R;
import com.haeseong5.android.zalzal.home.models.ContentsItem;

import kr.co.prnd.YouTubePlayerView;

public class VideoActivity extends AppCompatActivity {
    private final String VIDEO_ID = "3QjxIwUemgo";
    private YouTubePlayerView mYouTubePlayerView;
    private TextView tvTitle, tvWriter, tvContent;
    private ImageView ivLike;
    private ContentsItem mContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();

        mYouTubePlayerView.play(VIDEO_ID,null);
        setTestData();
    }

    private void initView(){
        mYouTubePlayerView = findViewById(R.id.video_youtube_player_view);
        setMargin();
        tvTitle = findViewById(R.id.video_tv_title);
        tvContent = findViewById(R.id.video_tv_content);
        tvWriter = findViewById(R.id.video_tv_writer);
        ivLike = findViewById(R.id.video_iv_like);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void setMargin(){
        /*변경하고 싶은 레이아웃의 파라미터 값을 가져 옴*/
        LinearLayout.LayoutParams plControl = (LinearLayout.LayoutParams) mYouTubePlayerView.getLayoutParams();

        /*해당 margin값 변경*/
        plControl.topMargin = getStatusBarHeight();

        /*변경된 값의 파라미터를 해당 레이아웃 파라미터 값에 셋팅*/
        mYouTubePlayerView.setLayoutParams(plControl);
    }
    void setTestData(){
        mContents = new ContentsItem();
        mContents.setContent("내용 테스트 ㅎㅎ!!!!!!!!!!!!!");
        mContents.setTitle("맛있는 커피~");
        mContents.setWriter("writer");
        tvTitle.setText(mContents.getTitle());
        tvWriter.setText(mContents.getWriter());
        tvContent.setText(mContents.getContent());
    }
}

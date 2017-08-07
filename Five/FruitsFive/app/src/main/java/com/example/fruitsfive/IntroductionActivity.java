package com.example.fruitsfive;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroductionActivity extends AppCompatActivity {

    @BindView(R.id.jump)
    Button jump;
    private int count = 4;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                jump.setText(count + "跳过");
                if (count == 0) {
                    startActivity(new Intent(IntroductionActivity.this, MainActivity.class));
                    finish();
                }
                count--;
                sendEmptyMessageDelayed(1, 1000);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        ButterKnife.bind(this);
        handler.sendEmptyMessageDelayed(1, 1000);
    }

    @OnClick(R.id.jump)
    void jump() {
        handler.removeMessages(1);
        startActivity(new Intent(IntroductionActivity.this, MainActivity.class));
        finish();
    }

}

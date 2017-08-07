package com.example.l.lirensheng20170807;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by L on 2017/8/7.
 */

public class TopBar extends RelativeLayout {
    private Button btn_left, btn_right;
    private TextView text_title;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightColor;
    private Drawable rightBackground;
    private String rightText;

    private int titleTextColor;
    private String topText;
    private Drawable titleBackground;
    private LayoutParams leftParams, rightParams, titleParams;

    public interface topbarClickListener {
        public void leftClick();

        public void rightClick();
    }

    public topbarClickListener listener;

    public TopBar(Context context) {
        super(context);
    }

    public void setOnTopBarClickListener(topbarClickListener listener) {
        this.listener = listener;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public TopBar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        leftText = ta.getString(R.styleable.TopBar_leftText);

        rightColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        rightText = ta.getString(R.styleable.TopBar_rightText);

        topText = ta.getString(R.styleable.TopBar_topTitle);
        titleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        titleBackground=ta.getDrawable(R.styleable.TopBar_titleBackground);
        ta.recycle();

        btn_left = new Button(context);
        btn_right = new Button(context);
        text_title = new TextView(context);

        btn_left.setTextColor(leftTextColor);
        btn_left.setBackground(leftBackground);
        btn_left.setText(leftText);

        btn_right.setTextColor(rightColor);
        btn_right.setBackground(rightBackground);
        btn_right.setText(rightText);

        text_title.setText(topText);
        text_title.setTextColor(titleTextColor);
        //text_title.setBackground(titleBackground);
        setBackgroundColor(0xFFF59563);

        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(btn_left, leftParams);

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(btn_right, rightParams);


        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(text_title, titleParams);

        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();


            }
        });
        btn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();

            }
        });
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

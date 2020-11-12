package com.gcg.todayinformation.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class SpVideoView extends VideoView {
    public SpVideoView(Context context) {
        super(context);
    }

    public SpVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }
}

package com.example.android.androidscrolltest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by niedaocai on 20/11/2016.
 */

public class ScrollToDragView extends View {
    public ScrollToDragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onTouchEvent(MotionEvent event) {
        /*获取X, Y的视图坐标值*/
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                /*scrollTo(x,y)
                1. 当x > 0时，朝X轴正方向移动
                    当x< 0时，朝X轴负方向移动，这个是和之前当认知有差别的，
                2. 同理y
                3. 当ScrollTo移动的是View, 是让View的content移动，如TextView的content就是他的文本，
                    ImageView的Content就是他的drawable对象
                4. 当ScrollTo移动的是ViewGroup, 他移动的是ViewGroup中的所有子View
                */
                ((View) getParent()).scrollTo(-x, -y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}

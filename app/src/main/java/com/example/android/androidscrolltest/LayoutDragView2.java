package com.example.android.androidscrolltest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by niedaocai on 20/11/2016.
 */

public class LayoutDragView2 extends View {
    private int mLastRawX;
    private int mLastRawY;
    public LayoutDragView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onTouchEvent(MotionEvent event) {
        /*获取X, Y的绝对坐标值*/
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /*按下时，记录X,Y*/
                mLastRawX = rawX;
                mLastRawY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                int offX = rawX - mLastRawX; //相对按下时，X的偏移量
                int offY = rawY - mLastRawY;
                layout(getLeft() + offX, // 基于按下时的Left + X方向的移动偏移量
                        getTop() + offY,
                        getRight() + offX,
                        getBottom() + offY);
                mLastRawX = rawX;
                mLastRawY = rawY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}

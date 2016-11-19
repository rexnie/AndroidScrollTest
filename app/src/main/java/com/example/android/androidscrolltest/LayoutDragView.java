package com.example.android.androidscrolltest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by niedaocai on 19/11/2016.
 */

public class LayoutDragView extends View {
    private int mLastX;
    private int mLastY;
    public LayoutDragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onTouchEvent(MotionEvent event) {
        /*获取X, Y的视图坐标值*/
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /*按下时，记录X,Y*/
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offX = x - mLastX; //相对按下时，X的偏移量
                int offY = y - mLastY;
                layout(getLeft() + offX, // 基于按下时的Left + X方向的移动偏移量
                        getTop() + offY,
                        getRight() + offX,
                        getBottom() + offY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}

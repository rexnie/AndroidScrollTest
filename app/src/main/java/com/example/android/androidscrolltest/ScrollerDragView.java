package com.example.android.androidscrolltest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by niedaocai on 20/11/2016.
 */

public class ScrollerDragView extends View {
    private int mLastX;
    private int mLastY;
    private Scroller mScroller;
    public ScrollerDragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                View vg = (View) getParent();
                mScroller.startScroll(vg.getScrollX(),
                        vg.getScrollY(),
                        mLastX - x, // -offset, the same as ScrollTo,ScrollBy
                        mLastY - y, // -offset
                        3000); //in ms
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}

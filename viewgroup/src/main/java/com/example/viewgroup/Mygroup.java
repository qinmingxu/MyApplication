package com.example.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wan on 2017/11/29.
 */

public class Mygroup extends ViewGroup {
    public Mygroup(Context context) {
        super(context);
    }

    public Mygroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Mygroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        if(widthmode==MeasureSpec.AT_MOST&&heightmode==MeasureSpec.AT_MOST){
            View view = getChildAt(0);
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight()*2;
            setMeasuredDimension(width,height);
        }else if(widthmode==MeasureSpec.AT_MOST){

        }else if(heightmode==MeasureSpec.AT_MOST){

        }else {

        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        View v1 = getChildAt(0);
        v1.layout(0,0,v1.getMeasuredWidth(),v1.getMeasuredHeight());
        View v2 = getChildAt(1);
        v2.layout(0,v1.getMeasuredHeight(),v1.getMeasuredWidth(),v1.getMeasuredHeight()*2);
    }
}

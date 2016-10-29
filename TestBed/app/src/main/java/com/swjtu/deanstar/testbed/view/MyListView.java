package com.swjtu.deanstar.testbed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by yhp5210 on 2016/10/13.
 * 滑动到顶部还可以继续滑动的listview
 */

public class MyListView  extends ListView{

    private int mMaxOverScrollY = 100;
    private Context mContext;
    private final String TAG = "MyListView";
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {

        super(context, attrs);
        mContext = context;
        initView();
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }


    @Override
    protected boolean overScrollBy(int deltaX,int deltaY,int scrollX,int scrollY,int scrollRangeX,int scrollRangeY
            ,int maxOverScrollX,int maxOverScrollY,boolean isTouchEvent){



        return  super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverScrollY, isTouchEvent);
    }


    /**
     * 为了让各个分辨率下的手机滑动基本相同
     */

    private void initView(){

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        Log.d(TAG,"density:"+density);
        mMaxOverScrollY = (int)density * mMaxOverScrollY;
    }


}

package com.swjtu.deanstar.testbed.util;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.WindowManager;

/**
 * Created by yhp5210 on 2016/10/29.
 */

public class ScreenUtil {


    public static Point getScreenSize(Context context){

        Point outPoint = new Point();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
         wm.getDefaultDisplay().getSize(outPoint);
        return outPoint;

    }
}

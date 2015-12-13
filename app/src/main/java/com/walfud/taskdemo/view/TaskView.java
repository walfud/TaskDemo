package com.walfud.taskdemo.view;

import android.app.ActivityManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by walfud on 2015/12/13.
 */
public class TaskView extends FrameLayout {
    public TaskView(Context context) {
        this(context, null);
    }

    public TaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // Function
    public void set(ActivityManager.AppTask task) {

    }
}

package com.walfud.taskdemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.walfud.taskdemo.view.TaskView;

import java.util.List;

/**
 * Created by walfud on 2015/12/10.
 */
public class BaseActivity extends Activity implements View.OnClickListener {

    private static long mId = 0;

    private HorizontalScrollView mHsv;

    private Button mStartActivity;
    private TextView mIdTv;

    private RadioButton mModeStandardA;
    private RadioButton mModeStandardB;
    private RadioButton mModeStandardC;
    private RadioButton mModeSingleTopA;
    private RadioButton mModeSingleTopB;
    private RadioButton mModeSingleTopC;
    private RadioButton mModeSingleTaskA;
    private RadioButton mModeSingleTaskB;
    private RadioButton mModeSingleTaskC;
    private RadioButton mModeSingleInstanceA;
    private RadioButton mModeSingleInstanceB;
    private RadioButton mModeSingleInstanceC;

    private CheckBox mFlagNewTask;
    private CheckBox mFlagMultipleTask;
    private CheckBox mFlagClearTask;
    private CheckBox mFlagTaskOnHome;
    private CheckBox mFlagSingleTop;
    private CheckBox mFlagClearTop;
    private CheckBox mFlagNoHistory;
    private CheckBox mFlagExcludeFromRecents;
    private CheckBox mFlagReorderToFront;
    private CheckBox mFlagPreviousIsTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHsv = $(R.id.hsv_task);

        mStartActivity = $(R.id.btn_start_activity);
        mIdTv = $(R.id.tv_id);

        mModeStandardA = $(R.id.rb_mode_standard_a);
        mModeStandardB = $(R.id.rb_mode_standard_b);
        mModeStandardC = $(R.id.rb_mode_standard_c);
        mModeSingleTopA = $(R.id.rb_mode_single_top_a);
        mModeSingleTopB = $(R.id.rb_mode_single_top_b);
        mModeSingleTopC = $(R.id.rb_mode_single_top_c);
        mModeSingleTaskA = $(R.id.rb_mode_single_task_a);
        mModeSingleTaskB = $(R.id.rb_mode_single_task_b);
        mModeSingleTaskC = $(R.id.rb_mode_single_task_c);
        mModeSingleInstanceA = $(R.id.rb_mode_single_instance_a);
        mModeSingleInstanceB = $(R.id.rb_mode_single_instance_b);
        mModeSingleInstanceC = $(R.id.rb_mode_single_instance_c);

        mFlagNewTask = $(R.id.cb_flag_new_task);
        mFlagMultipleTask = $(R.id.cb_flag_multiple_task);
        mFlagClearTask = $(R.id.cb_flag_clear_task);
        mFlagTaskOnHome = $(R.id.cb_flag_task_on_home);
        mFlagSingleTop = $(R.id.cb_flag_single_top);
        mFlagClearTop = $(R.id.cb_flag_clear_top);
        mFlagNoHistory = $(R.id.cb_flag_no_history);
        mFlagExcludeFromRecents = $(R.id.cb_flag_exclude_from_recents);
        mFlagReorderToFront = $(R.id.cb_flag_reorder_to_front);
        mFlagPreviousIsTop = $(R.id.cb_flag_previous_is_top);

        //
        mStartActivity.setOnClickListener(this);
        mIdTv.setText(String.format("id: %d", mId++));
    }

    @Override
    protected void onResume() {
        super.onResume();

        mHsv.removeAllViews();

        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        for (ActivityManager.AppTask task : appTaskList) {
            TaskView taskView = (TaskView) LayoutInflater.from(this).inflate(R.layout.view_task, mHsv, false);
            task.getTaskInfo().
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_activity:
                startActivity(parseIntent());
                break;

            default:
                break;
        }
    }

    // Function
    public Intent parseIntent() {
        Intent intent = new Intent();

        // Launch mode
        if (false) {
            // Stub

        } else if (mModeStandardA.isChecked()) {
            intent.setComponent(new ComponentName(this, StandardAActivity.class));
        } else if (mModeStandardB.isChecked()) {
            intent.setComponent(new ComponentName(this, StandardBActivity.class));
        } else if (mModeStandardC.isChecked()) {
            intent.setComponent(new ComponentName(this, StandardCActivity.class));

        } else if (mModeSingleTopA.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleTopAActivity.class));
        } else if (mModeSingleTopB.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleTopBActivity.class));
        } else if (mModeSingleTopC.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleTopCActivity.class));

        } else if (mModeSingleTaskA.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleTaskAActivity.class));
        } else if (mModeSingleTaskB.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleTaskBActivity.class));
        } else if (mModeSingleTaskC.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleTaskCActivity.class));

        } else if (mModeSingleInstanceA.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleInstanceAActivity.class));
        } else if (mModeSingleInstanceB.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleInstanceBActivity.class));
        } else if (mModeSingleInstanceC.isChecked()) {
            intent.setComponent(new ComponentName(this, SingleInstanceCActivity.class));

        } else {
            // Nothing
        }

        // Flags
        if (mFlagNewTask.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        if (mFlagMultipleTask.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        }
        if (mFlagClearTask.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        if (mFlagTaskOnHome.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        }
        if (mFlagSingleTop.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }
        if (mFlagClearTop.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        if (mFlagNoHistory.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        }
        if (mFlagExcludeFromRecents.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        }
        if (mFlagReorderToFront.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        }
        if (mFlagPreviousIsTop.isChecked()) {
            intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        }

        return intent;
    }

    // Internal
    private <T extends View> T $(int resId) {
        return (T) findViewById(resId);
    }
}

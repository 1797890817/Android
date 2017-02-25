package com.ddb.activitylifecycletest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepin on 17-2-25.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    //添加活动
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    //删除活动
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    //清楚所有活动
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }

        activities.clear();
    }

}

package com.sonelli;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
@TargetApi(24)
/* renamed from: com.sonelli.cp */
/* loaded from: classes.dex */
public final class C0840cp {

    /* renamed from: b */
    @Nullable
    public static final Method f2022b = m2897c();

    /* renamed from: c */
    @Nullable
    public static final Method f2023c = m2898d();

    /* renamed from: a */
    public final JobScheduler f2024a;

    public C0840cp(JobScheduler jobScheduler) {
        this.f2024a = jobScheduler;
    }

    /* renamed from: b */
    public static int m2896b(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        return (f2022b == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) ? jobScheduler.schedule(jobInfo) : new C0840cp(jobScheduler).m2900a(jobInfo, str, m2899e(), str2);
    }

    @Nullable
    /* renamed from: c */
    public static Method m2897c() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            if (!Log.isLoggable("JobSchedulerCompat", 6)) {
                return null;
            }
            Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            return null;
        }
    }

    @Nullable
    /* renamed from: d */
    public static Method m2898d() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        return null;
    }

    /* renamed from: e */
    public static int m2899e() {
        Method method = f2023c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public final int m2900a(JobInfo jobInfo, String str, int i, String str2) {
        Method method = f2022b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f2024a, jobInfo, str, Integer.valueOf(i), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.e(str2, "error calling scheduleAsPackage", e);
            }
        }
        return this.f2024a.schedule(jobInfo);
    }
}

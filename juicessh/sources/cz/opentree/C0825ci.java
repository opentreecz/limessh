package cz.opentree;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.gtm.zzdd;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
/* renamed from: cz.opentree.ci */
/* loaded from: classes.dex */
public final class C0825ci {

    /* renamed from: b */
    @Nullable
    public static final Method f1948b = m2808c();

    /* renamed from: c */
    @Nullable
    public static final Method f1949c = m2809d();

    /* renamed from: d */
    public static volatile zzdd f1950d = C0877di.f2177a;

    /* renamed from: a */
    public final JobScheduler f1951a;

    public C0825ci(JobScheduler jobScheduler) {
        this.f1951a = jobScheduler;
    }

    /* renamed from: b */
    public static int m2807b(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        return (f1948b != null && f1950d.mo1217a() && context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0) ? new C0825ci(jobScheduler).m2812a(jobInfo, str, m2810e(), str2) : jobScheduler.schedule(jobInfo);
    }

    @Nullable
    /* renamed from: c */
    public static Method m2808c() {
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
    public static Method m2809d() {
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
    public static int m2810e() {
        Method method = f1949c;
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

    /* renamed from: f */
    public static final /* synthetic */ boolean m2811f() {
        return false;
    }

    /* renamed from: a */
    public final int m2812a(JobInfo jobInfo, String str, int i, String str2) {
        Method method = f1948b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f1951a, jobInfo, str, Integer.valueOf(i), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.e(str2, "error calling scheduleAsPackage", e);
            }
        }
        return this.f1951a.schedule(jobInfo);
    }
}

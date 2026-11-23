package com.sonelli.juicessh.widgets;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.RemoteViews;
import com.sonelli.gj0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.activities.AddressBookActivity;
import com.sonelli.juicessh.activities.ConfigureWidgetActivity;
import com.sonelli.juicessh.activities.MainActivity;
import com.sonelli.juicessh.activities.ManageConnectionActivity;
import com.sonelli.juicessh.activities.PurchaseActivity;
import com.sonelli.juicessh.activities.TerminalEmulatorActivity;

/* loaded from: classes.dex */
public class ConnectionWidgetProvider extends AppWidgetProvider {

    /* renamed from: a */
    public static String f4384a = "ConnectionWidget";

    /* renamed from: b */
    public static String f4385b = "com.sonelli.juicessh.widget.action.REFRESH";

    /* loaded from: classes.dex */
    public static class WidgetUpdateJob extends JobService {
        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            if (jobParameters == null) {
                gj0.m4142c(ConnectionWidgetProvider.f4384a, "Attempted a period update of a widget, but no widget id was passed");
                return false;
            }
            int i = extras.getInt("widget_id");
            if (i < 0) {
                gj0.m4142c(ConnectionWidgetProvider.f4384a, "Attempted a period update of a widget, but an invalid widget id was passed");
                return false;
            }
            gj0.m4141b(ConnectionWidgetProvider.f4384a, "Performing peridic update to JuiceSSH widget " + i);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
            if (appWidgetManager != null) {
                appWidgetManager.notifyAppWidgetViewDataChanged(i, R.id.widget_list);
            }
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public final RemoteViews m5731a(Context context, int i) {
        gj0.m4141b(f4384a, "Building widget id: " + i);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_frequently_used);
        Intent intent = new Intent(context, (Class<?>) ConnectionWidgetService.class);
        intent.setData(Uri.parse("update://" + i));
        intent.putExtra("appWidgetId", i);
        if (Build.VERSION.SDK_INT >= 14) {
            remoteViews.setRemoteAdapter(R.id.widget_list, intent);
        } else {
            remoteViews.setRemoteAdapter(i, R.id.widget_list, intent);
        }
        Intent intent2 = new Intent(context, (Class<?>) TerminalEmulatorActivity.class);
        intent2.setAction("do-not-cache" + System.currentTimeMillis());
        intent2.setFlags(402653184);
        remoteViews.setPendingIntentTemplate(R.id.widget_list, PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent2, 134217728));
        Intent intent3 = new Intent(context, (Class<?>) ConnectionWidgetProvider.class);
        intent3.setAction(f4385b);
        intent3.putExtra("appWidgetId", i);
        remoteViews.setOnClickPendingIntent(R.id.widget_refresh_button, PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent3, 134217728));
        Intent intent4 = new Intent(context, (Class<?>) ConfigureWidgetActivity.class);
        intent4.putExtra("appWidgetId", i);
        remoteViews.setOnClickPendingIntent(R.id.widget_configure_button, PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent4, 134217728));
        PendingIntent activity = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), new Intent(context, (Class<?>) MainActivity.class), 134217728);
        remoteViews.setOnClickPendingIntent(R.id.widget_title, activity);
        remoteViews.setOnClickPendingIntent(R.id.widget_icon, activity);
        remoteViews.setOnClickPendingIntent(R.id.widget_add_button, PendingIntent.getActivities(context, (int) System.currentTimeMillis(), new Intent[]{new Intent(context, (Class<?>) AddressBookActivity.class), new Intent(context, (Class<?>) ManageConnectionActivity.class)}, 134217728));
        remoteViews.setOnClickPendingIntent(R.id.widget_problock_screen, PendingIntent.getActivity(context, (int) System.currentTimeMillis(), new Intent(context, (Class<?>) PurchaseActivity.class), 134217728));
        return remoteViews;
    }

    /* renamed from: b */
    public void m5732b(Context context, int i) {
        gj0.m4141b(f4384a, "Updating JuiceSSH widget " + i);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (appWidgetManager != null) {
            appWidgetManager.notifyAppWidgetViewDataChanged(i, R.id.widget_list);
        }
        Long valueOf = Long.valueOf(Long.parseLong(context.getSharedPreferences(context.getPackageName() + "_widget-" + i, 0).getString("widget:update_frequency", "86400")));
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("widget_id", i);
        gj0.m4141b(f4384a, String.format("Scheduling an update to JuiceSSH widget %d every %d seconds", Integer.valueOf(i), valueOf));
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(i + 1259, new ComponentName(context, (Class<?>) WidgetUpdateJob.class)).setRequiredNetworkType(0).setPeriodic(valueOf.longValue() * 1000).setPersisted(true).setExtras(persistableBundle).build());
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        for (int i : iArr) {
            ((JobScheduler) context.getSystemService("jobscheduler")).cancel(i + 1259);
        }
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == null || !intent.getAction().equals(f4385b)) {
            super.onReceive(context, intent);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int i = extras.getInt("appWidgetId", 0);
            if (i != 0) {
                m5732b(context, i);
                return;
            }
            return;
        }
        for (int i2 : AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) ConnectionWidgetProvider.class))) {
            m5732b(context, i2);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        for (int i : iArr) {
            appWidgetManager.updateAppWidget(i, m5731a(context, i));
            m5732b(context, i);
        }
    }
}

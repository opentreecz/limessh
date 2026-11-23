package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.sonelli.AbstractC1138i0;
import com.sonelli.C1483l0;
import com.sonelli.C1486l3;
import com.sonelli.RunnableC1139i1;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public static /* synthetic */ void m752a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        C1483l0.m6034f(context);
        AbstractC1138i0.a m4681a = AbstractC1138i0.m4681a();
        m4681a.mo2327b(queryParameter);
        m4681a.mo2329d(C1486l3.m6047b(intValue));
        if (queryParameter2 != null) {
            m4681a.mo2328c(Base64.decode(queryParameter2, 0));
        }
        C1483l0.m6032c().m6036e().m8573g(m4681a.mo2326a(), i, RunnableC1139i1.m4705a());
    }
}

package com.sonelli;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.h1 */
/* loaded from: classes.dex */
public class C1089h1 implements WorkScheduler {

    /* renamed from: a */
    public final Context f3061a;

    /* renamed from: b */
    public final EventStore f3062b;

    /* renamed from: c */
    public AlarmManager f3063c;

    /* renamed from: d */
    public final AbstractC1583n1 f3064d;

    /* renamed from: e */
    public final Clock f3065e;

    @VisibleForTesting
    public C1089h1(Context context, EventStore eventStore, AlarmManager alarmManager, Clock clock, AbstractC1583n1 abstractC1583n1) {
        this.f3061a = context;
        this.f3062b = eventStore;
        this.f3063c = alarmManager;
        this.f3065e = clock;
        this.f3064d = abstractC1583n1;
    }

    public C1089h1(Context context, EventStore eventStore, Clock clock, AbstractC1583n1 abstractC1583n1) {
        this(context, eventStore, (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM), clock, abstractC1583n1);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    /* renamed from: a */
    public void mo754a(AbstractC1138i0 abstractC1138i0, int i) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", abstractC1138i0.mo2323b());
        builder.appendQueryParameter("priority", String.valueOf(C1486l3.m6046a(abstractC1138i0.mo2325d())));
        if (abstractC1138i0.mo2324c() != null) {
            builder.appendQueryParameter(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(abstractC1138i0.mo2324c(), 0));
        }
        Intent intent = new Intent(this.f3061a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (m4334b(intent)) {
            C2253x0.m9656a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", abstractC1138i0);
            return;
        }
        long mo756Q = this.f3062b.mo756Q(abstractC1138i0);
        long m6615f = this.f3064d.m6615f(abstractC1138i0.mo2325d(), mo756Q, i);
        C2253x0.m9657b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", abstractC1138i0, Long.valueOf(m6615f), Long.valueOf(mo756Q), Integer.valueOf(i));
        this.f3063c.set(3, this.f3065e.mo807a() + m6615f, PendingIntent.getBroadcast(this.f3061a, 0, intent, 0));
    }

    @VisibleForTesting
    /* renamed from: b */
    public boolean m4334b(Intent intent) {
        return PendingIntent.getBroadcast(this.f3061a, 0, intent, 536870912) != null;
    }
}

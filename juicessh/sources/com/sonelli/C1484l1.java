package com.sonelli;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
@RequiresApi(api = 21)
/* renamed from: com.sonelli.l1 */
/* loaded from: classes.dex */
public class C1484l1 implements WorkScheduler {

    /* renamed from: a */
    public final Context f4711a;

    /* renamed from: b */
    public final EventStore f4712b;

    /* renamed from: c */
    public final AbstractC1583n1 f4713c;

    public C1484l1(Context context, EventStore eventStore, AbstractC1583n1 abstractC1583n1) {
        this.f4711a = context;
        this.f4712b = eventStore;
        this.f4713c = abstractC1583n1;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    /* renamed from: a */
    public void mo754a(AbstractC1138i0 abstractC1138i0, int i) {
        ComponentName componentName = new ComponentName(this.f4711a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f4711a.getSystemService("jobscheduler");
        int m6040b = m6040b(abstractC1138i0);
        if (m6041c(jobScheduler, m6040b, i)) {
            C2253x0.m9656a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", abstractC1138i0);
            return;
        }
        long mo756Q = this.f4712b.mo756Q(abstractC1138i0);
        AbstractC1583n1 abstractC1583n1 = this.f4713c;
        JobInfo.Builder builder = new JobInfo.Builder(m6040b, componentName);
        abstractC1583n1.m6614b(builder, abstractC1138i0.mo2325d(), mo756Q, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", abstractC1138i0.mo2323b());
        persistableBundle.putInt("priority", C1486l3.m6046a(abstractC1138i0.mo2325d()));
        if (abstractC1138i0.mo2324c() != null) {
            persistableBundle.putString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(abstractC1138i0.mo2324c(), 0));
        }
        builder.setExtras(persistableBundle);
        C2253x0.m9657b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", abstractC1138i0, Integer.valueOf(m6040b), Long.valueOf(this.f4713c.m6615f(abstractC1138i0.mo2325d(), mo756Q, i)), Long.valueOf(mo756Q), Integer.valueOf(i));
        jobScheduler.schedule(builder.build());
    }

    @VisibleForTesting
    /* renamed from: b */
    public int m6040b(AbstractC1138i0 abstractC1138i0) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f4711a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(abstractC1138i0.mo2323b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(C1486l3.m6046a(abstractC1138i0.mo2325d())).array());
        if (abstractC1138i0.mo2324c() != null) {
            adler32.update(abstractC1138i0.mo2324c());
        }
        return (int) adler32.getValue();
    }

    /* renamed from: c */
    public final boolean m6041c(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }
}

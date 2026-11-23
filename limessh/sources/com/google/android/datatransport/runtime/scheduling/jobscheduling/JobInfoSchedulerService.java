package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import cz.opentree.AbstractC1138i0;
import cz.opentree.C1483l0;
import cz.opentree.C1486l3;
import cz.opentree.RunnableC1533m1;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
@RequiresApi(api = 21)
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        C1483l0.m6034f(getApplicationContext());
        AbstractC1138i0.a m4681a = AbstractC1138i0.m4681a();
        m4681a.mo2327b(string);
        m4681a.mo2329d(C1486l3.m6047b(i));
        if (string2 != null) {
            m4681a.mo2328c(Base64.decode(string2, 0));
        }
        C1483l0.m6032c().m6036e().m8573g(m4681a.mo2326a(), i2, RunnableC1533m1.m6337a(this, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

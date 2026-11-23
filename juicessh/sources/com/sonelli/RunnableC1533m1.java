package com.sonelli;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.m1 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1533m1 implements Runnable {

    /* renamed from: O */
    public final JobInfoSchedulerService f4948O;

    /* renamed from: P */
    public final JobParameters f4949P;

    public RunnableC1533m1(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f4948O = jobInfoSchedulerService;
        this.f4949P = jobParameters;
    }

    /* renamed from: a */
    public static Runnable m6337a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new RunnableC1533m1(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4948O.jobFinished(this.f4949P, false);
    }
}

package com.google.firebase.crashlytics.internal.report;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.sonelli.d90;
import com.sonelli.jc0;
import com.sonelli.m80;
import com.sonelli.s80;
import com.sonelli.sb0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class ReportUploader {

    /* renamed from: h */
    public static final short[] f1240h = {10, 20, 30, 60, 120, 300};

    /* renamed from: a */
    public final CreateReportSpiCall f1241a;

    /* renamed from: b */
    @Nullable
    public final String f1242b;

    /* renamed from: c */
    public final String f1243c;

    /* renamed from: d */
    public final d90 f1244d;

    /* renamed from: e */
    public final sb0 f1245e;

    /* renamed from: f */
    public final HandlingExceptionCheck f1246f;

    /* renamed from: g */
    public Thread f1247g;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface HandlingExceptionCheck {
        /* renamed from: a */
        boolean mo1721a();
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface Provider {
        /* renamed from: a */
        ReportUploader mo1733a(@NonNull jc0 jc0Var);
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface ReportFilesProvider {
        /* renamed from: a */
        File[] mo1736a();

        /* renamed from: b */
        File[] mo1737b();
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.report.ReportUploader$a */
    /* loaded from: classes.dex */
    public class C0662a extends s80 {

        /* renamed from: O */
        public final List<Report> f1248O;

        /* renamed from: P */
        public final boolean f1249P;

        /* renamed from: Q */
        public final float f1250Q;

        public C0662a(List<Report> list, boolean z, float f) {
            this.f1248O = list;
            this.f1249P = z;
            this.f1250Q = f;
        }

        @Override // com.sonelli.s80
        /* renamed from: a */
        public void mo1834a() {
            try {
                m1835b(this.f1248O, this.f1249P);
            } catch (Exception e) {
                m80.m6375f().m6380e("An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.f1247g = null;
        }

        /* renamed from: b */
        public final void m1835b(List<Report> list, boolean z) {
            m80.m6375f().m6377b("Starting report processing in " + this.f1250Q + " second(s)...");
            if (this.f1250Q > 0.0f) {
                try {
                    Thread.sleep(r0 * 1000.0f);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (ReportUploader.this.f1246f.mo1721a()) {
                return;
            }
            int i = 0;
            while (list.size() > 0 && !ReportUploader.this.f1246f.mo1721a()) {
                m80.m6375f().m6377b("Attempting to send " + list.size() + " report(s)");
                ArrayList arrayList = new ArrayList();
                for (Report report : list) {
                    if (!ReportUploader.this.m1832d(report, z)) {
                        arrayList.add(report);
                    }
                }
                if (arrayList.size() > 0) {
                    int i2 = i + 1;
                    long j = ReportUploader.f1240h[Math.min(i, ReportUploader.f1240h.length - 1)];
                    m80.m6375f().m6377b("Report submission: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                list = arrayList;
            }
        }
    }

    public ReportUploader(@Nullable String str, String str2, d90 d90Var, sb0 sb0Var, CreateReportSpiCall createReportSpiCall, HandlingExceptionCheck handlingExceptionCheck) {
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f1241a = createReportSpiCall;
        this.f1242b = str;
        this.f1243c = str2;
        this.f1244d = d90Var;
        this.f1245e = sb0Var;
        this.f1246f = handlingExceptionCheck;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0060 A[Catch: Exception -> 0x0067, TRY_LEAVE, TryCatch #0 {Exception -> 0x0067, blocks: (B:3:0x0001, B:5:0x0011, B:8:0x0060, B:14:0x001b, B:16:0x001f, B:18:0x0027, B:19:0x0032, B:22:0x004d), top: B:2:0x0001 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m1832d(com.google.firebase.crashlytics.internal.report.model.Report r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            com.sonelli.tb0 r1 = new com.sonelli.tb0     // Catch: java.lang.Exception -> L67
            java.lang.String r2 = r5.f1242b     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = r5.f1243c     // Catch: java.lang.Exception -> L67
            r1.<init>(r2, r3, r6)     // Catch: java.lang.Exception -> L67
            com.sonelli.d90 r2 = r5.f1244d     // Catch: java.lang.Exception -> L67
            com.sonelli.d90 r3 = com.sonelli.d90.ALL     // Catch: java.lang.Exception -> L67
            r4 = 1
            if (r2 != r3) goto L1b
            com.sonelli.m80 r7 = com.sonelli.m80.m6375f()     // Catch: java.lang.Exception -> L67
            java.lang.String r1 = "Send to Reports Endpoint disabled. Removing Reports Endpoint report."
            r7.m6377b(r1)     // Catch: java.lang.Exception -> L67
            goto L30
        L1b:
            com.sonelli.d90 r3 = com.sonelli.d90.JAVA_ONLY     // Catch: java.lang.Exception -> L67
            if (r2 != r3) goto L32
            com.google.firebase.crashlytics.internal.report.model.Report$a r2 = r6.getType()     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.internal.report.model.Report$a r3 = com.google.firebase.crashlytics.internal.report.model.Report.EnumC0663a.JAVA     // Catch: java.lang.Exception -> L67
            if (r2 != r3) goto L32
            com.sonelli.m80 r7 = com.sonelli.m80.m6375f()     // Catch: java.lang.Exception -> L67
            java.lang.String r1 = "Send to Reports Endpoint for non-native reports disabled. Removing Reports Uploader report."
            r7.m6377b(r1)     // Catch: java.lang.Exception -> L67
        L30:
            r7 = r4
            goto L5e
        L32:
            com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall r2 = r5.f1241a     // Catch: java.lang.Exception -> L67
            boolean r7 = r2.mo1841b(r1, r7)     // Catch: java.lang.Exception -> L67
            com.sonelli.m80 r1 = com.sonelli.m80.m6375f()     // Catch: java.lang.Exception -> L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L67
            r2.<init>()     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = "Crashlytics Reports Endpoint upload "
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            if (r7 == 0) goto L4b
            java.lang.String r3 = "complete: "
            goto L4d
        L4b:
            java.lang.String r3 = "FAILED: "
        L4d:
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = r6.mo1837b()     // Catch: java.lang.Exception -> L67
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L67
            r1.m6381g(r2)     // Catch: java.lang.Exception -> L67
        L5e:
            if (r7 == 0) goto L80
            com.sonelli.sb0 r7 = r5.f1245e     // Catch: java.lang.Exception -> L67
            r7.m8421b(r6)     // Catch: java.lang.Exception -> L67
            r0 = r4
            goto L80
        L67:
            r7 = move-exception
            com.sonelli.m80 r1 = com.sonelli.m80.m6375f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error occurred sending report "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r1.m6380e(r6, r7)
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.ReportUploader.m1832d(com.google.firebase.crashlytics.internal.report.model.Report, boolean):boolean");
    }

    /* renamed from: e */
    public synchronized void m1833e(List<Report> list, boolean z, float f) {
        if (this.f1247g != null) {
            m80.m6375f().m6377b("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new C0662a(list, z, f), "Crashlytics Report Uploader");
        this.f1247g = thread;
        thread.start();
    }
}

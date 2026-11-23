package com.sonelli;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents;
import com.google.firebase.crashlytics.internal.common.NativeSessionFile;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.sonelli.oa0;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class o90 implements CrashlyticsLifecycleEvents {

    /* renamed from: a */
    public final a90 f5459a;

    /* renamed from: b */
    public final lb0 f5460b;

    /* renamed from: c */
    public final bc0 f5461c;

    /* renamed from: d */
    public final LogFileManager f5462d;

    /* renamed from: e */
    public final q90 f5463e;

    /* renamed from: f */
    @Nullable
    public String f5464f;

    public o90(a90 a90Var, lb0 lb0Var, bc0 bc0Var, LogFileManager logFileManager, q90 q90Var) {
        this.f5459a = a90Var;
        this.f5460b = lb0Var;
        this.f5461c = bc0Var;
        this.f5462d = logFileManager;
        this.f5463e = q90Var;
    }

    /* renamed from: b */
    public static o90 m6900b(Context context, h90 h90Var, FileStore fileStore, q80 q80Var, LogFileManager logFileManager, q90 q90Var, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsDataProvider settingsDataProvider) {
        return new o90(new a90(context, h90Var, q80Var, stackTraceTrimmingStrategy), new lb0(new File(fileStore.mo1827a()), settingsDataProvider), bc0.m2428a(context), logFileManager, q90Var);
    }

    @NonNull
    /* renamed from: e */
    public static List<oa0.AbstractC1643b> m6901e(@NonNull Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            oa0.AbstractC1643b.a m6936a = oa0.AbstractC1643b.m6936a();
            m6936a.mo6940b(entry.getKey());
            m6936a.mo6941c(entry.getValue());
            arrayList.add(m6936a.mo6939a());
        }
        Collections.sort(arrayList, n90.m6653a());
        return arrayList;
    }

    /* renamed from: c */
    public void m6903c(@NonNull String str, @NonNull List<NativeSessionFile> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<NativeSessionFile> it = list.iterator();
        while (it.hasNext()) {
            oa0.AbstractC1644c.b mo1743c = it.next().mo1743c();
            if (mo1743c != null) {
                arrayList.add(mo1743c);
            }
        }
        lb0 lb0Var = this.f5460b;
        oa0.AbstractC1644c.a m6942a = oa0.AbstractC1644c.m6942a();
        m6942a.mo6946b(pa0.m7255e(arrayList));
        lb0Var.m6137k(str, m6942a.mo6945a());
    }

    /* renamed from: d */
    public void m6904d(long j) {
        this.f5460b.m6136j(this.f5464f, j);
    }

    /* renamed from: g */
    public void m6905g(@NonNull String str, long j) {
        this.f5464f = str;
        this.f5460b.m6130C(this.f5459a.m2010c(str, j));
    }

    /* renamed from: h */
    public void m6906h() {
        this.f5464f = null;
    }

    /* renamed from: i */
    public final boolean m6907i(@NonNull j60<b90> j60Var) {
        if (!j60Var.mo2701n()) {
            m80.m6375f().m6378c("Crashlytics report could not be enqueued to DataTransport", j60Var.mo2696i());
            return false;
        }
        b90 mo2697j = j60Var.mo2697j();
        m80.m6375f().m6377b("Crashlytics report successfully enqueued to DataTransport: " + mo2697j.mo2403c());
        this.f5460b.m6135i(mo2697j.mo2403c());
        return true;
    }

    /* renamed from: j */
    public final void m6908j(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j, boolean z) {
        String str2 = this.f5464f;
        if (str2 == null) {
            m80.m6375f().m6377b("Cannot persist event, no currently open session");
            return;
        }
        boolean equals = str.equals("crash");
        oa0.AbstractC1645d.d m2009b = this.f5459a.m2009b(th, thread, str, j, 4, 8, z);
        oa0.AbstractC1645d.d.b mo2740g = m2009b.mo2740g();
        String m1752d = this.f5462d.m1752d();
        if (m1752d != null) {
            oa0.AbstractC1645d.d.AbstractC2512d.a m7006a = oa0.AbstractC1645d.d.AbstractC2512d.m7006a();
            m7006a.mo6102b(m1752d);
            mo2740g.mo2744d(m7006a.mo6101a());
        } else {
            m80.m6375f().m6377b("No log data to include with this event.");
        }
        List<oa0.AbstractC1643b> m6901e = m6901e(this.f5463e.m7639a());
        if (!m6901e.isEmpty()) {
            oa0.AbstractC1645d.d.a.AbstractC2502a mo3175f = m2009b.mo2735b().mo3175f();
            mo3175f.mo3178c(pa0.m7255e(m6901e));
            mo2740g.mo2742b(mo3175f.mo3176a());
        }
        this.f5460b.m6129B(mo2740g.mo2741a(), str2, equals);
    }

    /* renamed from: k */
    public void m6909k(@NonNull Throwable th, @NonNull Thread thread, long j) {
        m6908j(th, thread, "crash", j, true);
    }

    /* renamed from: l */
    public void m6910l() {
        this.f5460b.m6134h();
    }

    /* renamed from: m */
    public void m6911m(@NonNull Executor executor, @NonNull d90 d90Var) {
        if (d90Var == d90.NONE) {
            m80.m6375f().m6377b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f5460b.m6134h();
            return;
        }
        for (b90 b90Var : this.f5460b.m6140y()) {
            if (b90Var.mo2402b().m6922k() != oa0.EnumC1646e.NATIVE || d90Var == d90.ALL) {
                this.f5461c.m2432e(b90Var).mo2694g(executor, m90.m6385b(this));
            } else {
                m80.m6375f().m6377b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f5460b.m6135i(b90Var.mo2403c());
            }
        }
    }
}

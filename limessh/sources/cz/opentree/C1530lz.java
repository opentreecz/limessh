package cz.opentree;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.lz */
/* loaded from: classes.dex */
public final class C1530lz {

    /* renamed from: a */
    public final String f4935a;

    /* renamed from: b */
    public final String f4936b;

    /* renamed from: c */
    public final String f4937c;

    /* renamed from: d */
    public final long f4938d;

    /* renamed from: e */
    public final /* synthetic */ C0960ez f4939e;

    public C1530lz(C0960ez c0960ez, String str, long j) {
        this.f4939e = c0960ez;
        C0813ca.m2725g(str);
        C0813ca.m2719a(j > 0);
        this.f4935a = String.valueOf(str).concat(":start");
        this.f4936b = String.valueOf(str).concat(":count");
        this.f4937c = String.valueOf(str).concat(":value");
        this.f4938d = j;
    }

    @WorkerThread
    /* renamed from: a */
    public final Pair<String, Long> m6322a() {
        long abs;
        this.f4939e.mo7585d();
        this.f4939e.mo7585d();
        long m6325d = m6325d();
        if (m6325d == 0) {
            m6324c();
            abs = 0;
        } else {
            abs = Math.abs(m6325d - this.f4939e.mo1483i().mo1177a());
        }
        long j = this.f4938d;
        if (abs < j) {
            return null;
        }
        if (abs > (j << 1)) {
            m6324c();
            return null;
        }
        String string = this.f4939e.m3588D().getString(this.f4937c, null);
        long j2 = this.f4939e.m3588D().getLong(this.f4936b, 0L);
        m6324c();
        return (string == null || j2 <= 0) ? C0960ez.f2553E : new Pair<>(string, Long.valueOf(j2));
    }

    @WorkerThread
    /* renamed from: b */
    public final void m6323b(String str, long j) {
        this.f4939e.mo7585d();
        if (m6325d() == 0) {
            m6324c();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f4939e.m3588D().getLong(this.f4936b, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.f4939e.m3588D().edit();
            edit.putString(this.f4937c, str);
            edit.putLong(this.f4936b, 1L);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.f4939e.m7588m().m4018G0().nextLong() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j3;
        SharedPreferences.Editor edit2 = this.f4939e.m3588D().edit();
        if (z) {
            edit2.putString(this.f4937c, str);
        }
        edit2.putLong(this.f4936b, j3);
        edit2.apply();
    }

    @WorkerThread
    /* renamed from: c */
    public final void m6324c() {
        this.f4939e.mo7585d();
        long mo1177a = this.f4939e.mo1483i().mo1177a();
        SharedPreferences.Editor edit = this.f4939e.m3588D().edit();
        edit.remove(this.f4936b);
        edit.remove(this.f4937c);
        edit.putLong(this.f4935a, mo1177a);
        edit.apply();
    }

    @WorkerThread
    /* renamed from: d */
    public final long m6325d() {
        return this.f4939e.m3588D().getLong(this.f4935a, 0L);
    }
}

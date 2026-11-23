package cz.opentree;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import java.util.UUID;

/* renamed from: cz.opentree.qh */
/* loaded from: classes.dex */
public final class C1763qh {

    /* renamed from: a */
    public final String f5996a;

    /* renamed from: b */
    public final long f5997b;

    /* renamed from: c */
    public final /* synthetic */ C1654oh f5998c;

    public C1763qh(C1654oh c1654oh, String str, long j) {
        this.f5998c = c1654oh;
        C0813ca.m2725g(str);
        C0813ca.m2719a(j > 0);
        this.f5996a = str;
        this.f5997b = j;
    }

    /* renamed from: a */
    public final void m7703a(String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        SharedPreferences sharedPreferences3;
        if (m7706d() == 0) {
            m7704b();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            sharedPreferences = this.f5998c.f5482Q;
            long j = sharedPreferences.getLong(m7708f(), 0L);
            if (j <= 0) {
                sharedPreferences3 = this.f5998c.f5482Q;
                SharedPreferences.Editor edit = sharedPreferences3.edit();
                edit.putString(m7709g(), str);
                edit.putLong(m7708f(), 1L);
                edit.apply();
                return;
            }
            long j2 = j + 1;
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j2;
            sharedPreferences2 = this.f5998c.f5482Q;
            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
            if (z) {
                edit2.putString(m7709g(), str);
            }
            edit2.putLong(m7708f(), j2);
            edit2.apply();
        }
    }

    /* renamed from: b */
    public final void m7704b() {
        SharedPreferences sharedPreferences;
        long mo1177a = this.f5998c.m8659g0().mo1177a();
        sharedPreferences = this.f5998c.f5482Q;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(m7708f());
        edit.remove(m7709g());
        edit.putLong(m7707e(), mo1177a);
        edit.commit();
    }

    /* renamed from: c */
    public final Pair<String, Long> m7705c() {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        long m7706d = m7706d();
        long abs = m7706d == 0 ? 0L : Math.abs(m7706d - this.f5998c.m8659g0().mo1177a());
        long j = this.f5997b;
        if (abs < j) {
            return null;
        }
        if (abs > (j << 1)) {
            m7704b();
            return null;
        }
        sharedPreferences = this.f5998c.f5482Q;
        String string = sharedPreferences.getString(m7709g(), null);
        sharedPreferences2 = this.f5998c.f5482Q;
        long j2 = sharedPreferences2.getLong(m7708f(), 0L);
        m7704b();
        if (string == null || j2 <= 0) {
            return null;
        }
        return new Pair<>(string, Long.valueOf(j2));
    }

    /* renamed from: d */
    public final long m7706d() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.f5998c.f5482Q;
        return sharedPreferences.getLong(m7707e(), 0L);
    }

    /* renamed from: e */
    public final String m7707e() {
        return String.valueOf(this.f5996a).concat(":start");
    }

    /* renamed from: f */
    public final String m7708f() {
        return String.valueOf(this.f5996a).concat(":count");
    }

    /* renamed from: g */
    public final String m7709g() {
        return String.valueOf(this.f5996a).concat(":value");
    }
}

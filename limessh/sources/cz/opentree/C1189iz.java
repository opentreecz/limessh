package cz.opentree;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.iz */
/* loaded from: classes.dex */
public final class C1189iz {

    /* renamed from: a */
    public final String f3450a;

    /* renamed from: b */
    public final long f3451b;

    /* renamed from: c */
    public boolean f3452c;

    /* renamed from: d */
    public long f3453d;

    /* renamed from: e */
    public final /* synthetic */ C0960ez f3454e;

    public C1189iz(C0960ez c0960ez, String str, long j) {
        this.f3454e = c0960ez;
        C0813ca.m2725g(str);
        this.f3450a = str;
        this.f3451b = j;
    }

    @WorkerThread
    /* renamed from: a */
    public final long m4968a() {
        if (!this.f3452c) {
            this.f3452c = true;
            this.f3453d = this.f3454e.m3588D().getLong(this.f3450a, this.f3451b);
        }
        return this.f3453d;
    }

    @WorkerThread
    /* renamed from: b */
    public final void m4969b(long j) {
        SharedPreferences.Editor edit = this.f3454e.m3588D().edit();
        edit.putLong(this.f3450a, j);
        edit.apply();
        this.f3453d = j;
    }
}

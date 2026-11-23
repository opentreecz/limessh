package cz.opentree;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.kz */
/* loaded from: classes.dex */
public final class C1480kz {

    /* renamed from: a */
    public final String f4681a;

    /* renamed from: b */
    public boolean f4682b;

    /* renamed from: c */
    public String f4683c;

    /* renamed from: d */
    public final /* synthetic */ C0960ez f4684d;

    public C1480kz(C0960ez c0960ez, String str, String str2) {
        this.f4684d = c0960ez;
        C0813ca.m2725g(str);
        this.f4681a = str;
    }

    @WorkerThread
    /* renamed from: a */
    public final String m6012a() {
        if (!this.f4682b) {
            this.f4682b = true;
            this.f4683c = this.f4684d.m3588D().getString(this.f4681a, null);
        }
        return this.f4683c;
    }

    @WorkerThread
    /* renamed from: b */
    public final void m6013b(String str) {
        if (this.f4684d.m7590o().m2630u(C1735pu.f5874z0) || !g40.m4008z0(str, this.f4683c)) {
            SharedPreferences.Editor edit = this.f4684d.m3588D().edit();
            edit.putString(this.f4681a, str);
            edit.apply();
            this.f4683c = str;
        }
    }
}

package cz.opentree;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.gz */
/* loaded from: classes.dex */
public final class C1085gz {

    /* renamed from: a */
    public final String f3032a;

    /* renamed from: b */
    public final boolean f3033b;

    /* renamed from: c */
    public boolean f3034c;

    /* renamed from: d */
    public boolean f3035d;

    /* renamed from: e */
    public final /* synthetic */ C0960ez f3036e;

    public C1085gz(C0960ez c0960ez, String str, boolean z) {
        this.f3036e = c0960ez;
        C0813ca.m2725g(str);
        this.f3032a = str;
        this.f3033b = z;
    }

    @WorkerThread
    /* renamed from: a */
    public final void m4291a(boolean z) {
        SharedPreferences.Editor edit = this.f3036e.m3588D().edit();
        edit.putBoolean(this.f3032a, z);
        edit.apply();
        this.f3035d = z;
    }

    @WorkerThread
    /* renamed from: b */
    public final boolean m4292b() {
        if (!this.f3034c) {
            this.f3034c = true;
            this.f3035d = this.f3036e.m3588D().getBoolean(this.f3032a, this.f3033b);
        }
        return this.f3035d;
    }
}

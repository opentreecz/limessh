package com.sonelli;

import com.google.android.gms.tagmanager.zzby;
import com.google.android.gms.tagmanager.zzcb;

/* loaded from: classes.dex */
public final class z50 extends y50 {

    /* renamed from: d */
    public static z50 f8456d;

    /* renamed from: a */
    public zzcb f8457a;

    /* renamed from: b */
    public volatile zzby f8458b;

    /* renamed from: c */
    public boolean f8459c = false;

    /* renamed from: c */
    public static z50 m10394c() {
        if (f8456d == null) {
            f8456d = new z50();
        }
        return f8456d;
    }

    @Override // com.sonelli.y50
    /* renamed from: a */
    public final synchronized void mo10089a() {
        if (this.f8459c) {
            this.f8458b.m1541a(new a60(this));
        } else {
            v50.m9166a("Dispatch call queued. Dispatch will run once initialization is complete.");
        }
    }
}

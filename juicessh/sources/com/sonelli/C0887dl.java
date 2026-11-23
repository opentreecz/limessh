package com.sonelli;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.dl */
/* loaded from: classes.dex */
public final class C0887dl extends ContentObserver {

    /* renamed from: a */
    public final /* synthetic */ C0782bl f2231a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0887dl(C0782bl c0782bl, Handler handler) {
        super(null);
        this.f2231a = c0782bl;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f2231a.m2554c();
    }
}

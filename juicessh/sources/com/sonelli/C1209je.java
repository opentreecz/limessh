package com.sonelli;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.sonelli.je */
/* loaded from: classes.dex */
public class C1209je implements IInterface {

    /* renamed from: a */
    public final IBinder f3548a;

    public C1209je(IBinder iBinder, String str) {
        this.f3548a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3548a;
    }
}

package com.sonelli;

import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class de0 extends HandlerC1158if {

    /* renamed from: a */
    public final /* synthetic */ be0 f2159a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de0(be0 be0Var, Looper looper) {
        super(looper);
        this.f2159a = be0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f2159a.m2453d(message);
    }
}

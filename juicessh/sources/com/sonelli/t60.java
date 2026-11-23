package com.sonelli;

import com.google.android.gms.tasks.OnCompleteListener;

/* loaded from: classes.dex */
public final class t60 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ j60 f6714O;

    /* renamed from: P */
    public final /* synthetic */ s60 f6715P;

    public t60(s60 s60Var, j60 j60Var) {
        this.f6715P = s60Var;
        this.f6714O = j60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCompleteListener onCompleteListener;
        OnCompleteListener onCompleteListener2;
        obj = this.f6715P.f6357b;
        synchronized (obj) {
            onCompleteListener = this.f6715P.f6358c;
            if (onCompleteListener != null) {
                onCompleteListener2 = this.f6715P.f6358c;
                onCompleteListener2.mo1554a(this.f6714O);
            }
        }
    }
}

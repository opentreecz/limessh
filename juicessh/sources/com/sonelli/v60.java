package com.sonelli;

import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: classes.dex */
public final class v60 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ j60 f7410O;

    /* renamed from: P */
    public final /* synthetic */ u60 f7411P;

    public v60(u60 u60Var, j60 j60Var) {
        this.f7411P = u60Var;
        this.f7410O = j60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.f7411P.f6922b;
        synchronized (obj) {
            onFailureListener = this.f7411P.f6923c;
            if (onFailureListener != null) {
                onFailureListener2 = this.f7411P.f6923c;
                onFailureListener2.mo1555d(this.f7410O.mo2696i());
            }
        }
    }
}

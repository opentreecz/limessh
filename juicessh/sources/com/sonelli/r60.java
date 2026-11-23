package com.sonelli;

import com.google.android.gms.tasks.OnCanceledListener;

/* loaded from: classes.dex */
public final class r60 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ q60 f6187O;

    public r60(q60 q60Var) {
        this.f6187O = q60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCanceledListener onCanceledListener;
        OnCanceledListener onCanceledListener2;
        obj = this.f6187O.f5944b;
        synchronized (obj) {
            onCanceledListener = this.f6187O.f5945c;
            if (onCanceledListener != null) {
                onCanceledListener2 = this.f6187O.f5945c;
                onCanceledListener2.mo1553c();
            }
        }
    }
}

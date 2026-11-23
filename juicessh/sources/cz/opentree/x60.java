package cz.opentree;

import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: classes.dex */
public final class x60 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ j60 f7890O;

    /* renamed from: P */
    public final /* synthetic */ w60 f7891P;

    public x60(w60 w60Var, j60 j60Var) {
        this.f7891P = w60Var;
        this.f7890O = j60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.f7891P.f7624b;
        synchronized (obj) {
            onSuccessListener = this.f7891P.f7625c;
            if (onSuccessListener != null) {
                onSuccessListener2 = this.f7891P.f7625c;
                onSuccessListener2.mo1556b(this.f7890O.mo2697j());
            }
        }
    }
}

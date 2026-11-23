package cz.opentree;

import com.google.android.gms.tasks.Continuation;

/* loaded from: classes.dex */
public final class n60 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ j60 f5236O;

    /* renamed from: P */
    public final /* synthetic */ m60 f5237P;

    public n60(m60 m60Var, j60 j60Var) {
        this.f5237P = m60Var;
        this.f5236O = j60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c70 c70Var;
        c70 c70Var2;
        c70 c70Var3;
        Continuation continuation;
        c70 c70Var4;
        c70 c70Var5;
        if (this.f5236O.mo2699l()) {
            c70Var5 = this.f5237P.f4994c;
            c70Var5.m2708u();
            return;
        }
        try {
            continuation = this.f5237P.f4993b;
            Object mo1552a = continuation.mo1552a(this.f5236O);
            c70Var4 = this.f5237P.f4994c;
            c70Var4.m2705r(mo1552a);
        } catch (i60 e) {
            if (e.getCause() instanceof Exception) {
                c70Var3 = this.f5237P.f4994c;
                c70Var3.m2704q((Exception) e.getCause());
            } else {
                c70Var2 = this.f5237P.f4994c;
                c70Var2.m2704q(e);
            }
        } catch (Exception e2) {
            c70Var = this.f5237P.f4994c;
            c70Var.m2704q(e2);
        }
    }
}

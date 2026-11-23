package cz.opentree;

import com.google.android.gms.tasks.Continuation;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class p60 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ j60 f5631O;

    /* renamed from: P */
    public final /* synthetic */ o60 f5632P;

    public p60(o60 o60Var, j60 j60Var) {
        this.f5632P = o60Var;
        this.f5631O = j60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c70 c70Var;
        c70 c70Var2;
        c70 c70Var3;
        Continuation continuation;
        try {
            continuation = this.f5632P.f5437b;
            j60 j60Var = (j60) continuation.mo1552a(this.f5631O);
            if (j60Var == null) {
                this.f5632P.mo1555d(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = l60.f4755b;
            j60Var.mo2692e(executor, this.f5632P);
            j60Var.mo2691d(executor, this.f5632P);
            j60Var.mo2688a(executor, this.f5632P);
        } catch (i60 e) {
            if (e.getCause() instanceof Exception) {
                c70Var3 = this.f5632P.f5438c;
                c70Var3.m2704q((Exception) e.getCause());
            } else {
                c70Var2 = this.f5632P.f5438c;
                c70Var2.m2704q(e);
            }
        } catch (Exception e2) {
            c70Var = this.f5632P.f5438c;
            c70Var.m2704q(e2);
        }
    }
}

package cz.opentree;

import com.google.android.gms.tasks.SuccessContinuation;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class z60 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ j60 f8460O;

    /* renamed from: P */
    public final /* synthetic */ y60 f8461P;

    public z60(y60 y60Var, j60 j60Var) {
        this.f8461P = y60Var;
        this.f8460O = j60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.f8461P.f8144b;
            j60 mo1557a = successContinuation.mo1557a(this.f8460O.mo2697j());
            if (mo1557a == null) {
                this.f8461P.mo1555d(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = l60.f4755b;
            mo1557a.mo2692e(executor, this.f8461P);
            mo1557a.mo2691d(executor, this.f8461P);
            mo1557a.mo2688a(executor, this.f8461P);
        } catch (i60 e) {
            if (e.getCause() instanceof Exception) {
                this.f8461P.mo1555d((Exception) e.getCause());
            } else {
                this.f8461P.mo1555d(e);
            }
        } catch (CancellationException unused) {
            this.f8461P.mo1553c();
        } catch (Exception e2) {
            this.f8461P.mo1555d(e2);
        }
    }
}

package cz.opentree;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class s60<TResult> implements zzq<TResult> {

    /* renamed from: a */
    public final Executor f6356a;

    /* renamed from: b */
    public final Object f6357b = new Object();

    /* renamed from: c */
    @GuardedBy("mLock")
    public OnCompleteListener<TResult> f6358c;

    public s60(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f6356a = executor;
        this.f6358c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    /* renamed from: a */
    public final void mo1567a(@NonNull j60<TResult> j60Var) {
        synchronized (this.f6357b) {
            if (this.f6358c == null) {
                return;
            }
            this.f6356a.execute(new t60(this, j60Var));
        }
    }
}

package cz.opentree;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class w60<TResult> implements zzq<TResult> {

    /* renamed from: a */
    public final Executor f7623a;

    /* renamed from: b */
    public final Object f7624b = new Object();

    /* renamed from: c */
    @GuardedBy("mLock")
    public OnSuccessListener<? super TResult> f7625c;

    public w60(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.f7623a = executor;
        this.f7625c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    /* renamed from: a */
    public final void mo1567a(@NonNull j60<TResult> j60Var) {
        if (j60Var.mo2701n()) {
            synchronized (this.f7624b) {
                if (this.f7625c == null) {
                    return;
                }
                this.f7623a.execute(new x60(this, j60Var));
            }
        }
    }
}

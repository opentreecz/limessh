package cz.opentree;

import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.iid.zzav;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class ae0 {

    /* renamed from: a */
    public final Executor f1370a;

    /* renamed from: b */
    @GuardedBy("this")
    public final Map<Pair<String, String>, j60<InstanceIdResult>> f1371b = new ArrayMap();

    public ae0(Executor executor) {
        this.f1370a = executor;
    }

    /* renamed from: a */
    public final /* synthetic */ j60 m2046a(Pair pair, j60 j60Var) throws Exception {
        synchronized (this) {
            this.f1371b.remove(pair);
        }
        return j60Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final synchronized j60<InstanceIdResult> m2047b(String str, String str2, zzav zzavVar) {
        final Pair pair = new Pair(str, str2);
        j60<InstanceIdResult> j60Var = this.f1371b.get(pair);
        if (j60Var != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return j60Var;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        j60 mo2695h = zzavVar.mo1902a().mo2695h(this.f1370a, new Continuation(this, pair) { // from class: cz.opentree.zd0

            /* renamed from: a */
            public final ae0 f8491a;

            /* renamed from: b */
            public final Pair f8492b;

            {
                this.f8491a = this;
                this.f8492b = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public final Object mo1552a(j60 j60Var2) {
                this.f8491a.m2046a(this.f8492b, j60Var2);
                return j60Var2;
            }
        });
        this.f1371b.put(pair, mo2695h);
        return mo2695h;
    }
}

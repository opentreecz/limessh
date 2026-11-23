package cz.opentree;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzb;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class hd0 implements zzb {

    /* renamed from: c */
    public static final Object f3135c = new Object();

    /* renamed from: d */
    @GuardedBy("lock")
    public static me0 f3136d;

    /* renamed from: a */
    public final Context f3137a;

    /* renamed from: b */
    public final ExecutorService f3138b;

    public hd0(Context context, ExecutorService executorService) {
        this.f3137a = context;
        this.f3138b = executorService;
    }

    /* renamed from: b */
    public static final /* synthetic */ j60 m4435b(Context context, Intent intent, j60 j60Var) throws Exception {
        return (C1501lc.m6150j() && ((Integer) j60Var.mo2697j()).intValue() == 402) ? m4439f(context, intent).mo2694g(ue0.m8874a(), re0.f6204a) : j60Var;
    }

    /* renamed from: c */
    public static me0 m4436c(Context context, String str) {
        me0 me0Var;
        synchronized (f3135c) {
            if (f3136d == null) {
                f3136d = new me0(context, str);
            }
            me0Var = f3136d;
        }
        return me0Var;
    }

    /* renamed from: e */
    public static final /* synthetic */ Integer m4438e(j60 j60Var) throws Exception {
        return -1;
    }

    /* renamed from: f */
    public static j60<Integer> m4439f(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        return m4436c(context, "com.google.firebase.MESSAGING_EVENT").m6404a(intent).mo2694g(ue0.m8874a(), se0.f6433a);
    }

    /* renamed from: g */
    public static final /* synthetic */ Integer m4440g(j60 j60Var) throws Exception {
        return 403;
    }

    @Override // com.google.firebase.iid.zzb
    /* renamed from: a */
    public final j60<Integer> mo1903a(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = this.f3137a;
        return (!(C1501lc.m6150j() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? Tasks.m1560c(this.f3138b, new Callable(context, intent) { // from class: cz.opentree.qe0

            /* renamed from: a */
            public final Context f5975a;

            /* renamed from: b */
            public final Intent f5976b;

            {
                this.f5975a = context;
                this.f5976b = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer valueOf;
                valueOf = Integer.valueOf(ce0.m2778b().m2779a(this.f5975a, this.f5976b));
                return valueOf;
            }
        }).mo2695h(this.f3138b, new Continuation(context, intent) { // from class: cz.opentree.pe0

            /* renamed from: a */
            public final Context f5655a;

            /* renamed from: b */
            public final Intent f5656b;

            {
                this.f5655a = context;
                this.f5656b = intent;
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public final Object mo1552a(j60 j60Var) {
                return hd0.m4435b(this.f5655a, this.f5656b, j60Var);
            }
        }) : m4439f(context, intent);
    }
}

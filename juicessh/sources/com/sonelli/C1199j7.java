package com.sonelli;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.sonelli.C1848s7;
import com.sonelli.C1850s9;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.j7 */
/* loaded from: classes.dex */
public class C1199j7<O extends Api.ApiOptions> implements HasApiKey<O> {

    /* renamed from: a */
    public final Context f3499a;

    /* renamed from: b */
    public final Api<O> f3500b;

    /* renamed from: c */
    public final O f3501c;

    /* renamed from: d */
    public final C1750q7<O> f3502d;

    /* renamed from: e */
    public final Looper f3503e;

    /* renamed from: f */
    public final int f3504f;

    /* renamed from: g */
    public final GoogleApiClient f3505g;

    /* renamed from: h */
    public final StatusExceptionMapper f3506h;

    /* renamed from: i */
    public final C1848s7 f3507i;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.sonelli.j7$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final StatusExceptionMapper f3508a;

        /* renamed from: b */
        public final Looper f3509b;

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* renamed from: com.sonelli.j7$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C2490a {

            /* renamed from: a */
            public StatusExceptionMapper f3510a;

            /* renamed from: b */
            public Looper f3511b;

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: a */
            public a m5081a() {
                if (this.f3510a == null) {
                    this.f3510a = new C1692p7();
                }
                if (this.f3511b == null) {
                    this.f3511b = Looper.getMainLooper();
                }
                return new a(this.f3510a, this.f3511b);
            }

            /* renamed from: b */
            public C2490a m5082b(StatusExceptionMapper statusExceptionMapper) {
                C0813ca.m2730l(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.f3510a = statusExceptionMapper;
                return this;
            }
        }

        static {
            new C2490a().m5081a();
        }

        public a(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.f3508a = statusExceptionMapper;
            this.f3509b = looper;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1199j7(@androidx.annotation.NonNull android.content.Context r2, com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.Nullable O r4, com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.sonelli.j7$a$a r0 = new com.sonelli.j7$a$a
            r0.<init>()
            r0.m5082b(r5)
            com.sonelli.j7$a r5 = r0.m5081a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1199j7.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    public C1199j7(@NonNull Context context, Api<O> api, @Nullable O o, a aVar) {
        C0813ca.m2730l(context, "Null context is not permitted.");
        C0813ca.m2730l(api, "Api must not be null.");
        C0813ca.m2730l(aVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.f3499a = applicationContext;
        this.f3500b = api;
        this.f3501c = o;
        this.f3503e = aVar.f3509b;
        this.f3502d = C1750q7.m7629b(api, o);
        this.f3505g = new C1438k8(this);
        C1848s7 m8340g = C1848s7.m8340g(applicationContext);
        this.f3507i = m8340g;
        this.f3504f = m8340g.m8355i();
        this.f3506h = aVar.f3508a;
        m8340g.m8352d(this);
    }

    /* renamed from: a */
    public GoogleApiClient m5069a() {
        return this.f3505g;
    }

    /* renamed from: b */
    public C1850s9.a m5070b() {
        Account m963p;
        GoogleSignInAccount m964h;
        GoogleSignInAccount m964h2;
        C1850s9.a aVar = new C1850s9.a();
        O o = this.f3501c;
        if (!(o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (m964h2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).m964h()) == null) {
            O o2 = this.f3501c;
            m963p = o2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o2).m963p() : null;
        } else {
            m963p = m964h2.m903p();
        }
        aVar.m8413c(m963p);
        O o3 = this.f3501c;
        aVar.m8411a((!(o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (m964h = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).m964h()) == null) ? Collections.emptySet() : m964h.m897d0());
        aVar.m8414d(this.f3499a.getClass().getName());
        aVar.m8415e(this.f3499a.getPackageName());
        return aVar;
    }

    /* renamed from: c */
    public <A extends Api.AnyClient, T extends AbstractC1802r7<? extends Result, A>> T m5071c(@NonNull T t) {
        m5079k(0, t);
        return t;
    }

    /* renamed from: d */
    public <A extends Api.AnyClient, T extends AbstractC1802r7<? extends Result, A>> T m5072d(@NonNull T t) {
        m5079k(1, t);
        return t;
    }

    /* renamed from: e */
    public C1750q7<O> m5073e() {
        return this.f3502d;
    }

    /* renamed from: f */
    public O m5074f() {
        return this.f3501c;
    }

    /* renamed from: g */
    public Context m5075g() {
        return this.f3499a;
    }

    /* renamed from: h */
    public final int m5076h() {
        return this.f3504f;
    }

    /* renamed from: i */
    public Looper m5077i() {
        return this.f3503e;
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.common.api.Api$Client] */
    @WorkerThread
    /* renamed from: j */
    public Api.Client m5078j(Looper looper, C1848s7.a<O> aVar) {
        return this.f3500b.m962c().mo979a(this.f3499a, looper, m5070b().m8412b(), this.f3501c, aVar, aVar);
    }

    /* renamed from: k */
    public final <A extends Api.AnyClient, T extends AbstractC1802r7<? extends Result, A>> T m5079k(int i, @NonNull T t) {
        t.m1016m();
        this.f3507i.m8353e(this, i, t);
        return t;
    }

    /* renamed from: l */
    public BinderC1751q8 m5080l(Context context, Handler handler) {
        return new BinderC1751q8(context, handler, m5070b().m8412b());
    }
}

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import cz.opentree.C0813ca;
import cz.opentree.C1850s9;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class Api<O extends ApiOptions> {

    /* renamed from: a */
    public final AbstractC0426a<?, O> f720a;

    /* renamed from: b */
    public final C0429d<?> f721b;

    /* renamed from: c */
    public final String f722c;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface AnyClient {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface ApiOptions {

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* loaded from: classes.dex */
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            /* renamed from: p */
            Account m963p();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* loaded from: classes.dex */
        public interface HasGoogleSignInAccountOptions extends HasOptions {
            /* renamed from: h */
            GoogleSignInAccount m964h();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* loaded from: classes.dex */
        public interface HasOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* loaded from: classes.dex */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* loaded from: classes.dex */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface Client extends AnyClient {
        @NonNull
        /* renamed from: a */
        Set<Scope> mo965a();

        /* renamed from: b */
        void m966b(IAccountAccessor iAccountAccessor, Set<Scope> set);

        /* renamed from: d */
        boolean m967d();

        void disconnect();

        /* renamed from: e */
        String m968e();

        /* renamed from: f */
        void m969f(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        /* renamed from: h */
        void m970h(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        boolean isConnected();

        /* renamed from: k */
        boolean m971k();

        /* renamed from: l */
        int mo972l();

        /* renamed from: m */
        Feature[] m973m();

        /* renamed from: n */
        boolean mo974n();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface SimpleClient<T extends IInterface> extends AnyClient {
        /* renamed from: g */
        void m975g(int i, T t);

        /* renamed from: i */
        String m976i();

        /* renamed from: j */
        T m977j(IBinder iBinder);

        /* renamed from: o */
        String m978o();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.Api$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0426a<T extends Client, O> extends AbstractC0428c<T, O> {
        @Deprecated
        /* renamed from: a */
        public T mo979a(Context context, Looper looper, C1850s9 c1850s9, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.Api$b */
    /* loaded from: classes.dex */
    public static class C0427b<C extends AnyClient> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.Api$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0428c<T extends AnyClient, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.Api$d */
    /* loaded from: classes.dex */
    public static final class C0429d<C extends Client> extends C0427b<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends Client> Api(String str, AbstractC0426a<C, O> abstractC0426a, C0429d<C> c0429d) {
        C0813ca.m2730l(abstractC0426a, "Cannot construct an Api with a null ClientBuilder");
        C0813ca.m2730l(c0429d, "Cannot construct an Api with a null ClientKey");
        this.f722c = str;
        this.f720a = abstractC0426a;
        this.f721b = c0429d;
    }

    /* renamed from: a */
    public final C0427b<?> m960a() {
        C0429d<?> c0429d = this.f721b;
        if (c0429d != null) {
            return c0429d;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    /* renamed from: b */
    public final String m961b() {
        return this.f722c;
    }

    /* renamed from: c */
    public final AbstractC0426a<?, O> m962c() {
        C0813ca.m2733o(this.f720a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f720a;
    }
}

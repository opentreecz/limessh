package cz.opentree;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.o4 */
/* loaded from: classes.dex */
public final class C1632o4 {

    /* renamed from: a */
    public static final Api.C0429d<C0984fe> f5416a;

    /* renamed from: b */
    public static final Api.C0429d<C1900t5> f5417b;

    /* renamed from: c */
    public static final Api.AbstractC0426a<C0984fe, a> f5418c;

    /* renamed from: d */
    public static final Api.AbstractC0426a<C1900t5, GoogleSignInOptions> f5419d;

    /* renamed from: e */
    public static final Api<GoogleSignInOptions> f5420e;

    /* renamed from: f */
    @Deprecated
    public static final ProxyApi f5421f;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    @Deprecated
    /* renamed from: cz.opentree.o4$a */
    /* loaded from: classes.dex */
    public static class a implements Api.ApiOptions.Optional {

        /* renamed from: R */
        public static final a f5422R = new C2500a().m6866b();

        /* renamed from: O */
        public final String f5423O;

        /* renamed from: P */
        public final boolean f5424P;

        /* renamed from: Q */
        @Nullable
        public final String f5425Q;

        /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
        @Deprecated
        /* renamed from: cz.opentree.o4$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C2500a {

            /* renamed from: a */
            public String f5426a;

            /* renamed from: b */
            public Boolean f5427b;

            /* renamed from: c */
            @Nullable
            public String f5428c;

            public C2500a() {
                this.f5427b = Boolean.FALSE;
            }

            public C2500a(a aVar) {
                this.f5427b = Boolean.FALSE;
                this.f5426a = aVar.f5423O;
                this.f5427b = Boolean.valueOf(aVar.f5424P);
                this.f5428c = aVar.f5425Q;
            }

            /* renamed from: a */
            public C2500a m6865a(String str) {
                this.f5428c = str;
                return this;
            }

            /* renamed from: b */
            public a m6866b() {
                return new a(this);
            }
        }

        public a(C2500a c2500a) {
            this.f5423O = c2500a.f5426a;
            this.f5424P = c2500a.f5427b.booleanValue();
            this.f5425Q = c2500a.f5428c;
        }

        /* renamed from: a */
        public final Bundle m6864a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.f5423O);
            bundle.putBoolean("force_save_dialog", this.f5424P);
            bundle.putString("log_session_id", this.f5425Q);
            return bundle;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C0758ba.m2404a(this.f5423O, aVar.f5423O) && this.f5424P == aVar.f5424P && C0758ba.m2404a(this.f5425Q, aVar.f5425Q);
        }

        public int hashCode() {
            return C0758ba.m2405b(this.f5423O, Boolean.valueOf(this.f5424P), this.f5425Q);
        }
    }

    static {
        Api.C0429d<C0984fe> c0429d = new Api.C0429d<>();
        f5416a = c0429d;
        Api.C0429d<C1900t5> c0429d2 = new Api.C0429d<>();
        f5417b = c0429d2;
        C1691p6 c1691p6 = new C1691p6();
        f5418c = c1691p6;
        C1749q6 c1749q6 = new C1749q6();
        f5419d = c1749q6;
        Api<C1747q4> api = C1689p4.f5618c;
        new Api("Auth.CREDENTIALS_API", c1691p6, c0429d);
        f5420e = new Api<>("Auth.GOOGLE_SIGN_IN_API", c1749q6, c0429d2);
        f5421f = C1689p4.f5619d;
    }
}

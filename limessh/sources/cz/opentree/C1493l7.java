package cz.opentree;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.l7 */
/* loaded from: classes.dex */
public final class C1493l7 {

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: cz.opentree.l7$a */
    /* loaded from: classes.dex */
    public static final class a<R extends Result> extends BasePendingResult<R> {
        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* renamed from: c */
        public final R mo1010c(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: cz.opentree.l7$b */
    /* loaded from: classes.dex */
    public static final class b<R extends Result> extends BasePendingResult<R> {

        /* renamed from: o */
        public final R f4757o;

        public b(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f4757o = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* renamed from: c */
        public final R mo1010c(Status status) {
            return this.f4757o;
        }
    }

    /* renamed from: a */
    public static <R extends Result> PendingResult<R> m6088a(R r, GoogleApiClient googleApiClient) {
        C0813ca.m2730l(r, "Result must not be null");
        C0813ca.m2720b(!r.mo991n().m996Z(), "Status code must not be SUCCESS");
        b bVar = new b(googleApiClient, r);
        bVar.m1013f(r);
        return bVar;
    }

    /* renamed from: b */
    public static <R extends Result> AbstractC1437k7<R> m6089b(R r, GoogleApiClient googleApiClient) {
        C0813ca.m2730l(r, "Result must not be null");
        a aVar = new a(googleApiClient);
        aVar.m1013f(r);
        return new C2203w7(aVar);
    }

    /* renamed from: c */
    public static PendingResult<Status> m6090c(Status status, GoogleApiClient googleApiClient) {
        C0813ca.m2730l(status, "Result must not be null");
        C2327y7 c2327y7 = new C2327y7(googleApiClient);
        c2327y7.m1013f(status);
        return c2327y7;
    }
}

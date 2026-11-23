package cz.opentree;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientEventManager$GmsClientEventState;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.v9 */
/* loaded from: classes.dex */
public abstract class AbstractC2159v9<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, GmsClientEventManager$GmsClientEventState {

    /* renamed from: w */
    public final C1850s9 f7429w;

    /* renamed from: x */
    public final Set<Scope> f7430x;

    /* renamed from: y */
    public final Account f7431y;

    @Deprecated
    public AbstractC2159v9(Context context, Looper looper, int i, C1850s9 c1850s9, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i, c1850s9, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AbstractC2159v9(android.content.Context r10, android.os.Looper r11, int r12, cz.opentree.C1850s9 r13, com.google.android.gms.common.api.internal.ConnectionCallbacks r14, com.google.android.gms.common.api.internal.OnConnectionFailedListener r15) {
        /*
            r9 = this;
            cz.opentree.w9 r3 = cz.opentree.AbstractC2207w9.m9450a(r10)
            cz.opentree.x6 r4 = cz.opentree.C2260x6.m9706m()
            cz.opentree.C0813ca.m2729k(r14)
            r7 = r14
            com.google.android.gms.common.api.internal.ConnectionCallbacks r7 = (com.google.android.gms.common.api.internal.ConnectionCallbacks) r7
            cz.opentree.C0813ca.m2729k(r15)
            r8 = r15
            com.google.android.gms.common.api.internal.OnConnectionFailedListener r8 = (com.google.android.gms.common.api.internal.OnConnectionFailedListener) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.AbstractC2159v9.<init>(android.content.Context, android.os.Looper, int, cz.opentree.s9, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):void");
    }

    public AbstractC2159v9(Context context, Looper looper, AbstractC2207w9 abstractC2207w9, C2260x6 c2260x6, int i, C1850s9 c1850s9, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, abstractC2207w9, c2260x6, i, m9201h0(connectionCallbacks), m9202i0(onConnectionFailedListener), c1850s9.m8406g());
        this.f7429w = c1850s9;
        this.f7431y = c1850s9.m8400a();
        Set<Scope> m8403d = c1850s9.m8403d();
        m9205j0(m8403d);
        this.f7430x = m8403d;
    }

    @Nullable
    /* renamed from: h0 */
    public static BaseGmsClient.BaseConnectionCallbacks m9201h0(ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new C1497la(connectionCallbacks);
    }

    @Nullable
    /* renamed from: i0 */
    public static BaseGmsClient.BaseOnConnectionFailedListener m9202i0(OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new C1543ma(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    /* renamed from: a */
    public Set<Scope> mo965a() {
        return mo974n() ? this.f7430x : Collections.emptySet();
    }

    /* renamed from: f0 */
    public final C1850s9 m9203f0() {
        return this.f7429w;
    }

    @NonNull
    /* renamed from: g0 */
    public Set<Scope> m9204g0(@NonNull Set<Scope> set) {
        return set;
    }

    /* renamed from: j0 */
    public final Set<Scope> m9205j0(@NonNull Set<Scope> set) {
        m9204g0(set);
        Iterator<Scope> it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return set;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: l */
    public int mo972l() {
        return super.mo972l();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: s */
    public final Account mo1093s() {
        return this.f7431y;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: y */
    public final Set<Scope> mo1099y() {
        return this.f7430x;
    }
}

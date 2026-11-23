package cz.opentree;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.zacf;
import com.google.android.gms.common.api.internal.zar;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import cz.opentree.C0758ba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.s7 */
/* loaded from: classes.dex */
public class C1848s7 implements Handler.Callback {

    /* renamed from: n */
    public static final Status f6359n = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: o */
    public static final Status f6360o = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: p */
    public static final Object f6361p = new Object();

    /* renamed from: q */
    @GuardedBy("lock")
    public static C1848s7 f6362q;

    /* renamed from: d */
    public final Context f6366d;

    /* renamed from: e */
    public final C2260x6 f6367e;

    /* renamed from: f */
    public final C2334y9 f6368f;

    /* renamed from: j */
    @GuardedBy("lock")
    public C0756b8 f6372j;

    /* renamed from: m */
    public final Handler f6375m;

    /* renamed from: a */
    public long f6363a = 5000;

    /* renamed from: b */
    public long f6364b = 120000;

    /* renamed from: c */
    public long f6365c = 10000;

    /* renamed from: g */
    public final AtomicInteger f6369g = new AtomicInteger(1);

    /* renamed from: h */
    public final AtomicInteger f6370h = new AtomicInteger(0);

    /* renamed from: i */
    public final Map<C1750q7<?>, a<?>> f6371i = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: k */
    @GuardedBy("lock")
    public final Set<C1750q7<?>> f6373k = new ArraySet();

    /* renamed from: l */
    public final Set<C1750q7<?>> f6374l = new ArraySet();

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: cz.opentree.s7$a */
    /* loaded from: classes.dex */
    public class a<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {

        /* renamed from: b */
        public final Api.Client f6377b;

        /* renamed from: c */
        public final Api.AnyClient f6378c;

        /* renamed from: d */
        public final C1750q7<O> f6379d;

        /* renamed from: e */
        public final C0702a9 f6380e;

        /* renamed from: h */
        public final int f6383h;

        /* renamed from: i */
        public final BinderC1751q8 f6384i;

        /* renamed from: j */
        public boolean f6385j;

        /* renamed from: a */
        public final Queue<AbstractC1636o8> f6376a = new LinkedList();

        /* renamed from: f */
        public final Set<C2262x8> f6381f = new HashSet();

        /* renamed from: g */
        public final Map<C2155v7<?>, C1591n8> f6382g = new HashMap();

        /* renamed from: k */
        public final List<c> f6386k = new ArrayList();

        /* renamed from: l */
        public ConnectionResult f6387l = null;

        @WorkerThread
        public a(C1199j7<O> c1199j7) {
            Api.Client m5078j = c1199j7.m5078j(C1848s7.this.f6375m.getLooper(), this);
            this.f6377b = m5078j;
            if (m5078j instanceof C0917ea) {
                this.f6378c = ((C0917ea) m5078j).m3460k0();
            } else {
                this.f6378c = m5078j;
            }
            this.f6379d = c1199j7.m5073e();
            this.f6380e = new C0702a9();
            this.f6383h = c1199j7.m5076h();
            if (m5078j.mo974n()) {
                this.f6384i = c1199j7.m5080l(C1848s7.this.f6366d, C1848s7.this.f6375m);
            } else {
                this.f6384i = null;
            }
        }

        @WorkerThread
        /* renamed from: A */
        public final void m8364A() {
            if (this.f6385j) {
                C1848s7.this.f6375m.removeMessages(11, this.f6379d);
                C1848s7.this.f6375m.removeMessages(9, this.f6379d);
                this.f6385j = false;
            }
        }

        /* renamed from: B */
        public final void m8365B() {
            C1848s7.this.f6375m.removeMessages(12, this.f6379d);
            C1848s7.this.f6375m.sendMessageDelayed(C1848s7.this.f6375m.obtainMessage(12, this.f6379d), C1848s7.this.f6365c);
        }

        @WorkerThread
        /* renamed from: C */
        public final boolean m8366C() {
            return m8369F(true);
        }

        @WorkerThread
        /* renamed from: D */
        public final void m8367D(Status status) {
            C0813ca.m2722d(C1848s7.this.f6375m);
            Iterator<AbstractC1636o8> it = this.f6376a.iterator();
            while (it.hasNext()) {
                it.next().mo6881b(status);
            }
            this.f6376a.clear();
        }

        @WorkerThread
        /* renamed from: E */
        public final void m8368E(AbstractC1636o8 abstractC1636o8) {
            abstractC1636o8.mo6882c(this.f6380e, m8376d());
            try {
                abstractC1636o8.mo6884f(this);
            } catch (DeadObjectException unused) {
                mo1018q(1);
                this.f6377b.disconnect();
            }
        }

        @WorkerThread
        /* renamed from: F */
        public final boolean m8369F(boolean z) {
            C0813ca.m2722d(C1848s7.this.f6375m);
            if (!this.f6377b.isConnected() || this.f6382g.size() != 0) {
                return false;
            }
            if (!this.f6380e.m2004d()) {
                this.f6377b.disconnect();
                return true;
            }
            if (z) {
                m8365B();
            }
            return false;
        }

        @WorkerThread
        /* renamed from: J */
        public final void m8370J(@NonNull ConnectionResult connectionResult) {
            C0813ca.m2722d(C1848s7.this.f6375m);
            this.f6377b.disconnect();
            mo1020r(connectionResult);
        }

        @WorkerThread
        /* renamed from: K */
        public final boolean m8371K(@NonNull ConnectionResult connectionResult) {
            synchronized (C1848s7.f6361p) {
                if (C1848s7.this.f6372j != null && C1848s7.this.f6373k.contains(this.f6379d)) {
                    C1848s7.this.f6372j.m10096a(connectionResult, this.f6383h);
                    throw null;
                }
            }
            return false;
        }

        @WorkerThread
        /* renamed from: L */
        public final void m8372L(ConnectionResult connectionResult) {
            for (C2262x8 c2262x8 : this.f6381f) {
                String str = null;
                if (C0758ba.m2404a(connectionResult, ConnectionResult.f708S)) {
                    str = this.f6377b.m968e();
                }
                c2262x8.m9728a(this.f6379d, connectionResult, str);
            }
            this.f6381f.clear();
        }

        @WorkerThread
        /* renamed from: a */
        public final void m8373a() {
            C0813ca.m2722d(C1848s7.this.f6375m);
            if (this.f6377b.isConnected() || this.f6377b.m967d()) {
                return;
            }
            int m10115b = C1848s7.this.f6368f.m10115b(C1848s7.this.f6366d, this.f6377b);
            if (m10115b != 0) {
                mo1020r(new ConnectionResult(m10115b, null));
                return;
            }
            C1848s7 c1848s7 = C1848s7.this;
            Api.Client client = this.f6377b;
            b bVar = new b(client, this.f6379d);
            if (client.mo974n()) {
                this.f6384i.m7633R0(bVar);
            }
            this.f6377b.m969f(bVar);
        }

        /* renamed from: b */
        public final int m8374b() {
            return this.f6383h;
        }

        /* renamed from: c */
        public final boolean m8375c() {
            return this.f6377b.isConnected();
        }

        /* renamed from: d */
        public final boolean m8376d() {
            return this.f6377b.mo974n();
        }

        @WorkerThread
        /* renamed from: e */
        public final void m8377e() {
            C0813ca.m2722d(C1848s7.this.f6375m);
            if (this.f6385j) {
                m8373a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        @WorkerThread
        /* renamed from: f */
        public final Feature m8378f(@Nullable Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] m973m = this.f6377b.m973m();
                if (m973m == null) {
                    m973m = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(m973m.length);
                for (Feature feature : m973m) {
                    arrayMap.put(feature.m957x(), Long.valueOf(feature.m956K()));
                }
                for (Feature feature2 : featureArr) {
                    if (!arrayMap.containsKey(feature2.m957x()) || ((Long) arrayMap.get(feature2.m957x())).longValue() < feature2.m956K()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        @WorkerThread
        /* renamed from: h */
        public final void m8379h(c cVar) {
            if (this.f6386k.contains(cVar) && !this.f6385j) {
                if (this.f6377b.isConnected()) {
                    m8388v();
                } else {
                    m8373a();
                }
            }
        }

        @WorkerThread
        /* renamed from: i */
        public final void m8380i(AbstractC1636o8 abstractC1636o8) {
            C0813ca.m2722d(C1848s7.this.f6375m);
            if (this.f6377b.isConnected()) {
                if (m8385p(abstractC1636o8)) {
                    m8365B();
                    return;
                } else {
                    this.f6376a.add(abstractC1636o8);
                    return;
                }
            }
            this.f6376a.add(abstractC1636o8);
            ConnectionResult connectionResult = this.f6387l;
            if (connectionResult == null || !connectionResult.m953Z()) {
                m8373a();
            } else {
                mo1020r(this.f6387l);
            }
        }

        @WorkerThread
        /* renamed from: j */
        public final void m8381j(C2262x8 c2262x8) {
            C0813ca.m2722d(C1848s7.this.f6375m);
            this.f6381f.add(c2262x8);
        }

        /* renamed from: l */
        public final Api.Client m8382l() {
            return this.f6377b;
        }

        @WorkerThread
        /* renamed from: m */
        public final void m8383m() {
            C0813ca.m2722d(C1848s7.this.f6375m);
            if (this.f6385j) {
                m8364A();
                m8367D(C1848s7.this.f6367e.mo9712g(C1848s7.this.f6366d) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f6377b.disconnect();
            }
        }

        @WorkerThread
        /* renamed from: o */
        public final void m8384o(c cVar) {
            Feature[] mo3455g;
            if (this.f6386k.remove(cVar)) {
                C1848s7.this.f6375m.removeMessages(15, cVar);
                C1848s7.this.f6375m.removeMessages(16, cVar);
                Feature feature = cVar.f6396b;
                ArrayList arrayList = new ArrayList(this.f6376a.size());
                for (AbstractC1636o8 abstractC1636o8 : this.f6376a) {
                    if ((abstractC1636o8 instanceof AbstractC0915e8) && (mo3455g = ((AbstractC0915e8) abstractC1636o8).mo3455g(this)) != null && C2420zb.m10418b(mo3455g, feature)) {
                        arrayList.add(abstractC1636o8);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    AbstractC1636o8 abstractC1636o82 = (AbstractC1636o8) obj;
                    this.f6376a.remove(abstractC1636o82);
                    abstractC1636o82.mo6883d(new C1635o7(feature));
                }
            }
        }

        @WorkerThread
        /* renamed from: p */
        public final boolean m8385p(AbstractC1636o8 abstractC1636o8) {
            if (!(abstractC1636o8 instanceof AbstractC0915e8)) {
                m8368E(abstractC1636o8);
                return true;
            }
            AbstractC0915e8 abstractC0915e8 = (AbstractC0915e8) abstractC1636o8;
            Feature m8378f = m8378f(abstractC0915e8.mo3455g(this));
            if (m8378f == null) {
                m8368E(abstractC1636o8);
                return true;
            }
            if (!abstractC0915e8.mo3456h(this)) {
                abstractC0915e8.mo6883d(new C1635o7(m8378f));
                return false;
            }
            c cVar = new c(this.f6379d, m8378f, null);
            int indexOf = this.f6386k.indexOf(cVar);
            if (indexOf >= 0) {
                c cVar2 = this.f6386k.get(indexOf);
                C1848s7.this.f6375m.removeMessages(15, cVar2);
                C1848s7.this.f6375m.sendMessageDelayed(Message.obtain(C1848s7.this.f6375m, 15, cVar2), C1848s7.this.f6363a);
                return false;
            }
            this.f6386k.add(cVar);
            C1848s7.this.f6375m.sendMessageDelayed(Message.obtain(C1848s7.this.f6375m, 15, cVar), C1848s7.this.f6363a);
            C1848s7.this.f6375m.sendMessageDelayed(Message.obtain(C1848s7.this.f6375m, 16, cVar), C1848s7.this.f6364b);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (m8371K(connectionResult)) {
                return false;
            }
            C1848s7.this.m8356m(connectionResult, this.f6383h);
            return false;
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        /* renamed from: q */
        public final void mo1018q(int i) {
            if (Looper.myLooper() == C1848s7.this.f6375m.getLooper()) {
                m8387u();
            } else {
                C1848s7.this.f6375m.post(new RunnableC1097h8(this));
            }
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        @WorkerThread
        /* renamed from: r */
        public final void mo1020r(@NonNull ConnectionResult connectionResult) {
            C0813ca.m2722d(C1848s7.this.f6375m);
            BinderC1751q8 binderC1751q8 = this.f6384i;
            if (binderC1751q8 != null) {
                binderC1751q8.m7634S0();
            }
            m8391y();
            C1848s7.this.f6368f.m10114a();
            m8372L(connectionResult);
            if (connectionResult.m955x() == 4) {
                m8367D(C1848s7.f6360o);
                return;
            }
            if (this.f6376a.isEmpty()) {
                this.f6387l = connectionResult;
                return;
            }
            if (m8371K(connectionResult) || C1848s7.this.m8356m(connectionResult, this.f6383h)) {
                return;
            }
            if (connectionResult.m955x() == 18) {
                this.f6385j = true;
            }
            if (this.f6385j) {
                C1848s7.this.f6375m.sendMessageDelayed(Message.obtain(C1848s7.this.f6375m, 9, this.f6379d), C1848s7.this.f6363a);
                return;
            }
            String m7630a = this.f6379d.m7630a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(m7630a).length() + 63 + String.valueOf(valueOf).length());
            sb.append("API: ");
            sb.append(m7630a);
            sb.append(" is not available on this device. Connection failed with: ");
            sb.append(valueOf);
            m8367D(new Status(17, sb.toString()));
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        /* renamed from: s */
        public final void mo1019s(@Nullable Bundle bundle) {
            if (Looper.myLooper() == C1848s7.this.f6375m.getLooper()) {
                m8386t();
            } else {
                C1848s7.this.f6375m.post(new RunnableC1030g8(this));
            }
        }

        @WorkerThread
        /* renamed from: t */
        public final void m8386t() {
            m8391y();
            m8372L(ConnectionResult.f708S);
            m8364A();
            Iterator<C1591n8> it = this.f6382g.values().iterator();
            while (it.hasNext()) {
                C1591n8 next = it.next();
                if (m8378f(next.f5239a.m9724b()) != null) {
                    it.remove();
                } else {
                    try {
                        next.f5239a.m9725c(this.f6378c, new k60<>());
                    } catch (DeadObjectException unused) {
                        mo1018q(1);
                        this.f6377b.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            m8388v();
            m8365B();
        }

        @WorkerThread
        /* renamed from: u */
        public final void m8387u() {
            m8391y();
            this.f6385j = true;
            this.f6380e.m2006f();
            C1848s7.this.f6375m.sendMessageDelayed(Message.obtain(C1848s7.this.f6375m, 9, this.f6379d), C1848s7.this.f6363a);
            C1848s7.this.f6375m.sendMessageDelayed(Message.obtain(C1848s7.this.f6375m, 11, this.f6379d), C1848s7.this.f6364b);
            C1848s7.this.f6368f.m10114a();
        }

        @WorkerThread
        /* renamed from: v */
        public final void m8388v() {
            ArrayList arrayList = new ArrayList(this.f6376a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                AbstractC1636o8 abstractC1636o8 = (AbstractC1636o8) obj;
                if (!this.f6377b.isConnected()) {
                    return;
                }
                if (m8385p(abstractC1636o8)) {
                    this.f6376a.remove(abstractC1636o8);
                }
            }
        }

        @WorkerThread
        /* renamed from: w */
        public final void m8389w() {
            C0813ca.m2722d(C1848s7.this.f6375m);
            m8367D(C1848s7.f6359n);
            this.f6380e.m2005e();
            for (C2155v7 c2155v7 : (C2155v7[]) this.f6382g.keySet().toArray(new C2155v7[this.f6382g.size()])) {
                m8380i(new C2204w8(c2155v7, new k60()));
            }
            m8372L(new ConnectionResult(4));
            if (this.f6377b.isConnected()) {
                this.f6377b.m970h(new C1200j8(this));
            }
        }

        /* renamed from: x */
        public final Map<C2155v7<?>, C1591n8> m8390x() {
            return this.f6382g;
        }

        @WorkerThread
        /* renamed from: y */
        public final void m8391y() {
            C0813ca.m2722d(C1848s7.this.f6375m);
            this.f6387l = null;
        }

        @WorkerThread
        /* renamed from: z */
        public final ConnectionResult m8392z() {
            C0813ca.m2722d(C1848s7.this.f6375m);
            return this.f6387l;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: cz.opentree.s7$b */
    /* loaded from: classes.dex */
    public class b implements zacf, BaseGmsClient.ConnectionProgressReportCallbacks {

        /* renamed from: a */
        public final Api.Client f6389a;

        /* renamed from: b */
        public final C1750q7<?> f6390b;

        /* renamed from: c */
        public IAccountAccessor f6391c = null;

        /* renamed from: d */
        public Set<Scope> f6392d = null;

        /* renamed from: e */
        public boolean f6393e = false;

        public b(Api.Client client, C1750q7<?> c1750q7) {
            this.f6389a = client;
            this.f6390b = c1750q7;
        }

        /* renamed from: e */
        public static /* synthetic */ boolean m8394e(b bVar, boolean z) {
            bVar.f6393e = true;
            return true;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        /* renamed from: a */
        public final void mo1104a(@NonNull ConnectionResult connectionResult) {
            C1848s7.this.f6375m.post(new RunnableC1494l8(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.zacf
        @WorkerThread
        /* renamed from: b */
        public final void mo1021b(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                mo1022c(new ConnectionResult(4));
            } else {
                this.f6391c = iAccountAccessor;
                this.f6392d = set;
                m8397g();
            }
        }

        @Override // com.google.android.gms.common.api.internal.zacf
        @WorkerThread
        /* renamed from: c */
        public final void mo1022c(ConnectionResult connectionResult) {
            ((a) C1848s7.this.f6371i.get(this.f6390b)).m8370J(connectionResult);
        }

        @WorkerThread
        /* renamed from: g */
        public final void m8397g() {
            IAccountAccessor iAccountAccessor;
            if (!this.f6393e || (iAccountAccessor = this.f6391c) == null) {
                return;
            }
            this.f6389a.m966b(iAccountAccessor, this.f6392d);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: cz.opentree.s7$c */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public final C1750q7<?> f6395a;

        /* renamed from: b */
        public final Feature f6396b;

        public c(C1750q7<?> c1750q7, Feature feature) {
            this.f6395a = c1750q7;
            this.f6396b = feature;
        }

        public /* synthetic */ c(C1750q7 c1750q7, Feature feature, C0973f8 c0973f8) {
            this(c1750q7, feature);
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                if (C0758ba.m2404a(this.f6395a, cVar.f6395a) && C0758ba.m2404a(this.f6396b, cVar.f6396b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return C0758ba.m2405b(this.f6395a, this.f6396b);
        }

        public final String toString() {
            C0758ba.a m2406c = C0758ba.m2406c(this);
            m2406c.m2407a("key", this.f6395a);
            m2406c.m2407a("feature", this.f6396b);
            return m2406c.toString();
        }
    }

    public C1848s7(Context context, Looper looper, C2260x6 c2260x6) {
        this.f6366d = context;
        HandlerC2215we handlerC2215we = new HandlerC2215we(looper, this);
        this.f6375m = handlerC2215we;
        this.f6367e = c2260x6;
        this.f6368f = new C2334y9(c2260x6);
        handlerC2215we.sendMessage(handlerC2215we.obtainMessage(6));
    }

    /* renamed from: a */
    public static void m8337a() {
        synchronized (f6361p) {
            C1848s7 c1848s7 = f6362q;
            if (c1848s7 != null) {
                c1848s7.f6370h.incrementAndGet();
                Handler handler = c1848s7.f6375m;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    /* renamed from: g */
    public static C1848s7 m8340g(Context context) {
        C1848s7 c1848s7;
        synchronized (f6361p) {
            if (f6362q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f6362q = new C1848s7(context.getApplicationContext(), handlerThread.getLooper(), C2260x6.m9706m());
            }
            c1848s7 = f6362q;
        }
        return c1848s7;
    }

    /* renamed from: c */
    public final void m8351c(ConnectionResult connectionResult, int i) {
        if (m8356m(connectionResult, i)) {
            return;
        }
        Handler handler = this.f6375m;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    /* renamed from: d */
    public final void m8352d(C1199j7<?> c1199j7) {
        Handler handler = this.f6375m;
        handler.sendMessage(handler.obtainMessage(7, c1199j7));
    }

    /* renamed from: e */
    public final <O extends Api.ApiOptions> void m8353e(C1199j7<O> c1199j7, int i, AbstractC1802r7<? extends Result, Api.AnyClient> abstractC1802r7) {
        C1997u8 c1997u8 = new C1997u8(i, abstractC1802r7);
        Handler handler = this.f6375m;
        handler.sendMessage(handler.obtainMessage(4, new C1541m8(c1997u8, this.f6370h.get(), c1199j7)));
    }

    @WorkerThread
    /* renamed from: h */
    public final void m8354h(C1199j7<?> c1199j7) {
        C1750q7<?> m5073e = c1199j7.m5073e();
        a<?> aVar = this.f6371i.get(m5073e);
        if (aVar == null) {
            aVar = new a<>(c1199j7);
            this.f6371i.put(m5073e, aVar);
        }
        if (aVar.m8376d()) {
            this.f6374l.add(m5073e);
        }
        aVar.m8373a();
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public boolean handleMessage(Message message) {
        int i = message.what;
        a<?> aVar = null;
        switch (i) {
            case 1:
                this.f6365c = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f6375m.removeMessages(12);
                for (C1750q7<?> c1750q7 : this.f6371i.keySet()) {
                    Handler handler = this.f6375m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c1750q7), this.f6365c);
                }
                return true;
            case 2:
                C2262x8 c2262x8 = (C2262x8) message.obj;
                Iterator<C1750q7<?>> it = c2262x8.m9729b().iterator();
                while (true) {
                    if (it.hasNext()) {
                        C1750q7<?> next = it.next();
                        a<?> aVar2 = this.f6371i.get(next);
                        if (aVar2 == null) {
                            c2262x8.m9728a(next, new ConnectionResult(13), null);
                        } else if (aVar2.m8375c()) {
                            c2262x8.m9728a(next, ConnectionResult.f708S, aVar2.m8382l().m968e());
                        } else if (aVar2.m8392z() != null) {
                            c2262x8.m9728a(next, aVar2.m8392z(), null);
                        } else {
                            aVar2.m8381j(c2262x8);
                            aVar2.m8373a();
                        }
                    }
                }
                return true;
            case 3:
                for (a<?> aVar3 : this.f6371i.values()) {
                    aVar3.m8391y();
                    aVar3.m8373a();
                }
                return true;
            case 4:
            case 8:
            case 13:
                C1541m8 c1541m8 = (C1541m8) message.obj;
                a<?> aVar4 = this.f6371i.get(c1541m8.f5000c.m5073e());
                if (aVar4 == null) {
                    m8354h(c1541m8.f5000c);
                    aVar4 = this.f6371i.get(c1541m8.f5000c.m5073e());
                }
                if (!aVar4.m8376d() || this.f6370h.get() == c1541m8.f4999b) {
                    aVar4.m8380i(c1541m8.f4998a);
                } else {
                    c1541m8.f4998a.mo6881b(f6359n);
                    aVar4.m8389w();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it2 = this.f6371i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        if (next2.m8374b() == i2) {
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    String mo9711e = this.f6367e.mo9711e(connectionResult.m955x());
                    String m951K = connectionResult.m951K();
                    StringBuilder sb = new StringBuilder(String.valueOf(mo9711e).length() + 69 + String.valueOf(m951K).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(mo9711e);
                    sb.append(": ");
                    sb.append(m951K);
                    aVar.m8367D(new Status(17, sb.toString()));
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i2);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                }
                return true;
            case 6:
                if (C1501lc.m6141a() && (this.f6366d.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.m1000c((Application) this.f6366d.getApplicationContext());
                    BackgroundDetector.m999b().m1001a(new C0973f8(this));
                    if (!BackgroundDetector.m999b().m1004f(true)) {
                        this.f6365c = 300000L;
                    }
                }
                return true;
            case 7:
                m8354h((C1199j7) message.obj);
                return true;
            case 9:
                if (this.f6371i.containsKey(message.obj)) {
                    this.f6371i.get(message.obj).m8377e();
                }
                return true;
            case 10:
                Iterator<C1750q7<?>> it3 = this.f6374l.iterator();
                while (it3.hasNext()) {
                    this.f6371i.remove(it3.next()).m8389w();
                }
                this.f6374l.clear();
                return true;
            case 11:
                if (this.f6371i.containsKey(message.obj)) {
                    this.f6371i.get(message.obj).m8383m();
                }
                return true;
            case 12:
                if (this.f6371i.containsKey(message.obj)) {
                    this.f6371i.get(message.obj).m8366C();
                }
                return true;
            case 14:
                C0811c8 c0811c8 = (C0811c8) message.obj;
                C1750q7<?> m2713a = c0811c8.m2713a();
                if (this.f6371i.containsKey(m2713a)) {
                    c0811c8.m2714b().m5844c(Boolean.valueOf(this.f6371i.get(m2713a).m8369F(false)));
                } else {
                    c0811c8.m2714b().m5844c(Boolean.FALSE);
                }
                return true;
            case 15:
                c cVar = (c) message.obj;
                if (this.f6371i.containsKey(cVar.f6395a)) {
                    this.f6371i.get(cVar.f6395a).m8379h(cVar);
                }
                return true;
            case 16:
                c cVar2 = (c) message.obj;
                if (this.f6371i.containsKey(cVar2.f6395a)) {
                    this.f6371i.get(cVar2.f6395a).m8384o(cVar2);
                }
                return true;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }

    /* renamed from: i */
    public final int m8355i() {
        return this.f6369g.getAndIncrement();
    }

    /* renamed from: m */
    public final boolean m8356m(ConnectionResult connectionResult, int i) {
        return this.f6367e.m9721t(this.f6366d, connectionResult, i);
    }

    /* renamed from: u */
    public final void m8357u() {
        Handler handler = this.f6375m;
        handler.sendMessage(handler.obtainMessage(3));
    }
}

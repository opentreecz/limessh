package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.sonelli.AbstractC2207w9;
import com.sonelli.C0704ab;
import com.sonelli.C0813ca;
import com.sonelli.C2326y6;
import com.sonelli.C2416z9;
import com.sonelli.HandlerC0872df;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public abstract class BaseGmsClient<T extends IInterface> {

    /* renamed from: v */
    public static final Feature[] f802v = new Feature[0];

    /* renamed from: a */
    public C0704ab f803a;

    /* renamed from: b */
    public final Context f804b;

    /* renamed from: c */
    public final AbstractC2207w9 f805c;

    /* renamed from: d */
    public final C2326y6 f806d;

    /* renamed from: e */
    public final Handler f807e;

    /* renamed from: f */
    public final Object f808f;

    /* renamed from: g */
    public final Object f809g;

    /* renamed from: h */
    @GuardedBy("mServiceBrokerLock")
    public IGmsServiceBroker f810h;

    /* renamed from: i */
    public ConnectionProgressReportCallbacks f811i;

    /* renamed from: j */
    @GuardedBy("mLock")
    public T f812j;

    /* renamed from: k */
    public final ArrayList<AbstractC0438c<?>> f813k;

    /* renamed from: l */
    @GuardedBy("mLock")
    public ServiceConnectionC0441f f814l;

    /* renamed from: m */
    @GuardedBy("mLock")
    public int f815m;

    /* renamed from: n */
    public final BaseConnectionCallbacks f816n;

    /* renamed from: o */
    public final BaseOnConnectionFailedListener f817o;

    /* renamed from: p */
    public final int f818p;

    /* renamed from: q */
    public final String f819q;

    /* renamed from: r */
    public ConnectionResult f820r;

    /* renamed from: s */
    public boolean f821s;

    /* renamed from: t */
    public volatile zza f822t;

    /* renamed from: u */
    public AtomicInteger f823u;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface BaseConnectionCallbacks {
        /* renamed from: q */
        void mo1101q(int i);

        /* renamed from: s */
        void mo1102s(@Nullable Bundle bundle);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface BaseOnConnectionFailedListener {
        /* renamed from: r */
        void mo1103r(@NonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface ConnectionProgressReportCallbacks {
        /* renamed from: a */
        void mo1104a(@NonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface SignOutCallbacks {
        /* renamed from: a */
        void mo1105a();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$a */
    /* loaded from: classes.dex */
    public class C0436a implements ConnectionProgressReportCallbacks {
        public C0436a() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        /* renamed from: a */
        public void mo1104a(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.m954a0()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.m1077b(null, baseGmsClient.mo1099y());
            } else if (BaseGmsClient.this.f817o != null) {
                BaseGmsClient.this.f817o.mo1103r(connectionResult);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$b */
    /* loaded from: classes.dex */
    public abstract class AbstractC0437b extends AbstractC0438c<Boolean> {

        /* renamed from: d */
        public final int f825d;

        /* renamed from: e */
        public final Bundle f826e;

        @BinderThread
        public AbstractC0437b(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.f825d = i;
            this.f826e = bundle;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.AbstractC0438c
        /* renamed from: c */
        public final /* synthetic */ void mo1106c(Boolean bool) {
            if (bool == null) {
                BaseGmsClient.this.m1073O(1, null);
                return;
            }
            int i = this.f825d;
            if (i == 0) {
                if (mo1109g()) {
                    return;
                }
                BaseGmsClient.this.m1073O(1, null);
                mo1108f(new ConnectionResult(8, null));
                return;
            }
            if (i == 10) {
                BaseGmsClient.this.m1073O(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), BaseGmsClient.this.mo1089o(), BaseGmsClient.this.mo1085i()));
            }
            BaseGmsClient.this.m1073O(1, null);
            Bundle bundle = this.f826e;
            mo1108f(new ConnectionResult(this.f825d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.AbstractC0438c
        /* renamed from: d */
        public final void mo1107d() {
        }

        /* renamed from: f */
        public abstract void mo1108f(ConnectionResult connectionResult);

        /* renamed from: g */
        public abstract boolean mo1109g();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$c */
    /* loaded from: classes.dex */
    public abstract class AbstractC0438c<TListener> {

        /* renamed from: a */
        public TListener f828a;

        /* renamed from: b */
        public boolean f829b = false;

        public AbstractC0438c(TListener tlistener) {
            this.f828a = tlistener;
        }

        /* renamed from: a */
        public final void m1110a() {
            synchronized (this) {
                this.f828a = null;
            }
        }

        /* renamed from: b */
        public final void m1111b() {
            m1110a();
            synchronized (BaseGmsClient.this.f813k) {
                BaseGmsClient.this.f813k.remove(this);
            }
        }

        /* renamed from: c */
        public abstract void mo1106c(TListener tlistener);

        /* renamed from: d */
        public abstract void mo1107d();

        /* renamed from: e */
        public final void m1112e() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f828a;
                if (this.f829b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    mo1106c(tlistener);
                } catch (RuntimeException e) {
                    mo1107d();
                    throw e;
                }
            } else {
                mo1107d();
            }
            synchronized (this) {
                this.f829b = true;
            }
            m1111b();
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$d */
    /* loaded from: classes.dex */
    public final class HandlerC0439d extends HandlerC0872df {
        public HandlerC0439d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public static void m1113a(Message message) {
            AbstractC0438c abstractC0438c = (AbstractC0438c) message.obj;
            abstractC0438c.mo1107d();
            abstractC0438c.m1111b();
        }

        /* renamed from: b */
        public static boolean m1114b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (BaseGmsClient.this.f823u.get() != message.arg1) {
                if (m1114b(message)) {
                    m1113a(message);
                    return;
                }
                return;
            }
            int i = message.what;
            if ((i == 1 || i == 7 || ((i == 4 && !BaseGmsClient.this.m1092r()) || message.what == 5)) && !BaseGmsClient.this.m1079d()) {
                m1113a(message);
                return;
            }
            int i2 = message.what;
            if (i2 == 4) {
                BaseGmsClient.this.f820r = new ConnectionResult(message.arg2);
                if (BaseGmsClient.this.m1082e0() && !BaseGmsClient.this.f821s) {
                    BaseGmsClient.this.m1073O(3, null);
                    return;
                }
                ConnectionResult connectionResult = BaseGmsClient.this.f820r != null ? BaseGmsClient.this.f820r : new ConnectionResult(8);
                BaseGmsClient.this.f811i.mo1104a(connectionResult);
                BaseGmsClient.this.m1065D(connectionResult);
                return;
            }
            if (i2 == 5) {
                ConnectionResult connectionResult2 = BaseGmsClient.this.f820r != null ? BaseGmsClient.this.f820r : new ConnectionResult(8);
                BaseGmsClient.this.f811i.mo1104a(connectionResult2);
                BaseGmsClient.this.m1065D(connectionResult2);
                return;
            }
            if (i2 == 3) {
                Object obj = message.obj;
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                BaseGmsClient.this.f811i.mo1104a(connectionResult3);
                BaseGmsClient.this.m1065D(connectionResult3);
                return;
            }
            if (i2 == 6) {
                BaseGmsClient.this.m1073O(5, null);
                if (BaseGmsClient.this.f816n != null) {
                    BaseGmsClient.this.f816n.mo1101q(message.arg2);
                }
                BaseGmsClient.this.m1066E(message.arg2);
                BaseGmsClient.this.m1075T(5, 1, null);
                return;
            }
            if (i2 == 2 && !BaseGmsClient.this.isConnected()) {
                m1113a(message);
                return;
            }
            if (m1114b(message)) {
                ((AbstractC0438c) message.obj).m1112e();
                return;
            }
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i3);
            Log.wtf("GmsClient", sb.toString(), new Exception());
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$e */
    /* loaded from: classes.dex */
    public static final class BinderC0440e extends IGmsCallbacks.AbstractBinderC0445a {

        /* renamed from: a */
        public BaseGmsClient f832a;

        /* renamed from: b */
        public final int f833b;

        public BinderC0440e(@NonNull BaseGmsClient baseGmsClient, int i) {
            this.f832a = baseGmsClient;
            this.f833b = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        /* renamed from: d0 */
        public final void mo1115d0(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        /* renamed from: k0 */
        public final void mo1116k0(int i, @NonNull IBinder iBinder, @NonNull zza zzaVar) {
            C0813ca.m2730l(this.f832a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            C0813ca.m2729k(zzaVar);
            this.f832a.m1074S(zzaVar);
            mo1117l0(i, iBinder, zzaVar.f868O);
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        /* renamed from: l0 */
        public final void mo1117l0(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            C0813ca.m2730l(this.f832a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f832a.m1067F(i, iBinder, bundle, this.f833b);
            this.f832a = null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$f */
    /* loaded from: classes.dex */
    public final class ServiceConnectionC0441f implements ServiceConnection {

        /* renamed from: a */
        public final int f834a;

        public ServiceConnectionC0441f(int i) {
            this.f834a = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker c2416z9;
            if (iBinder == null) {
                BaseGmsClient.this.m1076V(16);
                return;
            }
            synchronized (BaseGmsClient.this.f809g) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    c2416z9 = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    c2416z9 = (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new C2416z9(iBinder) : (IGmsServiceBroker) queryLocalInterface;
                }
                baseGmsClient.f810h = c2416z9;
            }
            BaseGmsClient.this.m1072N(0, null, this.f834a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.f809g) {
                BaseGmsClient.this.f810h = null;
            }
            Handler handler = BaseGmsClient.this.f807e;
            handler.sendMessage(handler.obtainMessage(6, this.f834a, 1));
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$g */
    /* loaded from: classes.dex */
    public final class C0442g extends AbstractC0437b {
        @BinderThread
        public C0442g(int i, @Nullable Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.AbstractC0437b
        /* renamed from: f */
        public final void mo1108f(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.m1092r() && BaseGmsClient.this.m1082e0()) {
                BaseGmsClient.this.m1076V(16);
            } else {
                BaseGmsClient.this.f811i.mo1104a(connectionResult);
                BaseGmsClient.this.m1065D(connectionResult);
            }
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.AbstractC0437b
        /* renamed from: g */
        public final boolean mo1109g() {
            BaseGmsClient.this.f811i.mo1104a(ConnectionResult.f708S);
            return true;
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$h */
    /* loaded from: classes.dex */
    public final class C0443h extends AbstractC0437b {

        /* renamed from: g */
        public final IBinder f837g;

        @BinderThread
        public C0443h(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f837g = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.AbstractC0437b
        /* renamed from: f */
        public final void mo1108f(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.f817o != null) {
                BaseGmsClient.this.f817o.mo1103r(connectionResult);
            }
            BaseGmsClient.this.m1065D(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.AbstractC0437b
        /* renamed from: g */
        public final boolean mo1109g() {
            try {
                String interfaceDescriptor = this.f837g.getInterfaceDescriptor();
                if (!BaseGmsClient.this.mo1085i().equals(interfaceDescriptor)) {
                    String mo1085i = BaseGmsClient.this.mo1085i();
                    StringBuilder sb = new StringBuilder(String.valueOf(mo1085i).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(mo1085i);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface mo1086j = BaseGmsClient.this.mo1086j(this.f837g);
                if (mo1086j == null || !(BaseGmsClient.this.m1075T(2, 4, mo1086j) || BaseGmsClient.this.m1075T(3, 4, mo1086j))) {
                    return false;
                }
                BaseGmsClient.this.f820r = null;
                Bundle m1095u = BaseGmsClient.this.m1095u();
                if (BaseGmsClient.this.f816n == null) {
                    return true;
                }
                BaseGmsClient.this.f816n.mo1102s(m1095u);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BaseGmsClient(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks r13, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener r14, java.lang.String r15) {
        /*
            r9 = this;
            com.sonelli.w9 r3 = com.sonelli.AbstractC2207w9.m9450a(r10)
            com.sonelli.y6 r4 = com.sonelli.C2326y6.m10090f()
            com.sonelli.C0813ca.m2729k(r13)
            r6 = r13
            com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks r6 = (com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks) r6
            com.sonelli.C0813ca.m2729k(r14)
            r7 = r14
            com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener r7 = (com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener) r7
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks, com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener, java.lang.String):void");
    }

    public BaseGmsClient(Context context, Looper looper, AbstractC2207w9 abstractC2207w9, C2326y6 c2326y6, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.f808f = new Object();
        this.f809g = new Object();
        this.f813k = new ArrayList<>();
        this.f815m = 1;
        this.f820r = null;
        this.f821s = false;
        this.f822t = null;
        this.f823u = new AtomicInteger(0);
        C0813ca.m2730l(context, "Context must not be null");
        this.f804b = context;
        C0813ca.m2730l(looper, "Looper must not be null");
        C0813ca.m2730l(abstractC2207w9, "Supervisor must not be null");
        this.f805c = abstractC2207w9;
        C0813ca.m2730l(c2326y6, "API availability must not be null");
        this.f806d = c2326y6;
        this.f807e = new HandlerC0439d(looper);
        this.f818p = i;
        this.f816n = baseConnectionCallbacks;
        this.f817o = baseOnConnectionFailedListener;
        this.f819q = str;
    }

    /* renamed from: A */
    public String m1062A() {
        return "com.google.android.gms";
    }

    /* renamed from: B */
    public boolean m1063B() {
        return false;
    }

    @CallSuper
    /* renamed from: C */
    public void m1064C(@NonNull T t) {
        System.currentTimeMillis();
    }

    @CallSuper
    /* renamed from: D */
    public void m1065D(ConnectionResult connectionResult) {
        connectionResult.m955x();
        System.currentTimeMillis();
    }

    @CallSuper
    /* renamed from: E */
    public void m1066E(int i) {
        System.currentTimeMillis();
    }

    /* renamed from: F */
    public void m1067F(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.f807e;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new C0443h(i, iBinder, bundle)));
    }

    /* renamed from: G */
    public void mo1068G(int i, T t) {
    }

    /* renamed from: H */
    public boolean m1069H() {
        return false;
    }

    /* renamed from: I */
    public void m1070I(int i) {
        Handler handler = this.f807e;
        handler.sendMessage(handler.obtainMessage(6, this.f823u.get(), i));
    }

    /* renamed from: J */
    public void m1071J(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, @Nullable PendingIntent pendingIntent) {
        C0813ca.m2730l(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.f811i = connectionProgressReportCallbacks;
        Handler handler = this.f807e;
        handler.sendMessage(handler.obtainMessage(3, this.f823u.get(), i, pendingIntent));
    }

    /* renamed from: N */
    public final void m1072N(int i, @Nullable Bundle bundle, int i2) {
        Handler handler = this.f807e;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new C0442g(i, null)));
    }

    /* renamed from: O */
    public final void m1073O(int i, T t) {
        C0704ab c0704ab;
        C0813ca.m2719a((i == 4) == (t != null));
        synchronized (this.f808f) {
            this.f815m = i;
            this.f812j = t;
            mo1068G(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (this.f814l != null && (c0704ab = this.f803a) != null) {
                        String m2034d = c0704ab.m2034d();
                        String m2031a = this.f803a.m2031a();
                        StringBuilder sb = new StringBuilder(String.valueOf(m2034d).length() + 70 + String.valueOf(m2031a).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(m2034d);
                        sb.append(" on ");
                        sb.append(m2031a);
                        Log.e("GmsClient", sb.toString());
                        this.f805c.m9451b(this.f803a.m2034d(), this.f803a.m2031a(), this.f803a.m2033c(), this.f814l, m1078c0(), this.f803a.m2032b());
                        this.f823u.incrementAndGet();
                    }
                    this.f814l = new ServiceConnectionC0441f(this.f823u.get());
                    C0704ab c0704ab2 = (this.f815m != 3 || m1098x() == null) ? new C0704ab(m1062A(), mo1089o(), false, KeycodeConstants.KEYCODE_MEDIA_EJECT, m1063B()) : new C0704ab(m1096v().getPackageName(), m1098x(), true, KeycodeConstants.KEYCODE_MEDIA_EJECT, false);
                    this.f803a = c0704ab2;
                    if (c0704ab2.m2032b() && mo972l() < 17895000) {
                        String valueOf = String.valueOf(this.f803a.m2034d());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                    if (!this.f805c.mo9452c(new AbstractC2207w9.a(this.f803a.m2034d(), this.f803a.m2031a(), this.f803a.m2033c(), this.f803a.m2032b()), this.f814l, m1078c0())) {
                        String m2034d2 = this.f803a.m2034d();
                        String m2031a2 = this.f803a.m2031a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(m2034d2).length() + 34 + String.valueOf(m2031a2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(m2034d2);
                        sb2.append(" on ");
                        sb2.append(m2031a2);
                        Log.e("GmsClient", sb2.toString());
                        m1072N(16, null, this.f823u.get());
                    }
                } else if (i == 4) {
                    m1064C(t);
                }
            } else if (this.f814l != null) {
                this.f805c.m9451b(this.f803a.m2034d(), this.f803a.m2031a(), this.f803a.m2033c(), this.f814l, m1078c0(), this.f803a.m2032b());
                this.f814l = null;
            }
        }
    }

    /* renamed from: S */
    public final void m1074S(zza zzaVar) {
        this.f822t = zzaVar;
    }

    /* renamed from: T */
    public final boolean m1075T(int i, int i2, T t) {
        synchronized (this.f808f) {
            if (this.f815m != i) {
                return false;
            }
            m1073O(i2, t);
            return true;
        }
    }

    /* renamed from: V */
    public final void m1076V(int i) {
        int i2;
        if (m1080d0()) {
            i2 = 5;
            this.f821s = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.f807e;
        handler.sendMessage(handler.obtainMessage(i2, this.f823u.get(), 16));
    }

    @WorkerThread
    /* renamed from: b */
    public void m1077b(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle mo1097w = mo1097w();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.f818p);
        getServiceRequest.f845R = this.f804b.getPackageName();
        getServiceRequest.f848U = mo1097w;
        if (set != null) {
            getServiceRequest.f847T = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (mo974n()) {
            getServiceRequest.f849V = mo1093s() != null ? mo1093s() : new Account("<<default account>>", "com.google");
            if (iAccountAccessor != null) {
                getServiceRequest.f846S = iAccountAccessor.asBinder();
            }
        } else if (m1069H()) {
            getServiceRequest.f849V = mo1093s();
        }
        getServiceRequest.f850W = f802v;
        getServiceRequest.f851X = m1094t();
        try {
            synchronized (this.f809g) {
                IGmsServiceBroker iGmsServiceBroker = this.f810h;
                if (iGmsServiceBroker != null) {
                    iGmsServiceBroker.mo1121K(new BinderC0440e(this, this.f823u.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m1070I(1);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m1067F(8, null, null, this.f823u.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m1067F(8, null, null, this.f823u.get());
        }
    }

    @Nullable
    /* renamed from: c0 */
    public final String m1078c0() {
        String str = this.f819q;
        return str == null ? this.f804b.getClass().getName() : str;
    }

    /* renamed from: d */
    public boolean m1079d() {
        boolean z;
        synchronized (this.f808f) {
            int i = this.f815m;
            z = i == 2 || i == 3;
        }
        return z;
    }

    /* renamed from: d0 */
    public final boolean m1080d0() {
        boolean z;
        synchronized (this.f808f) {
            z = this.f815m == 3;
        }
        return z;
    }

    public void disconnect() {
        this.f823u.incrementAndGet();
        synchronized (this.f813k) {
            int size = this.f813k.size();
            for (int i = 0; i < size; i++) {
                this.f813k.get(i).m1110a();
            }
            this.f813k.clear();
        }
        synchronized (this.f809g) {
            this.f810h = null;
        }
        m1073O(1, null);
    }

    /* renamed from: e */
    public String m1081e() {
        C0704ab c0704ab;
        if (!isConnected() || (c0704ab = this.f803a) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return c0704ab.m2031a();
    }

    /* renamed from: e0 */
    public final boolean m1082e0() {
        if (this.f821s || TextUtils.isEmpty(mo1085i()) || TextUtils.isEmpty(m1098x())) {
            return false;
        }
        try {
            Class.forName(mo1085i());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: f */
    public void m1083f(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        C0813ca.m2730l(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.f811i = connectionProgressReportCallbacks;
        m1073O(2, null);
    }

    /* renamed from: h */
    public void m1084h(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.mo1105a();
    }

    @NonNull
    /* renamed from: i */
    public abstract String mo1085i();

    public boolean isConnected() {
        boolean z;
        synchronized (this.f808f) {
            z = this.f815m == 4;
        }
        return z;
    }

    @Nullable
    /* renamed from: j */
    public abstract T mo1086j(IBinder iBinder);

    /* renamed from: k */
    public boolean m1087k() {
        return true;
    }

    /* renamed from: l */
    public int mo972l() {
        return C2326y6.f8141a;
    }

    @Nullable
    /* renamed from: m */
    public final Feature[] m1088m() {
        zza zzaVar = this.f822t;
        if (zzaVar == null) {
            return null;
        }
        return zzaVar.f869P;
    }

    /* renamed from: n */
    public boolean mo974n() {
        return false;
    }

    @NonNull
    /* renamed from: o */
    public abstract String mo1089o();

    /* renamed from: p */
    public void m1090p() {
        int mo9713h = this.f806d.mo9713h(this.f804b, mo972l());
        if (mo9713h == 0) {
            m1083f(new C0436a());
        } else {
            m1073O(1, null);
            m1071J(new C0436a(), mo9713h, null);
        }
    }

    /* renamed from: q */
    public final void m1091q() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* renamed from: r */
    public boolean m1092r() {
        return false;
    }

    /* renamed from: s */
    public Account mo1093s() {
        return null;
    }

    /* renamed from: t */
    public Feature[] m1094t() {
        return f802v;
    }

    /* renamed from: u */
    public Bundle m1095u() {
        return null;
    }

    /* renamed from: v */
    public final Context m1096v() {
        return this.f804b;
    }

    /* renamed from: w */
    public Bundle mo1097w() {
        return new Bundle();
    }

    @Nullable
    /* renamed from: x */
    public String m1098x() {
        return null;
    }

    /* renamed from: y */
    public Set<Scope> mo1099y() {
        return Collections.EMPTY_SET;
    }

    /* renamed from: z */
    public final T m1100z() throws DeadObjectException {
        T t;
        synchronized (this.f808f) {
            if (this.f815m == 5) {
                throw new DeadObjectException();
            }
            m1091q();
            C0813ca.m2733o(this.f812j != null, "Client is connected but service is null");
            t = this.f812j;
        }
        return t;
    }
}

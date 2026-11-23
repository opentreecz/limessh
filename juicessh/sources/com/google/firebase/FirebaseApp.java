package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.material.badge.BadgeDrawable;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.events.Publisher;
import com.sonelli.C0705ac;
import com.sonelli.C0758ba;
import com.sonelli.C0813ca;
import com.sonelli.C1501lc;
import com.sonelli.C1547mc;
import com.sonelli.f70;
import com.sonelli.fd0;
import com.sonelli.g80;
import com.sonelli.h70;
import com.sonelli.hg0;
import com.sonelli.kg0;
import com.sonelli.mg0;
import com.sonelli.og0;
import com.sonelli.v70;
import com.sonelli.z70;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class FirebaseApp {

    /* renamed from: i */
    public static final Object f1097i = new Object();

    /* renamed from: j */
    public static final Executor f1098j = new ExecutorC0624c();

    /* renamed from: k */
    @GuardedBy("LOCK")
    public static final Map<String, FirebaseApp> f1099k = new ArrayMap();

    /* renamed from: a */
    public final Context f1100a;

    /* renamed from: b */
    public final String f1101b;

    /* renamed from: c */
    public final h70 f1102c;

    /* renamed from: d */
    public final z70 f1103d;

    /* renamed from: g */
    public final g80<hg0> f1106g;

    /* renamed from: e */
    public final AtomicBoolean f1104e = new AtomicBoolean(false);

    /* renamed from: f */
    public final AtomicBoolean f1105f = new AtomicBoolean();

    /* renamed from: h */
    public final List<BackgroundStateChangeListener> f1107h = new CopyOnWriteArrayList();

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    /* loaded from: classes.dex */
    public interface BackgroundStateChangeListener {
        /* renamed from: a */
        void m1588a(boolean z);
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    @TargetApi(14)
    /* renamed from: com.google.firebase.FirebaseApp$b */
    /* loaded from: classes.dex */
    public static class C0623b implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a */
        public static AtomicReference<C0623b> f1108a = new AtomicReference<>();

        /* renamed from: c */
        public static void m1590c(Context context) {
            if (C1501lc.m6141a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f1108a.get() == null) {
                    C0623b c0623b = new C0623b();
                    if (f1108a.compareAndSet(null, c0623b)) {
                        BackgroundDetector.m1000c(application);
                        BackgroundDetector.m999b().m1001a(c0623b);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        /* renamed from: a */
        public void mo1005a(boolean z) {
            synchronized (FirebaseApp.f1097i) {
                Iterator it = new ArrayList(FirebaseApp.f1099k.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.f1104e.get()) {
                        firebaseApp.m1587t(z);
                    }
                }
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    /* renamed from: com.google.firebase.FirebaseApp$c */
    /* loaded from: classes.dex */
    public static class ExecutorC0624c implements Executor {

        /* renamed from: a */
        public static final Handler f1109a = new Handler(Looper.getMainLooper());

        public ExecutorC0624c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            f1109a.post(runnable);
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    @TargetApi(24)
    /* renamed from: com.google.firebase.FirebaseApp$d */
    /* loaded from: classes.dex */
    public static class C0625d extends BroadcastReceiver {

        /* renamed from: b */
        public static AtomicReference<C0625d> f1110b = new AtomicReference<>();

        /* renamed from: a */
        public final Context f1111a;

        public C0625d(Context context) {
            this.f1111a = context;
        }

        /* renamed from: b */
        public static void m1592b(Context context) {
            if (f1110b.get() == null) {
                C0625d c0625d = new C0625d(context);
                if (f1110b.compareAndSet(null, c0625d)) {
                    context.registerReceiver(c0625d, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        /* renamed from: c */
        public void m1593c() {
            this.f1111a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f1097i) {
                Iterator<FirebaseApp> it = FirebaseApp.f1099k.values().iterator();
                while (it.hasNext()) {
                    it.next().m1584l();
                }
            }
            m1593c();
        }
    }

    public FirebaseApp(Context context, String str, h70 h70Var) {
        new CopyOnWriteArrayList();
        C0813ca.m2729k(context);
        this.f1100a = context;
        C0813ca.m2725g(str);
        this.f1101b = str;
        C0813ca.m2729k(h70Var);
        this.f1102c = h70Var;
        List<ComponentRegistrar> m1604a = ComponentDiscovery.m1602b(context, ComponentDiscoveryService.class).m1604a();
        String m6408a = mg0.m6408a();
        Executor executor = f1098j;
        v70[] v70VarArr = new v70[8];
        v70VarArr[0] = v70.m9178n(context, Context.class, new Class[0]);
        v70VarArr[1] = v70.m9178n(this, FirebaseApp.class, new Class[0]);
        v70VarArr[2] = v70.m9178n(h70Var, h70.class, new Class[0]);
        v70VarArr[3] = og0.m7033a("fire-android", "");
        v70VarArr[4] = og0.m7033a("fire-core", "19.3.0");
        v70VarArr[5] = m6408a != null ? og0.m7033a("kotlin", m6408a) : null;
        v70VarArr[6] = kg0.m5884b();
        v70VarArr[7] = fd0.m3732b();
        this.f1103d = new z70(executor, m1604a, v70VarArr);
        this.f1106g = new g80<>(f70.m3687a(this, context));
    }

    @NonNull
    /* renamed from: h */
    public static FirebaseApp m1572h() {
        FirebaseApp firebaseApp;
        synchronized (f1097i) {
            firebaseApp = f1099k.get("[DEFAULT]");
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + C1547mc.m6396a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    @Nullable
    /* renamed from: m */
    public static FirebaseApp m1573m(@NonNull Context context) {
        synchronized (f1097i) {
            if (f1099k.containsKey("[DEFAULT]")) {
                return m1572h();
            }
            h70 m4382a = h70.m4382a(context);
            if (m4382a == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return m1574n(context, m4382a);
        }
    }

    @NonNull
    /* renamed from: n */
    public static FirebaseApp m1574n(@NonNull Context context, @NonNull h70 h70Var) {
        return m1575o(context, h70Var, "[DEFAULT]");
    }

    @NonNull
    /* renamed from: o */
    public static FirebaseApp m1575o(@NonNull Context context, @NonNull h70 h70Var, @NonNull String str) {
        FirebaseApp firebaseApp;
        C0623b.m1590c(context);
        String m1577s = m1577s(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f1097i) {
            Map<String, FirebaseApp> map = f1099k;
            C0813ca.m2733o(!map.containsKey(m1577s), "FirebaseApp name " + m1577s + " already exists!");
            C0813ca.m2730l(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, m1577s, h70Var);
            map.put(m1577s, firebaseApp);
        }
        firebaseApp.m1584l();
        return firebaseApp;
    }

    /* renamed from: r */
    public static /* synthetic */ hg0 m1576r(FirebaseApp firebaseApp, Context context) {
        return new hg0(context, firebaseApp.m1583k(), (Publisher) firebaseApp.f1103d.mo1598a(Publisher.class));
    }

    /* renamed from: s */
    public static String m1577s(@NonNull String str) {
        return str.trim();
    }

    /* renamed from: e */
    public final void m1578e() {
        C0813ca.m2733o(!this.f1105f.get(), "FirebaseApp was deleted");
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseApp) {
            return this.f1101b.equals(((FirebaseApp) obj).m1581i());
        }
        return false;
    }

    /* renamed from: f */
    public <T> T m1579f(Class<T> cls) {
        m1578e();
        return (T) this.f1103d.mo1598a(cls);
    }

    @NonNull
    /* renamed from: g */
    public Context m1580g() {
        m1578e();
        return this.f1100a;
    }

    public int hashCode() {
        return this.f1101b.hashCode();
    }

    @NonNull
    /* renamed from: i */
    public String m1581i() {
        m1578e();
        return this.f1101b;
    }

    @NonNull
    /* renamed from: j */
    public h70 m1582j() {
        m1578e();
        return this.f1102c;
    }

    /* renamed from: k */
    public String m1583k() {
        return C0705ac.m2038c(m1581i().getBytes(Charset.defaultCharset())) + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + C0705ac.m2038c(m1582j().m4384c().getBytes(Charset.defaultCharset()));
    }

    /* renamed from: l */
    public final void m1584l() {
        if (!UserManagerCompat.isUserUnlocked(this.f1100a)) {
            C0625d.m1592b(this.f1100a);
        } else {
            this.f1103d.m10398e(m1586q());
        }
    }

    /* renamed from: p */
    public boolean m1585p() {
        m1578e();
        return this.f1106g.get().m4446b();
    }

    @VisibleForTesting
    /* renamed from: q */
    public boolean m1586q() {
        return "[DEFAULT]".equals(m1581i());
    }

    /* renamed from: t */
    public final void m1587t(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<BackgroundStateChangeListener> it = this.f1107h.iterator();
        while (it.hasNext()) {
            it.next().m1588a(z);
        }
    }

    public String toString() {
        C0758ba.a m2406c = C0758ba.m2406c(this);
        m2406c.m2407a("name", this.f1101b);
        m2406c.m2407a("options", this.f1102c);
        return m2406c.toString();
    }
}

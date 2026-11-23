package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.sonelli.C0813ca;
import com.sonelli.C1599nc;
import com.sonelli.C1698pc;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes.dex */
public class WakeLock {

    /* renamed from: m */
    public static ScheduledExecutorService f1039m;

    /* renamed from: a */
    public final Object f1040a;

    /* renamed from: b */
    public final PowerManager.WakeLock f1041b;

    /* renamed from: c */
    public WorkSource f1042c;

    /* renamed from: d */
    public final int f1043d;

    /* renamed from: e */
    public final String f1044e;

    /* renamed from: f */
    public final String f1045f;

    /* renamed from: g */
    public final Context f1046g;

    /* renamed from: h */
    public boolean f1047h;

    /* renamed from: i */
    public final Map<String, Integer[]> f1048i;

    /* renamed from: j */
    public final Set<Future<?>> f1049j;

    /* renamed from: k */
    public int f1050k;

    /* renamed from: l */
    public AtomicInteger f1051l;

    /* loaded from: classes.dex */
    public interface zza {
    }

    public WakeLock(@NonNull Context context, int i, @NonNull String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    public WakeLock(@NonNull Context context, int i, @NonNull String str, @Nullable String str2, @NonNull String str3) {
        this(context, i, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(@NonNull Context context, int i, @NonNull String str, @Nullable String str2, @NonNull String str3, @Nullable String str4) {
        this.f1040a = this;
        this.f1047h = true;
        this.f1048i = new HashMap();
        this.f1049j = Collections.synchronizedSet(new HashSet());
        this.f1051l = new AtomicInteger(0);
        C0813ca.m2730l(context, "WakeLock: context must not be null");
        C0813ca.m2726h(str, "WakeLock: wakeLockName must not be empty");
        this.f1043d = i;
        this.f1045f = null;
        Context applicationContext = context.getApplicationContext();
        this.f1046g = applicationContext;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f1044e = str;
        } else {
            String valueOf = String.valueOf(str);
            this.f1044e = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        this.f1041b = newWakeLock;
        if (C1698pc.m7306c(context)) {
            WorkSource m7304a = C1698pc.m7304a(context, C1599nc.m6663a(str3) ? context.getPackageName() : str3);
            this.f1042c = m7304a;
            if (m7304a != null && C1698pc.m7306c(applicationContext)) {
                WorkSource workSource = this.f1042c;
                if (workSource != null) {
                    workSource.add(m7304a);
                } else {
                    this.f1042c = m7304a;
                }
                try {
                    newWakeLock.setWorkSource(this.f1042c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    Log.wtf("WakeLock", e.toString());
                }
            }
        }
        if (f1039m == null) {
            f1039m = PooledExecutorsProvider.m1142a().mo1143a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        com.sonelli.C2211wb.m9459a().m9463c(r13.f1046g, com.sonelli.C2163vb.m9207a(r13.f1041b, r6), 7, r13.f1044e, r6, null, r13.f1043d, m1517f(), r14);
        r13.f1050k++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r13.f1050k == 0) goto L22;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m1512a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.f1051l
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.m1516e(r0)
            java.lang.Object r0 = r13.f1040a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f1048i     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.f1050k     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.f1041b     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f1048i     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.f1050k = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.f1047h     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f1048i     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f1048i     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = r12
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.f1047h     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.f1050k     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            com.sonelli.wb r1 = com.sonelli.C2211wb.m9459a()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.f1046g     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.f1041b     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = com.sonelli.C2163vb.m9207a(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.f1044e     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.f1043d     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.m1517f()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.m9463c(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.f1050k     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.f1050k = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.f1041b
            r0.acquire()
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = com.google.android.gms.stats.WakeLock.f1039m
            com.sonelli.i50 r1 = new com.sonelli.i50
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.m1512a(long):void");
    }

    /* renamed from: b */
    public boolean m1513b() {
        return this.f1041b.isHeld();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
    
        if (r1 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        com.sonelli.C2211wb.m9459a().m9462b(r12.f1046g, com.sonelli.C2163vb.m9207a(r12.f1041b, r6), 8, r12.f1044e, r6, null, r12.f1043d, m1517f());
        r12.f1050k--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r12.f1050k == 1) goto L21;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m1514c() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f1051l
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L19
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.f1044e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L19:
            r0 = 0
            java.lang.String r6 = r12.m1516e(r0)
            java.lang.Object r0 = r12.f1040a
            monitor-enter(r0)
            boolean r1 = r12.f1047h     // Catch: java.lang.Throwable -> L7e
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L52
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f1048i     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L33
        L31:
            r1 = r11
            goto L50
        L33:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r2 != r10) goto L42
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f1048i     // Catch: java.lang.Throwable -> L7e
            r1.remove(r6)     // Catch: java.lang.Throwable -> L7e
            r1 = r10
            goto L50
        L42:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7e
            r1[r11] = r2     // Catch: java.lang.Throwable -> L7e
            goto L31
        L50:
            if (r1 != 0) goto L5a
        L52:
            boolean r1 = r12.f1047h     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L79
            int r1 = r12.f1050k     // Catch: java.lang.Throwable -> L7e
            if (r1 != r10) goto L79
        L5a:
            com.sonelli.wb r1 = com.sonelli.C2211wb.m9459a()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = r12.f1046g     // Catch: java.lang.Throwable -> L7e
            android.os.PowerManager$WakeLock r3 = r12.f1041b     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = com.sonelli.C2163vb.m9207a(r3, r6)     // Catch: java.lang.Throwable -> L7e
            r4 = 8
            java.lang.String r5 = r12.f1044e     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            int r8 = r12.f1043d     // Catch: java.lang.Throwable -> L7e
            java.util.List r9 = r12.m1517f()     // Catch: java.lang.Throwable -> L7e
            r1.m9462b(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e
            int r1 = r12.f1050k     // Catch: java.lang.Throwable -> L7e
            int r1 = r1 - r10
            r12.f1050k = r1     // Catch: java.lang.Throwable -> L7e
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r12.m1518g(r11)
            return
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.m1514c():void");
    }

    /* renamed from: d */
    public void m1515d(boolean z) {
        this.f1041b.setReferenceCounted(z);
        this.f1047h = z;
    }

    /* renamed from: e */
    public final String m1516e(String str) {
        return (!this.f1047h || TextUtils.isEmpty(str)) ? this.f1045f : str;
    }

    /* renamed from: f */
    public final List<String> m1517f() {
        return C1698pc.m7305b(this.f1042c);
    }

    /* renamed from: g */
    public final void m1518g(int i) {
        if (this.f1041b.isHeld()) {
            try {
                this.f1041b.release();
            } catch (RuntimeException e) {
                if (!e.getClass().equals(RuntimeException.class)) {
                    throw e;
                }
                Log.e("WakeLock", String.valueOf(this.f1044e).concat(" was already released!"), e);
            }
            this.f1041b.isHeld();
        }
    }
}

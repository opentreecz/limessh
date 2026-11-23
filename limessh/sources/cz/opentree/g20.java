package cz.opentree;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class g20 extends AbstractC0742ay {

    /* renamed from: c */
    public final y20 f2804c;

    /* renamed from: d */
    public zzel f2805d;

    /* renamed from: e */
    public volatile Boolean f2806e;

    /* renamed from: f */
    public final AbstractC1127hu f2807f;

    /* renamed from: g */
    public final r30 f2808g;

    /* renamed from: h */
    public final List<Runnable> f2809h;

    /* renamed from: i */
    public final AbstractC1127hu f2810i;

    public g20(C2144uz c2144uz) {
        super(c2144uz);
        this.f2809h = new ArrayList();
        this.f2808g = new r30(c2144uz.mo1483i());
        this.f2804c = new y20(this);
        this.f2807f = new j20(this, c2144uz);
        this.f2810i = new p20(this, c2144uz);
    }

    /* renamed from: C */
    public static /* synthetic */ zzel m3932C(g20 g20Var, zzel zzelVar) {
        g20Var.f2805d = null;
        return null;
    }

    @Override // cz.opentree.AbstractC0742ay
    /* renamed from: B */
    public final boolean mo1960B() {
        return false;
    }

    @Nullable
    @WorkerThread
    /* renamed from: E */
    public final zzm m3939E(boolean z) {
        mo1480f();
        return m10663r().m7570C(z ? mo1484j().m8531Q() : null);
    }

    @WorkerThread
    /* renamed from: F */
    public final void m3940F(ComponentName componentName) {
        mo7585d();
        if (this.f2805d != null) {
            this.f2805d = null;
            mo1484j().m8530P().m9084b("Disconnected from device MeasurementService", componentName);
            mo7585d();
            m3959Z();
        }
    }

    @WorkerThread
    /* renamed from: G */
    public final void m3941G(zzs zzsVar) {
        mo7585d();
        m2299y();
        m3951R(new l20(this, m3939E(false), zzsVar));
    }

    @WorkerThread
    /* renamed from: H */
    public final void m3942H(zzs zzsVar, zzaq zzaqVar, String str) {
        mo7585d();
        m2299y();
        if (m7588m().m4048v(C0810c7.f1875a) == 0) {
            m3951R(new q20(this, zzaqVar, str, zzsVar));
        } else {
            mo1484j().m8525K().m9083a("Not bundling data. Service unavailable or out of date");
            m7588m().m4035U(zzsVar, new byte[0]);
        }
    }

    @WorkerThread
    /* renamed from: I */
    public final void m3943I(zzs zzsVar, String str, String str2) {
        mo7585d();
        m2299y();
        m3951R(new x20(this, str, str2, m3939E(false), zzsVar));
    }

    @WorkerThread
    /* renamed from: J */
    public final void m3944J(zzs zzsVar, String str, String str2, boolean z) {
        mo7585d();
        m2299y();
        m3951R(new z20(this, str, str2, z, m3939E(false), zzsVar));
    }

    @WorkerThread
    /* renamed from: K */
    public final void m3945K(zzaq zzaqVar, String str) {
        C0813ca.m2729k(zzaqVar);
        mo7585d();
        m2299y();
        boolean m3963d0 = m3963d0();
        m3951R(new r20(this, m3963d0, m3963d0 && m10666u().m7123F(zzaqVar), zzaqVar, m3939E(true), str));
    }

    @WorkerThread
    /* renamed from: L */
    public final void m3946L(zzel zzelVar) {
        mo7585d();
        C0813ca.m2729k(zzelVar);
        this.f2805d = zzelVar;
        m3964e0();
        m3967h0();
    }

    @WorkerThread
    /* renamed from: M */
    public final void m3947M(zzel zzelVar, AbstractSafeParcelable abstractSafeParcelable, zzm zzmVar) {
        int i;
        List<AbstractSafeParcelable> m7121D;
        mo7585d();
        mo7583b();
        m2299y();
        boolean m3963d0 = m3963d0();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!m3963d0 || (m7121D = m10666u().m7121D(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(m7121D);
                i = m7121D.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzaq) {
                    try {
                        zzelVar.mo1468L0((zzaq) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e) {
                        mo1484j().m8522H().m9084b("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkn) {
                    try {
                        zzelVar.mo1475h0((zzkn) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e2) {
                        mo1484j().m8522H().m9084b("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzy) {
                    try {
                        zzelVar.mo1467H((zzy) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e3) {
                        mo1484j().m8522H().m9084b("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    mo1484j().m8522H().m9083a("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    @WorkerThread
    /* renamed from: N */
    public final void m3948N(b20 b20Var) {
        mo7585d();
        m2299y();
        m3951R(new n20(this, b20Var));
    }

    @WorkerThread
    /* renamed from: P */
    public final void m3949P(zzkn zzknVar) {
        mo7585d();
        m2299y();
        m3951R(new i20(this, m3963d0() && m10666u().m7124G(zzknVar), zzknVar, m3939E(true)));
    }

    @WorkerThread
    /* renamed from: Q */
    public final void m3950Q(zzy zzyVar) {
        C0813ca.m2729k(zzyVar);
        mo7585d();
        m2299y();
        mo1480f();
        m3951R(new v20(this, true, m10666u().m7125H(zzyVar), new zzy(zzyVar), m3939E(true), zzyVar));
    }

    @WorkerThread
    /* renamed from: R */
    public final void m3951R(Runnable runnable) throws IllegalStateException {
        mo7585d();
        if (m3955V()) {
            runnable.run();
        } else {
            if (this.f2809h.size() >= 1000) {
                mo1484j().m8522H().m9083a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f2809h.add(runnable);
            this.f2810i.m4649c(60000L);
            m3959Z();
        }
    }

    @WorkerThread
    /* renamed from: S */
    public final void m3952S(AtomicReference<String> atomicReference) {
        mo7585d();
        m2299y();
        m3951R(new m20(this, atomicReference, m3939E(false)));
    }

    @WorkerThread
    /* renamed from: T */
    public final void m3953T(AtomicReference<List<zzy>> atomicReference, String str, String str2, String str3) {
        mo7585d();
        m2299y();
        m3951R(new u20(this, atomicReference, str, str2, str3, m3939E(false)));
    }

    @WorkerThread
    /* renamed from: U */
    public final void m3954U(AtomicReference<List<zzkn>> atomicReference, String str, String str2, String str3, boolean z) {
        mo7585d();
        m2299y();
        m3951R(new w20(this, atomicReference, str, str2, str3, z, m3939E(false)));
    }

    @WorkerThread
    /* renamed from: V */
    public final boolean m3955V() {
        mo7585d();
        m2299y();
        return this.f2805d != null;
    }

    @WorkerThread
    /* renamed from: W */
    public final void m3956W() {
        mo7585d();
        m2299y();
        m3951R(new t20(this, m3939E(true)));
    }

    @WorkerThread
    /* renamed from: X */
    public final void m3957X() {
        mo7585d();
        mo7583b();
        m2299y();
        zzm m3939E = m3939E(false);
        if (m3963d0()) {
            m10666u().m7126I();
        }
        m3951R(new k20(this, m3939E));
    }

    @WorkerThread
    /* renamed from: Y */
    public final void m3958Y() {
        mo7585d();
        m2299y();
        zzm m3939E = m3939E(true);
        m10666u().m7127J();
        m3951R(new o20(this, m3939E));
    }

    @WorkerThread
    /* renamed from: Z */
    public final void m3959Z() {
        mo7585d();
        m2299y();
        if (m3955V()) {
            return;
        }
        if (m3965f0()) {
            this.f2804c.m10054d();
            return;
        }
        if (m7590o().m2622R()) {
            return;
        }
        mo1480f();
        List<ResolveInfo> queryIntentServices = mo1482h().getPackageManager().queryIntentServices(new Intent().setClassName(mo1482h(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!(queryIntentServices != null && queryIntentServices.size() > 0)) {
            mo1484j().m8522H().m9083a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context mo1482h = mo1482h();
        mo1480f();
        intent.setComponent(new ComponentName(mo1482h, "com.google.android.gms.measurement.AppMeasurementService"));
        this.f2804c.m10053b(intent);
    }

    /* renamed from: a0 */
    public final Boolean m3960a0() {
        return this.f2806e;
    }

    @WorkerThread
    /* renamed from: b0 */
    public final void m3961b0() {
        mo7585d();
        m2299y();
        this.f2804c.m10052a();
        try {
            C1926tb.m8637b().m8639c(mo1482h(), this.f2804c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f2805d = null;
    }

    @WorkerThread
    /* renamed from: c0 */
    public final boolean m3962c0() {
        mo7585d();
        m2299y();
        return !m3965f0() || m7588m().m4022J0() >= 200900;
    }

    /* renamed from: d0 */
    public final boolean m3963d0() {
        mo1480f();
        return true;
    }

    @WorkerThread
    /* renamed from: e0 */
    public final void m3964e0() {
        mo7585d();
        this.f2808g.m7856a();
        this.f2807f.m4649c(C1735pu.f5798K.m6320a(null).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f8  */
    @androidx.annotation.WorkerThread
    /* renamed from: f0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m3965f0() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.g20.m3965f0():boolean");
    }

    @WorkerThread
    /* renamed from: g0 */
    public final void m3966g0() {
        mo7585d();
        if (m3955V()) {
            mo1484j().m8530P().m9083a("Inactivity, disconnecting from the service");
            m3961b0();
        }
    }

    @WorkerThread
    /* renamed from: h0 */
    public final void m3967h0() {
        mo7585d();
        mo1484j().m8530P().m9084b("Processing queued up service tasks", Integer.valueOf(this.f2809h.size()));
        Iterator<Runnable> it = this.f2809h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                mo1484j().m8522H().m9084b("Task exception while flushing queue", e);
            }
        }
        this.f2809h.clear();
        this.f2810i.m4651e();
    }
}

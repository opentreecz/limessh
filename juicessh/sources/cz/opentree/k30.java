package cz.opentree;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class k30 extends AbstractC0742ay {

    /* renamed from: c */
    public Handler f4449c;

    /* renamed from: d */
    public final t30 f4450d;

    /* renamed from: e */
    public final q30 f4451e;

    /* renamed from: f */
    public final l30 f4452f;

    public k30(C2144uz c2144uz) {
        super(c2144uz);
        this.f4450d = new t30(this);
        this.f4451e = new q30(this);
        this.f4452f = new l30(this);
    }

    @Override // cz.opentree.AbstractC0742ay
    /* renamed from: B */
    public final boolean mo1960B() {
        return false;
    }

    @WorkerThread
    /* renamed from: C */
    public final void m5798C(long j) {
        mo7585d();
        m5800G();
        mo1484j().m8530P().m9084b("Activity resumed, time", Long.valueOf(j));
        if (m7590o().m2630u(C1735pu.f5789F0)) {
            if (m7590o().m2619M().booleanValue() || m7589n().f2579x.m4292b()) {
                this.f4451e.m7609b(j);
            }
            this.f4452f.m6048a();
        } else {
            this.f4452f.m6048a();
            if (m7590o().m2619M().booleanValue()) {
                this.f4451e.m7609b(j);
            }
        }
        t30 t30Var = this.f4450d;
        t30Var.f6705a.mo7585d();
        if (t30Var.f6705a.f5899a.m9122q()) {
            if (!t30Var.f6705a.m7590o().m2630u(C1735pu.f5789F0)) {
                t30Var.f6705a.m7589n().f2579x.m4291a(false);
            }
            t30Var.m8588b(t30Var.f6705a.mo1483i().mo1177a(), false);
        }
    }

    /* renamed from: F */
    public final boolean m5799F(boolean z, boolean z2, long j) {
        return this.f4451e.m7610d(z, z2, j);
    }

    @WorkerThread
    /* renamed from: G */
    public final void m5800G() {
        mo7585d();
        if (this.f4449c == null) {
            this.f4449c = new HandlerC2028us(Looper.getMainLooper());
        }
    }

    @WorkerThread
    /* renamed from: I */
    public final void m5801I(long j) {
        mo7585d();
        m5800G();
        mo1484j().m8530P().m9084b("Activity paused, time", Long.valueOf(j));
        this.f4452f.m6049b(j);
        if (m7590o().m2619M().booleanValue()) {
            this.f4451e.m7612f(j);
        }
        t30 t30Var = this.f4450d;
        if (t30Var.f6705a.m7590o().m2630u(C1735pu.f5789F0)) {
            return;
        }
        t30Var.f6705a.m7589n().f2579x.m4291a(true);
    }
}

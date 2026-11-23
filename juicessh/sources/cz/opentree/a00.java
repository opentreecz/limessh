package cz.opentree;

import android.os.Binder;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class a00 extends AbstractBinderC1625ny {

    /* renamed from: a */
    public final z30 f1301a;

    /* renamed from: b */
    public Boolean f1302b;

    /* renamed from: c */
    @Nullable
    public String f1303c;

    public a00(z30 z30Var) {
        this(z30Var, null);
    }

    public a00(z30 z30Var, @Nullable String str) {
        C0813ca.m2729k(z30Var);
        this.f1301a = z30Var;
        this.f1303c = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: E */
    public final List<zzkn> mo1463E(zzm zzmVar, boolean z) {
        m1945Q0(zzmVar, false);
        try {
            List<h40> list = (List) this.f1301a.mo1481g().m8286x(new m00(this, zzmVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (h40 h40Var : list) {
                if (z || !g40.m3984B0(h40Var.f3102c)) {
                    arrayList.add(new zzkn(h40Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f1301a.mo1484j().m8522H().m9085c("Failed to get user properties. appId", C1889sy.m8516y(zzmVar.f997O), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: F */
    public final void mo1464F(zzaq zzaqVar, String str, String str2) {
        C0813ca.m2729k(zzaqVar);
        C0813ca.m2725g(str);
        m1943O0(str, true);
        m1946s(new h00(this, zzaqVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: G */
    public final List<zzkn> mo1465G(String str, String str2, String str3, boolean z) {
        m1943O0(str, true);
        try {
            List<h40> list = (List) this.f1301a.mo1481g().m8286x(new e00(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (h40 h40Var : list) {
                if (z || !g40.m3984B0(h40Var.f3102c)) {
                    arrayList.add(new zzkn(h40Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f1301a.mo1484j().m8522H().m9085c("Failed to get user properties as. appId", C1889sy.m8516y(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: G0 */
    public final void mo1466G0(zzm zzmVar) {
        m1945Q0(zzmVar, false);
        m1946s(new l00(this, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: H */
    public final void mo1467H(zzy zzyVar, zzm zzmVar) {
        C0813ca.m2729k(zzyVar);
        C0813ca.m2729k(zzyVar.f1021Q);
        m1945Q0(zzmVar, false);
        zzy zzyVar2 = new zzy(zzyVar);
        zzyVar2.f1019O = zzmVar.f997O;
        m1946s(new n00(this, zzyVar2, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: L0 */
    public final void mo1468L0(zzaq zzaqVar, zzm zzmVar) {
        C0813ca.m2729k(zzaqVar);
        m1945Q0(zzmVar, false);
        m1946s(new i00(this, zzaqVar, zzmVar));
    }

    @BinderThread
    /* renamed from: O0 */
    public final void m1943O0(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            this.f1301a.mo1484j().m8522H().m9083a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.f1302b == null) {
                    if (!"com.google.android.gms".equals(this.f1303c) && !C1649oc.m7010a(this.f1301a.mo1482h(), Binder.getCallingUid()) && !C0862d7.m3159a(this.f1301a.mo1482h()).m3163c(Binder.getCallingUid())) {
                        z2 = false;
                        this.f1302b = Boolean.valueOf(z2);
                    }
                    z2 = true;
                    this.f1302b = Boolean.valueOf(z2);
                }
                if (this.f1302b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.f1301a.mo1484j().m8522H().m9084b("Measurement Service called with invalid calling package. appId", C1889sy.m8516y(str));
                throw e;
            }
        }
        if (this.f1303c == null && C0810c7.m2686k(this.f1301a.mo1482h(), Binder.getCallingUid(), str)) {
            this.f1303c = str;
        }
        if (str.equals(this.f1303c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: P */
    public final void mo1469P(zzm zzmVar) {
        m1943O0(zzmVar.f997O, false);
        m1946s(new f00(this, zzmVar));
    }

    /* renamed from: P0 */
    public final zzaq m1944P0(zzaq zzaqVar, zzm zzmVar) {
        zzal zzalVar;
        boolean z = false;
        if ("_cmp".equals(zzaqVar.f986O) && (zzalVar = zzaqVar.f987P) != null && zzalVar.m1461x() != 0) {
            String m1460c0 = zzaqVar.f987P.m1460c0("_cis");
            if (!TextUtils.isEmpty(m1460c0) && (("referrer broadcast".equals(m1460c0) || "referrer API".equals(m1460c0)) && this.f1301a.m10343H().m2610D(zzmVar.f997O, C1735pu.f5816T))) {
                z = true;
            }
        }
        if (!z) {
            return zzaqVar;
        }
        this.f1301a.mo1484j().m8528N().m9084b("Event has been filtered ", zzaqVar.toString());
        return new zzaq("_cmpx", zzaqVar.f987P, zzaqVar.f988Q, zzaqVar.f989R);
    }

    @BinderThread
    /* renamed from: Q0 */
    public final void m1945Q0(zzm zzmVar, boolean z) {
        C0813ca.m2729k(zzmVar);
        m1943O0(zzmVar.f997O, false);
        this.f1301a.m10362a0().m4042h0(zzmVar.f998P, zzmVar.f1014f0, zzmVar.f1018j0);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: R */
    public final List<zzy> mo1470R(String str, String str2, zzm zzmVar) {
        m1945Q0(zzmVar, false);
        try {
            return (List) this.f1301a.mo1481g().m8286x(new d00(this, zzmVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f1301a.mo1484j().m8522H().m9084b("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: X */
    public final void mo1471X(zzy zzyVar) {
        C0813ca.m2729k(zzyVar);
        C0813ca.m2729k(zzyVar.f1021Q);
        m1943O0(zzyVar.f1019O, true);
        m1946s(new c00(this, new zzy(zzyVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: Y */
    public final List<zzkn> mo1472Y(String str, String str2, boolean z, zzm zzmVar) {
        m1945Q0(zzmVar, false);
        try {
            List<h40> list = (List) this.f1301a.mo1481g().m8286x(new b00(this, zzmVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (h40 h40Var : list) {
                if (z || !g40.m3984B0(h40Var.f3102c)) {
                    arrayList.add(new zzkn(h40Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f1301a.mo1484j().m8522H().m9085c("Failed to query user properties. appId", C1889sy.m8516y(zzmVar.f997O), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: a0 */
    public final void mo1473a0(long j, String str, String str2, String str3) {
        m1946s(new o00(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: c0 */
    public final List<zzy> mo1474c0(String str, String str2, String str3) {
        m1943O0(str, true);
        try {
            return (List) this.f1301a.mo1481g().m8286x(new g00(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f1301a.mo1484j().m8522H().m9084b("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: h0 */
    public final void mo1475h0(zzkn zzknVar, zzm zzmVar) {
        C0813ca.m2729k(zzknVar);
        m1945Q0(zzmVar, false);
        m1946s(new j00(this, zzknVar, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: o0 */
    public final void mo1476o0(zzm zzmVar) {
        m1945Q0(zzmVar, false);
        m1946s(new RunnableC2447zz(this, zzmVar));
    }

    /* renamed from: s */
    public final void m1946s(Runnable runnable) {
        C0813ca.m2729k(runnable);
        if (this.f1301a.mo1481g().m8284I()) {
            runnable.run();
        } else {
            this.f1301a.mo1481g().m8281A(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: v */
    public final byte[] mo1477v(zzaq zzaqVar, String str) {
        C0813ca.m2725g(str);
        C0813ca.m2729k(zzaqVar);
        m1943O0(str, true);
        this.f1301a.mo1484j().m8529O().m9084b("Log and bundle. event", this.f1301a.m10360Z().m7809x(zzaqVar.f986O));
        long mo1179c = this.f1301a.mo1483i().mo1179c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f1301a.mo1481g().m8282C(new k00(this, zzaqVar, str)).get();
            if (bArr == null) {
                this.f1301a.mo1484j().m8522H().m9084b("Log and bundle returned null. appId", C1889sy.m8516y(str));
                bArr = new byte[0];
            }
            this.f1301a.mo1484j().m8529O().m9086d("Log and bundle processed. event, size, time_ms", this.f1301a.m10360Z().m7809x(zzaqVar.f986O), Integer.valueOf(bArr.length), Long.valueOf((this.f1301a.mo1483i().mo1179c() / 1000000) - mo1179c));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.f1301a.mo1484j().m8522H().m9086d("Failed to log and bundle. appId, event, error", C1889sy.m8516y(str), this.f1301a.m10360Z().m7809x(zzaqVar.f986O), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    @BinderThread
    /* renamed from: v0 */
    public final String mo1478v0(zzm zzmVar) {
        m1945Q0(zzmVar, false);
        return this.f1301a.m10354T(zzmVar);
    }
}

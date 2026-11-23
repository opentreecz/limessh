package cz.opentree;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.measurement.internal.zzac;
import cz.opentree.C1046gk;
import cz.opentree.C1113hk;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.qz */
/* loaded from: classes.dex */
public final class C1792qz extends w30 implements zzac {

    /* renamed from: j */
    public static int f6133j = 65535;

    /* renamed from: k */
    public static int f6134k = 2;

    /* renamed from: d */
    public final Map<String, Map<String, String>> f6135d;

    /* renamed from: e */
    public final Map<String, Map<String, Boolean>> f6136e;

    /* renamed from: f */
    public final Map<String, Map<String, Boolean>> f6137f;

    /* renamed from: g */
    public final Map<String, C1113hk> f6138g;

    /* renamed from: h */
    public final Map<String, Map<String, Integer>> f6139h;

    /* renamed from: i */
    public final Map<String, String> f6140i;

    public C1792qz(z30 z30Var) {
        super(z30Var);
        this.f6135d = new ArrayMap();
        this.f6136e = new ArrayMap();
        this.f6137f = new ArrayMap();
        this.f6138g = new ArrayMap();
        this.f6140i = new ArrayMap();
        this.f6139h = new ArrayMap();
    }

    /* renamed from: y */
    public static Map<String, String> m7814y(C1113hk c1113hk) {
        ArrayMap arrayMap = new ArrayMap();
        if (c1113hk != null) {
            for (C1164ik c1164ik : c1113hk.m4470M()) {
                arrayMap.put(c1164ik.m4785D(), c1164ik.m4786E());
            }
        }
        return arrayMap;
    }

    @WorkerThread
    /* renamed from: A */
    public final boolean m7815A(String str, byte[] bArr, String str2) {
        m9404t();
        mo7585d();
        C0813ca.m2725g(str);
        C1113hk.a m9840z = m7828x(str, bArr).m9840z();
        if (m9840z == null) {
            return false;
        }
        m7829z(str, m9840z);
        this.f6138g.put(str, (C1113hk) ((AbstractC2303xn) m9840z.mo1259f()));
        this.f6140i.put(str, str2);
        this.f6135d.put(str, m7814y((C1113hk) ((AbstractC2303xn) m9840z.mo1259f())));
        m9687q().m3011P(str, new ArrayList(m9840z.m4479z()));
        try {
            m9840z.m4475A();
            bArr = ((C1113hk) ((AbstractC2303xn) m9840z.mo1259f())).m5946k();
        } catch (RuntimeException e) {
            mo1484j().m8525K().m9085c("Unable to serialize reduced-size config. Storing full config instead. appId", C1889sy.m8516y(str), e);
        }
        C0845cu m9687q = m9687q();
        C0813ca.m2725g(str);
        m9687q.mo7585d();
        m9687q.m9404t();
        new ContentValues().put("remote_config", bArr);
        try {
            if (m9687q.m3038x().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                m9687q.mo1484j().m8522H().m9084b("Failed to update remote config (got 0). appId", C1889sy.m8516y(str));
            }
        } catch (SQLiteException e2) {
            m9687q.mo1484j().m8522H().m9085c("Error storing remote config. appId", C1889sy.m8516y(str), e2);
        }
        this.f6138g.put(str, (C1113hk) ((AbstractC2303xn) m9840z.mo1259f()));
        return true;
    }

    @WorkerThread
    /* renamed from: B */
    public final String m7816B(String str) {
        mo7585d();
        return this.f6140i.get(str);
    }

    @WorkerThread
    /* renamed from: C */
    public final boolean m7817C(String str, String str2) {
        Boolean bool;
        mo7585d();
        m7826L(str);
        if (m7824J(str) && g40.m3984B0(str2)) {
            return true;
        }
        if (m7825K(str) && g40.m3996c0(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f6136e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    /* renamed from: D */
    public final void m7818D(String str) {
        mo7585d();
        this.f6140i.put(str, null);
    }

    @WorkerThread
    /* renamed from: E */
    public final boolean m7819E(String str, String str2) {
        Boolean bool;
        mo7585d();
        m7826L(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        if (C1069gr.m4250b() && m7590o().m2630u(C1735pu.f5801L0) && ("purchase".equals(str2) || "refund".equals(str2))) {
            return true;
        }
        Map<String, Boolean> map = this.f6137f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    /* renamed from: F */
    public final int m7820F(String str, String str2) {
        Integer num;
        mo7585d();
        m7826L(str);
        Map<String, Integer> map = this.f6139h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @WorkerThread
    /* renamed from: G */
    public final void m7821G(String str) {
        mo7585d();
        this.f6138g.remove(str);
    }

    @WorkerThread
    /* renamed from: H */
    public final boolean m7822H(String str) {
        mo7585d();
        C1113hk m7827w = m7827w(str);
        if (m7827w == null) {
            return false;
        }
        return m7827w.m4473P();
    }

    @WorkerThread
    /* renamed from: I */
    public final long m7823I(String str) {
        String mo1452k = mo1452k(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(mo1452k)) {
            return 0L;
        }
        try {
            return Long.parseLong(mo1452k);
        } catch (NumberFormatException e) {
            mo1484j().m8525K().m9085c("Unable to parse timezone offset. appId", C1889sy.m8516y(str), e);
            return 0L;
        }
    }

    /* renamed from: J */
    public final boolean m7824J(String str) {
        return "1".equals(mo1452k(str, "measurement.upload.blacklist_internal"));
    }

    /* renamed from: K */
    public final boolean m7825K(String str) {
        return "1".equals(mo1452k(str, "measurement.upload.blacklist_public"));
    }

    @WorkerThread
    /* renamed from: L */
    public final void m7826L(String str) {
        m9404t();
        mo7585d();
        C0813ca.m2725g(str);
        if (this.f6138g.get(str) == null) {
            byte[] m3030q0 = m9687q().m3030q0(str);
            if (m3030q0 != null) {
                C1113hk.a m9840z = m7828x(str, m3030q0).m9840z();
                m7829z(str, m9840z);
                this.f6135d.put(str, m7814y((C1113hk) ((AbstractC2303xn) m9840z.mo1259f())));
                this.f6138g.put(str, (C1113hk) ((AbstractC2303xn) m9840z.mo1259f()));
                this.f6140i.put(str, null);
                return;
            }
            this.f6135d.put(str, null);
            this.f6136e.put(str, null);
            this.f6137f.put(str, null);
            this.f6138g.put(str, null);
            this.f6140i.put(str, null);
            this.f6139h.put(str, null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzac
    @WorkerThread
    /* renamed from: k */
    public final String mo1452k(String str, String str2) {
        mo7585d();
        m7826L(str);
        Map<String, String> map = this.f6135d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // cz.opentree.w30
    /* renamed from: v */
    public final boolean mo2315v() {
        return false;
    }

    @WorkerThread
    /* renamed from: w */
    public final C1113hk m7827w(String str) {
        m9404t();
        mo7585d();
        C0813ca.m2725g(str);
        m7826L(str);
        return this.f6138g.get(str);
    }

    @WorkerThread
    /* renamed from: x */
    public final C1113hk m7828x(String str, byte[] bArr) {
        if (bArr == null) {
            return C1113hk.m4462R();
        }
        try {
            C1113hk c1113hk = (C1113hk) ((AbstractC2303xn) ((C1113hk.a) d40.m3120A(C1113hk.m4461Q(), bArr)).mo1259f());
            mo1484j().m8530P().m9085c("Parsed config. version, gmp_app_id", c1113hk.m4466H() ? Long.valueOf(c1113hk.m4467I()) : null, c1113hk.m4468J() ? c1113hk.m4469L() : null);
            return c1113hk;
        } catch (C0839co e) {
            mo1484j().m8525K().m9085c("Unable to merge remote config. appId", C1889sy.m8516y(str), e);
            return C1113hk.m4462R();
        } catch (RuntimeException e2) {
            mo1484j().m8525K().m9085c("Unable to merge remote config. appId", C1889sy.m8516y(str), e2);
            return C1113hk.m4462R();
        }
    }

    /* renamed from: z */
    public final void m7829z(String str, C1113hk.a aVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (aVar != null) {
            for (int i = 0; i < aVar.m4476v(); i++) {
                C1046gk.a m9840z = aVar.m4477w(i).m9840z();
                if (TextUtils.isEmpty(m9840z.m4157w())) {
                    mo1484j().m8525K().m9083a("EventConfig contained null event name");
                } else {
                    String m8562b = t00.m8562b(m9840z.m4157w());
                    if (!TextUtils.isEmpty(m8562b)) {
                        m9840z.m4156v(m8562b);
                        aVar.m4478y(i, m9840z);
                    }
                    arrayMap.put(m9840z.m4157w(), Boolean.valueOf(m9840z.m4158y()));
                    arrayMap2.put(m9840z.m4157w(), Boolean.valueOf(m9840z.m4159z()));
                    if (m9840z.m4154A()) {
                        if (m9840z.m4155B() < f6134k || m9840z.m4155B() > f6133j) {
                            mo1484j().m8525K().m9085c("Invalid sampling rate. Event name, sample rate", m9840z.m4157w(), Integer.valueOf(m9840z.m4155B()));
                        } else {
                            arrayMap3.put(m9840z.m4157w(), Integer.valueOf(m9840z.m4155B()));
                        }
                    }
                }
            }
        }
        this.f6136e.put(str, arrayMap);
        this.f6137f.put(str, arrayMap2);
        this.f6139h.put(str, arrayMap3);
    }
}

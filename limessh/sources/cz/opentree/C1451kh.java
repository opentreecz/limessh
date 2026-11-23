package cz.opentree;

import java.util.Map;

/* renamed from: cz.opentree.kh */
/* loaded from: classes.dex */
public class C1451kh extends AbstractC2006uf {

    /* renamed from: Q */
    public static C1451kh f4538Q;

    public C1451kh(C2216wf c2216wf) {
        super(c2216wf);
    }

    /* renamed from: J0 */
    public static String m5887J0(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (!(obj instanceof Long)) {
            return obj instanceof Boolean ? String.valueOf(obj) : obj instanceof Throwable ? obj.getClass().getCanonicalName() : "-";
        }
        Long l = (Long) obj;
        if (Math.abs(l.longValue()) < 100) {
            return String.valueOf(obj);
        }
        String str = String.valueOf(obj).charAt(0) != '-' ? "" : "-";
        String valueOf = String.valueOf(Math.abs(l.longValue()));
        return str + Math.round(Math.pow(10.0d, valueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
    }

    /* renamed from: K0 */
    public static C1451kh m5888K0() {
        return f4538Q;
    }

    @Override // cz.opentree.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        synchronized (C1451kh.class) {
            f4538Q = this;
        }
    }

    /* renamed from: G0 */
    public final void m5889G0(C1043gh c1043gh, String str) {
        String c1043gh2 = c1043gh != null ? c1043gh.toString() : "no hit data";
        String valueOf = String.valueOf(str);
        m8672t0(valueOf.length() != 0 ? "Discarding hit. ".concat(valueOf) : new String("Discarding hit. "), c1043gh2);
    }

    /* renamed from: H0 */
    public final void m5890H0(Map<String, String> map, String str) {
        String str2;
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            str2 = sb.toString();
        } else {
            str2 = "no hit data";
        }
        String valueOf = String.valueOf(str);
        m8672t0(valueOf.length() != 0 ? "Discarding hit. ".concat(valueOf) : new String("Discarding hit. "), str2);
    }

    /* renamed from: I0 */
    public final synchronized void m5891I0(int i, String str, Object obj, Object obj2, Object obj3) {
        C0813ca.m2729k(str);
        if (i < 0) {
            i = 0;
        }
        if (i >= 9) {
            i = 8;
        }
        char c = m8661i0().m8889a() ? 'C' : 'c';
        char charAt = "01VDIWEA?".charAt(i);
        String str2 = C2167vf.f7453a;
        String m8647c0 = C1930tf.m8647c0(str, m5887J0(obj), m5887J0(obj2), m5887J0(obj3));
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(m8647c0).length());
        sb.append("3");
        sb.append(charAt);
        sb.append(c);
        sb.append(str2);
        sb.append(":");
        sb.append(m8647c0);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = sb2.substring(0, 1024);
        }
        C1654oh m9489q = m8658f0().m9489q();
        if (m9489q != null) {
            m9489q.m7040M0().m7703a(sb2);
        }
    }
}

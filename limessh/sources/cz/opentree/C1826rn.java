package cz.opentree;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzgy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.rn */
/* loaded from: classes.dex */
public final class C1826rn<T extends zzfd<T>> {

    /* renamed from: d */
    public static final C1826rn f6261d = new C1826rn(true);

    /* renamed from: a */
    public final C1468kp<T, Object> f6262a;

    /* renamed from: b */
    public boolean f6263b;

    /* renamed from: c */
    public boolean f6264c;

    public C1826rn() {
        this.f6262a = C1468kp.m5971b(16);
    }

    public C1826rn(C1468kp<T, Object> c1468kp) {
        this.f6262a = c1468kp;
        m8210k();
    }

    public C1826rn(boolean z) {
        this(C1468kp.m5971b(0));
        m8210k();
    }

    /* renamed from: a */
    public static int m8199a(zzfd<?> zzfdVar, Object obj) {
        EnumC1616nq mo1227b = zzfdVar.mo1227b();
        int mo1226a = zzfdVar.mo1226a();
        if (!zzfdVar.mo1229d()) {
            return m8200b(mo1227b, mo1226a, obj);
        }
        int i = 0;
        if (zzfdVar.mo1230e()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                i += m8206j(mo1227b, it.next());
            }
            return AbstractC1116hn.m4518h0(mo1226a) + i + AbstractC1116hn.m4497E0(i);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            i += m8200b(mo1227b, mo1226a, it2.next());
        }
        return i;
    }

    /* renamed from: b */
    public static int m8200b(EnumC1616nq enumC1616nq, int i, Object obj) {
        int m4518h0 = AbstractC1116hn.m4518h0(i);
        if (enumC1616nq == EnumC1616nq.f5339Z) {
            C2435zn.m10541g((zzgt) obj);
            m4518h0 <<= 1;
        }
        return m4518h0 + m8206j(enumC1616nq, obj);
    }

    /* renamed from: c */
    public static <T extends zzfd<T>> C1826rn<T> m8201c() {
        return f6261d;
    }

    /* renamed from: e */
    public static Object m8202e(Object obj) {
        if (obj instanceof zzgy) {
            return ((zzgy) obj).mo1270a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: f */
    public static void m8203f(AbstractC1116hn abstractC1116hn, EnumC1616nq enumC1616nq, int i, Object obj) throws IOException {
        if (enumC1616nq == EnumC1616nq.f5339Z) {
            zzgt zzgtVar = (zzgt) obj;
            C2435zn.m10541g(zzgtVar);
            abstractC1116hn.mo4558m(i, 3);
            zzgtVar.mo1264c(abstractC1116hn);
            abstractC1116hn.mo4558m(i, 4);
            return;
        }
        abstractC1116hn.mo4558m(i, enumC1616nq.m6768h());
        switch (C1777qn.f6057b[enumC1616nq.ordinal()]) {
            case 1:
                abstractC1116hn.m4552h(((Double) obj).doubleValue());
                return;
            case 2:
                abstractC1116hn.m4553i(((Float) obj).floatValue());
                return;
            case 3:
                abstractC1116hn.mo4565t(((Long) obj).longValue());
                return;
            case 4:
                abstractC1116hn.mo4565t(((Long) obj).longValue());
                return;
            case 5:
                abstractC1116hn.mo4554j(((Integer) obj).intValue());
                return;
            case 6:
                abstractC1116hn.mo4547a0(((Long) obj).longValue());
                return;
            case 7:
                abstractC1116hn.mo4549f0(((Integer) obj).intValue());
                return;
            case 8:
                abstractC1116hn.m4570y(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgt) obj).mo1264c(abstractC1116hn);
                return;
            case 10:
                abstractC1116hn.mo4567v((zzgt) obj);
                return;
            case 11:
                if (obj instanceof AbstractC1939tm) {
                    abstractC1116hn.mo4566u((AbstractC1939tm) obj);
                    return;
                } else {
                    abstractC1116hn.mo4568w((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof AbstractC1939tm) {
                    abstractC1116hn.mo4566u((AbstractC1939tm) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    abstractC1116hn.mo4543T(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                abstractC1116hn.mo4538O(((Integer) obj).intValue());
                return;
            case 14:
                abstractC1116hn.mo4549f0(((Integer) obj).intValue());
                return;
            case 15:
                abstractC1116hn.mo4547a0(((Long) obj).longValue());
                return;
            case 16:
                abstractC1116hn.m4544X(((Integer) obj).intValue());
                return;
            case 17:
                abstractC1116hn.m4542S(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfn) {
                    abstractC1116hn.mo4554j(((zzfn) obj).mo1233a());
                    return;
                } else {
                    abstractC1116hn.mo4554j(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof cz.opentree.C0891do) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfn) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L4;
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m8204h(cz.opentree.EnumC1616nq r2, java.lang.Object r3) {
        /*
            cz.opentree.C2435zn.m10538d(r3)
            int[] r0 = cz.opentree.C1777qn.f6056a
            cz.opentree.qq r2 = r2.m6767f()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = r1
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgt
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof cz.opentree.C0891do
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfn
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof cz.opentree.AbstractC1939tm
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C1826rn.m8204h(cz.opentree.nq, java.lang.Object):void");
    }

    /* renamed from: i */
    public static <T extends zzfd<T>> boolean m8205i(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.mo1228c() == EnumC1780qq.MESSAGE) {
            if (key.mo1229d()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgt) it.next()).mo1268d()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzgt)) {
                    if (value instanceof C0891do) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzgt) value).mo1268d()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: j */
    public static int m8206j(EnumC1616nq enumC1616nq, Object obj) {
        switch (C1777qn.f6057b[enumC1616nq.ordinal()]) {
            case 1:
                return AbstractC1116hn.m4535z(((Double) obj).doubleValue());
            case 2:
                return AbstractC1116hn.m4488A(((Float) obj).floatValue());
            case 3:
                return AbstractC1116hn.m4516e0(((Long) obj).longValue());
            case 4:
                return AbstractC1116hn.m4520j0(((Long) obj).longValue());
            case 5:
                return AbstractC1116hn.m4521l0(((Integer) obj).intValue());
            case 6:
                return AbstractC1116hn.m4528s0(((Long) obj).longValue());
            case 7:
                return AbstractC1116hn.m4533x0(((Integer) obj).intValue());
            case 8:
                return AbstractC1116hn.m4505L(((Boolean) obj).booleanValue());
            case 9:
                return AbstractC1116hn.m4509W((zzgt) obj);
            case 10:
                return obj instanceof C0891do ? AbstractC1116hn.m4513d((C0891do) obj) : AbstractC1116hn.m4503J((zzgt) obj);
            case 11:
                return obj instanceof AbstractC1939tm ? AbstractC1116hn.m4502I((AbstractC1939tm) obj) : AbstractC1116hn.m4504K((String) obj);
            case 12:
                return obj instanceof AbstractC1939tm ? AbstractC1116hn.m4502I((AbstractC1939tm) obj) : AbstractC1116hn.m4506M((byte[]) obj);
            case 13:
                return AbstractC1116hn.m4525p0(((Integer) obj).intValue());
            case 14:
                return AbstractC1116hn.m4489A0(((Integer) obj).intValue());
            case 15:
                return AbstractC1116hn.m4532w0(((Long) obj).longValue());
            case 16:
                return AbstractC1116hn.m4529t0(((Integer) obj).intValue());
            case 17:
                return AbstractC1116hn.m4524o0(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfn ? AbstractC1116hn.m4493C0(((zzfn) obj).mo1233a()) : AbstractC1116hn.m4493C0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: n */
    public static int m8207n(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        return (key.mo1228c() != EnumC1780qq.MESSAGE || key.mo1229d() || key.mo1230e()) ? m8199a(key, value) : value instanceof C0891do ? AbstractC1116hn.m4494D(entry.getKey().mo1226a(), (C0891do) value) : AbstractC1116hn.m4496E(entry.getKey().mo1226a(), (zzgt) value);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C1826rn c1826rn = new C1826rn();
        for (int i = 0; i < this.f6262a.m5981j(); i++) {
            Map.Entry<T, Object> m5979h = this.f6262a.m5979h(i);
            c1826rn.m8211l(m5979h.getKey(), m5979h.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f6262a.m5983m()) {
            c1826rn.m8211l(entry.getKey(), entry.getValue());
        }
        c1826rn.f6264c = this.f6264c;
        return c1826rn;
    }

    /* renamed from: d */
    public final Object m8208d(T t) {
        Object obj = this.f6262a.get(t);
        if (!(obj instanceof C0891do)) {
            return obj;
        }
        C0891do.m3276e();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1826rn) {
            return this.f6262a.equals(((C1826rn) obj).f6262a);
        }
        return false;
    }

    /* renamed from: g */
    public final void m8209g(C1826rn<T> c1826rn) {
        for (int i = 0; i < c1826rn.f6262a.m5981j(); i++) {
            m8212m(c1826rn.f6262a.m5979h(i));
        }
        Iterator<Map.Entry<T, Object>> it = c1826rn.f6262a.m5983m().iterator();
        while (it.hasNext()) {
            m8212m(it.next());
        }
    }

    public final int hashCode() {
        return this.f6262a.hashCode();
    }

    /* renamed from: k */
    public final void m8210k() {
        if (this.f6263b) {
            return;
        }
        this.f6262a.mo5180e();
        this.f6263b = true;
    }

    /* renamed from: l */
    public final void m8211l(T t, Object obj) {
        if (!t.mo1229d()) {
            m8204h(t.mo1227b(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                m8204h(t.mo1227b(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof C0891do) {
            this.f6264c = true;
        }
        this.f6262a.put(t, obj);
    }

    /* renamed from: m */
    public final void m8212m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof C0891do) {
            C0891do.m3276e();
            throw null;
        }
        if (key.mo1229d()) {
            Object m8208d = m8208d(key);
            if (m8208d == null) {
                m8208d = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) m8208d).add(m8202e(it.next()));
            }
            this.f6262a.put(key, m8208d);
            return;
        }
        if (key.mo1228c() != EnumC1780qq.MESSAGE) {
            this.f6262a.put(key, m8202e(value));
            return;
        }
        Object m8208d2 = m8208d(key);
        if (m8208d2 == null) {
            this.f6262a.put(key, m8202e(value));
        } else {
            this.f6262a.put(key, m8208d2 instanceof zzgy ? key.mo1231i((zzgy) m8208d2, (zzgy) value) : key.mo1232j(((zzgt) m8208d2).mo1266i(), (zzgt) value).mo1259f());
        }
    }

    /* renamed from: o */
    public final boolean m8213o() {
        return this.f6263b;
    }

    /* renamed from: p */
    public final Iterator<Map.Entry<T, Object>> m8214p() {
        return this.f6264c ? new C1170io(this.f6262a.entrySet().iterator()) : this.f6262a.entrySet().iterator();
    }

    /* renamed from: q */
    public final Iterator<Map.Entry<T, Object>> m8215q() {
        return this.f6264c ? new C1170io(this.f6262a.m5984o().iterator()) : this.f6262a.m5984o().iterator();
    }

    /* renamed from: r */
    public final boolean m8216r() {
        for (int i = 0; i < this.f6262a.m5981j(); i++) {
            if (!m8205i(this.f6262a.m5979h(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.f6262a.m5983m().iterator();
        while (it.hasNext()) {
            if (!m8205i(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: s */
    public final int m8217s() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6262a.m5981j(); i2++) {
            i += m8207n(this.f6262a.m5979h(i2));
        }
        Iterator<Map.Entry<T, Object>> it = this.f6262a.m5983m().iterator();
        while (it.hasNext()) {
            i += m8207n(it.next());
        }
        return i;
    }
}

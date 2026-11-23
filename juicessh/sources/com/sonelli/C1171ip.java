package com.sonelli;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzix;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.ip */
/* loaded from: classes.dex */
public final class C1171ip {

    /* renamed from: a */
    public static final Class<?> f3387a = m4842F();

    /* renamed from: b */
    public static final AbstractC2238wp<?, ?> f3388b = m4873g(false);

    /* renamed from: c */
    public static final AbstractC2238wp<?, ?> f3389c = m4873g(true);

    /* renamed from: d */
    public static final AbstractC2238wp<?, ?> f3390d = new C2364yp();

    /* renamed from: A */
    public static int m4837A(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1778qo) {
            C1778qo c1778qo = (C1778qo) list;
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4524o0(c1778qo.mo1239d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4524o0(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: B */
    public static AbstractC2238wp<?, ?> m4838B() {
        return f3390d;
    }

    /* renamed from: C */
    public static void m4839C(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1314p(i, list, z);
    }

    /* renamed from: D */
    public static int m4840D(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m4841E(list) + (size * AbstractC1116hn.m4518h0(i));
    }

    /* renamed from: E */
    public static int m4841E(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0724ao) {
            C0724ao c0724ao = (C0724ao) list;
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4493C0(c0724ao.m2167f(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4493C0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: F */
    public static Class<?> m4842F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: G */
    public static void m4843G(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1288E(i, list, z);
    }

    /* renamed from: H */
    public static int m4844H(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m4845I(list) + (size * AbstractC1116hn.m4518h0(i));
    }

    /* renamed from: I */
    public static int m4845I(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0724ao) {
            C0724ao c0724ao = (C0724ao) list;
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4521l0(c0724ao.m2167f(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4521l0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: J */
    public static Class<?> m4846J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: K */
    public static void m4847K(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1285B(i, list, z);
    }

    /* renamed from: L */
    public static int m4848L(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m4849M(list) + (size * AbstractC1116hn.m4518h0(i));
    }

    /* renamed from: M */
    public static int m4849M(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0724ao) {
            C0724ao c0724ao = (C0724ao) list;
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4525p0(c0724ao.m2167f(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4525p0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: N */
    public static void m4850N(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1324z(i, list, z);
    }

    /* renamed from: O */
    public static int m4851O(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m4852P(list) + (size * AbstractC1116hn.m4518h0(i));
    }

    /* renamed from: P */
    public static int m4852P(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0724ao) {
            C0724ao c0724ao = (C0724ao) list;
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4529t0(c0724ao.m2167f(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4529t0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: Q */
    public static void m4853Q(int i, List<Long> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1316r(i, list, z);
    }

    /* renamed from: R */
    public static int m4854R(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * AbstractC1116hn.m4534y0(i, 0);
    }

    /* renamed from: S */
    public static int m4855S(List<?> list) {
        return list.size() << 2;
    }

    /* renamed from: T */
    public static void m4856T(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1309k(i, list, z);
    }

    /* renamed from: U */
    public static int m4857U(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * AbstractC1116hn.m4527r0(i, 0L);
    }

    /* renamed from: V */
    public static int m4858V(List<?> list) {
        return list.size() << 3;
    }

    /* renamed from: W */
    public static void m4859W(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1319u(i, list, z);
    }

    /* renamed from: X */
    public static int m4860X(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * AbstractC1116hn.m4501H(i, true);
    }

    /* renamed from: Y */
    public static int m4861Y(List<?> list) {
        return list.size();
    }

    /* renamed from: Z */
    public static void m4862Z(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1289F(i, list, z);
    }

    /* renamed from: a */
    public static int m4863a(int i, Object obj, zzhi zzhiVar) {
        return obj instanceof C1118ho ? AbstractC1116hn.m4511c(i, (C1118ho) obj) : AbstractC1116hn.m4498F(i, (zzgt) obj, zzhiVar);
    }

    /* renamed from: a0 */
    public static void m4864a0(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1317s(i, list, z);
    }

    /* renamed from: b */
    public static int m4865b(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int m4518h0 = AbstractC1116hn.m4518h0(i) * size;
        if (list instanceof zzga) {
            zzga zzgaVar = (zzga) list;
            while (i2 < size) {
                Object mo1243d = zzgaVar.mo1243d(i2);
                m4518h0 += mo1243d instanceof AbstractC1939tm ? AbstractC1116hn.m4502I((AbstractC1939tm) mo1243d) : AbstractC1116hn.m4504K((String) mo1243d);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                m4518h0 += obj instanceof AbstractC1939tm ? AbstractC1116hn.m4502I((AbstractC1939tm) obj) : AbstractC1116hn.m4504K((String) obj);
                i2++;
            }
        }
        return m4518h0;
    }

    /* renamed from: b0 */
    public static void m4866b0(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1320v(i, list, z);
    }

    /* renamed from: c */
    public static int m4867c(int i, List<?> list, zzhi zzhiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int m4518h0 = AbstractC1116hn.m4518h0(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            m4518h0 += obj instanceof C1118ho ? AbstractC1116hn.m4513d((C1118ho) obj) : AbstractC1116hn.m4515e((zzgt) obj, zzhiVar);
        }
        return m4518h0;
    }

    /* renamed from: c0 */
    public static void m4868c0(int i, List<Integer> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1310l(i, list, z);
    }

    /* renamed from: d */
    public static int m4869d(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return m4871e(list) + (list.size() * AbstractC1116hn.m4518h0(i));
    }

    /* renamed from: d0 */
    public static void m4870d0(int i, List<Boolean> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1305g(i, list, z);
    }

    /* renamed from: e */
    public static int m4871e(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1778qo) {
            C1778qo c1778qo = (C1778qo) list;
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4516e0(c1778qo.mo1239d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4516e0(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: f */
    public static AbstractC2238wp<?, ?> m4872f() {
        return f3388b;
    }

    /* renamed from: g */
    public static AbstractC2238wp<?, ?> m4873g(boolean z) {
        try {
            Class<?> m4846J = m4846J();
            if (m4846J == null) {
                return null;
            }
            return (AbstractC2238wp) m4846J.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: h */
    public static <UT, UB> UB m4874h(int i, int i2, UB ub, AbstractC2238wp<UT, UB> abstractC2238wp) {
        if (ub == null) {
            ub = abstractC2238wp.mo9609a();
        }
        abstractC2238wp.mo9610b(ub, i, i2);
        return ub;
    }

    /* renamed from: i */
    public static <UT, UB> UB m4875i(int i, List<Integer> list, zzfp zzfpVar, UB ub, AbstractC2238wp<UT, UB> abstractC2238wp) {
        if (zzfpVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzfpVar.mo1235c(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) m4874h(i, intValue, ub, abstractC2238wp);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzfpVar.mo1235c(intValue2)) {
                    ub = (UB) m4874h(i, intValue2, ub, abstractC2238wp);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* renamed from: j */
    public static void m4876j(int i, List<String> list, zzix zzixVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1298O(i, list);
    }

    /* renamed from: k */
    public static void m4877k(int i, List<?> list, zzix zzixVar, zzhi zzhiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1303e(i, list, zzhiVar);
    }

    /* renamed from: l */
    public static void m4878l(int i, List<Double> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1291H(i, list, z);
    }

    /* renamed from: m */
    public static <T, FT extends zzfd<FT>> void m4879m(AbstractC1562mn<FT> abstractC1562mn, T t, T t2) {
        C1826rn<FT> mo6477b = abstractC1562mn.mo6477b(t2);
        if (mo6477b.f6262a.isEmpty()) {
            return;
        }
        abstractC1562mn.mo6481f(t).m8209g(mo6477b);
    }

    /* renamed from: n */
    public static <T> void m4880n(zzgm zzgmVar, T t, T t2, long j) {
        C0841cq.m2926j(t, j, zzgmVar.mo1249f(C0841cq.m2907F(t, j), C0841cq.m2907F(t2, j)));
    }

    /* renamed from: o */
    public static <T, UT, UB> void m4881o(AbstractC2238wp<UT, UB> abstractC2238wp, T t, T t2) {
        abstractC2238wp.mo9613e(t, abstractC2238wp.mo9617i(abstractC2238wp.mo9614f(t), abstractC2238wp.mo9614f(t2)));
    }

    /* renamed from: p */
    public static void m4882p(Class<?> cls) {
        Class<?> cls2;
        if (!AbstractC2303xn.class.isAssignableFrom(cls) && (cls2 = f3387a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* renamed from: q */
    public static boolean m4883q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: r */
    public static int m4884r(int i, List<AbstractC1939tm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int m4518h0 = size * AbstractC1116hn.m4518h0(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            m4518h0 += AbstractC1116hn.m4502I(list.get(i2));
        }
        return m4518h0;
    }

    /* renamed from: s */
    public static int m4885s(int i, List<zzgt> list, zzhi zzhiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += AbstractC1116hn.m4508V(i, list.get(i3), zzhiVar);
        }
        return i2;
    }

    /* renamed from: t */
    public static int m4886t(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m4887u(list) + (size * AbstractC1116hn.m4518h0(i));
    }

    /* renamed from: u */
    public static int m4887u(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1778qo) {
            C1778qo c1778qo = (C1778qo) list;
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4520j0(c1778qo.mo1239d(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += AbstractC1116hn.m4520j0(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: v */
    public static AbstractC2238wp<?, ?> m4888v() {
        return f3389c;
    }

    /* renamed from: w */
    public static void m4889w(int i, List<AbstractC1939tm> list, zzix zzixVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1292I(i, list);
    }

    /* renamed from: x */
    public static void m4890x(int i, List<?> list, zzix zzixVar, zzhi zzhiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1307i(i, list, zzhiVar);
    }

    /* renamed from: y */
    public static void m4891y(int i, List<Float> list, zzix zzixVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzixVar.mo1295L(i, list, z);
    }

    /* renamed from: z */
    public static int m4892z(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m4837A(list) + (size * AbstractC1116hn.m4518h0(i));
    }
}

package com.sonelli;

import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzix;
import com.sonelli.AbstractC2303xn;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.jn */
/* loaded from: classes.dex */
public final class C1228jn implements zzix {

    /* renamed from: a */
    public final AbstractC1116hn f3629a;

    public C1228jn(AbstractC1116hn abstractC1116hn) {
        C2435zn.m10540f(abstractC1116hn, "output");
        AbstractC1116hn abstractC1116hn2 = abstractC1116hn;
        this.f3629a = abstractC1116hn2;
        abstractC1116hn2.f3176a = this;
    }

    /* renamed from: P */
    public static C1228jn m5172P(AbstractC1116hn abstractC1116hn) {
        C1228jn c1228jn = abstractC1116hn.f3176a;
        return c1228jn != null ? c1228jn : new C1228jn(abstractC1116hn);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: A */
    public final void mo1284A(int i, int i2) throws IOException {
        this.f3629a.m4551g0(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: B */
    public final void mo1285B(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.m4540Q(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4524o0(list.get(i4).longValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.m4542S(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: C */
    public final void mo1286C(int i, AbstractC1939tm abstractC1939tm) throws IOException {
        this.f3629a.mo4560o(i, abstractC1939tm);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: D */
    public final void mo1287D(int i, Object obj, zzhi zzhiVar) throws IOException {
        this.f3629a.mo4562q(i, (zzgt) obj, zzhiVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: E */
    public final void mo1288E(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4559n(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4520j0(list.get(i4).longValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4565t(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: F */
    public final void mo1289F(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.m4551g0(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4529t0(list.get(i4).intValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.m4544X(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: G */
    public final <K, V> void mo1290G(int i, C1943to<K, V> c1943to, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f3629a.mo4558m(i, 2);
            this.f3629a.mo4538O(C2024uo.m8966a(c1943to, entry.getKey(), entry.getValue()));
            C2024uo.m8967b(this.f3629a, c1943to, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: H */
    public final void mo1291H(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.m4555k(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4535z(list.get(i4).doubleValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.m4552h(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: I */
    public final void mo1292I(int i, List<AbstractC1939tm> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f3629a.mo4560o(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: J */
    public final void mo1293J(int i, int i2) throws IOException {
        this.f3629a.mo4556k0(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: K */
    public final void mo1294K(int i, long j) throws IOException {
        this.f3629a.mo4546Z(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: L */
    public final void mo1295L(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.m4557l(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4488A(list.get(i4).floatValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.m4553i(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: M */
    public final void mo1296M(int i, int i2) throws IOException {
        this.f3629a.mo4545Y(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: N */
    public final void mo1297N(int i, long j) throws IOException {
        this.f3629a.m4540Q(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: O */
    public final void mo1298O(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzga)) {
            while (i2 < list.size()) {
                this.f3629a.mo4563r(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzga zzgaVar = (zzga) list;
        while (i2 < list.size()) {
            Object mo1243d = zzgaVar.mo1243d(i2);
            if (mo1243d instanceof String) {
                this.f3629a.mo4563r(i, (String) mo1243d);
            } else {
                this.f3629a.mo4560o(i, (AbstractC1939tm) mo1243d);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: a */
    public final int mo1299a() {
        return AbstractC2303xn.e.f8034k;
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: b */
    public final void mo1300b(int i, int i2) throws IOException {
        this.f3629a.mo4556k0(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: c */
    public final void mo1301c(int i) throws IOException {
        this.f3629a.mo4558m(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: d */
    public final void mo1302d(int i) throws IOException {
        this.f3629a.mo4558m(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: e */
    public final void mo1303e(int i, List<?> list, zzhi zzhiVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo1287D(i, list.get(i2), zzhiVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: f */
    public final void mo1304f(int i, boolean z) throws IOException {
        this.f3629a.mo4564s(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: g */
    public final void mo1305g(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4564s(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4505L(list.get(i4).booleanValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.m4570y(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: h */
    public final void mo1306h(int i, long j) throws IOException {
        this.f3629a.mo4546Z(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: i */
    public final void mo1307i(int i, List<?> list, zzhi zzhiVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo1315q(i, list.get(i2), zzhiVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: j */
    public final void mo1308j(int i, int i2) throws IOException {
        this.f3629a.mo4539P(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: k */
    public final void mo1309k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4539P(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4521l0(list.get(i4).intValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4554j(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: l */
    public final void mo1310l(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4539P(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4493C0(list.get(i4).intValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4554j(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: m */
    public final void mo1311m(int i, int i2) throws IOException {
        this.f3629a.mo4539P(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: n */
    public final void mo1312n(int i, long j) throws IOException {
        this.f3629a.mo4559n(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: o */
    public final void mo1313o(int i, Object obj) throws IOException {
        if (obj instanceof AbstractC1939tm) {
            this.f3629a.mo4541R(i, (AbstractC1939tm) obj);
        } else {
            this.f3629a.mo4561p(i, (zzgt) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: p */
    public final void mo1314p(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4559n(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4516e0(list.get(i4).longValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4565t(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: q */
    public final void mo1315q(int i, Object obj, zzhi zzhiVar) throws IOException {
        AbstractC1116hn abstractC1116hn = this.f3629a;
        abstractC1116hn.mo4558m(i, 3);
        zzhiVar.mo1278g((zzgt) obj, abstractC1116hn.f3176a);
        abstractC1116hn.mo4558m(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: r */
    public final void mo1316r(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4546Z(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4532w0(list.get(i4).longValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4547a0(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: s */
    public final void mo1317s(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4556k0(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4533x0(list.get(i4).intValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4549f0(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: t */
    public final void mo1318t(int i, String str) throws IOException {
        this.f3629a.mo4563r(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: u */
    public final void mo1319u(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4545Y(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4525p0(list.get(i4).intValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4538O(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: v */
    public final void mo1320v(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4556k0(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4489A0(list.get(i4).intValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4549f0(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: w */
    public final void mo1321w(int i, long j) throws IOException {
        this.f3629a.mo4559n(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: x */
    public final void mo1322x(int i, double d) throws IOException {
        this.f3629a.m4555k(i, d);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: y */
    public final void mo1323y(int i, float f) throws IOException {
        this.f3629a.m4557l(i, f);
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    /* renamed from: z */
    public final void mo1324z(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3629a.mo4546Z(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3629a.mo4558m(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += AbstractC1116hn.m4528s0(list.get(i4).longValue());
        }
        this.f3629a.mo4538O(i3);
        while (i2 < list.size()) {
            this.f3629a.mo4547a0(list.get(i2).longValue());
            i2++;
        }
    }
}

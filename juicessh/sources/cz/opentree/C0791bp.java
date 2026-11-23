package cz.opentree;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzix;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.bp */
/* loaded from: classes.dex */
public final class C0791bp<T> implements zzhi<T> {

    /* renamed from: a */
    public final zzgt f1776a;

    /* renamed from: b */
    public final AbstractC2238wp<?, ?> f1777b;

    /* renamed from: c */
    public final boolean f1778c;

    /* renamed from: d */
    public final AbstractC1562mn<?> f1779d;

    public C0791bp(AbstractC2238wp<?, ?> abstractC2238wp, AbstractC1562mn<?> abstractC1562mn, zzgt zzgtVar) {
        this.f1777b = abstractC2238wp;
        this.f1778c = abstractC1562mn.mo6480e(zzgtVar);
        this.f1779d = abstractC1562mn;
        this.f1776a = zzgtVar;
    }

    /* renamed from: j */
    public static <T> C0791bp<T> m2590j(AbstractC2238wp<?, ?> abstractC2238wp, AbstractC1562mn<?> abstractC1562mn, zzgt zzgtVar) {
        return new C0791bp<>(abstractC2238wp, abstractC1562mn, zzgtVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: a */
    public final T mo1272a() {
        return (T) this.f1776a.mo1263b().mo1260n();
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: b */
    public final int mo1273b(T t) {
        int hashCode = this.f1777b.mo9614f(t).hashCode();
        return this.f1778c ? (hashCode * 53) + this.f1779d.mo6477b(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: c */
    public final boolean mo1274c(T t) {
        return this.f1779d.mo6477b(t).m8216r();
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: d */
    public final void mo1275d(T t) {
        this.f1777b.mo9618j(t);
        this.f1779d.mo6482g(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: e */
    public final int mo1276e(T t) {
        AbstractC2238wp<?, ?> abstractC2238wp = this.f1777b;
        int mo9619k = abstractC2238wp.mo9619k(abstractC2238wp.mo9614f(t)) + 0;
        return this.f1778c ? mo9619k + this.f1779d.mo6477b(t).m8217s() : mo9619k;
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: f */
    public final boolean mo1277f(T t, T t2) {
        if (!this.f1777b.mo9614f(t).equals(this.f1777b.mo9614f(t2))) {
            return false;
        }
        if (this.f1778c) {
            return this.f1779d.mo6477b(t).equals(this.f1779d.mo6477b(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: g */
    public final void mo1278g(T t, zzix zzixVar) throws IOException {
        Iterator<Map.Entry<?, Object>> m8214p = this.f1779d.mo6477b(t).m8214p();
        while (m8214p.hasNext()) {
            Map.Entry<?, Object> next = m8214p.next();
            zzfd zzfdVar = (zzfd) next.getKey();
            if (zzfdVar.mo1228c() != EnumC1780qq.MESSAGE || zzfdVar.mo1229d() || zzfdVar.mo1230e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof C1005fo) {
                zzixVar.mo1313o(zzfdVar.mo1226a(), ((C1005fo) next).m3847a().m4582d());
            } else {
                zzixVar.mo1313o(zzfdVar.mo1226a(), next.getValue());
            }
        }
        AbstractC2238wp<?, ?> abstractC2238wp = this.f1777b;
        abstractC2238wp.mo9615g(abstractC2238wp.mo9614f(t), zzixVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[EDGE_INSN: B:24:0x0099->B:25:0x0099 BREAK  A[LOOP:1: B:10:0x0053->B:18:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mo1279h(T r10, byte[] r11, int r12, int r13, cz.opentree.C1876sm r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            cz.opentree.xn r0 = (cz.opentree.AbstractC2303xn) r0
            cz.opentree.zp r1 = r0.zzb
            cz.opentree.zp r2 = cz.opentree.C2437zp.m10576a()
            if (r1 != r2) goto L11
            cz.opentree.zp r1 = cz.opentree.C2437zp.m10579g()
            r0.zzb = r1
        L11:
            cz.opentree.xn$d r10 = (cz.opentree.AbstractC2303xn.d) r10
            r10.m9847D()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = cz.opentree.C1725pm.m7400i(r11, r12, r14)
            int r2 = r14.f6511a
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            cz.opentree.mn<?> r12 = r9.f1779d
            cz.opentree.kn r0 = r14.f6514d
            com.google.android.gms.internal.measurement.zzgt r3 = r9.f1776a
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.mo6478c(r0, r3, r5)
            r0 = r12
            cz.opentree.xn$f r0 = (cz.opentree.AbstractC2303xn.f) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = cz.opentree.C1725pm.m7394c(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            cz.opentree.C1007fp.m3851a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = cz.opentree.C1725pm.m7392a(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = cz.opentree.C1725pm.m7400i(r11, r4, r14)
            int r5 = r14.f6511a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = cz.opentree.C1725pm.m7408q(r11, r4, r14)
            java.lang.Object r2 = r14.f6513c
            cz.opentree.tm r2 = (cz.opentree.AbstractC1939tm) r2
            goto L53
        L72:
            cz.opentree.C1007fp.m3851a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = cz.opentree.C1725pm.m7400i(r11, r4, r14)
            int r12 = r14.f6511a
            cz.opentree.mn<?> r0 = r9.f1779d
            cz.opentree.kn r5 = r14.f6514d
            com.google.android.gms.internal.measurement.zzgt r6 = r9.f1776a
            java.lang.Object r0 = r0.mo6478c(r5, r6, r12)
            cz.opentree.xn$f r0 = (cz.opentree.AbstractC2303xn.f) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = cz.opentree.C1725pm.m7392a(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.m10580c(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            cz.opentree.co r10 = cz.opentree.C0839co.m2893e()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0791bp.mo1279h(java.lang.Object, byte[], int, int, cz.opentree.sm):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: i */
    public final void mo1280i(T t, T t2) {
        C1171ip.m4881o(this.f1777b, t, t2);
        if (this.f1778c) {
            C1171ip.m4879m(this.f1779d, t, t2);
        }
    }
}

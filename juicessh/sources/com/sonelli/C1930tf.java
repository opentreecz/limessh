package com.sonelli;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.util.Clock;

/* renamed from: com.sonelli.tf */
/* loaded from: classes.dex */
public class C1930tf {

    /* renamed from: O */
    public final C2216wf f6762O;

    public C1930tf(C2216wf c2216wf) {
        C0813ca.m2729k(c2216wf);
        this.f6762O = c2216wf;
    }

    /* renamed from: Y */
    public static String m8646Y(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    /* renamed from: c0 */
    public static String m8647c0(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String m8646Y = m8646Y(obj);
        String m8646Y2 = m8646Y(obj2);
        String m8646Y3 = m8646Y(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(m8646Y)) {
            sb.append(str2);
            sb.append(m8646Y);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(m8646Y2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(m8646Y2);
        }
        if (!TextUtils.isEmpty(m8646Y3)) {
            sb.append(str3);
            sb.append(m8646Y3);
        }
        return sb.toString();
    }

    /* renamed from: v0 */
    public static boolean m8648v0() {
        return Log.isLoggable(C0770bh.f1677b.m2801a(), 2);
    }

    /* renamed from: A0 */
    public final void m8649A0(String str) {
        m8677y(5, str, null, null, null);
    }

    /* renamed from: B0 */
    public final void m8650B0(String str) {
        m8677y(6, str, null, null, null);
    }

    /* renamed from: D */
    public final void m8651D(String str, Object obj, Object obj2) {
        m8677y(2, str, obj, obj2, null);
    }

    /* renamed from: K */
    public final void m8652K(String str, Object obj, Object obj2, Object obj3) {
        m8677y(3, str, obj, obj2, obj3);
    }

    /* renamed from: Z */
    public final void m8653Z(String str, Object obj) {
        m8677y(3, str, obj, null, null);
    }

    /* renamed from: a0 */
    public final void m8654a0(String str, Object obj, Object obj2) {
        m8677y(3, str, obj, obj2, null);
    }

    /* renamed from: b0 */
    public final void m8655b0(String str, Object obj, Object obj2, Object obj3) {
        m8677y(5, str, obj, obj2, obj3);
    }

    /* renamed from: d0 */
    public final void m8656d0(String str, Object obj) {
        m8677y(4, str, obj, null, null);
    }

    /* renamed from: e0 */
    public final void m8657e0(String str, Object obj, Object obj2) {
        m8677y(5, str, obj, obj2, null);
    }

    /* renamed from: f0 */
    public final C2216wf m8658f0() {
        return this.f6762O;
    }

    /* renamed from: g0 */
    public final Clock m8659g0() {
        return this.f6762O.m9476d();
    }

    /* renamed from: h0 */
    public final C1451kh m8660h0() {
        return this.f6762O.m9477e();
    }

    /* renamed from: i0 */
    public final C2007ug m8661i0() {
        return this.f6762O.m9478f();
    }

    /* renamed from: j0 */
    public final C1434k4 m8662j0() {
        return this.f6762O.m9479g();
    }

    /* renamed from: k0 */
    public final GoogleAnalytics m8663k0() {
        return this.f6762O.m9488p();
    }

    /* renamed from: l0 */
    public final C1652of m8664l0() {
        return this.f6762O.m9480h();
    }

    /* renamed from: m0 */
    public final C2425zg m8665m0() {
        return this.f6762O.m9481i();
    }

    /* renamed from: n0 */
    public final C0771bi m8666n0() {
        return this.f6762O.m9482j();
    }

    /* renamed from: o0 */
    public final C1654oh m8667o0() {
        return this.f6762O.m9483k();
    }

    /* renamed from: p0 */
    public final C1653og m8668p0() {
        return this.f6762O.m9491s();
    }

    /* renamed from: q0 */
    public final C1602nf m8669q0() {
        return this.f6762O.m9490r();
    }

    /* renamed from: r0 */
    public final C1107hg m8670r0() {
        return this.f6762O.m9484l();
    }

    /* renamed from: s0 */
    public final C2345yg m8671s0() {
        return this.f6762O.m9485m();
    }

    /* renamed from: t0 */
    public final void m8672t0(String str, Object obj) {
        m8677y(5, str, obj, null, null);
    }

    /* renamed from: u0 */
    public final void m8673u0(String str, Object obj, Object obj2) {
        m8677y(6, str, obj, obj2, null);
    }

    /* renamed from: w0 */
    public final void m8674w0(String str, Object obj) {
        m8677y(6, str, obj, null, null);
    }

    /* renamed from: x */
    public final Context m8675x() {
        return this.f6762O.m9475a();
    }

    /* renamed from: x0 */
    public final void m8676x0(String str) {
        m8677y(2, str, null, null, null);
    }

    /* renamed from: y */
    public final void m8677y(int i, String str, Object obj, Object obj2, Object obj3) {
        C2216wf c2216wf = this.f6762O;
        C1451kh m9487o = c2216wf != null ? c2216wf.m9487o() : null;
        if (m9487o == null) {
            String m2801a = C0770bh.f1677b.m2801a();
            if (Log.isLoggable(m2801a, i)) {
                Log.println(i, m2801a, m8647c0(str, obj, obj2, obj3));
                return;
            }
            return;
        }
        String m2801a2 = C0770bh.f1677b.m2801a();
        if (Log.isLoggable(m2801a2, i)) {
            Log.println(i, m2801a2, m8647c0(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            m9487o.m5891I0(i, str, obj, obj2, obj3);
        }
    }

    /* renamed from: y0 */
    public final void m8678y0(String str) {
        m8677y(3, str, null, null, null);
    }

    /* renamed from: z */
    public final void m8679z(String str, Object obj) {
        m8677y(2, str, obj, null, null);
    }

    /* renamed from: z0 */
    public final void m8680z0(String str) {
        m8677y(4, str, null, null, null);
    }
}

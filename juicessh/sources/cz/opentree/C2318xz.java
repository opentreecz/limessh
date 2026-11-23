package cz.opentree;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.xz */
/* loaded from: classes.dex */
public final class C2318xz {

    /* renamed from: A */
    public long f8063A;

    /* renamed from: B */
    public long f8064B;

    /* renamed from: C */
    public long f8065C;

    /* renamed from: D */
    public String f8066D;

    /* renamed from: E */
    public boolean f8067E;

    /* renamed from: F */
    public long f8068F;

    /* renamed from: G */
    public long f8069G;

    /* renamed from: a */
    public final C2144uz f8070a;

    /* renamed from: b */
    public final String f8071b;

    /* renamed from: c */
    public String f8072c;

    /* renamed from: d */
    public String f8073d;

    /* renamed from: e */
    public String f8074e;

    /* renamed from: f */
    public String f8075f;

    /* renamed from: g */
    public long f8076g;

    /* renamed from: h */
    public long f8077h;

    /* renamed from: i */
    public long f8078i;

    /* renamed from: j */
    public String f8079j;

    /* renamed from: k */
    public long f8080k;

    /* renamed from: l */
    public String f8081l;

    /* renamed from: m */
    public long f8082m;

    /* renamed from: n */
    public long f8083n;

    /* renamed from: o */
    public boolean f8084o;

    /* renamed from: p */
    public long f8085p;

    /* renamed from: q */
    public boolean f8086q;

    /* renamed from: r */
    public boolean f8087r;

    /* renamed from: s */
    public String f8088s;

    /* renamed from: t */
    public Boolean f8089t;

    /* renamed from: u */
    public long f8090u;

    /* renamed from: v */
    public List<String> f8091v;

    /* renamed from: w */
    public String f8092w;

    /* renamed from: x */
    public long f8093x;

    /* renamed from: y */
    public long f8094y;

    /* renamed from: z */
    public long f8095z;

    @WorkerThread
    public C2318xz(C2144uz c2144uz, String str) {
        C0813ca.m2729k(c2144uz);
        C0813ca.m2725g(str);
        this.f8070a = c2144uz;
        this.f8071b = str;
        c2144uz.mo1481g().mo7585d();
    }

    @WorkerThread
    /* renamed from: A */
    public final String m9899A() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8073d;
    }

    @WorkerThread
    /* renamed from: B */
    public final void m9900B(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8083n != j;
        this.f8083n = j;
    }

    @WorkerThread
    /* renamed from: C */
    public final void m9901C(String str) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= !g40.m4008z0(this.f8074e, str);
        this.f8074e = str;
    }

    @WorkerThread
    /* renamed from: D */
    public final String m9902D() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8088s;
    }

    @WorkerThread
    /* renamed from: E */
    public final void m9903E(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8090u != j;
        this.f8090u = j;
    }

    @WorkerThread
    /* renamed from: F */
    public final void m9904F(String str) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= !g40.m4008z0(this.f8075f, str);
        this.f8075f = str;
    }

    @WorkerThread
    /* renamed from: G */
    public final String m9905G() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8092w;
    }

    @WorkerThread
    /* renamed from: H */
    public final void m9906H(long j) {
        C0813ca.m2719a(j >= 0);
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8076g != j;
        this.f8076g = j;
    }

    @WorkerThread
    /* renamed from: I */
    public final void m9907I(String str) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= !g40.m4008z0(this.f8079j, str);
        this.f8079j = str;
    }

    @WorkerThread
    /* renamed from: J */
    public final String m9908J() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8074e;
    }

    @WorkerThread
    /* renamed from: K */
    public final void m9909K(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8068F != j;
        this.f8068F = j;
    }

    @WorkerThread
    /* renamed from: L */
    public final void m9910L(String str) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= !g40.m4008z0(this.f8081l, str);
        this.f8081l = str;
    }

    @WorkerThread
    /* renamed from: M */
    public final String m9911M() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8075f;
    }

    @WorkerThread
    /* renamed from: N */
    public final void m9912N(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8069G != j;
        this.f8069G = j;
    }

    @WorkerThread
    /* renamed from: O */
    public final void m9913O(String str) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= !g40.m4008z0(this.f8066D, str);
        this.f8066D = str;
    }

    @WorkerThread
    /* renamed from: P */
    public final long m9914P() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8077h;
    }

    @WorkerThread
    /* renamed from: Q */
    public final void m9915Q(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8093x != j;
        this.f8093x = j;
    }

    @WorkerThread
    /* renamed from: R */
    public final long m9916R() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8078i;
    }

    @WorkerThread
    /* renamed from: S */
    public final void m9917S(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8094y != j;
        this.f8094y = j;
    }

    @WorkerThread
    /* renamed from: T */
    public final String m9918T() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8079j;
    }

    @WorkerThread
    /* renamed from: U */
    public final void m9919U(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8095z != j;
        this.f8095z = j;
    }

    @WorkerThread
    /* renamed from: V */
    public final long m9920V() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8080k;
    }

    @WorkerThread
    /* renamed from: W */
    public final void m9921W(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8063A != j;
        this.f8063A = j;
    }

    @WorkerThread
    /* renamed from: X */
    public final String m9922X() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8081l;
    }

    @WorkerThread
    /* renamed from: Y */
    public final void m9923Y(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8065C != j;
        this.f8065C = j;
    }

    @WorkerThread
    /* renamed from: Z */
    public final long m9924Z() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8082m;
    }

    @WorkerThread
    /* renamed from: a */
    public final void m9925a(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8077h != j;
        this.f8077h = j;
    }

    @WorkerThread
    /* renamed from: a0 */
    public final void m9926a0(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8064B != j;
        this.f8064B = j;
    }

    @WorkerThread
    /* renamed from: b */
    public final void m9927b(Boolean bool) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= !g40.m3994a0(this.f8089t, bool);
        this.f8089t = bool;
    }

    @WorkerThread
    /* renamed from: b0 */
    public final long m9928b0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8083n;
    }

    @WorkerThread
    /* renamed from: c */
    public final void m9929c(String str) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= !g40.m4008z0(this.f8072c, str);
        this.f8072c = str;
    }

    @WorkerThread
    /* renamed from: c0 */
    public final void m9930c0(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8085p != j;
        this.f8085p = j;
    }

    @WorkerThread
    /* renamed from: d */
    public final void m9931d(@Nullable List<String> list) {
        this.f8070a.mo1481g().mo7585d();
        if (g40.m3999l0(this.f8091v, list)) {
            return;
        }
        this.f8067E = true;
        this.f8091v = list != null ? new ArrayList(list) : null;
    }

    @WorkerThread
    /* renamed from: d0 */
    public final long m9932d0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8090u;
    }

    @WorkerThread
    /* renamed from: e */
    public final void m9933e(boolean z) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8084o != z;
        this.f8084o = z;
    }

    @WorkerThread
    /* renamed from: e0 */
    public final boolean m9934e0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8084o;
    }

    @WorkerThread
    /* renamed from: f */
    public final boolean m9935f() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8067E;
    }

    @WorkerThread
    /* renamed from: f0 */
    public final long m9936f0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8076g;
    }

    @WorkerThread
    /* renamed from: g */
    public final long m9937g() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8065C;
    }

    @WorkerThread
    /* renamed from: g0 */
    public final long m9938g0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8068F;
    }

    @WorkerThread
    /* renamed from: h */
    public final long m9939h() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8064B;
    }

    @WorkerThread
    /* renamed from: h0 */
    public final long m9940h0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8069G;
    }

    @WorkerThread
    /* renamed from: i */
    public final String m9941i() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8066D;
    }

    @WorkerThread
    /* renamed from: i0 */
    public final void m9942i0() {
        this.f8070a.mo1481g().mo7585d();
        long j = this.f8076g + 1;
        if (j > 2147483647L) {
            this.f8070a.mo1484j().m8525K().m9084b("Bundle index overflow. appId", C1889sy.m8516y(this.f8071b));
            j = 0;
        }
        this.f8067E = true;
        this.f8076g = j;
    }

    @WorkerThread
    /* renamed from: j */
    public final String m9943j() {
        this.f8070a.mo1481g().mo7585d();
        String str = this.f8066D;
        m9913O(null);
        return str;
    }

    @WorkerThread
    /* renamed from: j0 */
    public final long m9944j0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8093x;
    }

    @WorkerThread
    /* renamed from: k */
    public final long m9945k() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8085p;
    }

    @WorkerThread
    /* renamed from: k0 */
    public final long m9946k0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8094y;
    }

    @WorkerThread
    /* renamed from: l */
    public final boolean m9947l() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8086q;
    }

    @WorkerThread
    /* renamed from: l0 */
    public final long m9948l0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8095z;
    }

    @WorkerThread
    /* renamed from: m */
    public final boolean m9949m() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8087r;
    }

    @WorkerThread
    /* renamed from: m0 */
    public final long m9950m0() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8063A;
    }

    @WorkerThread
    /* renamed from: n */
    public final Boolean m9951n() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8089t;
    }

    @Nullable
    @WorkerThread
    /* renamed from: o */
    public final List<String> m9952o() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8091v;
    }

    @WorkerThread
    /* renamed from: p */
    public final void m9953p() {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E = false;
    }

    @WorkerThread
    /* renamed from: q */
    public final void m9954q(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8078i != j;
        this.f8078i = j;
    }

    @WorkerThread
    /* renamed from: r */
    public final void m9955r(String str) {
        this.f8070a.mo1481g().mo7585d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f8067E |= !g40.m4008z0(this.f8073d, str);
        this.f8073d = str;
    }

    @WorkerThread
    /* renamed from: s */
    public final void m9956s(boolean z) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8086q != z;
        this.f8086q = z;
    }

    @WorkerThread
    /* renamed from: t */
    public final String m9957t() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8071b;
    }

    @WorkerThread
    /* renamed from: u */
    public final void m9958u(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8080k != j;
        this.f8080k = j;
    }

    @WorkerThread
    /* renamed from: v */
    public final void m9959v(String str) {
        this.f8070a.mo1481g().mo7585d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f8067E |= !g40.m4008z0(this.f8088s, str);
        this.f8088s = str;
    }

    @WorkerThread
    /* renamed from: w */
    public final void m9960w(boolean z) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8087r != z;
        this.f8087r = z;
    }

    @WorkerThread
    /* renamed from: x */
    public final String m9961x() {
        this.f8070a.mo1481g().mo7585d();
        return this.f8072c;
    }

    @WorkerThread
    /* renamed from: y */
    public final void m9962y(long j) {
        this.f8070a.mo1481g().mo7585d();
        this.f8067E |= this.f8082m != j;
        this.f8082m = j;
    }

    @WorkerThread
    /* renamed from: z */
    public final void m9963z(String str) {
        this.f8070a.mo1481g().mo7585d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f8067E |= !g40.m4008z0(this.f8092w, str);
        this.f8092w = str;
    }
}

package com.sonelli;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class x40 implements Api.ApiOptions.Optional {

    /* renamed from: X */
    public static final x40 f7866X = new x40(false, false, null, false, null, null, false, null, null);

    /* renamed from: O */
    public final boolean f7867O = false;

    /* renamed from: P */
    public final boolean f7868P = false;

    /* renamed from: Q */
    public final String f7869Q = null;

    /* renamed from: R */
    public final boolean f7870R = false;

    /* renamed from: U */
    public final boolean f7873U = false;

    /* renamed from: S */
    public final String f7871S = null;

    /* renamed from: T */
    public final String f7872T = null;

    /* renamed from: V */
    public final Long f7874V = null;

    /* renamed from: W */
    public final Long f7875W = null;

    public x40(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l, Long l2) {
    }

    @Nullable
    /* renamed from: a */
    public final Long m9690a() {
        return this.f7874V;
    }

    @Nullable
    /* renamed from: b */
    public final String m9691b() {
        return this.f7871S;
    }

    @Nullable
    /* renamed from: c */
    public final String m9692c() {
        return this.f7872T;
    }

    @Nullable
    /* renamed from: d */
    public final Long m9693d() {
        return this.f7875W;
    }

    /* renamed from: e */
    public final String m9694e() {
        return this.f7869Q;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x40)) {
            return false;
        }
        x40 x40Var = (x40) obj;
        return this.f7867O == x40Var.f7867O && this.f7868P == x40Var.f7868P && C0758ba.m2404a(this.f7869Q, x40Var.f7869Q) && this.f7870R == x40Var.f7870R && this.f7873U == x40Var.f7873U && C0758ba.m2404a(this.f7871S, x40Var.f7871S) && C0758ba.m2404a(this.f7872T, x40Var.f7872T) && C0758ba.m2404a(this.f7874V, x40Var.f7874V) && C0758ba.m2404a(this.f7875W, x40Var.f7875W);
    }

    /* renamed from: f */
    public final boolean m9695f() {
        return this.f7870R;
    }

    /* renamed from: g */
    public final boolean m9696g() {
        return this.f7868P;
    }

    public final int hashCode() {
        return C0758ba.m2405b(Boolean.valueOf(this.f7867O), Boolean.valueOf(this.f7868P), this.f7869Q, Boolean.valueOf(this.f7870R), Boolean.valueOf(this.f7873U), this.f7871S, this.f7872T, this.f7874V, this.f7875W);
    }

    /* renamed from: i */
    public final boolean m9697i() {
        return this.f7867O;
    }

    /* renamed from: j */
    public final boolean m9698j() {
        return this.f7873U;
    }
}

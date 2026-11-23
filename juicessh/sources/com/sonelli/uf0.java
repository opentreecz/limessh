package com.sonelli;

import com.google.firebase.installations.StateListener;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class uf0 implements StateListener {

    /* renamed from: a */
    public final k60<String> f6955a;

    public uf0(k60<String> k60Var) {
        this.f6955a = k60Var;
    }

    @Override // com.google.firebase.installations.StateListener
    /* renamed from: a */
    public boolean mo1909a(bg0 bg0Var, Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    /* renamed from: b */
    public boolean mo1910b(bg0 bg0Var) {
        if (!bg0Var.m2469l() && !bg0Var.m2468k() && !bg0Var.m2466i()) {
            return false;
        }
        this.f6955a.m5846e(bg0Var.mo2461d());
        return true;
    }
}

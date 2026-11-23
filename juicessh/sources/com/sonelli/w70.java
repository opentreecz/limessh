package com.sonelli;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class w70 implements Provider {

    /* renamed from: a */
    public final z70 f7627a;

    /* renamed from: b */
    public final v70 f7628b;

    public w70(z70 z70Var, v70 v70Var) {
        this.f7627a = z70Var;
        this.f7628b = v70Var;
    }

    /* renamed from: a */
    public static Provider m9413a(z70 z70Var, v70 v70Var) {
        return new w70(z70Var, v70Var);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        Object mo1608a;
        mo1608a = r1.m9180d().mo1608a(new j80(this.f7628b, this.f7627a));
        return mo1608a;
    }
}

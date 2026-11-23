package com.sonelli;

/* loaded from: classes.dex */
public class xt0 {

    /* renamed from: a */
    public byte[] f8054a;

    /* renamed from: b */
    public int f8055b;

    public xt0(byte[] bArr, int i) {
        this.f8054a = e51.m3436e(bArr);
        this.f8055b = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof xt0)) {
            return false;
        }
        xt0 xt0Var = (xt0) obj;
        if (xt0Var.f8055b != this.f8055b) {
            return false;
        }
        return e51.m3432a(this.f8054a, xt0Var.f8054a);
    }

    public int hashCode() {
        return this.f8055b ^ e51.m3445n(this.f8054a);
    }
}

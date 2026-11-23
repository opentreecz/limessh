package com.sonelli;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class ko0 {

    /* renamed from: a */
    public int f4630a;

    /* renamed from: b */
    public final int[] f4631b = new int[10];

    /* renamed from: a */
    public void m5961a() {
        this.f4630a = 0;
        Arrays.fill(this.f4631b, 0);
    }

    /* renamed from: b */
    public int m5962b(int i) {
        return this.f4631b[i];
    }

    /* renamed from: c */
    public int m5963c() {
        if ((this.f4630a & 2) != 0) {
            return this.f4631b[1];
        }
        return -1;
    }

    /* renamed from: d */
    public int m5964d() {
        return (this.f4630a & 128) != 0 ? this.f4631b[7] : SupportMenu.USER_MASK;
    }

    /* renamed from: e */
    public int m5965e(int i) {
        return (this.f4630a & 16) != 0 ? this.f4631b[4] : i;
    }

    /* renamed from: f */
    public int m5966f(int i) {
        return (this.f4630a & 32) != 0 ? this.f4631b[5] : i;
    }

    /* renamed from: g */
    public boolean m5967g(int i) {
        return ((1 << i) & this.f4630a) != 0;
    }

    /* renamed from: h */
    public void m5968h(ko0 ko0Var) {
        for (int i = 0; i < 10; i++) {
            if (ko0Var.m5967g(i)) {
                m5969i(i, ko0Var.m5962b(i));
            }
        }
    }

    /* renamed from: i */
    public ko0 m5969i(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f4631b;
            if (i < iArr.length) {
                this.f4630a = (1 << i) | this.f4630a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* renamed from: j */
    public int m5970j() {
        return Integer.bitCount(this.f4630a);
    }
}

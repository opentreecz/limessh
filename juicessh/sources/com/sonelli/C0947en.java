package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.en */
/* loaded from: classes.dex */
public final class C0947en extends AbstractC0838cn {

    /* renamed from: a */
    public int f2496a;

    /* renamed from: b */
    public int f2497b;

    /* renamed from: c */
    public int f2498c;

    /* renamed from: d */
    public int f2499d;

    /* renamed from: e */
    public int f2500e;

    public C0947en(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f2500e = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f2496a = i2 + i;
        this.f2498c = i;
        this.f2499d = i;
    }

    @Override // com.sonelli.AbstractC0838cn
    /* renamed from: c */
    public final int mo2885c(int i) throws C0839co {
        if (i < 0) {
            throw C0839co.m2890b();
        }
        int mo2886e = i + mo2886e();
        int i2 = this.f2500e;
        if (mo2886e > i2) {
            throw C0839co.m2889a();
        }
        this.f2500e = mo2886e;
        m3532f();
        return i2;
    }

    @Override // com.sonelli.AbstractC0838cn
    /* renamed from: e */
    public final int mo2886e() {
        return this.f2498c - this.f2499d;
    }

    /* renamed from: f */
    public final void m3532f() {
        int i = this.f2496a + this.f2497b;
        this.f2496a = i;
        int i2 = i - this.f2499d;
        int i3 = this.f2500e;
        if (i2 <= i3) {
            this.f2497b = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f2497b = i4;
        this.f2496a = i - i4;
    }
}

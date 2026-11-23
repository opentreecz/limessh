package cz.opentree;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: cz.opentree.kf */
/* loaded from: classes.dex */
public final class C1447kf extends AbstractC1142i4<C1447kf> {

    /* renamed from: a */
    public String f4522a;

    /* renamed from: b */
    public int f4523b;

    /* renamed from: c */
    public int f4524c;

    /* renamed from: d */
    public String f4525d;

    /* renamed from: e */
    public String f4526e;

    /* renamed from: f */
    public boolean f4527f;

    /* renamed from: g */
    public boolean f4528g;

    public C1447kf() {
        this(false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1447kf(boolean r5) {
        /*
            r4 = this;
            java.util.UUID r5 = java.util.UUID.randomUUID()
            long r0 = r5.getLeastSignificantBits()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r0 = r0 & r2
            int r0 = (int) r0
            if (r0 == 0) goto L10
            goto L23
        L10:
            long r0 = r5.getMostSignificantBits()
            long r0 = r0 & r2
            int r0 = (int) r0
            if (r0 == 0) goto L19
            goto L23
        L19:
            java.lang.String r5 = "GAv4"
            java.lang.String r0 = "UUID.randomUUID() returned 0."
            android.util.Log.e(r5, r0)
            r0 = 2147483647(0x7fffffff, float:NaN)
        L23:
            r5 = 0
            r4.<init>(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C1447kf.<init>(boolean):void");
    }

    public C1447kf(boolean z, int i) {
        C0813ca.m2731m(i);
        this.f4523b = i;
        this.f4528g = false;
    }

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1447kf c1447kf) {
        C1447kf c1447kf2 = c1447kf;
        if (!TextUtils.isEmpty(this.f4522a)) {
            c1447kf2.f4522a = this.f4522a;
        }
        int i = this.f4523b;
        if (i != 0) {
            c1447kf2.f4523b = i;
        }
        int i2 = this.f4524c;
        if (i2 != 0) {
            c1447kf2.f4524c = i2;
        }
        if (!TextUtils.isEmpty(this.f4525d)) {
            c1447kf2.f4525d = this.f4525d;
        }
        if (!TextUtils.isEmpty(this.f4526e)) {
            String str = this.f4526e;
            if (TextUtils.isEmpty(str)) {
                c1447kf2.f4526e = null;
            } else {
                c1447kf2.f4526e = str;
            }
        }
        boolean z = this.f4527f;
        if (z) {
            c1447kf2.f4527f = z;
        }
        boolean z2 = this.f4528g;
        if (z2) {
            c1447kf2.f4528g = z2;
        }
    }

    /* renamed from: e */
    public final String m5874e() {
        return this.f4522a;
    }

    /* renamed from: f */
    public final int m5875f() {
        return this.f4523b;
    }

    /* renamed from: g */
    public final String m5876g() {
        return this.f4526e;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.f4522a);
        hashMap.put("interstitial", Boolean.valueOf(this.f4527f));
        hashMap.put("automatic", Boolean.valueOf(this.f4528g));
        hashMap.put("screenId", Integer.valueOf(this.f4523b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.f4524c));
        hashMap.put("referrerScreenName", this.f4525d);
        hashMap.put("referrerUri", this.f4526e);
        return AbstractC1142i4.m4715a(hashMap);
    }
}

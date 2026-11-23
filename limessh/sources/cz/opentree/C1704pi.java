package cz.opentree;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: cz.opentree.pi */
/* loaded from: classes.dex */
public final class C1704pi extends AbstractC1142i4<C1704pi> {

    /* renamed from: a */
    public String f5663a;

    /* renamed from: b */
    public int f5664b;

    /* renamed from: c */
    public int f5665c;

    /* renamed from: d */
    public int f5666d;

    /* renamed from: e */
    public int f5667e;

    /* renamed from: f */
    public int f5668f;

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1704pi c1704pi) {
        C1704pi c1704pi2 = c1704pi;
        int i = this.f5664b;
        if (i != 0) {
            c1704pi2.f5664b = i;
        }
        int i2 = this.f5665c;
        if (i2 != 0) {
            c1704pi2.f5665c = i2;
        }
        int i3 = this.f5666d;
        if (i3 != 0) {
            c1704pi2.f5666d = i3;
        }
        int i4 = this.f5667e;
        if (i4 != 0) {
            c1704pi2.f5667e = i4;
        }
        int i5 = this.f5668f;
        if (i5 != 0) {
            c1704pi2.f5668f = i5;
        }
        if (TextUtils.isEmpty(this.f5663a)) {
            return;
        }
        c1704pi2.f5663a = this.f5663a;
    }

    /* renamed from: e */
    public final String m7320e() {
        return this.f5663a;
    }

    /* renamed from: f */
    public final void m7321f(String str) {
        this.f5663a = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.f5663a);
        hashMap.put("screenColors", Integer.valueOf(this.f5664b));
        hashMap.put("screenWidth", Integer.valueOf(this.f5665c));
        hashMap.put("screenHeight", Integer.valueOf(this.f5666d));
        hashMap.put("viewportWidth", Integer.valueOf(this.f5667e));
        hashMap.put("viewportHeight", Integer.valueOf(this.f5668f));
        return AbstractC1142i4.m4715a(hashMap);
    }
}

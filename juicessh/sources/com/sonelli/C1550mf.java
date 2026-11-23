package com.sonelli;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.sonelli.mf */
/* loaded from: classes.dex */
public final class C1550mf extends AbstractC1142i4<C1550mf> {

    /* renamed from: a */
    public String f5030a;

    /* renamed from: b */
    public long f5031b;

    /* renamed from: c */
    public String f5032c;

    /* renamed from: d */
    public String f5033d;

    @Override // com.sonelli.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1550mf c1550mf) {
        C1550mf c1550mf2 = c1550mf;
        if (!TextUtils.isEmpty(this.f5030a)) {
            c1550mf2.f5030a = this.f5030a;
        }
        long j = this.f5031b;
        if (j != 0) {
            c1550mf2.f5031b = j;
        }
        if (!TextUtils.isEmpty(this.f5032c)) {
            c1550mf2.f5032c = this.f5032c;
        }
        if (TextUtils.isEmpty(this.f5033d)) {
            return;
        }
        c1550mf2.f5033d = this.f5033d;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.f5030a);
        hashMap.put("timeInMillis", Long.valueOf(this.f5031b));
        hashMap.put("category", this.f5032c);
        hashMap.put("label", this.f5033d);
        return AbstractC1142i4.m4715a(hashMap);
    }
}

package cz.opentree;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: cz.opentree.ri */
/* loaded from: classes.dex */
public final class C1819ri extends AbstractC1142i4<C1819ri> {

    /* renamed from: a */
    public String f6217a;

    /* renamed from: b */
    public String f6218b;

    /* renamed from: c */
    public String f6219c;

    /* renamed from: d */
    public long f6220d;

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1819ri c1819ri) {
        C1819ri c1819ri2 = c1819ri;
        if (!TextUtils.isEmpty(this.f6217a)) {
            c1819ri2.f6217a = this.f6217a;
        }
        if (!TextUtils.isEmpty(this.f6218b)) {
            c1819ri2.f6218b = this.f6218b;
        }
        if (!TextUtils.isEmpty(this.f6219c)) {
            c1819ri2.f6219c = this.f6219c;
        }
        long j = this.f6220d;
        if (j != 0) {
            c1819ri2.f6220d = j;
        }
    }

    /* renamed from: e */
    public final String m7908e() {
        return this.f6218b;
    }

    /* renamed from: f */
    public final String m7909f() {
        return this.f6219c;
    }

    /* renamed from: g */
    public final long m7910g() {
        return this.f6220d;
    }

    /* renamed from: h */
    public final String m7911h() {
        return this.f6217a;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.f6217a);
        hashMap.put("action", this.f6218b);
        hashMap.put("label", this.f6219c);
        hashMap.put("value", Long.valueOf(this.f6220d));
        return AbstractC1142i4.m4715a(hashMap);
    }
}

package com.sonelli;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.sonelli.ki */
/* loaded from: classes.dex */
public final class C1455ki extends AbstractC1142i4<C1455ki> {

    /* renamed from: a */
    public String f4556a;

    /* renamed from: b */
    public String f4557b;

    /* renamed from: c */
    public String f4558c;

    /* renamed from: d */
    public String f4559d;

    /* renamed from: e */
    public final void m5902e(String str) {
        this.f4558c = str;
    }

    /* renamed from: f */
    public final void m5903f(String str) {
        this.f4559d = str;
    }

    /* renamed from: g */
    public final void m5904g(String str) {
        this.f4556a = str;
    }

    /* renamed from: h */
    public final void m5905h(String str) {
        this.f4557b = str;
    }

    @Override // com.sonelli.AbstractC1142i4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void mo4718d(C1455ki c1455ki) {
        if (!TextUtils.isEmpty(this.f4556a)) {
            c1455ki.f4556a = this.f4556a;
        }
        if (!TextUtils.isEmpty(this.f4557b)) {
            c1455ki.f4557b = this.f4557b;
        }
        if (!TextUtils.isEmpty(this.f4558c)) {
            c1455ki.f4558c = this.f4558c;
        }
        if (TextUtils.isEmpty(this.f4559d)) {
            return;
        }
        c1455ki.f4559d = this.f4559d;
    }

    /* renamed from: j */
    public final String m5907j() {
        return this.f4556a;
    }

    /* renamed from: k */
    public final String m5908k() {
        return this.f4557b;
    }

    /* renamed from: l */
    public final String m5909l() {
        return this.f4558c;
    }

    /* renamed from: m */
    public final String m5910m() {
        return this.f4559d;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.f4556a);
        hashMap.put("appVersion", this.f4557b);
        hashMap.put("appId", this.f4558c);
        hashMap.put("appInstallerId", this.f4559d);
        return AbstractC1142i4.m4715a(hashMap);
    }
}

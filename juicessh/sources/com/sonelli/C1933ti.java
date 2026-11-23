package com.sonelli;

import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.HashMap;

/* renamed from: com.sonelli.ti */
/* loaded from: classes.dex */
public final class C1933ti extends AbstractC1142i4<C1933ti> {

    /* renamed from: a */
    public String f6771a;

    /* renamed from: b */
    public String f6772b;

    /* renamed from: c */
    public String f6773c;

    /* renamed from: d */
    public String f6774d;

    /* renamed from: e */
    public boolean f6775e;

    /* renamed from: f */
    public String f6776f;

    /* renamed from: g */
    public boolean f6777g;

    /* renamed from: h */
    public double f6778h;

    @Override // com.sonelli.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1933ti c1933ti) {
        C1933ti c1933ti2 = c1933ti;
        if (!TextUtils.isEmpty(this.f6771a)) {
            c1933ti2.f6771a = this.f6771a;
        }
        if (!TextUtils.isEmpty(this.f6772b)) {
            c1933ti2.f6772b = this.f6772b;
        }
        if (!TextUtils.isEmpty(this.f6773c)) {
            c1933ti2.f6773c = this.f6773c;
        }
        if (!TextUtils.isEmpty(this.f6774d)) {
            c1933ti2.f6774d = this.f6774d;
        }
        if (this.f6775e) {
            c1933ti2.f6775e = true;
        }
        if (!TextUtils.isEmpty(this.f6776f)) {
            c1933ti2.f6776f = this.f6776f;
        }
        boolean z = this.f6777g;
        if (z) {
            c1933ti2.f6777g = z;
        }
        double d = this.f6778h;
        if (d != ShadowDrawableWrapper.COS_45) {
            C0813ca.m2720b(d >= ShadowDrawableWrapper.COS_45 && d <= 100.0d, "Sample rate must be between 0% and 100%");
            c1933ti2.f6778h = d;
        }
    }

    /* renamed from: e */
    public final void m8687e(String str) {
        this.f6772b = str;
    }

    /* renamed from: f */
    public final void m8688f(String str) {
        this.f6773c = str;
    }

    /* renamed from: g */
    public final void m8689g(boolean z) {
        this.f6775e = z;
    }

    /* renamed from: h */
    public final void m8690h(boolean z) {
        this.f6777g = true;
    }

    /* renamed from: i */
    public final String m8691i() {
        return this.f6771a;
    }

    /* renamed from: j */
    public final String m8692j() {
        return this.f6772b;
    }

    /* renamed from: k */
    public final String m8693k() {
        return this.f6773c;
    }

    /* renamed from: l */
    public final String m8694l() {
        return this.f6774d;
    }

    /* renamed from: m */
    public final boolean m8695m() {
        return this.f6775e;
    }

    /* renamed from: n */
    public final String m8696n() {
        return this.f6776f;
    }

    /* renamed from: o */
    public final boolean m8697o() {
        return this.f6777g;
    }

    /* renamed from: p */
    public final double m8698p() {
        return this.f6778h;
    }

    /* renamed from: q */
    public final void m8699q(String str) {
        this.f6771a = str;
    }

    /* renamed from: r */
    public final void m8700r(String str) {
        this.f6774d = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.f6771a);
        hashMap.put("clientId", this.f6772b);
        hashMap.put("userId", this.f6773c);
        hashMap.put("androidAdId", this.f6774d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.f6775e));
        hashMap.put("sessionControl", this.f6776f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.f6777g));
        hashMap.put("sampleRate", Double.valueOf(this.f6778h));
        return AbstractC1142i4.m4715a(hashMap);
    }
}

package cz.opentree;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: cz.opentree.li */
/* loaded from: classes.dex */
public final class C1507li extends AbstractC1142i4<C1507li> {

    /* renamed from: a */
    public String f4805a;

    /* renamed from: b */
    public String f4806b;

    /* renamed from: c */
    public String f4807c;

    /* renamed from: d */
    public String f4808d;

    /* renamed from: e */
    public String f4809e;

    /* renamed from: f */
    public String f4810f;

    /* renamed from: g */
    public String f4811g;

    /* renamed from: h */
    public String f4812h;

    /* renamed from: i */
    public String f4813i;

    /* renamed from: j */
    public String f4814j;

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1507li c1507li) {
        C1507li c1507li2 = c1507li;
        if (!TextUtils.isEmpty(this.f4805a)) {
            c1507li2.f4805a = this.f4805a;
        }
        if (!TextUtils.isEmpty(this.f4806b)) {
            c1507li2.f4806b = this.f4806b;
        }
        if (!TextUtils.isEmpty(this.f4807c)) {
            c1507li2.f4807c = this.f4807c;
        }
        if (!TextUtils.isEmpty(this.f4808d)) {
            c1507li2.f4808d = this.f4808d;
        }
        if (!TextUtils.isEmpty(this.f4809e)) {
            c1507li2.f4809e = this.f4809e;
        }
        if (!TextUtils.isEmpty(this.f4810f)) {
            c1507li2.f4810f = this.f4810f;
        }
        if (!TextUtils.isEmpty(this.f4811g)) {
            c1507li2.f4811g = this.f4811g;
        }
        if (!TextUtils.isEmpty(this.f4812h)) {
            c1507li2.f4812h = this.f4812h;
        }
        if (!TextUtils.isEmpty(this.f4813i)) {
            c1507li2.f4813i = this.f4813i;
        }
        if (TextUtils.isEmpty(this.f4814j)) {
            return;
        }
        c1507li2.f4814j = this.f4814j;
    }

    /* renamed from: e */
    public final String m6171e() {
        return this.f4810f;
    }

    /* renamed from: f */
    public final String m6172f() {
        return this.f4805a;
    }

    /* renamed from: g */
    public final String m6173g() {
        return this.f4806b;
    }

    /* renamed from: h */
    public final void m6174h(String str) {
        this.f4805a = str;
    }

    /* renamed from: i */
    public final String m6175i() {
        return this.f4807c;
    }

    /* renamed from: j */
    public final String m6176j() {
        return this.f4808d;
    }

    /* renamed from: k */
    public final String m6177k() {
        return this.f4809e;
    }

    /* renamed from: l */
    public final String m6178l() {
        return this.f4811g;
    }

    /* renamed from: m */
    public final String m6179m() {
        return this.f4812h;
    }

    /* renamed from: n */
    public final String m6180n() {
        return this.f4813i;
    }

    /* renamed from: o */
    public final String m6181o() {
        return this.f4814j;
    }

    /* renamed from: p */
    public final void m6182p(String str) {
        this.f4806b = str;
    }

    /* renamed from: q */
    public final void m6183q(String str) {
        this.f4807c = str;
    }

    /* renamed from: r */
    public final void m6184r(String str) {
        this.f4808d = str;
    }

    /* renamed from: s */
    public final void m6185s(String str) {
        this.f4809e = str;
    }

    /* renamed from: t */
    public final void m6186t(String str) {
        this.f4810f = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.f4805a);
        hashMap.put("source", this.f4806b);
        hashMap.put("medium", this.f4807c);
        hashMap.put("keyword", this.f4808d);
        hashMap.put("content", this.f4809e);
        hashMap.put("id", this.f4810f);
        hashMap.put("adNetworkId", this.f4811g);
        hashMap.put("gclid", this.f4812h);
        hashMap.put("dclid", this.f4813i);
        hashMap.put("aclid", this.f4814j);
        return AbstractC1142i4.m4715a(hashMap);
    }

    /* renamed from: u */
    public final void m6187u(String str) {
        this.f4811g = str;
    }

    /* renamed from: v */
    public final void m6188v(String str) {
        this.f4812h = str;
    }

    /* renamed from: w */
    public final void m6189w(String str) {
        this.f4813i = str;
    }

    /* renamed from: x */
    public final void m6190x(String str) {
        this.f4814j = str;
    }
}

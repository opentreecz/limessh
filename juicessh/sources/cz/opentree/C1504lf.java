package cz.opentree;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: cz.opentree.lf */
/* loaded from: classes.dex */
public final class C1504lf extends AbstractC1142i4<C1504lf> {

    /* renamed from: a */
    public String f4789a;

    /* renamed from: b */
    public String f4790b;

    /* renamed from: c */
    public String f4791c;

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1504lf c1504lf) {
        C1504lf c1504lf2 = c1504lf;
        if (!TextUtils.isEmpty(this.f4789a)) {
            c1504lf2.f4789a = this.f4789a;
        }
        if (!TextUtils.isEmpty(this.f4790b)) {
            c1504lf2.f4790b = this.f4790b;
        }
        if (TextUtils.isEmpty(this.f4791c)) {
            return;
        }
        c1504lf2.f4791c = this.f4791c;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("network", this.f4789a);
        hashMap.put("action", this.f4790b);
        hashMap.put("target", this.f4791c);
        return AbstractC1142i4.m4715a(hashMap);
    }
}

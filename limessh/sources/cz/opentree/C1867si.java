package cz.opentree;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: cz.opentree.si */
/* loaded from: classes.dex */
public final class C1867si extends AbstractC1142i4<C1867si> {

    /* renamed from: a */
    public String f6462a;

    /* renamed from: b */
    public boolean f6463b;

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1867si c1867si) {
        C1867si c1867si2 = c1867si;
        if (!TextUtils.isEmpty(this.f6462a)) {
            c1867si2.f6462a = this.f6462a;
        }
        boolean z = this.f6463b;
        if (z) {
            c1867si2.f6463b = z;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("description", this.f6462a);
        hashMap.put("fatal", Boolean.valueOf(this.f6463b));
        return AbstractC1142i4.m4715a(hashMap);
    }
}

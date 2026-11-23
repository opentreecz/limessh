package com.sonelli;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l40 {

    /* renamed from: a */
    public final C2144uz f4740a;

    public l40(C2144uz c2144uz) {
        this.f4740a = c2144uz;
    }

    @WorkerThread
    /* renamed from: a */
    public final void m6062a() {
        this.f4740a.mo1481g().mo7585d();
        if (m6066e()) {
            if (m6065d()) {
                this.f4740a.m9096B().f2555B.m6013b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.f4740a.m9101G().m10009S("auto", "_cmpx", bundle);
            } else {
                String m6012a = this.f4740a.m9096B().f2555B.m6012a();
                if (TextUtils.isEmpty(m6012a)) {
                    this.f4740a.mo1484j().m8523I().m9083a("Cache still valid but referrer not found");
                } else {
                    long m4968a = ((this.f4740a.m9096B().f2556C.m4968a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(m6012a);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", m4968a);
                    this.f4740a.m9101G().m10009S((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.f4740a.m9096B().f2555B.m6013b(null);
            }
            this.f4740a.m9096B().f2556C.m4969b(0L);
        }
    }

    @WorkerThread
    /* renamed from: b */
    public final void m6063b(String str, Bundle bundle) {
        String str2;
        this.f4740a.mo1481g().mo7585d();
        if (this.f4740a.m9122q()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            str2 = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str3 : bundle.keySet()) {
                builder.appendQueryParameter(str3, bundle.getString(str3));
            }
            str2 = builder.build().toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f4740a.m9096B().f2555B.m6013b(str2);
        this.f4740a.m9096B().f2556C.m4969b(this.f4740a.mo1483i().mo1177a());
    }

    /* renamed from: c */
    public final void m6064c() {
        if (m6066e() && m6065d()) {
            this.f4740a.m9096B().f2555B.m6013b(null);
        }
    }

    /* renamed from: d */
    public final boolean m6065d() {
        return m6066e() && this.f4740a.mo1483i().mo1177a() - this.f4740a.m9096B().f2556C.m4968a() > this.f4740a.m9130y().m2627r(null, C1735pu.f5815S0);
    }

    /* renamed from: e */
    public final boolean m6066e() {
        return this.f4740a.m9096B().f2556C.m4968a() > 0;
    }
}

package com.sonelli;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.s0 */
/* loaded from: classes.dex */
public abstract class AbstractC1841s0 {
    /* renamed from: a */
    public static AbstractC1841s0 m8289a(Context context, Clock clock, Clock clock2, String str) {
        return new C1685p0(context, clock, clock2, str);
    }

    /* renamed from: b */
    public abstract Context mo7162b();

    @NonNull
    /* renamed from: c */
    public abstract String mo7163c();

    /* renamed from: d */
    public abstract Clock mo7164d();

    /* renamed from: e */
    public abstract Clock mo7165e();
}

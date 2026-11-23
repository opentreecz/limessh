package com.sonelli;

import javax.annotation.Nullable;
import okio.BufferedSource;

/* compiled from: RealResponseBody.java */
/* loaded from: classes.dex */
public final class wn0 extends an0 {

    /* renamed from: O */
    @Nullable
    public final String f7777O;

    /* renamed from: P */
    public final long f7778P;

    /* renamed from: Q */
    public final BufferedSource f7779Q;

    public wn0(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.f7777O = str;
        this.f7778P = j;
        this.f7779Q = bufferedSource;
    }

    @Override // com.sonelli.an0
    /* renamed from: b */
    public long mo2162b() {
        return this.f7778P;
    }

    @Override // com.sonelli.an0
    /* renamed from: c */
    public sm0 mo2163c() {
        String str = this.f7777O;
        if (str != null) {
            return sm0.m8470d(str);
        }
        return null;
    }

    @Override // com.sonelli.an0
    /* renamed from: h */
    public BufferedSource mo2164h() {
        return this.f7779Q;
    }
}

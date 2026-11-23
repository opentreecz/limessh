package com.sonelli;

import com.sonelli.AbstractC1795r0;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.o0 */
/* loaded from: classes.dex */
public final class C1628o0 extends AbstractC1795r0 {

    /* renamed from: a */
    public final AbstractC1795r0.a f5392a;

    /* renamed from: b */
    public final long f5393b;

    public C1628o0(AbstractC1795r0.a aVar, long j) {
        Objects.requireNonNull(aVar, "Null status");
        this.f5392a = aVar;
        this.f5393b = j;
    }

    @Override // com.sonelli.AbstractC1795r0
    /* renamed from: b */
    public long mo6823b() {
        return this.f5393b;
    }

    @Override // com.sonelli.AbstractC1795r0
    /* renamed from: c */
    public AbstractC1795r0.a mo6824c() {
        return this.f5392a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1795r0)) {
            return false;
        }
        AbstractC1795r0 abstractC1795r0 = (AbstractC1795r0) obj;
        return this.f5392a.equals(abstractC1795r0.mo6824c()) && this.f5393b == abstractC1795r0.mo6823b();
    }

    public int hashCode() {
        int hashCode = (this.f5392a.hashCode() ^ 1000003) * 1000003;
        long j = this.f5393b;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f5392a + ", nextRequestWaitMillis=" + this.f5393b + "}";
    }
}

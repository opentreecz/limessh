package com.sonelli;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.m */
/* loaded from: classes.dex */
public final class C1531m extends AbstractC1840s {

    /* renamed from: a */
    public final long f4940a;

    public C1531m(long j) {
        this.f4940a = j;
    }

    @Override // com.sonelli.AbstractC1840s
    /* renamed from: a */
    public long mo6326a() {
        return this.f4940a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AbstractC1840s) && this.f4940a == ((AbstractC1840s) obj).mo6326a();
    }

    public int hashCode() {
        long j = this.f4940a;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f4940a + "}";
    }
}

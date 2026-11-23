package com.sonelli;

import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.a2 */
/* loaded from: classes.dex */
public final class C0692a2 extends AbstractC1022g2 {

    /* renamed from: a */
    public final long f1311a;

    /* renamed from: b */
    public final AbstractC1138i0 f1312b;

    /* renamed from: c */
    public final AbstractC0906e0 f1313c;

    public C0692a2(long j, AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0) {
        this.f1311a = j;
        Objects.requireNonNull(abstractC1138i0, "Null transportContext");
        this.f1312b = abstractC1138i0;
        Objects.requireNonNull(abstractC0906e0, "Null event");
        this.f1313c = abstractC0906e0;
    }

    @Override // com.sonelli.AbstractC1022g2
    /* renamed from: b */
    public AbstractC0906e0 mo1951b() {
        return this.f1313c;
    }

    @Override // com.sonelli.AbstractC1022g2
    /* renamed from: c */
    public long mo1952c() {
        return this.f1311a;
    }

    @Override // com.sonelli.AbstractC1022g2
    /* renamed from: d */
    public AbstractC1138i0 mo1953d() {
        return this.f1312b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1022g2)) {
            return false;
        }
        AbstractC1022g2 abstractC1022g2 = (AbstractC1022g2) obj;
        return this.f1311a == abstractC1022g2.mo1952c() && this.f1312b.equals(abstractC1022g2.mo1953d()) && this.f1313c.equals(abstractC1022g2.mo1951b());
    }

    public int hashCode() {
        long j = this.f1311a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1312b.hashCode()) * 1000003) ^ this.f1313c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f1311a + ", transportContext=" + this.f1312b + ", event=" + this.f1313c + "}";
    }
}

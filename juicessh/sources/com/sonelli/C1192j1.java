package com.sonelli;

import com.google.android.datatransport.runtime.time.Clock;
import com.sonelli.AbstractC1583n1;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.j1 */
/* loaded from: classes.dex */
public final class C1192j1 extends AbstractC1583n1 {

    /* renamed from: a */
    public final Clock f3465a;

    /* renamed from: b */
    public final Map<EnumC0854d, AbstractC1583n1.b> f3466b;

    public C1192j1(Clock clock, Map<EnumC0854d, AbstractC1583n1.b> map) {
        Objects.requireNonNull(clock, "Null clock");
        this.f3465a = clock;
        Objects.requireNonNull(map, "Null values");
        this.f3466b = map;
    }

    @Override // com.sonelli.AbstractC1583n1
    /* renamed from: d */
    public Clock mo5033d() {
        return this.f3465a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1583n1)) {
            return false;
        }
        AbstractC1583n1 abstractC1583n1 = (AbstractC1583n1) obj;
        return this.f3465a.equals(abstractC1583n1.mo5033d()) && this.f3466b.equals(abstractC1583n1.mo5034g());
    }

    @Override // com.sonelli.AbstractC1583n1
    /* renamed from: g */
    public Map<EnumC0854d, AbstractC1583n1.b> mo5034g() {
        return this.f3466b;
    }

    public int hashCode() {
        return ((this.f3465a.hashCode() ^ 1000003) * 1000003) ^ this.f3466b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f3465a + ", values=" + this.f3466b + "}";
    }
}

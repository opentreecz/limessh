package com.sonelli;

import androidx.annotation.Nullable;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* renamed from: com.sonelli.a */
/* loaded from: classes.dex */
public final class C0689a<T> extends AbstractC0802c<T> {

    /* renamed from: a */
    public final Integer f1288a;

    /* renamed from: b */
    public final T f1289b;

    /* renamed from: c */
    public final EnumC0854d f1290c;

    public C0689a(@Nullable Integer num, T t, EnumC0854d enumC0854d) {
        this.f1288a = num;
        Objects.requireNonNull(t, "Null payload");
        this.f1289b = t;
        Objects.requireNonNull(enumC0854d, "Null priority");
        this.f1290c = enumC0854d;
    }

    @Override // com.sonelli.AbstractC0802c
    @Nullable
    /* renamed from: a */
    public Integer mo1928a() {
        return this.f1288a;
    }

    @Override // com.sonelli.AbstractC0802c
    /* renamed from: b */
    public T mo1929b() {
        return this.f1289b;
    }

    @Override // com.sonelli.AbstractC0802c
    /* renamed from: c */
    public EnumC0854d mo1930c() {
        return this.f1290c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0802c)) {
            return false;
        }
        AbstractC0802c abstractC0802c = (AbstractC0802c) obj;
        Integer num = this.f1288a;
        if (num != null ? num.equals(abstractC0802c.mo1928a()) : abstractC0802c.mo1928a() == null) {
            if (this.f1289b.equals(abstractC0802c.mo1929b()) && this.f1290c.equals(abstractC0802c.mo1930c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f1288a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f1289b.hashCode()) * 1000003) ^ this.f1290c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f1288a + ", payload=" + this.f1289b + ", priority=" + this.f1290c + "}";
    }
}

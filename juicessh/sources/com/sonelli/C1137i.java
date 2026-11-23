package com.sonelli;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.i */
/* loaded from: classes.dex */
public final class C1137i extends AbstractC1627o {

    /* renamed from: a */
    public final List<AbstractC1794r> f3244a;

    public C1137i(List<AbstractC1794r> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.f3244a = list;
    }

    @Override // com.sonelli.AbstractC1627o
    @NonNull
    /* renamed from: b */
    public List<AbstractC1794r> mo4680b() {
        return this.f3244a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1627o) {
            return this.f3244a.equals(((AbstractC1627o) obj).mo4680b());
        }
        return false;
    }

    public int hashCode() {
        return this.f3244a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f3244a + "}";
    }
}

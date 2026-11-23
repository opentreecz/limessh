package com.sonelli;

import androidx.annotation.NonNull;
import com.sonelli.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class aa0 extends oa0.AbstractC1645d.a.b {

    /* renamed from: a */
    public final String f1359a;

    @Override // com.sonelli.oa0.AbstractC1645d.a.b
    @NonNull
    /* renamed from: a */
    public String mo2030a() {
        return this.f1359a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof oa0.AbstractC1645d.a.b) {
            return this.f1359a.equals(((oa0.AbstractC1645d.a.b) obj).mo2030a());
        }
        return false;
    }

    public int hashCode() {
        return this.f1359a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.f1359a + "}";
    }
}

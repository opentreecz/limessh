package cz.opentree;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.m9 */
/* loaded from: classes.dex */
public final class C1542m9 {

    /* renamed from: a */
    public final Uri f5004a;

    public C1542m9(Uri uri) {
        this.f5004a = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1542m9)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C0758ba.m2404a(((C1542m9) obj).f5004a, this.f5004a);
    }

    public final int hashCode() {
        return C0758ba.m2405b(this.f5004a);
    }
}

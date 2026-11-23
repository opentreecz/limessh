package cz.opentree;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.d0 */
/* loaded from: classes.dex */
public final class C0855d0 {

    /* renamed from: a */
    public final C0746b f2092a;

    /* renamed from: b */
    public final byte[] f2093b;

    public C0855d0(@NonNull C0746b c0746b, @NonNull byte[] bArr) {
        Objects.requireNonNull(c0746b, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.f2092a = c0746b;
        this.f2093b = bArr;
    }

    /* renamed from: a */
    public byte[] m3083a() {
        return this.f2093b;
    }

    /* renamed from: b */
    public C0746b m3084b() {
        return this.f2092a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0855d0)) {
            return false;
        }
        C0855d0 c0855d0 = (C0855d0) obj;
        if (this.f2092a.equals(c0855d0.f2092a)) {
            return Arrays.equals(this.f2093b, c0855d0.f2093b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f2092a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f2093b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f2092a + ", bytes=[...]}";
    }
}

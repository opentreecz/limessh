package cz.opentree;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class p50 {

    /* renamed from: a */
    public final String f5627a;

    /* renamed from: b */
    public final byte[] f5628b;

    public p50(String str, byte[] bArr) {
        this.f5627a = str;
        this.f5628b = bArr;
    }

    public final String toString() {
        String str = this.f5627a;
        int hashCode = Arrays.hashCode(this.f5628b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
        sb.append("KeyAndSerialized: key = ");
        sb.append(str);
        sb.append(" serialized hash = ");
        sb.append(hashCode);
        return sb.toString();
    }
}

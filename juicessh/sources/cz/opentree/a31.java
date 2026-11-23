package cz.opentree;

import java.util.Objects;

/* loaded from: classes.dex */
public final class a31 {

    /* renamed from: a */
    public final byte[][] f1328a;

    public a31(z21 z21Var, byte[][] bArr) {
        Objects.requireNonNull(z21Var, "params == null");
        Objects.requireNonNull(bArr, "publicKey == null");
        if (m31.m6361k(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        }
        if (bArr.length != z21Var.m10325a()) {
            throw new IllegalArgumentException("wrong publicKey size");
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2.length != z21Var.m10327c()) {
                throw new IllegalArgumentException("wrong publicKey format");
            }
        }
        this.f1328a = m31.m6354d(bArr);
    }

    /* renamed from: a */
    public byte[][] m1977a() {
        return m31.m6354d(this.f1328a);
    }
}

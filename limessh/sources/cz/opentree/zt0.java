package cz.opentree;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public class zt0 implements CipherParameters {

    /* renamed from: O */
    public BigInteger f8590O;

    /* renamed from: P */
    public BigInteger f8591P;

    /* renamed from: Q */
    public BigInteger f8592Q;

    /* renamed from: R */
    public cu0 f8593R;

    public zt0(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f8590O = bigInteger3;
        this.f8592Q = bigInteger;
        this.f8591P = bigInteger2;
    }

    public zt0(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, cu0 cu0Var) {
        this.f8590O = bigInteger3;
        this.f8592Q = bigInteger;
        this.f8591P = bigInteger2;
        this.f8593R = cu0Var;
    }

    /* renamed from: a */
    public BigInteger m10628a() {
        return this.f8590O;
    }

    /* renamed from: b */
    public BigInteger m10629b() {
        return this.f8592Q;
    }

    /* renamed from: c */
    public BigInteger m10630c() {
        return this.f8591P;
    }

    /* renamed from: d */
    public cu0 m10631d() {
        return this.f8593R;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zt0)) {
            return false;
        }
        zt0 zt0Var = (zt0) obj;
        return zt0Var.m10629b().equals(this.f8592Q) && zt0Var.m10630c().equals(this.f8591P) && zt0Var.m10628a().equals(this.f8590O);
    }

    public int hashCode() {
        return (m10629b().hashCode() ^ m10630c().hashCode()) ^ m10628a().hashCode();
    }
}

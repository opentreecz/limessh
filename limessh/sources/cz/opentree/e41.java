package cz.opentree;

import java.security.PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class e41 implements PublicKey {

    /* renamed from: O */
    public short[][] f2335O;

    /* renamed from: P */
    public short[][] f2336P;

    /* renamed from: Q */
    public short[] f2337Q;

    /* renamed from: R */
    public int f2338R;

    public e41(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f2338R = i;
        this.f2335O = sArr;
        this.f2336P = sArr2;
        this.f2337Q = sArr3;
    }

    public e41(s41 s41Var) {
        this(s41Var.m8322d(), s41Var.m8319a(), s41Var.m8321c(), s41Var.m8320b());
    }

    /* renamed from: a */
    public short[][] m3428a() {
        return this.f2335O;
    }

    /* renamed from: b */
    public short[] m3429b() {
        return e51.m3439h(this.f2337Q);
    }

    /* renamed from: c */
    public short[][] m3430c() {
        short[][] sArr = new short[this.f2336P.length];
        int i = 0;
        while (true) {
            short[][] sArr2 = this.f2336P;
            if (i == sArr2.length) {
                return sArr;
            }
            sArr[i] = e51.m3439h(sArr2[i]);
            i++;
        }
    }

    /* renamed from: d */
    public int m3431d() {
        return this.f2338R;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof e41)) {
            return false;
        }
        e41 e41Var = (e41) obj;
        return this.f2338R == e41Var.m3431d() && e21.m3393j(this.f2335O, e41Var.m3428a()) && e21.m3393j(this.f2336P, e41Var.m3430c()) && e21.m3392i(this.f2337Q, e41Var.m3429b());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return j41.m5053a(new vs0(PQCObjectIdentifiers.f8876a, er0.f2528O), new v01(this.f2338R, this.f2335O, this.f2336P, this.f2337Q));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.f2338R * 37) + e51.m3452u(this.f2335O)) * 37) + e51.m3452u(this.f2336P)) * 37) + e51.m3451t(this.f2337Q);
    }
}

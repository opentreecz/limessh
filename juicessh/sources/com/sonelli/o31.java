package com.sonelli;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.pqc.jcajce.interfaces.LMSKey;

/* loaded from: classes.dex */
public class o31 implements PublicKey, LMSKey {

    /* renamed from: O */
    public transient j11 f5415O;

    public o31(ws0 ws0Var) throws IOException {
        m6860a(ws0Var);
    }

    /* renamed from: a */
    public final void m6860a(ws0 ws0Var) throws IOException {
        this.f5415O = (j11) k21.m5791a(ws0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o31) {
            try {
                return e51.m3432a(this.f5415O.getEncoded(), ((o31) obj).f5415O.getEncoded());
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return l21.m6045a(this.f5415O).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        try {
            return e51.m3445n(this.f5415O.getEncoded());
        } catch (IOException unused) {
            return -1;
        }
    }
}

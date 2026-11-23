package com.sonelli;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class u31 extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    /* renamed from: a */
    public PrivateKey mo2668a(qs0 qs0Var) throws IOException {
        q01 m7591o = q01.m7591o(qs0Var.m7784q().mo1950f());
        return new q31(new s11(m7591o.m7596q(), m7591o.m7595p(), m7591o.m7593m(), m7591o.m7594n(), m7591o.m7597r(), null));
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
        try {
            qs0 m7779m = qs0.m7779m(eq0.m3546p(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!PQCObjectIdentifiers.f8879d.m3549o(m7779m.m7782n().m9343k())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                }
                q01 m7591o = q01.m7591o(m7779m.m7784q());
                return new q31(new s11(m7591o.m7596q(), m7591o.m7595p(), m7591o.m7593m(), m7591o.m7594n(), m7591o.m7597r(), w31.m9407b(m7591o.m7592k()).mo7097e()));
            } catch (IOException unused) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
            }
        } catch (IOException e) {
            throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e);
        }
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
        try {
            ws0 m9635m = ws0.m9635m(eq0.m3546p(((X509EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!PQCObjectIdentifiers.f8879d.m3549o(m9635m.m9636k().m9343k())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                }
                r01 m7841n = r01.m7841n(m9635m.m9638o());
                return new r31(new t11(m7841n.m7844o(), m7841n.m7845p(), m7841n.m7843m(), w31.m9407b(m7841n.m7842k()).mo7097e()));
            } catch (IOException e) {
                throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e.getMessage());
            }
        } catch (IOException e2) {
            throw new InvalidKeySpecException(e2.toString());
        }
    }

    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        return null;
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }
}

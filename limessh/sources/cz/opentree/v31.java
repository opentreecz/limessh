package cz.opentree;

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
public class v31 extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    /* renamed from: a */
    public PrivateKey mo2668a(qs0 qs0Var) throws IOException {
        s01 m8291n = s01.m8291n(qs0Var.m7784q().mo1950f());
        return new s31(new w11(m8291n.m8295p(), m8291n.m8294o(), m8291n.m8292k(), m8291n.m8293m(), m8291n.m8296q(), m8291n.m8297r(), m8291n.m8298s()));
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
        try {
            qs0 m7779m = qs0.m7779m(eq0.m3546p(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!PQCObjectIdentifiers.f8878c.m3549o(m7779m.m7782n().m9343k())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                }
                s01 m8291n = s01.m8291n(m7779m.m7784q());
                return new s31(new w11(m8291n.m8295p(), m8291n.m8294o(), m8291n.m8292k(), m8291n.m8293m(), m8291n.m8296q(), m8291n.m8297r(), m8291n.m8298s()));
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
                if (!PQCObjectIdentifiers.f8878c.m3549o(m9635m.m9636k().m9343k())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                }
                t01 m8563m = t01.m8563m(m9635m.m9638o());
                return new t31(new x11(m8563m.m8565n(), m8563m.m8566o(), m8563m.m8564k()));
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

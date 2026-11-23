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

/* loaded from: classes.dex */
public class f41 extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    /* renamed from: a */
    public PrivateKey mo2668a(qs0 qs0Var) throws IOException {
        u01 m8824n = u01.m8824n(qs0Var.m7784q());
        return new d41(m8824n.m8827o(), m8824n.m8825k(), m8824n.m8828p(), m8824n.m8826m(), m8824n.m8830r(), m8824n.m8829q());
    }

    /* renamed from: b */
    public PublicKey m3681b(ws0 ws0Var) throws IOException {
        v01 m9136p = v01.m9136p(ws0Var.m9638o());
        return new e41(m9136p.m9140o(), m9136p.m9137k(), m9136p.m9139n(), m9136p.m9138m());
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof r41) {
            return new d41((r41) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return mo2668a(qs0.m7779m(eq0.m3546p(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        }
        throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof s41) {
            return new e41((s41) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return m3681b(ws0.m9635m(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof d41) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (r41.class.isAssignableFrom(cls)) {
                d41 d41Var = (d41) key;
                return new r41(d41Var.m3151c(), d41Var.m3149a(), d41Var.m3152d(), d41Var.m3150b(), d41Var.m3154f(), d41Var.m3153e());
            }
        } else {
            if (!(key instanceof e41)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
            if (s41.class.isAssignableFrom(cls)) {
                e41 e41Var = (e41) key;
                return new s41(e41Var.m3431d(), e41Var.m3428a(), e41Var.m3430c(), e41Var.m3429b());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof d41) || (key instanceof e41)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }
}

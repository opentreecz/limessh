package cz.opentree;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public final class yu0 extends Provider implements ConfigurableProvider {

    /* renamed from: O */
    public static String f8320O = "BouncyCastle Security Provider v1.65";

    /* renamed from: P */
    public static final ProviderConfiguration f8321P = new zu0();

    /* renamed from: Q */
    public static final Map f8322Q = new HashMap();

    /* renamed from: R */
    public static final String[] f8323R = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};

    /* renamed from: S */
    public static final String[] f8324S = {"SipHash", "SipHash128", "Poly1305"};

    /* renamed from: T */
    public static final String[] f8325T = {"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc"};

    /* renamed from: U */
    public static final String[] f8326U = {"X509", "IES"};

    /* renamed from: V */
    public static final String[] f8327V = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};

    /* renamed from: W */
    public static final String[] f8328W = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka"};

    /* renamed from: X */
    public static final String[] f8329X = {"BC", "BCFKS", "PKCS12"};

    /* renamed from: Y */
    public static final String[] f8330Y = {"DRBG"};

    /* renamed from: cz.opentree.yu0$a */
    /* loaded from: classes.dex */
    public class C2393a implements PrivilegedAction {
        public C2393a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            yu0.this.m10229k();
            return null;
        }
    }

    public yu0() {
        super("BC", 1.65d, f8320O);
        AccessController.doPrivileged(new C2393a());
    }

    /* renamed from: d */
    public static AsymmetricKeyInfoConverter m10224d(aq0 aq0Var) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        Map map = f8322Q;
        synchronized (map) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) map.get(aq0Var);
        }
        return asymmetricKeyInfoConverter;
    }

    /* renamed from: e */
    public static PrivateKey m10225e(qs0 qs0Var) throws IOException {
        AsymmetricKeyInfoConverter m10224d = m10224d(qs0Var.m7782n().m9343k());
        if (m10224d == null) {
            return null;
        }
        return m10224d.mo2668a(qs0Var);
    }

    /* renamed from: c */
    public void m10226c(aq0 aq0Var, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        Map map = f8322Q;
        synchronized (map) {
            map.put(aq0Var, asymmetricKeyInfoConverter);
        }
    }

    /* renamed from: i */
    public final void m10227i(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            Class m9642a = wu0.m9642a(yu0.class, str + strArr[i] + "$Mappings");
            if (m9642a != null) {
                try {
                    ((xu0) m9642a.newInstance()).m9895a(this);
                } catch (Exception e) {
                    throw new InternalError("cannot create instance of " + str + strArr[i] + "$Mappings : " + e);
                }
            }
        }
    }

    /* renamed from: j */
    public final void m10228j() {
        m10226c(PQCObjectIdentifiers.f8880e, new i41());
        m10226c(PQCObjectIdentifiers.f8881f, new z31());
        m10226c(PQCObjectIdentifiers.f8882g, new p41());
        m10226c(IsaraObjectIdentifiers.f8732a, new p41());
        m10226c(PQCObjectIdentifiers.f8887l, new q41());
        m10226c(IsaraObjectIdentifiers.f8733b, new q41());
        m10226c(PQCObjectIdentifiers.f8878c, new v31());
        m10226c(PQCObjectIdentifiers.f8879d, new u31());
        m10226c(PQCObjectIdentifiers.f8876a, new f41());
        m10226c(PQCObjectIdentifiers.f8892q, new c41());
        m10226c(PQCObjectIdentifiers.f8893r, new c41());
        m10226c(PKCSObjectIdentifiers.f8758l, new p31());
    }

    /* renamed from: k */
    public final void m10229k() {
        m10227i("org.bouncycastle.jcajce.provider.digest.", f8328W);
        m10227i("org.bouncycastle.jcajce.provider.symmetric.", f8323R);
        m10227i("org.bouncycastle.jcajce.provider.symmetric.", f8324S);
        m10227i("org.bouncycastle.jcajce.provider.symmetric.", f8325T);
        m10227i("org.bouncycastle.jcajce.provider.asymmetric.", f8326U);
        m10227i("org.bouncycastle.jcajce.provider.asymmetric.", f8327V);
        m10227i("org.bouncycastle.jcajce.provider.keystore.", f8329X);
        m10227i("org.bouncycastle.jcajce.provider.drbg.", f8330Y);
        m10228j();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertPathValidator.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }
}

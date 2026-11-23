package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: CipherSuite.java */
/* loaded from: classes.dex */
public final class km0 {

    /* renamed from: b */
    public static final Comparator<String> f4597b = new C1465a();

    /* renamed from: c */
    public static final Map<String, km0> f4598c = new LinkedHashMap();

    /* renamed from: d */
    public static final km0 f4599d;

    /* renamed from: e */
    public static final km0 f4600e;

    /* renamed from: f */
    public static final km0 f4601f;

    /* renamed from: g */
    public static final km0 f4602g;

    /* renamed from: h */
    public static final km0 f4603h;

    /* renamed from: i */
    public static final km0 f4604i;

    /* renamed from: j */
    public static final km0 f4605j;

    /* renamed from: k */
    public static final km0 f4606k;

    /* renamed from: l */
    public static final km0 f4607l;

    /* renamed from: m */
    public static final km0 f4608m;

    /* renamed from: n */
    public static final km0 f4609n;

    /* renamed from: o */
    public static final km0 f4610o;

    /* renamed from: p */
    public static final km0 f4611p;

    /* renamed from: q */
    public static final km0 f4612q;

    /* renamed from: r */
    public static final km0 f4613r;

    /* renamed from: s */
    public static final km0 f4614s;

    /* renamed from: t */
    public static final km0 f4615t;

    /* renamed from: u */
    public static final km0 f4616u;

    /* renamed from: a */
    public final String f4617a;

    /* compiled from: CipherSuite.java */
    /* renamed from: com.sonelli.km0$a */
    /* loaded from: classes.dex */
    public class C1465a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i = 4; i < min; i++) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    static {
        m5951c("SSL_RSA_WITH_NULL_MD5", 1);
        m5951c("SSL_RSA_WITH_NULL_SHA", 2);
        m5951c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        m5951c("SSL_RSA_WITH_RC4_128_MD5", 4);
        m5951c("SSL_RSA_WITH_RC4_128_SHA", 5);
        m5951c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        m5951c("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f4599d = m5951c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m5951c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        m5951c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        m5951c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        m5951c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        m5951c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        m5951c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        m5951c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        m5951c("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        m5951c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        m5951c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        m5951c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        m5951c("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        m5951c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        m5951c("TLS_KRB5_WITH_RC4_128_SHA", 32);
        m5951c("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        m5951c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        m5951c("TLS_KRB5_WITH_RC4_128_MD5", 36);
        m5951c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        m5951c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        m5951c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        m5951c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f4600e = m5951c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        m5951c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        m5951c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        m5951c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f4601f = m5951c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        m5951c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        m5951c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        m5951c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        m5951c("TLS_RSA_WITH_NULL_SHA256", 59);
        m5951c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        m5951c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        m5951c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        m5951c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        m5951c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        m5951c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        m5951c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        m5951c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        m5951c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        m5951c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        m5951c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        m5951c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", KeycodeConstants.KEYCODE_F2);
        m5951c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", KeycodeConstants.KEYCODE_F5);
        m5951c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", KeycodeConstants.KEYCODE_F6);
        m5951c("TLS_PSK_WITH_RC4_128_SHA", KeycodeConstants.KEYCODE_F8);
        m5951c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", KeycodeConstants.KEYCODE_F9);
        m5951c("TLS_PSK_WITH_AES_128_CBC_SHA", KeycodeConstants.KEYCODE_F10);
        m5951c("TLS_PSK_WITH_AES_256_CBC_SHA", KeycodeConstants.KEYCODE_F11);
        m5951c("TLS_RSA_WITH_SEED_CBC_SHA", KeycodeConstants.KEYCODE_NUMPAD_6);
        f4602g = m5951c("TLS_RSA_WITH_AES_128_GCM_SHA256", KeycodeConstants.KEYCODE_NUMPAD_SUBTRACT);
        f4603h = m5951c("TLS_RSA_WITH_AES_256_GCM_SHA384", KeycodeConstants.KEYCODE_NUMPAD_ADD);
        m5951c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", KeycodeConstants.KEYCODE_NUMPAD_DOT);
        m5951c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", KeycodeConstants.KEYCODE_NUMPAD_COMMA);
        m5951c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", KeycodeConstants.KEYCODE_NUMPAD_LEFT_PAREN);
        m5951c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", KeycodeConstants.KEYCODE_NUMPAD_RIGHT_PAREN);
        m5951c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", KeycodeConstants.KEYCODE_CHANNEL_UP);
        m5951c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", KeycodeConstants.KEYCODE_CHANNEL_DOWN);
        m5951c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        m5951c("TLS_FALLBACK_SCSV", 22016);
        m5951c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        m5951c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        m5951c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        m5951c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        m5951c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        m5951c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        m5951c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        m5951c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        m5951c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        m5951c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        m5951c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        m5951c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        m5951c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        m5951c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        m5951c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        m5951c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        m5951c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        m5951c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f4604i = m5951c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f4605j = m5951c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        m5951c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        m5951c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        m5951c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        m5951c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        m5951c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        m5951c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        m5951c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        m5951c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        m5951c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        m5951c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        m5951c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        m5951c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        m5951c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f4606k = m5951c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f4607l = m5951c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        m5951c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        m5951c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f4608m = m5951c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f4609n = m5951c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        m5951c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        m5951c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        m5951c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        m5951c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f4610o = m5951c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f4611p = m5951c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        m5951c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        m5951c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        f4612q = m5951c("TLS_AES_128_GCM_SHA256", 4865);
        f4613r = m5951c("TLS_AES_256_GCM_SHA384", 4866);
        f4614s = m5951c("TLS_CHACHA20_POLY1305_SHA256", 4867);
        f4615t = m5951c("TLS_AES_128_CCM_SHA256", 4868);
        f4616u = m5951c("TLS_AES_256_CCM_8_SHA256", 4869);
    }

    public km0(String str) {
        Objects.requireNonNull(str);
        this.f4617a = str;
    }

    /* renamed from: a */
    public static synchronized km0 m5949a(String str) {
        km0 km0Var;
        synchronized (km0.class) {
            Map<String, km0> map = f4598c;
            km0Var = map.get(str);
            if (km0Var == null) {
                km0Var = map.get(m5952d(str));
                if (km0Var == null) {
                    km0Var = new km0(str);
                }
                map.put(str, km0Var);
            }
        }
        return km0Var;
    }

    /* renamed from: b */
    public static List<km0> m5950b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m5949a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: c */
    public static km0 m5951c(String str, int i) {
        km0 km0Var = new km0(str);
        f4598c.put(str, km0Var);
        return km0Var;
    }

    /* renamed from: d */
    public static String m5952d(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String toString() {
        return this.f4617a;
    }
}

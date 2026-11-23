package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* loaded from: classes.dex */
public final class r21 implements XMSSOid {

    /* renamed from: c */
    public static final Map<String, r21> f6164c;

    /* renamed from: a */
    public final int f6165a;

    /* renamed from: b */
    public final String f6166b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(m7851b("SHA-256", 32, 16, 67, 10), new r21(1, "XMSS_SHA2_10_256"));
        hashMap.put(m7851b("SHA-256", 32, 16, 67, 16), new r21(2, "XMSS_SHA2_16_256"));
        hashMap.put(m7851b("SHA-256", 32, 16, 67, 20), new r21(3, "XMSS_SHA2_20_256"));
        hashMap.put(m7851b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 10), new r21(4, "XMSS_SHA2_10_512"));
        hashMap.put(m7851b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 16), new r21(5, "XMSS_SHA2_16_512"));
        hashMap.put(m7851b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 20), new r21(6, "XMSS_SHA2_20_512"));
        hashMap.put(m7851b("SHAKE128", 32, 16, 67, 10), new r21(7, "XMSS_SHAKE_10_256"));
        hashMap.put(m7851b("SHAKE128", 32, 16, 67, 16), new r21(8, "XMSS_SHAKE_16_256"));
        hashMap.put(m7851b("SHAKE128", 32, 16, 67, 20), new r21(9, "XMSS_SHAKE_20_256"));
        hashMap.put(m7851b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 10), new r21(10, "XMSS_SHAKE_10_512"));
        hashMap.put(m7851b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 16), new r21(11, "XMSS_SHAKE_16_512"));
        hashMap.put(m7851b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 20), new r21(12, "XMSS_SHAKE_20_512"));
        f6164c = Collections.unmodifiableMap(hashMap);
    }

    public r21(int i, String str) {
        this.f6165a = i;
        this.f6166b = str;
    }

    /* renamed from: b */
    public static String m7851b(String str, int i, int i2, int i3, int i4) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4;
    }

    /* renamed from: c */
    public static r21 m7852c(String str, int i, int i2, int i3, int i4) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f6164c.get(m7851b(str, i, i2, i3, i4));
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    /* renamed from: a */
    public int mo7606a() {
        return this.f6165a;
    }

    public String toString() {
        return this.f6166b;
    }
}

package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* loaded from: classes.dex */
public final class y21 implements XMSSOid {

    /* renamed from: c */
    public static final Map<String, y21> f8117c;

    /* renamed from: a */
    public final int f8118a;

    /* renamed from: b */
    public final String f8119b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(m10055b("SHA-256", 32, 16, 67), new y21(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(m10055b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1), new y21(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(m10055b("SHAKE128", 32, 16, 67), new y21(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(m10055b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1), new y21(67108868, "WOTSP_SHAKE256_W16"));
        f8117c = Collections.unmodifiableMap(hashMap);
    }

    public y21(int i, String str) {
        this.f8118a = i;
        this.f8119b = str;
    }

    /* renamed from: b */
    public static String m10055b(String str, int i, int i2, int i3) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i + "-" + i2 + "-" + i3;
    }

    /* renamed from: c */
    public static y21 m10056c(String str, int i, int i2, int i3) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f8117c.get(m10055b(str, i, i2, i3));
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    /* renamed from: a */
    public int mo7606a() {
        return this.f8118a;
    }

    public String toString() {
        return this.f8119b;
    }
}

package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* loaded from: classes.dex */
public final class q21 implements XMSSOid {

    /* renamed from: c */
    public static final Map<String, q21> f5923c;

    /* renamed from: a */
    public final int f5924a;

    /* renamed from: b */
    public final String f5925b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 20, 2), new q21(1, "XMSSMT_SHA2_20/2_256"));
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 20, 4), new q21(2, "XMSSMT_SHA2_20/4_256"));
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 40, 2), new q21(3, "XMSSMT_SHA2_40/2_256"));
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 40, 2), new q21(4, "XMSSMT_SHA2_40/4_256"));
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 40, 4), new q21(5, "XMSSMT_SHA2_40/8_256"));
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 60, 8), new q21(6, "XMSSMT_SHA2_60/3_256"));
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 60, 6), new q21(7, "XMSSMT_SHA2_60/6_256"));
        hashMap.put(m7604b("SHA-256", 32, 16, 67, 60, 12), new q21(8, "XMSSMT_SHA2_60/12_256"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 20, 2), new q21(9, "XMSSMT_SHA2_20/2_512"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 20, 4), new q21(10, "XMSSMT_SHA2_20/4_512"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 40, 2), new q21(11, "XMSSMT_SHA2_40/2_512"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 40, 4), new q21(12, "XMSSMT_SHA2_40/4_512"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 40, 8), new q21(13, "XMSSMT_SHA2_40/8_512"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 60, 3), new q21(14, "XMSSMT_SHA2_60/3_512"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 60, 6), new q21(15, "XMSSMT_SHA2_60/6_512"));
        hashMap.put(m7604b("SHA-512", 64, 16, KeycodeConstants.KEYCODE_F1, 60, 12), new q21(16, "XMSSMT_SHA2_60/12_512"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 20, 2), new q21(17, "XMSSMT_SHAKE_20/2_256"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 20, 4), new q21(18, "XMSSMT_SHAKE_20/4_256"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 40, 2), new q21(19, "XMSSMT_SHAKE_40/2_256"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 40, 4), new q21(20, "XMSSMT_SHAKE_40/4_256"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 40, 8), new q21(21, "XMSSMT_SHAKE_40/8_256"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 60, 3), new q21(22, "XMSSMT_SHAKE_60/3_256"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 60, 6), new q21(23, "XMSSMT_SHAKE_60/6_256"));
        hashMap.put(m7604b("SHAKE128", 32, 16, 67, 60, 12), new q21(24, "XMSSMT_SHAKE_60/12_256"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 20, 2), new q21(25, "XMSSMT_SHAKE_20/2_512"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 20, 4), new q21(26, "XMSSMT_SHAKE_20/4_512"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 40, 2), new q21(27, "XMSSMT_SHAKE_40/2_512"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 40, 4), new q21(28, "XMSSMT_SHAKE_40/4_512"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 40, 8), new q21(29, "XMSSMT_SHAKE_40/8_512"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 60, 3), new q21(30, "XMSSMT_SHAKE_60/3_512"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 60, 6), new q21(31, "XMSSMT_SHAKE_60/6_512"));
        hashMap.put(m7604b("SHAKE256", 64, 16, KeycodeConstants.KEYCODE_F1, 60, 12), new q21(32, "XMSSMT_SHAKE_60/12_512"));
        f5923c = Collections.unmodifiableMap(hashMap);
    }

    public q21(int i, String str) {
        this.f5924a = i;
        this.f5925b = str;
    }

    /* renamed from: b */
    public static String m7604b(String str, int i, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4 + "-" + i5;
    }

    /* renamed from: c */
    public static q21 m7605c(String str, int i, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f5923c.get(m7604b(str, i, i2, i3, i4, i5));
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    /* renamed from: a */
    public int mo7606a() {
        return this.f5924a;
    }

    public String toString() {
        return this.f5925b;
    }
}

package com.sonelli;

import android.util.Base64;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.ae */
/* loaded from: classes.dex */
public final class C0707ae {

    /* renamed from: a */
    public static final Random f1369a = new Random();

    /* renamed from: a */
    public static String m2045a() {
        byte[] bArr = new byte[16];
        f1369a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}

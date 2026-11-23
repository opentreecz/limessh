package cz.opentree;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class y10 {
    @Nullable
    /* renamed from: a */
    public static String m10048a(String str, String[] strArr, String[] strArr2) {
        C0813ca.m2729k(strArr);
        C0813ca.m2729k(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i];
            }
        }
        return null;
    }
}

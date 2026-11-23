package com.sonelli;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.File;

/* loaded from: classes.dex */
public final class s50 {
    /* renamed from: a */
    public static int m8331a() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(Build.VERSION.SDK);
            v50.m9168c(valueOf.length() != 0 ? "Invalid version number: ".concat(valueOf) : new String("Invalid version number: "));
            return 0;
        }
    }

    @TargetApi(9)
    /* renamed from: b */
    public static boolean m8332b(String str) {
        if (m8331a() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}

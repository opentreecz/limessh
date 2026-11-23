package com.sonelli;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.mc */
/* loaded from: classes.dex */
public class C1547mc {

    /* renamed from: a */
    public static String f5016a;

    /* renamed from: b */
    public static int f5017b;

    @Nullable
    /* renamed from: a */
    public static String m6396a() {
        if (f5016a == null) {
            if (f5017b == 0) {
                f5017b = Process.myPid();
            }
            f5016a = m6397b(f5017b);
        }
        return f5016a;
    }

    @Nullable
    /* renamed from: b */
    public static String m6397b(int i) {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = m6398c(sb.toString());
            try {
                str = bufferedReader.readLine().trim();
                C1155ic.m4744a(bufferedReader);
            } catch (IOException unused) {
                C1155ic.m4744a(bufferedReader);
                return str;
            } catch (Throwable th2) {
                th = th2;
                C1155ic.m4744a(bufferedReader);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return str;
    }

    /* renamed from: c */
    public static BufferedReader m6398c(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}

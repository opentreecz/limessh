package com.sonelli;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ll */
/* loaded from: classes.dex */
public final class C1513ll {
    /* renamed from: a */
    public static C1165il m6250a(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                HashMap hashMap = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String valueOf = String.valueOf(file);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
                        sb.append("Parsed ");
                        sb.append(valueOf);
                        Log.i("HermeticFileOverrides", sb.toString());
                        C1165il c1165il = new C1165il(hashMap);
                        bufferedReader.close();
                        return c1165il;
                    }
                    String[] split = readLine.split(" ", 3);
                    if (split.length != 3) {
                        String valueOf2 = String.valueOf(readLine);
                        Log.e("HermeticFileOverrides", valueOf2.length() != 0 ? "Invalid: ".concat(valueOf2) : new String("Invalid: "));
                    } else {
                        String str = split[0];
                        String decode = Uri.decode(split[1]);
                        String decode2 = Uri.decode(split[2]);
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, new HashMap());
                        }
                        ((Map) hashMap.get(str)).put(decode, decode2);
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public static AbstractC2358yl<C1165il> m6251b(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && ((str3.equals("goldfish") || str3.equals("ranchu") || str3.equals("robolectric")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            z = true;
        }
        if (!z) {
            return AbstractC2358yl.m10188d();
        }
        if (C0834cl.m2864a() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        AbstractC2358yl<File> m6252c = m6252c(context);
        return m6252c.mo9580b() ? AbstractC2358yl.m10187a(m6250a(m6252c.mo9581c())) : AbstractC2358yl.m10188d();
    }

    /* renamed from: c */
    public static AbstractC2358yl<File> m6252c(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? AbstractC2358yl.m10187a(file) : AbstractC2358yl.m10188d();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            return AbstractC2358yl.m10188d();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}

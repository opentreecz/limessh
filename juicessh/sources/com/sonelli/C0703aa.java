package com.sonelli;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.aa */
/* loaded from: classes.dex */
public class C0703aa {

    /* renamed from: b */
    public static final C2267x9 f1356b = new C2267x9("LibraryVersion", "");

    /* renamed from: c */
    public static C0703aa f1357c = new C0703aa();

    /* renamed from: a */
    public ConcurrentHashMap<String, String> f1358a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static C0703aa m2028a() {
        return f1357c;
    }

    /* renamed from: b */
    public String m2029b(@NonNull String str) {
        C0813ca.m2726h(str, "Please provide a valid libraryName");
        if (this.f1358a.containsKey(str)) {
            return this.f1358a.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = C0703aa.class.getResourceAsStream(String.format("/%s.properties", str));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty("version", null);
                C2267x9 c2267x9 = f1356b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                c2267x9.m9744d("LibraryVersion", sb.toString());
            } else {
                C2267x9 c2267x92 = f1356b;
                String valueOf = String.valueOf(str);
                c2267x92.m9745e("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e) {
            C2267x9 c2267x93 = f1356b;
            String valueOf2 = String.valueOf(str);
            c2267x93.m9743c("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e);
        }
        if (str2 == null) {
            f1356b.m9742b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.f1358a.put(str, str2);
        return str2;
    }
}

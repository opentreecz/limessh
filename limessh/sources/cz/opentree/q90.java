package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class q90 {

    /* renamed from: a */
    public String f5965a = null;

    /* renamed from: b */
    public final ConcurrentHashMap<String, String> f5966b = new ConcurrentHashMap<>();

    /* renamed from: c */
    public static String m7638c(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    @NonNull
    /* renamed from: a */
    public Map<String, String> m7639a() {
        return Collections.unmodifiableMap(this.f5966b);
    }

    @Nullable
    /* renamed from: b */
    public String m7640b() {
        return this.f5965a;
    }

    /* renamed from: d */
    public void m7641d(String str) {
        this.f5965a = m7638c(str);
    }
}

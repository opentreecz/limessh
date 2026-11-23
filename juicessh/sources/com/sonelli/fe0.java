package com.sonelli;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class fe0 {

    /* renamed from: a */
    public final SharedPreferences f2667a;

    /* renamed from: b */
    public final Context f2668b;

    /* renamed from: c */
    @GuardedBy("this")
    public final Map<String, Long> f2669c = new ArrayMap();

    public fe0(Context context) {
        this.f2668b = context;
        this.f2667a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || m3740f()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            m3737c();
            FirebaseInstanceId.m1866b().m1892w();
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    /* renamed from: b */
    public static String m3734b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: g */
    public static String m3735g(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: a */
    public final synchronized ee0 m3736a(String str, String str2, String str3) {
        return ee0.m3479a(this.f2667a.getString(m3735g(str, str2, str3), null));
    }

    /* renamed from: c */
    public final synchronized void m3737c() {
        this.f2669c.clear();
        this.f2667a.edit().clear().commit();
    }

    /* renamed from: d */
    public final synchronized void m3738d(String str, String str2, String str3, String str4, String str5) {
        String m3480b = ee0.m3480b(str4, str5, System.currentTimeMillis());
        if (m3480b == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f2667a.edit();
        edit.putString(m3735g(str, str2, str3), m3480b);
        edit.commit();
    }

    /* renamed from: e */
    public final synchronized long m3739e(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (this.f2667a.contains(m3734b(str, "cre"))) {
            currentTimeMillis = m3742i(str);
        } else {
            SharedPreferences.Editor edit = this.f2667a.edit();
            edit.putString(m3734b(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        }
        this.f2669c.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    /* renamed from: f */
    public final synchronized boolean m3740f() {
        return this.f2667a.getAll().isEmpty();
    }

    /* renamed from: h */
    public final synchronized void m3741h(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f2667a.edit();
        for (String str2 : this.f2667a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    /* renamed from: i */
    public final long m3742i(String str) {
        String string = this.f2667a.getString(m3734b(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}

package com.sonelli;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: com.sonelli.r3 */
/* loaded from: classes.dex */
public final class C1798r3 {

    /* renamed from: a */
    public SharedPreferences f6167a;

    public C1798r3(Context context) {
        try {
            Context m2678c = C0810c7.m2678c(context);
            this.f6167a = m2678c == null ? null : m2678c.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f6167a = null;
        }
    }

    /* renamed from: a */
    public final boolean m7853a(String str, boolean z) {
        try {
            SharedPreferences sharedPreferences = this.f6167a;
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }

    /* renamed from: b */
    public final float m7854b(String str, float f) {
        try {
            SharedPreferences sharedPreferences = this.f6167a;
            if (sharedPreferences == null) {
                return 0.0f;
            }
            return sharedPreferences.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    /* renamed from: c */
    public final String m7855c(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.f6167a;
            return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }
}

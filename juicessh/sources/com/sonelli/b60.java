package com.sonelli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class b60 {
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public static void m2391a(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }
}

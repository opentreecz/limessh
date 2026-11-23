package com.sonelli;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class h90 implements InstallIdProvider {

    /* renamed from: f */
    public static final Pattern f3121f = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: g */
    public static final String f3122g = Pattern.quote("/");

    /* renamed from: a */
    public final i90 f3123a;

    /* renamed from: b */
    public final Context f3124b;

    /* renamed from: c */
    public final String f3125c;

    /* renamed from: d */
    public final FirebaseInstanceIdInternal f3126d;

    /* renamed from: e */
    public String f3127e;

    public h90(Context context, String str, FirebaseInstanceIdInternal firebaseInstanceIdInternal) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f3124b = context;
        this.f3125c = str;
        this.f3126d = firebaseInstanceIdInternal;
        this.f3123a = new i90();
    }

    /* renamed from: c */
    public static String m4387c(String str) {
        if (str == null) {
            return null;
        }
        return f3121f.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    @NonNull
    /* renamed from: a */
    public synchronized String mo1740a() {
        String str = this.f3127e;
        if (str != null) {
            return str;
        }
        SharedPreferences m9441t = w80.m9441t(this.f3124b);
        String id = this.f3126d.getId();
        String string = m9441t.getString("firebase.installation.id", null);
        if (string != null) {
            if (string.equals(id)) {
                this.f3127e = m9441t.getString("crashlytics.installation.id", null);
                m80.m6375f().m6377b("Found matching FID, using Crashlytics IID: " + this.f3127e);
                if (this.f3127e == null) {
                    this.f3127e = m4388b(id, m9441t);
                }
            } else {
                this.f3127e = m4388b(id, m9441t);
            }
            return this.f3127e;
        }
        SharedPreferences m9436o = w80.m9436o(this.f3124b);
        String string2 = m9436o.getString("crashlytics.installation.id", null);
        m80.m6375f().m6377b("No cached FID; legacy id is " + string2);
        if (string2 == null) {
            this.f3127e = m4388b(id, m9441t);
        } else {
            this.f3127e = string2;
            m4394i(string2, id, m9441t, m9436o);
        }
        return this.f3127e;
    }

    /* renamed from: b */
    public final synchronized String m4388b(String str, SharedPreferences sharedPreferences) {
        String m4387c;
        m4387c = m4387c(UUID.randomUUID().toString());
        m80.m6375f().m6377b("Created new Crashlytics IID: " + m4387c);
        sharedPreferences.edit().putString("crashlytics.installation.id", m4387c).putString("firebase.installation.id", str).apply();
        return m4387c;
    }

    /* renamed from: d */
    public String m4389d() {
        return this.f3125c;
    }

    /* renamed from: e */
    public String m4390e() {
        return this.f3123a.m4731a(this.f3124b);
    }

    /* renamed from: f */
    public String m4391f() {
        return String.format(Locale.US, "%s/%s", m4395j(Build.MANUFACTURER), m4395j(Build.MODEL));
    }

    /* renamed from: g */
    public String m4392g() {
        return m4395j(Build.VERSION.INCREMENTAL);
    }

    /* renamed from: h */
    public String m4393h() {
        return m4395j(Build.VERSION.RELEASE);
    }

    /* renamed from: i */
    public final synchronized void m4394i(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        m80.m6375f().m6377b("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    /* renamed from: j */
    public final String m4395j(String str) {
        return str.replaceAll(f3122g, "");
    }
}

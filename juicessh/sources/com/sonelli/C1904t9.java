package com.sonelli;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.base.R$string;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.t9 */
/* loaded from: classes.dex */
public final class C1904t9 {

    /* renamed from: a */
    @GuardedBy("sCache")
    public static final SimpleArrayMap<String, String> f6725a = new SimpleArrayMap<>();

    /* renamed from: a */
    public static String m8607a(Context context) {
        String packageName = context.getPackageName();
        try {
            return C2272xc.m9755a(context).m9467d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    /* renamed from: b */
    public static String m8608b(Context context) {
        return context.getResources().getString(R$string.common_google_play_services_notification_channel_name);
    }

    @NonNull
    /* renamed from: c */
    public static String m8609c(Context context, int i) {
        Resources resources = context.getResources();
        return i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(R$string.common_google_play_services_enable_button) : resources.getString(R$string.common_google_play_services_update_button) : resources.getString(R$string.common_google_play_services_install_button);
    }

    @NonNull
    /* renamed from: d */
    public static String m8610d(Context context, int i) {
        Resources resources = context.getResources();
        String m8607a = m8607a(context);
        if (i == 1) {
            return resources.getString(R$string.common_google_play_services_install_text, m8607a);
        }
        if (i == 2) {
            return C0981fc.m3712c(context) ? resources.getString(R$string.common_google_play_services_wear_update_text) : resources.getString(R$string.common_google_play_services_update_text, m8607a);
        }
        if (i == 3) {
            return resources.getString(R$string.common_google_play_services_enable_text, m8607a);
        }
        if (i == 5) {
            return m8615i(context, "common_google_play_services_invalid_account_text", m8607a);
        }
        if (i == 7) {
            return m8615i(context, "common_google_play_services_network_error_text", m8607a);
        }
        if (i == 9) {
            return resources.getString(R$string.common_google_play_services_unsupported_text, m8607a);
        }
        if (i == 20) {
            return m8615i(context, "common_google_play_services_restricted_profile_text", m8607a);
        }
        switch (i) {
            case 16:
                return m8615i(context, "common_google_play_services_api_unavailable_text", m8607a);
            case 17:
                return m8615i(context, "common_google_play_services_sign_in_failed_text", m8607a);
            case 18:
                return resources.getString(R$string.common_google_play_services_updating_text, m8607a);
            default:
                return resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue, m8607a);
        }
    }

    @NonNull
    /* renamed from: e */
    public static String m8611e(Context context, int i) {
        return (i == 6 || i == 19) ? m8615i(context, "common_google_play_services_resolution_required_text", m8607a(context)) : m8610d(context, i);
    }

    @NonNull
    /* renamed from: f */
    public static String m8612f(Context context, int i) {
        String m8614h = i == 6 ? m8614h(context, "common_google_play_services_resolution_required_title") : m8613g(context, i);
        return m8614h == null ? context.getResources().getString(R$string.common_google_play_services_notification_ticker) : m8614h;
    }

    @Nullable
    /* renamed from: g */
    public static String m8613g(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R$string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R$string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R$string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m8614h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m8614h(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m8614h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m8614h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    @Nullable
    /* renamed from: h */
    public static String m8614h(Context context, String str) {
        SimpleArrayMap<String, String> simpleArrayMap = f6725a;
        synchronized (simpleArrayMap) {
            String str2 = simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources m2392d = C0755b7.m2392d(context);
            if (m2392d == null) {
                return null;
            }
            int identifier = m2392d.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = m2392d.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                simpleArrayMap.put(str, string);
                return string;
            }
            String valueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    /* renamed from: i */
    public static String m8615i(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String m8614h = m8614h(context, str);
        if (m8614h == null) {
            m8614h = resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, m8614h, str2);
    }
}

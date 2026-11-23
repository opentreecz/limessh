package com.sonelli;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ju */
/* loaded from: classes.dex */
public final class C1236ju extends p00 {

    /* renamed from: c */
    public long f3653c;

    /* renamed from: d */
    public String f3654d;

    /* renamed from: e */
    public Boolean f3655e;

    /* renamed from: f */
    public AccountManager f3656f;

    /* renamed from: g */
    public Boolean f3657g;

    /* renamed from: h */
    public long f3658h;

    public C1236ju(C2144uz c2144uz) {
        super(c2144uz);
    }

    @WorkerThread
    /* renamed from: A */
    public final boolean m5192A() {
        Account[] result;
        mo7585d();
        long mo1177a = mo1483i().mo1177a();
        if (mo1177a - this.f3658h > 86400000) {
            this.f3657g = null;
        }
        Boolean bool = this.f3657g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(mo1482h(), "android.permission.GET_ACCOUNTS") != 0) {
            mo1484j().m8526L().m9083a("Permission error checking for dasher/unicorn accounts");
            this.f3658h = mo1177a;
            this.f3657g = Boolean.FALSE;
            return false;
        }
        if (this.f3656f == null) {
            this.f3656f = AccountManager.get(mo1482h());
        }
        try {
            result = this.f3656f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            mo1484j().m8523I().m9084b("Exception checking account types", e);
        }
        if (result != null && result.length > 0) {
            this.f3657g = Boolean.TRUE;
            this.f3658h = mo1177a;
            return true;
        }
        Account[] result2 = this.f3656f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.f3657g = Boolean.TRUE;
            this.f3658h = mo1177a;
            return true;
        }
        this.f3658h = mo1177a;
        this.f3657g = Boolean.FALSE;
        return false;
    }

    @Override // com.sonelli.p00
    /* renamed from: t */
    public final boolean mo3597t() {
        Calendar calendar = Calendar.getInstance();
        this.f3653c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f3654d = sb.toString();
        return false;
    }

    /* renamed from: v */
    public final boolean m5193v(Context context) {
        if (this.f3655e == null) {
            mo1480f();
            this.f3655e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f3655e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f3655e.booleanValue();
    }

    /* renamed from: w */
    public final long m5194w() {
        m7166q();
        return this.f3653c;
    }

    /* renamed from: x */
    public final String m5195x() {
        m7166q();
        return this.f3654d;
    }

    @WorkerThread
    /* renamed from: y */
    public final long m5196y() {
        mo7585d();
        return this.f3658h;
    }

    @WorkerThread
    /* renamed from: z */
    public final void m5197z() {
        mo7585d();
        this.f3657g = null;
        this.f3658h = 0L;
    }
}

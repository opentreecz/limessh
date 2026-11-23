package com.sonelli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class fc0 implements SettingsDataProvider {

    /* renamed from: a */
    public final Context f2655a;

    /* renamed from: b */
    public final nc0 f2656b;

    /* renamed from: c */
    public final gc0 f2657c;

    /* renamed from: d */
    public final CurrentTimeProvider f2658d;

    /* renamed from: e */
    public final cc0 f2659e;

    /* renamed from: f */
    public final SettingsSpiCall f2660f;

    /* renamed from: g */
    public final c90 f2661g;

    /* renamed from: h */
    public final AtomicReference<Settings> f2662h;

    /* renamed from: i */
    public final AtomicReference<k60<jc0>> f2663i;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.fc0$a */
    /* loaded from: classes.dex */
    public class C0982a implements SuccessContinuation<Void, Void> {
        public C0982a() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j60<Void> mo1557a(@Nullable Void r5) throws Exception {
            JSONObject mo1847a = fc0.this.f2660f.mo1847a(fc0.this.f2656b, true);
            if (mo1847a != null) {
                mc0 m4114b = fc0.this.f2657c.m4114b(mo1847a);
                fc0.this.f2659e.m2761c(m4114b.m6400d(), mo1847a);
                fc0.this.m3729q(mo1847a, "Loaded settings: ");
                fc0 fc0Var = fc0.this;
                fc0Var.m3730r(fc0Var.f2656b.f5253f);
                fc0.this.f2662h.set(m4114b);
                ((k60) fc0.this.f2663i.get()).m5846e(m4114b.m6399c());
                k60 k60Var = new k60();
                k60Var.m5846e(m4114b.m6399c());
                fc0.this.f2663i.set(k60Var);
            }
            return Tasks.m1562e(null);
        }
    }

    public fc0(Context context, nc0 nc0Var, CurrentTimeProvider currentTimeProvider, gc0 gc0Var, cc0 cc0Var, SettingsSpiCall settingsSpiCall, c90 c90Var) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.f2662h = atomicReference;
        this.f2663i = new AtomicReference<>(new k60());
        this.f2655a = context;
        this.f2656b = nc0Var;
        this.f2658d = currentTimeProvider;
        this.f2657c = gc0Var;
        this.f2659e = cc0Var;
        this.f2660f = settingsSpiCall;
        this.f2661g = c90Var;
        atomicReference.set(dc0.m3188e(currentTimeProvider));
    }

    /* renamed from: l */
    public static fc0 m3723l(Context context, String str, h90 h90Var, db0 db0Var, String str2, String str3, String str4, c90 c90Var) {
        String m4390e = h90Var.m4390e();
        p90 p90Var = new p90();
        return new fc0(context, new nc0(str, h90Var.m4391f(), h90Var.m4392g(), h90Var.m4393h(), h90Var, w80.m9429h(w80.m9437p(context), str, str3, str2), str3, str2, e90.m3458f(m4390e).m3459h()), p90Var, new gc0(p90Var), new cc0(context), new qc0(str4, String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), db0Var), c90Var);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    /* renamed from: a */
    public j60<jc0> mo1842a() {
        return this.f2663i.get().m5842a();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsDataProvider
    /* renamed from: b */
    public Settings mo1843b() {
        return this.f2662h.get();
    }

    /* renamed from: k */
    public boolean m3724k() {
        return !m3726n().equals(this.f2656b.f5253f);
    }

    /* renamed from: m */
    public final mc0 m3725m(ec0 ec0Var) {
        mc0 mc0Var = null;
        try {
            if (!ec0.SKIP_CACHE_LOOKUP.equals(ec0Var)) {
                JSONObject m2760b = this.f2659e.m2760b();
                if (m2760b != null) {
                    mc0 m4114b = this.f2657c.m4114b(m2760b);
                    if (m4114b != null) {
                        m3729q(m2760b, "Loaded cached settings: ");
                        long mo1739a = this.f2658d.mo1739a();
                        if (!ec0.IGNORE_CACHE_EXPIRATION.equals(ec0Var) && m4114b.m6401e(mo1739a)) {
                            m80.m6375f().m6377b("Cached settings have expired.");
                        }
                        try {
                            m80.m6375f().m6377b("Returning cached settings.");
                            mc0Var = m4114b;
                        } catch (Exception e) {
                            e = e;
                            mc0Var = m4114b;
                            m80.m6375f().m6380e("Failed to get cached settings", e);
                            return mc0Var;
                        }
                    } else {
                        m80.m6375f().m6380e("Failed to parse cached settings data.", null);
                    }
                } else {
                    m80.m6375f().m6377b("No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return mc0Var;
    }

    /* renamed from: n */
    public final String m3726n() {
        return w80.m9441t(this.f2655a).getString("existing_instance_identifier", "");
    }

    /* renamed from: o */
    public j60<Void> m3727o(ec0 ec0Var, Executor executor) {
        mc0 m3725m;
        if (!m3724k() && (m3725m = m3725m(ec0Var)) != null) {
            this.f2662h.set(m3725m);
            this.f2663i.get().m5846e(m3725m.m6399c());
            return Tasks.m1562e(null);
        }
        mc0 m3725m2 = m3725m(ec0.IGNORE_CACHE_EXPIRATION);
        if (m3725m2 != null) {
            this.f2662h.set(m3725m2);
            this.f2663i.get().m5846e(m3725m2.m6399c());
        }
        return this.f2661g.m2718d().mo2703p(executor, new C0982a());
    }

    /* renamed from: p */
    public j60<Void> m3728p(Executor executor) {
        return m3727o(ec0.USE_CACHE, executor);
    }

    /* renamed from: q */
    public final void m3729q(JSONObject jSONObject, String str) throws JSONException {
        m80.m6375f().m6377b(str + jSONObject.toString());
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: r */
    public final boolean m3730r(String str) {
        SharedPreferences.Editor edit = w80.m9441t(this.f2655a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }
}

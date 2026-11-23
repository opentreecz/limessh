package cz.opentree.juicessh.views.dbpreferences;

import android.content.Intent;
import android.preference.ListPreference;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.PurchaseActivity;
import cz.opentree.util.ProBlockablePreference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class EncListDBPreference extends ListPreference implements ProBlockablePreference {

    /* renamed from: O */
    public AtomicBoolean f4342O;

    /* renamed from: P */
    public AtomicBoolean f4343P;

    /* renamed from: Q */
    public Preference.OnPreferenceChangeListener f4344Q;

    /* renamed from: R */
    public Preference.OnPreferenceClickListener f4345R;

    @Override // cz.opentree.util.ProBlockablePreference
    /* renamed from: f */
    public void mo5652f(boolean z) {
        if (z) {
            setSummary(R.string.pro_users_only);
            super.setOnPreferenceClickListener(null);
            super.setOnPreferenceChangeListener(null);
        } else {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = this.f4344Q;
            if (onPreferenceChangeListener != null) {
                super.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
            Preference.OnPreferenceClickListener onPreferenceClickListener = this.f4345R;
            if (onPreferenceClickListener != null) {
                super.setOnPreferenceClickListener(onPreferenceClickListener);
            }
        }
        this.f4342O.set(z);
        try {
            notify();
        } catch (IllegalMonitorStateException unused) {
        }
    }

    /* renamed from: g */
    public void m5698g(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m5698g(viewGroup.getChildAt(i), z);
            }
        }
    }

    /* renamed from: h */
    public boolean m5699h() {
        return this.f4342O.get();
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        m5698g(view, (m5699h() || this.f4343P.get()) ? false : true);
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    public void onClick() {
        if (!m5699h()) {
            super.onClick();
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) PurchaseActivity.class));
        }
    }

    @Override // android.preference.Preference
    public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (!m5699h()) {
            super.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        this.f4344Q = onPreferenceChangeListener;
    }

    @Override // android.preference.Preference
    public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener onPreferenceClickListener) {
        if (!m5699h()) {
            super.setOnPreferenceClickListener(onPreferenceClickListener);
        }
        this.f4345R = onPreferenceClickListener;
    }

    @Override // android.preference.ListPreference
    public void setValue(String str) {
        super.setValue(str);
        notifyChanged();
    }
}

package cz.opentree.limessh.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.PurchaseActivity;
import cz.opentree.util.ProBlockablePreference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class ActionPreference extends DialogPreference implements ProBlockablePreference {

    /* renamed from: O */
    public AtomicBoolean f4287O;

    /* renamed from: P */
    public Preference.OnPreferenceChangeListener f4288P;

    /* renamed from: Q */
    public Preference.OnPreferenceClickListener f4289Q;

    public ActionPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4287O = new AtomicBoolean(false);
    }

    @Override // cz.opentree.util.ProBlockablePreference
    /* renamed from: f */
    public void mo5652f(boolean z) {
        if (z) {
            setSummary(R.string.pro_users_only);
            super.setOnPreferenceClickListener(null);
            super.setOnPreferenceChangeListener(null);
        } else {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = this.f4288P;
            if (onPreferenceChangeListener != null) {
                super.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
            Preference.OnPreferenceClickListener onPreferenceClickListener = this.f4289Q;
            if (onPreferenceClickListener != null) {
                super.setOnPreferenceClickListener(onPreferenceClickListener);
            }
        }
        this.f4287O.set(z);
        try {
            notify();
        } catch (IllegalMonitorStateException unused) {
        }
    }

    /* renamed from: g */
    public void m5653g(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m5653g(viewGroup.getChildAt(i), z);
            }
        }
    }

    /* renamed from: h */
    public boolean m5654h() {
        return this.f4287O.get();
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        m5653g(view, !m5654h());
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    public void onClick() {
        if (!m5654h()) {
            super.onClick();
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) PurchaseActivity.class));
        }
    }

    @Override // android.preference.DialogPreference
    public void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        persistBoolean(z);
    }

    @Override // android.preference.Preference
    public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (!m5654h()) {
            super.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        this.f4288P = onPreferenceChangeListener;
    }

    @Override // android.preference.Preference
    public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener onPreferenceClickListener) {
        if (!m5654h()) {
            super.setOnPreferenceClickListener(onPreferenceClickListener);
        }
        this.f4289Q = onPreferenceClickListener;
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle bundle) {
    }
}

package com.sonelli.juicessh.views.dbpreferences;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.activities.PurchaseActivity;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.models.User;
import com.sonelli.juicessh.views.SwitchCompatPreference;
import com.sonelli.qg0;
import com.sonelli.util.ProBlockablePreference;
import com.sonelli.util.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class EncSwitchDBPreference extends SwitchCompatPreference implements ProBlockablePreference {

    /* renamed from: U */
    public ArrayList<Preference> f4346U;

    /* renamed from: V */
    public AtomicBoolean f4347V;

    /* renamed from: W */
    public AtomicBoolean f4348W;

    /* renamed from: X */
    public Preference.OnPreferenceChangeListener f4349X;

    /* renamed from: Y */
    public Preference.OnPreferenceClickListener f4350Y;

    /* renamed from: com.sonelli.juicessh.views.dbpreferences.EncSwitchDBPreference$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1404a extends AsyncTask<Void, Void, Boolean> {
        public AsyncTaskC1404a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            boolean z;
            if (EncSwitchDBPreference.this.getKey().equals("pinlock:enabled")) {
                z = Session.m9046g().m9049h().m10494c(EncSwitchDBPreference.this.getContext());
            } else {
                try {
                    z = Boolean.valueOf(qg0.m7700a(Config.m5458d(EncSwitchDBPreference.this.getKey(), EncSwitchDBPreference.this.getContext()), User.m5527u(EncSwitchDBPreference.this.getContext()))).booleanValue();
                } catch (qg0.C1762a e) {
                    e.printStackTrace();
                    z = false;
                    return Boolean.valueOf(z);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    z = false;
                    return Boolean.valueOf(z);
                }
            }
            return Boolean.valueOf(z);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            EncSwitchDBPreference.this.mo5685k(bool.booleanValue());
            EncSwitchDBPreference.this.m5687m(null);
            EncSwitchDBPreference.this.f4348W.set(false);
            EncSwitchDBPreference encSwitchDBPreference = EncSwitchDBPreference.this;
            encSwitchDBPreference.mo5652f(encSwitchDBPreference.m5702p());
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            EncSwitchDBPreference.this.f4348W.set(true);
            try {
                notify();
            } catch (IllegalMonitorStateException unused) {
            }
        }
    }

    public EncSwitchDBPreference(Context context) {
        this(context, null);
    }

    public EncSwitchDBPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4346U = new ArrayList<>();
        this.f4347V = new AtomicBoolean(false);
        this.f4348W = new AtomicBoolean(false);
        new AsyncTaskC1404a().execute(new Void[0]);
    }

    @Override // com.sonelli.util.ProBlockablePreference
    /* renamed from: f */
    public void mo5652f(boolean z) {
        if (z) {
            mo5685k(false);
            m5686l(R.string.pro_users_only);
            super.setOnPreferenceClickListener(null);
            super.setOnPreferenceChangeListener(null);
        } else {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = this.f4349X;
            if (onPreferenceChangeListener != null) {
                super.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
            Preference.OnPreferenceClickListener onPreferenceClickListener = this.f4350Y;
            if (onPreferenceClickListener != null) {
                super.setOnPreferenceClickListener(onPreferenceClickListener);
            }
        }
        this.f4347V.set(z);
        try {
            notify();
        } catch (IllegalMonitorStateException unused) {
        }
    }

    @Override // com.sonelli.juicessh.views.SwitchCompatPreference
    /* renamed from: k */
    public void mo5685k(boolean z) {
        super.mo5685k(z);
        Iterator<Preference> it = this.f4346U.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z);
        }
    }

    /* renamed from: o */
    public void m5701o(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m5701o(viewGroup.getChildAt(i), z);
            }
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        if (view == null) {
            return;
        }
        super.onBindView(view);
        m5701o(view, (m5702p() || this.f4348W.get()) ? false : true);
    }

    @Override // com.sonelli.juicessh.views.SwitchCompatPreference, android.preference.Preference
    public void onClick() {
        if (!m5702p()) {
            super.onClick();
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) PurchaseActivity.class));
        }
    }

    /* renamed from: p */
    public boolean m5702p() {
        return this.f4347V.get();
    }

    /* renamed from: q */
    public void m5703q(boolean z) {
        Preference.OnPreferenceChangeListener onPreferenceChangeListener = getOnPreferenceChangeListener();
        setOnPreferenceChangeListener(null);
        mo5685k(z);
        if (onPreferenceChangeListener != null) {
            setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
    }

    @Override // android.preference.Preference
    public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (!m5702p()) {
            super.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        this.f4349X = onPreferenceChangeListener;
    }

    @Override // android.preference.Preference
    public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener onPreferenceClickListener) {
        if (!m5702p()) {
            super.setOnPreferenceClickListener(onPreferenceClickListener);
        }
        this.f4350Y = onPreferenceClickListener;
    }
}

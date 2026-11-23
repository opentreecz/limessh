package cz.opentree.juicessh.views.dbpreferences;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.PurchaseActivity;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.views.SwitchCompatPreference;
import cz.opentree.util.ProBlockablePreference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class SwitchDBPreference extends SwitchCompatPreference implements ProBlockablePreference {

    /* renamed from: U */
    public ArrayList<Preference> f4374U;

    /* renamed from: V */
    public AtomicBoolean f4375V;

    /* renamed from: W */
    public AtomicBoolean f4376W;

    /* renamed from: X */
    public Preference.OnPreferenceChangeListener f4377X;

    /* renamed from: Y */
    public Preference.OnPreferenceClickListener f4378Y;

    /* renamed from: cz.opentree.juicessh.views.dbpreferences.SwitchDBPreference$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1409a extends AsyncTask<Void, Void, Boolean> {
        public AsyncTaskC1409a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                return Boolean.valueOf(Config.m5458d(SwitchDBPreference.this.getKey(), SwitchDBPreference.this.getContext()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return Boolean.FALSE;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            SwitchDBPreference.this.mo5685k(bool.booleanValue());
            SwitchDBPreference.this.m5687m(null);
            SwitchDBPreference.this.f4376W.set(false);
            SwitchDBPreference switchDBPreference = SwitchDBPreference.this;
            switchDBPreference.mo5652f(switchDBPreference.m5722p());
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            SwitchDBPreference.this.f4376W.set(true);
            try {
                notify();
            } catch (IllegalMonitorStateException unused) {
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.views.dbpreferences.SwitchDBPreference$b */
    /* loaded from: classes.dex */
    public class C1410b implements Preference.OnPreferenceChangeListener {
        public C1410b() {
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            Config.m5462h(SwitchDBPreference.this.getKey(), String.valueOf(obj), SwitchDBPreference.this.getContext());
            return true;
        }
    }

    public SwitchDBPreference(Context context) {
        this(context, null);
    }

    public SwitchDBPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4374U = new ArrayList<>();
        this.f4375V = new AtomicBoolean(false);
        this.f4376W = new AtomicBoolean(false);
        new AsyncTaskC1409a().execute(new Void[0]);
        setOnPreferenceChangeListener(new C1410b());
    }

    @Override // cz.opentree.util.ProBlockablePreference
    /* renamed from: f */
    public void mo5652f(boolean z) {
        if (z) {
            m5686l(R.string.pro_users_only);
            mo5685k(false);
            super.setOnPreferenceClickListener(null);
            super.setOnPreferenceChangeListener(null);
        } else {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = this.f4377X;
            if (onPreferenceChangeListener != null) {
                super.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
            Preference.OnPreferenceClickListener onPreferenceClickListener = this.f4378Y;
            if (onPreferenceClickListener != null) {
                super.setOnPreferenceClickListener(onPreferenceClickListener);
            }
        }
        this.f4375V.set(z);
        try {
            notify();
        } catch (IllegalMonitorStateException unused) {
        }
    }

    @Override // cz.opentree.juicessh.views.SwitchCompatPreference
    /* renamed from: k */
    public void mo5685k(boolean z) {
        super.mo5685k(z);
        Iterator<Preference> it = this.f4374U.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z);
        }
    }

    /* renamed from: o */
    public void m5721o(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m5721o(viewGroup.getChildAt(i), z);
            }
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        m5721o(view, (m5722p() || this.f4376W.get()) ? false : true);
    }

    @Override // cz.opentree.juicessh.views.SwitchCompatPreference, android.preference.Preference
    public void onClick() {
        if (!m5722p()) {
            super.onClick();
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) PurchaseActivity.class));
        }
    }

    /* renamed from: p */
    public boolean m5722p() {
        return this.f4375V.get();
    }

    @Override // android.preference.Preference
    public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (!m5722p()) {
            super.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        this.f4377X = onPreferenceChangeListener;
    }

    @Override // android.preference.Preference
    public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener onPreferenceClickListener) {
        if (!m5722p()) {
            super.setOnPreferenceClickListener(onPreferenceClickListener);
        }
        this.f4378Y = onPreferenceClickListener;
    }
}

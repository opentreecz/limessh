package cz.opentree.limessh.views.dbpreferences;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.ListPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.PurchaseActivity;
import cz.opentree.limessh.models.Config;
import cz.opentree.util.ProBlockablePreference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class ListDBPreference extends ListPreference implements ProBlockablePreference {

    /* renamed from: O */
    public AtomicBoolean f4352O;

    /* renamed from: P */
    public AtomicBoolean f4353P;

    /* renamed from: Q */
    public Preference.OnPreferenceChangeListener f4354Q;

    /* renamed from: R */
    public Preference.OnPreferenceClickListener f4355R;

    /* renamed from: cz.opentree.limessh.views.dbpreferences.ListDBPreference$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1405a extends AsyncTask<Void, Void, String> {
        public AsyncTaskC1405a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            String m5458d = Config.m5458d(ListDBPreference.this.getKey(), ListDBPreference.this.getContext());
            CharSequence[] entryValues = ListDBPreference.this.getEntryValues();
            int i = 0;
            CharSequence charSequence = entryValues[0];
            while (true) {
                if (i < entryValues.length) {
                    if (m5458d != null && m5458d.equals(entryValues[i])) {
                        charSequence = entryValues[i];
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            return charSequence.toString();
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (str == null || Build.VERSION.SDK_INT < 14) {
                ListDBPreference.this.setSummary((CharSequence) null);
            } else {
                ListDBPreference.this.setSummary("%s");
            }
            ListDBPreference.this.setValue(str);
            ListDBPreference.this.f4353P.set(false);
            ListDBPreference listDBPreference = ListDBPreference.this;
            listDBPreference.mo5652f(listDBPreference.m5708k());
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            ListDBPreference.this.f4353P.set(true);
            try {
                notify();
            } catch (IllegalMonitorStateException unused) {
            }
        }
    }

    /* renamed from: cz.opentree.limessh.views.dbpreferences.ListDBPreference$b */
    /* loaded from: classes.dex */
    public class C1406b implements Preference.OnPreferenceChangeListener {
        public C1406b() {
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            Config.m5462h(ListDBPreference.this.getKey(), obj.toString(), ListDBPreference.this.getContext());
            return true;
        }
    }

    public ListDBPreference(Context context) {
        this(context, null);
    }

    public ListDBPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4352O = new AtomicBoolean(false);
        this.f4353P = new AtomicBoolean(false);
        new AsyncTaskC1405a().execute(new Void[0]);
        setOnPreferenceChangeListener(new C1406b());
    }

    @Override // cz.opentree.util.ProBlockablePreference
    /* renamed from: f */
    public void mo5652f(boolean z) {
        if (z) {
            setSummary(R.string.pro_users_only);
            super.setOnPreferenceClickListener(null);
            super.setOnPreferenceChangeListener(null);
        } else {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = this.f4354Q;
            if (onPreferenceChangeListener != null) {
                super.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
            Preference.OnPreferenceClickListener onPreferenceClickListener = this.f4355R;
            if (onPreferenceClickListener != null) {
                super.setOnPreferenceClickListener(onPreferenceClickListener);
            }
        }
        this.f4352O.set(z);
        try {
            notify();
        } catch (IllegalMonitorStateException unused) {
        }
    }

    /* renamed from: h */
    public void m5707h(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m5707h(viewGroup.getChildAt(i), z);
            }
        }
    }

    /* renamed from: k */
    public boolean m5708k() {
        return this.f4352O.get();
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        m5707h(view, (m5708k() || this.f4353P.get()) ? false : true);
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    public void onClick() {
        if (!m5708k()) {
            super.onClick();
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) PurchaseActivity.class));
        }
    }

    @Override // android.preference.Preference
    public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (!m5708k()) {
            super.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        this.f4354Q = onPreferenceChangeListener;
    }

    @Override // android.preference.Preference
    public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener onPreferenceClickListener) {
        if (!m5708k()) {
            super.setOnPreferenceClickListener(onPreferenceClickListener);
        }
        this.f4355R = onPreferenceClickListener;
    }

    @Override // android.preference.ListPreference
    public void setValue(String str) {
        super.setValue(str);
        notifyChanged();
    }
}

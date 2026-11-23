package com.sonelli.juicessh.views.dbpreferences;

import android.content.Context;
import android.os.AsyncTask;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.sonelli.gj0;
import com.sonelli.juicessh.models.Config;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class TextDBPreference extends EditTextPreference {

    /* renamed from: O */
    public AtomicBoolean f4381O;

    /* renamed from: com.sonelli.juicessh.views.dbpreferences.TextDBPreference$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1411a extends AsyncTask<Void, Void, String> {
        public AsyncTaskC1411a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            try {
                return Config.m5458d(TextDBPreference.this.getKey(), TextDBPreference.this.getContext());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (str != null) {
                TextDBPreference.this.setText(str);
                TextDBPreference.this.setSummary(str);
            }
            TextDBPreference.this.f4381O.set(false);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            TextDBPreference.this.f4381O.set(true);
            try {
                notify();
            } catch (IllegalMonitorStateException unused) {
            }
        }
    }

    /* renamed from: com.sonelli.juicessh.views.dbpreferences.TextDBPreference$b */
    /* loaded from: classes.dex */
    public class C1412b implements Preference.OnPreferenceChangeListener {
        public C1412b() {
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            gj0.m4141b("TextDBPreference", "Setting " + TextDBPreference.this.getKey() + " = " + obj);
            Config.m5462h(TextDBPreference.this.getKey(), String.valueOf(obj), TextDBPreference.this.getContext());
            TextDBPreference.this.setSummary(String.valueOf(obj));
            return true;
        }
    }

    public TextDBPreference(Context context) {
        this(context, null);
    }

    public TextDBPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new ArrayList();
        this.f4381O = new AtomicBoolean(false);
        new AsyncTaskC1411a().execute(new Void[0]);
        setOnPreferenceChangeListener(new C1412b());
    }

    /* renamed from: g */
    public void m5728g(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m5728g(viewGroup.getChildAt(i), z);
            }
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        m5728g(view, !this.f4381O.get());
    }
}

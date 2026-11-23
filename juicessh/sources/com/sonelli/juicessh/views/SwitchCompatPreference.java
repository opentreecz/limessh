package com.sonelli.juicessh.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: classes.dex */
public class SwitchCompatPreference extends Preference {

    /* renamed from: O */
    public boolean f4314O;

    /* renamed from: P */
    public boolean f4315P;

    /* renamed from: Q */
    public boolean f4316Q;

    /* renamed from: R */
    public String f4317R;

    /* renamed from: S */
    public String f4318S;

    /* renamed from: T */
    public SwitchCompat f4319T;

    /* renamed from: com.sonelli.juicessh.views.SwitchCompatPreference$a */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1397a implements View.OnClickListener {
        public ViewOnClickListenerC1397a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwitchCompatPreference.this.onClick();
        }
    }

    /* renamed from: com.sonelli.juicessh.views.SwitchCompatPreference$b */
    /* loaded from: classes.dex */
    public class RunnableC1398b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ boolean f4321O;

        public RunnableC1398b(boolean z) {
            this.f4321O = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwitchCompatPreference.this.f4319T.setChecked(this.f4321O);
        }
    }

    public SwitchCompatPreference(Context context) {
        super(context);
        this.f4314O = false;
        this.f4316Q = false;
    }

    public SwitchCompatPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4314O = false;
        this.f4316Q = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.summaryOn, R.attr.summaryOff});
        this.f4318S = obtainStyledAttributes.getString(0);
        this.f4317R = obtainStyledAttributes.getString(1);
    }

    /* renamed from: h */
    public boolean m5684h() {
        return this.f4315P;
    }

    /* renamed from: k */
    public void mo5685k(boolean z) {
        if (!this.f4316Q || callChangeListener(Boolean.valueOf(z))) {
            this.f4316Q = true;
            if (z == this.f4315P) {
                return;
            }
            this.f4315P = z;
            CharSequence charSequence = z ? this.f4318S : this.f4317R;
            if (charSequence == null) {
                charSequence = getSummary();
            }
            setSummary(charSequence);
            if (shouldPersist()) {
                persistBoolean(z);
            }
            SwitchCompat switchCompat = this.f4319T;
            if (switchCompat != null) {
                switchCompat.postDelayed(new RunnableC1398b(z), 100L);
            }
        }
    }

    /* renamed from: l */
    public void m5686l(int i) {
        this.f4317R = getContext().getString(i);
    }

    /* renamed from: m */
    public void m5687m(String str) {
        this.f4317R = str;
    }

    @Override // android.preference.Preference
    public void onClick() {
        super.onClick();
        mo5685k(!this.f4315P);
        if (getOnPreferenceClickListener() != null) {
            getOnPreferenceClickListener().onPreferenceClick(this);
        }
    }

    @Override // android.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        super.onCreateView(viewGroup);
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(com.sonelli.juicessh.R.layout.switch_preference, viewGroup, false);
        SwitchCompat switchCompat = (SwitchCompat) inflate.findViewById(com.sonelli.juicessh.R.id.switch_compat);
        this.f4319T = switchCompat;
        switchCompat.setChecked(this.f4315P);
        CharSequence charSequence = this.f4315P ? this.f4318S : this.f4317R;
        if (charSequence == null) {
            charSequence = getSummary();
        }
        setSummary(charSequence);
        inflate.setOnClickListener(new ViewOnClickListenerC1397a());
        return inflate;
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, this.f4314O));
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z, Object obj) {
        super.onSetInitialValue(z, obj);
        if (z) {
            this.f4315P = getPersistedBoolean(this.f4314O);
            return;
        }
        Boolean bool = (Boolean) obj;
        this.f4315P = bool.booleanValue();
        persistBoolean(bool.booleanValue());
    }
}

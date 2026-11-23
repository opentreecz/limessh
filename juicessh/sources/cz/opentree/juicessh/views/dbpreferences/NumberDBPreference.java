package cz.opentree.juicessh.views.dbpreferences;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import cz.opentree.juicessh.R$styleable;
import cz.opentree.juicessh.activities.PurchaseActivity;
import cz.opentree.juicessh.models.Config;
import cz.opentree.util.ProBlockablePreference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class NumberDBPreference extends DialogPreference implements ProBlockablePreference {

    /* renamed from: b0 */
    public static final int f4358b0 = Build.VERSION.SDK_INT;

    /* renamed from: O */
    public AtomicBoolean f4359O;

    /* renamed from: P */
    public AtomicBoolean f4360P;

    /* renamed from: Q */
    public Preference.OnPreferenceChangeListener f4361Q;

    /* renamed from: R */
    public Preference.OnPreferenceClickListener f4362R;

    /* renamed from: S */
    public NumberPicker f4363S;

    /* renamed from: T */
    public Spinner f4364T;

    /* renamed from: U */
    public LinearLayout f4365U;

    /* renamed from: V */
    public TextView f4366V;

    /* renamed from: W */
    public int f4367W;

    /* renamed from: X */
    public int f4368X;

    /* renamed from: Y */
    public int f4369Y;

    /* renamed from: Z */
    public String f4370Z;

    /* renamed from: a0 */
    public String f4371a0;

    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1407a();

        /* renamed from: O */
        public int f4372O;

        /* renamed from: cz.opentree.juicessh.views.dbpreferences.NumberDBPreference$SavedState$a */
        /* loaded from: classes.dex */
        public static class C1407a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4372O = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4372O);
        }
    }

    /* renamed from: cz.opentree.juicessh.views.dbpreferences.NumberDBPreference$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1408a extends AsyncTask<Void, Void, Integer> {
        public AsyncTaskC1408a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                return Integer.valueOf(Config.m5458d(NumberDBPreference.this.getKey(), NumberDBPreference.this.getContext()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return 0;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            NumberDBPreference.this.f4367W = num.intValue();
            NumberDBPreference.this.f4360P.set(false);
            NumberDBPreference numberDBPreference = NumberDBPreference.this;
            numberDBPreference.mo5652f(numberDBPreference.m5714l());
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            NumberDBPreference.this.f4360P.set(true);
            try {
                notify();
            } catch (IllegalMonitorStateException unused) {
            }
        }
    }

    public NumberDBPreference(Context context) {
        this(context, null);
    }

    public NumberDBPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dialogPreferenceStyle);
    }

    public NumberDBPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4359O = new AtomicBoolean(false);
        this.f4360P = new AtomicBoolean(false);
        this.f4367W = 0;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.NumberDBPreference);
        this.f4368X = obtainStyledAttributes.getInteger(3, 0);
        this.f4369Y = obtainStyledAttributes.getInteger(1, 999);
        this.f4370Z = obtainStyledAttributes.getString(2);
        this.f4371a0 = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f4365U = linearLayout;
        linearLayout.setOrientation(1);
        this.f4365U.setPadding((int) context.getResources().getDimension(cz.opentree.juicessh.R.dimen.dialog_padding_left), (int) context.getResources().getDimension(cz.opentree.juicessh.R.dimen.dialog_padding_top), (int) context.getResources().getDimension(cz.opentree.juicessh.R.dimen.dialog_padding_right), (int) context.getResources().getDimension(cz.opentree.juicessh.R.dimen.dialog_padding_bottom));
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        String str = this.f4370Z;
        if (str != null && str.length() > 0) {
            TextView textView = new TextView(context);
            textView.setText(this.f4370Z);
            int round = Math.round(TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(round, round, round, round);
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(2, 16.0f);
            this.f4365U.addView(textView);
            if (f4358b0 <= 10) {
                textView.setTextColor(getContext().getResources().getColor(R.color.primary_text_dark));
            }
        }
        this.f4365U.addView(relativeLayout);
        if (this.f4371a0 != null) {
            TextView textView2 = new TextView(context);
            this.f4366V = textView2;
            textView2.setText(this.f4371a0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(0, 5000);
            layoutParams2.addRule(15);
            layoutParams2.setMargins(0, 0, Math.round(TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics())), 0);
            relativeLayout.addView(this.f4366V, layoutParams2);
        }
        if (f4358b0 <= 10) {
            this.f4366V.setTextColor(getContext().getResources().getColor(R.color.primary_text_dark));
            this.f4364T = new Spinner(context);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            this.f4364T.setLayoutParams(layoutParams3);
            this.f4364T.setId(5000);
            int i2 = this.f4369Y - this.f4368X;
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(String.valueOf(this.f4368X + i3));
            }
            this.f4364T.setAdapter((SpinnerAdapter) new ArrayAdapter(context, R.layout.simple_spinner_item, arrayList));
            relativeLayout.addView(this.f4364T);
        } else {
            NumberPicker numberPicker = new NumberPicker(context, attributeSet);
            this.f4363S = numberPicker;
            numberPicker.setId(5000);
            this.f4363S.setMinValue(this.f4368X);
            this.f4363S.setMaxValue(this.f4369Y);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            relativeLayout.addView(this.f4363S, layoutParams4);
        }
        new AsyncTaskC1408a().execute(new Void[0]);
    }

    @Override // cz.opentree.util.ProBlockablePreference
    /* renamed from: f */
    public void mo5652f(boolean z) {
        if (z) {
            setSummary(cz.opentree.juicessh.R.string.pro_users_only);
            super.setOnPreferenceClickListener(null);
            super.setOnPreferenceChangeListener(null);
        } else {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = this.f4361Q;
            if (onPreferenceChangeListener != null) {
                super.setOnPreferenceChangeListener(onPreferenceChangeListener);
            }
            Preference.OnPreferenceClickListener onPreferenceClickListener = this.f4362R;
            if (onPreferenceClickListener != null) {
                super.setOnPreferenceClickListener(onPreferenceClickListener);
            }
        }
        this.f4359O.set(z);
        try {
            notify();
        } catch (IllegalMonitorStateException unused) {
        }
    }

    /* renamed from: k */
    public void m5713k(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m5713k(viewGroup.getChildAt(i), z);
            }
        }
    }

    /* renamed from: l */
    public boolean m5714l() {
        return this.f4359O.get();
    }

    /* renamed from: m */
    public void m5715m(int i) {
        try {
            this.f4367W = i;
            Config.m5462h(getKey(), String.valueOf(i), getContext());
        } catch (NumberFormatException unused) {
            m5715m(1);
        }
    }

    @Override // android.preference.DialogPreference
    public void onBindDialogView(View view) {
        super.onBindDialogView(view);
        if (f4358b0 <= 10) {
            this.f4364T.setSelection(this.f4367W - this.f4368X);
        } else {
            this.f4363S.setValue(this.f4367W);
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        m5713k(view, (m5714l() || this.f4360P.get()) ? false : true);
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    public void onClick() {
        if (!m5714l()) {
            super.onClick();
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) PurchaseActivity.class));
        }
    }

    @Override // android.preference.DialogPreference
    public View onCreateDialogView() {
        return this.f4365U;
    }

    @Override // android.preference.DialogPreference
    public void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (z) {
            int selectedItemPosition = f4358b0 <= 10 ? this.f4364T.getSelectedItemPosition() + this.f4368X : this.f4363S.getValue();
            if (callChangeListener(Integer.valueOf(selectedItemPosition))) {
                m5715m(selectedItemPosition);
            }
        }
        ((ViewGroup) this.f4365U.getParent()).removeView(this.f4365U);
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(this.f4367W);
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(((SavedState) parcelable).getSuperState());
        try {
            i = Integer.valueOf(Config.m5458d(getKey(), getContext())).intValue();
        } catch (NumberFormatException unused) {
            i = 1;
        }
        if (f4358b0 <= 10) {
            this.f4364T.setSelection(i - this.f4368X);
        } else {
            this.f4363S.setValue(i);
        }
    }

    @Override // android.preference.DialogPreference, android.preference.Preference
    @SuppressLint({"NewApi"})
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        int selectedItemPosition = f4358b0 <= 10 ? this.f4364T.getSelectedItemPosition() + this.f4368X : this.f4363S.getValue();
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f4372O = selectedItemPosition;
        return savedState;
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z, Object obj) {
        this.f4367W = Integer.valueOf(Config.m5458d(getKey(), getContext())).intValue();
    }

    @Override // android.preference.Preference
    public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (!m5714l()) {
            super.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        this.f4361Q = onPreferenceChangeListener;
    }

    @Override // android.preference.Preference
    public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener onPreferenceClickListener) {
        if (!m5714l()) {
            super.setOnPreferenceClickListener(onPreferenceClickListener);
        }
        this.f4362R = onPreferenceClickListener;
    }
}

package org.lyf.juicesshofflinepro;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/* loaded from: classes.dex */
public final class SettingsActivity extends Activity {
    static final String KEY_HOOK_API_GATE = "hook_api_gate";
    static final String KEY_HOOK_PRO_CHECK = "hook_pro_check";
    static final String KEY_HOOK_SESSION_EXPIRY = "hook_session_expiry";
    static final String KEY_HOOK_USER_SIGNATURE = "hook_user_signature";
    static final String KEY_SESSION_YEARS = "session_years";
    static final String PREFS = "settings";
    private CheckBox apiGate;
    private CheckBox proCheck;
    private CheckBox sessionExpiry;
    private EditText sessionYears;
    private CheckBox userSignature;

    private CheckBox checkBox(String str, boolean z) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(str);
        checkBox.setChecked(z);
        checkBox.setPadding(0, m0dp(4), 0, m0dp(4));
        return checkBox;
    }

    /* renamed from: dp */
    private int m0dp(int i) {
        return Math.round(i * getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        save();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.proCheck.setChecked(true);
        this.userSignature.setChecked(true);
        this.sessionExpiry.setChecked(true);
        this.apiGate.setChecked(true);
        this.sessionYears.setText("10");
        save();
    }

    private LinearLayout.LayoutParams matchWrap() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    private void save() {
        int i;
        try {
            i = Integer.parseInt(this.sessionYears.getText().toString().trim());
        } catch (NumberFormatException unused) {
            i = 10;
        }
        if (i < 1) {
            i = 1;
        }
        if (i > 100) {
            i = 100;
        }
        this.sessionYears.setText(String.valueOf(i));
        getSharedPreferences(PREFS, 0).edit().putBoolean(KEY_HOOK_PRO_CHECK, this.proCheck.isChecked()).putBoolean(KEY_HOOK_USER_SIGNATURE, this.userSignature.isChecked()).putBoolean(KEY_HOOK_SESSION_EXPIRY, this.sessionExpiry.isChecked()).putBoolean(KEY_HOOK_API_GATE, this.apiGate.isChecked()).putInt(KEY_SESSION_YEARS, i).apply();
        Toast.makeText(this, C0001R.string.saved_restart_juicessh, 1).show();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(C0001R.string.app_name);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, 0);
        ScrollView scrollView = new ScrollView(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int m0dp = m0dp(16);
        linearLayout.setPadding(m0dp, m0dp, m0dp, m0dp);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(this);
        textView.setText(C0001R.string.app_name);
        textView.setTextSize(22.0f);
        textView.setGravity(8388611);
        linearLayout.addView(textView, matchWrap());
        TextView textView2 = new TextView(this);
        textView2.setText(C0001R.string.settings_hint);
        textView2.setPadding(0, m0dp(8), 0, m0dp(12));
        linearLayout.addView(textView2, matchWrap());
        this.proCheck = checkBox(getString(C0001R.string.hook_pro_check), sharedPreferences.getBoolean(KEY_HOOK_PRO_CHECK, true));
        this.userSignature = checkBox(getString(C0001R.string.hook_user_signature), sharedPreferences.getBoolean(KEY_HOOK_USER_SIGNATURE, true));
        this.sessionExpiry = checkBox(getString(C0001R.string.hook_session_expiry), sharedPreferences.getBoolean(KEY_HOOK_SESSION_EXPIRY, true));
        this.apiGate = checkBox(getString(C0001R.string.hook_api_gate), sharedPreferences.getBoolean(KEY_HOOK_API_GATE, true));
        linearLayout.addView(this.proCheck, matchWrap());
        linearLayout.addView(this.userSignature, matchWrap());
        linearLayout.addView(this.sessionExpiry, matchWrap());
        linearLayout.addView(this.apiGate, matchWrap());
        TextView textView3 = new TextView(this);
        textView3.setText(C0001R.string.session_years);
        textView3.setPadding(0, m0dp(12), 0, 0);
        linearLayout.addView(textView3, matchWrap());
        EditText editText = new EditText(this);
        this.sessionYears = editText;
        editText.setSingleLine(true);
        this.sessionYears.setInputType(2);
        this.sessionYears.setText(String.valueOf(sharedPreferences.getInt(KEY_SESSION_YEARS, 10)));
        linearLayout.addView(this.sessionYears, matchWrap());
        Button button = new Button(this);
        button.setText(C0001R.string.save);
        button.setOnClickListener(new View.OnClickListener() { // from class: org.lyf.juicesshofflinepro.SettingsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.this.lambda$onCreate$0(view);
            }
        });
        linearLayout.addView(button, matchWrap());
        Button button2 = new Button(this);
        button2.setText(C0001R.string.restore_defaults);
        button2.setOnClickListener(new View.OnClickListener() { // from class: org.lyf.juicesshofflinepro.SettingsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.this.lambda$onCreate$1(view);
            }
        });
        linearLayout.addView(button2, matchWrap());
        setContentView(scrollView);
    }
}

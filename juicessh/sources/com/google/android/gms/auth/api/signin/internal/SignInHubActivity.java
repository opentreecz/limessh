package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.sonelli.C0696a6;
import com.sonelli.C0766be;
import com.sonelli.C1800r5;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
@KeepName
/* loaded from: classes.dex */
public class SignInHubActivity extends FragmentActivity {

    /* renamed from: T */
    public static boolean f701T = false;

    /* renamed from: O */
    public boolean f702O = false;

    /* renamed from: P */
    public SignInConfiguration f703P;

    /* renamed from: Q */
    public boolean f704Q;

    /* renamed from: R */
    public int f705R;

    /* renamed from: S */
    public Intent f706S;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* renamed from: com.google.android.gms.auth.api.signin.internal.SignInHubActivity$a */
    /* loaded from: classes.dex */
    public class C0425a implements LoaderManager.LoaderCallbacks<Void> {
        public C0425a() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new C1800r5(SignInHubActivity.this, GoogleApiClient.m982c());
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f705R, SignInHubActivity.this.f706S);
            SignInHubActivity.this.finish();
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* renamed from: i */
    public final void m940i(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f701T = false;
    }

    /* renamed from: k */
    public final void m941k() {
        getSupportLoaderManager().initLoader(0, null, new C0425a());
        f701T = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (this.f702O) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.m935h() != null) {
                GoogleSignInAccount m935h = signInAccount.m935h();
                C0696a6 m1982c = C0696a6.m1982c(this);
                GoogleSignInOptions m937x = this.f703P.m937x();
                C0766be.m2448a(m935h);
                m1982c.m1985b(m937x, m935h);
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", m935h);
                this.f704Q = true;
                this.f705R = i2;
                this.f706S = intent;
                m941k();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                m940i(intExtra);
                return;
            }
        }
        m940i(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        C0766be.m2448a(action);
        String str = action;
        if ("com.google.android.gms.auth.NO_IMPL".equals(str)) {
            m940i(12500);
            return;
        }
        if (!str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !str.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String valueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        C0766be.m2448a(bundleExtra);
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.f703P = signInConfiguration;
        if (bundle != null) {
            boolean z = bundle.getBoolean("signingInGoogleApiClients");
            this.f704Q = z;
            if (z) {
                this.f705R = bundle.getInt("signInResultCode");
                Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                C0766be.m2448a(intent2);
                this.f706S = intent2;
                m941k();
                return;
            }
            return;
        }
        if (f701T) {
            setResult(0);
            m940i(12502);
            return;
        }
        f701T = true;
        Intent intent3 = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent3.setPackage("com.google.android.gms");
        } else {
            intent3.setPackage(getPackageName());
        }
        intent3.putExtra("config", this.f703P);
        try {
            startActivityForResult(intent3, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f702O = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            m940i(17);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f704Q);
        if (this.f704Q) {
            bundle.putInt("signInResultCode", this.f705R);
            bundle.putParcelable("signInResultData", this.f706S);
        }
    }
}

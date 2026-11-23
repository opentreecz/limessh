package com.sonelli.juicessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.SignInButton;
import com.sonelli.C1029g7;
import com.sonelli.C1196j5;
import com.sonelli.gj0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.controllers.ApplicationClass;
import com.sonelli.juicessh.services.BillingService;
import com.sonelli.util.SessionedActivity;

/* loaded from: classes.dex */
public class ThankYouForPurchasingActivity extends SessionedActivity implements View.OnClickListener {

    /* renamed from: P */
    public SignInButton f3947P;

    /* renamed from: Q */
    public TextView f3948Q;

    /* renamed from: R */
    public final BillingService f3949R = new BillingService(this);

    /* renamed from: com.sonelli.juicessh.activities.ThankYouForPurchasingActivity$a */
    /* loaded from: classes.dex */
    public class C1314a implements BillingService.OnServiceConnectedListener {
        public C1314a(ThankYouForPurchasingActivity thankYouForPurchasingActivity) {
        }

        @Override // com.sonelli.juicessh.services.BillingService.OnServiceConnectedListener
        public void onConnected() {
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.thank_you_for_purchasing);
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        this.f3947P = signInButton;
        signInButton.m958a(1);
        this.f3947P.setOnClickListener(this);
        this.f3948Q = (TextView) findViewById(R.id.activating_textview);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }
        this.f3949R.m5615c(new C1314a(this));
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
    }

    @Override // com.sonelli.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10368) {
            this.f3947P.setVisibility(8);
            this.f3948Q.setVisibility(0);
            try {
                this.f3949R.m5616d(C1196j5.m5056b(intent).mo2698k(C1029g7.class).m891K());
            } catch (C1029g7 e) {
                gj0.m4142c("ThankYouForPurchasingFragment", "Google SignIn Failed: " + e.getMessage());
                Toast.makeText(this, "There was an signing in with Google, please try again later", 0).show();
                this.f3947P.setVisibility(0);
                this.f3948Q.setVisibility(8);
            } catch (BillingService.C1366b e2) {
                gj0.m4142c("ThankYouForPurchasingFragment", "Billing Service Error: " + e2.getMessage());
                Toast.makeText(this, "There was an error communicating with the Google Billing Service, please try again later", 0).show();
                this.f3947P.setVisibility(0);
                this.f3948Q.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.sign_in_button) {
            return;
        }
        startActivityForResult(((ApplicationClass) getApplication()).m5371b().m5835m(), 10368);
    }
}

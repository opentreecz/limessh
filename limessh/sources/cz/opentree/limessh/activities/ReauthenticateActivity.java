package cz.opentree.limessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.SignInButton;
import cz.opentree.C1029g7;
import cz.opentree.C1196j5;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.controllers.ApplicationClass;
import cz.opentree.limessh.models.User;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.util.SessionedActivity;

/* loaded from: classes.dex */
public class ReauthenticateActivity extends SessionedActivity implements View.OnClickListener {

    /* renamed from: P */
    public SignInButton f3878P;

    /* renamed from: Q */
    public TextView f3879Q;

    /* renamed from: R */
    public Boolean f3880R = Boolean.FALSE;

    /* renamed from: cz.opentree.limessh.activities.ReauthenticateActivity$a */
    /* loaded from: classes.dex */
    public class C1289a extends pi0.AbstractC1720p {
        public C1289a() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            super.mo3228a(str);
            User.m5519B("New User", ReauthenticateActivity.this);
            Toast.makeText(ReauthenticateActivity.this, oi0.m7045b(), 1).show();
            ReauthenticateActivity.this.f3878P.setVisibility(0);
            ReauthenticateActivity.this.f3879Q.setVisibility(8);
            ((ApplicationClass) ReauthenticateActivity.this.getApplication()).m5371b().m5837o();
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            ReauthenticateActivity.this.startActivity(new Intent(ReauthenticateActivity.this, (Class<?>) MainActivity.class));
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.reauthenticate);
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        this.f3878P = signInButton;
        signInButton.m958a(1);
        this.f3878P.setOnClickListener(this);
        this.f3879Q = (TextView) findViewById(R.id.status_textview);
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
    }

    @Override // cz.opentree.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10368) {
            this.f3878P.setVisibility(8);
            this.f3879Q.setVisibility(0);
            try {
                C1196j5.m5056b(intent).mo2698k(C1029g7.class);
                pi0.m7331j(this, new C1289a());
            } catch (C1029g7 e) {
                gj0.m4142c("ReauthenticateActivity", "Google SignIn Failed: " + e.getMessage());
                Toast.makeText(this, "There was an signing in with Google, please try again later", 0).show();
                this.f3878P.setVisibility(0);
                this.f3879Q.setVisibility(8);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f3880R.booleanValue()) {
            return;
        }
        User.m5519B("New User", this);
    }
}

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
import cz.opentree.limessh.models.Config;
import cz.opentree.limessh.models.User;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.util.SessionedActivity;

/* loaded from: classes.dex */
public class AuthenticationMigrationActivity extends SessionedActivity implements View.OnClickListener {

    /* renamed from: P */
    public TextView f3711P;

    /* renamed from: Q */
    public SignInButton f3712Q;

    /* renamed from: R */
    public boolean f3713R = false;

    /* renamed from: cz.opentree.limessh.activities.AuthenticationMigrationActivity$a */
    /* loaded from: classes.dex */
    public class C1246a extends pi0.AbstractC1720p {
        public C1246a() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            super.mo3228a(str);
            User.m5519B("New User", AuthenticationMigrationActivity.this);
            Toast.makeText(AuthenticationMigrationActivity.this, oi0.m7045b(), 1).show();
            AuthenticationMigrationActivity.this.f3712Q.setVisibility(0);
            AuthenticationMigrationActivity.this.f3711P.setVisibility(4);
            ((ApplicationClass) AuthenticationMigrationActivity.this.getApplication()).m5371b().m5837o();
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (!oi0.m7047d(user)) {
                mo3228a(oi0.m7045b());
                return;
            }
            AuthenticationMigrationActivity.this.f3713R = true;
            AuthenticationMigrationActivity.this.startActivity(new Intent(AuthenticationMigrationActivity.this, (Class<?>) MainActivity.class));
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.authentication_migration);
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        this.f3712Q = signInButton;
        signInButton.m958a(1);
        this.f3712Q.setOnClickListener(this);
        this.f3711P = (TextView) findViewById(R.id.status_textview);
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
    }

    @Override // cz.opentree.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12277) {
            this.f3712Q.setVisibility(4);
            this.f3711P.setVisibility(0);
            try {
                User.m5519B(C1196j5.m5056b(intent).mo2698k(C1029g7.class).m891K(), this);
                pi0.m7335n(this);
                pi0.m7331j(this, new C1246a());
            } catch (C1029g7 e) {
                gj0.m4142c("AuthenticationMigrationActivity", "Google SignIn Failed: " + e.getMessage());
                Toast.makeText(this, "There was an signing in with Google, please try again later", 0).show();
                this.f3712Q.setVisibility(0);
                this.f3711P.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.sign_in_button) {
            return;
        }
        startActivityForResult(((ApplicationClass) getApplication()).m5371b().m5835m(), 12277);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Config.m5458d("changelog:seen_auth_migration_message", this);
        if (User.m5525s(this).equals("New User") || this.f3713R) {
            return;
        }
        User.m5519B("New User", this);
    }
}

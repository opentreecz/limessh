package cz.opentree.juicessh.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import cz.opentree.C1029g7;
import cz.opentree.C1196j5;
import cz.opentree.gj0;
import cz.opentree.j60;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.controllers.ApplicationClass;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.services.BillingService;
import cz.opentree.juicessh.widgets.ConnectionWidgetProvider;
import cz.opentree.kj0;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.qi0;
import cz.opentree.util.SessionedActivity;
import cz.opentree.vk0;

/* loaded from: classes.dex */
public class PurchaseActivity extends SessionedActivity {

    /* renamed from: P */
    public BillingService f3868P;

    /* renamed from: Q */
    public Button f3869Q;

    /* renamed from: R */
    public boolean f3870R = true;

    /* renamed from: S */
    public AsyncTask<BillingService, Void, String> f3871S;

    /* renamed from: cz.opentree.juicessh.activities.PurchaseActivity$a */
    /* loaded from: classes.dex */
    public class C1285a implements BillingService.OnServiceConnectedListener {

        /* renamed from: cz.opentree.juicessh.activities.PurchaseActivity$a$a */
        /* loaded from: classes.dex */
        public class a extends AsyncTask<BillingService, Void, String> {
            public a() {
            }

            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String doInBackground(BillingService... billingServiceArr) {
                try {
                    return billingServiceArr[0].m5619g(oi0.m7044a()).f4161a;
                } catch (BillingService.C1366b unused) {
                    gj0.m4142c("Activities/PurchaseActivity", "Unable to load purchase offer details");
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(String str) {
                super.onPostExecute(str);
                if (str == null || str.length() <= 0) {
                    return;
                }
                PurchaseActivity.this.f3869Q.setText(PurchaseActivity.this.getString(R.string.purchase) + " (" + str + ")");
                if (PurchaseActivity.this.f3870R) {
                    vk0 vk0Var = new vk0(PurchaseActivity.this);
                    vk0Var.m9297j(PurchaseActivity.this.getString(R.string.special_offer));
                    vk0Var.m9295h(String.format(PurchaseActivity.this.getString(R.string.for_a_limited_time_only), str));
                    AlertDialog create = vk0Var.setPositiveButton(R.string.f3674ok, (DialogInterface.OnClickListener) null).create();
                    if (PurchaseActivity.this.isFinishing()) {
                        return;
                    }
                    try {
                        create.show();
                        PurchaseActivity.this.f3870R = false;
                    } catch (WindowManager.BadTokenException unused) {
                    }
                }
            }
        }

        public C1285a() {
        }

        @Override // cz.opentree.juicessh.services.BillingService.OnServiceConnectedListener
        public void onConnected() {
            PurchaseActivity.this.f3871S = new a();
            PurchaseActivity.this.f3871S.execute(PurchaseActivity.this.f3868P);
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.PurchaseActivity$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1286b implements View.OnClickListener {
        public ViewOnClickListenerC1286b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gj0.m4141b("Activities/PurchaseActivity", "Requesting purchase...");
            ((ApplicationClass) PurchaseActivity.this.getApplication()).m5370a();
            if (PurchaseActivity.this.f3871S != null) {
                PurchaseActivity.this.f3871S.cancel(true);
            }
            try {
                PurchaseActivity.this.f3868P.m5620h(oi0.m7044a(), 19597);
            } catch (BillingService.C1366b e) {
                gj0.m4142c("Activities/PurchaseActivity", "Billing Exception: " + e.getMessage());
                e.printStackTrace();
                PurchaseActivity purchaseActivity = PurchaseActivity.this;
                Toast.makeText(purchaseActivity, purchaseActivity.getString(R.string.please_try_again_later), 1).show();
                qi0.m7716c(PurchaseActivity.this).m7717a("Error", "Billing Exception:" + e.getMessage(), "");
                PurchaseActivity.this.finish();
            }
            qi0.m7716c(PurchaseActivity.this).m7717a("Button Click", "Purchase", "");
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.PurchaseActivity$c */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1287c implements View.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ Intent f3875O;

        public ViewOnClickListenerC1287c(Intent intent) {
            this.f3875O = intent;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PurchaseActivity.this.f3871S != null) {
                PurchaseActivity.this.f3871S.cancel(true);
            }
            PurchaseActivity.this.startActivityForResult(this.f3875O, 19600);
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.PurchaseActivity$d */
    /* loaded from: classes.dex */
    public class C1288d extends pi0.AbstractC1720p {
        public C1288d() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            super.mo3228a(str);
            User.m5527u(PurchaseActivity.this);
            User.m5519B("New User", PurchaseActivity.this);
            PurchaseActivity purchaseActivity = PurchaseActivity.this;
            Toast.makeText(purchaseActivity, purchaseActivity.getString(R.string.purchase_not_found), 1).show();
            ((ApplicationClass) PurchaseActivity.this.getApplication()).m5371b().m5837o();
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (!oi0.m7047d(user)) {
                User.m5519B("New User", PurchaseActivity.this);
                Toast.makeText(PurchaseActivity.this, oi0.m7045b(), 1).show();
                ((ApplicationClass) PurchaseActivity.this.getApplication()).m5371b().m5837o();
            } else {
                Toast.makeText(PurchaseActivity.this, oi0.m7046c(), 1).show();
                Intent intent = new Intent(PurchaseActivity.this, (Class<?>) ConnectionWidgetProvider.class);
                intent.setAction(ConnectionWidgetProvider.f4385b);
                LocalBroadcastManager.getInstance(PurchaseActivity.this).sendBroadcast(intent);
                PurchaseActivity.this.startActivity(new Intent(PurchaseActivity.this, (Class<?>) MainActivity.class));
            }
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.purchase);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (!kj0.m5917a().mo5136v()) {
            Toast.makeText(this, getString(R.string.purchasing_is_disabled), 1).show();
            finish();
        }
        this.f3870R = true;
        this.f3868P = new BillingService(this);
        Button button = (Button) findViewById(R.id.purchaseButton);
        this.f3869Q = button;
        button.setOnClickListener(new ViewOnClickListenerC1286b());
        ((Button) findViewById(R.id.purchasedButton)).setOnClickListener(new ViewOnClickListenerC1287c(((ApplicationClass) getApplication()).m5371b().m5835m()));
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        this.f3868P.m5615c(new C1285a());
    }

    @Override // cz.opentree.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 19597) {
            if (i != 19600) {
                return;
            }
            m5306s(C1196j5.m5056b(intent));
        } else if (i2 == -1) {
            qi0.m7716c(this).m7717a("Purchases", "New Purchase", "New Purchase");
            Intent intent2 = new Intent(this, (Class<?>) ConnectionWidgetProvider.class);
            intent2.setAction(ConnectionWidgetProvider.f4385b);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            Intent intent3 = new Intent(this, (Class<?>) MainActivity.class);
            intent3.setFlags(268468224);
            startActivity(intent3);
        }
    }

    @Override // cz.opentree.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BillingService billingService = this.f3868P;
        if (billingService != null) {
            billingService.m5617e();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /* renamed from: s */
    public final void m5306s(@NonNull j60<GoogleSignInAccount> j60Var) {
        try {
            GoogleSignInAccount mo2698k = j60Var.mo2698k(C1029g7.class);
            mo2698k.m895b0();
            Toast.makeText(this, getString(R.string.verifying_purchase), 0).show();
            User.m5519B(mo2698k.m891K(), this);
            gj0.m4141b("Activities/PurchaseActivity", "Clearing user caches...");
            pi0.m7335n(this);
            pi0.m7331j(this, new C1288d());
        } catch (C1029g7 e) {
            gj0.m4142c("Activities/PurchaseActivity", e.getMessage());
        }
    }
}

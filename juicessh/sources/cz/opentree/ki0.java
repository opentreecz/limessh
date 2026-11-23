package cz.opentree;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import cz.opentree.limessh.R;
import cz.opentree.limessh.connections.transports.ConnectionProvider;
import cz.opentree.limessh.fragments.ManageIdentityFragment;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.models.User;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.util.IdentityPrompt;
import cz.opentree.util.PasswordPrompt;
import java.sql.SQLException;

/* compiled from: SSHTransportAuthenticator.java */
/* loaded from: classes.dex */
public class ki0 {

    /* compiled from: SSHTransportAuthenticator.java */
    /* renamed from: cz.opentree.ki0$a */
    /* loaded from: classes.dex */
    public static class RunnableC1456a implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ FragmentActivity f4560O;

        /* renamed from: P */
        public final /* synthetic */ Identity f4561P;

        /* renamed from: Q */
        public final /* synthetic */ bi0 f4562Q;

        /* compiled from: SSHTransportAuthenticator.java */
        /* renamed from: cz.opentree.ki0$a$a */
        /* loaded from: classes.dex */
        public class a implements PasswordPrompt.PasswordPromptListener {
            public a() {
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            /* renamed from: a */
            public void mo5299a(String str, boolean z) {
                RunnableC1456a runnableC1456a = RunnableC1456a.this;
                runnableC1456a.f4561P.privatekeyPassword = qg0.m7702c(str, User.m5527u(runnableC1456a.f4560O));
                if (z) {
                    try {
                        C1328DB.m5404d(Identity.class, RunnableC1456a.this.f4560O).update(RunnableC1456a.this.f4561P);
                    } catch (SQLException unused) {
                        gj0.m4142c("SSHTransportAuthenticator", "Failed to save new private key passphrase for identity: " + RunnableC1456a.this.f4561P.nickname);
                        RunnableC1456a.this.f4562Q.m2511r();
                        return;
                    }
                }
                RunnableC1456a runnableC1456a2 = RunnableC1456a.this;
                runnableC1456a2.f4562Q.m2518y(runnableC1456a2.f4561P);
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            public void onCancel() {
                RunnableC1456a.this.f4562Q.m2511r();
            }
        }

        public RunnableC1456a(FragmentActivity fragmentActivity, Identity identity, bi0 bi0Var) {
            this.f4560O = fragmentActivity;
            this.f4561P = identity;
            this.f4562Q = bi0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            PasswordPrompt passwordPrompt = new PasswordPrompt(this.f4560O, new a());
            String format = String.format(this.f4560O.getString(R.string.please_enter_your_private_key_passphrase_for), this.f4561P.toString());
            passwordPrompt.m9296i(R.string.private_key);
            passwordPrompt.m9295h(format);
            if (this.f4560O.isFinishing()) {
                this.f4562Q.m2511r();
            } else {
                passwordPrompt.show();
            }
        }
    }

    /* compiled from: SSHTransportAuthenticator.java */
    /* renamed from: cz.opentree.ki0$b */
    /* loaded from: classes.dex */
    public static class RunnableC1457b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Connection f4564O;

        /* renamed from: P */
        public final /* synthetic */ FragmentActivity f4565P;

        /* renamed from: Q */
        public final /* synthetic */ bi0 f4566Q;

        /* compiled from: SSHTransportAuthenticator.java */
        /* renamed from: cz.opentree.ki0$b$a */
        /* loaded from: classes.dex */
        public class a implements IdentityPrompt.IdentityPromptListener {

            /* compiled from: SSHTransportAuthenticator.java */
            /* renamed from: cz.opentree.ki0$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C2499a implements ManageIdentityFragment.OnIdentityDialogCompleteListener {

                /* renamed from: a */
                public final /* synthetic */ ManageIdentityFragment f4568a;

                public C2499a(ManageIdentityFragment manageIdentityFragment) {
                    this.f4568a = manageIdentityFragment;
                }

                @Override // cz.opentree.limessh.fragments.ManageIdentityFragment.OnIdentityDialogCompleteListener
                /* renamed from: a */
                public void mo5288a(Identity identity) {
                    gj0.m4141b("SSHTransportAuthenticator", "Dismissing new identity dialog");
                    this.f4568a.dismiss();
                    gj0.m4141b("SSHTransportAuthenticator", "Resuming chain with new identity");
                    RunnableC1457b.this.f4566Q.m2518y(identity);
                }

                @Override // cz.opentree.limessh.fragments.ManageIdentityFragment.OnIdentityDialogCompleteListener
                public void onCancel() {
                    gj0.m4141b("SSHTransportAuthenticator", "Dismissing new identity dialog due user cancel request");
                    this.f4568a.dismiss();
                    RunnableC1457b.this.f4566Q.m2511r();
                }
            }

            public a() {
            }

            @Override // cz.opentree.util.IdentityPrompt.IdentityPromptListener
            /* renamed from: a */
            public void mo5914a(Identity identity) {
                if (!RunnableC1457b.this.f4566Q.m2514u()) {
                    RunnableC1457b runnableC1457b = RunnableC1457b.this;
                    runnableC1457b.f4564O.m5472z(identity, runnableC1457b.f4565P);
                }
                RunnableC1457b.this.f4566Q.m2518y(identity);
            }

            @Override // cz.opentree.util.IdentityPrompt.IdentityPromptListener
            /* renamed from: b */
            public void mo5915b() {
                FragmentTransaction beginTransaction = RunnableC1457b.this.f4565P.getSupportFragmentManager().beginTransaction();
                ManageIdentityFragment manageIdentityFragment = new ManageIdentityFragment();
                manageIdentityFragment.m5447v(true);
                Connection connection = RunnableC1457b.this.f4564O;
                connection.mo5368g();
                manageIdentityFragment.m5442q(connection);
                if (RunnableC1457b.this.f4566Q.m2514u()) {
                    manageIdentityFragment.m5438m(false);
                } else {
                    manageIdentityFragment.m5438m(true);
                }
                manageIdentityFragment.m5444s(new C2499a(manageIdentityFragment));
                manageIdentityFragment.show(beginTransaction, "ManageIdentityDialog");
            }

            @Override // cz.opentree.util.IdentityPrompt.IdentityPromptListener
            public void onCancel() {
                RunnableC1457b.this.f4566Q.m2511r();
            }
        }

        public RunnableC1457b(Connection connection, FragmentActivity fragmentActivity, bi0 bi0Var) {
            this.f4564O = connection;
            this.f4565P = fragmentActivity;
            this.f4566Q = bi0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            IdentityPrompt identityPrompt = new IdentityPrompt(this.f4564O, this.f4565P, new a());
            if (this.f4565P.isFinishing()) {
                this.f4566Q.m2511r();
            } else {
                identityPrompt.show();
            }
        }
    }

    /* compiled from: SSHTransportAuthenticator.java */
    /* renamed from: cz.opentree.ki0$c */
    /* loaded from: classes.dex */
    public static class RunnableC1458c implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ FragmentActivity f4570O;

        /* renamed from: P */
        public final /* synthetic */ Identity f4571P;

        /* renamed from: Q */
        public final /* synthetic */ bi0 f4572Q;

        /* compiled from: SSHTransportAuthenticator.java */
        /* renamed from: cz.opentree.ki0$c$a */
        /* loaded from: classes.dex */
        public class a implements PasswordPrompt.PasswordPromptListener {
            public a() {
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            /* renamed from: a */
            public void mo5299a(String str, boolean z) {
                RunnableC1458c runnableC1458c = RunnableC1458c.this;
                runnableC1458c.f4571P.password = qg0.m7702c(str, User.m5527u(runnableC1458c.f4570O));
                RunnableC1458c.this.f4571P.passUpdated = System.currentTimeMillis();
                if (z) {
                    try {
                        C1328DB.m5404d(Identity.class, RunnableC1458c.this.f4570O).update(RunnableC1458c.this.f4571P);
                    } catch (SQLException unused) {
                        gj0.m4142c("SSHTransportAuthenticator", "Failed to save new password for identity: " + RunnableC1458c.this.f4571P.nickname);
                    }
                }
                RunnableC1458c runnableC1458c2 = RunnableC1458c.this;
                runnableC1458c2.f4572Q.m2518y(runnableC1458c2.f4571P);
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            public void onCancel() {
                RunnableC1458c.this.f4572Q.m2511r();
            }
        }

        public RunnableC1458c(FragmentActivity fragmentActivity, Identity identity, bi0 bi0Var) {
            this.f4570O = fragmentActivity;
            this.f4571P = identity;
            this.f4572Q = bi0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            PasswordPrompt passwordPrompt = new PasswordPrompt(this.f4570O, new a());
            passwordPrompt.m9295h(String.format(this.f4570O.getString(R.string.enter_password_for), this.f4571P.username));
            if (this.f4570O.isFinishing()) {
                this.f4572Q.m2511r();
            } else {
                passwordPrompt.show();
            }
        }
    }

    /* renamed from: a */
    public static void m5911a(FragmentActivity fragmentActivity, Identity identity, bi0 bi0Var) {
        fragmentActivity.runOnUiThread(new RunnableC1458c(fragmentActivity, identity, bi0Var));
    }

    /* renamed from: b */
    public static void m5912b(FragmentActivity fragmentActivity, Identity identity, bi0 bi0Var) {
        fragmentActivity.runOnUiThread(new RunnableC1456a(fragmentActivity, identity, bi0Var));
    }

    /* renamed from: c */
    public static void m5913c(FragmentActivity fragmentActivity, Connection connection, ConnectionProvider connectionProvider, bi0 bi0Var) {
        gj0.m4141b("SSHTransportAuthenticator", connection.m5471w() + " connection doesn't have an identity attached to it - prompting for one");
        fragmentActivity.runOnUiThread(new RunnableC1457b(connection, fragmentActivity, bi0Var));
    }
}

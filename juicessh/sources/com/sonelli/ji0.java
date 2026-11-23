package com.sonelli;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.sonelli.ck0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.connections.transports.ForwardTransport;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.models.Identity;
import com.sonelli.juicessh.models.User;
import com.sonelli.libssh.adapter.SSHLog;
import com.sonelli.mh0;
import com.sonelli.mi0;
import com.sonelli.qg0;
import java.util.UUID;

/* compiled from: SSHTransport.java */
/* loaded from: classes.dex */
public abstract class ji0 extends mi0 {

    /* renamed from: d */
    public FragmentActivity f3561d;

    /* renamed from: e */
    public Thread f3562e;

    /* renamed from: f */
    public int f3563f;

    /* renamed from: g */
    public UUID f3564g;

    /* renamed from: h */
    public bi0 f3565h;

    /* renamed from: i */
    public int f3566i;

    /* renamed from: j */
    public Connection f3567j;

    /* renamed from: k */
    public ck0 f3568k;

    /* compiled from: SSHTransport.java */
    /* renamed from: com.sonelli.ji0$a */
    /* loaded from: classes.dex */
    public class RunnableC1214a implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ FragmentActivity f3569O;

        /* renamed from: P */
        public final /* synthetic */ Connection f3570P;

        /* renamed from: Q */
        public final /* synthetic */ Identity f3571Q;

        /* renamed from: R */
        public final /* synthetic */ gi0 f3572R;

        /* renamed from: S */
        public final /* synthetic */ bi0 f3573S;

        /* compiled from: SSHTransport.java */
        /* renamed from: com.sonelli.ji0$a$a */
        /* loaded from: classes.dex */
        public class a extends SSHLog.AbstractC1508a {

            /* renamed from: a */
            public final /* synthetic */ hj0 f3575a;

            public a(RunnableC1214a runnableC1214a, hj0 hj0Var) {
                this.f3575a = hj0Var;
            }

            @Override // com.sonelli.libssh.adapter.SSHLog.AbstractC1508a
            /* renamed from: a */
            public void mo5130a(int i, String str) {
                this.f3575a.m4458a(i, str);
            }
        }

        /* compiled from: SSHTransport.java */
        /* renamed from: com.sonelli.ji0$a$b */
        /* loaded from: classes.dex */
        public class b extends ck0.AbstractC0833b {
            public b() {
            }

            @Override // com.sonelli.ck0.AbstractC0833b
            /* renamed from: a */
            public boolean mo2863a(String str, String str2, String str3) {
                mh0 mh0Var = new mh0(RunnableC1214a.this.f3569O, str, str2, str3);
                int i = C1217d.f3585a[mh0Var.m6423b().ordinal()];
                if (i == 1) {
                    return true;
                }
                if (i == 2) {
                    ji0.this.m5123C(mh0Var);
                    return false;
                }
                if (i != 3) {
                    return false;
                }
                ji0.this.m5122A(mh0Var);
                return false;
            }
        }

        public RunnableC1214a(FragmentActivity fragmentActivity, Connection connection, Identity identity, gi0 gi0Var, bi0 bi0Var) {
            this.f3569O = fragmentActivity;
            this.f3570P = connection;
            this.f3571Q = identity;
            this.f3572R = gi0Var;
            this.f3573S = bi0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Connection connection;
            String str;
            try {
                ji0.this.f3568k.m2853n(new a(this, new hj0(this.f3569O)));
                ji0.this.f3568k.m2851l(this.f3570P.address);
                ji0.this.f3568k.m2858s(this.f3571Q.username);
                if (this.f3572R == null || (str = (connection = this.f3570P).redirectedAddress) == null || connection.redirectedPort <= 0) {
                    ji0.this.f3568k.m2851l(this.f3570P.address);
                    ji0.this.f3568k.m2855p(this.f3570P.port);
                } else {
                    ji0.this.f3568k.m2851l(str);
                    ji0.this.f3568k.m2855p(this.f3570P.redirectedPort);
                }
                if (this.f3571Q.m5482t()) {
                    try {
                        String m7700a = qg0.m7700a(this.f3571Q.privatekey, User.m5527u(this.f3569O));
                        String m7700a2 = qg0.m7700a(this.f3571Q.privatekeyPassword, User.m5527u(this.f3569O));
                        if (m7700a == null) {
                            throw new qg0.C1762a();
                        }
                        if (m7700a2 != null) {
                            ji0.this.f3568k.m2857r(m7700a, m7700a2);
                        } else {
                            ji0.this.f3568k.m2856q(m7700a);
                        }
                    } catch (qg0.C1762a unused) {
                        gj0.m4142c("SSHTransport", String.format("Failed to decrypt private key (null encryption key: %b)", Boolean.valueOf(User.m5527u(this.f3569O) == null)));
                    }
                }
                if (this.f3571Q.m5481s()) {
                    try {
                        String m7700a3 = qg0.m7700a(this.f3571Q.password, User.m5527u(this.f3569O));
                        if (m7700a3 == null) {
                            throw new qg0.C1762a();
                        }
                        ji0.this.f3568k.m2854o(m7700a3);
                    } catch (qg0.C1762a unused2) {
                        gj0.m4142c("SSHTransport", String.format("Failed to decrypt password (null encryption key: %b)", Boolean.valueOf(User.m5527u(this.f3569O) == null)));
                        ji0.this.f3568k.m2854o(this.f3571Q.password);
                    }
                }
                ji0.this.f3568k.m2852m(new ui0(this.f3569O, this.f3571Q));
                gj0.m4141b("SSHTransport", "Connecting SSH Session");
                ji0.this.f3568k.m2843d(new b());
                ji0.this.mo3775B();
            } catch (ek0 e) {
                gj0.m4142c("SSHTransport", "SSH Exception: " + e.getMessage());
                if (e.m3523a() == ek0.f2462Z.m3526c()) {
                    this.f3573S.m2504C(ji0.this, mi0.EnumC1556b.AUTHENTICATION_FAILURE);
                    return;
                }
                if (e.m3523a() == ek0.f2451D0.m3526c()) {
                    this.f3573S.m2504C(ji0.this, mi0.EnumC1556b.AUTHENTICATION_FAILED_PASSWORD_AVAILABLE);
                } else {
                    if (e.m3523a() == ek0.f2461Y.m3526c()) {
                        return;
                    }
                    if (e.m3523a() == ek0.f2463a0.m3526c()) {
                        this.f3573S.m2504C(ji0.this, mi0.EnumC1556b.INCORRECT_PRIVATE_KEY_PASSPHRASE);
                    } else {
                        this.f3573S.m2505D(ji0.this, mi0.EnumC1556b.UNKNOWN, e.getMessage());
                    }
                }
            }
        }
    }

    /* compiled from: SSHTransport.java */
    /* renamed from: com.sonelli.ji0$b */
    /* loaded from: classes.dex */
    public class RunnableC1215b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ mh0 f3577O;

        /* compiled from: SSHTransport.java */
        /* renamed from: com.sonelli.ji0$b$a */
        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ji0.this.f3565h.m2504C(ji0.this, mi0.EnumC1556b.HOST_KEY_REJECTED);
            }
        }

        /* compiled from: SSHTransport.java */
        /* renamed from: com.sonelli.ji0$b$b */
        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RunnableC1215b.this.f3577O.m6422a();
                ji0.this.f3565h.m2517x();
            }
        }

        public RunnableC1215b(mh0 mh0Var) {
            this.f3577O = mh0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vk0 vk0Var = new vk0(ji0.this.f3561d);
            vk0Var.m9296i(R.string.host_verification);
            String string = ji0.this.f3561d.getString(R.string.host_key_changed);
            mh0 mh0Var = this.f3577O;
            vk0Var.m9295h(String.format(string, mh0Var.f5040b, mh0Var.f5041c));
            AlertDialog create = vk0Var.setPositiveButton(ji0.this.f3561d.getString(R.string.accept), new b()).setNegativeButton(ji0.this.f3561d.getString(R.string.reject), new a()).create();
            if (ji0.this.f3561d.isFinishing()) {
                ji0.this.f3565h.m2504C(ji0.this, mi0.EnumC1556b.HOST_KEY_REJECTED);
            } else {
                create.show();
            }
        }
    }

    /* compiled from: SSHTransport.java */
    /* renamed from: com.sonelli.ji0$c */
    /* loaded from: classes.dex */
    public class RunnableC1216c implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ mh0 f3581O;

        /* compiled from: SSHTransport.java */
        /* renamed from: com.sonelli.ji0$c$a */
        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ji0.this.f3565h.m2504C(ji0.this, mi0.EnumC1556b.HOST_KEY_REJECTED);
            }
        }

        /* compiled from: SSHTransport.java */
        /* renamed from: com.sonelli.ji0$c$b */
        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RunnableC1216c.this.f3581O.m6422a();
                ji0.this.f3565h.m2517x();
            }
        }

        public RunnableC1216c(mh0 mh0Var) {
            this.f3581O = mh0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vk0 vk0Var = new vk0(ji0.this.f3561d);
            vk0Var.m9296i(R.string.host_verification);
            String string = ji0.this.f3561d.getString(R.string.this_is_the_first_time_youve_connected);
            mh0 mh0Var = this.f3581O;
            vk0Var.m9295h(String.format(string, mh0Var.f5040b, mh0Var.f5041c));
            AlertDialog create = vk0Var.setPositiveButton(ji0.this.f3561d.getString(R.string.accept), new b()).setNegativeButton(ji0.this.f3561d.getString(R.string.reject), new a()).create();
            if (ji0.this.f3561d.isFinishing()) {
                ji0.this.f3565h.m2504C(ji0.this, mi0.EnumC1556b.HOST_KEY_REJECTED);
            } else {
                create.show();
            }
        }
    }

    /* compiled from: SSHTransport.java */
    /* renamed from: com.sonelli.ji0$d */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1217d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f3585a;

        static {
            int[] iArr = new int[mh0.EnumC1553a.values().length];
            f3585a = iArr;
            try {
                iArr[mh0.EnumC1553a.OKAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3585a[mh0.EnumC1553a.NOT_SEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3585a[mh0.EnumC1553a.CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ji0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, gi0 gi0Var, Connection connection, Identity identity) {
        this.f3561d = fragmentActivity;
        this.f3563f = i;
        this.f3564g = uuid;
        this.f3565h = bi0Var;
        this.f3566i = i2;
        this.f3567j = connection;
        if (identity == null) {
            bi0Var.m2504C(this, mi0.EnumC1556b.NO_IDENTITY);
            return;
        }
        if (gi0Var != null) {
            try {
                int m4139E = gi0Var.m4139E();
                connection.redirectedPort = m4139E == -1 ? gi0Var.m4138D(connection.address, connection.port) : m4139E;
                connection.redirectedAddress = "127.0.0.1";
                gj0.m4142c("SSHTransport", String.format("Redirecting connection %s:%d to %s:%d", connection.address, Integer.valueOf(connection.port), connection.redirectedAddress, Integer.valueOf(connection.redirectedPort)));
            } catch (ForwardTransport.C1322a e) {
                e.printStackTrace();
                bi0Var.m2504C(this, mi0.EnumC1556b.FORWARDER_NOT_ACCESSIBLE);
                return;
            }
        }
        try {
            dk0 dk0Var = new dk0();
            dk0Var.m3253i(Config.m5459e(fragmentActivity, "ssh:agent"));
            this.f3568k = new ck0(dk0Var);
            Thread thread = new Thread(new RunnableC1214a(fragmentActivity, connection, identity, gi0Var, bi0Var));
            this.f3562e = thread;
            thread.start();
        } catch (ek0 e2) {
            gj0.m4142c("SSHTransport", "FAIL: " + e2.getMessage());
            bi0Var.m2504C(this, mi0.EnumC1556b.BINARY_NOT_FOUND);
        }
    }

    /* renamed from: A */
    public final void m5122A(mh0 mh0Var) {
        gj0.m4141b("SSHTransport", "Got a host key change for " + this.f3567j.m5471w());
        this.f3562e.interrupt();
        this.f3561d.runOnUiThread(new RunnableC1215b(mh0Var));
    }

    /* renamed from: B */
    public abstract void mo3775B();

    /* renamed from: C */
    public void m5123C(mh0 mh0Var) {
        gj0.m4141b("SSHTransport", "Got an unseen host key for " + this.f3567j.m5471w());
        this.f3562e.interrupt();
        this.f3561d.runOnUiThread(new RunnableC1216c(mh0Var));
    }

    @Override // com.sonelli.mi0
    /* renamed from: h */
    public void mo3506h() {
        mo3215i();
    }

    @Override // com.sonelli.mi0
    /* renamed from: i */
    public void mo3215i() {
        Thread thread = this.f3562e;
        if (thread != null && thread.isAlive()) {
            this.f3562e.interrupt();
        }
        ck0 ck0Var = this.f3568k;
        if (ck0Var != null) {
            ck0Var.m2844e();
        }
    }

    @Override // com.sonelli.mi0
    /* renamed from: k */
    public Connection mo2815k() {
        return this.f3567j;
    }

    @Override // com.sonelli.mi0
    /* renamed from: o */
    public boolean mo3216o() {
        ck0 ck0Var = this.f3568k;
        if (ck0Var == null) {
            return false;
        }
        return ck0Var.m2847h();
    }

    /* renamed from: u */
    public Activity m5124u() {
        return this.f3561d;
    }

    /* renamed from: v */
    public int m5125v() {
        return this.f3563f;
    }

    /* renamed from: w */
    public UUID m5126w() {
        return this.f3564g;
    }

    /* renamed from: x */
    public bi0 m5127x() {
        return this.f3565h;
    }

    /* renamed from: y */
    public ck0 m5128y() {
        return this.f3568k;
    }

    /* renamed from: z */
    public void m5129z() {
        this.f3565h.m2503B(this.f3566i, this);
    }
}

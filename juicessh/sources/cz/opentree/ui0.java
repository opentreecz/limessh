package cz.opentree;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.libssh.adapter.SSHAuthenticator;
import cz.opentree.qg0;
import cz.opentree.util.BlockingOnUIRunnable;
import cz.opentree.util.PasswordPrompt;
import cz.opentree.util.TextPrompt;
import java.sql.SQLException;
import java.util.Locale;

/* compiled from: InteractiveAuthenticator.java */
/* loaded from: classes.dex */
public class ui0 implements SSHAuthenticator.InteractiveAuthenticator {

    /* renamed from: a */
    public Context f6971a;

    /* renamed from: b */
    public Identity f6972b;

    /* renamed from: c */
    public boolean f6973c = false;

    /* compiled from: InteractiveAuthenticator.java */
    /* renamed from: cz.opentree.ui0$a */
    /* loaded from: classes.dex */
    public class C2012a implements BlockingOnUIRunnable.BlockingOnUIRunnableListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f6974a;

        /* renamed from: b */
        public final /* synthetic */ String[] f6975b;

        /* renamed from: c */
        public final /* synthetic */ String f6976c;

        /* compiled from: InteractiveAuthenticator.java */
        /* renamed from: cz.opentree.ui0$a$a */
        /* loaded from: classes.dex */
        public class a implements PasswordPrompt.PasswordPromptListener {

            /* renamed from: a */
            public final /* synthetic */ BlockingOnUIRunnable.BlockingOnUIFinishedListener f6978a;

            public a(BlockingOnUIRunnable.BlockingOnUIFinishedListener blockingOnUIFinishedListener) {
                this.f6978a = blockingOnUIFinishedListener;
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            /* renamed from: a */
            public void mo5299a(String str, boolean z) {
                C2012a.this.f6975b[0] = str;
                if (z) {
                    try {
                        gj0.m4141b("InteractiveAuthenticator", "Saved password for identity: " + ui0.this.f6972b.nickname);
                        ui0.this.f6972b.password = qg0.m7702c(str, User.m5527u(ui0.this.f6971a));
                        C1328DB.m5404d(Identity.class, ui0.this.f6971a).update(ui0.this.f6972b);
                    } catch (SQLException unused) {
                        gj0.m4142c("InteractiveAuthenticator", "Failed to save new password for identity: " + ui0.this.f6972b.nickname);
                    }
                }
                this.f6978a.mo8999a();
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            public void onCancel() {
                this.f6978a.mo8999a();
            }
        }

        /* compiled from: InteractiveAuthenticator.java */
        /* renamed from: cz.opentree.ui0$a$b */
        /* loaded from: classes.dex */
        public class b implements TextPrompt.TextPromptListener {

            /* renamed from: a */
            public final /* synthetic */ BlockingOnUIRunnable.BlockingOnUIFinishedListener f6980a;

            public b(BlockingOnUIRunnable.BlockingOnUIFinishedListener blockingOnUIFinishedListener) {
                this.f6980a = blockingOnUIFinishedListener;
            }

            @Override // cz.opentree.util.TextPrompt.TextPromptListener
            /* renamed from: e */
            public void mo8901e(String str) {
                C2012a.this.f6975b[0] = str;
                this.f6980a.mo8999a();
            }

            @Override // cz.opentree.util.TextPrompt.TextPromptListener
            public void onCancel() {
                this.f6980a.mo8999a();
            }
        }

        /* compiled from: InteractiveAuthenticator.java */
        /* renamed from: cz.opentree.ui0$a$c */
        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnCancelListener {

            /* renamed from: O */
            public final /* synthetic */ BlockingOnUIRunnable.BlockingOnUIFinishedListener f6982O;

            public c(C2012a c2012a, BlockingOnUIRunnable.BlockingOnUIFinishedListener blockingOnUIFinishedListener) {
                this.f6982O = blockingOnUIFinishedListener;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f6982O.mo8999a();
            }
        }

        public C2012a(boolean z, String[] strArr, String str) {
            this.f6974a = z;
            this.f6975b = strArr;
            this.f6976c = str;
        }

        @Override // cz.opentree.util.BlockingOnUIRunnable.BlockingOnUIRunnableListener
        /* renamed from: a */
        public void mo8900a(BlockingOnUIRunnable.BlockingOnUIFinishedListener blockingOnUIFinishedListener) {
            AlertDialog create = !this.f6974a ? new PasswordPrompt(ui0.this.f6971a, new a(blockingOnUIFinishedListener)).create() : new TextPrompt(ui0.this.f6971a, new b(blockingOnUIFinishedListener)).create();
            create.setOnCancelListener(new c(this, blockingOnUIFinishedListener));
            create.setTitle(R.string.interactive_authentication);
            create.setMessage(this.f6976c);
            if ((ui0.this.f6971a instanceof Activity) && ((Activity) ui0.this.f6971a).isFinishing()) {
                return;
            }
            create.show();
        }
    }

    public ui0(Context context, Identity identity) {
        this.f6971a = context;
        this.f6972b = identity;
    }

    @Override // cz.opentree.libssh.adapter.SSHAuthenticator.InteractiveAuthenticator
    /* renamed from: a */
    public String mo6201a(boolean z) {
        return m8899f(this.f6971a.getString(R.string.enter_password), z);
    }

    @Override // cz.opentree.libssh.adapter.SSHAuthenticator.InteractiveAuthenticator
    /* renamed from: b */
    public String mo6202b(String str, boolean z) {
        return m8899f(str, z);
    }

    @Override // cz.opentree.libssh.adapter.SSHAuthenticator.InteractiveAuthenticator
    /* renamed from: c */
    public boolean mo6203c() {
        return this.f6973c;
    }

    /* renamed from: f */
    public final String m8899f(String str, boolean z) {
        gj0.m4141b("InteractiveAuthenticator", "Showing interactive authentication prompt: " + str);
        if (str.toLowerCase(Locale.ENGLISH).contains("password")) {
            if (z || this.f6972b.password == null || this.f6973c) {
                this.f6973c = false;
            } else {
                gj0.m4141b("InteractiveAuthenticator", "Detected a password prompt and we have a saved password - attempting (only once) to authenticate with the saved password");
                try {
                    String m7700a = qg0.m7700a(this.f6972b.password, User.m5527u(this.f6971a));
                    if (m7700a != null && m7700a.length() > 0) {
                        this.f6973c = true;
                        return m7700a;
                    }
                } catch (qg0.C1762a e) {
                    e.printStackTrace();
                }
            }
        }
        String[] strArr = new String[1];
        new BlockingOnUIRunnable(this.f6971a, new C2012a(z, strArr, str)).m8998c();
        return strArr[0] != null ? strArr[0] : "";
    }
}

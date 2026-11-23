package cz.opentree;

import android.app.Activity;
import cz.opentree.juicessh.R;
import cz.opentree.libssh.SshLibrary;
import cz.opentree.libssh.adapter.SSHAuthenticator;
import cz.opentree.util.PasswordPrompt;

/* compiled from: SSHKey.java */
/* loaded from: classes.dex */
public class ug0 {

    /* compiled from: SSHKey.java */
    /* renamed from: cz.opentree.ug0$a */
    /* loaded from: classes.dex */
    public static class C2008a implements PasswordPrompt.PasswordPromptListener {

        /* renamed from: a */
        public final /* synthetic */ String f6960a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC2009b f6961b;

        /* renamed from: c */
        public final /* synthetic */ Activity f6962c;

        public C2008a(String str, AbstractC2009b abstractC2009b, Activity activity) {
            this.f6960a = str;
            this.f6961b = abstractC2009b;
            this.f6962c = activity;
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        /* renamed from: a */
        public void mo5299a(String str, boolean z) {
            try {
                String m6191e = SSHAuthenticator.m6191e(this.f6960a, str);
                if (m6191e == null || m6191e.isEmpty()) {
                    this.f6961b.mo5207a();
                } else {
                    this.f6961b.mo5208b(m6191e);
                }
            } catch (ek0 e) {
                if (e.m3523a() != ek0.f2463a0.m3526c()) {
                    this.f6961b.mo5207a();
                    return;
                }
                PasswordPrompt passwordPrompt = new PasswordPrompt(this.f6962c, null);
                String format = String.format(this.f6962c.getString(R.string.please_enter_your_private_key_passphrase), new Object[0]);
                passwordPrompt.m9296i(R.string.private_key);
                passwordPrompt.m9295h(format);
                passwordPrompt.m9018q();
                passwordPrompt.setCancelable(false);
                passwordPrompt.m9019r(this);
                passwordPrompt.show();
            }
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        public void onCancel() {
        }
    }

    /* compiled from: SSHKey.java */
    /* renamed from: cz.opentree.ug0$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2009b {
        /* renamed from: a */
        public void mo5207a() {
        }

        /* renamed from: b */
        public void mo5208b(String str) {
        }
    }

    /* renamed from: a */
    public static void m8891a(Activity activity, String str, String str2, AbstractC2009b abstractC2009b) {
        try {
            String m6191e = SSHAuthenticator.m6191e(str, str2);
            if (m6191e == null || m6191e.isEmpty()) {
                abstractC2009b.mo5207a();
            } else {
                abstractC2009b.mo5208b(m6191e);
            }
        } catch (ek0 e) {
            if (e.m3523a() == ek0.f2463a0.m3526c()) {
                PasswordPrompt passwordPrompt = new PasswordPrompt(activity, null);
                String format = String.format(activity.getString(R.string.please_enter_your_private_key_passphrase), new Object[0]);
                passwordPrompt.m9296i(R.string.private_key);
                passwordPrompt.m9295h(format);
                passwordPrompt.m9018q();
                passwordPrompt.setCancelable(false);
                passwordPrompt.m9019r(new C2008a(str, abstractC2009b, activity));
                passwordPrompt.show();
            }
        }
    }

    /* renamed from: b */
    public static boolean m8892b(String str) {
        String trim = str.trim();
        if (trim.startsWith(SshLibrary.RSA_HEADER_BEGIN) || trim.startsWith(SshLibrary.ECDSA_HEADER_BEGIN) || trim.startsWith(SshLibrary.DSA_HEADER_BEGIN) || trim.startsWith("-----BEGIN PRIVATE KEY-----") || trim.startsWith(SshLibrary.OPENSSH_HEADER_BEGIN)) {
            return true;
        }
        return trim.startsWith("-----BEGIN ENCRYPTED PRIVATE KEY-----");
    }
}

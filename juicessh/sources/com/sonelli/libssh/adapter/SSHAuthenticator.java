package com.sonelli.libssh.adapter;

import com.sonelli.ck0;
import com.sonelli.ek0;
import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.ssh_key_struct;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class SSHAuthenticator {

    /* renamed from: a */
    public SshLibrary f4818a;

    /* renamed from: b */
    public SshLibrary.ssh_session f4819b;

    /* renamed from: c */
    public final ck0 f4820c;

    /* renamed from: d */
    public final SSHAuthAgent f4821d;

    /* renamed from: e */
    public String f4822e;

    /* renamed from: f */
    public String f4823f;

    /* renamed from: g */
    public String f4824g;

    /* renamed from: h */
    public String f4825h;

    /* renamed from: i */
    public InteractiveAuthenticator f4826i;

    /* loaded from: classes.dex */
    public interface InteractiveAuthenticator {
        /* renamed from: a */
        String mo6201a(boolean z);

        /* renamed from: b */
        String mo6202b(String str, boolean z);

        /* renamed from: c */
        boolean mo6203c();
    }

    public SSHAuthenticator(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar, ck0 ck0Var, SSHAuthAgent sSHAuthAgent) {
        this.f4818a = sshLibrary;
        this.f4819b = ssh_sessionVar;
        this.f4820c = ck0Var;
        this.f4821d = sSHAuthAgent;
    }

    /* renamed from: e */
    public static String m6191e(String str, String str2) throws ek0 {
        try {
            SshLibrary sshLibrary = SshLibrary.INSTANCE;
            ssh_key_struct.ByReference[] byReferenceArr = {new ssh_key_struct.ByReference()};
            if (sshLibrary.ssh_pki_import_privkey_base64(str, str2, (SshLibrary.ssh_auth_callback) null, (Pointer) null, byReferenceArr) != 0) {
                throw new ek0(ek0.f2463a0);
            }
            PointerByReference pointerByReference = new PointerByReference();
            if (sshLibrary.ssh_pki_export_pubkey_base64(byReferenceArr[0], pointerByReference) != 0) {
                throw new ek0(ek0.f2488z0);
            }
            return m6192f(byReferenceArr[0].type) + pointerByReference.getValue().getString(0L) + " JuiceSSH ";
        } catch (UnsatisfiedLinkError e) {
            throw new ek0(ek0.f2452P, e.getMessage());
        }
    }

    /* renamed from: f */
    public static String m6192f(int i) {
        switch (i) {
            case 0:
                return "ssh-unknown ";
            case 1:
                return "ssh-dss ";
            case 2:
            case 3:
            case 7:
                return "ssh-rsa ";
            case 4:
                return "ssh-ecdsa ";
            case 5:
            case 14:
                return "ssh-ed25519 ";
            case 6:
                return "ssh-dsa ";
            case 8:
            case 11:
                return "ecdsa-sha2-nistp256 ";
            case 9:
            case 12:
                return "ecdsa-sha2-nistp384 ";
            case 10:
            case 13:
                return "ecdsa-sha2-nistp521 ";
            default:
                return "";
        }
    }

    /* renamed from: a */
    public void m6193a() throws ek0 {
        if (this.f4818a.ssh_userauth_none(this.f4819b, this.f4822e) == 0) {
            return;
        }
        int i = -1;
        while (true) {
            int ssh_userauth_list = this.f4818a.ssh_userauth_list(this.f4819b, this.f4822e);
            if (ssh_userauth_list <= 0) {
                throw new ek0(ek0.f2462Z);
            }
            if (ssh_userauth_list == i) {
                if ((ssh_userauth_list & 2) <= 0) {
                    throw new ek0(ek0.f2462Z);
                }
                throw new ek0(ek0.f2451D0);
            }
            if ((ssh_userauth_list & 4) > 0) {
                int m6196d = m6196d();
                if (m6196d == -1) {
                    this.f4820c.m2849j("Received SSH_AUTH_ERROR for private key authentication");
                } else if (m6196d == 0) {
                    this.f4820c.m2849j("Received SSH_AUTH_SUCCESS for private key authentication");
                    return;
                } else if (m6196d == 1) {
                    this.f4820c.m2849j("Received SSH_AUTH_DENIED for private key authentication");
                } else if (m6196d == 2) {
                    this.f4820c.m2849j("Received SSH_AUTH_PARTIAL for private key authentication");
                } else if (m6196d == 4) {
                    this.f4820c.m2849j("Received SSH_AUTH_AGAIN for private key authentication");
                }
            }
            if ((ssh_userauth_list & 16) > 0) {
                int m6194b = m6194b();
                if (m6194b == -1) {
                    this.f4820c.m2849j("Received SSH_AUTH_ERROR for keyboard-interactive authentication");
                } else if (m6194b == 0) {
                    this.f4820c.m2849j("Received SSH_AUTH_SUCCESS for keyboard-interactive authentication");
                    return;
                } else if (m6194b == 1) {
                    this.f4820c.m2849j("Received SSH_AUTH_DENIED for keyboard-interactive authentication");
                } else if (m6194b == 2) {
                    this.f4820c.m2849j("Received SSH_AUTH_PARTIAL for keyboard-interactive authentication");
                } else if (m6194b == 4) {
                    this.f4820c.m2849j("Received SSH_AUTH_AGAIN for keyboard-interactive authentication");
                }
            }
            if ((ssh_userauth_list & 2) > 0) {
                int m6195c = m6195c();
                if (m6195c == -1) {
                    this.f4820c.m2849j("Received SSH_AUTH_ERROR for password authentication");
                } else if (m6195c == 0) {
                    this.f4820c.m2849j("Received SSH_AUTH_SUCCESS for password authentication");
                    return;
                } else if (m6195c == 1) {
                    this.f4820c.m2849j("Received SSH_AUTH_DENIED for password authentication");
                } else if (m6195c == 2) {
                    this.f4820c.m2849j("Received SSH_AUTH_PARTIAL for password authentication");
                } else if (m6195c == 4) {
                    this.f4820c.m2849j("Received SSH_AUTH_AGAIN for password authentication");
                }
            }
            i = ssh_userauth_list;
        }
    }

    /* renamed from: b */
    public final int m6194b() {
        if (this.f4826i == null) {
            return 2;
        }
        int ssh_userauth_kbdint = this.f4818a.ssh_userauth_kbdint(this.f4819b, (String) null, (String) null);
        while (ssh_userauth_kbdint == 3) {
            this.f4818a.ssh_userauth_kbdint_getname(this.f4819b);
            this.f4818a.ssh_userauth_kbdint_getinstruction(this.f4819b);
            int ssh_userauth_kbdint_getnprompts = this.f4818a.ssh_userauth_kbdint_getnprompts(this.f4819b);
            for (int i = 0; i < ssh_userauth_kbdint_getnprompts; i++) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1);
                String ssh_userauth_kbdint_getprompt = this.f4818a.ssh_userauth_kbdint_getprompt(this.f4819b, i, allocateDirect);
                boolean z = allocateDirect.get() == 1;
                if (this.f4818a.ssh_userauth_kbdint_setanswer(this.f4819b, i, ssh_userauth_kbdint_getprompt.length() > 0 ? this.f4826i.mo6202b(ssh_userauth_kbdint_getprompt, z) : this.f4826i.mo6201a(z)) < 0) {
                    return -1;
                }
            }
            ssh_userauth_kbdint = this.f4818a.ssh_userauth_kbdint(this.f4819b, (String) null, (String) null);
        }
        return (ssh_userauth_kbdint == 1 && this.f4826i.mo6203c()) ? m6194b() : ssh_userauth_kbdint;
    }

    /* renamed from: c */
    public final int m6195c() {
        String str = this.f4825h;
        if (str == null) {
            return 2;
        }
        return this.f4818a.ssh_userauth_password(this.f4819b, this.f4822e, str);
    }

    /* renamed from: d */
    public final int m6196d() throws ek0 {
        if (this.f4823f == null) {
            return 2;
        }
        ssh_key_struct.ByReference[] byReferenceArr = {new ssh_key_struct.ByReference()};
        if (this.f4818a.ssh_pki_import_privkey_base64(this.f4823f, this.f4824g, (SshLibrary.ssh_auth_callback) null, (Pointer) null, byReferenceArr) != 0) {
            throw new ek0(ek0.f2463a0);
        }
        int ssh_userauth_publickey = this.f4818a.ssh_userauth_publickey(this.f4819b, this.f4822e, byReferenceArr[0]);
        if (this.f4821d != null && (ssh_userauth_publickey == 2 || ssh_userauth_publickey == 0)) {
            PointerByReference pointerByReference = new PointerByReference();
            if (this.f4818a.ssh_pki_export_privkey_base64(byReferenceArr[0], (String) null, (SshLibrary.ssh_auth_callback) null, (Pointer) null, pointerByReference) != 0) {
                this.f4820c.m2849j("Could not add key to agent: failed to extract private key");
            }
            PointerByReference pointerByReference2 = new PointerByReference();
            if (this.f4818a.ssh_pki_export_pubkey_base64(byReferenceArr[0], pointerByReference2) != 0) {
                this.f4820c.m2849j("Could not add key to agent: failed to extract public key");
            }
            this.f4821d.addKey(byReferenceArr[0].type, pointerByReference.getValue().getString(0L), pointerByReference2.getValue().getString(0L));
        }
        return ssh_userauth_publickey;
    }

    /* renamed from: g */
    public void m6197g(InteractiveAuthenticator interactiveAuthenticator) {
        this.f4826i = interactiveAuthenticator;
    }

    /* renamed from: h */
    public void m6198h(String str) {
        this.f4825h = str;
    }

    /* renamed from: i */
    public void m6199i(String str, String str2) {
        this.f4823f = str;
        this.f4824g = str2;
    }

    /* renamed from: j */
    public void m6200j(String str) {
        this.f4822e = str;
    }
}

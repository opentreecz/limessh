package com.sonelli;

import android.util.Base64;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.ochafik.lang.jnaerator.runtime.NativeSizeByReference;
import com.sonelli.fk0;
import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.adapter.SSHAuthAgent;
import com.sonelli.libssh.adapter.SSHAuthenticator;
import com.sonelli.libssh.adapter.SSHLog;
import com.sonelli.libssh.adapter.SSHPortForward;
import com.sonelli.libssh.adapter.SSHSftp;
import com.sonelli.libssh.ssh_key_struct;
import com.sun.jna.ptr.PointerByReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: SSHClient.java */
/* loaded from: classes.dex */
public class ck0 {

    /* renamed from: a */
    public dk0 f1964a;

    /* renamed from: b */
    public SshLibrary f1965b;

    /* renamed from: c */
    public SSHLog f1966c;

    /* renamed from: d */
    public String f1967d;

    /* renamed from: f */
    public String f1969f;

    /* renamed from: g */
    public SSHAuthenticator f1970g;

    /* renamed from: i */
    public SSHAuthAgent f1972i;

    /* renamed from: k */
    public SshLibrary.ssh_session f1974k;

    /* renamed from: e */
    public int f1968e = 22;

    /* renamed from: h */
    public boolean f1971h = false;

    /* renamed from: j */
    public ArrayList<bk0> f1973j = new ArrayList<>();

    /* compiled from: SSHClient.java */
    /* renamed from: com.sonelli.ck0$a */
    /* loaded from: classes.dex */
    public class RunnableC0832a implements Runnable {
        public RunnableC0832a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ck0.this.f1965b.ssh_is_connected(ck0.this.f1974k) == 1) {
                ck0.this.f1965b.ssh_silent_disconnect(ck0.this.f1974k);
            }
        }
    }

    /* compiled from: SSHClient.java */
    /* renamed from: com.sonelli.ck0$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0833b {
        /* renamed from: a */
        public abstract boolean mo2863a(String str, String str2, String str3);
    }

    public ck0(dk0 dk0Var) throws ek0 {
        try {
            SshLibrary sshLibrary = SshLibrary.INSTANCE;
            this.f1965b = sshLibrary;
            SshLibrary.ssh_session ssh_new = sshLibrary.ssh_new();
            this.f1974k = ssh_new;
            if (ssh_new == null) {
                throw new ek0(ek0.f2454R);
            }
            if (dk0Var.m3251g()) {
                this.f1972i = new SSHAuthAgent(this.f1965b, this.f1974k, this);
            }
            SshLibrary sshLibrary2 = this.f1965b;
            SshLibrary.ssh_session ssh_sessionVar = this.f1974k;
            this.f1970g = new SSHAuthenticator(sshLibrary2, ssh_sessionVar, this, this.f1972i);
            dk0Var.m3245a(sshLibrary2, ssh_sessionVar);
            this.f1964a = dk0Var;
        } catch (UnsatisfiedLinkError e) {
            throw new ek0(ek0.f2452P, e.getMessage());
        }
    }

    /* renamed from: c */
    public final void m2842c() throws ek0 {
        this.f1970g.m6200j(this.f1969f);
        this.f1970g.m6193a();
        this.f1971h = true;
    }

    /* renamed from: d */
    public void m2843d(AbstractC0833b abstractC0833b) throws ek0 {
        if (this.f1974k == null) {
            throw new ek0(ek0.f2456T, "tried to connect to an invalid ssh session");
        }
        if (m2847h()) {
            throw new ek0(ek0.f2453Q);
        }
        String str = this.f1967d;
        if (str == null) {
            throw new ek0(ek0.f2465c0);
        }
        if (this.f1965b.ssh_options_set(this.f1974k, 0, tk0.m8754i(str)) != 0) {
            throw new ek0(ek0.f2457U, String.format("could not set hostname to %s", this.f1967d));
        }
        String str2 = this.f1969f;
        if (str2 == null) {
            throw new ek0(ek0.f2464b0);
        }
        if (this.f1965b.ssh_options_set(this.f1974k, 4, tk0.m8754i(str2)) != 0) {
            throw new ek0(ek0.f2457U, String.format("could not set username to %s", this.f1969f));
        }
        if (this.f1965b.ssh_options_set(this.f1974k, 1, tk0.m8753h(Integer.valueOf(this.f1968e))) != 0) {
            throw new ek0(ek0.f2457U, String.format("could not set port to %d", Integer.valueOf(this.f1968e)));
        }
        int ssh_connect = this.f1965b.ssh_connect(this.f1974k);
        if (ssh_connect == -2) {
            throw new ek0(ek0.f2457U, "server responded with SSH_AGAIN");
        }
        if (ssh_connect == -1) {
            String ssh_get_error = this.f1965b.ssh_get_error(this.f1974k.getPointer());
            if (ssh_get_error == null) {
                ssh_get_error = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            throw new ek0(ek0.f2457U, ssh_get_error);
        }
        if (ssh_connect == 0) {
            m2849j("connect: Connected successfully to " + this.f1967d);
        }
        if (!m2862w(abstractC0833b)) {
            m2844e();
            throw new ek0(ek0.f2461Y);
        }
        try {
            m2842c();
        } catch (ek0 e) {
            m2844e();
            throw e;
        }
    }

    /* renamed from: e */
    public void m2844e() {
        Log.d("SSHClient", "Disconnecting from SSH session");
        if (m2847h()) {
            Iterator<bk0> it = this.f1973j.iterator();
            while (it.hasNext()) {
                bk0 next = it.next();
                if (next != null && !next.mo2550e()) {
                    next.m2546a();
                }
            }
            SshLibrary.ssh_session ssh_sessionVar = this.f1974k;
            if (ssh_sessionVar == null || this.f1965b.ssh_is_connected(ssh_sessionVar) != 1) {
                return;
            }
            new ScheduledThreadPoolExecutor(1).schedule(new RunnableC0832a(), 5L, TimeUnit.SECONDS);
        }
    }

    /* renamed from: f */
    public void m2845f(String str, fk0.AbstractC0995a abstractC0995a) throws ek0 {
        if (!m2847h()) {
            throw new ek0(ek0.f2470h0, "not connected");
        }
        if (!m2846g()) {
            throw new ek0(ek0.f2470h0, "not authenticated");
        }
        new fk0(this.f1965b, this.f1974k, str, abstractC0995a);
    }

    /* renamed from: g */
    public boolean m2846g() {
        return this.f1971h;
    }

    /* renamed from: h */
    public boolean m2847h() {
        SshLibrary.ssh_session ssh_sessionVar;
        SshLibrary sshLibrary = this.f1965b;
        return (sshLibrary == null || (ssh_sessionVar = this.f1974k) == null || sshLibrary.ssh_is_connected(ssh_sessionVar) != 1) ? false : true;
    }

    /* renamed from: i */
    public SSHPortForward m2848i(int i, String str, int i2) throws ek0 {
        if (!m2847h()) {
            throw new ek0(ek0.f2471i0, "not connected");
        }
        if (m2846g()) {
            return new jk0(this.f1965b, this.f1974k, i, str, i2);
        }
        throw new ek0(ek0.f2471i0, "not authenticated");
    }

    /* renamed from: j */
    public void m2849j(String str) {
        SSHLog sSHLog = this.f1966c;
        if (sSHLog != null) {
            sSHLog.log(1, str);
        }
    }

    /* renamed from: k */
    public SSHPortForward m2850k(int i, String str, int i2) throws ek0 {
        if (!m2847h()) {
            throw new ek0(ek0.f2472j0, "not connected");
        }
        if (m2846g()) {
            return new kk0(this.f1965b, this.f1974k, i, str, i2);
        }
        throw new ek0(ek0.f2472j0, "not authenticated");
    }

    /* renamed from: l */
    public void m2851l(String str) {
        this.f1967d = str;
    }

    /* renamed from: m */
    public void m2852m(SSHAuthenticator.InteractiveAuthenticator interactiveAuthenticator) {
        this.f1970g.m6197g(interactiveAuthenticator);
    }

    /* renamed from: n */
    public void m2853n(SSHLog.AbstractC1508a abstractC1508a) throws ek0 {
        if (this.f1965b.ssh_set_log_level(2) != 0) {
            throw new ek0(ek0.f2458V, "could not set log level");
        }
        SSHLog sSHLog = new SSHLog(abstractC1508a);
        this.f1966c = sSHLog;
        if (this.f1965b.ssh_set_log_callback(sSHLog) != 0) {
            throw new ek0(ek0.f2458V, "could not register logging callback");
        }
    }

    /* renamed from: o */
    public void m2854o(String str) {
        this.f1970g.m6198h(str);
    }

    /* renamed from: p */
    public void m2855p(int i) {
        this.f1968e = i;
    }

    /* renamed from: q */
    public void m2856q(String str) {
        this.f1970g.m6199i(str, null);
    }

    /* renamed from: r */
    public void m2857r(String str, String str2) {
        this.f1970g.m6199i(str, str2);
    }

    /* renamed from: s */
    public void m2858s(String str) {
        this.f1969f = str;
    }

    /* renamed from: t */
    public SSHSftp m2859t() throws ek0 {
        if (!m2847h()) {
            throw new ek0(ek0.f2486x0, "not connected");
        }
        if (m2846g()) {
            return new SSHSftp(this.f1965b, this.f1974k);
        }
        throw new ek0(ek0.f2486x0, "not authenticated");
    }

    /* renamed from: u */
    public mk0 m2860u(String str, int i, int i2) throws ek0 {
        if (!m2847h()) {
            throw new ek0(ek0.f2468f0, "not connected");
        }
        if (!m2846g()) {
            throw new ek0(ek0.f2468f0, "not authenticated");
        }
        mk0 mk0Var = new mk0(this.f1965b, this.f1974k, str, i, i2, this.f1964a);
        this.f1973j.add(mk0Var);
        return mk0Var;
    }

    /* renamed from: v */
    public SSHPortForward m2861v(int i) throws ek0 {
        if (!m2847h()) {
            throw new ek0(ek0.f2450C0, "not connected");
        }
        if (m2846g()) {
            return new rk0(this.f1965b, this.f1974k, i);
        }
        throw new ek0(ek0.f2450C0, "not authenticated");
    }

    /* renamed from: w */
    public final boolean m2862w(AbstractC0833b abstractC0833b) throws ek0 {
        if (!this.f1964a.m3252h() || abstractC0833b == null) {
            return true;
        }
        String lowerCase = this.f1967d.toLowerCase(Locale.ENGLISH);
        if (lowerCase.equals("127.0.0.1") || lowerCase.equals("localhost") || lowerCase.startsWith("fc00::")) {
            return true;
        }
        ssh_key_struct.ByReference[] byReferenceArr = {new ssh_key_struct.ByReference()};
        if (this.f1965b.ssh_get_server_publickey(this.f1974k, byReferenceArr) != 0) {
            throw new ek0(ek0.f2459W);
        }
        PointerByReference pointerByReference = new PointerByReference();
        if (this.f1965b.ssh_pki_export_pubkey_base64(byReferenceArr[0], pointerByReference) != 0) {
            throw new ek0(ek0.f2459W);
        }
        String string = pointerByReference.getValue().getString(0L);
        PointerByReference pointerByReference2 = new PointerByReference();
        NativeSizeByReference nativeSizeByReference = new NativeSizeByReference();
        if (this.f1965b.ssh_get_publickey_hash(byReferenceArr[0], 2, pointerByReference2, nativeSizeByReference) != 0) {
            throw new ek0(ek0.f2460X);
        }
        String trim = ("SHA256:" + Base64.encodeToString(pointerByReference2.getValue().getByteArray(0L, nativeSizeByReference.getValue().intValue()), 1)).trim();
        m2849j("connect: Got host key " + trim);
        if (abstractC0833b != null) {
            return abstractC0833b.mo2863a(this.f1967d, trim, string);
        }
        return false;
    }
}

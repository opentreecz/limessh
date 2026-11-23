package com.sonelli.libssh.adapter;

import android.util.Log;
import com.sonelli.ek0;
import com.sonelli.fk0;
import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.sftp_attributes_struct;
import com.sonelli.libssh.sftp_dir_struct;
import com.sonelli.libssh.sftp_session_struct;
import com.sonelli.lk0;
import com.sonelli.tk0;
import com.sun.jna.Pointer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class SSHSftp {

    /* renamed from: a */
    public SshLibrary f4834a;

    /* renamed from: b */
    public SshLibrary.ssh_session f4835b;

    /* renamed from: c */
    public sftp_session_struct f4836c;

    /* renamed from: d */
    public String f4837d;

    /* renamed from: e */
    public String f4838e;

    /* loaded from: classes.dex */
    public interface SftpProgressMonitor {
    }

    /* renamed from: com.sonelli.libssh.adapter.SSHSftp$a */
    /* loaded from: classes.dex */
    public class C1510a extends fk0.AbstractC0995a {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f4839a;

        /* renamed from: b */
        public final /* synthetic */ AtomicInteger f4840b;

        /* renamed from: c */
        public final /* synthetic */ AtomicBoolean f4841c;

        public C1510a(SSHSftp sSHSftp, ArrayList arrayList, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean) {
            this.f4839a = arrayList;
            this.f4840b = atomicInteger;
            this.f4841c = atomicBoolean;
        }

        @Override // com.sonelli.fk0.AbstractC0995a
        /* renamed from: a */
        public void mo3777a(int i) {
            super.mo3777a(i);
            this.f4840b.compareAndSet(-1, i);
            this.f4841c.compareAndSet(false, true);
        }

        @Override // com.sonelli.fk0.AbstractC0995a
        /* renamed from: b */
        public void mo3778b(String str) {
            super.mo3778b(str);
            this.f4839a.add(str);
        }
    }

    public SSHSftp(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar) throws ek0 {
        this.f4834a = sshLibrary;
        this.f4835b = ssh_sessionVar;
        sftp_session_struct sftp_new = sshLibrary.sftp_new(ssh_sessionVar);
        this.f4836c = sftp_new;
        if (sftp_new == null) {
            throw new ek0(ek0.f2486x0, sshLibrary.ssh_get_error(ssh_sessionVar.getPointer()));
        }
        if (sshLibrary.sftp_init(sftp_new) != 0) {
            throw new ek0(ek0.f2487y0, String.format("ERROR %d", Integer.valueOf(sshLibrary.sftp_get_error(this.f4836c))));
        }
    }

    /* renamed from: m */
    public static void m6205m(int i) throws ek0 {
        if (i == 0) {
            return;
        }
        switch (i) {
            case 0:
                return;
            case 1:
                throw new ek0(ek0.f2473k0);
            case 2:
                throw new ek0(ek0.f2474l0);
            case 3:
                throw new ek0(ek0.f2475m0);
            case 4:
                throw new ek0(ek0.f2476n0);
            case 5:
                throw new ek0(ek0.f2477o0);
            case 6:
                throw new ek0(ek0.f2478p0);
            case 7:
                throw new ek0(ek0.f2479q0);
            case 8:
                throw new ek0(ek0.f2480r0);
            case 9:
                throw new ek0(ek0.f2481s0);
            case 10:
                throw new ek0(ek0.f2482t0);
            case 11:
                throw new ek0(ek0.f2483u0);
            case 12:
                throw new ek0(ek0.f2484v0);
            case 13:
                throw new ek0(ek0.f2484v0);
            default:
                throw new ek0(ek0.f2476n0);
        }
    }

    /* renamed from: a */
    public void m6206a(String str) throws ek0 {
        String m6219o = m6219o(m6224t(str));
        Pointer sftp_canonicalize_path = this.f4834a.sftp_canonicalize_path(this.f4836c, m6219o);
        if (sftp_canonicalize_path == null) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        } else {
            m6219o = sftp_canonicalize_path.getString(0L);
        }
        sftp_attributes_struct sftp_stat = this.f4834a.sftp_stat(this.f4836c, m6219o);
        int i = sftp_stat.flags;
        SshLibrary sshLibrary = this.f4834a;
        if ((i & 4) == 0) {
            throw new ek0(ek0.f2475m0, "Can't change directory: " + m6219o);
        }
        if (sftp_stat.type == 2) {
            sshLibrary.sftp_attributes_free(sftp_stat);
            this.f4837d = m6219o;
        } else {
            throw new ek0(ek0.f2482t0, "Can't change directory: " + m6219o);
        }
    }

    /* renamed from: b */
    public void m6207b(int i, String str) throws ek0 {
        String m6224t = m6224t(str);
        sftp_attributes_struct sftp_stat = this.f4834a.sftp_stat(this.f4836c, m6224t);
        if (sftp_stat == null) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
            return;
        }
        sftp_stat.autoRead();
        int i2 = sftp_stat.uid;
        this.f4834a.sftp_attributes_free(sftp_stat);
        if (this.f4834a.sftp_chown(this.f4836c, m6224t, i2, i) != 0) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
    }

    /* renamed from: c */
    public void m6208c(String str, String str2) throws ek0 {
        m6207b(m6216k(str, 1), str2);
    }

    /* renamed from: d */
    public void m6209d(int i, String str) throws ek0 {
        if (this.f4834a.sftp_chmod(this.f4836c, m6224t(str), i) != 0) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
    }

    /* renamed from: e */
    public void m6210e(int i, String str) throws ek0 {
        String m6224t = m6224t(str);
        sftp_attributes_struct sftp_stat = this.f4834a.sftp_stat(this.f4836c, m6224t);
        if (sftp_stat == null) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
            return;
        }
        sftp_stat.autoRead();
        int i2 = sftp_stat.gid;
        this.f4834a.sftp_attributes_free(sftp_stat);
        if (this.f4834a.sftp_chown(this.f4836c, m6224t, i, i2) != 0) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
    }

    /* renamed from: f */
    public void m6211f(String str, String str2) throws ek0 {
        m6210e(m6216k(str, 0), str2);
    }

    /* renamed from: g */
    public void m6212g() {
        sftp_session_struct sftp_session_structVar = this.f4836c;
        if (sftp_session_structVar != null) {
            this.f4834a.sftp_free(sftp_session_structVar);
        }
    }

    /* renamed from: h */
    public final String m6213h() throws ek0 {
        if (this.f4837d == null) {
            this.f4837d = m6215j();
        }
        return this.f4837d;
    }

    /* renamed from: i */
    public int m6214i() {
        if (m6218n()) {
            return this.f4834a.ssh_channel_get_exit_status(this.f4836c.channel);
        }
        return -1;
    }

    /* renamed from: j */
    public String m6215j() throws ek0 {
        if (this.f4838e == null) {
            Pointer sftp_canonicalize_path = this.f4834a.sftp_canonicalize_path(this.f4836c, "");
            if (sftp_canonicalize_path == null) {
                m6205m(this.f4834a.sftp_get_error(this.f4836c));
            } else {
                this.f4838e = sftp_canonicalize_path.getString(0L);
            }
        }
        return this.f4838e;
    }

    /* renamed from: k */
    public final int m6216k(String str, int i) throws ek0 {
        String str2;
        if (i == 0) {
            str2 = "u";
        } else {
            if (i != 1) {
                throw new ek0(ek0.f2470h0, "Not sure if looking up ID for user or group");
            }
            str2 = "g";
        }
        String format = String.format("id -%s %s", str2, str);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ArrayList arrayList = new ArrayList();
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        new fk0(this.f4834a, this.f4835b, format, new C1510a(this, arrayList, atomicInteger, atomicBoolean));
        while (!atomicBoolean.get()) {
            try {
                Thread.sleep(5L);
            } catch (InterruptedException unused) {
                throw new ek0(ek0.f2470h0, String.format("Failed to execute %s to get id for entity", format));
            }
        }
        if (atomicInteger.get() != 0) {
            throw new ek0(ek0.f2470h0, String.format("Executing %s to get id for entity returned an error", format));
        }
        if (arrayList.size() != 1) {
            throw new ek0(ek0.f2470h0, "Could not parse stdout as uid or gid (multiple lines)");
        }
        try {
            return Integer.parseInt((String) arrayList.get(0));
        } catch (NumberFormatException unused2) {
            throw new ek0(ek0.f2470h0, String.format("Could not parse %s as uid/gid int", arrayList.get(0)));
        }
    }

    /* renamed from: l */
    public final Vector<String> m6217l(String str) throws ek0 {
        Vector<String> vector = new Vector<>();
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf < 0) {
            vector.addElement(tk0.m8759n(str));
            return vector;
        }
        String substring = str.substring(0, lastIndexOf == 0 ? 1 : lastIndexOf);
        String substring2 = str.substring(lastIndexOf + 1);
        String m8759n = tk0.m8759n(substring);
        byte[][] bArr = new byte[1];
        if (!tk0.m8751f(substring2, bArr)) {
            if (!m8759n.equals("/")) {
                m8759n = m8759n + "/";
            }
            vector.addElement(m8759n + tk0.m8759n(substring2));
            return vector;
        }
        byte[] bArr2 = bArr[0];
        Vector<lk0> m6220p = m6220p(m8759n);
        if (!m8759n.endsWith("/")) {
            m8759n = m8759n + "/";
        }
        Iterator<lk0> it = m6220p.iterator();
        while (it.hasNext()) {
            lk0 next = it.next();
            if (tk0.m8749d(bArr2, tk0.m8757l(next.f4851a))) {
                vector.addElement(m8759n + next.f4851a);
            }
        }
        return vector;
    }

    /* renamed from: n */
    public boolean m6218n() {
        return this.f4834a.channel_is_closed(this.f4836c.channel) != 0;
    }

    /* renamed from: o */
    public final String m6219o(String str) throws ek0 {
        Vector<String> m6217l = m6217l(str);
        if (m6217l.size() == 1) {
            return m6217l.elementAt(0);
        }
        throw new ek0(ek0.f2476n0, str + " is not unique: " + m6217l.toString());
    }

    /* renamed from: p */
    public Vector<lk0> m6220p(String str) throws ek0 {
        Vector<lk0> vector = new Vector<>();
        sftp_dir_struct sftp_opendir = this.f4834a.sftp_opendir(this.f4836c, str);
        if (sftp_opendir == null) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
        while (true) {
            sftp_attributes_struct sftp_readdir = this.f4834a.sftp_readdir(this.f4836c, sftp_opendir);
            if (sftp_readdir == null) {
                break;
            }
            sftp_readdir.autoRead();
            vector.add(new lk0(sftp_readdir));
            this.f4834a.sftp_attributes_free(sftp_readdir);
        }
        if (this.f4834a.sftp_dir_eof(sftp_opendir) == 0) {
            this.f4834a.sftp_closedir(sftp_opendir);
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
        int sftp_closedir = this.f4834a.sftp_closedir(sftp_opendir);
        SshLibrary sshLibrary = this.f4834a;
        if (sftp_closedir != 0) {
            m6205m(sshLibrary.sftp_get_error(this.f4836c));
        }
        return vector;
    }

    /* renamed from: q */
    public void m6221q(String str, String str2) throws ek0 {
        String m6224t = m6224t(str);
        String m6224t2 = m6224t(str2);
        if (m6224t2.endsWith("/")) {
            int lastIndexOf = m6224t.lastIndexOf("/");
            if (lastIndexOf == -1) {
                m6224t2 = m6224t2 + m6224t;
            } else {
                m6224t2 = m6224t2 + m6224t.substring(lastIndexOf + 1);
            }
        }
        Log.d("SSHSftp", String.format("Moving %s to %s", m6224t, m6224t2));
        if (this.f4834a.sftp_rename(this.f4836c, m6224t, m6224t2) != 0) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
    }

    /* renamed from: r */
    public String m6222r() throws ek0 {
        return m6213h();
    }

    /* renamed from: s */
    public String m6223s(String str) throws ek0 {
        String m6224t = m6224t(str);
        Pointer sftp_readlink = this.f4834a.sftp_readlink(this.f4836c, m6224t);
        if (sftp_readlink != null) {
            return sftp_readlink.getString(0L);
        }
        throw new ek0(ek0.f2470h0, String.format("Could not read symlink of %s", m6224t));
    }

    /* renamed from: t */
    public final String m6224t(String str) throws ek0 {
        if (str.charAt(0) == '/') {
            return str;
        }
        if (str.charAt(0) == '~') {
            String m6215j = m6215j();
            if (m6215j.endsWith("/")) {
                return m6215j + str.substring(1);
            }
            return m6215j + "/" + str.substring(1);
        }
        String m6213h = m6213h();
        if (m6213h.endsWith("/")) {
            return m6213h + str;
        }
        return m6213h + "/" + str;
    }

    /* renamed from: u */
    public void m6225u(String str) throws ek0 {
        if (this.f4834a.sftp_unlink(this.f4836c, m6224t(str)) != 0) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
    }

    /* renamed from: v */
    public void m6226v(String str) throws ek0 {
        if (this.f4834a.sftp_rmdir(this.f4836c, m6224t(str)) != 0) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        }
    }

    /* renamed from: w */
    public lk0 m6227w(String str) throws ek0 {
        String m6224t = m6224t(str);
        Pointer sftp_canonicalize_path = this.f4834a.sftp_canonicalize_path(this.f4836c, m6224t);
        if (sftp_canonicalize_path == null) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
        } else {
            m6224t = sftp_canonicalize_path.getString(0L);
        }
        sftp_attributes_struct sftp_stat = this.f4834a.sftp_stat(this.f4836c, m6224t);
        if (sftp_stat == null) {
            m6205m(this.f4834a.sftp_get_error(this.f4836c));
            return null;
        }
        sftp_stat.autoRead();
        lk0 lk0Var = new lk0(sftp_stat);
        this.f4834a.sftp_attributes_free(sftp_stat);
        return lk0Var;
    }
}

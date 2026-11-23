package com.sonelli;

import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.adapter.SSHLog;

/* compiled from: SSHConfig.java */
/* loaded from: classes.dex */
public class dk0 {

    /* renamed from: a */
    public SSHLog.EnumC1509b f2224a = SSHLog.EnumC1509b.LOG_VERBOSITY_PACKET;

    /* renamed from: b */
    public String f2225b = "zlib@openssh.com,zlib,none";

    /* renamed from: c */
    public String f2226c = "zlib@openssh.com,zlib,none";

    /* renamed from: d */
    public int f2227d = 9;

    /* renamed from: e */
    public boolean f2228e = true;

    /* renamed from: f */
    public int f2229f = 60;

    /* renamed from: g */
    public boolean f2230g = true;

    /* renamed from: a */
    public dk0 m3245a(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar) throws ek0 {
        if (sshLibrary.ssh_options_set(ssh_sessionVar, 17, tk0.m8754i(m3246b())) != 0) {
            throw new ek0(ek0.f2455S, String.format("could not set compression to %s for client->server", m3246b()));
        }
        if (sshLibrary.ssh_options_set(ssh_sessionVar, 18, tk0.m8754i(m3247c())) != 0) {
            throw new ek0(ek0.f2455S, String.format("could not set compression to %s for server->client", m3247c()));
        }
        if (sshLibrary.ssh_options_set(ssh_sessionVar, 23, tk0.m8753h(Integer.valueOf(m3248d()))) != 0) {
            throw new ek0(ek0.f2455S, String.format("could not set compression level to %d", Integer.valueOf(m3248d())));
        }
        if (sshLibrary.ssh_options_set(ssh_sessionVar, 21, tk0.m8755j(m3252h())) != 0) {
            throw new ek0(ek0.f2455S, String.format("could not set strict host key checking to %b", Boolean.valueOf(m3252h())));
        }
        if (sshLibrary.ssh_options_set(ssh_sessionVar, 9, tk0.m8753h(Integer.valueOf(m3249e()))) != 0) {
            throw new ek0(ek0.f2455S, String.format("could not set connection timeout to %d", Integer.valueOf(m3249e())));
        }
        if (sshLibrary.ssh_options_set(ssh_sessionVar, 13, tk0.m8753h(Integer.valueOf(m3250f().m6204f()))) == 0) {
            return this;
        }
        throw new ek0(ek0.f2455S, String.format("could set log verbosity to level %d", Integer.valueOf(m3250f().m6204f())));
    }

    /* renamed from: b */
    public String m3246b() {
        return this.f2226c;
    }

    /* renamed from: c */
    public String m3247c() {
        return this.f2225b;
    }

    /* renamed from: d */
    public int m3248d() {
        return this.f2227d;
    }

    /* renamed from: e */
    public int m3249e() {
        return this.f2229f;
    }

    /* renamed from: f */
    public SSHLog.EnumC1509b m3250f() {
        return this.f2224a;
    }

    /* renamed from: g */
    public boolean m3251g() {
        return this.f2230g;
    }

    /* renamed from: h */
    public boolean m3252h() {
        return this.f2228e;
    }

    /* renamed from: i */
    public void m3253i(boolean z) {
        this.f2230g = z;
    }
}

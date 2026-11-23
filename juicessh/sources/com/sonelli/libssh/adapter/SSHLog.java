package com.sonelli.libssh.adapter;

import com.sonelli.libssh.SshLibrary;
import com.sun.jna.Pointer;

/* loaded from: classes.dex */
public class SSHLog implements SshLibrary.ssh_logging_callback {
    private AbstractC1508a listener;

    /* renamed from: com.sonelli.libssh.adapter.SSHLog$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1508a {
        /* renamed from: a */
        public abstract void mo5130a(int i, String str);
    }

    /* renamed from: com.sonelli.libssh.adapter.SSHLog$b */
    /* loaded from: classes.dex */
    public enum EnumC1509b {
        LOG_VERBOSITY_NOLOG(0),
        LOG_VERBOSITY_WARNING(1),
        LOG_VERBOSITY_PROTOCOL(2),
        LOG_VERBOSITY_PACKET(3),
        LOG_VERBOSITY_FUNCTIONS(4);


        /* renamed from: O */
        public int f4833O;

        EnumC1509b(int i) {
            this.f4833O = i;
        }

        /* renamed from: f */
        public int m6204f() {
            return this.f4833O;
        }
    }

    public SSHLog(AbstractC1508a abstractC1508a) {
        this.listener = abstractC1508a;
    }

    @Override // com.sonelli.libssh.SshLibrary.ssh_logging_callback
    public void apply(int i, Pointer pointer, Pointer pointer2, Pointer pointer3) {
        if (this.listener != null) {
            String string = pointer2.getString(0L);
            if (string.equals("ssh_channel_accept: No channel request of this type from server")) {
                return;
            }
            this.listener.mo5130a(i, string);
        }
    }

    public void log(int i, String str) {
        AbstractC1508a abstractC1508a = this.listener;
        if (abstractC1508a != null) {
            abstractC1508a.mo5130a(i, str);
        }
    }
}

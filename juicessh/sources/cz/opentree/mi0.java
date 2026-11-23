package cz.opentree;

import androidx.core.app.NotificationCompat;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Connection;
import java.util.HashMap;

/* compiled from: Transport.java */
/* loaded from: classes.dex */
public abstract class mi0 {

    /* renamed from: c */
    public static HashMap<EnumC1556b, Integer> f5048c = new C1555a();

    /* renamed from: a */
    public NotificationCompat.Builder f5049a;

    /* renamed from: b */
    public NotificationCompat.Builder f5050b;

    /* compiled from: Transport.java */
    /* renamed from: cz.opentree.mi0$a */
    /* loaded from: classes.dex */
    public static class C1555a extends HashMap<EnumC1556b, Integer> {
        public C1555a() {
            EnumC1556b enumC1556b = EnumC1556b.SHELL_FAILED;
            Integer valueOf = Integer.valueOf(R.string.connection_failed);
            put(enumC1556b, valueOf);
            put(EnumC1556b.STREAM_CROSSING_FAILED, valueOf);
            put(EnumC1556b.INVALID_PRIVATE_KEY, Integer.valueOf(R.string.invalid_private_key));
            put(EnumC1556b.INCORRECT_PRIVATE_KEY_PASSPHRASE, Integer.valueOf(R.string.incorrect_private_key_passphrase));
            put(EnumC1556b.FORWARDER_NOT_CONNECTED, valueOf);
            put(EnumC1556b.FORWARDER_NOT_ACCESSIBLE, valueOf);
            EnumC1556b enumC1556b2 = EnumC1556b.HOST_KEY_REJECTED;
            Integer valueOf2 = Integer.valueOf(R.string.host_key_rejected);
            put(enumC1556b2, valueOf2);
            put(EnumC1556b.HOST_KEY_UNKNOWN, valueOf2);
            put(EnumC1556b.HOST_KEY_CHANGED, Integer.valueOf(R.string.host_key_changed));
            EnumC1556b enumC1556b3 = EnumC1556b.AUTHENTICATION_FAILURE;
            Integer valueOf3 = Integer.valueOf(R.string.authentication_failure);
            put(enumC1556b3, valueOf3);
            put(EnumC1556b.AUTHENTICATION_FAILED_PASSWORD_AVAILABLE, valueOf3);
            put(EnumC1556b.AUTHENTICATION_CANCELLED, Integer.valueOf(R.string.authentication_cancelled));
            EnumC1556b enumC1556b4 = EnumC1556b.UNABLE_TO_CONNECT;
            Integer valueOf4 = Integer.valueOf(R.string.unabled_to_connect_to_host);
            put(enumC1556b4, valueOf4);
            put(EnumC1556b.CONNECTION_TIMED_OUT, valueOf4);
            put(EnumC1556b.CONNECTION_REFUSED, valueOf4);
            put(EnumC1556b.UNABLE_TO_RESOLVE, valueOf4);
            put(EnumC1556b.NO_IDENTITY, Integer.valueOf(R.string.no_identity));
            put(EnumC1556b.CONNECTION_POLL_FAILED, valueOf);
            put(EnumC1556b.PROCESS_EXECUTION_FAILED, Integer.valueOf(R.string.process_execution_failed));
            put(EnumC1556b.COULDNT_OPEN_MOSH_SESSION, Integer.valueOf(R.string.couldnt_open_a_mosh_session));
            put(EnumC1556b.CONNECT_VIA_NOT_SUPPORTED, Integer.valueOf(R.string.connect_via_only_supports_ssh_connections));
            put(EnumC1556b.FAILED_TO_INITIATE_SSH_TRANSPORT, Integer.valueOf(R.string.error_occurred_while_trying_to_initiate_ssh_transport));
            put(EnumC1556b.COULD_NOT_FIND_MOSH_INSTALLATION, Integer.valueOf(R.string.could_not_find_mosh_installation));
            put(EnumC1556b.COULD_NOT_DETECT_MOSH_PORT_KEY, Integer.valueOf(R.string.could_not_detect_mosh_port_key_with_min_version));
            put(EnumC1556b.MOSH_SERVER_TIMED_OUT, Integer.valueOf(R.string.mosh_server_timed_out));
            put(EnumC1556b.MOSH_LOCALE_NOT_AVAILABLE, Integer.valueOf(R.string.the_requested_locale_is_not_installed_on_the_host));
            put(EnumC1556b.MOSH_REQUIRES_UTF8_LOCALE, Integer.valueOf(R.string.mosh_requires_a_utf8_locale));
            put(EnumC1556b.UNSUPPORTED_CPU_ARCH, Integer.valueOf(R.string.unsupported_cpu_architecture));
            put(EnumC1556b.BINARY_NOT_FOUND, Integer.valueOf(R.string.binary_not_found));
            put(EnumC1556b.UNKNOWN, valueOf);
        }
    }

    /* compiled from: Transport.java */
    /* renamed from: cz.opentree.mi0$b */
    /* loaded from: classes.dex */
    public enum EnumC1556b {
        SHELL_FAILED,
        STREAM_CROSSING_FAILED,
        INVALID_PRIVATE_KEY,
        INCORRECT_PRIVATE_KEY_PASSPHRASE,
        FORWARDER_NOT_CONNECTED,
        HOST_KEY_REJECTED,
        HOST_KEY_UNKNOWN,
        HOST_KEY_CHANGED,
        AUTHENTICATION_FAILURE,
        AUTHENTICATION_FAILED_PASSWORD_AVAILABLE,
        AUTHENTICATION_CANCELLED,
        UNABLE_TO_CONNECT,
        NO_IDENTITY,
        CONNECTION_POLL_FAILED,
        FORWARDER_NOT_ACCESSIBLE,
        PROCESS_EXECUTION_FAILED,
        COULDNT_OPEN_MOSH_SESSION,
        CONNECT_VIA_NOT_SUPPORTED,
        FAILED_TO_INITIATE_SSH_TRANSPORT,
        COULD_NOT_FIND_MOSH_INSTALLATION,
        COULD_NOT_DETECT_MOSH_PORT_KEY,
        MOSH_SERVER_TIMED_OUT,
        MOSH_LOCALE_NOT_AVAILABLE,
        MOSH_REQUIRES_UTF8_LOCALE,
        UNKNOWN_HOST,
        UNSUPPORTED_CPU_ARCH,
        BINARY_NOT_FOUND,
        CONNECTION_TIMED_OUT,
        CONNECTION_REFUSED,
        UNABLE_TO_RESOLVE,
        UNKNOWN
    }

    /* renamed from: h */
    public abstract void mo3506h();

    /* renamed from: i */
    public abstract void mo3215i();

    /* renamed from: j */
    public int m6425j() {
        if (mo2815k() != null) {
            return mo2815k().backspaceMode;
        }
        return 0;
    }

    /* renamed from: k */
    public abstract Connection mo2815k();

    /* renamed from: l */
    public int mo3507l() {
        return 0;
    }

    /* renamed from: m */
    public abstract NotificationCompat.Builder mo3508m();

    /* renamed from: n */
    public abstract NotificationCompat.Builder mo3509n();

    /* renamed from: o */
    public abstract boolean mo3216o();

    /* renamed from: p */
    public boolean mo2816p() {
        return true;
    }

    /* renamed from: q */
    public boolean mo2817q() {
        return true;
    }
}

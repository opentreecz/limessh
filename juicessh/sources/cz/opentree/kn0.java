package cz.opentree;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes.dex */
public final class kn0 {

    /* renamed from: a */
    public final List<mm0> f4624a;

    /* renamed from: b */
    public int f4625b = 0;

    /* renamed from: c */
    public boolean f4626c;

    /* renamed from: d */
    public boolean f4627d;

    public kn0(List<mm0> list) {
        this.f4624a = list;
    }

    /* renamed from: a */
    public mm0 m5957a(SSLSocket sSLSocket) throws IOException {
        mm0 mm0Var;
        int i = this.f4625b;
        int size = this.f4624a.size();
        while (true) {
            if (i >= size) {
                mm0Var = null;
                break;
            }
            mm0Var = this.f4624a.get(i);
            if (mm0Var.m6465c(sSLSocket)) {
                this.f4625b = i + 1;
                break;
            }
            i++;
        }
        if (mm0Var != null) {
            this.f4626c = m5959c(sSLSocket);
            dn0.f2249a.mo3267c(mm0Var, sSLSocket, this.f4627d);
            return mm0Var;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f4627d + ", modes=" + this.f4624a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: b */
    public boolean m5958b(IOException iOException) {
        this.f4627d = true;
        if (!this.f4626c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }

    /* renamed from: c */
    public final boolean m5959c(SSLSocket sSLSocket) {
        for (int i = this.f4625b; i < this.f4624a.size(); i++) {
            if (this.f4624a.get(i).m6465c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}

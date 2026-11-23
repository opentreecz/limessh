package com.sonelli;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class j40 extends SSLSocketFactory {

    /* renamed from: a */
    public final SSLSocketFactory f3489a;

    public j40() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    public j40(SSLSocketFactory sSLSocketFactory) {
        this.f3489a = sSLSocketFactory;
    }

    /* renamed from: a */
    public final SSLSocket m5052a(SSLSocket sSLSocket) {
        return new i40(this, sSLSocket);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        return m5052a((SSLSocket) this.f3489a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        return m5052a((SSLSocket) this.f3489a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return m5052a((SSLSocket) this.f3489a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return m5052a((SSLSocket) this.f3489a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return m5052a((SSLSocket) this.f3489a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return m5052a((SSLSocket) this.f3489a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f3489a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f3489a.getSupportedCipherSuites();
    }
}

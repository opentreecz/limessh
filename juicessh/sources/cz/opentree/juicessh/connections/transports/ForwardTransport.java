package cz.opentree.juicessh.connections.transports;

import cz.opentree.gj0;
import java.io.IOException;
import java.net.ServerSocket;

/* loaded from: classes.dex */
public interface ForwardTransport {

    /* renamed from: cz.opentree.juicessh.connections.transports.ForwardTransport$a */
    /* loaded from: classes.dex */
    public static class C1322a extends Exception {

        /* renamed from: O */
        public String f3980O;

        /* renamed from: P */
        public StackTraceElement[] f3981P;

        public C1322a(String str, StackTraceElement[] stackTraceElementArr) {
            this.f3980O = str;
            this.f3981P = stackTraceElementArr;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f3980O;
        }

        @Override // java.lang.Throwable
        public void printStackTrace() {
            StackTraceElement[] stackTraceElementArr = this.f3981P;
            if (stackTraceElementArr != null) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    gj0.m4142c("ForwardTransportException", stackTraceElement.toString());
                }
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.connections.transports.ForwardTransport$b */
    /* loaded from: classes.dex */
    public static class C1323b {
        /* renamed from: a */
        public static int m5369a() throws IOException {
            ServerSocket serverSocket = new ServerSocket(0);
            int localPort = serverSocket.getLocalPort();
            serverSocket.close();
            gj0.m4141b("ForwardTransportUtil", "Found unused random TCP port: " + localPort);
            return localPort;
        }
    }
}

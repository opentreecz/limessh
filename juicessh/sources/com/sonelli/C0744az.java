package com.sonelli;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.WorkerThread;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.az */
/* loaded from: classes.dex */
public final class C0744az extends w30 {

    /* renamed from: d */
    public final SSLSocketFactory f1545d;

    public C0744az(z30 z30Var) {
        super(z30Var);
        this.f1545d = Build.VERSION.SDK_INT < 19 ? new j40() : null;
    }

    @WorkerThread
    /* renamed from: y */
    public static byte[] m2314y(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override // com.sonelli.w30
    /* renamed from: v */
    public final boolean mo2315v() {
        return false;
    }

    @WorkerThread
    /* renamed from: w */
    public final HttpURLConnection m2316w(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        SSLSocketFactory sSLSocketFactory = this.f1545d;
        if (sSLSocketFactory != null && (openConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) openConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setReadTimeout(61000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* renamed from: z */
    public final boolean m2317z() {
        NetworkInfo networkInfo;
        m9404t();
        try {
            networkInfo = ((ConnectivityManager) mo1482h().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }
}

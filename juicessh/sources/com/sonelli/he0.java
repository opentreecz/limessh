package com.sonelli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class he0 implements Runnable {

    /* renamed from: O */
    public final long f3139O;

    /* renamed from: P */
    public final PowerManager.WakeLock f3140P;

    /* renamed from: Q */
    public final FirebaseInstanceId f3141Q;

    public he0(FirebaseInstanceId firebaseInstanceId, long j) {
        this.f3141Q = firebaseInstanceId;
        this.f3139O = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) m4441a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f3140P = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    /* renamed from: a */
    public final Context m4441a() {
        return this.f3141Q.m1884h().m1580g();
    }

    /* renamed from: b */
    public final boolean m4442b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) m4441a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: c */
    public final boolean m4443c() throws IOException {
        ee0 m1889r = this.f3141Q.m1889r();
        boolean z = true;
        if (!this.f3141Q.m1888q(m1889r)) {
            return true;
        }
        try {
            String m1891u = this.f3141Q.m1891u();
            if (m1891u == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if ((m1889r == null || (m1889r != null && !m1891u.equals(m1889r.f2372a))) && "[DEFAULT]".equals(this.f3141Q.m1884h().m1581i())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(this.f3141Q.m1884h().m1581i());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", m1891u);
                Context m4441a = m4441a();
                Intent intent2 = new Intent(m4441a, (Class<?>) FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                m4441a.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (!z) {
                if (e.getMessage() != null) {
                    throw e;
                }
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            String message2 = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message2).length() + 52);
            sb.append("Token retrieval failed: ");
            sb.append(message2);
            sb.append(". Will retry token retrieval");
            Log.w("FirebaseInstanceId", sb.toString());
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        if (ce0.m2778b().m2780c(m4441a())) {
            this.f3140P.acquire();
        }
        try {
            try {
                this.f3141Q.m1887p(true);
                if (!this.f3141Q.m1893x()) {
                    this.f3141Q.m1887p(false);
                    if (ce0.m2778b().m2780c(m4441a())) {
                        this.f3140P.release();
                        return;
                    }
                    return;
                }
                if (ce0.m2778b().m2782e(m4441a()) && !m4442b()) {
                    new ge0(this).m4118a();
                    if (ce0.m2778b().m2780c(m4441a())) {
                        this.f3140P.release();
                        return;
                    }
                    return;
                }
                if (m4443c()) {
                    this.f3141Q.m1887p(false);
                } else {
                    this.f3141Q.m1886l(this.f3139O);
                }
                if (ce0.m2778b().m2780c(m4441a())) {
                    this.f3140P.release();
                }
            } catch (IOException e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.f3141Q.m1887p(false);
                if (ce0.m2778b().m2780c(m4441a())) {
                    this.f3140P.release();
                }
            }
        } catch (Throwable th) {
            if (ce0.m2778b().m2780c(m4441a())) {
                this.f3140P.release();
            }
            throw th;
        }
    }
}

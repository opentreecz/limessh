package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.sonelli.AbstractC2207w9;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.xa */
/* loaded from: classes.dex */
public final class C2270xa extends AbstractC2207w9 implements Handler.Callback {

    /* renamed from: d */
    public final Context f7912d;

    /* renamed from: e */
    public final Handler f7913e;

    /* renamed from: c */
    @GuardedBy("mConnectionStatus")
    public final HashMap<AbstractC2207w9.a, ServiceConnectionC2419za> f7911c = new HashMap<>();

    /* renamed from: f */
    public final C1926tb f7914f = C1926tb.m8637b();

    /* renamed from: g */
    public final long f7915g = 5000;

    /* renamed from: h */
    public final long f7916h = 300000;

    public C2270xa(Context context) {
        this.f7912d = context.getApplicationContext();
        this.f7913e = new HandlerC0872df(context.getMainLooper(), this);
    }

    @Override // com.sonelli.AbstractC2207w9
    /* renamed from: c */
    public final boolean mo9452c(AbstractC2207w9.a aVar, ServiceConnection serviceConnection, String str) {
        boolean m10409d;
        C0813ca.m2730l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7911c) {
            ServiceConnectionC2419za serviceConnectionC2419za = this.f7911c.get(aVar);
            if (serviceConnectionC2419za == null) {
                serviceConnectionC2419za = new ServiceConnectionC2419za(this, aVar);
                serviceConnectionC2419za.m10410e(serviceConnection, serviceConnection, str);
                serviceConnectionC2419za.m10413h(str);
                this.f7911c.put(aVar, serviceConnectionC2419za);
            } else {
                this.f7913e.removeMessages(0, aVar);
                if (serviceConnectionC2419za.m10412g(serviceConnection)) {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                serviceConnectionC2419za.m10410e(serviceConnection, serviceConnection, str);
                int m10408c = serviceConnectionC2419za.m10408c();
                if (m10408c == 1) {
                    serviceConnection.onServiceConnected(serviceConnectionC2419za.m10407b(), serviceConnectionC2419za.m10406a());
                } else if (m10408c == 2) {
                    serviceConnectionC2419za.m10413h(str);
                }
            }
            m10409d = serviceConnectionC2419za.m10409d();
        }
        return m10409d;
    }

    @Override // com.sonelli.AbstractC2207w9
    /* renamed from: d */
    public final void mo9453d(AbstractC2207w9.a aVar, ServiceConnection serviceConnection, String str) {
        C0813ca.m2730l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7911c) {
            ServiceConnectionC2419za serviceConnectionC2419za = this.f7911c.get(aVar);
            if (serviceConnectionC2419za == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!serviceConnectionC2419za.m10412g(serviceConnection)) {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            serviceConnectionC2419za.m10411f(serviceConnection, str);
            if (serviceConnectionC2419za.m10415j()) {
                this.f7913e.sendMessageDelayed(this.f7913e.obtainMessage(0, aVar), this.f7915g);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f7911c) {
                AbstractC2207w9.a aVar = (AbstractC2207w9.a) message.obj;
                ServiceConnectionC2419za serviceConnectionC2419za = this.f7911c.get(aVar);
                if (serviceConnectionC2419za != null && serviceConnectionC2419za.m10415j()) {
                    if (serviceConnectionC2419za.m10409d()) {
                        serviceConnectionC2419za.m10414i("GmsClientSupervisor");
                    }
                    this.f7911c.remove(aVar);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f7911c) {
            AbstractC2207w9.a aVar2 = (AbstractC2207w9.a) message.obj;
            ServiceConnectionC2419za serviceConnectionC2419za2 = this.f7911c.get(aVar2);
            if (serviceConnectionC2419za2 != null && serviceConnectionC2419za2.m10408c() == 3) {
                String valueOf = String.valueOf(aVar2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(valueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName m10407b = serviceConnectionC2419za2.m10407b();
                if (m10407b == null) {
                    m10407b = aVar2.m9454a();
                }
                if (m10407b == null) {
                    m10407b = new ComponentName(aVar2.m9455b(), EnvironmentCompat.MEDIA_UNKNOWN);
                }
                serviceConnectionC2419za2.onServiceDisconnected(m10407b);
            }
        }
        return true;
    }
}

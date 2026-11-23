package com.sonelli;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.v6 */
/* loaded from: classes.dex */
public class ServiceConnectionC2154v6 implements ServiceConnection {

    /* renamed from: a */
    public boolean f7408a = false;

    /* renamed from: b */
    public final BlockingQueue<IBinder> f7409b = new LinkedBlockingQueue();

    /* renamed from: a */
    public IBinder m9171a(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        C0813ca.m2728j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f7408a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f7408a = true;
        IBinder poll = this.f7409b.poll(j, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7409b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}

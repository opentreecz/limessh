package com.sonelli.juicessh.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.sonelli.uj0;

/* loaded from: classes.dex */
public class ConnectionPluginService extends Service {
    public ConnectionPluginService() {
        new Handler();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new uj0(getApplicationContext());
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

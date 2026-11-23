package cz.opentree;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.Hashtable;

/* compiled from: SessionDebugLogger.java */
/* loaded from: classes.dex */
public class hj0 {

    /* renamed from: a */
    public LocalBroadcastManager f3165a;

    static {
        new Hashtable();
    }

    public hj0(Context context) {
        this.f3165a = LocalBroadcastManager.getInstance(context);
    }

    /* renamed from: a */
    public void m4458a(int i, String str) {
        if (str.equals("Caught an exception, leaving main loop due to Socket closed") || str.contains("MOSH CONNECT")) {
            return;
        }
        if (str.contains("mathces")) {
            str = str.replace("mathces", "matches");
        }
        gj0.m4144e("SessionLogger", str);
        Intent intent = new Intent("cz.opentree.juicessh.logs.ssh");
        intent.putExtra("tag", "SessionLogger");
        intent.putExtra("level", i);
        intent.putExtra("message", str);
        this.f3165a.sendBroadcast(intent);
    }
}

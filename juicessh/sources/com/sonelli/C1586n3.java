package com.sonelli;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* compiled from: GCMBroadcastReceiver.java */
/* renamed from: com.sonelli.n3 */
/* loaded from: classes.dex */
public class C1586n3 extends BroadcastReceiver {

    /* renamed from: a */
    public static boolean f5213a = false;

    /* renamed from: a */
    public static final String m6636a(Context context) {
        return context.getPackageName() + ".GCMIntentService";
    }

    /* renamed from: b */
    public String mo5609b(Context context) {
        return m6636a(context);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Log.v("GCMBroadcastReceiver", "onReceive: " + intent.getAction());
        if (!f5213a) {
            f5213a = true;
            String name = getClass().getName();
            if (!name.equals(C1586n3.class.getName())) {
                C1631o3.m6859r(name);
            }
        }
        String mo5609b = mo5609b(context);
        Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + mo5609b);
        AbstractIntentServiceC1535m3.m6347j(context, intent, mo5609b);
        setResult(-1, null, null);
    }
}

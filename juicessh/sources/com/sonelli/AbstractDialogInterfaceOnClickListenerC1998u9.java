package com.sonelli;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.u9 */
/* loaded from: classes.dex */
public abstract class AbstractDialogInterfaceOnClickListenerC1998u9 implements DialogInterface.OnClickListener {
    /* renamed from: a */
    public static AbstractDialogInterfaceOnClickListenerC1998u9 m8862a(Activity activity, Intent intent, int i) {
        return new C1440ka(intent, activity, i);
    }

    /* renamed from: b */
    public abstract void mo5851b();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo5851b();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}

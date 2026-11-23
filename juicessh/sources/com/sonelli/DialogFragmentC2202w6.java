package com.sonelli;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.w6 */
/* loaded from: classes.dex */
public class DialogFragmentC2202w6 extends DialogFragment {

    /* renamed from: O */
    public Dialog f7621O = null;

    /* renamed from: P */
    public DialogInterface.OnCancelListener f7622P = null;

    /* renamed from: a */
    public static DialogFragmentC2202w6 m9410a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC2202w6 dialogFragmentC2202w6 = new DialogFragmentC2202w6();
        C0813ca.m2730l(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dialogFragmentC2202w6.f7621O = dialog2;
        if (onCancelListener != null) {
            dialogFragmentC2202w6.f7622P = onCancelListener;
        }
        return dialogFragmentC2202w6;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f7622P;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f7621O == null) {
            setShowsDialog(false);
        }
        return this.f7621O;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}

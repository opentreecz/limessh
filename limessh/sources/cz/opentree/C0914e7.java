package cz.opentree;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.e7 */
/* loaded from: classes.dex */
public class C0914e7 extends DialogFragment {

    /* renamed from: O */
    public Dialog f2341O = null;

    /* renamed from: P */
    public DialogInterface.OnCancelListener f2342P = null;

    /* renamed from: e */
    public static C0914e7 m3454e(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C0914e7 c0914e7 = new C0914e7();
        C0813ca.m2730l(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0914e7.f2341O = dialog2;
        if (onCancelListener != null) {
            c0914e7.f2342P = onCancelListener;
        }
        return c0914e7;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2342P;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2341O == null) {
            setShowsDialog(false);
        }
        return this.f2341O;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}

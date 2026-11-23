package cz.opentree.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import cz.opentree.limessh.R;
import cz.opentree.vk0;

/* loaded from: classes.dex */
public class RetryPrompt extends vk0 {

    /* renamed from: S */
    public RetryPromptListener f7249S;

    /* renamed from: T */
    public AlertDialog f7250T;

    /* renamed from: U */
    public Context f7251U;

    /* loaded from: classes.dex */
    public interface RetryPromptListener {
        /* renamed from: a */
        void mo2520a();

        void onCancel();
    }

    /* renamed from: cz.opentree.util.RetryPrompt$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2114a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2114a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            RetryPromptListener retryPromptListener = RetryPrompt.this.f7249S;
            if (retryPromptListener != null) {
                retryPromptListener.mo2520a();
            }
        }
    }

    /* renamed from: cz.opentree.util.RetryPrompt$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2115b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2115b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            RetryPromptListener retryPromptListener = RetryPrompt.this.f7249S;
            if (retryPromptListener != null) {
                retryPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.RetryPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2116c implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2116c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            RetryPromptListener retryPromptListener = RetryPrompt.this.f7249S;
            if (retryPromptListener != null) {
                retryPromptListener.onCancel();
            }
        }
    }

    public RetryPrompt(Context context, RetryPromptListener retryPromptListener) {
        super(context);
        this.f7249S = retryPromptListener;
        this.f7251U = context;
        m9297j(context.getString(R.string.connection_failed));
        m9295h(context.getString(R.string.do_you_want_to_retry));
        setCancelable(true);
        setPositiveButton(context.getString(R.string.yes), new DialogInterfaceOnClickListenerC2114a());
        setNegativeButton(context.getString(R.string.f3673no), new DialogInterfaceOnClickListenerC2115b());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2116c());
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7250T = create;
        return create;
    }

    /* renamed from: l */
    public AlertDialog m9041l() {
        if (this.f7250T == null) {
            create();
        }
        return this.f7250T;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        if (m9041l().isShowing()) {
            m9041l().dismiss();
        }
        Context context = this.f7251U;
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            try {
                m9041l().show();
            } catch (Exception unused) {
            }
        }
        return m9041l();
    }
}

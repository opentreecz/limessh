package cz.opentree.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.WindowManager;
import cz.opentree.limessh.R;
import cz.opentree.vk0;

/* loaded from: classes.dex */
public class BackgroundPrompt extends vk0 {

    /* renamed from: S */
    public BackgroundPromptListener f7148S;

    /* renamed from: T */
    public AlertDialog f7149T;

    /* loaded from: classes.dex */
    public interface BackgroundPromptListener {
        /* renamed from: a */
        void mo5339a();

        /* renamed from: b */
        void mo5340b();
    }

    /* renamed from: cz.opentree.util.BackgroundPrompt$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2076a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2076a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            BackgroundPromptListener backgroundPromptListener = BackgroundPrompt.this.f7148S;
            if (backgroundPromptListener != null) {
                backgroundPromptListener.mo5340b();
            }
        }
    }

    /* renamed from: cz.opentree.util.BackgroundPrompt$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2077b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2077b(BackgroundPrompt backgroundPrompt) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: cz.opentree.util.BackgroundPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2078c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2078c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            BackgroundPromptListener backgroundPromptListener = BackgroundPrompt.this.f7148S;
            if (backgroundPromptListener != null) {
                backgroundPromptListener.mo5339a();
            }
        }
    }

    public BackgroundPrompt(Context context, BackgroundPromptListener backgroundPromptListener) {
        super(context);
        this.f7148S = backgroundPromptListener;
        String str = context.getString(R.string.background_session) + "\n\n" + context.getString(R.string.background_session_battery_warning);
        setCancelable(false);
        m9297j(context.getString(R.string.app_name));
        m9295h(str);
        setCancelable(true);
        setPositiveButton(context.getString(R.string.yes), new DialogInterfaceOnClickListenerC2076a());
        DialogInterfaceOnClickListenerC2077b dialogInterfaceOnClickListenerC2077b = new DialogInterfaceOnClickListenerC2077b(this);
        DialogInterfaceOnClickListenerC2078c dialogInterfaceOnClickListenerC2078c = new DialogInterfaceOnClickListenerC2078c();
        if (Build.VERSION.SDK_INT >= 21) {
            setNeutralButton(context.getString(R.string.cancel), dialogInterfaceOnClickListenerC2077b);
            setNegativeButton(context.getString(R.string.f3673no), dialogInterfaceOnClickListenerC2078c);
        } else {
            setNeutralButton(context.getString(R.string.f3673no), dialogInterfaceOnClickListenerC2078c);
            setNegativeButton(context.getString(R.string.cancel), dialogInterfaceOnClickListenerC2077b);
        }
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7149T = create;
        return create;
    }

    /* renamed from: l */
    public AlertDialog m8995l() {
        if (this.f7149T == null) {
            create();
        }
        return this.f7149T;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        try {
            m8995l().dismiss();
            if (m9291a() != null && !m9291a().isFinishing()) {
                m8995l().show();
            }
        } catch (WindowManager.BadTokenException unused) {
        }
        return m8995l();
    }
}

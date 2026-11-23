package cz.opentree.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.vk0;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class EmailPrompt extends vk0 {

    /* renamed from: S */
    public LinearLayout f7157S;

    /* renamed from: T */
    public EmailPromptListener f7158T;

    /* renamed from: U */
    public AlertDialog f7159U;

    /* renamed from: V */
    public Context f7160V;

    /* renamed from: W */
    public boolean f7161W;

    /* loaded from: classes.dex */
    public interface EmailPromptListener {
        /* renamed from: e */
        void mo5298e(String str);

        void onCancel();
    }

    /* renamed from: cz.opentree.util.EmailPrompt$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2080a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2080a(EmailPrompt emailPrompt) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: cz.opentree.util.EmailPrompt$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2081b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2081b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            EmailPromptListener emailPromptListener = EmailPrompt.this.f7158T;
            if (emailPromptListener != null) {
                emailPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.EmailPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2082c implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2082c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            EmailPromptListener emailPromptListener = EmailPrompt.this.f7158T;
            if (emailPromptListener != null) {
                emailPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.EmailPrompt$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2083d implements DialogInterface.OnShowListener {

        /* renamed from: cz.opentree.util.EmailPrompt$d$a */
        /* loaded from: classes.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ((InputMethodManager) EmailPrompt.this.f7159U.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            }
        }

        /* renamed from: cz.opentree.util.EmailPrompt$d$b */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {

            /* renamed from: O */
            public final /* synthetic */ EditText f7166O;

            public b(EditText editText) {
                this.f7166O = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmailPrompt emailPrompt = EmailPrompt.this;
                if (emailPrompt.f7158T == null) {
                    gj0.m4142c("CustomAlertBuilder", "Dialog without listener");
                    return;
                }
                if (!emailPrompt.f7161W) {
                    EmailPrompt.this.f7159U.dismiss();
                    EmailPrompt.this.f7158T.mo5298e(this.f7166O.getText().toString());
                } else if (!EmailPrompt.m9002p(this.f7166O.getText().toString())) {
                    Toast.makeText(EmailPrompt.this.f7160V, EmailPrompt.this.f7160V.getResources().getString(R.string.invalid_email_address), 0).show();
                } else {
                    EmailPrompt.this.f7159U.dismiss();
                    EmailPrompt.this.f7158T.mo5298e(this.f7166O.getText().toString());
                }
            }
        }

        public DialogInterfaceOnShowListenerC2083d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            EditText editText = (EditText) EmailPrompt.this.f7159U.findViewById(R.id.email);
            editText.setOnFocusChangeListener(new a());
            editText.clearFocus();
            editText.requestFocus();
            EmailPrompt.this.f7159U.getButton(-1).setOnClickListener(new b(editText));
        }
    }

    public EmailPrompt(Context context, EmailPromptListener emailPromptListener) {
        super(context);
        this.f7161W = false;
        this.f7160V = context;
        this.f7158T = emailPromptListener;
        this.f7157S = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.email_prompt, (ViewGroup) null, false);
        setCancelable(true);
        m9296i(R.string.invite_user);
        m9294g(R.string.enter_users_email_address_to_invite);
        m9298k(this.f7157S);
        setPositiveButton(context.getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2080a(this));
        setNegativeButton(context.getString(R.string.cancel), new DialogInterfaceOnClickListenerC2081b());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2082c());
    }

    /* renamed from: p */
    public static boolean m9002p(String str) {
        return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", 2).matcher(str).matches();
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7159U = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2083d());
        return this.f7159U;
    }

    /* renamed from: n */
    public AlertDialog m9003n() {
        if (this.f7159U == null) {
            create();
        }
        return this.f7159U;
    }

    /* renamed from: o */
    public void m9004o(boolean z) {
        this.f7161W = z;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        m9003n().dismiss();
        if (m9291a() != null && !m9291a().isFinishing()) {
            m9003n().show();
        }
        return m9003n();
    }
}

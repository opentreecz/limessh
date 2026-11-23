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
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.vk0;

/* loaded from: classes.dex */
public class TextPrompt extends vk0 {

    /* renamed from: S */
    public LinearLayout f7294S;

    /* renamed from: T */
    public EditText f7295T;

    /* renamed from: U */
    public TextPromptListener f7296U;

    /* renamed from: V */
    public AlertDialog f7297V;

    /* loaded from: classes.dex */
    public interface TextPromptListener {
        /* renamed from: e */
        void mo8901e(String str);

        void onCancel();
    }

    /* renamed from: cz.opentree.util.TextPrompt$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2131a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2131a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            TextPrompt textPrompt = TextPrompt.this;
            TextPromptListener textPromptListener = textPrompt.f7296U;
            if (textPromptListener != null) {
                textPromptListener.mo8901e(textPrompt.f7295T.getText().toString());
            }
        }
    }

    /* renamed from: cz.opentree.util.TextPrompt$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2132b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2132b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            TextPromptListener textPromptListener = TextPrompt.this.f7296U;
            if (textPromptListener != null) {
                textPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.TextPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2133c implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2133c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            TextPromptListener textPromptListener = TextPrompt.this.f7296U;
            if (textPromptListener != null) {
                textPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.TextPrompt$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2134d implements DialogInterface.OnShowListener {

        /* renamed from: cz.opentree.util.TextPrompt$d$a */
        /* loaded from: classes.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ((InputMethodManager) TextPrompt.this.f7297V.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            }
        }

        public DialogInterfaceOnShowListenerC2134d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            EditText editText = (EditText) TextPrompt.this.f7297V.findViewById(R.id.text1);
            editText.setOnFocusChangeListener(new a());
            editText.clearFocus();
            editText.requestFocus();
        }
    }

    public TextPrompt(Context context, TextPromptListener textPromptListener) {
        super(context);
        this.f7296U = textPromptListener;
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.text_prompt, (ViewGroup) null, false);
        this.f7294S = linearLayout;
        this.f7295T = (EditText) linearLayout.findViewById(R.id.text1);
        setCancelable(true);
        m9298k(this.f7294S);
        setPositiveButton(context.getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2131a());
        setNegativeButton(context.getString(R.string.cancel), new DialogInterfaceOnClickListenerC2132b());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2133c());
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7297V = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2134d());
        return this.f7297V;
    }

    /* renamed from: l */
    public AlertDialog m9071l() {
        if (this.f7297V == null) {
            create();
        }
        return this.f7297V;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        gj0.m4141b("CustomAlertBuilder", "Showing TextPrompt dialog on activity: " + m9291a().getClass().getName() + "...");
        m9071l().dismiss();
        if (m9291a() == null || m9291a().isFinishing()) {
            gj0.m4142c("CustomAlertBuilder", "Attempted to show TextPrompt but activity had already finished");
        } else {
            m9071l().show();
        }
        return m9071l();
    }
}

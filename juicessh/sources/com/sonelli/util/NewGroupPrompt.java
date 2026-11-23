package com.sonelli.util;

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
import com.sonelli.gj0;
import com.sonelli.juicessh.R;
import com.sonelli.vk0;

/* loaded from: classes.dex */
public class NewGroupPrompt extends vk0 {

    /* renamed from: S */
    public LinearLayout f7177S;

    /* renamed from: T */
    public PromptListener f7178T;

    /* renamed from: U */
    public AlertDialog f7179U;

    /* renamed from: V */
    public Context f7180V;

    /* renamed from: W */
    public boolean f7181W;

    /* loaded from: classes.dex */
    public interface PromptListener {
        /* renamed from: e */
        void mo5209e(String str);

        void onCancel();
    }

    /* renamed from: com.sonelli.util.NewGroupPrompt$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2089a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2089a(NewGroupPrompt newGroupPrompt) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.sonelli.util.NewGroupPrompt$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2090b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2090b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            PromptListener promptListener = NewGroupPrompt.this.f7178T;
            if (promptListener != null) {
                promptListener.onCancel();
            }
        }
    }

    /* renamed from: com.sonelli.util.NewGroupPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2091c implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2091c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            PromptListener promptListener = NewGroupPrompt.this.f7178T;
            if (promptListener != null) {
                promptListener.onCancel();
            }
        }
    }

    /* renamed from: com.sonelli.util.NewGroupPrompt$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2092d implements DialogInterface.OnShowListener {

        /* renamed from: com.sonelli.util.NewGroupPrompt$d$a */
        /* loaded from: classes.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ((InputMethodManager) NewGroupPrompt.this.f7179U.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            }
        }

        /* renamed from: com.sonelli.util.NewGroupPrompt$d$b */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {

            /* renamed from: O */
            public final /* synthetic */ EditText f7186O;

            public b(EditText editText) {
                this.f7186O = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewGroupPrompt newGroupPrompt = NewGroupPrompt.this;
                if (newGroupPrompt.f7178T == null) {
                    gj0.m4142c("CustomAlertBuilder", "Dialog without listener");
                    return;
                }
                if (!newGroupPrompt.f7181W) {
                    NewGroupPrompt.this.f7179U.dismiss();
                    NewGroupPrompt.this.f7178T.mo5209e(this.f7186O.getText().toString());
                } else if (!NewGroupPrompt.m9009p(this.f7186O.getText().toString())) {
                    Toast.makeText(NewGroupPrompt.this.f7180V, NewGroupPrompt.this.f7180V.getResources().getString(R.string.invalid_group_name), 0).show();
                } else {
                    NewGroupPrompt.this.f7179U.dismiss();
                    NewGroupPrompt.this.f7178T.mo5209e(this.f7186O.getText().toString());
                }
            }
        }

        public DialogInterfaceOnShowListenerC2092d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            EditText editText = (EditText) NewGroupPrompt.this.f7179U.findViewById(R.id.text1);
            editText.setOnFocusChangeListener(new a());
            editText.clearFocus();
            editText.requestFocus();
            NewGroupPrompt.this.f7179U.getButton(-1).setOnClickListener(new b(editText));
        }
    }

    public NewGroupPrompt(Context context, PromptListener promptListener) {
        super(context);
        this.f7181W = false;
        this.f7180V = context;
        this.f7178T = promptListener;
        this.f7177S = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.new_group_prompt, (ViewGroup) null, false);
        setCancelable(true);
        m9296i(R.string.new_group);
        m9294g(R.string.please_enter_a_name_for_this_group);
        m9298k(this.f7177S);
        setPositiveButton(context.getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2089a(this));
        setNegativeButton(context.getString(R.string.cancel), new DialogInterfaceOnClickListenerC2090b());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2091c());
    }

    /* renamed from: p */
    public static boolean m9009p(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7179U = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2092d());
        return this.f7179U;
    }

    /* renamed from: n */
    public AlertDialog m9010n() {
        if (this.f7179U == null) {
            create();
        }
        return this.f7179U;
    }

    /* renamed from: o */
    public void m9011o(boolean z) {
        this.f7181W = z;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        m9010n().dismiss();
        if (m9291a() != null && !m9291a().isFinishing()) {
            m9010n().show();
        }
        return m9010n();
    }
}

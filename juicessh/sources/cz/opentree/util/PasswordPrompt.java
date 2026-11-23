package cz.opentree.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.controllers.PinManager;
import cz.opentree.vk0;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;

/* loaded from: classes.dex */
public class PasswordPrompt extends vk0 implements PinManager.PinPromptDialog {

    /* renamed from: S */
    public LinearLayout f7188S;

    /* renamed from: T */
    public EditText f7189T;

    /* renamed from: U */
    public CheckBox f7190U;

    /* renamed from: V */
    public LinearLayout f7191V;

    /* renamed from: W */
    public final CheckBox f7192W;

    /* renamed from: X */
    public LinearLayout f7193X;

    /* renamed from: Y */
    public PasswordPromptListener f7194Y;

    /* renamed from: Z */
    public AlertDialog f7195Z;

    /* renamed from: a0 */
    public boolean f7196a0;

    /* renamed from: b0 */
    public boolean f7197b0;

    /* loaded from: classes.dex */
    public interface PasswordPromptListener {
        /* renamed from: a */
        void mo5299a(String str, boolean z);

        void onCancel();
    }

    /* renamed from: cz.opentree.util.PasswordPrompt$a */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2093a implements View.OnClickListener {
        public ViewOnClickListenerC2093a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PasswordPrompt.this.f7190U.isChecked()) {
                PasswordPrompt.this.f7190U.setChecked(false);
            } else {
                PasswordPrompt.this.f7190U.setChecked(true);
            }
        }
    }

    /* renamed from: cz.opentree.util.PasswordPrompt$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2094b implements View.OnClickListener {
        public ViewOnClickListenerC2094b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PasswordPrompt.this.f7192W.isChecked()) {
                PasswordPrompt.this.f7192W.setChecked(false);
                PasswordPrompt.this.f7189T.setInputType(KeycodeConstants.KEYCODE_MEDIA_EJECT);
            } else {
                PasswordPrompt.this.f7192W.setChecked(true);
                PasswordPrompt.this.f7189T.setInputType(KeycodeConstants.KEYCODE_NUMPAD_1);
            }
        }
    }

    /* renamed from: cz.opentree.util.PasswordPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2095c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2095c(PasswordPrompt passwordPrompt) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: cz.opentree.util.PasswordPrompt$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2096d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2096d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            PasswordPromptListener passwordPromptListener = PasswordPrompt.this.f7194Y;
            if (passwordPromptListener != null) {
                passwordPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.PasswordPrompt$e */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2097e implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2097e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            PasswordPromptListener passwordPromptListener = PasswordPrompt.this.f7194Y;
            if (passwordPromptListener != null) {
                passwordPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.PasswordPrompt$f */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2098f implements DialogInterface.OnShowListener {

        /* renamed from: cz.opentree.util.PasswordPrompt$f$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = PasswordPrompt.this.f7189T.getText().toString();
                if (!PasswordPrompt.this.f7197b0) {
                    PasswordPrompt.this.f7195Z.dismiss();
                    PasswordPrompt passwordPrompt = PasswordPrompt.this;
                    PasswordPromptListener passwordPromptListener = passwordPrompt.f7194Y;
                    if (passwordPromptListener != null) {
                        passwordPromptListener.mo5299a(passwordPrompt.f7189T.getText().toString(), PasswordPrompt.this.f7190U.isChecked());
                        return;
                    }
                    return;
                }
                String m9016t = PasswordPrompt.m9016t(obj, view.getContext());
                if (m9016t != null) {
                    Toast.makeText(view.getContext(), m9016t, 0).show();
                    return;
                }
                PasswordPrompt.this.f7195Z.dismiss();
                PasswordPrompt passwordPrompt2 = PasswordPrompt.this;
                PasswordPromptListener passwordPromptListener2 = passwordPrompt2.f7194Y;
                if (passwordPromptListener2 != null) {
                    passwordPromptListener2.mo5299a(passwordPrompt2.f7189T.getText().toString(), PasswordPrompt.this.f7190U.isChecked());
                }
            }
        }

        /* renamed from: cz.opentree.util.PasswordPrompt$f$b */
        /* loaded from: classes.dex */
        public class b implements View.OnKeyListener {

            /* renamed from: O */
            public final /* synthetic */ Button f7204O;

            public b(DialogInterfaceOnShowListenerC2098f dialogInterfaceOnShowListenerC2098f, Button button) {
                this.f7204O = button;
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0) {
                    return false;
                }
                this.f7204O.performClick();
                return true;
            }
        }

        /* renamed from: cz.opentree.util.PasswordPrompt$f$c */
        /* loaded from: classes.dex */
        public class c implements View.OnFocusChangeListener {
            public c() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ((InputMethodManager) PasswordPrompt.this.f7195Z.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            }
        }

        public DialogInterfaceOnShowListenerC2098f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button button = PasswordPrompt.this.f7195Z.getButton(-1);
            button.setOnClickListener(new a());
            EditText editText = (EditText) PasswordPrompt.this.f7195Z.findViewById(R.id.password);
            editText.setOnKeyListener(new b(this, button));
            editText.setOnFocusChangeListener(new c());
            editText.clearFocus();
            editText.requestFocus();
        }
    }

    public PasswordPrompt(Context context, PasswordPromptListener passwordPromptListener) {
        super(context);
        this.f7196a0 = true;
        this.f7197b0 = false;
        this.f7194Y = passwordPromptListener;
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.password_prompt, (ViewGroup) null, false);
        this.f7188S = linearLayout;
        this.f7189T = (EditText) linearLayout.findViewById(R.id.password);
        LinearLayout linearLayout2 = (LinearLayout) this.f7188S.findViewById(R.id.rememberPasswordLayout);
        this.f7191V = linearLayout2;
        this.f7190U = (CheckBox) linearLayout2.findViewById(R.id.rememberPassword);
        LinearLayout linearLayout3 = (LinearLayout) this.f7188S.findViewById(R.id.showPasswordLayout);
        this.f7193X = linearLayout3;
        this.f7192W = (CheckBox) linearLayout3.findViewById(R.id.showPassword);
        this.f7191V.setOnClickListener(new ViewOnClickListenerC2093a());
        this.f7193X.setOnClickListener(new ViewOnClickListenerC2094b());
        if (!this.f7196a0) {
            this.f7191V.setVisibility(8);
        }
        m9298k(this.f7188S);
        setCancelable(true);
        m9297j(context.getString(R.string.authentication_failure));
        m9295h(context.getString(R.string.enter_password));
        setCancelable(false);
        setPositiveButton(context.getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2095c(this));
        setNegativeButton(context.getString(R.string.cancel), new DialogInterfaceOnClickListenerC2096d());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2097e());
    }

    /* renamed from: t */
    public static String m9016t(String str, Context context) {
        if (str.length() < 6) {
            return String.format(context.getString(R.string.password_must_be_over_x_chars), 6);
        }
        return null;
    }

    @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptDialog
    /* renamed from: b */
    public PinManager.PinPromptDialog mo2824b(FragmentActivity fragmentActivity) {
        show();
        return this;
    }

    @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptDialog
    /* renamed from: c */
    public void mo2825c(PinManager.PinPromptSimpleListener pinPromptSimpleListener) {
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7195Z = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2098f());
        return this.f7195Z;
    }

    @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptDialog
    /* renamed from: d */
    public void mo2826d(PinManager.PinPromptListener pinPromptListener) {
    }

    @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptDialog
    public void dismiss() {
        if (isShowing()) {
            m9017p().dismiss();
        }
    }

    @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptDialog
    public boolean isShowing() {
        return m9017p() != null && m9017p().isShowing();
    }

    /* renamed from: p */
    public AlertDialog m9017p() {
        if (this.f7195Z == null) {
            create();
        }
        return this.f7195Z;
    }

    /* renamed from: q */
    public void m9018q() {
        this.f7196a0 = false;
        LinearLayout linearLayout = this.f7191V;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: r */
    public void m9019r(PasswordPromptListener passwordPromptListener) {
        this.f7194Y = passwordPromptListener;
    }

    /* renamed from: s */
    public void m9020s(boolean z) {
        this.f7197b0 = z;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        m9017p().dismiss();
        if (m9291a() != null && !m9291a().isFinishing()) {
            try {
                m9017p().show();
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        return m9017p();
    }
}

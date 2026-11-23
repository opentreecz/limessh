package cz.opentree;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.limessh.R;
import cz.opentree.limessh.controllers.PinManager;
import cz.opentree.limessh.models.User;
import cz.opentree.limessh.views.FontAwesomeTextView;

/* compiled from: NumericPinFragment.java */
/* loaded from: classes.dex */
public class cj0 extends DialogFragment implements PinManager.PinPromptDialog {

    /* renamed from: P */
    public PinManager.PinPromptListener f1955P;

    /* renamed from: Q */
    public TextView f1956Q;

    /* renamed from: R */
    public String f1957R;

    /* renamed from: T */
    public PinManager.PinPromptSimpleListener f1959T;

    /* renamed from: O */
    public int f1954O = 0;

    /* renamed from: S */
    public boolean f1958S = false;

    /* compiled from: NumericPinFragment.java */
    /* renamed from: cz.opentree.cj0$a */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0827a implements View.OnClickListener {
        public ViewOnClickListenerC0827a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            cj0.this.f1956Q.setText("");
        }
    }

    /* compiled from: NumericPinFragment.java */
    /* renamed from: cz.opentree.cj0$b */
    /* loaded from: classes.dex */
    public class ViewOnKeyListenerC0828b implements View.OnKeyListener {
        public ViewOnKeyListenerC0828b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (cj0.this.f1956Q.getText().length() <= 0) {
                return false;
            }
            cj0.this.f1956Q.setText("");
            return true;
        }
    }

    /* compiled from: NumericPinFragment.java */
    /* renamed from: cz.opentree.cj0$c */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0829c implements View.OnClickListener {
        public ViewOnClickListenerC0829c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (cj0.this.f1955P != null) {
                cj0 cj0Var = cj0.this;
                if (cj0Var.f1954O != 0) {
                    try {
                        User.m5522E(cj0Var.getActivity(), cj0.this.f1956Q.getText().toString());
                        cj0.this.f1956Q.setText("");
                        cj0.this.dismiss();
                        cj0.this.f1955P.mo5374d();
                        return;
                    } catch (NumberFormatException unused) {
                        cj0.this.f1956Q.setText("");
                        cj0.this.f1955P.mo5375e();
                        return;
                    }
                }
                if (cj0Var.f1957R == null || !cj0.this.f1956Q.getText().toString().equals(cj0.this.f1957R)) {
                    cj0.this.f1956Q.setText("");
                    cj0.this.f1955P.mo5375e();
                } else {
                    cj0.this.f1956Q.setText("");
                    cj0.this.dismiss();
                    cj0.this.f1955P.mo5374d();
                }
            }
        }
    }

    /* compiled from: NumericPinFragment.java */
    /* renamed from: cz.opentree.cj0$d */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0830d implements View.OnClickListener {
        public ViewOnClickListenerC0830d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (cj0.this.f1956Q.length() < 255) {
                cj0.this.f1956Q.append(view.getTag().toString());
            }
        }
    }

    /* renamed from: i */
    public static cj0 m2823i(boolean z, int i) {
        cj0 cj0Var = new cj0();
        Bundle bundle = new Bundle();
        bundle.putBoolean("cancelable", z);
        bundle.putInt("mode", i);
        cj0Var.setArguments(bundle);
        return cj0Var;
    }

    @Override // cz.opentree.limessh.controllers.PinManager.PinPromptDialog
    /* renamed from: b */
    public PinManager.PinPromptDialog mo2824b(FragmentActivity fragmentActivity) {
        super.show(fragmentActivity.getSupportFragmentManager(), "pin_dialog");
        return this;
    }

    @Override // cz.opentree.limessh.controllers.PinManager.PinPromptDialog
    /* renamed from: c */
    public void mo2825c(PinManager.PinPromptSimpleListener pinPromptSimpleListener) {
        this.f1959T = pinPromptSimpleListener;
    }

    @Override // cz.opentree.limessh.controllers.PinManager.PinPromptDialog
    /* renamed from: d */
    public void mo2826d(PinManager.PinPromptListener pinPromptListener) {
        this.f1955P = pinPromptListener;
    }

    @Override // cz.opentree.limessh.controllers.PinManager.PinPromptDialog
    public boolean isShowing() {
        return super.isVisible();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        PinManager.PinPromptListener pinPromptListener = this.f1955P;
        if (pinPromptListener != null) {
            pinPromptListener.onCancel();
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f1958S = arguments.getBoolean("cancelable", false);
            this.f1954O = arguments.getInt("mode", 0);
        }
        setRetainInstance(true);
        setStyle(2, R.style.Theme_JuiceSSH_Material_NoActionBar_Fullscreen);
        setCancelable(this.f1958S);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        PinManager.PinPromptSimpleListener pinPromptSimpleListener = this.f1959T;
        if (pinPromptSimpleListener != null) {
            pinPromptSimpleListener.mo5376a(this);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.numeric_pin_prompt, viewGroup, false);
        this.f1956Q = (EditText) inflate.findViewById(R.id.passphrase);
        Button button = (Button) inflate.findViewById(R.id.button_1);
        Button button2 = (Button) inflate.findViewById(R.id.button_2);
        Button button3 = (Button) inflate.findViewById(R.id.button_3);
        Button button4 = (Button) inflate.findViewById(R.id.button_4);
        Button button5 = (Button) inflate.findViewById(R.id.button_5);
        Button button6 = (Button) inflate.findViewById(R.id.button_6);
        Button button7 = (Button) inflate.findViewById(R.id.button_7);
        Button button8 = (Button) inflate.findViewById(R.id.button_8);
        Button button9 = (Button) inflate.findViewById(R.id.button_9);
        Button button10 = (Button) inflate.findViewById(R.id.button_0);
        TextView textView = (TextView) inflate.findViewById(R.id.message);
        if (this.f1954O == 1) {
            textView.setText(getString(R.string.please_set_a_pin));
        } else {
            textView.setText(getString(R.string.enter_your_pin_to_unlock));
        }
        FontAwesomeTextView fontAwesomeTextView = (FontAwesomeTextView) inflate.findViewById(R.id.button_backspace);
        FontAwesomeTextView fontAwesomeTextView2 = (FontAwesomeTextView) inflate.findViewById(R.id.button_ok);
        fontAwesomeTextView.setOnClickListener(new ViewOnClickListenerC0827a());
        inflate.setOnKeyListener(new ViewOnKeyListenerC0828b());
        fontAwesomeTextView2.setOnClickListener(new ViewOnClickListenerC0829c());
        ViewOnClickListenerC0830d viewOnClickListenerC0830d = new ViewOnClickListenerC0830d();
        button.setOnClickListener(viewOnClickListenerC0830d);
        button2.setOnClickListener(viewOnClickListenerC0830d);
        button3.setOnClickListener(viewOnClickListenerC0830d);
        button4.setOnClickListener(viewOnClickListenerC0830d);
        button5.setOnClickListener(viewOnClickListenerC0830d);
        button6.setOnClickListener(viewOnClickListenerC0830d);
        button7.setOnClickListener(viewOnClickListenerC0830d);
        button8.setOnClickListener(viewOnClickListenerC0830d);
        button9.setOnClickListener(viewOnClickListenerC0830d);
        button10.setOnClickListener(viewOnClickListenerC0830d);
        getDialog().getWindow().setSoftInputMode(2);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (User.m5528v(getActivity()) != null) {
            this.f1957R = User.m5528v(getActivity());
        }
        this.f1956Q.setText("");
    }
}

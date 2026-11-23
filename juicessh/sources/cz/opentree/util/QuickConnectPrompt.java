package cz.opentree.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import cz.opentree.gj0;
import cz.opentree.jh0;
import cz.opentree.limessh.R;
import cz.opentree.vk0;

/* loaded from: classes.dex */
public class QuickConnectPrompt extends vk0 {

    /* renamed from: S */
    public LinearLayout f7236S;

    /* renamed from: T */
    public EditText f7237T;

    /* renamed from: U */
    public Spinner f7238U;

    /* renamed from: V */
    public jh0 f7239V;

    /* renamed from: W */
    public QuickConnectPromptListener f7240W;

    /* renamed from: X */
    public CheckBox f7241X;

    /* renamed from: Y */
    public AlertDialog f7242Y;

    /* loaded from: classes.dex */
    public interface QuickConnectPromptListener {
        /* renamed from: a */
        void mo5231a(Uri uri, boolean z);

        void onCancel();
    }

    /* renamed from: cz.opentree.util.QuickConnectPrompt$a */
    /* loaded from: classes.dex */
    public class C2109a implements AdapterView.OnItemSelectedListener {
        public C2109a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int itemId = (int) QuickConnectPrompt.this.f7239V.getItemId(i);
            if (itemId == 1) {
                QuickConnectPrompt.this.f7237T.setVisibility(0);
                QuickConnectPrompt.this.f7237T.setHint("[username@]hostname[:port]");
            } else if (itemId == 2) {
                QuickConnectPrompt.this.f7237T.setText("");
                QuickConnectPrompt.this.f7237T.setVisibility(8);
            } else if (itemId != 3) {
                QuickConnectPrompt.this.f7237T.setVisibility(0);
                QuickConnectPrompt.this.f7237T.setHint("[username@]hostname[:port]");
            } else {
                QuickConnectPrompt.this.f7237T.setVisibility(0);
                QuickConnectPrompt.this.f7237T.setHint("hostname[:port]");
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: cz.opentree.util.QuickConnectPrompt$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2110b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2110b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            QuickConnectPrompt quickConnectPrompt = QuickConnectPrompt.this;
            if (quickConnectPrompt.f7240W != null) {
                int itemId = (int) quickConnectPrompt.f7239V.getItemId(quickConnectPrompt.f7238U.getSelectedItemPosition());
                Uri parse = Uri.parse((itemId != 1 ? itemId != 2 ? itemId != 3 ? "ssh://" : "telnet://" : "local://" : "mosh://") + QuickConnectPrompt.this.f7237T.getText().toString());
                QuickConnectPrompt quickConnectPrompt2 = QuickConnectPrompt.this;
                quickConnectPrompt2.f7240W.mo5231a(parse, quickConnectPrompt2.f7241X.isChecked());
            }
        }
    }

    /* renamed from: cz.opentree.util.QuickConnectPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2111c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2111c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            QuickConnectPromptListener quickConnectPromptListener = QuickConnectPrompt.this.f7240W;
            if (quickConnectPromptListener != null) {
                quickConnectPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.QuickConnectPrompt$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2112d implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2112d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            QuickConnectPromptListener quickConnectPromptListener = QuickConnectPrompt.this.f7240W;
            if (quickConnectPromptListener != null) {
                quickConnectPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.QuickConnectPrompt$e */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2113e implements DialogInterface.OnShowListener {

        /* renamed from: cz.opentree.util.QuickConnectPrompt$e$a */
        /* loaded from: classes.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ((InputMethodManager) QuickConnectPrompt.this.f7242Y.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            }
        }

        public DialogInterfaceOnShowListenerC2113e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            EditText editText = (EditText) QuickConnectPrompt.this.f7242Y.findViewById(R.id.quickConnectHost);
            editText.setOnFocusChangeListener(new a());
            editText.clearFocus();
            editText.requestFocus();
        }
    }

    public QuickConnectPrompt(Context context, QuickConnectPromptListener quickConnectPromptListener) {
        super(context);
        this.f7240W = quickConnectPromptListener;
        m9296i(R.string.quick_connect);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.quick_connect_prompt, (ViewGroup) null, false);
        this.f7236S = linearLayout;
        EditText editText = (EditText) linearLayout.findViewById(R.id.quickConnectHost);
        this.f7237T = editText;
        editText.setHint("[username@]hostname[:port]");
        this.f7238U = (Spinner) this.f7236S.findViewById(R.id.quickConnectType);
        this.f7241X = (CheckBox) this.f7236S.findViewById(R.id.saveCheckbox);
        jh0 jh0Var = new jh0(context);
        this.f7239V = jh0Var;
        this.f7238U.setAdapter((SpinnerAdapter) jh0Var);
        this.f7238U.setOnItemSelectedListener(new C2109a());
        setCancelable(true);
        m9298k(this.f7236S);
        setPositiveButton(context.getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2110b());
        setNegativeButton(context.getString(R.string.cancel), new DialogInterfaceOnClickListenerC2111c());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2112d());
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7242Y = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2113e());
        return this.f7242Y;
    }

    /* renamed from: l */
    public AlertDialog m9040l() {
        if (this.f7242Y == null) {
            create();
        }
        return this.f7242Y;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        gj0.m4141b("CustomAlertBuilder", "Showing QuickConnectPrompt dialog on activity: " + m9291a().getClass().getName() + "...");
        m9040l().dismiss();
        if (m9291a() == null || m9291a().isFinishing()) {
            gj0.m4142c("CustomAlertBuilder", "Attempted to show TextPrompt but activity had already finished");
        } else {
            m9040l().show();
        }
        return m9040l();
    }
}

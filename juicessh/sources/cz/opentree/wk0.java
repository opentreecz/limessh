package cz.opentree;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import cz.opentree.limessh.R;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/* compiled from: DontShowAgainDialog.java */
/* loaded from: classes.dex */
public class wk0 extends vk0 {

    /* renamed from: S */
    public String f7757S;

    /* renamed from: T */
    public AlertDialog f7758T;

    /* renamed from: U */
    public SharedPreferences f7759U;

    /* renamed from: V */
    public TextView f7760V;

    /* renamed from: W */
    public CheckBox f7761W;

    /* compiled from: DontShowAgainDialog.java */
    /* renamed from: cz.opentree.wk0$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2230a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2230a(wk0 wk0Var) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: DontShowAgainDialog.java */
    /* renamed from: cz.opentree.wk0$b */
    /* loaded from: classes.dex */
    public class C2231b implements CompoundButton.OnCheckedChangeListener {
        public C2231b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            wk0.this.m9578n(z);
        }
    }

    public wk0(Context context, String str, String str2) {
        super(context);
        m9297j(str);
        this.f7759U = PreferenceManager.getDefaultSharedPreferences(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.confirm_dialog, (ViewGroup) null, false);
        m9298k(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.message);
        this.f7760V = textView;
        textView.setText(str2);
        setPositiveButton(R.string.f3674ok, new DialogInterfaceOnClickListenerC2230a(this));
        this.f7761W = (CheckBox) inflate.findViewById(R.id.dont_show_again);
        try {
            this.f7757S = tg0.m8685c(str + str2);
        } catch (UnsupportedEncodingException e) {
            gj0.m4142c("DontShowAgainDialog", "Could not derive hash of dialog title/message: " + e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            gj0.m4142c("DontShowAgainDialog", "Could not derive hash of dialog title/message: " + e2.getMessage());
        }
        this.f7761W.setOnCheckedChangeListener(new C2231b());
    }

    /* renamed from: l */
    public AlertDialog m9576l() {
        if (this.f7758T == null) {
            this.f7758T = create();
        }
        return this.f7758T;
    }

    /* renamed from: m */
    public void m9577m(int i) {
        this.f7761W.setText(i);
    }

    /* renamed from: n */
    public void m9578n(boolean z) {
        if (this.f7757S != null) {
            SharedPreferences.Editor edit = this.f7759U.edit();
            edit.putBoolean("seen_message:" + this.f7757S, z);
            edit.commit();
        }
    }

    /* renamed from: o */
    public boolean m9579o() {
        if (this.f7757S == null) {
            return false;
        }
        SharedPreferences sharedPreferences = this.f7759U;
        StringBuilder sb = new StringBuilder();
        sb.append("seen_message:");
        sb.append(this.f7757S);
        return !sharedPreferences.getBoolean(sb.toString(), false);
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        if (m9579o()) {
            try {
                m9576l().dismiss();
                if (m9291a() != null && !m9291a().isFinishing()) {
                    m9576l().show();
                }
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        return m9576l();
    }
}

package cz.opentree.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.vh0;
import cz.opentree.vk0;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class IdentityPrompt extends vk0 {

    /* renamed from: S */
    public LinearLayout f7168S;

    /* renamed from: T */
    public AlertDialog f7169T;

    /* renamed from: U */
    public Spinner f7170U;

    /* renamed from: V */
    public IdentityPromptListener f7171V;

    /* loaded from: classes.dex */
    public interface IdentityPromptListener {
        /* renamed from: a */
        void mo5914a(Identity identity);

        /* renamed from: b */
        void mo5915b();

        void onCancel();
    }

    /* renamed from: cz.opentree.util.IdentityPrompt$a */
    /* loaded from: classes.dex */
    public class C2084a implements AdapterView.OnItemSelectedListener {
        public C2084a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == adapterView.getAdapter().getCount() - 1) {
                IdentityPrompt.this.f7171V.mo5915b();
                IdentityPrompt.this.f7169T.dismiss();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: cz.opentree.util.IdentityPrompt$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2085b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2085b(IdentityPrompt identityPrompt) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: cz.opentree.util.IdentityPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2086c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2086c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            IdentityPromptListener identityPromptListener = IdentityPrompt.this.f7171V;
            if (identityPromptListener != null) {
                identityPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.IdentityPrompt$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2087d implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2087d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            IdentityPromptListener identityPromptListener = IdentityPrompt.this.f7171V;
            if (identityPromptListener != null) {
                identityPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.IdentityPrompt$e */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2088e implements DialogInterface.OnShowListener {

        /* renamed from: cz.opentree.util.IdentityPrompt$e$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IdentityPrompt identityPrompt;
                IdentityPromptListener identityPromptListener;
                vh0 vh0Var = (vh0) IdentityPrompt.this.f7170U.getAdapter();
                gj0.m4141b("IdentityPrompt", String.valueOf(vh0Var.m9225b()));
                if (vh0Var.m9225b() == 0 || IdentityPrompt.this.f7170U.getSelectedItemPosition() == vh0Var.m9225b() || (identityPromptListener = (identityPrompt = IdentityPrompt.this).f7171V) == null) {
                    return;
                }
                identityPromptListener.mo5914a((Identity) identityPrompt.f7170U.getSelectedItem());
                IdentityPrompt.this.f7169T.dismiss();
            }
        }

        public DialogInterfaceOnShowListenerC2088e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IdentityPrompt.this.f7169T.getButton(-1).setOnClickListener(new a());
        }
    }

    public IdentityPrompt(Connection connection, Context context, IdentityPromptListener identityPromptListener) {
        super(context);
        this.f7171V = identityPromptListener;
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.identity_prompt, (ViewGroup) null, false);
        this.f7168S = linearLayout;
        this.f7170U = (Spinner) linearLayout.findViewById(R.id.sp_identity);
        try {
            List queryForAll = C1328DB.m5404d(Identity.class, context).queryForAll();
            Collections.sort(queryForAll);
            this.f7170U.setAdapter((SpinnerAdapter) new vh0(context, queryForAll));
            this.f7170U.setOnItemSelectedListener(new C2084a());
            setCancelable(true);
            m9296i(R.string.choose_identity);
            m9295h(String.format(context.getString(R.string.please_choose_an_identity_to_use_for), connection.m5471w()));
            m9298k(this.f7168S);
            setPositiveButton(context.getResources().getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2085b(this));
            setNegativeButton(context.getString(R.string.cancel), new DialogInterfaceOnClickListenerC2086c());
            setOnCancelListener(new DialogInterfaceOnCancelListenerC2087d());
        } catch (SQLException e) {
            e.printStackTrace();
            this.f7171V.onCancel();
            if (m9006m() == null || !m9006m().isShowing()) {
                return;
            }
            m9006m().dismiss();
        }
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7169T = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2088e());
        return this.f7169T;
    }

    /* renamed from: m */
    public AlertDialog m9006m() {
        if (this.f7169T == null) {
            create();
        }
        return this.f7169T;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        m9006m().dismiss();
        if (m9291a() != null && !m9291a().isFinishing()) {
            m9006m().show();
        }
        return m9006m();
    }
}

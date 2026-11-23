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
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.pi0;
import cz.opentree.vh0;
import cz.opentree.vk0;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TeamMemberPrompt extends vk0 {

    /* renamed from: S */
    public LinearLayout f7272S;

    /* renamed from: T */
    public AlertDialog f7273T;

    /* renamed from: U */
    public Spinner f7274U;

    /* renamed from: V */
    public Context f7275V;

    /* renamed from: W */
    public TeamMemberPromptListener f7276W;

    /* loaded from: classes.dex */
    public interface TeamMemberPromptListener {
        /* renamed from: a */
        void mo9065a(User user);

        /* renamed from: b */
        void mo9066b();

        void onCancel();
    }

    /* renamed from: cz.opentree.util.TeamMemberPrompt$a */
    /* loaded from: classes.dex */
    public class C2123a extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ Context f7277a;

        public C2123a(Context context) {
            this.f7277a = context;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            try {
                List queryForAll = C1328DB.m5404d(User.class, this.f7277a).queryForAll();
                Iterator it = queryForAll.iterator();
                while (it.hasNext()) {
                    try {
                        if (((User) it.next()).f3993id.toString().equals(user.f3993id.toString())) {
                            it.remove();
                        }
                    } catch (NullPointerException unused) {
                    }
                }
                TeamMemberPrompt.this.m9064o(queryForAll);
            } catch (SQLException unused2) {
                TeamMemberPrompt.this.f7276W.onCancel();
                TeamMemberPrompt.this.f7273T.dismiss();
            }
        }
    }

    /* renamed from: cz.opentree.util.TeamMemberPrompt$b */
    /* loaded from: classes.dex */
    public class C2124b implements AdapterView.OnItemSelectedListener {
        public C2124b() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == adapterView.getAdapter().getCount() - 1) {
                TeamMemberPrompt.this.f7276W.mo9066b();
                TeamMemberPrompt.this.f7273T.dismiss();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: cz.opentree.util.TeamMemberPrompt$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2125c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2125c(TeamMemberPrompt teamMemberPrompt) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: cz.opentree.util.TeamMemberPrompt$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2126d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2126d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            TeamMemberPromptListener teamMemberPromptListener = TeamMemberPrompt.this.f7276W;
            if (teamMemberPromptListener != null) {
                teamMemberPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.TeamMemberPrompt$e */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2127e implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2127e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            TeamMemberPromptListener teamMemberPromptListener = TeamMemberPrompt.this.f7276W;
            if (teamMemberPromptListener != null) {
                teamMemberPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.TeamMemberPrompt$f */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2128f implements DialogInterface.OnShowListener {

        /* renamed from: cz.opentree.util.TeamMemberPrompt$f$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TeamMemberPrompt teamMemberPrompt;
                TeamMemberPromptListener teamMemberPromptListener;
                vh0 vh0Var = (vh0) TeamMemberPrompt.this.f7274U.getAdapter();
                if (vh0Var.m9225b() == 0 || TeamMemberPrompt.this.f7274U.getSelectedItemPosition() == vh0Var.m9225b() || (teamMemberPromptListener = (teamMemberPrompt = TeamMemberPrompt.this).f7276W) == null) {
                    return;
                }
                teamMemberPromptListener.mo9065a((User) teamMemberPrompt.f7274U.getSelectedItem());
                TeamMemberPrompt.this.f7273T.dismiss();
            }
        }

        public DialogInterfaceOnShowListenerC2128f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            TeamMemberPrompt.this.f7273T.getButton(-1).setOnClickListener(new a());
        }
    }

    public TeamMemberPrompt(Context context, TeamMemberPromptListener teamMemberPromptListener) {
        super(context);
        this.f7275V = context;
        this.f7276W = teamMemberPromptListener;
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.team_member_prompt, (ViewGroup) null, false);
        this.f7272S = linearLayout;
        this.f7274U = (Spinner) linearLayout.findViewById(R.id.sp_team_member);
        pi0.m7331j(context, new C2123a(context));
        this.f7274U.setOnItemSelectedListener(new C2124b());
        setCancelable(true);
        m9296i(R.string.invite_user);
        m9294g(R.string.please_select_a_team_member_to_invite);
        m9298k(this.f7272S);
        setPositiveButton(context.getResources().getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2125c(this));
        setNegativeButton(context.getString(R.string.cancel), new DialogInterfaceOnClickListenerC2126d());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2127e());
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7273T = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2128f());
        return this.f7273T;
    }

    /* renamed from: n */
    public AlertDialog m9063n() {
        if (this.f7273T == null) {
            create();
        }
        return this.f7273T;
    }

    /* renamed from: o */
    public final void m9064o(List<User> list) {
        this.f7274U.setAdapter((SpinnerAdapter) new vh0(this.f7275V, list));
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        m9063n().dismiss();
        if (m9291a() != null && !m9291a().isFinishing()) {
            m9063n().show();
        }
        return m9063n();
    }
}

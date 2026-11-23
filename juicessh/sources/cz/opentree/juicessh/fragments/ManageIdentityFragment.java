package cz.opentree.juicessh.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.PurchaseActivity;
import cz.opentree.juicessh.connections.transports.ConnectionProvider;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.models.Snippet;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.qg0;
import cz.opentree.ug0;
import cz.opentree.util.PasswordPrompt;
import cz.opentree.util.PrivateKeyPrompt;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class ManageIdentityFragment extends DialogFragment {

    /* renamed from: O */
    public RelativeLayout f4049O;

    /* renamed from: P */
    public EditText f4050P;

    /* renamed from: Q */
    public EditText f4051Q;

    /* renamed from: R */
    public TextView f4052R;

    /* renamed from: S */
    public TextView f4053S;

    /* renamed from: T */
    public Button f4054T;

    /* renamed from: U */
    public Button f4055U;

    /* renamed from: V */
    public Button f4056V;

    /* renamed from: W */
    public boolean f4057W = false;

    /* renamed from: X */
    public boolean f4058X = true;

    /* renamed from: Y */
    public Identity f4059Y = new Identity();

    /* renamed from: Z */
    public ConnectionProvider f4060Z;

    /* renamed from: a0 */
    public OnIdentityDialogCompleteListener f4061a0;

    /* renamed from: b0 */
    public PrivateKeyPrompt f4062b0;

    /* loaded from: classes.dex */
    public interface OnIdentityDialogCompleteListener {
        /* renamed from: a */
        void mo5288a(Identity identity);

        void onCancel();
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$a */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1340a implements View.OnClickListener {
        public ViewOnClickListenerC1340a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ManageIdentityFragment.this.m5441p();
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1341b implements View.OnClickListener {
        public ViewOnClickListenerC1341b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ManageIdentityFragment manageIdentityFragment = ManageIdentityFragment.this;
            manageIdentityFragment.onCancel(manageIdentityFragment.getDialog());
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$c */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1342c implements View.OnClickListener {

        /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$c$a */
        /* loaded from: classes.dex */
        public class a extends pi0.AbstractC1720p {
            public a() {
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: a */
            public void mo3228a(String str) {
                super.mo3228a(str);
                ManageIdentityFragment.this.startActivity(new Intent(ManageIdentityFragment.this.getActivity(), (Class<?>) PurchaseActivity.class));
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: b */
            public void mo3229b(User user) {
                super.mo3229b(user);
                if (oi0.m7047d(user)) {
                    ManageIdentityFragment.this.m5440o();
                } else {
                    ManageIdentityFragment.this.startActivity(new Intent(ManageIdentityFragment.this.getActivity(), (Class<?>) PurchaseActivity.class));
                }
            }
        }

        public ViewOnClickListenerC1342c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pi0.m7331j(ManageIdentityFragment.this.getActivity(), new a());
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$d */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1343d implements View.OnClickListener {
        public ViewOnClickListenerC1343d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ManageIdentityFragment.this.m5446u(view);
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$e */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1344e implements View.OnClickListener {
        public ViewOnClickListenerC1344e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ManageIdentityFragment.this.m5445t(view);
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$f */
    /* loaded from: classes.dex */
    public class C1345f implements PasswordPrompt.PasswordPromptListener {
        public C1345f() {
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        /* renamed from: a */
        public void mo5299a(String str, boolean z) {
            ManageIdentityFragment.this.f4059Y.password = qg0.m7702c(str, User.m5527u(ManageIdentityFragment.this.getActivity()));
            if (str.isEmpty()) {
                ManageIdentityFragment.this.f4059Y.passUpdated = 0L;
                ManageIdentityFragment.this.f4052R.setText(ManageIdentityFragment.this.getResources().getString(R.string.not_set));
                ManageIdentityFragment.this.f4055U.setText(R.string.set_optional);
                return;
            }
            ManageIdentityFragment.this.f4059Y.passUpdated = System.currentTimeMillis();
            ManageIdentityFragment.this.f4052R.setText(ManageIdentityFragment.this.getResources().getString(R.string.updated) + " " + ((Object) DateUtils.getRelativeTimeSpanString(ManageIdentityFragment.this.f4059Y.passUpdated)));
            ManageIdentityFragment.this.f4055U.setText(R.string.update_or_clear);
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        public void onCancel() {
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$g */
    /* loaded from: classes.dex */
    public class C1346g implements PrivateKeyPrompt.PrivateKeyPromptListener {
        public C1346g() {
        }

        @Override // cz.opentree.util.PrivateKeyPrompt.PrivateKeyPromptListener
        /* renamed from: e */
        public void mo5448e(String str) {
            if (str.isEmpty()) {
                ManageIdentityFragment.this.f4059Y.privatekey = "";
                ManageIdentityFragment.this.f4059Y.privatekeyPassword = "";
                ManageIdentityFragment.this.f4059Y.keyUpdated = 0L;
                ManageIdentityFragment.this.f4053S.setText(ManageIdentityFragment.this.getResources().getString(R.string.not_set));
                ManageIdentityFragment.this.f4054T.setText(R.string.set_optional);
                return;
            }
            ManageIdentityFragment.this.f4059Y.privatekey = qg0.m7702c(str, User.m5527u(ManageIdentityFragment.this.getActivity()));
            ManageIdentityFragment.this.f4059Y.privatekeyPassword = "";
            ManageIdentityFragment.this.f4059Y.keyUpdated = System.currentTimeMillis();
            ManageIdentityFragment.this.f4053S.setText(ManageIdentityFragment.this.getResources().getString(R.string.updated) + " " + ((Object) DateUtils.getRelativeTimeSpanString(ManageIdentityFragment.this.f4059Y.keyUpdated)));
            ManageIdentityFragment.this.f4054T.setText(R.string.update_or_clear);
        }

        @Override // cz.opentree.util.PrivateKeyPrompt.PrivateKeyPromptListener
        public void onCancel() {
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageIdentityFragment$h */
    /* loaded from: classes.dex */
    public class C1347h extends ug0.AbstractC2009b {
        public C1347h() {
        }

        @Override // cz.opentree.ug0.AbstractC2009b
        /* renamed from: a */
        public void mo5207a() {
            super.mo5207a();
            gj0.m4142c("ManageIdentityActivity", "Failed generate snippet from invalid public key");
            Toast.makeText(ManageIdentityFragment.this.getActivity(), R.string.invalid_private_key, 0).show();
        }

        @Override // cz.opentree.ug0.AbstractC2009b
        /* renamed from: b */
        public void mo5208b(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("mkdir -p ~/.ssh;\n");
            sb.append("chmod 700 ~/.ssh;\n");
            sb.append("echo \"");
            sb.append(str);
            sb.append("\" >> ~/.ssh/authorized_keys;\n");
            sb.append("chmod 600 ~/.ssh/authorized_keys;\n");
            if (ManageIdentityFragment.this.f4059Y.snippet == null || ManageIdentityFragment.this.f4059Y.snippet.m5383m() == null) {
                ManageIdentityFragment.this.f4059Y.snippet = new Snippet();
            }
            String obj = !ManageIdentityFragment.this.f4050P.getText().toString().isEmpty() ? ManageIdentityFragment.this.f4050P.getText().toString() : ManageIdentityFragment.this.f4051Q.getText().toString();
            ManageIdentityFragment.this.f4059Y.snippet.name = "Add Key: " + obj;
            ManageIdentityFragment.this.f4059Y.snippet.content = sb.toString();
            try {
                Toast.makeText(ManageIdentityFragment.this.getActivity(), C1328DB.m5404d(Snippet.class, ManageIdentityFragment.this.getActivity()).createOrUpdate(ManageIdentityFragment.this.f4059Y.snippet).isUpdated() ? ManageIdentityFragment.this.getString(R.string.snippet_updated_successfully) : ManageIdentityFragment.this.getString(R.string.snippet_created_successfully), 0).show();
            } catch (SQLException e) {
                gj0.m4142c("ManageIdentityActivity", "Failed to save snippet: " + e.getMessage());
                Toast.makeText(ManageIdentityFragment.this.getActivity(), R.string.failed_to_save_snippet, 0).show();
            }
        }
    }

    /* renamed from: m */
    public void m5438m(boolean z) {
        this.f4058X = z;
    }

    /* renamed from: n */
    public void m5439n() {
    }

    /* renamed from: o */
    public void m5440o() {
        if (getActivity() == null) {
            return;
        }
        if (this.f4051Q.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), R.string.you_must_enter_a_username, 0).show();
            return;
        }
        String str = this.f4059Y.privatekey;
        if (str == null || str.isEmpty()) {
            Toast.makeText(getActivity(), R.string.identity_has_no_key_to_export, 0).show();
            return;
        }
        try {
            ug0.m8891a(getActivity(), qg0.m7700a(this.f4059Y.privatekey, User.m5527u(getActivity())), qg0.m7700a(this.f4059Y.privatekeyPassword, User.m5527u(getActivity())), new C1347h());
        } catch (qg0.C1762a unused) {
            gj0.m4142c("ManageIdentityActivity", "Failed to decrypt private key to save public key snippet");
            Toast.makeText(getActivity(), getString(R.string.failed_to_save_snippet), 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 13508 || this.f4062b0 == null || i2 != -1 || intent == null) {
            return;
        }
        this.f4062b0.m9037B(intent.getData());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        OnIdentityDialogCompleteListener onIdentityDialogCompleteListener = this.f4061a0;
        if (onIdentityDialogCompleteListener != null) {
            onIdentityDialogCompleteListener.onCancel();
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m5439n();
        setCancelable(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.manage_identity, viewGroup, false);
        this.f4049O = relativeLayout;
        this.f4050P = (EditText) relativeLayout.findViewById(R.id.identityNickname_value);
        this.f4051Q = (EditText) this.f4049O.findViewById(R.id.identityUsername_value);
        this.f4052R = (TextView) this.f4049O.findViewById(R.id.identityPassword_status);
        this.f4053S = (TextView) this.f4049O.findViewById(R.id.identityPrivateKey_status);
        this.f4055U = (Button) this.f4049O.findViewById(R.id.identityPasswordButton);
        this.f4054T = (Button) this.f4049O.findViewById(R.id.identityPrivateKey_button);
        String str = this.f4059Y.username;
        if (str != null) {
            this.f4051Q.setText(str);
        }
        String str2 = this.f4059Y.nickname;
        if (str2 != null) {
            this.f4050P.setText(str2);
        }
        String str3 = this.f4059Y.password;
        if (str3 != null && str3.length() > 0) {
            this.f4055U.setText(R.string.update_or_clear);
        }
        String str4 = this.f4059Y.privatekey;
        if (str4 != null && str4.length() > 0) {
            this.f4054T.setText(R.string.update_or_clear);
        }
        if (this.f4057W) {
            getDialog().getWindow().requestFeature(1);
            this.f4049O.findViewById(R.id.snippet_header_row).setVisibility(8);
            this.f4049O.findViewById(R.id.snippet_row).setVisibility(8);
            this.f4049O.findViewById(R.id.snippet_button_row).setVisibility(8);
            this.f4049O.findViewById(R.id.bottom_buttons).setVisibility(0);
            ((Button) this.f4049O.findViewById(R.id.button_ok)).setOnClickListener(new ViewOnClickListenerC1340a());
            ((Button) this.f4049O.findViewById(R.id.button_cancel)).setOnClickListener(new ViewOnClickListenerC1341b());
        }
        Button button = (Button) this.f4049O.findViewById(R.id.generate_snippet);
        this.f4056V = button;
        button.setOnClickListener(new ViewOnClickListenerC1342c());
        this.f4054T.setOnClickListener(new ViewOnClickListenerC1343d());
        this.f4055U.setOnClickListener(new ViewOnClickListenerC1344e());
        return this.f4049O;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            if (this.f4059Y.passUpdated != 0) {
                this.f4052R.setText(getResources().getString(R.string.updated) + " " + ((Object) DateUtils.getRelativeTimeSpanString(this.f4059Y.passUpdated)));
            }
        } catch (NullPointerException unused) {
        }
        try {
            if (this.f4059Y.keyUpdated != 0) {
                this.f4053S.setText(getResources().getString(R.string.updated) + " " + ((Object) DateUtils.getRelativeTimeSpanString(this.f4059Y.keyUpdated)));
            }
        } catch (NullPointerException unused2) {
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: p */
    public void m5441p() {
        if (this.f4051Q.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), R.string.you_must_enter_a_username, 0).show();
            return;
        }
        this.f4059Y.nickname = this.f4050P.getText().toString().trim();
        this.f4059Y.username = this.f4051Q.getText().toString().trim();
        try {
            C1328DB.m5404d(Identity.class, getActivity()).createOrUpdate(this.f4059Y);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return;
        } catch (SQLException e2) {
            Toast.makeText(getActivity(), e2.getMessage(), 0).show();
        }
        ConnectionProvider connectionProvider = this.f4060Z;
        if (connectionProvider != null && this.f4058X) {
            connectionProvider.mo5368g().m5472z(this.f4059Y, getActivity());
        }
        OnIdentityDialogCompleteListener onIdentityDialogCompleteListener = this.f4061a0;
        if (onIdentityDialogCompleteListener != null) {
            onIdentityDialogCompleteListener.mo5288a(this.f4059Y);
        }
    }

    /* renamed from: q */
    public void m5442q(Connection connection) {
        this.f4060Z = connection;
    }

    /* renamed from: r */
    public void m5443r(Identity identity) {
        this.f4059Y = identity;
    }

    /* renamed from: s */
    public void m5444s(OnIdentityDialogCompleteListener onIdentityDialogCompleteListener) {
        this.f4061a0 = onIdentityDialogCompleteListener;
    }

    /* renamed from: t */
    public void m5445t(View view) {
        if (getActivity() == null) {
            return;
        }
        PasswordPrompt passwordPrompt = new PasswordPrompt(getActivity(), new C1345f());
        passwordPrompt.m9018q();
        passwordPrompt.m9297j(getResources().getString(R.string.new_password));
        passwordPrompt.m9295h(getResources().getString(R.string.please_enter_a_new_password));
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        passwordPrompt.show();
    }

    /* renamed from: u */
    public void m5446u(View view) {
        if (getActivity() == null) {
            return;
        }
        Identity identity = this.f4059Y;
        this.f4062b0 = new PrivateKeyPrompt(this, getActivity(), identity != null && identity.m5482t(), new C1346g());
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.f4062b0.show();
    }

    /* renamed from: v */
    public void m5447v(boolean z) {
        this.f4057W = z;
    }
}

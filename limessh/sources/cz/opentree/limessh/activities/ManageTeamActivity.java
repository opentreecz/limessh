package cz.opentree.limessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.models.Team;
import cz.opentree.limessh.models.TeamEncryption;
import cz.opentree.limessh.models.TeamMembership;
import cz.opentree.limessh.models.User;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.limessh.services.CloudSync;
import cz.opentree.pi0;
import cz.opentree.qg0;
import cz.opentree.sg0;
import cz.opentree.util.EmailPrompt;
import cz.opentree.util.PasswordPrompt;
import cz.opentree.util.SessionedActivity;
import cz.opentree.xj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManageTeamActivity extends SessionedActivity {

    /* renamed from: W */
    public static String f3854W = "ManageTeamActivity";

    /* renamed from: P */
    public EditText f3855P;

    /* renamed from: Q */
    public TextView f3856Q;

    /* renamed from: R */
    public LinearLayout f3857R;

    /* renamed from: S */
    public ImageButton f3858S;

    /* renamed from: T */
    public Team f3859T;

    /* renamed from: U */
    public xj0<User> f3860U;

    /* renamed from: V */
    public xj0.AbstractC2296d f3861V = new C1280a();

    /* renamed from: cz.opentree.limessh.activities.ManageTeamActivity$a */
    /* loaded from: classes.dex */
    public class C1280a extends xj0.AbstractC2296d {

        /* renamed from: cz.opentree.limessh.activities.ManageTeamActivity$a$a */
        /* loaded from: classes.dex */
        public class a implements EmailPrompt.EmailPromptListener {
            public a() {
            }

            @Override // cz.opentree.util.EmailPrompt.EmailPromptListener
            /* renamed from: e */
            public void mo5298e(String str) {
                User user = new User();
                user.f3993id = null;
                user.email = str;
                user.name = str;
                ArrayList<User> m9788i = ManageTeamActivity.this.f3860U.m9788i();
                ManageTeamActivity.this.f3860U.f7973O.add(user);
                m9788i.add(user);
                xj0<User> xj0Var = ManageTeamActivity.this.f3860U;
                xj0Var.m9795p(xj0Var.f7973O, m9788i);
            }

            @Override // cz.opentree.util.EmailPrompt.EmailPromptListener
            public void onCancel() {
            }
        }

        public C1280a() {
        }

        @Override // cz.opentree.xj0.AbstractC2296d
        /* renamed from: a */
        public void mo5244a(View view) {
            EmailPrompt emailPrompt = new EmailPrompt(ManageTeamActivity.this, new a());
            emailPrompt.m9004o(true);
            if (ManageTeamActivity.this.isFinishing()) {
                return;
            }
            emailPrompt.show();
        }
    }

    /* renamed from: cz.opentree.limessh.activities.ManageTeamActivity$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1281b implements View.OnClickListener {
        public ViewOnClickListenerC1281b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ManageTeamActivity.this.setPasswordDialogue(view);
        }
    }

    /* renamed from: cz.opentree.limessh.activities.ManageTeamActivity$c */
    /* loaded from: classes.dex */
    public class C1282c extends pi0.AbstractC1720p {
        public C1282c() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            try {
                List<User> queryForAll = C1328DB.m5404d(User.class, ManageTeamActivity.this).queryForAll();
                ArrayList<User> arrayList = new ArrayList<>();
                for (TeamMembership teamMembership : C1328DB.m5404d(TeamMembership.class, ManageTeamActivity.this).queryForEq("team_id", ManageTeamActivity.this.f3859T)) {
                    User user2 = teamMembership.user;
                    if (user2 != null && user2.m5383m() != null) {
                        for (User user3 : queryForAll) {
                            if (user3.f3993id.toString().equals(teamMembership.user.m5383m().f3993id.toString())) {
                                arrayList.add(user3);
                            }
                        }
                    }
                    User user4 = new User();
                    user4.f3993id = null;
                    String str = teamMembership.email;
                    user4.email = str;
                    user4.name = str;
                    arrayList.add(user4);
                    queryForAll.add(user4);
                }
                Iterator<User> it = queryForAll.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().f3993id.toString().equals(user.f3993id.toString())) {
                            it.remove();
                        }
                    } catch (NullPointerException unused) {
                    }
                }
                Iterator<User> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    try {
                        if (it2.next().f3993id.toString().equals(user.f3993id.toString())) {
                            it2.remove();
                        }
                    } catch (NullPointerException unused2) {
                    }
                }
                ManageTeamActivity.this.f3860U.m9795p(queryForAll, arrayList);
            } catch (SQLException e) {
                gj0.m4142c(ManageTeamActivity.f3854W, "Failed to populate team selections: " + e.getMessage());
            }
        }
    }

    /* renamed from: cz.opentree.limessh.activities.ManageTeamActivity$d */
    /* loaded from: classes.dex */
    public class C1283d extends pi0.AbstractC1720p {
        public C1283d() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            boolean z;
            User user2;
            super.mo3229b(user);
            try {
                ManageTeamActivity manageTeamActivity = ManageTeamActivity.this;
                manageTeamActivity.f3859T.name = manageTeamActivity.f3855P.getText().toString();
                C1328DB.m5404d(Team.class, ManageTeamActivity.this).createOrUpdate(ManageTeamActivity.this.f3859T);
                List<TeamMembership> queryForEq = C1328DB.m5404d(TeamMembership.class, ManageTeamActivity.this).queryForEq("team_id", ManageTeamActivity.this.f3859T);
                ArrayList arrayList = new ArrayList();
                ArrayList<User> m9788i = ManageTeamActivity.this.f3860U.m9788i();
                m9788i.add(0, user);
                Iterator<User> it = m9788i.iterator();
                while (it.hasNext()) {
                    User next = it.next();
                    TeamMembership teamMembership = new TeamMembership();
                    teamMembership.user = next;
                    teamMembership.email = next.email;
                    teamMembership.team = ManageTeamActivity.this.f3859T;
                    UUID uuid = next.f3993id;
                    if (uuid == null || !uuid.toString().equals(user.f3993id.toString())) {
                        teamMembership.accepted = false;
                    } else {
                        teamMembership.notified = true;
                        teamMembership.accepted = true;
                    }
                    for (TeamMembership teamMembership2 : queryForEq) {
                        if (next.f3993id != null && (user2 = teamMembership2.user) != null && user2.m5383m() != null) {
                            if (teamMembership2.user.m5383m().f3993id.toString().equals(next.f3993id.toString())) {
                                teamMembership = teamMembership2;
                            }
                        }
                        if (teamMembership2.email.equals(next.email)) {
                            teamMembership = teamMembership2;
                        }
                    }
                    C1328DB.m5404d(TeamMembership.class, ManageTeamActivity.this).createOrUpdate(teamMembership);
                    arrayList.add(teamMembership);
                }
                for (TeamMembership teamMembership3 : queryForEq) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((TeamMembership) it2.next()).f3993id.toString().equals(teamMembership3.f3993id.toString())) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        C1328DB.m5404d(TeamMembership.class, ManageTeamActivity.this).delete(teamMembership3);
                    }
                }
                CloudSync.m5627g(ManageTeamActivity.this);
                Intent intent = new Intent();
                intent.putExtra("id", ManageTeamActivity.this.f3859T.f3993id);
                ManageTeamActivity.this.setResult(-1, intent);
                ManageTeamActivity.this.finish();
            } catch (SQLException e) {
                gj0.m4142c(ManageTeamActivity.f3854W, "Failed to save team: " + e.getMessage());
                ManageTeamActivity.this.setResult(0, new Intent());
                ManageTeamActivity.this.finish();
            }
        }
    }

    /* renamed from: cz.opentree.limessh.activities.ManageTeamActivity$e */
    /* loaded from: classes.dex */
    public class C1284e implements PasswordPrompt.PasswordPromptListener {
        public C1284e() {
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        /* renamed from: a */
        public void mo5299a(String str, boolean z) {
            String m9016t = PasswordPrompt.m9016t(str, ManageTeamActivity.this.getApplicationContext());
            if (m9016t != null) {
                ManageTeamActivity manageTeamActivity = ManageTeamActivity.this;
                manageTeamActivity.f3859T.passUpdated = 0L;
                manageTeamActivity.f3856Q.setText(m9016t);
                return;
            }
            if (str.isEmpty()) {
                ManageTeamActivity manageTeamActivity2 = ManageTeamActivity.this;
                manageTeamActivity2.f3859T.passUpdated = 0L;
                manageTeamActivity2.f3856Q.setText(manageTeamActivity2.getResources().getString(R.string.not_set));
                return;
            }
            ManageTeamActivity manageTeamActivity3 = ManageTeamActivity.this;
            manageTeamActivity3.f3859T.m5510y(manageTeamActivity3.getApplicationContext(), str);
            ManageTeamActivity manageTeamActivity4 = ManageTeamActivity.this;
            TeamEncryption.m5512s(manageTeamActivity4.f3859T, manageTeamActivity4.getApplicationContext());
            ManageTeamActivity.this.f3859T.encryptionTest = qg0.m7702c("LimeSSH", sg0.m8429a(str));
            ManageTeamActivity.this.f3859T.passUpdated = System.currentTimeMillis();
            ManageTeamActivity.this.f3856Q.setText(ManageTeamActivity.this.getResources().getString(R.string.updated) + " " + ((Object) DateUtils.getRelativeTimeSpanString(ManageTeamActivity.this.f3859T.passUpdated)));
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        public void onCancel() {
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.manage_team);
        this.f3855P = (EditText) findViewById(R.id.teamName_value);
        this.f3857R = (LinearLayout) findViewById(R.id.main_content);
        xj0<User> xj0Var = new xj0<>(this);
        this.f3860U = xj0Var;
        xj0Var.m9789j();
        this.f3860U.m9791l(getResources().getString(R.string.add_team_member));
        this.f3860U.m9792m(this.f3861V);
        ImageButton imageButton = (ImageButton) findViewById(R.id.password_button);
        this.f3858S = imageButton;
        imageButton.setOnClickListener(new ViewOnClickListenerC1281b());
        this.f3856Q = (TextView) findViewById(R.id.identityPassword_status);
        this.f3857R.addView(this.f3860U);
        Bundle extras = getIntent().getExtras();
        try {
            if (extras.containsKey("id")) {
                Team team = (Team) C1328DB.m5404d(Team.class, this).queryForId((UUID) extras.get("id"));
                this.f3859T = team;
                if (team == null) {
                    this.f3859T = new Team();
                } else {
                    this.f3855P.setText(team.name);
                    this.f3856Q.setText(getResources().getString(R.string.updated) + " " + ((Object) DateUtils.getRelativeTimeSpanString(this.f3859T.passUpdated)));
                }
            } else {
                this.f3859T = new Team();
            }
        } catch (NullPointerException unused) {
            this.f3859T = new Team();
        } catch (SQLException unused2) {
            this.f3859T = new Team();
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        pi0.m7331j(this, new C1282c());
    }

    /* renamed from: m */
    public void m5297m() {
        if (this.f3855P.getText().toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.you_must_enter_a_team_name), 0).show();
        } else if (this.f3859T.passUpdated < 1) {
            Toast.makeText(this, getString(R.string.you_must_set_a_password), 0).show();
        } else {
            pi0.m7331j(this, new C1283d());
        }
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_manage_team, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_item_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        m5297m();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void setPasswordDialogue(View view) {
        PasswordPrompt passwordPrompt = new PasswordPrompt(this, new C1284e());
        passwordPrompt.m9018q();
        passwordPrompt.m9297j(getResources().getString(R.string.new_password));
        passwordPrompt.m9295h(getResources().getString(R.string.teamshare_password_explanation));
        if (isFinishing()) {
            return;
        }
        passwordPrompt.show();
    }
}

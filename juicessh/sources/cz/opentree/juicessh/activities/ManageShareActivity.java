package cz.opentree.juicessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.ConnectionGroup;
import cz.opentree.juicessh.models.Share;
import cz.opentree.juicessh.models.Team;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.services.CloudSync;
import cz.opentree.pi0;
import cz.opentree.util.SessionedActivity;
import cz.opentree.xj0;
import cz.opentree.yj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManageShareActivity extends SessionedActivity {

    /* renamed from: U */
    public static String f3838U = "ManageShareActivity";

    /* renamed from: P */
    public LinearLayout f3839P;

    /* renamed from: Q */
    public ConnectionGroup f3840Q;

    /* renamed from: R */
    public xj0<Team> f3841R;

    /* renamed from: S */
    public yj0<Team> f3842S;

    /* renamed from: T */
    public xj0.AbstractC2296d f3843T = new C1274a();

    /* renamed from: cz.opentree.juicessh.activities.ManageShareActivity$a */
    /* loaded from: classes.dex */
    public class C1274a extends xj0.AbstractC2296d {
        public C1274a() {
        }

        @Override // cz.opentree.xj0.AbstractC2296d
        /* renamed from: a */
        public void mo5244a(View view) {
            ManageShareActivity.this.f3842S = (yj0) view;
            ManageShareActivity.this.startActivityForResult(new Intent(ManageShareActivity.this, (Class<?>) ManageTeamActivity.class), 1);
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageShareActivity$b */
    /* loaded from: classes.dex */
    public class C1275b extends pi0.AbstractC1720p {
        public C1275b() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            List<Team> m5505v = Team.m5505v(user, ManageShareActivity.this);
            ArrayList<Team> arrayList = new ArrayList<>();
            ManageShareActivity manageShareActivity = ManageShareActivity.this;
            for (Share share : Share.m5499r(manageShareActivity.f3840Q, manageShareActivity)) {
                for (Team team : m5505v) {
                    if (team.f3993id.toString().equals(share.team.m5383m().f3993id.toString())) {
                        arrayList.add(team);
                    }
                }
            }
            ManageShareActivity.this.f3841R.m9795p(m5505v, arrayList);
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.manage_share);
        this.f3839P = (LinearLayout) findViewById(R.id.main_content);
        xj0<Team> xj0Var = new xj0<>(this);
        this.f3841R = xj0Var;
        xj0Var.m9793n(getResources().getString(R.string.teams));
        this.f3841R.m9791l(getResources().getString(R.string.add_team));
        this.f3841R.m9792m(this.f3843T);
        this.f3839P.addView(this.f3841R);
        Bundle extras = getIntent().getExtras();
        try {
            if (extras.containsKey("group_id")) {
                this.f3840Q = (ConnectionGroup) C1328DB.m5404d(ConnectionGroup.class, this).queryForId((UUID) extras.get("group_id"));
                pi0.m7331j(this, new C1275b());
            } else {
                finish();
            }
        } catch (NullPointerException unused) {
            finish();
        } catch (SQLException unused2) {
            finish();
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
    }

    /* renamed from: m */
    public void m5292m() {
        try {
            List<Share> queryForEq = C1328DB.m5404d(Share.class, this).queryForEq("group_id", this.f3840Q);
            ArrayList arrayList = new ArrayList();
            Iterator<Team> it = this.f3841R.m9788i().iterator();
            while (it.hasNext()) {
                Team next = it.next();
                Share share = new Share();
                share.group = this.f3840Q;
                share.team = next;
                for (Share share2 : queryForEq) {
                    try {
                        if (share2.team.m5383m().f3993id.toString().equals(next.f3993id.toString()) && share2.group.m5383m().f3993id.toString().equals(this.f3840Q.f3993id.toString())) {
                            share = share2;
                        }
                    } catch (NullPointerException unused) {
                    }
                }
                C1328DB.m5404d(Share.class, this).createOrUpdate(share);
                arrayList.add(share);
            }
            for (Share share3 : queryForEq) {
                Iterator it2 = arrayList.iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    if (share3.f3993id.toString().equals(((Share) it2.next()).f3993id.toString())) {
                        z = true;
                    }
                }
                if (!z) {
                    C1328DB.m5404d(Share.class, this).delete(share3);
                }
            }
            CloudSync.m5627g(this);
            setResult(-1, new Intent());
            finish();
        } catch (SQLException e) {
            gj0.m4142c(f3838U, "Failed to save share: " + e.getMessage());
            setResult(0, new Intent());
            finish();
        }
    }

    @Override // cz.opentree.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            Bundle extras = intent.getExtras();
            try {
                if (extras.containsKey("id")) {
                    UUID uuid = (UUID) extras.get("id");
                    List<Team> queryForAll = C1328DB.m5404d(Team.class, this).queryForAll();
                    ArrayList<Team> arrayList = new ArrayList<>();
                    for (Team team : queryForAll) {
                        Iterator<Team> it = this.f3841R.m9788i().iterator();
                        while (it.hasNext()) {
                            if (it.next().f3993id.toString().equals(team.f3993id.toString())) {
                                arrayList.add(team);
                            }
                        }
                        if (team.f3993id.toString().equals(uuid.toString())) {
                            arrayList.add(team);
                        }
                    }
                    this.f3841R.m9795p(queryForAll, arrayList);
                }
            } catch (NullPointerException | SQLException unused) {
            }
        }
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_manage_share, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_item_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        m5292m();
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
}

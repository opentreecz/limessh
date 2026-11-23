package com.sonelli.juicessh.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.ViewPager;
import com.sonelli.gj0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.models.TeamMembership;
import com.sonelli.juicessh.models.User;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.services.CloudSync;
import com.sonelli.pi0;
import com.sonelli.util.SessionedActivity;
import com.sonelli.wk0;
import com.sonelli.xh0;
import java.sql.SQLException;
import java.util.UUID;

/* loaded from: classes.dex */
public class TeamShareActivity extends SessionedActivity {

    /* renamed from: P */
    public ViewPager f3882P;

    /* renamed from: Q */
    public Menu f3883Q;

    /* renamed from: com.sonelli.juicessh.activities.TeamShareActivity$a */
    /* loaded from: classes.dex */
    public class C1290a extends pi0.AbstractC1720p {
        public C1290a() {
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            TeamShareActivity teamShareActivity = TeamShareActivity.this;
            ViewPager viewPager = teamShareActivity.f3882P;
            viewPager.setAdapter(new xh0(user, viewPager, teamShareActivity));
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.TeamShareActivity$b */
    /* loaded from: classes.dex */
    public class C1291b implements ViewPager.OnPageChangeListener {
        public C1291b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (TeamShareActivity.this.f3883Q == null) {
                return;
            }
            TeamShareActivity.this.f3883Q.clear();
            TeamShareActivity teamShareActivity = TeamShareActivity.this;
            TeamShareActivity.super.onCreateOptionsMenu(teamShareActivity.f3883Q);
            if (i == 0) {
                TeamShareActivity.this.getMenuInflater().inflate(R.menu.menu_teamshare_invites, TeamShareActivity.this.f3883Q);
            } else {
                TeamShareActivity.this.getMenuInflater().inflate(R.menu.menu_teamshare_team, TeamShareActivity.this.f3883Q);
            }
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.TeamShareActivity$c */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC1292c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC1292c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            TeamShareActivity.this.startActivity(new Intent(TeamShareActivity.this, (Class<?>) ManageCloudSyncActivity.class));
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.TeamShareActivity$d */
    /* loaded from: classes.dex */
    public class C1293d extends CloudSync.AbstractC1376i {
        public C1293d() {
        }

        @Override // com.sonelli.juicessh.services.CloudSync.AbstractC1376i
        /* renamed from: a */
        public void mo5314a() {
            super.mo5314a();
            TeamShareActivity.this.f3882P.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.teamshare);
        this.f3882P = (ViewPager) findViewById(R.id.viewpager);
        pi0.m7331j(this, new C1290a());
        this.f3882P.setOnPageChangeListener(new C1291b());
        this.f3882P.setCurrentItem(1);
        m5313o(getIntent().getExtras());
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        if (Config.m5459e(this, "cloudsync:enabled")) {
            return;
        }
        wk0 wk0Var = new wk0(this, getString(R.string.cloudsync_required), getString(R.string.teamshare_requires_cloudsync));
        wk0Var.setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC1292c());
        wk0Var.setNegativeButton(R.string.f3673no, (DialogInterface.OnClickListener) null);
        wk0Var.show();
    }

    /* renamed from: o */
    public void m5313o(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            UUID uuid = (UUID) bundle.get("membership");
            String str = (String) bundle.get(NotificationCompat.CATEGORY_EMAIL);
            Boolean bool = (Boolean) bundle.get("accepted");
            if (uuid != null) {
                if (User.m5525s(this) == null) {
                    gj0.m4142c("Activities/TeamShareActivity", "Tried to respond to an invite but no logged in user");
                } else if (str.equals(User.m5525s(this))) {
                    ((TeamMembership) C1328DB.m5404d(TeamMembership.class, this).queryForId(uuid)).m5517v(bool.booleanValue(), this, new C1293d());
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (SQLException e2) {
            gj0.m4142c("Activities/TeamShareActivity", "Failed to respond to invite: " + e2.getMessage());
        }
        ViewPager viewPager = this.f3882P;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        this.f3882P.getAdapter().notifyDataSetChanged();
    }

    @Override // com.sonelli.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f3882P.getAdapter().notifyDataSetChanged();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        if (this.f3882P.getCurrentItem() <= 0) {
            return false;
        }
        if (menuItem.getItemId() != R.id.remove) {
            return super.onContextItemSelected(menuItem);
        }
        xh0 xh0Var = (xh0) this.f3882P.getAdapter();
        try {
            C1328DB.m5404d(TeamMembership.class, this).delete(xh0Var.m9770i(adapterContextMenuInfo.position));
            CloudSync.m5627g(this);
            xh0Var.notifyDataSetChanged();
            return true;
        } catch (SQLException unused) {
            Toast.makeText(this, getString(R.string.could_not_remove_team_member), 0).show();
            return true;
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.f3882P.getCurrentItem() > 0) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            contextMenu.setHeaderTitle(R.string.team_member);
            getMenuInflater().inflate(R.menu.team_member_context_menu, contextMenu);
        }
    }

    @Override // com.sonelli.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.f3883Q = menu;
        getMenuInflater().inflate(R.menu.menu_teamshare_invites, menu);
        return true;
    }

    @Override // com.sonelli.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m5313o(intent.getExtras());
    }

    @Override // com.sonelli.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f3882P.getCurrentItem() > 0) {
            switch (menuItem.getItemId()) {
                case R.id.delete /* 2131296400 */:
                    ((xh0) this.f3882P.getAdapter()).m9769h();
                    return true;
                case R.id.leave /* 2131296533 */:
                    ((xh0) this.f3882P.getAdapter()).m9773l();
                    return true;
                case R.id.rename /* 2131296670 */:
                    ((xh0) this.f3882P.getAdapter()).m9774m();
                    return true;
                case R.id.update_api_key /* 2131296816 */:
                    ((xh0) this.f3882P.getAdapter()).m9768g();
                    return true;
            }
        }
        return super.onOptionsItemSelected(menuItem);
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

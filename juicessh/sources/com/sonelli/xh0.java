package com.sonelli;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.activities.ManageTeamActivity;
import com.sonelli.juicessh.models.Team;
import com.sonelli.juicessh.models.TeamEncryption;
import com.sonelli.juicessh.models.TeamMembership;
import com.sonelli.juicessh.models.User;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.services.CloudSync;
import com.sonelli.pi0;
import com.sonelli.util.EmailPrompt;
import com.sonelli.util.PasswordPrompt;
import com.sonelli.util.TeamMemberPrompt;
import com.sonelli.util.TextPrompt;
import java.sql.SQLException;
import java.util.List;

/* compiled from: TeamSharePagerAdapter.java */
/* loaded from: classes.dex */
public class xh0 extends PagerAdapter {

    /* renamed from: a */
    public Activity f7931a;

    /* renamed from: b */
    public List<Team> f7932b;

    /* renamed from: c */
    public List<TeamMembership> f7933c;

    /* renamed from: d */
    public LayoutInflater f7934d;

    /* renamed from: e */
    public ViewPager f7935e;

    /* renamed from: f */
    public User f7936f;

    /* renamed from: g */
    public View f7937g;

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2278a implements DialogInterface.OnClickListener {

        /* compiled from: TeamSharePagerAdapter.java */
        /* renamed from: com.sonelli.xh0$a$a */
        /* loaded from: classes.dex */
        public class a extends pi0.AbstractC1720p {
            public a() {
            }

            @Override // com.sonelli.pi0.AbstractC1720p
            /* renamed from: b */
            public void mo3229b(User user) {
                super.mo3229b(user);
                ((Team) xh0.this.f7932b.get(xh0.this.f7935e.getCurrentItem() - 1)).m5507s(xh0.this.f7931a);
                xh0.this.f7932b.remove(xh0.this.f7935e.getCurrentItem() - 1);
                xh0.this.notifyDataSetChanged();
            }
        }

        public DialogInterfaceOnClickListenerC2278a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            pi0.m7331j(xh0.this.f7931a, new a());
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$b */
    /* loaded from: classes.dex */
    public class C2279b implements PasswordPrompt.PasswordPromptListener {

        /* renamed from: a */
        public final /* synthetic */ Team f7940a;

        public C2279b(Team team) {
            this.f7940a = team;
        }

        @Override // com.sonelli.util.PasswordPrompt.PasswordPromptListener
        /* renamed from: a */
        public void mo5299a(String str, boolean z) {
            String m9016t = PasswordPrompt.m9016t(str, xh0.this.f7931a);
            if (m9016t != null) {
                Toast.makeText(xh0.this.f7931a, m9016t, 0).show();
                return;
            }
            this.f7940a.m5510y(xh0.this.f7931a, str);
            this.f7940a.passUpdated = System.currentTimeMillis();
            TeamEncryption.m5512s(this.f7940a, xh0.this.f7931a);
            this.f7940a.encryptionTest = qg0.m7702c("JuiceSSH", sg0.m8429a(str));
            try {
                C1328DB.m5404d(Team.class, xh0.this.f7931a).update(this.f7940a);
            } catch (SQLException e) {
                Toast.makeText(xh0.this.f7931a, xh0.this.f7931a.getString(R.string.could_not_update_team_password), 0).show();
                e.printStackTrace();
            }
        }

        @Override // com.sonelli.util.PasswordPrompt.PasswordPromptListener
        public void onCancel() {
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$c */
    /* loaded from: classes.dex */
    public class RunnableC2280c implements Runnable {
        public RunnableC2280c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xh0.this.f7935e.setCurrentItem(Math.max(1, xh0.this.f7935e.getCurrentItem()));
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$d */
    /* loaded from: classes.dex */
    public class RunnableC2281d implements Runnable {
        public RunnableC2281d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xh0.this.f7935e.setCurrentItem(0);
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$e */
    /* loaded from: classes.dex */
    public class C2282e extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ ListView f7944a;

        public C2282e(ListView listView) {
            this.f7944a = listView;
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            ListView listView = this.f7944a;
            List list = xh0.this.f7933c;
            xh0 xh0Var = xh0.this;
            listView.setAdapter((ListAdapter) new oh0(list, xh0Var, xh0Var.f7931a));
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$f */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2283f implements View.OnClickListener {
        public ViewOnClickListenerC2283f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            xh0.this.f7931a.startActivityForResult(new Intent(xh0.this.f7931a, (Class<?>) ManageTeamActivity.class), 0);
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$g */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2284g implements View.OnClickListener {
        public ViewOnClickListenerC2284g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            xh0.this.m9771j();
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$h */
    /* loaded from: classes.dex */
    public class C2285h extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ ListView f7948a;

        /* renamed from: b */
        public final /* synthetic */ int f7949b;

        public C2285h(ListView listView, int i) {
            this.f7948a = listView;
            this.f7949b = i;
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            ListView listView = this.f7948a;
            Team team = (Team) xh0.this.f7932b.get(this.f7949b - 1);
            xh0 xh0Var = xh0.this;
            listView.setAdapter((ListAdapter) new wh0(user, team, xh0Var, xh0Var.f7931a));
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$i */
    /* loaded from: classes.dex */
    public class C2286i implements TextPrompt.TextPromptListener {
        public C2286i() {
        }

        @Override // com.sonelli.util.TextPrompt.TextPromptListener
        /* renamed from: e */
        public void mo8901e(String str) {
            if (str.isEmpty()) {
                return;
            }
            Team team = (Team) xh0.this.f7932b.get(xh0.this.f7935e.getCurrentItem() - 1);
            team.name = str;
            try {
                C1328DB.m5404d(Team.class, xh0.this.f7931a).createOrUpdate(team);
                CloudSync.m5627g(xh0.this.f7931a);
                xh0.this.notifyDataSetChanged();
            } catch (SQLException unused) {
                Toast.makeText(xh0.this.f7931a, xh0.this.f7931a.getString(R.string.could_not_rename_team), 0).show();
            }
        }

        @Override // com.sonelli.util.TextPrompt.TextPromptListener
        public void onCancel() {
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$j */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2287j implements DialogInterface.OnClickListener {

        /* compiled from: TeamSharePagerAdapter.java */
        /* renamed from: com.sonelli.xh0$j$a */
        /* loaded from: classes.dex */
        public class a extends pi0.AbstractC1720p {
            public a() {
            }

            @Override // com.sonelli.pi0.AbstractC1720p
            /* renamed from: b */
            public void mo3229b(User user) {
                super.mo3229b(user);
                ((Team) xh0.this.f7932b.get(xh0.this.f7935e.getCurrentItem() - 1)).m5509w(user, xh0.this.f7931a);
                xh0.this.f7932b.remove(xh0.this.f7935e.getCurrentItem() - 1);
                xh0.this.notifyDataSetChanged();
                CloudSync.m5627g(xh0.this.f7931a);
            }
        }

        public DialogInterfaceOnClickListenerC2287j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            pi0.m7331j(xh0.this.f7931a, new a());
        }
    }

    /* compiled from: TeamSharePagerAdapter.java */
    /* renamed from: com.sonelli.xh0$k */
    /* loaded from: classes.dex */
    public class C2288k implements TeamMemberPrompt.TeamMemberPromptListener {

        /* compiled from: TeamSharePagerAdapter.java */
        /* renamed from: com.sonelli.xh0$k$a */
        /* loaded from: classes.dex */
        public class a implements EmailPrompt.EmailPromptListener {
            public a() {
            }

            @Override // com.sonelli.util.EmailPrompt.EmailPromptListener
            /* renamed from: e */
            public void mo5298e(String str) {
                User user = new User();
                user.f3993id = null;
                user.email = str;
                user.name = str;
                xh0.this.m9772k(user);
                xh0.this.notifyDataSetChanged();
            }

            @Override // com.sonelli.util.EmailPrompt.EmailPromptListener
            public void onCancel() {
            }
        }

        public C2288k() {
        }

        @Override // com.sonelli.util.TeamMemberPrompt.TeamMemberPromptListener
        /* renamed from: a */
        public void mo9065a(User user) {
            xh0.this.m9772k(user);
            xh0.this.notifyDataSetChanged();
        }

        @Override // com.sonelli.util.TeamMemberPrompt.TeamMemberPromptListener
        /* renamed from: b */
        public void mo9066b() {
            EmailPrompt emailPrompt = new EmailPrompt(xh0.this.f7931a, new a());
            emailPrompt.m9004o(true);
            emailPrompt.show();
        }

        @Override // com.sonelli.util.TeamMemberPrompt.TeamMemberPromptListener
        public void onCancel() {
        }
    }

    public xh0(User user, ViewPager viewPager, Activity activity) {
        this.f7931a = activity;
        this.f7936f = user;
        this.f7932b = Team.m5505v(user, activity);
        this.f7933c = TeamMembership.m5513s(user, activity);
        this.f7934d = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f7935e = viewPager;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    /* renamed from: g */
    public void m9768g() {
        PasswordPrompt passwordPrompt = new PasswordPrompt(this.f7931a, new C2279b(this.f7932b.get(this.f7935e.getCurrentItem() - 1)));
        passwordPrompt.m9296i(R.string.change_team_password);
        passwordPrompt.m9295h(String.format(this.f7931a.getString(R.string.please_enter_a_new_password_for_team), this.f7932b.get(this.f7935e.getCurrentItem() - 1).name));
        passwordPrompt.m9018q();
        if (this.f7931a.isFinishing()) {
            return;
        }
        passwordPrompt.show();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f7932b.size() + 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (i != 0) {
            try {
                return this.f7932b.get(i - 1).name;
            } catch (NullPointerException unused) {
                return this.f7931a.getString(R.string.team);
            }
        }
        return this.f7931a.getResources().getString(R.string.invites) + " (" + this.f7933c.size() + ")";
    }

    /* renamed from: h */
    public void m9769h() {
        List<Team> list;
        if (this.f7935e.getCurrentItem() <= 0 || (list = this.f7932b) == null || list.get(this.f7935e.getCurrentItem() - 1) == null) {
            return;
        }
        vk0 vk0Var = new vk0(this.f7931a);
        vk0Var.m9297j(this.f7931a.getString(R.string.delete_team));
        vk0Var.m9295h(String.format(this.f7931a.getString(R.string.are_you_sure_you_want_to_delete_team), this.f7932b.get(this.f7935e.getCurrentItem() - 1).name));
        vk0Var.setPositiveButton(this.f7931a.getString(R.string.yes), new DialogInterfaceOnClickListenerC2278a());
        vk0Var.setNegativeButton(this.f7931a.getString(R.string.f3673no), (DialogInterface.OnClickListener) null);
        if (this.f7931a.isFinishing()) {
            return;
        }
        vk0Var.show();
    }

    /* renamed from: i */
    public TeamMembership m9770i(int i) {
        if (this.f7935e.getCurrentItem() != 0) {
            return (TeamMembership) ((ListView) this.f7937g.findViewById(R.id.list)).getItemAtPosition(i);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f7934d.inflate(R.layout.pager_list, (ViewGroup) null, false);
        ListView listView = (ListView) relativeLayout.findViewById(R.id.list);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.empty);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.emptyTitle);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.emptyMessage);
        FloatingActionButton floatingActionButton = (FloatingActionButton) relativeLayout.findViewById(R.id.fab_new);
        if (i == 0) {
            listView.setDividerHeight(0);
            textView.setText(this.f7931a.getString(R.string.no_invites));
            textView2.setText(this.f7931a.getString(R.string.you_do_not_have_any_invites));
            listView.setEmptyView(linearLayout);
            pi0.m7331j(this.f7931a, new C2282e(listView));
            floatingActionButton.setOnClickListener(new ViewOnClickListenerC2283f());
            viewGroup.addView(relativeLayout);
            return relativeLayout;
        }
        listView.setDividerHeight(0);
        textView.setText(this.f7931a.getString(R.string.no_members));
        textView2.setText(this.f7931a.getString(R.string.this_team_has_no_members));
        listView.setEmptyView(linearLayout);
        floatingActionButton.setOnClickListener(new ViewOnClickListenerC2284g());
        this.f7931a.registerForContextMenu(listView);
        pi0.m7331j(this.f7931a, new C2285h(listView, i));
        viewGroup.addView(relativeLayout);
        return relativeLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* renamed from: j */
    public void m9771j() {
        AlertDialog create = new TeamMemberPrompt(this.f7931a, new C2288k()).create();
        if (this.f7931a.isFinishing()) {
            return;
        }
        create.show();
    }

    /* renamed from: k */
    public final void m9772k(User user) {
        List<Team> list;
        User user2;
        if (this.f7935e.getCurrentItem() <= 0 || (list = this.f7932b) == null || list.get(this.f7935e.getCurrentItem() - 1) == null) {
            return;
        }
        Team team = this.f7932b.get(this.f7935e.getCurrentItem() - 1);
        try {
            List<TeamMembership> queryForEq = C1328DB.m5404d(TeamMembership.class, this.f7931a).queryForEq("team_id", team);
            TeamMembership teamMembership = new TeamMembership();
            teamMembership.user = user;
            teamMembership.email = user.email;
            teamMembership.team = team;
            teamMembership.accepted = false;
            for (TeamMembership teamMembership2 : queryForEq) {
                if (user.f3993id != null && (user2 = teamMembership2.user) != null) {
                    if (user2.f3993id.toString().equals(user.f3993id.toString())) {
                        teamMembership = teamMembership2;
                    }
                }
                if (teamMembership2.email.equals(user.email)) {
                    teamMembership = teamMembership2;
                }
            }
            gj0.m4141b("Adapters/TeamSharePagerAdapter", teamMembership.email);
            C1328DB.m5404d(TeamMembership.class, this.f7931a).createOrUpdate(teamMembership);
            CloudSync.m5627g(this.f7931a);
        } catch (SQLException unused) {
            Activity activity = this.f7931a;
            Toast.makeText(activity, activity.getString(R.string.could_not_invite_user), 0).show();
        }
    }

    /* renamed from: l */
    public void m9773l() {
        List<Team> list;
        if (this.f7935e.getCurrentItem() <= 0 || (list = this.f7932b) == null || list.get(this.f7935e.getCurrentItem() - 1) == null) {
            return;
        }
        vk0 vk0Var = new vk0(this.f7931a);
        vk0Var.m9297j(this.f7931a.getString(R.string.leave_team));
        vk0Var.m9295h(String.format(this.f7931a.getString(R.string.are_you_sure_you_want_to_leave_team), this.f7932b.get(this.f7935e.getCurrentItem() - 1).name));
        vk0Var.setPositiveButton(this.f7931a.getString(R.string.yes), new DialogInterfaceOnClickListenerC2287j());
        vk0Var.setNegativeButton(this.f7931a.getString(R.string.f3673no), (DialogInterface.OnClickListener) null);
        if (this.f7931a.isFinishing()) {
            return;
        }
        vk0Var.show();
    }

    /* renamed from: m */
    public void m9774m() {
        List<Team> list;
        if (this.f7935e.getCurrentItem() <= 0 || (list = this.f7932b) == null || list.get(this.f7935e.getCurrentItem() - 1) == null) {
            return;
        }
        TextPrompt textPrompt = new TextPrompt(this.f7931a, new C2286i());
        textPrompt.m9296i(R.string.rename_team);
        textPrompt.m9295h(String.format(this.f7931a.getString(R.string.enter_new_team_name), this.f7932b.get(this.f7935e.getCurrentItem() - 1).name));
        if (this.f7931a.isFinishing()) {
            return;
        }
        textPrompt.show();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.f7932b = Team.m5505v(this.f7936f, this.f7931a);
        this.f7933c = TeamMembership.m5513s(this.f7936f, this.f7931a);
        super.notifyDataSetChanged();
        if (this.f7933c.size() == 0 && this.f7932b.size() > 0) {
            this.f7935e.postDelayed(new RunnableC2280c(), 0L);
        }
        if (this.f7933c.size() > 0) {
            this.f7935e.postDelayed(new RunnableC2281d(), 0L);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.f7937g = (View) obj;
    }
}

package cz.opentree;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import com.j256.ormlite.dao.CloseableIterator;
import cz.opentree.limessh.R;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.ConnectionCounter;
import cz.opentree.limessh.models.ConnectionGroupMembership;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.models.PortForward;
import cz.opentree.limessh.models.User;
import cz.opentree.limessh.models.ec2link.Ec2Connection;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.pi0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ConnectionWidgetFactory.java */
@TargetApi(11)
/* loaded from: classes.dex */
public class zj0 implements RemoteViewsService.RemoteViewsFactory {

    /* renamed from: h */
    public static ConcurrentHashMap<Integer, Boolean> f8528h = new ConcurrentHashMap<>();

    /* renamed from: a */
    public Context f8529a;

    /* renamed from: b */
    public int f8530b;

    /* renamed from: c */
    public List<Connection> f8531c = new ArrayList();

    /* renamed from: d */
    public List<PortForward> f8532d = new ArrayList();

    /* renamed from: e */
    public AppWidgetManager f8533e;

    /* renamed from: f */
    public RemoteViews f8534f;

    /* renamed from: g */
    public int f8535g;

    /* compiled from: ConnectionWidgetFactory.java */
    /* renamed from: cz.opentree.zj0$a */
    /* loaded from: classes.dex */
    public class C2430a extends pi0.AbstractC1720p {
        public C2430a() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            zj0.this.m10490f(kj0.m5917a().m5926F());
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (kj0.m5917a().m5926F() && !oi0.m7047d(user)) {
                zj0.this.m10490f(true);
            } else {
                zj0.this.m10491g();
                zj0.this.m10490f(false);
            }
        }
    }

    public zj0(Context context, Intent intent) {
        this.f8529a = context;
        this.f8530b = intent.getIntExtra("appWidgetId", 0);
        this.f8533e = AppWidgetManager.getInstance(context);
        this.f8534f = new RemoteViews(context.getPackageName(), R.layout.widget_frequently_used);
        onDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m10485a() {
        try {
            CloseableIterator it = C1328DB.m5404d(Connection.class, this.f8529a).iterator();
            while (it.hasNext()) {
                this.f8531c.add((Connection) it.next());
            }
            CloseableIterator it2 = C1328DB.m5404d(Ec2Connection.class, this.f8529a).iterator();
            while (it2.hasNext()) {
                this.f8531c.add((Connection) it2.next());
            }
        } catch (NullPointerException e) {
            gj0.m4142c("ConnectionWidgetFactory", "Failed to get all connections");
            e.printStackTrace();
        }
        Collections.sort(this.f8531c);
    }

    /* renamed from: b */
    public void m10486b() {
        for (ConnectionCounter connectionCounter : ConnectionCounter.m5473r(this.f8529a, 30L)) {
            Connection m5383m = connectionCounter.connection.m5383m();
            if (m5383m == null && connectionCounter.connection.f3993id != null) {
                try {
                    m5383m = (Connection) C1328DB.m5404d(Ec2Connection.class, this.f8529a).queryForId(connectionCounter.connection.f3993id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (m5383m != null) {
                this.f8531c.add(m5383m);
            }
        }
    }

    /* renamed from: c */
    public void m10487c(UUID uuid) {
        try {
            try {
                for (ConnectionGroupMembership connectionGroupMembership : C1328DB.m5404d(ConnectionGroupMembership.class, this.f8529a).queryForEq("group_id", uuid)) {
                    Connection m5383m = connectionGroupMembership.connection.m5383m();
                    if (m5383m == null && connectionGroupMembership.connection.f3993id != null) {
                        try {
                            m5383m = (Connection) C1328DB.m5404d(Ec2Connection.class, this.f8529a).queryForId(connectionGroupMembership.connection.f3993id);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (m5383m != null) {
                        this.f8531c.add(m5383m);
                    }
                }
            } catch (NullPointerException e2) {
                gj0.m4142c("ConnectionWidgetFactory", "Failed to get connections for group: " + uuid.toString());
                e2.printStackTrace();
            }
        } catch (SQLException e3) {
            gj0.m4142c("ConnectionWidgetFactory", "Failed to get connections for group: " + uuid.toString());
            e3.printStackTrace();
        }
        Collections.sort(this.f8531c);
    }

    /* renamed from: d */
    public void m10488d() {
        try {
            List<PortForward> queryForAll = C1328DB.m5404d(PortForward.class, this.f8529a).queryForAll();
            this.f8532d = queryForAll;
            Collections.sort(queryForAll);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @TargetApi(11)
    /* renamed from: e */
    public void m10489e() {
        try {
            if (f8528h.containsKey(Integer.valueOf(this.f8530b))) {
                return;
            }
            f8528h.put(Integer.valueOf(this.f8530b), Boolean.TRUE);
            this.f8534f.setViewVisibility(R.id.widget_empty_screen, 8);
            this.f8534f.setViewVisibility(R.id.widget_problock_screen, 8);
            this.f8534f.setViewVisibility(R.id.widget_list, 8);
            this.f8534f.setViewVisibility(R.id.widget_loading_screen, 0);
            this.f8533e.partiallyUpdateAppWidget(this.f8530b, this.f8534f);
        } catch (NullPointerException unused) {
            m10490f(kj0.m5917a().m5926F());
        }
    }

    @TargetApi(11)
    /* renamed from: f */
    public void m10490f(boolean z) {
        if (f8528h.containsKey(Integer.valueOf(this.f8530b))) {
            if (z) {
                this.f8534f.setViewVisibility(R.id.widget_empty_screen, 8);
                this.f8534f.setViewVisibility(R.id.widget_loading_screen, 8);
                this.f8534f.setViewVisibility(R.id.widget_list, 8);
                this.f8534f.setViewVisibility(R.id.widget_problock_screen, 0);
            } else {
                this.f8534f.setViewVisibility(R.id.widget_loading_screen, 8);
                this.f8534f.setViewVisibility(R.id.widget_problock_screen, 8);
                if (!(this.f8535g == -3 && this.f8532d.size() == 0) && (this.f8535g == -3 || this.f8531c.size() != 0)) {
                    this.f8534f.setViewVisibility(R.id.widget_empty_screen, 8);
                    this.f8534f.setViewVisibility(R.id.widget_list, 0);
                } else {
                    this.f8534f.setViewVisibility(R.id.widget_empty_screen, 0);
                    this.f8534f.setViewVisibility(R.id.widget_list, 8);
                }
            }
            try {
                this.f8533e.partiallyUpdateAppWidget(this.f8530b, this.f8534f);
            } catch (NullPointerException unused) {
            }
            f8528h.remove(Integer.valueOf(this.f8530b));
        }
    }

    /* renamed from: g */
    public void m10491g() {
        this.f8531c.clear();
        this.f8532d.clear();
        String string = this.f8529a.getSharedPreferences(this.f8529a.getPackageName() + "_widget-" + this.f8530b, 0).getString("widget:group", "-1");
        try {
            m10487c(UUID.fromString(string));
            gj0.m4141b("ConnectionWidgetFactory", "Populating widget with specific connection group");
        } catch (IllegalArgumentException unused) {
            int parseInt = Integer.parseInt(string);
            this.f8535g = parseInt;
            if (parseInt == -3) {
                gj0.m4141b("ConnectionWidgetFactory", "Populating widget with port forwards");
                m10488d();
            } else if (parseInt == -2) {
                gj0.m4141b("ConnectionWidgetFactory", "Populating widget with all connections");
                m10485a();
            } else {
                if (parseInt != -1) {
                    return;
                }
                gj0.m4141b("ConnectionWidgetFactory", "Populating widget with frequently used connections");
                m10486b();
            }
        } catch (NullPointerException unused2) {
            m10486b();
        }
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public int getCount() {
        return this.f8535g != -3 ? this.f8531c.size() : this.f8532d.size();
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    @TargetApi(11)
    public RemoteViews getViewAt(int i) {
        Connection connection;
        if (this.f8535g == -3) {
            PortForward portForward = this.f8532d.get(i);
            if (portForward == null) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(this.f8529a.getPackageName(), R.layout.widget_frequently_used_item);
            remoteViews.setTextViewText(R.id.widget_freq_item_title, portForward.name);
            Intent intent = new Intent();
            intent.setFlags(603979776);
            intent.setData(Uri.parse("ssh-forward://" + portForward.f3993id.toString()));
            remoteViews.setOnClickFillInIntent(R.id.widget_freq_item_title, intent);
            return remoteViews;
        }
        List<Connection> list = this.f8531c;
        if (list == null || (connection = list.get(i)) == null) {
            return null;
        }
        RemoteViews remoteViews2 = new RemoteViews(this.f8529a.getPackageName(), R.layout.widget_frequently_used_item);
        Identity m5470v = connection.m5470v(this.f8529a);
        if (m5470v == null) {
            remoteViews2.setTextViewText(R.id.widget_freq_item_title, connection.m5471w());
        } else {
            remoteViews2.setTextViewText(R.id.widget_freq_item_title, m5470v.username + "@" + connection.m5471w());
        }
        Intent intent2 = new Intent();
        intent2.setAction("do-not-cache" + System.currentTimeMillis());
        int i2 = connection.type;
        if (i2 == 1) {
            intent2.setData(Uri.parse("mosh://" + connection.f3993id.toString()));
        } else if (i2 == 2) {
            intent2.setData(Uri.parse("local://" + connection.f3993id.toString()));
        } else if (i2 != 3) {
            intent2.setData(Uri.parse("ssh://" + connection.f3993id.toString()));
        } else {
            intent2.setData(Uri.parse("telnet://" + connection.f3993id.toString()));
        }
        intent2.putExtra("background", false);
        remoteViews2.setOnClickFillInIntent(R.id.widget_freq_item_title, intent2);
        return remoteViews2;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onCreate() {
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onDataSetChanged() {
        if (f8528h.containsKey(Integer.valueOf(this.f8530b))) {
            return;
        }
        m10489e();
        pi0.m7331j(this.f8529a, new C2430a());
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onDestroy() {
    }
}

package cz.opentree.limessh.models;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.TeamShareActivity;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.limessh.p002db.DAO;
import cz.opentree.limessh.services.CloudSync;
import cz.opentree.pi0;
import cz.opentree.qg0;
import cz.opentree.uk0;
import cz.opentree.vl0;
import cz.opentree.wi0;
import cz.opentree.xi0;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DatabaseTable(daoClass = DAO.class, tableName = "teammembership")
/* loaded from: classes.dex */
public class TeamMembership extends BaseModel<TeamMembership> implements Comparable<TeamMembership> {

    @DatabaseField
    public boolean accepted;

    @DatabaseField
    public String email;

    @DatabaseField
    public boolean notified;

    @DatabaseField(foreign = true)
    public Team team;

    @DatabaseField(foreign = true)
    public User user;

    /* renamed from: s */
    public static List<TeamMembership> m5513s(User user, Context context) {
        Team m5383m;
        DAO m5404d = C1328DB.m5404d(TeamMembership.class, context);
        try {
            QueryBuilder<T, ID> queryBuilder = m5404d.queryBuilder();
            Where where = queryBuilder.where();
            Boolean bool = Boolean.FALSE;
            where.m1927or(where.m1916eq("accepted", bool).and().m1916eq("user_id", user).and().m1924ne("owner_id", user), where.m1916eq("accepted", bool).and().m1916eq(NotificationCompat.CATEGORY_EMAIL, user.email).and().m1924ne("owner_id", user), new Where[0]);
            List<TeamMembership> query = m5404d.query(queryBuilder.prepare());
            ArrayList arrayList = new ArrayList();
            for (TeamMembership teamMembership : query) {
                Team team = teamMembership.team;
                if (team != null && (m5383m = team.m5383m()) != null && m5383m.name != null) {
                    arrayList.add(teamMembership);
                }
            }
            return arrayList;
        } catch (SQLException e) {
            gj0.m4142c("TeamMembership", "Failed to fetch team invites: " + e.getMessage());
            return new ArrayList();
        }
    }

    /* renamed from: u */
    public static void m5514u(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, User user, Context context) {
        xi0 xi0Var = new xi0(user, context);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject2);
        JSONArray jSONArray3 = new JSONArray();
        jSONArray3.put(jSONObject3);
        try {
            C1328DB.m5403c(jSONArray, TeamMembership.class, xi0Var, user, false, context);
            C1328DB.m5403c(jSONArray2, Team.class, xi0Var, user, false, context);
            C1328DB.m5403c(jSONArray3, User.class, xi0Var, user, false, context);
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("cz.opentree.limessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 7));
            try {
                UUID fromString = UUID.fromString(jSONObject2.getString(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                UUID fromString2 = UUID.fromString(jSONObject.getString(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                UUID fromString3 = UUID.fromString(jSONObject3.getString(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                Team team = (Team) C1328DB.m5404d(Team.class, context).queryForId(fromString);
                TeamMembership teamMembership = (TeamMembership) C1328DB.m5404d(TeamMembership.class, context).queryForId(fromString2);
                User user2 = (User) C1328DB.m5404d(User.class, context).queryForId(fromString3);
                if (teamMembership.accepted || !teamMembership.email.equals(User.m5525s(context))) {
                    gj0.m4141b("TeamMembership", "Got an invite notification but for another user on this device");
                    return;
                }
                if (!Boolean.parseBoolean(Config.m5458d("notifications:enabled", context))) {
                    gj0.m4141b("TeamMembership", "Not showing TeamShare invite as notifications are disabled");
                    return;
                }
                String string = context.getResources().getString(R.string.juicessh_teamshare_request);
                String str = user2.name + " " + context.getResources().getString(R.string.has_invited_you_to) + " " + team.name;
                NotificationCompat.Builder color = new NotificationCompat.Builder(context, "juicessh").setSmallIcon(R.drawable.ic_notification).setContentTitle(string).setContentText(str).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(true).setColor(ContextCompat.getColor(context, R.color.accent_bold));
                try {
                    if (user2.picture == null) {
                        color.setSmallIcon(R.drawable.ic_notification);
                    } else {
                        vl0 m10685j = Picasso.m10676n(context).m10685j(user2.picture);
                        m10685j.m9311i(new uk0());
                        color.setLargeIcon(m10685j.m9306c());
                    }
                } catch (IOException unused) {
                    color.setSmallIcon(R.drawable.ic_notification);
                }
                Intent intent = new Intent(context, (Class<?>) TeamShareActivity.class);
                intent.putExtra("membership", teamMembership.f3993id);
                intent.putExtra("accepted", true);
                intent.putExtra(NotificationCompat.CATEGORY_EMAIL, teamMembership.email);
                intent.setData(Uri.parse("juicessh://membership/request/" + teamMembership.f3993id.toString() + "/accept"));
                intent.setFlags(603979776);
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                Intent intent2 = new Intent(context, (Class<?>) TeamShareActivity.class);
                intent2.putExtra("membership", teamMembership.f3993id);
                intent2.putExtra("accepted", false);
                intent2.putExtra(NotificationCompat.CATEGORY_EMAIL, teamMembership.email);
                intent2.setData(Uri.parse("juicessh://membership/request/" + teamMembership.f3993id.toString() + "/reject"));
                intent2.setFlags(603979776);
                PendingIntent activity2 = PendingIntent.getActivity(context, 0, intent2, 0);
                color.addAction(android.R.drawable.ic_input_add, context.getResources().getString(R.string.accept), activity);
                color.addAction(android.R.drawable.ic_delete, context.getResources().getString(R.string.reject), activity2);
                Intent intent3 = new Intent(context, (Class<?>) TeamShareActivity.class);
                intent3.setData(Uri.parse("juicessh://membership/request/" + teamMembership.f3993id.toString()));
                intent3.setFlags(603979776);
                color.setContentIntent(PendingIntent.getActivity(context, 0, intent3, 0));
                color.setAutoCancel(true);
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle(color);
                bigTextStyle.setBigContentTitle(string);
                bigTextStyle.bigText(str);
                ((NotificationManager) context.getSystemService("notification")).notify(wi0.m9569b(teamMembership.f3993id, wi0.EnumC2225a.NOTIFICATION_TEAM_INVITE), bigTextStyle.build());
            } catch (NullPointerException unused2) {
                gj0.m4142c("TeamMembership", "Team membership request with invalid team/requestor");
            } catch (SQLException unused3) {
                gj0.m4142c("TeamMembership", "Team membership request with invalid team/requestor");
            } catch (JSONException unused4) {
                gj0.m4142c("TeamMembership", "Team membership request with invalid team/requestor");
            }
        } catch (qg0.C1762a unused5) {
            gj0.m4142c("TeamMembership", "Recieved encrypted TeamMembership request - which should never happen");
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(TeamMembership teamMembership) {
        User user;
        User user2 = this.user;
        if (user2 == null || user2.m5383m() == null || (user = teamMembership.user) == null || user.m5383m() == null) {
            return 0;
        }
        return this.user.name.compareTo(teamMembership.user.name);
    }

    /* renamed from: t */
    public void m5516t(User user, Context context) {
        User user2;
        Team team = this.team;
        if (team == null || team.m5383m() == null || (user2 = this.user) == null || user2.m5383m() == null) {
            gj0.m4142c("TeamMembership", "Tried to notify of new team member for null team/user");
            return;
        }
        if (!Boolean.parseBoolean(Config.m5458d("notifications:enabled", context))) {
            gj0.m4141b("TeamMembership", "Not showing team join notification as notifications are disabled");
            return;
        }
        String str = context.getResources().getString(R.string.app_name) + ": " + this.team.name;
        String format = String.format(context.getResources().getString(R.string.has_joined_team), this.user.name, this.team.name);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, "juicessh").setSmallIcon(R.drawable.ic_notification).setContentTitle(str).setContentText(format).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(true);
        try {
            if (user.picture == null) {
                autoCancel.setSmallIcon(R.drawable.ic_notification);
            } else {
                vl0 m10685j = Picasso.m10676n(context).m10685j(user.picture);
                m10685j.m9311i(new uk0());
                autoCancel.setLargeIcon(m10685j.m9306c());
            }
        } catch (IOException unused) {
            autoCancel.setSmallIcon(R.drawable.ic_notification);
        }
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle(autoCancel);
        bigTextStyle.setBigContentTitle(str);
        bigTextStyle.bigText(format);
        ((NotificationManager) context.getSystemService("notification")).notify(wi0.m9569b(this.f3993id, wi0.EnumC2225a.NOTIFICATION_NEW_TEAM_MEMBER), bigTextStyle.build());
    }

    /* renamed from: v */
    public void m5517v(boolean z, final Context context, CloudSync.AbstractC1376i abstractC1376i) {
        if (z) {
            this.accepted = z;
            pi0.m7331j(context, new pi0.AbstractC1720p() { // from class: cz.opentree.limessh.models.TeamMembership.1
                @Override // cz.opentree.pi0.AbstractC1720p
                /* renamed from: b */
                public void mo3229b(User user) {
                    super.mo3229b(user);
                    TeamMembership.this.user = user;
                    try {
                        C1328DB.m5404d(TeamMembership.class, context).update(TeamMembership.this);
                    } catch (SQLException e) {
                        gj0.m4142c("TeamMembership", "Failed to accept team membership: " + e.getMessage());
                    }
                }
            });
        } else {
            try {
                C1328DB.m5404d(TeamMembership.class, context).delete(this);
            } catch (SQLException e) {
                gj0.m4142c("TeamMembership", "Failed to decline team membership: " + e.getMessage());
            }
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(wi0.m9569b(this.f3993id, wi0.EnumC2225a.NOTIFICATION_TEAM_INVITE));
        CloudSync.m5628h(context, abstractC1376i);
    }
}

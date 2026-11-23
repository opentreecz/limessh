package com.sonelli.juicessh.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.gj0;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.p002db.DAO;
import com.sonelli.juicessh.services.CloudSync;
import com.sonelli.sg0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@DatabaseTable(daoClass = DAO.class, tableName = "team")
/* loaded from: classes.dex */
public class Team extends BaseModel<Team> implements Comparable<Team> {

    @DatabaseField
    public String encryptionTest;

    @DatabaseField
    public String name;

    @DatabaseField
    public long passUpdated;
    public String password;

    /* renamed from: u */
    public static String m5504u(UUID uuid, Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(sg0.m8429a(User.m5525s(context) + uuid.toString()), null);
    }

    /* renamed from: v */
    public static <T> List<Team> m5505v(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        DAO m5404d = C1328DB.m5404d(TeamMembership.class, context);
        try {
            Iterator it = m5404d.query(m5404d.queryBuilder().where().m1916eq("user_id", user).and().m1916eq("accepted", Boolean.TRUE).prepare()).iterator();
            while (it.hasNext()) {
                arrayList.add(((TeamMembership) it.next()).team.m5383m());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(Team team) {
        return this.name.compareToIgnoreCase(team.name);
    }

    /* renamed from: s */
    public void m5507s(Context context) {
        try {
            List queryForEq = C1328DB.m5404d(Share.class, context).queryForEq("team_id", this);
            List queryForEq2 = C1328DB.m5404d(TeamMembership.class, context).queryForEq("team_id", this);
            List queryForEq3 = C1328DB.m5404d(TeamEncryption.class, context).queryForEq("team_id", this);
            C1328DB.m5404d(Share.class, context).delete((Collection) queryForEq);
            C1328DB.m5404d(TeamMembership.class, context).delete((Collection) queryForEq2);
            C1328DB.m5404d(TeamEncryption.class, context).delete((Collection) queryForEq3);
            C1328DB.m5404d(Team.class, context).delete(this);
            CloudSync.m5627g(context);
        } catch (SQLException unused) {
        }
    }

    /* renamed from: t */
    public String m5508t(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(sg0.m8429a(User.m5525s(context) + this.f3993id.toString()), null);
    }

    public String toString() {
        return this.name;
    }

    /* renamed from: w */
    public void m5509w(User user, Context context) {
        DAO m5404d = C1328DB.m5404d(TeamMembership.class, context);
        try {
            Iterator it = m5404d.query(m5404d.queryBuilder().where().m1916eq("user_id", user).and().m1916eq("team_id", this).prepare()).iterator();
            while (it.hasNext()) {
                m5404d.delete((TeamMembership) it.next());
            }
        } catch (SQLException e) {
            gj0.m4142c(BaseModel.TAG, "Could not leave team: " + e.getMessage());
        }
    }

    /* renamed from: y */
    public void m5510y(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(sg0.m8429a(User.m5525s(context) + this.f3993id.toString()), sg0.m8429a(str));
        edit.commit();
    }
}

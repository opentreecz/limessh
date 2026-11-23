package com.sonelli.juicessh.models;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.p002db.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DatabaseTable(daoClass = DAO.class, tableName = "share")
/* loaded from: classes.dex */
public class Share extends BaseModel<Share> {

    @DatabaseField(foreign = true, index = true)
    public ConnectionGroup group;

    @DatabaseField(foreign = true, index = true)
    public Team team;

    /* renamed from: r */
    public static List<Share> m5499r(ConnectionGroup connectionGroup, Context context) {
        try {
            List<Share> queryForEq = C1328DB.m5404d(Share.class, context).queryForEq("group_id", connectionGroup);
            Iterator<Share> it = queryForEq.iterator();
            while (it.hasNext()) {
                Team team = it.next().team;
                if (team == null || team.m5383m() == null) {
                    it.remove();
                }
            }
            return queryForEq;
        } catch (SQLException unused) {
            return new ArrayList();
        }
    }

    /* renamed from: s */
    public static List<Share> m5500s(Team team, Context context) {
        try {
            List<Share> queryForEq = C1328DB.m5404d(Share.class, context).queryForEq("team_id", team);
            Iterator<Share> it = queryForEq.iterator();
            while (it.hasNext()) {
                ConnectionGroup connectionGroup = it.next().group;
                if (connectionGroup == null || connectionGroup.m5383m() == null) {
                    it.remove();
                }
            }
            return queryForEq;
        } catch (SQLException unused) {
            return new ArrayList();
        }
    }
}

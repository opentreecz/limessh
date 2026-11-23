package cz.opentree.juicessh.models;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.gj0;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.p002db.DAO;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

@DatabaseTable(daoClass = DAO.class, tableName = "teamencryption")
/* loaded from: classes.dex */
public class TeamEncryption extends BaseModel<TeamEncryption> {

    @DatabaseField
    public String data;

    @DatabaseField
    public UUID item;

    @DatabaseField
    public long revision;

    @DatabaseField(foreign = true)
    public Team team;

    @DatabaseField
    public String type;

    /* renamed from: r */
    public static void m5511r(User user, Context context) {
        try {
            for (Team team : Team.m5505v(user, context)) {
                for (Share share : Share.m5500s(team, context)) {
                    ConnectionGroup connectionGroup = share.group;
                    if (connectionGroup != null && connectionGroup.m5383m() != null) {
                        share.group.m5384o(team, context);
                        for (ConnectionGroupMembership connectionGroupMembership : C1328DB.m5404d(ConnectionGroupMembership.class, context).queryForEq("group_id", share.group)) {
                            Connection connection = connectionGroupMembership.connection;
                            if (connection != null && connection.m5383m() != null) {
                                connectionGroupMembership.connection.m5384o(team, context);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            gj0.m4142c("TeamEncryption", "Failed to create team encryptions: " + e.getMessage());
        }
    }

    /* renamed from: s */
    public static void m5512s(Team team, Context context) {
        DAO m5404d = C1328DB.m5404d(TeamEncryption.class, context);
        try {
            m5404d.delete((Collection) m5404d.queryForEq("team_id", team));
        } catch (SQLException e) {
            gj0.m4142c("TeamEncryption", "Failed to delete team encryptions: " + e.getMessage());
        }
    }
}

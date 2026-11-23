package com.sonelli.juicessh.models;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.gj0;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.p002db.DAO;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@DatabaseTable(daoClass = DAO.class, tableName = "connectionidentity")
/* loaded from: classes.dex */
public class ConnectionIdentity extends BaseModel<ConnectionIdentity> {
    public static final String TAG = "ConnectionIdentity";

    @DatabaseField(foreign = true, index = true)
    public Connection connection;

    @DatabaseField(foreign = true, index = true)
    public Identity identity;

    public ConnectionIdentity() {
    }

    public ConnectionIdentity(Connection connection, Identity identity, Context context) {
        this.connection = connection;
        this.identity = identity;
        try {
            DAO m5404d = C1328DB.m5404d(ConnectionIdentity.class, context);
            Iterator it = m5404d.queryForEq("connection_id", connection.f3993id).iterator();
            while (it.hasNext()) {
                m5404d.delete((ConnectionIdentity) it.next());
            }
            m5404d.createIfNotExists(this);
        } catch (SQLException e) {
            gj0.m4142c(TAG, "Failed to assign identity to connection: " + e.getMessage());
        }
    }

    /* renamed from: r */
    public static Identity m5477r(Connection connection, Context context) {
        try {
            List queryForEq = C1328DB.m5404d(ConnectionIdentity.class, context).queryForEq("connection_id", connection.f3993id);
            if (queryForEq.size() >= 1 && ((ConnectionIdentity) queryForEq.get(0)).identity != null && ((ConnectionIdentity) queryForEq.get(0)).identity.m5383m() != null) {
                return ((ConnectionIdentity) queryForEq.get(0)).identity.m5383m();
            }
            return null;
        } catch (SQLException e) {
            gj0.m4142c(TAG, "Failed to get identity for connection: " + e.getMessage());
            return null;
        }
    }
}

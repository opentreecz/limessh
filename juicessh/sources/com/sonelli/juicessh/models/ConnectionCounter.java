package com.sonelli.juicessh.models;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.gj0;
import com.sonelli.juicessh.models.ec2link.Ec2Connection;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.p002db.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@DatabaseTable(daoClass = DAO.class, tableName = "connectioncounter")
/* loaded from: classes.dex */
public class ConnectionCounter extends BaseModel<ConnectionCounter> {
    public static final String TAG = "ConnectionCounter";

    @DatabaseField(foreign = true, index = true)
    public Connection connection;

    @DatabaseField
    public int count;

    /* renamed from: r */
    public static List<ConnectionCounter> m5473r(Context context, long j) {
        DAO m5404d = C1328DB.m5404d(ConnectionCounter.class, context);
        try {
            List<ConnectionCounter> query = m5404d.query(m5404d.queryBuilder().orderBy("count", false).limit(Long.valueOf(j)).where().m1918gt("count", 0).prepare());
            m5475t(query, context);
            return query;
        } catch (SQLException unused) {
            gj0.m4142c(TAG, "Failed to fetch top used connections");
            return new ArrayList();
        }
    }

    /* renamed from: s */
    public static void m5474s(Connection connection, Context context) {
        DAO m5404d = C1328DB.m5404d(ConnectionCounter.class, context);
        try {
            List<ConnectionCounter> queryForEq = m5404d.queryForEq("connection_id", connection.f3993id);
            if (queryForEq.size() <= 0) {
                ConnectionCounter connectionCounter = new ConnectionCounter();
                connectionCounter.connection = connection;
                connectionCounter.count = 1;
                m5404d.create(connectionCounter);
                return;
            }
            for (ConnectionCounter connectionCounter2 : queryForEq) {
                connectionCounter2.count++;
                m5404d.update(connectionCounter2);
            }
        } catch (SQLException unused) {
            gj0.m4142c(TAG, "Could not increment connection counter for: " + connection.f3993id.toString());
        }
    }

    /* renamed from: t */
    public static List<ConnectionCounter> m5475t(List<ConnectionCounter> list, Context context) {
        ListIterator<ConnectionCounter> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ConnectionCounter next = listIterator.next();
            Connection connection = next.connection;
            if (connection == null || connection.f3993id == null) {
                gj0.m4142c(TAG, "Deleting invalid connection counter: " + next.f3993id);
                try {
                    C1328DB.m5404d(ConnectionCounter.class, context).delete(next);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                listIterator.remove();
            } else {
                Connection m5383m = connection.m5383m();
                if (m5383m == null) {
                    try {
                        Connection connection2 = (Connection) C1328DB.m5404d(Ec2Connection.class, context).queryForId(next.connection.f3993id);
                        try {
                            next.connection = connection2;
                            listIterator.set(next);
                        } catch (SQLException unused) {
                        }
                        m5383m = connection2;
                    } catch (SQLException unused2) {
                    }
                }
                if (m5383m == null) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }
}

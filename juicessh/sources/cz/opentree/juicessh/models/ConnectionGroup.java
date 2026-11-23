package cz.opentree.juicessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "connectiongroup")
/* loaded from: classes.dex */
public class ConnectionGroup extends BaseModel<ConnectionGroup> implements Comparable<ConnectionGroup> {
    public static final String TAG = "ConnectionGroup";

    @DatabaseField
    public String name;

    public ConnectionGroup() {
        this.name = "";
    }

    public ConnectionGroup(String str) {
        this.name = "";
        this.name = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(ConnectionGroup connectionGroup) {
        return toString().compareToIgnoreCase(connectionGroup.toString());
    }

    public String toString() {
        return this.name;
    }
}

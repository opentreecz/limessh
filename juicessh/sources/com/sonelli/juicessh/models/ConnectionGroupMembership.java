package com.sonelli.juicessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "connectiongroupmembership")
/* loaded from: classes.dex */
public class ConnectionGroupMembership extends BaseModel<ConnectionGroupMembership> {
    public static final String TAG = "ConnectionGroupMembership";

    @DatabaseField(foreign = true, index = true)
    public Connection connection;

    @DatabaseField(foreign = true, index = true)
    public ConnectionGroup group;
}

package com.sonelli.juicessh.models.ec2link;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "ec2connection")
/* loaded from: classes.dex */
public class Ec2Connection extends Connection {

    @DatabaseField
    public String instanceId;

    @DatabaseField(foreign = true, index = true)
    public Ec2Mapping mapping;

    public Ec2Connection() {
    }

    public Ec2Connection(String str, String str2, String str3, int i, Connection connection) {
        this.instanceId = str;
        this.nickname = str2;
        this.address = str3;
        this.port = i;
        this.via = connection;
    }
}

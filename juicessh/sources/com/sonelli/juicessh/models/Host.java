package com.sonelli.juicessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "host")
/* loaded from: classes.dex */
public class Host extends BaseModel<Host> {

    @DatabaseField
    public String fingerprint;

    @DatabaseField
    public String hostname;

    @DatabaseField
    public String key;

    @DatabaseField
    public String type;
}

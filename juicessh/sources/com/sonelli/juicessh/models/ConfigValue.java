package com.sonelli.juicessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "configvalue")
/* loaded from: classes.dex */
public class ConfigValue extends BaseModel<ConfigValue> {

    @DatabaseField(foreign = true)
    public ConfigField field;

    @DatabaseField
    public String value;
}

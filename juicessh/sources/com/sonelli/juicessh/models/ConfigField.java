package com.sonelli.juicessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "configfield")
/* loaded from: classes.dex */
public class ConfigField extends BaseModel<ConfigField> {

    @DatabaseField
    public String defaultValue;

    @DatabaseField(index = true)
    public String name;
}

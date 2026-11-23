package cz.opentree.limessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "configvalue")
/* loaded from: classes.dex */
public class ConfigValue extends BaseModel<ConfigValue> {

    @DatabaseField(foreign = true)
    public ConfigField field;

    @DatabaseField
    public String value;
}

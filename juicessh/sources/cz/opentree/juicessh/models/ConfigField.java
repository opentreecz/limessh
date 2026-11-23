package cz.opentree.juicessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "configfield")
/* loaded from: classes.dex */
public class ConfigField extends BaseModel<ConfigField> {

    @DatabaseField
    public String defaultValue;

    @DatabaseField(index = true)
    public String name;
}

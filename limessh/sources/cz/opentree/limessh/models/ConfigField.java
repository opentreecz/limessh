package cz.opentree.limessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "configfield")
/* loaded from: classes.dex */
public class ConfigField extends BaseModel<ConfigField> {

    @DatabaseField
    public String defaultValue;

    @DatabaseField(index = true)
    public String name;
}

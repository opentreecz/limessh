package cz.opentree.limessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.DAO;

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

package cz.opentree.juicessh.models.ec2link;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.juicessh.models.ConnectionGroup;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "ec2groupmapping")
/* loaded from: classes.dex */
public class Ec2GroupMapping extends BaseModel<Ec2GroupMapping> {

    @DatabaseField(foreign = true, index = true)
    public ConnectionGroup group;

    @DatabaseField(foreign = true, index = true)
    public Ec2Mapping mapping;
}

package cz.opentree.limessh.models.ec2link;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "ec2mapping")
/* loaded from: classes.dex */
public class Ec2Mapping extends BaseModel<Ec2Mapping> {

    @DatabaseField(foreign = true, index = true)
    public Connection defaultConnectVia;

    @DatabaseField(foreign = true, index = true)
    public Identity defaultIdentity;

    @DatabaseField(foreign = true, index = true)
    public Ec2Profile profile;

    @DatabaseField(index = true)
    public int defaultType = 0;

    @DatabaseField
    public boolean privateIps = false;

    @DatabaseField
    public int defaultPort = 22;
}

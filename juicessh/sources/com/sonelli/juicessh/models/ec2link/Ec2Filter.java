package com.sonelli.juicessh.models.ec2link;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.DAO;

@DatabaseTable(daoClass = DAO.class, tableName = "ec2filter")
/* loaded from: classes.dex */
public class Ec2Filter extends BaseModel<Ec2Filter> {

    @DatabaseField
    public String key;

    @DatabaseField(foreign = true, index = true)
    public Ec2Mapping mapping;

    @DatabaseField
    public String pattern;
    public static final String FILTERTYPE_SECURITY_GROUP = "Security Group";
    public static final String FILTERTYPE_TAG_VALUE = "Tag Value";
    public static final String FILTERTYPE_INSTANCE_TYPE = "Instance Type";
    public static final String[] filters = {FILTERTYPE_SECURITY_GROUP, FILTERTYPE_TAG_VALUE, FILTERTYPE_INSTANCE_TYPE};

    public Ec2Filter() {
    }

    public Ec2Filter(Ec2Mapping ec2Mapping, String str, String str2) {
        this.mapping = ec2Mapping;
        this.key = str;
        this.pattern = str2;
    }
}

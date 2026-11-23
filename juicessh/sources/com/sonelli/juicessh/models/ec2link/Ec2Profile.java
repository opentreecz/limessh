package com.sonelli.juicessh.models.ec2link;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.p002db.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DatabaseTable(daoClass = DAO.class, tableName = "ec2profile")
/* loaded from: classes.dex */
public class Ec2Profile extends BaseModel<Ec2Profile> implements Comparable<Ec2Profile> {
    public static String REGION_AF_SOUTH_1 = "af-south-1";
    public static String REGION_AP_EAST_1 = "ap-east-1";
    public static String REGION_AP_NORTHEAST_1 = "ap-northeast-1";
    public static String REGION_AP_NORTHEAST_2 = "ap-northeast-2";
    public static String REGION_AP_NORTHEAST_3 = "ap-northeast-3";
    public static String REGION_AP_SOUTHEAST_1 = "ap-southeast-1";
    public static String REGION_AP_SOUTHEAST_2 = "ap-southeast-2";
    public static String REGION_AP_SOUTH_1 = "ap-south-1";
    public static String REGION_CA_CENTRAL_1 = "ca-central-1";
    public static String REGION_CN_NORTHWEST_1 = "cn-northwest-1";
    public static String REGION_CN_NORTH_1 = "cn-north-1";
    public static String REGION_EU_CENTRAL_1 = "eu-central-1";
    public static String REGION_EU_NORTH_1 = "eu-north-1";
    public static String REGION_EU_SOUTH_1 = "eu-south-1";
    public static String REGION_EU_WEST_1 = "eu-west-1";
    public static String REGION_EU_WEST_2 = "eu-west-2";
    public static String REGION_ME_SOUTH_1 = "me-south-1";
    public static String REGION_SA_EAST_1 = "sa-east-1";
    public static String REGION_US_EAST_1 = "us-east-1";
    public static String REGION_US_EAST_2 = "us-east-2";
    public static String REGION_US_GOV_EAST_1 = "us-gov-east-1";
    public static String REGION_US_GOV_WEST_1 = "us-gov-west-1";
    public static String REGION_US_WEST_1 = "us-west-1";
    public static String REGION_US_WEST_2 = "us-west-2";
    public static String REGION_WEST_3 = "eu-west-3";
    public static String[] regions = {"us-east-2", "us-east-1", "us-west-1", "us-west-2", "af-south-1", "ap-east-1", "ap-south-1", "ap-northeast-3", "ap-northeast-2", "ap-southeast-1", "ap-southeast-2", "ap-northeast-1", "ca-central-1", "cn-north-1", "cn-northwest-1", "eu-central-1", "eu-west-1", "eu-west-2", "eu-south-1", "eu-west-3", "eu-north-1", "me-south-1", "sa-east-1", "us-gov-east-1", "us-gov-west-1"};

    @DatabaseField
    public String disabledReason;

    @DatabaseField
    public String key;

    @DatabaseField
    public String name;

    @DatabaseField
    public String region;

    @DatabaseField
    public String secret;

    @DatabaseField
    public boolean isEnabled = true;

    @DatabaseField
    public long lastSyncTime = 0;

    @DatabaseField
    public int lastSyncItemCount = 0;

    /* renamed from: s */
    public static List<Ec2Profile> m5534s(Context context) {
        try {
            List<Ec2Profile> queryForAll = C1328DB.m5404d(Ec2Profile.class, context).queryForAll();
            Collections.sort(queryForAll);
            return queryForAll;
        } catch (SQLException unused) {
            return new ArrayList();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(Ec2Profile ec2Profile) {
        String str = this.name;
        if (str == null) {
            str = "EC2 Sync Profile";
        }
        String str2 = ec2Profile.name;
        if (str2 != null) {
            return str.compareToIgnoreCase(str2);
        }
        return 0;
    }
}

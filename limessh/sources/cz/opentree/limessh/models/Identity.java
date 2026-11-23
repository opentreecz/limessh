package cz.opentree.limessh.models;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.gj0;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.limessh.p002db.DAO;
import cz.opentree.qg0;
import java.sql.SQLException;

@DatabaseTable(daoClass = DAO.class, tableName = "identity")
/* loaded from: classes.dex */
public class Identity extends BaseModel<Identity> implements Comparable<Identity> {
    public static final String TAG = "Models/Identity";

    @DatabaseField
    public long keyUpdated;

    @DatabaseField
    public String nickname;

    @DatabaseField
    public long passUpdated;

    @DatabaseField
    public String password;

    @DatabaseField
    public String privatekey;

    @DatabaseField
    public String privatekeyPassword;

    @DatabaseField(foreign = true)
    public Snippet snippet;

    @DatabaseField
    public String username;

    public Identity() {
    }

    public Identity(String str) {
        this.username = str;
    }

    /* renamed from: u */
    public static void m5479u(String str, Context context) {
        try {
            for (Identity identity : C1328DB.m5404d(Identity.class, context).queryForAll()) {
                try {
                    String str2 = identity.password;
                    if (str2 != null && str2.length() > 0) {
                        identity.password = qg0.m7702c(qg0.m7700a(identity.password, User.m5527u(context)), str);
                    }
                    String str3 = identity.privatekey;
                    if (str3 != null && str3.length() > 0) {
                        identity.privatekey = qg0.m7702c(qg0.m7700a(identity.privatekey, User.m5527u(context)), str);
                    }
                    String str4 = identity.privatekeyPassword;
                    if (str4 != null && str4.length() > 0) {
                        identity.privatekeyPassword = qg0.m7702c(qg0.m7700a(identity.privatekeyPassword, User.m5527u(context)), str);
                    }
                    C1328DB.m5404d(Identity.class, context).m5398r(identity);
                } catch (qg0.C1762a e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e2) {
            gj0.m4142c(TAG, "Error while re-encrypting identities");
            e2.printStackTrace();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(Identity identity) {
        return toString().compareToIgnoreCase(identity.toString());
    }

    /* renamed from: s */
    public boolean m5481s() {
        String str = this.password;
        return str != null && str.length() >= 1;
    }

    /* renamed from: t */
    public boolean m5482t() {
        String str = this.privatekey;
        return str != null && str.length() >= 1;
    }

    public String toString() {
        String str = this.nickname;
        return (str == null || str.isEmpty()) ? this.username : this.nickname;
    }
}

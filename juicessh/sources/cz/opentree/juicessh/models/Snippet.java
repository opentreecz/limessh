package cz.opentree.juicessh.models;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.p002db.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DatabaseTable(daoClass = DAO.class, tableName = "snippet")
/* loaded from: classes.dex */
public class Snippet extends BaseModel<Snippet> implements Comparable<Snippet> {

    @DatabaseField
    public String content;

    @DatabaseField
    public int count;

    @DatabaseField
    public String name;

    public Snippet() {
    }

    public Snippet(String str, String str2) {
        this.name = str;
        this.content = str2;
    }

    /* renamed from: t */
    public static List<Snippet> m5501t(Context context) {
        try {
            List<Snippet> queryForAll = C1328DB.m5404d(Snippet.class, context).queryForAll();
            Collections.sort(queryForAll);
            return queryForAll;
        } catch (SQLException unused) {
            return new ArrayList();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(Snippet snippet) {
        String str;
        String str2 = this.name;
        if (str2 == null) {
            str2 = "Snippet";
        }
        String str3 = snippet.name;
        int compareToIgnoreCase = str3 != null ? str2.compareToIgnoreCase(str3) : 0;
        if (compareToIgnoreCase != 0) {
            return compareToIgnoreCase;
        }
        String str4 = this.content;
        if (str4 == null || (str = snippet.content) == null) {
            return 0;
        }
        return str4.compareToIgnoreCase(str);
    }

    /* renamed from: s */
    public String m5503s() {
        String str = this.name;
        return (str == null || str.length() <= 1) ? this.content : this.name;
    }
}

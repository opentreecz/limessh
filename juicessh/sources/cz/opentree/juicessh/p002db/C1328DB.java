package cz.opentree.juicessh.p002db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.ConfigField;
import cz.opentree.juicessh.models.ConfigValue;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.ConnectionCounter;
import cz.opentree.juicessh.models.ConnectionGroup;
import cz.opentree.juicessh.models.ConnectionGroupMembership;
import cz.opentree.juicessh.models.ConnectionIdentity;
import cz.opentree.juicessh.models.DeletedItem;
import cz.opentree.juicessh.models.Host;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.models.PluginLog;
import cz.opentree.juicessh.models.PortForward;
import cz.opentree.juicessh.models.Purchase;
import cz.opentree.juicessh.models.Share;
import cz.opentree.juicessh.models.Snippet;
import cz.opentree.juicessh.models.Team;
import cz.opentree.juicessh.models.TeamEncryption;
import cz.opentree.juicessh.models.TeamMembership;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.models.ec2link.Ec2Connection;
import cz.opentree.juicessh.models.ec2link.Ec2Filter;
import cz.opentree.juicessh.models.ec2link.Ec2GroupMapping;
import cz.opentree.juicessh.models.ec2link.Ec2Mapping;
import cz.opentree.juicessh.models.ec2link.Ec2Profile;
import java.sql.SQLException;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: cz.opentree.juicessh.db.DB */
/* loaded from: classes.dex */
public class C1328DB extends OrmLiteSqliteOpenHelper {

    /* renamed from: O */
    public static C1328DB f3998O;

    public C1328DB(Context context) {
        super(context, User.m5526t(context), (SQLiteDatabase.CursorFactory) null, 55, R.raw.ormlite_config);
    }

    /* renamed from: a */
    public static <T extends BaseModel<?>> JSONArray m5401a(Class<T> cls, User user, Context context, boolean z) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (T t : m5404d(cls, context).queryForAll()) {
                if (z) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        String str = t.encrypted;
                        if (str == null || str.length() < 1 || user.passwordUpdated > t.modified) {
                            t.m5382l(context, true, user);
                        }
                        jSONObject.put("id", t.f3993id);
                        jSONObject.put("_encrypted", true);
                        jSONObject.put("modified", t.modified);
                        jSONObject.put("data", t.encrypted);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        gj0.m4142c("DB", "JSON error: " + e.getMessage());
                    }
                } else {
                    JSONObject m5385q = t.m5385q(context);
                    m5385q.put("id", t.f3993id);
                    m5385q.put("_encrypted", false);
                    m5385q.put("modified", t.modified);
                    jSONArray.put(m5385q);
                }
            }
        } catch (SQLException e2) {
            gj0.m4142c("DB", "Failed to export: " + e2.getMessage());
        }
        return jSONArray;
    }

    /* renamed from: b */
    public static C1328DB m5402b(Context context) {
        C1328DB c1328db = f3998O;
        if (c1328db == null || !c1328db.isOpen()) {
            f3998O = (C1328DB) OpenHelperManager.getHelper(context.getApplicationContext(), C1328DB.class);
        }
        return f3998O;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* renamed from: c */
    public static <T extends cz.opentree.juicessh.p002db.BaseModel<?>> void m5403c(org.json.JSONArray r26, java.lang.Class<T> r27, cz.opentree.xi0 r28, cz.opentree.juicessh.models.User r29, boolean r30, android.content.Context r31) throws cz.opentree.qg0.C1762a {
        /*
            Method dump skipped, instructions count: 1532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.juicessh.p002db.C1328DB.m5403c(org.json.JSONArray, java.lang.Class, cz.opentree.xi0, cz.opentree.juicessh.models.User, boolean, android.content.Context):void");
    }

    /* renamed from: d */
    public static <T extends BaseModel<?>> DAO<T, UUID> m5404d(Class<T> cls, Context context) {
        try {
            DAO<T, UUID> dao = new DAO<>(m5402b(context).getConnectionSource(), cls);
            dao.f3997O = context;
            return dao;
        } catch (SQLException e) {
            gj0.m4142c("DB", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.dropTable(connectionSource, ConfigField.class, true);
            TableUtils.dropTable(connectionSource, ConfigValue.class, true);
            TableUtils.dropTable(connectionSource, Connection.class, true);
            TableUtils.dropTable(connectionSource, ConnectionGroup.class, true);
            TableUtils.dropTable(connectionSource, ConnectionGroupMembership.class, true);
            TableUtils.dropTable(connectionSource, Identity.class, true);
            TableUtils.dropTable(connectionSource, DeletedItem.class, true);
            TableUtils.dropTable(connectionSource, ConnectionIdentity.class, true);
            TableUtils.dropTable(connectionSource, Team.class, true);
            TableUtils.dropTable(connectionSource, TeamMembership.class, true);
            TableUtils.dropTable(connectionSource, Share.class, true);
            TableUtils.dropTable(connectionSource, TeamEncryption.class, true);
            TableUtils.dropTable(connectionSource, ConnectionCounter.class, true);
            TableUtils.dropTable(connectionSource, Host.class, true);
            TableUtils.dropTable(connectionSource, Snippet.class, true);
            TableUtils.dropTable(connectionSource, Ec2Connection.class, true);
            TableUtils.dropTable(connectionSource, Ec2Filter.class, true);
            TableUtils.dropTable(connectionSource, Ec2GroupMapping.class, true);
            TableUtils.dropTable(connectionSource, Ec2Mapping.class, true);
            TableUtils.dropTable(connectionSource, Ec2Profile.class, true);
            TableUtils.dropTable(connectionSource, PluginLog.class, true);
            TableUtils.createTable(connectionSource, ConfigField.class);
            TableUtils.createTable(connectionSource, ConfigValue.class);
            TableUtils.createTable(connectionSource, Connection.class);
            TableUtils.createTable(connectionSource, ConnectionGroup.class);
            TableUtils.createTable(connectionSource, ConnectionGroupMembership.class);
            TableUtils.createTable(connectionSource, Identity.class);
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTable(connectionSource, DeletedItem.class);
            TableUtils.createTableIfNotExists(connectionSource, Purchase.class);
            TableUtils.createTable(connectionSource, ConnectionIdentity.class);
            TableUtils.createTable(connectionSource, Team.class);
            TableUtils.createTable(connectionSource, TeamMembership.class);
            TableUtils.createTable(connectionSource, Share.class);
            TableUtils.createTable(connectionSource, TeamEncryption.class);
            TableUtils.createTable(connectionSource, ConnectionCounter.class);
            TableUtils.createTable(connectionSource, Host.class);
            TableUtils.createTable(connectionSource, Snippet.class);
            TableUtils.createTable(connectionSource, Ec2Connection.class);
            TableUtils.createTable(connectionSource, Ec2Filter.class);
            TableUtils.createTable(connectionSource, Ec2GroupMapping.class);
            TableUtils.createTable(connectionSource, Ec2Mapping.class);
            TableUtils.createTable(connectionSource, Ec2Profile.class);
            TableUtils.createTable(connectionSource, PortForward.class);
            TableUtils.createTable(connectionSource, PluginLog.class);
        } catch (SQLException e) {
            e.printStackTrace();
            gj0.m4142c(C1328DB.class.getName(), "Unable to create databases: " + e.getMessage());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        switch (i + 1) {
            case 37:
            case 38:
            case 39:
            case 40:
                try {
                    TableUtils.createTable(connectionSource, Host.class);
                    TableUtils.createTable(connectionSource, Snippet.class);
                    TableUtils.createTable(connectionSource, Ec2Connection.class);
                    TableUtils.createTable(connectionSource, Ec2Filter.class);
                    TableUtils.createTable(connectionSource, Ec2GroupMapping.class);
                    TableUtils.createTable(connectionSource, Ec2Mapping.class);
                    TableUtils.createTable(connectionSource, Ec2Profile.class);
                    TableUtils.createTable(connectionSource, PortForward.class);
                    TableUtils.dropTable(connectionSource, PortForward.class, true);
                    TableUtils.createTable(connectionSource, PortForward.class);
                    sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN type INTEGER DEFAULT 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN type INTEGER DEFAULT 0;");
                    TableUtils.createTable(connectionSource, PluginLog.class);
                    sQLiteDatabase.execSQL("ALTER TABLE `ec2mapping` ADD COLUMN defaultType INTEGER DEFAULT 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                    sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                    sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                    sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                    sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                    sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                    return;
                } catch (SQLException e) {
                    gj0.m4142c(C1328DB.class.getName(), "Unable to upgrade database from version " + i + " to new " + i2);
                    e.printStackTrace();
                    return;
                }
            case 41:
            case 42:
                TableUtils.createTable(connectionSource, Ec2Connection.class);
                TableUtils.createTable(connectionSource, Ec2Filter.class);
                TableUtils.createTable(connectionSource, Ec2GroupMapping.class);
                TableUtils.createTable(connectionSource, Ec2Mapping.class);
                TableUtils.createTable(connectionSource, Ec2Profile.class);
                TableUtils.createTable(connectionSource, PortForward.class);
                TableUtils.dropTable(connectionSource, PortForward.class, true);
                TableUtils.createTable(connectionSource, PortForward.class);
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN type INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN type INTEGER DEFAULT 0;");
                TableUtils.createTable(connectionSource, PluginLog.class);
                sQLiteDatabase.execSQL("ALTER TABLE `ec2mapping` ADD COLUMN defaultType INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 43:
                TableUtils.createTable(connectionSource, PortForward.class);
                TableUtils.dropTable(connectionSource, PortForward.class, true);
                TableUtils.createTable(connectionSource, PortForward.class);
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN type INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN type INTEGER DEFAULT 0;");
                TableUtils.createTable(connectionSource, PluginLog.class);
                sQLiteDatabase.execSQL("ALTER TABLE `ec2mapping` ADD COLUMN defaultType INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 44:
            case 45:
            case 46:
                TableUtils.dropTable(connectionSource, PortForward.class, true);
                TableUtils.createTable(connectionSource, PortForward.class);
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN type INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN type INTEGER DEFAULT 0;");
                TableUtils.createTable(connectionSource, PluginLog.class);
                sQLiteDatabase.execSQL("ALTER TABLE `ec2mapping` ADD COLUMN defaultType INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 47:
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN type INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN type INTEGER DEFAULT 0;");
                TableUtils.createTable(connectionSource, PluginLog.class);
                sQLiteDatabase.execSQL("ALTER TABLE `ec2mapping` ADD COLUMN defaultType INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 48:
            case 49:
            default:
                return;
            case 50:
                TableUtils.createTable(connectionSource, PluginLog.class);
                sQLiteDatabase.execSQL("ALTER TABLE `ec2mapping` ADD COLUMN defaultType INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 51:
                sQLiteDatabase.execSQL("ALTER TABLE `ec2mapping` ADD COLUMN defaultType INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 52:
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 53:
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `ec2connection` ADD COLUMN `mosh_command` VARCHAR(255);");
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 54:
                sQLiteDatabase.execSQL("ALTER TABLE `identity` ADD COLUMN `snippet_id` VARCHAR(36);");
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
            case 55:
                sQLiteDatabase.execSQL("ALTER TABLE `connection` ADD COLUMN backspaceMode INTEGER DEFAULT 0;");
                return;
        }
    }
}

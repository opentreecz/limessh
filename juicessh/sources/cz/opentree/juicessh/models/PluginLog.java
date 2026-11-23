package cz.opentree.juicessh.models;

import android.content.Context;
import android.os.Binder;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.gj0;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.p002db.DAO;
import java.sql.SQLException;

@DatabaseTable(daoClass = DAO.class, tableName = "plugin_log")
/* loaded from: classes.dex */
public class PluginLog extends BaseModel<PluginLog> {
    public static final int DAYS_TO_KEEP = 7;
    public static final String TAG = "PluginLog";

    @DatabaseField
    public String message;

    @DatabaseField
    public String packageName;

    /* renamed from: r */
    public static String m5490r(Context context) {
        return context.getPackageManager().getNameForUid(Binder.getCallingUid());
    }

    /* renamed from: s */
    public static void m5491s(Context context, String str, String str2) {
        PluginLog pluginLog = new PluginLog();
        pluginLog.packageName = str;
        pluginLog.message = str2;
        gj0.m4145f(TAG, "(" + pluginLog.packageName + ") " + str2);
        try {
            C1328DB.m5404d(PluginLog.class, context).m5389h(pluginLog);
        } catch (SQLException unused) {
            gj0.m4142c(TAG, "Could not save plugin log entry: " + pluginLog.packageName + ": " + pluginLog.message);
        }
        m5492t(context);
    }

    /* renamed from: t */
    public static void m5492t(Context context) {
        long currentTimeMillis = System.currentTimeMillis() - 604800000;
        try {
            DeleteBuilder<T, ID> deleteBuilder = C1328DB.m5404d(PluginLog.class, context).deleteBuilder();
            deleteBuilder.where().m1923lt("modified", Long.valueOf(currentTimeMillis));
            deleteBuilder.delete();
        } catch (SQLException e) {
            gj0.m4142c(TAG, "Unable to purge old plugin log entries: " + e.getMessage());
        }
    }
}

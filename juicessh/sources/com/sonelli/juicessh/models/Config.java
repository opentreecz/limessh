package com.sonelli.juicessh.models;

import android.content.Context;
import com.sonelli.gj0;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.p002db.DAO;
import com.sonelli.qg0;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Config {
    public static final String TAG = "Models/Config";

    /* renamed from: a */
    public static ConfigField m5455a(String str, String str2, Context context) {
        try {
            List queryForEq = C1328DB.m5404d(ConfigField.class, context).queryForEq("name", str);
            if (queryForEq.size() >= 1) {
                return (ConfigField) queryForEq.get(0);
            }
            ConfigField configField = new ConfigField();
            configField.name = str;
            configField.defaultValue = str2;
            C1328DB.m5404d(ConfigField.class, context).createIfNotExists(configField);
            return configField;
        } catch (SQLException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static void m5456b(Context context) {
        m5455a("notifications:enabled", "true", context);
        m5455a("terminal:font_size", "8", context);
        m5455a("terminal:type", "linux", context);
        m5455a("terminal:utf8", "true", context);
        m5455a("terminal:keyboard_position", "1", context);
        m5455a("terminal:theme", Integer.toString(2), context);
        m5455a("terminal:bell_mode", "0", context);
        m5455a("terminal:autocomplete", "0", context);
        m5455a("terminal:horizontal_swipe_mode", "0", context);
        m5455a("mosh:mosh-server", "mosh-server new -s -l LANG=en_US.UTF-8", context);
        m5455a("tutorial:terminal", "false", context);
        m5455a("last:cloudsync", "0", context);
        m5455a("last:teamshare", "0", context);
        m5455a("cloudsync:enabled", "false", context);
        m5455a("cloudsync:identities", "true", context);
        m5455a("session:cache", "", context);
        m5455a("pinlock:style", String.valueOf(2), context);
        m5455a("pinlock:pin", "", context);
        m5455a("changelog:seen_auth_migration_message", "false", context);
        m5455a("version:code", "0", context);
        m5455a("theme:dark", "-1", context);
        m5455a("terminal:margin", "0", context);
        m5455a("terminal:margin_selection", "0", context);
        m5455a("ssh:agent", "false", context);
        m5455a("terminal:font", "", context);
    }

    /* renamed from: c */
    public static JSONArray m5457c(User user, Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (ConfigValue configValue : C1328DB.m5404d(ConfigValue.class, context).queryForAll()) {
                if (configValue != null && !m5463i(configValue.field.m5383m())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", configValue.f3993id.toString());
                    jSONObject.put("field", configValue.field.name);
                    jSONObject.put("modified", configValue.modified);
                    jSONObject.put("value", qg0.m7702c(configValue.value, User.m5527u(context)));
                    jSONArray.put(jSONObject);
                }
            }
        } catch (SQLException e) {
            gj0.m4142c(TAG, "SQL Error: " + e.getMessage());
        } catch (JSONException e2) {
            gj0.m4142c(TAG, "JSON Error: " + e2.getMessage());
        }
        return jSONArray;
    }

    /* renamed from: d */
    public static String m5458d(String str, Context context) {
        try {
            List queryForEq = C1328DB.m5404d(ConfigField.class, context).queryForEq("name", str);
            if (queryForEq != null && queryForEq.size() >= 1) {
                List queryForEq2 = C1328DB.m5404d(ConfigValue.class, context).queryForEq("field_id", queryForEq.get(0));
                if (queryForEq2 != null && queryForEq2.size() >= 1) {
                    return ((ConfigValue) queryForEq2.get(0)).value;
                }
                return ((ConfigField) queryForEq.get(0)).defaultValue;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public static boolean m5459e(Context context, String str) {
        return Boolean.valueOf(m5458d(str, context)).booleanValue();
    }

    /* renamed from: f */
    public static int m5460f(Context context, String str) {
        try {
            return Integer.valueOf(m5458d(str, context)).intValue();
        } catch (NullPointerException | NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: g */
    public static void m5461g(JSONArray jSONArray, User user, Context context) {
        DAO dao;
        DAO dao2;
        int i;
        DAO m5404d = C1328DB.m5404d(ConfigField.class, context);
        DAO m5404d2 = C1328DB.m5404d(ConfigValue.class, context);
        try {
            if (jSONArray.length() > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (!jSONObject.isNull("field") && !jSONObject.isNull("value") && !jSONObject.isNull("modified")) {
                        List queryForEq = m5404d.queryForEq("name", jSONObject.getString("field"));
                        if (queryForEq.size() < 1) {
                            gj0.m4142c(TAG, "Could not import config item as field " + jSONObject.getString("field") + " does not exist");
                        } else if (!m5463i((ConfigField) queryForEq.get(i2))) {
                            List queryForEq2 = m5404d2.queryForEq("field_id", queryForEq.get(i2));
                            if (queryForEq2.size() < 1) {
                                gj0.m4141b(TAG, "Inserting config from CloudSync backup: " + ((ConfigField) queryForEq.get(0)).name);
                                String m7700a = qg0.m7700a(jSONObject.getString("value"), User.m5527u(context));
                                if (m7700a == null) {
                                    gj0.m4142c(TAG, "Backup decryption failed for: " + ((ConfigField) queryForEq.get(0)).name);
                                } else {
                                    m5462h(((ConfigField) queryForEq.get(0)).name, m7700a, context);
                                }
                                dao = m5404d;
                                dao2 = m5404d2;
                            } else {
                                dao = m5404d;
                                dao2 = m5404d2;
                                if (jSONObject.getLong("modified") > ((ConfigValue) queryForEq2.get(0)).modified) {
                                    gj0.m4141b(TAG, "Updating config from CloudSync backup: " + ((ConfigField) queryForEq.get(0)).name);
                                    String m7700a2 = qg0.m7700a(jSONObject.getString("value"), User.m5527u(context));
                                    if (m7700a2 == null) {
                                        gj0.m4142c(TAG, "Backup decryption failed for: " + ((ConfigField) queryForEq.get(0)).name);
                                    } else {
                                        i = 0;
                                        m5462h(((ConfigField) queryForEq.get(0)).name, m7700a2, context);
                                        i3++;
                                        i2 = i;
                                        m5404d = dao;
                                        m5404d2 = dao2;
                                    }
                                }
                            }
                            i = 0;
                            i3++;
                            i2 = i;
                            m5404d = dao;
                            m5404d2 = dao2;
                        }
                    }
                    dao = m5404d;
                    dao2 = m5404d2;
                    i = i2;
                    i3++;
                    i2 = i;
                    m5404d = dao;
                    m5404d2 = dao2;
                }
            }
        } catch (qg0.C1762a e) {
            gj0.m4142c(TAG, "Failed importing config: Bad AES decyrption password");
            e.printStackTrace();
        } catch (SQLException e2) {
            gj0.m4142c(TAG, "Failed importing config: " + e2.getMessage());
        } catch (JSONException e3) {
            gj0.m4142c(TAG, "Failed importing config: " + e3.getMessage());
        }
    }

    /* renamed from: h */
    public static void m5462h(String str, String str2, Context context) {
        ConfigValue configValue;
        try {
            List queryForEq = C1328DB.m5404d(ConfigField.class, context).queryForEq("name", str);
            if (queryForEq != null && queryForEq.size() >= 1) {
                List queryForEq2 = C1328DB.m5404d(ConfigValue.class, context).queryForEq("field_id", queryForEq.get(0));
                if (queryForEq2 != null && queryForEq2.size() >= 1) {
                    configValue = (ConfigValue) queryForEq2.get(0);
                    configValue.field = (ConfigField) queryForEq.get(0);
                    configValue.value = str2;
                    C1328DB.m5404d(ConfigValue.class, context).createOrUpdate(configValue);
                    return;
                }
                configValue = new ConfigValue();
                configValue.field = (ConfigField) queryForEq.get(0);
                configValue.value = str2;
                C1328DB.m5404d(ConfigValue.class, context).createOrUpdate(configValue);
                return;
            }
            gj0.m4142c(TAG, "Tried to set config for unknown field: " + str);
        } catch (SQLException unused) {
            gj0.m4142c(TAG, "Failed to update config value for: " + str);
        }
    }

    /* renamed from: i */
    public static boolean m5463i(ConfigField configField) {
        String str;
        if (configField == null || (str = configField.name) == null || str.contains("last:") || configField.name.contains("session:") || configField.name.contains("cloudsync:") || configField.name.equals("terminal:font_size")) {
            return true;
        }
        return configField.name.contains("version:");
    }
}

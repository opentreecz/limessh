package com.sonelli.juicessh.models;

import android.content.Context;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.gj0;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.p002db.DAO;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DatabaseTable(daoClass = DAO.class, tableName = "deleteditem")
/* loaded from: classes.dex */
public class DeletedItem extends BaseModel<DeletedItem> {
    public static final String TAG = "Models/DeletedItem";

    /* renamed from: r */
    public static JSONArray m5478r(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (DeletedItem deletedItem : C1328DB.m5404d(DeletedItem.class, context).queryForAll()) {
                if (deletedItem != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", deletedItem.f3993id.toString());
                    jSONObject.put("modified", deletedItem.modified);
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
}

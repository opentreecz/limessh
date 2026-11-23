package com.sonelli.juicessh.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sonelli.gj0;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.DAO;
import org.json.JSONException;
import org.json.JSONObject;

@DatabaseTable(daoClass = DAO.class, tableName = "purchase")
/* loaded from: classes.dex */
public class Purchase extends BaseModel<Purchase> {
    public String data;

    @DatabaseField
    public String order;

    @DatabaseField
    public String product;
    public String signature;

    @DatabaseField
    public Integer state;

    @DatabaseField
    public Long time;
    public String token;

    @DatabaseField(foreign = true)
    public User user;

    public Purchase() {
    }

    public Purchase(String str, String str2) {
        this.data = str;
        this.signature = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.order = jSONObject.getString("orderId");
            this.product = jSONObject.getString("productId");
            this.time = Long.valueOf(jSONObject.getLong("purchaseTime"));
            this.state = Integer.valueOf(jSONObject.getInt("purchaseState"));
            this.token = jSONObject.getString("purchaseToken");
        } catch (JSONException e) {
            gj0.m4142c(BaseModel.TAG, "Unable to parse incoming purchase");
            e.printStackTrace();
        }
    }

    public Purchase(String str, String str2, int i, Long l, User user) {
        this.order = str;
        this.product = str2;
        this.state = Integer.valueOf(i);
        this.time = l;
        this.user = user;
    }
}

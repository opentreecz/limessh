package com.sonelli.juicessh.p002db;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.sonelli.gj0;
import com.sonelli.juicessh.models.Team;
import com.sonelli.juicessh.models.TeamEncryption;
import com.sonelli.juicessh.models.User;
import com.sonelli.pi0;
import com.sonelli.qg0;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaseModel<T> extends BaseDaoEnabled<T, UUID> {
    public static final String TAG = "Models/BaseModel";

    @DatabaseField
    public String encrypted;

    /* renamed from: id */
    @DatabaseField(m1913id = true, index = true)
    public UUID f3993id = UUID.randomUUID();

    @DatabaseField
    public boolean isEncrypted;

    @DatabaseField(foreign = true)
    public User lastUpdatedBy;

    @DatabaseField
    public long modified;

    @DatabaseField(foreign = true)
    public User owner;

    public BaseModel() {
        new HashMap();
    }

    /* renamed from: k */
    public void m5381k(final Context context) {
        if (context == null || getClass().getName().equals("com.sonelli.juicessh.models.User") || getClass().getName().equals("com.sonelli.juicessh.models.Purchase") || getClass().getName().equals("com.sonelli.juicessh.models.DeletedItem") || getClass().getName().equals("com.sonelli.juicessh.models.ImageCache")) {
            return;
        }
        new Thread(new Runnable() { // from class: com.sonelli.juicessh.db.BaseModel.1
            @Override // java.lang.Runnable
            public void run() {
                pi0.m7331j(context, new pi0.AbstractC1720p() { // from class: com.sonelli.juicessh.db.BaseModel.1.1
                    @Override // com.sonelli.pi0.AbstractC1720p
                    /* renamed from: b */
                    public void mo3229b(User user) {
                        super.mo3229b(user);
                        RunnableC13271 runnableC13271 = RunnableC13271.this;
                        BaseModel.this.m5382l(context, false, user);
                    }
                });
            }
        }).start();
    }

    /* renamed from: l */
    public <T extends BaseModel<?>> void m5382l(Context context, boolean z, User user) {
        if (z) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.sonelli.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 2));
        }
        if (getClass().getName().equals("com.sonelli.juicessh.models.User")) {
            return;
        }
        JSONObject m5385q = m5385q(context);
        gj0.m4141b(TAG, "Performing encryption of: " + getClass().getName() + " / " + this.f3993id.toString());
        try {
            this.encrypted = qg0.m7702c(m5385q.toString(), User.m5527u(context));
            if (user == null || user.passwordUpdated <= this.modified) {
                C1328DB.m5404d(getClass(), context).m5399s(this);
            } else {
                C1328DB.m5404d(getClass(), context).update(this);
            }
        } catch (SQLException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: m */
    public T m5383m() {
        try {
            if (this.modified >= 1) {
                return this;
            }
            if (super.refresh() > 0) {
                return this;
            }
            return null;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: o */
    public void m5384o(Team team, Context context) {
        TeamEncryption teamEncryption;
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.sonelli.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 2));
        JSONObject m5385q = m5385q(context);
        try {
            DAO m5404d = C1328DB.m5404d(TeamEncryption.class, context);
            List query = m5404d.query(m5404d.queryBuilder().where().m1916eq("item", this.f3993id).and().m1916eq("team_id", team).prepare());
            if (query.size() > 0) {
                teamEncryption = (TeamEncryption) query.get(0);
                if (((TeamEncryption) query.get(0)).revision == this.modified) {
                    return;
                }
            } else {
                teamEncryption = new TeamEncryption();
            }
            gj0.m4141b(TAG, "Performing team encryption of: " + getClass().getName() + " / " + this.f3993id.toString());
            String m5508t = team.m5508t(context);
            if (m5508t == null) {
                return;
            }
            if (!qg0.m7700a(team.encryptionTest, m5508t).equals("JuiceSSH")) {
                throw new qg0.C1762a();
            }
            teamEncryption.team = team;
            teamEncryption.item = this.f3993id;
            teamEncryption.type = getClass().getName();
            teamEncryption.data = qg0.m7702c(m5385q.toString(), m5508t);
            teamEncryption.revision = this.modified;
            m5404d.createOrUpdate(teamEncryption);
        } catch (qg0.C1762a | SQLException unused) {
        }
    }

    /* renamed from: q */
    public <T extends BaseModel<?>> JSONObject m5385q(Context context) {
        DAO m5404d = C1328DB.m5404d(getClass(), context);
        JSONObject jSONObject = new JSONObject();
        for (FieldType fieldType : m5404d.getTableInfo().getFieldTypes()) {
            try {
                if (!fieldType.getFieldName().equals("id") && !fieldType.getFieldName().equals("modified") && !fieldType.getFieldName().equals("encrypted")) {
                    if (fieldType.getForeignIdField() != null) {
                        Object obj = getClass().getField(fieldType.getFieldName()).get(this);
                        if (obj != null) {
                            if (obj.getClass().getName().equals("java.lang.String")) {
                                jSONObject.put(fieldType.getFieldName(), obj);
                            } else {
                                UUID uuid = (UUID) obj.getClass().getField("id").get(obj);
                                if (uuid != null) {
                                    jSONObject.put(fieldType.getFieldName(), uuid.toString());
                                } else {
                                    jSONObject.put(fieldType.getFieldName(), (Object) null);
                                }
                            }
                        }
                    } else {
                        jSONObject.put(fieldType.getFieldName(), getClass().getField(fieldType.getFieldName()).get(this));
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | JSONException unused) {
            }
        }
        return jSONObject;
    }
}

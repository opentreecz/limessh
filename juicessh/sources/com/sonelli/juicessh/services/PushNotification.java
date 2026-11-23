package com.sonelli.juicessh.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.sonelli.AbstractIntentServiceC1535m3;
import com.sonelli.C1631o3;
import com.sonelli.gj0;
import com.sonelli.juicessh.models.TeamMembership;
import com.sonelli.juicessh.models.User;
import com.sonelli.pi0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PushNotification extends AbstractIntentServiceC1535m3 {

    /* renamed from: com.sonelli.juicessh.services.PushNotification$a */
    /* loaded from: classes.dex */
    public class C1388a extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ JSONObject f4222a;

        /* renamed from: b */
        public final /* synthetic */ JSONObject f4223b;

        /* renamed from: c */
        public final /* synthetic */ JSONObject f4224c;

        /* renamed from: d */
        public final /* synthetic */ Context f4225d;

        public C1388a(PushNotification pushNotification, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Context context) {
            this.f4222a = jSONObject;
            this.f4223b = jSONObject2;
            this.f4224c = jSONObject3;
            this.f4225d = context;
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            TeamMembership.m5514u(this.f4222a, this.f4223b, this.f4224c, user, this.f4225d);
            super.mo3229b(user);
        }
    }

    /* renamed from: k */
    public static void m5642k(Context context) {
        try {
            C1631o3.m6842a(context);
            C1631o3.m6843b(context);
            if (C1631o3.m6850i(context).equals("")) {
                C1631o3.m6854m(context, "425124909500");
            }
            pi0.m7336o(context, C1631o3.m6850i(context));
        } catch (UnsupportedOperationException unused) {
            gj0.m4142c("Services/PushNotification", "Push notifications not supported - GCM not present");
        }
    }

    @Override // com.sonelli.AbstractIntentServiceC1535m3
    /* renamed from: b */
    public String[] mo5643b(Context context) {
        try {
            return super.mo5643b(context);
        } catch (IllegalStateException unused) {
            return new String[]{"425124909500"};
        }
    }

    @Override // com.sonelli.AbstractIntentServiceC1535m3
    /* renamed from: e */
    public void mo5644e(Context context, String str) {
        gj0.m4141b("Services/PushNotification", "GDM onError: " + str);
    }

    @Override // com.sonelli.AbstractIntentServiceC1535m3
    /* renamed from: f */
    public void mo5645f(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            gj0.m4142c("Services/PushNotification", "Recieved a push notification with on bundled data");
            return;
        }
        try {
            int parseInt = Integer.parseInt((String) extras.get(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE));
            if (parseInt < 1) {
                gj0.m4142c("Services/PushNotification", "Recieved a push notification without a set type");
                return;
            }
            if (parseInt != 1) {
                if (parseInt != 2) {
                    return;
                }
                gj0.m4141b("Services/PushNotification", "Received a remote CloudSync request");
                CloudSync.m5627g(context);
                return;
            }
            gj0.m4141b("Services/PushNotification", "Recieved a team membership request");
            try {
                pi0.m7331j(context, new C1388a(this, new JSONObject(extras.getString("membership")), new JSONObject(extras.getString("team")), new JSONObject(extras.getString("requestor")), context));
            } catch (NullPointerException e) {
                gj0.m4142c("Services/PushNotification", "Invalid teamshare request (npe)");
                e.printStackTrace();
            } catch (JSONException e2) {
                gj0.m4142c("Services/PushNotification", "Invalid teamshare request (json)");
                e2.printStackTrace();
            }
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            gj0.m4142c("Services/PushNotification", "Recieved a push notification without a set type");
        }
    }

    @Override // com.sonelli.AbstractIntentServiceC1535m3
    /* renamed from: h */
    public void mo5646h(Context context, String str) {
        gj0.m4141b("Services/PushNotification", "Got registration");
        pi0.m7336o(context, str);
    }

    @Override // com.sonelli.AbstractIntentServiceC1535m3
    /* renamed from: i */
    public void mo5647i(Context context, String str) {
        gj0.m4141b("Services/PushNotification", "GDM onUnregistered: " + str);
    }
}

package cz.opentree;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.j256.ormlite.field.FieldType;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.AuthenticationMigrationActivity;
import cz.opentree.juicessh.activities.ChangelogActivity;
import cz.opentree.juicessh.activities.MainActivity;
import cz.opentree.juicessh.activities.ReauthenticateActivity;
import cz.opentree.juicessh.controllers.ApplicationClass;
import cz.opentree.juicessh.models.Book;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.models.DeletedItem;
import cz.opentree.juicessh.models.Plugin;
import cz.opentree.juicessh.models.Purchase;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.p002db.DAO;
import cz.opentree.juicessh.services.CloudSync;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: API.java */
/* loaded from: classes.dex */
public class pi0 {

    /* renamed from: a */
    public static final AtomicInteger f5669a = new AtomicInteger(0);

    /* renamed from: b */
    public static User f5670b;

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$a */
    /* loaded from: classes.dex */
    public static class C1705a extends zg0 {

        /* renamed from: c */
        public boolean f5671c = false;

        /* renamed from: d */
        public boolean f5672d = true;

        /* renamed from: e */
        public ArrayList<Plugin> f5673e = new ArrayList<>();

        /* renamed from: f */
        public final /* synthetic */ SharedPreferences f5674f;

        /* renamed from: g */
        public final /* synthetic */ AtomicBoolean f5675g;

        /* renamed from: h */
        public final /* synthetic */ AbstractC1719o f5676h;

        public C1705a(SharedPreferences sharedPreferences, AtomicBoolean atomicBoolean, AbstractC1719o abstractC1719o) {
            this.f5674f = sharedPreferences;
            this.f5675g = atomicBoolean;
            this.f5676h = abstractC1719o;
        }

        @Override // cz.opentree.yg0
        /* renamed from: g */
        public void mo7341g(Throwable th, String str) {
            super.mo7341g(th, str);
            m10131a();
            if (m10131a() > 0 && m10131a() != 200) {
                this.f5672d = false;
            } else if (th instanceof JSONException) {
                this.f5672d = false;
            }
        }

        @Override // cz.opentree.yg0
        /* renamed from: h */
        public void mo7342h() {
            super.mo7342h();
            if (this.f5675g.get()) {
                return;
            }
            if (this.f5671c) {
                this.f5676h.mo3232c(this.f5673e);
            } else if (this.f5672d) {
                this.f5676h.mo3231b();
            } else {
                this.f5676h.mo3230a();
            }
        }

        @Override // cz.opentree.zg0
        /* renamed from: t */
        public void mo5232t(JSONArray jSONArray) {
            super.mo5232t(jSONArray);
            SharedPreferences.Editor edit = this.f5674f.edit();
            edit.putString("plugins_list", jSONArray.toString());
            edit.commit();
            gj0.m4141b("API", "Successfully updated cached plugin list from API");
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.f5673e.add(Plugin.m5483g(jSONArray.getJSONObject(i)));
                } catch (JSONException unused) {
                    gj0.m4142c("API", "Could not parse JSON response from API plugins list");
                    return;
                }
            }
            this.f5671c = true;
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$b */
    /* loaded from: classes.dex */
    public static class C1706b extends zg0 {

        /* renamed from: c */
        public boolean f5677c = false;

        /* renamed from: d */
        public boolean f5678d = true;

        /* renamed from: e */
        public ArrayList<Book> f5679e = new ArrayList<>();

        /* renamed from: f */
        public final /* synthetic */ SharedPreferences f5680f;

        /* renamed from: g */
        public final /* synthetic */ AtomicBoolean f5681g;

        /* renamed from: h */
        public final /* synthetic */ AbstractC1716l f5682h;

        public C1706b(SharedPreferences sharedPreferences, AtomicBoolean atomicBoolean, AbstractC1716l abstractC1716l) {
            this.f5680f = sharedPreferences;
            this.f5681g = atomicBoolean;
            this.f5682h = abstractC1716l;
        }

        @Override // cz.opentree.yg0
        /* renamed from: g */
        public void mo7341g(Throwable th, String str) {
            super.mo7341g(th, str);
            m10131a();
            if (m10131a() > 0 && m10131a() != 200) {
                this.f5678d = false;
            } else if (th instanceof JSONException) {
                this.f5678d = false;
            }
        }

        @Override // cz.opentree.yg0
        /* renamed from: h */
        public void mo7342h() {
            super.mo7342h();
            if (this.f5681g.get()) {
                return;
            }
            if (this.f5677c) {
                this.f5682h.mo2530c(this.f5679e);
            } else if (this.f5678d) {
                this.f5682h.mo2529b();
            } else {
                this.f5682h.mo2528a();
            }
        }

        @Override // cz.opentree.zg0
        /* renamed from: t */
        public void mo5232t(JSONArray jSONArray) {
            super.mo5232t(jSONArray);
            SharedPreferences.Editor edit = this.f5680f.edit();
            edit.putString("bookclub_list", jSONArray.toString());
            edit.commit();
            gj0.m4141b("API", "Successfully updated cached bookclub list from API");
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.f5679e.add(Book.m5449f(jSONArray.getJSONObject(i)));
                } catch (JSONException unused) {
                    gj0.m4142c("API", "Could not parse JSON response from API bookclub list");
                    return;
                }
            }
            this.f5677c = true;
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$c */
    /* loaded from: classes.dex */
    public static class C1707c extends zg0 {

        /* renamed from: c */
        public final /* synthetic */ Context f5683c;

        /* renamed from: d */
        public final /* synthetic */ AbstractC1718n f5684d;

        public C1707c(Context context, AbstractC1718n abstractC1718n) {
            this.f5683c = context;
            this.f5684d = abstractC1718n;
        }

        @Override // cz.opentree.yg0
        /* renamed from: h */
        public void mo7342h() {
            super.mo7342h();
            gj0.m4141b("API", "Submitted purchase to API for verification (response: " + m10131a() + ")");
            if (m10131a() != 200) {
                AbstractC1718n abstractC1718n = this.f5684d;
                if (abstractC1718n != null) {
                    abstractC1718n.mo5421a();
                    return;
                }
                return;
            }
            pi0.m7335n(this.f5683c);
            AbstractC1718n abstractC1718n2 = this.f5684d;
            if (abstractC1718n2 != null) {
                abstractC1718n2.mo5422c();
            }
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$d */
    /* loaded from: classes.dex */
    public static class C1708d extends AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ String f5685a;

        /* renamed from: b */
        public final /* synthetic */ Context f5686b;

        /* compiled from: API.java */
        /* renamed from: cz.opentree.pi0$d$a */
        /* loaded from: classes.dex */
        public class a extends yg0 {
            public a() {
            }

            @Override // cz.opentree.yg0
            /* renamed from: h */
            public void mo7342h() {
                super.mo7342h();
                if (m10131a() == 401) {
                    pi0.m7335n(C1708d.this.f5686b);
                }
            }
        }

        public C1708d(String str, Context context) {
            this.f5685a = str;
            this.f5686b = context;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            ah0 ah0Var = new ah0();
            ah0Var.m2070e("device", this.f5685a);
            ah0Var.m2070e("make", Build.MANUFACTURER);
            ah0Var.m2070e("model", Build.MODEL);
            ah0Var.m2070e("serial", Build.SERIAL);
            wg0 wg0Var = new wg0();
            wg0Var.m9518p(pi0.m7332k(this.f5686b));
            wg0Var.m9505c("Cookie", "session=" + user.sessionIdentifier);
            wg0Var.m9514l("https://api.sonelli.com/devices", ah0Var, new a());
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$e */
    /* loaded from: classes.dex */
    public static class C1709e extends zg0 {

        /* renamed from: c */
        public boolean f5688c = false;

        /* renamed from: d */
        public final /* synthetic */ LocalBroadcastManager f5689d;

        /* renamed from: e */
        public final /* synthetic */ Context f5690e;

        /* renamed from: f */
        public final /* synthetic */ User f5691f;

        /* renamed from: g */
        public final /* synthetic */ CloudSync.AbstractC1376i f5692g;

        /* renamed from: h */
        public final /* synthetic */ AbstractC1718n f5693h;

        public C1709e(LocalBroadcastManager localBroadcastManager, Context context, User user, CloudSync.AbstractC1376i abstractC1376i, AbstractC1718n abstractC1718n) {
            this.f5689d = localBroadcastManager;
            this.f5690e = context;
            this.f5691f = user;
            this.f5692g = abstractC1376i;
            this.f5693h = abstractC1718n;
        }

        @Override // cz.opentree.yg0
        /* renamed from: g */
        public void mo7341g(Throwable th, String str) {
            super.mo7341g(th, str);
            this.f5688c = false;
            gj0.m4142c("API", "CloudSync failed: " + th.getMessage());
            mo7342h();
        }

        @Override // cz.opentree.yg0
        /* renamed from: h */
        public void mo7342h() {
            super.mo7342h();
            if (m10131a() == 401) {
                this.f5688c = false;
                pi0.m7335n(this.f5690e);
            }
            if (this.f5688c) {
                this.f5689d.sendBroadcast(new Intent("cz.opentree.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 7));
            } else {
                this.f5689d.sendBroadcast(new Intent("cz.opentree.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 8));
            }
            AbstractC1718n abstractC1718n = this.f5693h;
            if (abstractC1718n != null) {
                abstractC1718n.mo5630b();
            }
        }

        @Override // cz.opentree.yg0
        /* renamed from: j */
        public void mo7343j(String str) {
            super.mo7343j(str);
            Intent putExtra = new Intent("cz.opentree.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 4);
            this.f5689d.sendBroadcast(putExtra);
            C1328DB.m5404d(DeletedItem.class, this.f5690e).m5400t();
            try {
                CloudSync.m5626f(new JSONObject(str), this.f5691f, this.f5690e, this.f5692g);
                Config.m5462h("last:cloudsync", String.valueOf(System.currentTimeMillis() / 1000), this.f5690e);
                gj0.m4141b("API", "Cloudsync completed successfully");
                this.f5688c = true;
                new Intent("cz.opentree.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 7);
                this.f5689d.sendBroadcast(putExtra);
                AbstractC1718n abstractC1718n = this.f5693h;
                if (abstractC1718n != null) {
                    abstractC1718n.mo5422c();
                }
            } catch (CloudSync.C1375h unused) {
                gj0.m4141b("API", "CloudSync cancelled");
                this.f5688c = false;
                new Intent("cz.opentree.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 8);
                this.f5689d.sendBroadcast(putExtra);
                AbstractC1718n abstractC1718n2 = this.f5693h;
                if (abstractC1718n2 != null) {
                    abstractC1718n2.mo5630b();
                }
            } catch (JSONException unused2) {
                gj0.m4141b("API", "Could not parse CloudSync JSON response");
            }
        }

        @Override // cz.opentree.zg0
        /* renamed from: s */
        public void mo7344s(Throwable th, JSONObject jSONObject) {
            super.mo7344s(th, jSONObject);
            this.f5688c = false;
            gj0.m4142c("API", "Cloudsync failed: " + th.getMessage());
            mo7342h();
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$f */
    /* loaded from: classes.dex */
    public static class C1710f extends yg0 {

        /* renamed from: c */
        public final /* synthetic */ AbstractC1718n f5694c;

        public C1710f(AbstractC1718n abstractC1718n) {
            this.f5694c = abstractC1718n;
        }

        @Override // cz.opentree.yg0
        /* renamed from: g */
        public void mo7341g(Throwable th, String str) {
            super.mo7341g(th, str);
            AbstractC1718n abstractC1718n = this.f5694c;
            if (abstractC1718n != null) {
                abstractC1718n.mo5421a();
            }
        }

        @Override // cz.opentree.yg0
        /* renamed from: j */
        public void mo7343j(String str) {
            super.mo7343j(str);
            AbstractC1718n abstractC1718n = this.f5694c;
            if (abstractC1718n != null) {
                abstractC1718n.mo5422c();
            }
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$g */
    /* loaded from: classes.dex */
    public static class C1711g implements OnCompleteListener<GoogleSignInAccount> {

        /* renamed from: a */
        public final /* synthetic */ Context f5695a;

        /* renamed from: b */
        public final /* synthetic */ String f5696b;

        /* renamed from: c */
        public final /* synthetic */ AbstractC1720p f5697c;

        /* compiled from: API.java */
        /* renamed from: cz.opentree.pi0$g$a */
        /* loaded from: classes.dex */
        public class a extends zg0 {

            /* renamed from: c */
            public final /* synthetic */ String f5698c;

            public a(String str) {
                this.f5698c = str;
            }

            @Override // cz.opentree.yg0
            /* renamed from: g */
            public void mo7341g(Throwable th, String str) {
                C1711g c1711g;
                AbstractC1720p abstractC1720p;
                super.mo7341g(th, str);
                gj0.m4142c("API", "Failed to authenticate with API: " + th.getMessage());
                if (pi0.f5670b != null || (abstractC1720p = (c1711g = C1711g.this).f5697c) == null) {
                    return;
                }
                abstractC1720p.mo3228a(c1711g.f5695a.getString(R.string.authentication_failure));
            }

            @Override // cz.opentree.yg0
            /* renamed from: h */
            public void mo7342h() {
                C1711g c1711g;
                AbstractC1720p abstractC1720p;
                super.mo7342h();
                if (m10131a() != 200) {
                    gj0.m4141b("API", "API HTTP Response code: " + m10131a());
                }
                if (m10131a() != 403 || pi0.f5669a.get() >= 3) {
                    pi0.f5669a.set(0);
                } else {
                    pi0.f5669a.incrementAndGet();
                    gj0.m4141b("API", "Retrying authentication (attempt " + pi0.f5669a.get() + "/3)...");
                    C1711g c1711g2 = C1711g.this;
                    pi0.m7326e(c1711g2.f5695a, this.f5698c, null, c1711g2.f5697c);
                }
                if (pi0.f5670b != null || (abstractC1720p = (c1711g = C1711g.this).f5697c) == null) {
                    return;
                }
                abstractC1720p.mo3228a(c1711g.f5695a.getString(R.string.authentication_failure));
            }

            @Override // cz.opentree.zg0
            /* renamed from: u */
            public void mo7345u(JSONObject jSONObject) {
                super.mo7345u(jSONObject);
                try {
                    try {
                        if (jSONObject.getString(NotificationCompat.CATEGORY_EMAIL).length() <= 0) {
                            gj0.m4142c("API", "Unable to parse session identifier from API response");
                            C1711g c1711g = C1711g.this;
                            AbstractC1720p abstractC1720p = c1711g.f5697c;
                            if (abstractC1720p != null) {
                                abstractC1720p.mo3228a(c1711g.f5695a.getString(R.string.authentication_failure));
                                return;
                            }
                            return;
                        }
                        User user = (User) C1328DB.m5404d(User.class, C1711g.this.f5695a).queryForId(UUID.fromString(jSONObject.getString(FieldType.FOREIGN_ID_FIELD_SUFFIX)));
                        if (user == null) {
                            gj0.m4141b("API", "User not found in local DB - creating...");
                            user = new User();
                            user.f3993id = UUID.fromString(jSONObject.getString(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                            user.purchases = C1328DB.m5404d(User.class, C1711g.this.f5695a).getEmptyForeignCollection("purchases");
                        }
                        User user2 = user;
                        user2.email = jSONObject.getString(NotificationCompat.CATEGORY_EMAIL);
                        try {
                            user2.name = jSONObject.getString("name");
                        } catch (JSONException unused) {
                            user2.name = "";
                        }
                        try {
                            user2.given_name = jSONObject.getString("given_name");
                        } catch (JSONException unused2) {
                            user2.given_name = "";
                        }
                        try {
                            user2.family_name = jSONObject.getString("family_name");
                        } catch (JSONException unused3) {
                            user2.family_name = "";
                        }
                        try {
                            user2.picture = jSONObject.getString("picture");
                        } catch (JSONException unused4) {
                        }
                        user2.sessionIdentifier = jSONObject.getJSONObject("session").getString("identifier");
                        user2.sessionExpires = Long.parseLong(jSONObject.getJSONObject("session").getString("expires"));
                        user2.passwordUpdated = Long.parseLong(jSONObject.getString("passwordUpdated"));
                        user2.signature = jSONObject.getString("signature");
                        user2.disabled = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                        user2.encryptionTest = jSONObject.getString("encryptionTest");
                        DAO m5404d = C1328DB.m5404d(Purchase.class, C1711g.this.f5695a);
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject.getJSONArray("purchases");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            arrayList.add(new Purchase(jSONObject2.getString("order"), jSONObject2.getString("product"), Integer.valueOf(jSONObject2.getInt("state")).intValue(), Long.valueOf(jSONObject2.getLong("time")), user2));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Purchase purchase : user2.purchases) {
                            Iterator it = arrayList.iterator();
                            boolean z = false;
                            while (it.hasNext()) {
                                if (purchase.order.equals(((Purchase) it.next()).order)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                arrayList2.add(purchase);
                            } else {
                                m5404d.m5392k(purchase);
                                user2.purchases.remove(purchase);
                            }
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            Purchase purchase2 = (Purchase) it2.next();
                            Iterator it3 = arrayList2.iterator();
                            boolean z2 = false;
                            while (it3.hasNext()) {
                                if (((Purchase) it3.next()).order.equals(purchase2.order)) {
                                    z2 = true;
                                }
                            }
                            if (!z2) {
                                user2.purchases.add(purchase2);
                            }
                        }
                        if (!user2.m5531H() || user2.disabled.booleanValue()) {
                            gj0.m4142c("API", "User failed signature verification or disabled");
                            if (pi0.f5670b != null) {
                                User unused5 = pi0.f5670b = null;
                                pi0.m7335n(C1711g.this.f5695a);
                            }
                            C1711g c1711g2 = C1711g.this;
                            AbstractC1720p abstractC1720p2 = c1711g2.f5697c;
                            if (abstractC1720p2 != null) {
                                abstractC1720p2.mo3228a(c1711g2.f5695a.getString(R.string.account_disabled));
                                return;
                            }
                            return;
                        }
                        String str = user2.encryptionTest;
                        if (str == null || str.length() < 1) {
                            pi0.m7338q(user2, C1711g.this.f5695a);
                        }
                        User unused6 = pi0.f5670b = user2;
                        C1328DB.m5404d(User.class, C1711g.this.f5695a).createOrUpdate(user2);
                        AbstractC1720p abstractC1720p3 = C1711g.this.f5697c;
                        if (abstractC1720p3 != null) {
                            abstractC1720p3.mo3229b(user2);
                        }
                    } catch (SQLException e) {
                        gj0.m4142c("API", "SQL Error: " + e.getMessage());
                        C1711g c1711g3 = C1711g.this;
                        AbstractC1720p abstractC1720p4 = c1711g3.f5697c;
                        if (abstractC1720p4 != null) {
                            abstractC1720p4.mo3228a(c1711g3.f5695a.getString(R.string.authentication_failure));
                        }
                    }
                } catch (JSONException e2) {
                    gj0.m4142c("API", "Failed to parse API JSON: " + e2.getMessage());
                    C1711g c1711g4 = C1711g.this;
                    AbstractC1720p abstractC1720p5 = c1711g4.f5697c;
                    if (abstractC1720p5 != null) {
                        abstractC1720p5.mo3228a(c1711g4.f5695a.getString(R.string.authentication_failure));
                    }
                }
            }
        }

        public C1711g(Context context, String str, AbstractC1720p abstractC1720p) {
            this.f5695a = context;
            this.f5696b = str;
            this.f5697c = abstractC1720p;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        /* renamed from: a */
        public void mo1554a(@NonNull j60<GoogleSignInAccount> j60Var) {
            AbstractC1720p abstractC1720p;
            try {
                String m895b0 = j60Var.mo2698k(C1029g7.class).m895b0();
                wg0 wg0Var = new wg0();
                wg0Var.m9518p(pi0.m7332k(this.f5695a));
                wg0Var.m9517o(30000);
                if (this.f5696b != null) {
                    wg0Var.m9505c("Cookie", "session=" + this.f5696b);
                }
                wg0Var.m9509g("https://api.sonelli.com/googleauth/" + m895b0, new a(m895b0));
            } catch (C1029g7 e) {
                gj0.m4142c("API", "Failed to obtain OAUTH2 token: " + e.getMessage());
                gj0.m4142c("API", "Exception OAUTH2 code: " + e.m4058a());
                if (e.m4058a() == 4) {
                    gj0.m4142c("API", "Interactive Google SignIn Required");
                    AbstractC1720p abstractC1720p2 = this.f5697c;
                    if (abstractC1720p2 != null) {
                        abstractC1720p2.mo3228a("Reauthentication with Google required");
                    }
                    Context context = this.f5695a;
                    if (!(context instanceof MainActivity) && !(context instanceof ChangelogActivity) && !(context instanceof AuthenticationMigrationActivity) && (context instanceof Activity)) {
                        ((Activity) this.f5695a).startActivity(new Intent((Activity) this.f5695a, (Class<?>) ReauthenticateActivity.class));
                    }
                }
                e.printStackTrace();
                if (pi0.f5670b != null || (abstractC1720p = this.f5697c) == null) {
                    return;
                }
                abstractC1720p.mo3228a(e.getMessage());
            }
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$h */
    /* loaded from: classes.dex */
    public static class C1712h extends yg0 {
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$i */
    /* loaded from: classes.dex */
    public static class C1713i extends yg0 {
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$j */
    /* loaded from: classes.dex */
    public static class C1714j extends AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ BlockingQueue f5700a;

        public C1714j(BlockingQueue blockingQueue) {
            this.f5700a = blockingQueue;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            super.mo3228a(str);
            try {
                this.f5700a.put(new User());
            } catch (InterruptedException unused) {
            }
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            try {
                this.f5700a.put(user);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$k */
    /* loaded from: classes.dex */
    public static class C1715k extends AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ Context f5701a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC1717m f5702b;

        /* compiled from: API.java */
        /* renamed from: cz.opentree.pi0$k$a */
        /* loaded from: classes.dex */
        public class a extends zg0 {

            /* renamed from: c */
            public boolean f5703c = false;

            /* renamed from: d */
            public JSONObject f5704d;

            public a() {
            }

            @Override // cz.opentree.yg0
            /* renamed from: h */
            public void mo7342h() {
                super.mo7342h();
                if (this.f5703c) {
                    C1715k.this.f5702b.mo5424b(this.f5704d);
                } else {
                    C1715k.this.f5702b.mo5423a();
                }
            }

            @Override // cz.opentree.zg0
            /* renamed from: u */
            public void mo7345u(JSONObject jSONObject) {
                super.mo7345u(jSONObject);
                this.f5703c = true;
                this.f5704d = jSONObject;
            }
        }

        public C1715k(Context context, AbstractC1717m abstractC1717m) {
            this.f5701a = context;
            this.f5702b = abstractC1717m;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            super.mo3228a(str);
            this.f5702b.mo5423a();
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            wg0 wg0Var = new wg0();
            wg0Var.m9518p(pi0.m7332k(this.f5701a));
            wg0Var.m9505c("Cookie", "session=" + user.sessionIdentifier);
            wg0Var.m9508f(this.f5701a, "https://api.sonelli.com/cloudsync", null, new a());
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$l */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1716l {
        /* renamed from: a */
        public void mo2528a() {
        }

        /* renamed from: b */
        public void mo2529b() {
        }

        /* renamed from: c */
        public void mo2530c(List<Book> list) {
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$m */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1717m {
        /* renamed from: a */
        public void mo5423a() {
        }

        /* renamed from: b */
        public void mo5424b(JSONObject jSONObject) {
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$n */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1718n {
        /* renamed from: a */
        public void mo5421a() {
        }

        /* renamed from: b */
        public void mo5630b() {
        }

        /* renamed from: c */
        public void mo5422c() {
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$o */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1719o {
        /* renamed from: a */
        public void mo3230a() {
        }

        /* renamed from: b */
        public void mo3231b() {
        }

        /* renamed from: c */
        public void mo3232c(List<Plugin> list) {
        }
    }

    /* compiled from: API.java */
    /* renamed from: cz.opentree.pi0$p */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1720p {
        /* renamed from: a */
        public void mo3228a(String str) {
        }

        /* renamed from: b */
        public void mo3229b(User user) {
        }
    }

    /* renamed from: e */
    public static void m7326e(Context context, String str, String str2, AbstractC1720p abstractC1720p) {
        ((ApplicationClass) context.getApplicationContext()).m5371b().m5838p().mo2689b(new C1711g(context, str2, abstractC1720p));
    }

    /* renamed from: f */
    public static void m7327f(Context context, User user, JSONObject jSONObject, CloudSync.AbstractC1376i abstractC1376i, AbstractC1718n abstractC1718n) {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.sendBroadcast(new Intent("cz.opentree.juicessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 3));
        wg0 wg0Var = new wg0();
        wg0Var.m9518p(m7332k(context));
        wg0Var.m9505c("Cookie", "session=" + user.sessionIdentifier);
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(jSONObject.toString().getBytes());
        wg0Var.m9517o(60000);
        wg0Var.m9513k(context, "https://api.sonelli.com/cloudsync", byteArrayEntity, "application/json", new C1709e(localBroadcastManager, context, user, abstractC1376i, abstractC1718n));
    }

    /* renamed from: g */
    public static void m7328g(Context context, AbstractC1716l abstractC1716l) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putBoolean("bookclub:new", false).apply();
        String string = defaultSharedPreferences.getString("bookclub_list", "");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (string.isEmpty()) {
            gj0.m4141b("API", "No cached version of book list available - fetching from API...");
            atomicBoolean.set(false);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Book.m5449f(jSONArray.getJSONObject(i)));
                }
                atomicBoolean.set(true);
                gj0.m4141b("API", "Loaded book list from cache");
                abstractC1716l.mo2530c(arrayList);
            } catch (JSONException unused) {
                gj0.m4142c("API", "Cached book list corrupt/invalid");
                atomicBoolean.set(false);
            }
        }
        String country = context.getResources().getConfiguration().locale.getCountry();
        wg0 wg0Var = new wg0();
        wg0Var.m9518p(m7332k(context));
        wg0Var.m9505c("requested-location", country);
        wg0Var.m9508f(context, "https://api.sonelli.com/bookclub", null, new C1706b(defaultSharedPreferences, atomicBoolean, abstractC1716l));
    }

    /* renamed from: h */
    public static void m7329h(Context context, AbstractC1717m abstractC1717m) {
        m7331j(context, new C1715k(context, abstractC1717m));
    }

    /* renamed from: i */
    public static void m7330i(Context context, AbstractC1719o abstractC1719o) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putBoolean("plugins:new", false).apply();
        String string = defaultSharedPreferences.getString("plugins_list", "");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (string.isEmpty()) {
            gj0.m4141b("API", "No cached version of plugin list available - fetching from API...");
            atomicBoolean.set(false);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Plugin.m5483g(jSONArray.getJSONObject(i)));
                }
                atomicBoolean.set(true);
                gj0.m4141b("API", "Loaded plugin list from cache");
                abstractC1719o.mo3232c(arrayList);
            } catch (JSONException unused) {
                gj0.m4142c("API", "Cached plugin list corrupt/invalid");
                atomicBoolean.set(false);
            }
        }
        wg0 wg0Var = new wg0();
        wg0Var.m9518p(m7332k(context));
        wg0Var.m9508f(context, "https://api.sonelli.com/plugins", null, new C1705a(defaultSharedPreferences, atomicBoolean, abstractC1719o));
    }

    /* renamed from: j */
    public static void m7331j(Context context, AbstractC1720p abstractC1720p) {
        // [OfflineProFix merged] resolve the user locally, no network refresh
        // (was Xposed hook pi0.j(Context, pi0$p) => local callback)
        if (abstractC1720p == null) {
            return;
        }
        User user = null;
        try {
            if (context != null) {
                user = User.m5518A(context);
            }
        } catch (Throwable unused) {
            user = null;
        }
        if (user == null) {
            user = new User();
        }
        abstractC1720p.mo3229b(user);
    }

    public static void m7331j_original(Context context, AbstractC1720p abstractC1720p) {
        User user;
        User user2;
        String m5525s = User.m5525s(context);
        if (m5525s == null) {
            abstractC1720p.mo3228a(context.getString(R.string.authentication_failure));
            return;
        }
        if (m5525s.equals("New User")) {
            abstractC1720p.mo3228a("New User");
            return;
        }
        User user3 = f5670b;
        if (user3 != null && !user3.disabled.booleanValue()) {
            long currentTimeMillis = System.currentTimeMillis() - f5670b.modified;
            DateUtils.getRelativeTimeSpanString(System.currentTimeMillis() + (f5670b.m5533w() * 1000), System.currentTimeMillis(), 0L, 0);
            DateUtils.getRelativeTimeSpanString(System.currentTimeMillis() + (3600000 - currentTimeMillis), System.currentTimeMillis(), 0L, 0);
            if (f5670b.m5533w() <= 0) {
                gj0.m4141b("API", "Cached user's API session has expired - refreshing session...");
                m7326e(context, null, f5670b.sessionIdentifier, abstractC1720p);
                return;
            }
            abstractC1720p.mo3229b(f5670b);
            if (currentTimeMillis <= 3600000 || context == null || (user2 = f5670b) == null) {
                return;
            }
            m7326e(context, null, user2.sessionIdentifier, null);
            return;
        }
        User m5518A = User.m5518A(context);
        if (m5518A == null || m5518A.disabled.booleanValue() || !m5518A.m5531H()) {
            m7326e(context, null, null, abstractC1720p);
            return;
        }
        f5670b = m5518A;
        if (m5518A.m5533w() <= 0) {
            m7326e(context, null, f5670b.sessionIdentifier, abstractC1720p);
            return;
        }
        abstractC1720p.mo3229b(f5670b);
        if (context == null || (user = f5670b) == null) {
            return;
        }
        m7326e(context, null, user.sessionIdentifier, null);
    }

    /* renamed from: k */
    public static String m7332k(Context context) {
        return (("JuiceSSH/" + m7333l(context)) + " (Android " + Build.VERSION.SDK_INT + "; " + Build.MODEL + "; " + Locale.getDefault().toString() + ")") + " JuiceSSH (http://sonelli.com)";
    }

    /* renamed from: l */
    public static int m7333l(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            gj0.m4142c("API", "Could not determin application version");
            return -1;
        }
    }

    /* renamed from: m */
    public static boolean m7334m(Context context) {
        // [OfflineProFix merged] API user gate always passes (was Xposed hook pi0.m(Context) => true)
        return true;
    }

    public static boolean m7334m_original(Context context) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        User user = new User();
        m7331j(context, new C1714j(arrayBlockingQueue));
        try {
            user = (User) arrayBlockingQueue.take();
        } catch (InterruptedException unused) {
        }
        return oi0.m7047d(user);
    }

    /* renamed from: n */
    public static void m7335n(Context context) {
        User m5518A = User.m5518A(context);
        if (m5518A != null) {
            m5518A.sessionExpires = -1L;
            wg0 wg0Var = new wg0();
            wg0Var.m9518p(m7332k(context));
            wg0Var.m9505c("Cookie", "session=" + m5518A.sessionIdentifier);
            wg0Var.m9509g("https://api.sonelli.com/logout", new C1713i());
            try {
                C1328DB.m5404d(User.class, context).update(m5518A);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        f5670b = null;
    }

    /* renamed from: o */
    public static void m7336o(Context context, String str) {
        gj0.m4141b("API", "Registering device for cloud notifications...");
        m7331j(context, new C1708d(str, context));
    }

    /* renamed from: p */
    public static void m7337p(Context context, Purchase purchase, User user, AbstractC1718n abstractC1718n) {
        gj0.m4141b("API", "Submitting new purchase: " + purchase.order);
        User user2 = f5670b;
        if (user2 != null) {
            try {
                user2.purchases.add(purchase);
            } catch (IllegalStateException unused) {
            }
        }
        wg0 wg0Var = new wg0();
        wg0Var.m9518p(m7332k(context));
        wg0Var.m9505c("Cookie", "session=" + user.sessionIdentifier);
        ah0 ah0Var = new ah0();
        ah0Var.m2070e("transaction", purchase.data);
        ah0Var.m2070e("signature", purchase.signature);
        wg0Var.m9512j(context, "https://api.sonelli.com/purchase", ah0Var, new C1707c(context, abstractC1718n));
    }

    /* renamed from: q */
    public static void m7338q(User user, Context context) {
        wg0 wg0Var = new wg0();
        wg0Var.m9518p(m7332k(context));
        wg0Var.m9517o(30000);
        wg0Var.m9505c("Cookie", "session=" + user.sessionIdentifier);
        String m7702c = qg0.m7702c("JuiceSSH", User.m5527u(context));
        long currentTimeMillis = System.currentTimeMillis();
        user.encryptionTest = m7702c;
        user.passwordUpdated = currentTimeMillis;
        try {
            user.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user2 = f5670b;
        if (user2 != null) {
            user2.encryptionTest = m7702c;
            user2.passwordUpdated = currentTimeMillis;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("encryptionTest", user.encryptionTest);
            jSONObject.put("passwordUpdated", user.passwordUpdated);
        } catch (JSONException unused) {
        }
        wg0Var.m9515m(context, "https://api.sonelli.com/users/:" + user.f3993id, new ByteArrayEntity(jSONObject.toString().getBytes()), "application/json", new C1712h());
    }

    /* renamed from: r */
    public static void m7339r(Context context, User user) {
        m7340s(context, user, null);
    }

    /* renamed from: s */
    public static void m7340s(Context context, User user, AbstractC1718n abstractC1718n) {
        User user2 = f5670b;
        if (user2 != null) {
            user2.encryptionTest = "";
        }
        wg0 wg0Var = new wg0();
        wg0Var.m9518p(m7332k(context));
        wg0Var.m9517o(30000);
        wg0Var.m9505c("Cookie", "session=" + user.sessionIdentifier);
        wg0Var.m9506d(context, "https://api.sonelli.com/users/:" + user.f3993id, new C1710f(abstractC1718n));
    }
}

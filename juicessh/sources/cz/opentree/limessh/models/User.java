package cz.opentree.limessh.models;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.core.app.NotificationCompat;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.limessh.p002db.DAO;
import cz.opentree.pi0;
import cz.opentree.qg0;
import cz.opentree.sg0;
import cz.opentree.util.PasswordPrompt;
import cz.opentree.util.Session;
import cz.opentree.vg0;
import cz.opentree.zk0;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable(daoClass = DAO.class, tableName = "user")
/* loaded from: classes.dex */
public class User extends BaseModel<User> implements Comparable<User> {

    /* renamed from: O */
    public static String f4096O = null;
    public static final String TAG = "Model/User";

    @DatabaseField
    public Boolean disabled;

    @DatabaseField
    public String email;

    @DatabaseField
    public String encryptionTest;

    @DatabaseField
    public String family_name;

    @DatabaseField
    public String given_name;

    @DatabaseField
    public String name;

    @DatabaseField
    public long passwordUpdated = 0;

    @DatabaseField
    public String picture;

    @ForeignCollectionField(eager = true)
    public ForeignCollection<Purchase> purchases;

    @DatabaseField
    public long sessionExpires;

    @DatabaseField
    public String sessionIdentifier;

    @DatabaseField
    public String signature;

    /* renamed from: cz.opentree.limessh.models.User$1 */
    /* loaded from: classes.dex */
    public static class C13521 implements PasswordPrompt.PasswordPromptListener {

        /* renamed from: a */
        public final /* synthetic */ Activity f4097a;

        /* renamed from: b */
        public final /* synthetic */ OnPasswordChangedListener f4098b;

        public C13521(Activity activity, OnPasswordChangedListener onPasswordChangedListener) {
            this.f4097a = activity;
            this.f4098b = onPasswordChangedListener;
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        /* renamed from: a */
        public void mo5299a(final String str, boolean z) {
            new Thread(new Runnable() { // from class: cz.opentree.limessh.models.User.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Identity.m5479u(str, C13521.this.f4097a);
                    User.m5521D(str, false, C13521.this.f4097a);
                    pi0.m7331j(C13521.this.f4097a, new pi0.AbstractC1720p() { // from class: cz.opentree.limessh.models.User.1.1.1
                        @Override // cz.opentree.pi0.AbstractC1720p
                        /* renamed from: b */
                        public void mo3229b(User user) {
                            super.mo3229b(user);
                            pi0.m7338q(user, C13521.this.f4097a);
                        }
                    });
                    C13521.this.f4097a.runOnUiThread(new Runnable() { // from class: cz.opentree.limessh.models.User.1.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            OnPasswordChangedListener onPasswordChangedListener = C13521.this.f4098b;
                            if (onPasswordChangedListener != null) {
                                onPasswordChangedListener.mo5419a(true);
                            }
                        }
                    });
                }
            }).start();
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        public void onCancel() {
            OnPasswordChangedListener onPasswordChangedListener = this.f4098b;
            if (onPasswordChangedListener != null) {
                onPasswordChangedListener.mo5419a(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnPasswordChangedListener {
        /* renamed from: a */
        void mo5419a(boolean z);
    }

    /* renamed from: A */
    public static User m5518A(Context context) {
        List list;
        try {
            list = C1328DB.m5404d(User.class, context).queryForEq(NotificationCompat.CATEGORY_EMAIL, m5525s(context));
        } catch (SQLException e) {
            e.printStackTrace();
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (User) list.get(0);
    }

    /* renamed from: B */
    public static void m5519B(String str, Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("account", str);
        edit.commit();
        m5520C(sg0.m8429a(str), context);
    }

    /* renamed from: C */
    public static void m5520C(String str, Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences.getString("account_hash", null) != null) {
            return;
        }
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putString("account_hash", str);
        edit.commit();
    }

    /* renamed from: D */
    public static void m5521D(String str, boolean z, Context context) {
        zk0 m9049h = Session.m9046g().m9049h();
        f4096O = null;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        String m5526t = m5526t(context);
        edit.putBoolean("g25_i", z);
        edit.putString(m5526t, qg0.m7702c(str, m5526t));
        edit.commit();
        m9049h.m10492a(context);
    }

    /* renamed from: E */
    public static void m5522E(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String m5526t = m5526t(context);
        String m7702c = qg0.m7702c(str, 925256861 + m5526t);
        if (m7702c == null) {
            return;
        }
        defaultSharedPreferences.edit().putString(sg0.m8429a(m5526t), m7702c).commit();
    }

    /* renamed from: F */
    public static void m5523F(Context context) {
        gj0.m4141b(TAG, "Creating user account...");
        m5519B("New User", context);
        m5521D(new BigInteger(KeycodeConstants.KEYCODE_MEDIA_RECORD, new SecureRandom()).toString(32), true, context);
        Config.m5456b(context);
        Session.m9045e(context);
        gj0.m4141b(TAG, "User account created complete");
    }

    /* renamed from: G */
    public static void m5524G(Activity activity, int i, OnPasswordChangedListener onPasswordChangedListener) {
        PasswordPrompt passwordPrompt = new PasswordPrompt(activity, new C13521(activity, onPasswordChangedListener));
        passwordPrompt.m9018q();
        passwordPrompt.m9020s(true);
        passwordPrompt.m9297j(activity.getString(R.string.encryption_passphrase));
        passwordPrompt.m9295h(activity.getString(i));
        passwordPrompt.create();
        if (activity.isFinishing()) {
            return;
        }
        passwordPrompt.show();
    }

    /* renamed from: s */
    public static String m5525s(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("account", null);
        if (string == null || string.isEmpty()) {
            m5523F(context);
        }
        return string;
    }

    /* renamed from: t */
    public static String m5526t(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("account_hash", null);
        if (string != null && !string.isEmpty()) {
            return string;
        }
        gj0.m4141b(TAG, "Generating account hash");
        String m8429a = sg0.m8429a(m5525s(context));
        m5520C(m8429a, context);
        return m8429a;
    }

    /* renamed from: u */
    public static String m5527u(Context context) {
        String str = f4096O;
        if (str != null) {
            return str;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            String m5526t = m5526t(context);
            String string = defaultSharedPreferences.getString(m5526t, null);
            String string2 = defaultSharedPreferences.getString("password", null);
            if (string == null && string2 == null) {
                return null;
            }
            if (string != null || string2 == null) {
                String m7700a = qg0.m7700a(string, m5526t);
                f4096O = m7700a;
                return m7700a;
            }
            gj0.m4141b(TAG, "Migrating user to new password schema");
            f4096O = qg0.m7700a(string2, m5526t);
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.remove("password");
            edit.commit();
            m5521D(f4096O, false, context);
            return f4096O;
        } catch (qg0.C1762a unused) {
            return null;
        }
    }

    /* renamed from: v */
    public static String m5528v(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            String m5526t = m5526t(context);
            String string = defaultSharedPreferences.getString(sg0.m8429a(m5526t), null);
            if (string == null) {
                return null;
            }
            return qg0.m7700a(string, 925256861 + m5526t);
        } catch (qg0.C1762a unused) {
            gj0.m4142c(TAG, "Failed to decrypt users PIN");
            return null;
        } catch (NumberFormatException unused2) {
            gj0.m4142c(TAG, "Failed to decrypt users PIN");
            return null;
        }
    }

    /* renamed from: y */
    public static Boolean m5529y(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return Boolean.valueOf(defaultSharedPreferences.getString(m5526t(context), null) == null && defaultSharedPreferences.getString("password", null) == null);
    }

    /* renamed from: z */
    public static boolean m5530z(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("g25_i", false);
    }

    /* renamed from: H */
    public boolean m5531H() {
        // [OfflineProFix merged] user signature always valid (was Xposed hook User.H() => true)
        return true;
    }

    public boolean m5531H_original() {
        try {
            String str = "";
            ArrayList arrayList = new ArrayList();
            for (Purchase purchase : this.purchases) {
                if (!arrayList.contains(purchase.order)) {
                    str = str + purchase.product + purchase.state;
                    arrayList.add(purchase.order);
                }
            }
            return vg0.m9223b(this.signature, this.sessionIdentifier + this.name + this.email + str + this.disabled.toString());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(User user) {
        try {
            return this.name.compareTo(user.name);
        } catch (NullPointerException unused) {
            return 0;
        }
    }

    public String toString() {
        return this.name;
    }

    /* renamed from: w */
    public long m5533w() {
        // [OfflineProFix merged] session never expires: 10 years in seconds (was Xposed hook User.w())
        return 315360000L;
    }

    public long m5533w_original() {
        if (this.sessionExpires <= 0) {
            return 0L;
        }
        return this.sessionExpires - (System.currentTimeMillis() / 1000);
    }
}

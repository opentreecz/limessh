package cz.opentree;

import com.j256.ormlite.field.FieldType;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class u00 {

    /* renamed from: a */
    public static final String[] f6880a = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", "session_id"};

    /* renamed from: b */
    public static final String[] f6881b = {"_ln", "_fot", "_fvt", "_ldl", FieldType.FOREIGN_ID_FIELD_SUFFIX, "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};

    /* renamed from: a */
    public static String m8823a(String str) {
        return y10.m10048a(str, f6880a, f6881b);
    }
}

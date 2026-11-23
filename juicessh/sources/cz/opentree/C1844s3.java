package cz.opentree;

import android.content.BroadcastReceiver;
import android.content.Context;

/* renamed from: cz.opentree.s3 */
/* loaded from: classes.dex */
public class C1844s3 extends BroadcastReceiver {

    /* renamed from: a */
    public static Boolean f6340a;

    /* renamed from: a */
    public static boolean m8310a(Context context) {
        C0813ca.m2729k(context);
        Boolean bool = f6340a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean m2077f = C0713ai.m2077f(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        f6340a = Boolean.valueOf(m2077f);
        return m2077f;
    }
}

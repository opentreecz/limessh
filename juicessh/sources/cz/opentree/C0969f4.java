package cz.opentree;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.analytics.zzo;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: cz.opentree.f4 */
/* loaded from: classes.dex */
public final class C0969f4 implements zzo {

    /* renamed from: P */
    public static final Uri f2618P;

    /* renamed from: O */
    public final LogPrinter f2619O = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        builder.authority("local");
        f2618P = builder.build();
    }

    @Override // com.google.android.gms.analytics.zzo
    /* renamed from: l */
    public final Uri mo835l() {
        return f2618P;
    }

    @Override // com.google.android.gms.analytics.zzo
    /* renamed from: n */
    public final void mo836n(C1093h4 c1093h4) {
        ArrayList arrayList = new ArrayList(c1093h4.m4354e());
        Collections.sort(arrayList, new C1026g4(this));
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String obj2 = ((AbstractC1142i4) obj).toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj2);
            }
        }
        this.f2619O.println(sb.toString());
    }
}

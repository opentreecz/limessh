package cz.opentree;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R$string;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.fa */
/* loaded from: classes.dex */
public class C0977fa {

    /* renamed from: a */
    public final Resources f2637a;

    /* renamed from: b */
    public final String f2638b;

    public C0977fa(Context context) {
        C0813ca.m2729k(context);
        Resources resources = context.getResources();
        this.f2637a = resources;
        this.f2638b = resources.getResourcePackageName(R$string.common_google_play_services_unknown_issue);
    }

    @Nullable
    /* renamed from: a */
    public String m3696a(String str) {
        int identifier = this.f2637a.getIdentifier(str, "string", this.f2638b);
        if (identifier == 0) {
            return null;
        }
        return this.f2637a.getString(identifier);
    }
}

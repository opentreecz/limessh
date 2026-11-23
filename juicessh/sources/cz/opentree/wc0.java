package cz.opentree;

import android.content.Context;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class wc0 implements UnityVersionProvider {

    /* renamed from: a */
    public final Context f7664a;

    /* renamed from: b */
    public boolean f7665b = false;

    /* renamed from: c */
    public String f7666c;

    public wc0(Context context) {
        this.f7664a = context;
    }

    @Override // com.google.firebase.crashlytics.internal.unity.UnityVersionProvider
    /* renamed from: a */
    public String mo1849a() {
        if (!this.f7665b) {
            this.f7666c = w80.m9418E(this.f7664a);
            this.f7665b = true;
        }
        String str = this.f7666c;
        if (str != null) {
            return str;
        }
        return null;
    }
}

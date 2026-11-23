package cz.opentree;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class g50 {

    /* renamed from: a */
    public static final Api.C0429d<y40> f2832a;

    /* renamed from: b */
    public static final Api.C0429d<y40> f2833b;

    /* renamed from: c */
    public static final Api.AbstractC0426a<y40, x40> f2834c;

    /* renamed from: d */
    public static final Api.AbstractC0426a<y40, Object> f2835d;

    static {
        Api.C0429d<y40> c0429d = new Api.C0429d<>();
        f2832a = c0429d;
        Api.C0429d<y40> c0429d2 = new Api.C0429d<>();
        f2833b = c0429d2;
        f50 f50Var = new f50();
        f2834c = f50Var;
        h50 h50Var = new h50();
        f2835d = h50Var;
        new Scope("profile");
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        new Api("SignIn.API", f50Var, c0429d);
        new Api("SignIn.INTERNAL_API", h50Var, c0429d2);
    }
}

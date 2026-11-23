package cz.opentree;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class xf0 {

    /* renamed from: a */
    public static final long f7923a = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: a */
    public long m9759a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    /* renamed from: b */
    public boolean m9760b(bg0 bg0Var) {
        return TextUtils.isEmpty(bg0Var.mo2459b()) || bg0Var.mo2465h() + bg0Var.mo2460c() < m9759a() + f7923a;
    }
}

package com.sonelli;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.j5 */
/* loaded from: classes.dex */
public final class C1196j5 {
    /* renamed from: a */
    public static C1435k5 m5055a(@NonNull Context context, @NonNull GoogleSignInOptions googleSignInOptions) {
        C0813ca.m2729k(googleSignInOptions);
        return new C1435k5(context, googleSignInOptions);
    }

    /* renamed from: b */
    public static j60<GoogleSignInAccount> m5056b(@Nullable Intent intent) {
        C1490l5 m8323a = C1846s5.m8323a(intent);
        if (m8323a == null) {
            return Tasks.m1561d(C1752q9.m7637a(Status.f729U));
        }
        GoogleSignInAccount m6068a = m8323a.m6068a();
        return (!m8323a.mo991n().m996Z() || m6068a == null) ? Tasks.m1561d(C1752q9.m7637a(m8323a.mo991n())) : Tasks.m1562e(m6068a);
    }
}

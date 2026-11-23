package com.sonelli;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.p5 */
/* loaded from: classes.dex */
public final class RunnableC1690p5 implements Runnable {

    /* renamed from: Q */
    public static final C1154ib f5624Q = new C1154ib("RevokeAccessOperation", new String[0]);

    /* renamed from: O */
    public final String f5625O;

    /* renamed from: P */
    public final C2327y7 f5626P;

    public RunnableC1690p5(String str) {
        C0813ca.m2725g(str);
        this.f5625O = str;
        this.f5626P = new C2327y7(null);
    }

    /* renamed from: a */
    public static PendingResult<Status> m7245a(@Nullable String str) {
        if (str == null) {
            return C1493l7.m6088a(new Status(4), null);
        }
        RunnableC1690p5 runnableC1690p5 = new RunnableC1690p5(str);
        new Thread(runnableC1690p5).start();
        return runnableC1690p5.f5626P;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f729U;
        try {
            String valueOf = String.valueOf(this.f5625O);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f727S;
            } else {
                f5624Q.m4740b("Unable to revoke access!", new Object[0]);
            }
            C1154ib c1154ib = f5624Q;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            c1154ib.m4739a(sb.toString(), new Object[0]);
        } catch (IOException e) {
            C1154ib c1154ib2 = f5624Q;
            String valueOf2 = String.valueOf(e.toString());
            c1154ib2.m4740b(valueOf2.length() != 0 ? "IOException when revoking access: ".concat(valueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            C1154ib c1154ib3 = f5624Q;
            String valueOf3 = String.valueOf(e2.toString());
            c1154ib3.m4740b(valueOf3.length() != 0 ? "Exception when revoking access: ".concat(valueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f5626P.m1013f(status);
    }
}

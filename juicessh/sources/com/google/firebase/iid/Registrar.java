package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import cz.opentree.b80;
import cz.opentree.og0;
import cz.opentree.v70;
import cz.opentree.xd0;
import cz.opentree.yd0;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
@Keep
/* loaded from: classes.dex */
public final class Registrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
    /* renamed from: com.google.firebase.iid.Registrar$a */
    /* loaded from: classes.dex */
    public static class C0666a implements FirebaseInstanceIdInternal {

        /* renamed from: a */
        public final FirebaseInstanceId f1279a;

        public C0666a(FirebaseInstanceId firebaseInstanceId) {
            this.f1279a = firebaseInstanceId;
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public final String getId() {
            return this.f1279a.m1878a();
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public final List<v70<?>> getComponents() {
        v70.C2157b m9172a = v70.m9172a(FirebaseInstanceId.class);
        m9172a.m9187b(b80.m2394f(FirebaseApp.class));
        m9172a.m9187b(b80.m2394f(Subscriber.class));
        m9172a.m9187b(b80.m2394f(UserAgentPublisher.class));
        m9172a.m9187b(b80.m2394f(HeartBeatInfo.class));
        m9172a.m9187b(b80.m2394f(FirebaseInstallationsApi.class));
        m9172a.m9191f(xd0.f7920a);
        m9172a.m9188c();
        v70 m9189d = m9172a.m9189d();
        v70.C2157b m9172a2 = v70.m9172a(FirebaseInstanceIdInternal.class);
        m9172a2.m9187b(b80.m2394f(FirebaseInstanceId.class));
        m9172a2.m9191f(yd0.f8196a);
        return Arrays.asList(m9189d, m9172a2.m9189d(), og0.m7033a("fire-iid", "20.1.5"));
    }
}

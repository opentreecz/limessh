package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.sonelli.b80;
import com.sonelli.og0;
import com.sonelli.qf0;
import com.sonelli.sf0;
import com.sonelli.v70;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
@Keep
/* loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer) {
        return new qf0((FirebaseApp) componentContainer.mo1598a(FirebaseApp.class), (UserAgentPublisher) componentContainer.mo1598a(UserAgentPublisher.class), (HeartBeatInfo) componentContainer.mo1598a(HeartBeatInfo.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<v70<?>> getComponents() {
        v70.C2157b m9172a = v70.m9172a(FirebaseInstallationsApi.class);
        m9172a.m9187b(b80.m2394f(FirebaseApp.class));
        m9172a.m9187b(b80.m2394f(HeartBeatInfo.class));
        m9172a.m9187b(b80.m2394f(UserAgentPublisher.class));
        m9172a.m9191f(sf0.m8427b());
        return Arrays.asList(m9172a.m9189d(), og0.m7033a("fire-installations", "16.2.1"));
    }
}

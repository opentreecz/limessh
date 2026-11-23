package cz.opentree;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final /* synthetic */ class xd0 implements ComponentFactory {

    /* renamed from: a */
    public static final ComponentFactory f7920a = new xd0();

    @Override // com.google.firebase.components.ComponentFactory
    /* renamed from: a */
    public final Object mo1608a(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp) componentContainer.mo1598a(FirebaseApp.class), (Subscriber) componentContainer.mo1598a(Subscriber.class), (UserAgentPublisher) componentContainer.mo1598a(UserAgentPublisher.class), (HeartBeatInfo) componentContainer.mo1598a(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.mo1598a(FirebaseInstallationsApi.class));
    }
}

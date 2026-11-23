package cz.opentree;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.events.Subscriber;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final /* synthetic */ class j70 implements ComponentFactory {

    /* renamed from: a */
    public static final ComponentFactory f3512a = new j70();

    @Override // com.google.firebase.components.ComponentFactory
    /* renamed from: a */
    public final Object mo1608a(ComponentContainer componentContainer) {
        return i70.m4723c((FirebaseApp) componentContainer.mo1598a(FirebaseApp.class), (Context) componentContainer.mo1598a(Context.class), (Subscriber) componentContainer.mo1598a(Subscriber.class));
    }
}

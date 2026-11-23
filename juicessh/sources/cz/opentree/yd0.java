package cz.opentree;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.Registrar;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final /* synthetic */ class yd0 implements ComponentFactory {

    /* renamed from: a */
    public static final ComponentFactory f8196a = new yd0();

    @Override // com.google.firebase.components.ComponentFactory
    /* renamed from: a */
    public final Object mo1608a(ComponentContainer componentContainer) {
        return new Registrar.C0666a((FirebaseInstanceId) componentContainer.mo1598a(FirebaseInstanceId.class));
    }
}

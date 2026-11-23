package cz.opentree;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public final /* synthetic */ class sf0 implements ComponentFactory {

    /* renamed from: a */
    public static final sf0 f6435a = new sf0();

    /* renamed from: b */
    public static ComponentFactory m8427b() {
        return f6435a;
    }

    @Override // com.google.firebase.components.ComponentFactory
    /* renamed from: a */
    public Object mo1608a(ComponentContainer componentContainer) {
        return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
    }
}

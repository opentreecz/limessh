package cz.opentree;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class u70 implements ComponentFactory {

    /* renamed from: a */
    public final Object f6924a;

    public u70(Object obj) {
        this.f6924a = obj;
    }

    /* renamed from: b */
    public static ComponentFactory m8858b(Object obj) {
        return new u70(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    /* renamed from: a */
    public Object mo1608a(ComponentContainer componentContainer) {
        Object obj = this.f6924a;
        v70.m9176l(obj, componentContainer);
        return obj;
    }
}

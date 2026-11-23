package com.sonelli;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class t70 implements ComponentFactory {

    /* renamed from: a */
    public final Object f6721a;

    public t70(Object obj) {
        this.f6721a = obj;
    }

    /* renamed from: b */
    public static ComponentFactory m8601b(Object obj) {
        return new t70(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    /* renamed from: a */
    public Object mo1608a(ComponentContainer componentContainer) {
        Object obj = this.f6721a;
        v70.m9177m(obj, componentContainer);
        return obj;
    }
}

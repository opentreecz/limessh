package com.sonelli;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public abstract class s70 implements ComponentContainer {
    @Override // com.google.firebase.components.ComponentContainer
    /* renamed from: a */
    public <T> T mo1598a(Class<T> cls) {
        Provider<T> mo1599b = mo1599b(cls);
        if (mo1599b == null) {
            return null;
        }
        return mo1599b.get();
    }

    @Override // com.google.firebase.components.ComponentContainer
    /* renamed from: d */
    public <T> Set<T> mo1601d(Class<T> cls) {
        return mo1600c(cls).get();
    }
}

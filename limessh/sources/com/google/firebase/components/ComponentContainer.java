package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public interface ComponentContainer {
    /* renamed from: a */
    <T> T mo1598a(Class<T> cls);

    /* renamed from: b */
    <T> Provider<T> mo1599b(Class<T> cls);

    /* renamed from: c */
    <T> Provider<Set<T>> mo1600c(Class<T> cls);

    /* renamed from: d */
    <T> Set<T> mo1601d(Class<T> cls);
}

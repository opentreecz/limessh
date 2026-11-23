package com.google.firebase.events;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public interface Subscriber {
    /* renamed from: a */
    <T> void mo1862a(Class<T> cls, EventHandler<? super T> eventHandler);

    /* renamed from: b */
    <T> void mo1863b(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);
}

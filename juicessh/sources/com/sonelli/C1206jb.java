package com.sonelli;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.jb */
/* loaded from: classes.dex */
public final class C1206jb implements PooledExecutorsProvider.PooledExecutorFactory {
    @Override // com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory
    /* renamed from: a */
    public final ScheduledExecutorService mo1143a() {
        return C0708af.m2048a().mo1206b(1, C0924ef.f2375a);
    }
}

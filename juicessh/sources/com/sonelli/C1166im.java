package com.sonelli;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.im */
/* loaded from: classes.dex */
public final class C1166im extends AbstractC0946em {

    /* renamed from: a */
    public final C1115hm f3341a = new C1115hm();

    @Override // com.sonelli.AbstractC0946em
    /* renamed from: a */
    public final void mo3530a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
        this.f3341a.m4487a(th, true).add(th2);
    }
}

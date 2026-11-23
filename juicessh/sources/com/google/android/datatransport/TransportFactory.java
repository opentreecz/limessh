package com.google.android.datatransport;

import com.sonelli.C0746b;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* loaded from: classes.dex */
public interface TransportFactory {
    /* renamed from: a */
    <T> Transport<T> mo739a(String str, Class<T> cls, C0746b c0746b, Transformer<T, byte[]> transformer);
}

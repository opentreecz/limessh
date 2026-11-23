package com.amazonaws;

import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;

/* loaded from: classes.dex */
public enum ServiceNameFactory {
    ;

    /* renamed from: f */
    public static String m69f(String str) {
        HttpClientConfig m221h = InternalConfig.Factory.m223a().m221h(str);
        if (m221h == null) {
            return null;
        }
        return m221h.m213a();
    }
}

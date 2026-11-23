package com.amazonaws;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class SDKGlobalConfiguration {

    /* renamed from: a */
    public static final AtomicInteger f81a = new AtomicInteger(0);

    /* renamed from: a */
    public static int m67a() {
        return f81a.get();
    }

    /* renamed from: b */
    public static void m68b(int i) {
        f81a.set(i);
    }
}

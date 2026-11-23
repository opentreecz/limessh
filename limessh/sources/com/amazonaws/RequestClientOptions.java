package com.amazonaws;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class RequestClientOptions {

    /* renamed from: a */
    public final Map<Marker, String> f76a = new EnumMap(Marker.class);

    /* loaded from: classes.dex */
    public enum Marker {
        USER_AGENT
    }

    /* renamed from: a */
    public String m64a(Marker marker) {
        return this.f76a.get(marker);
    }
}

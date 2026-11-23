package com.amazonaws;

import java.util.Map;

/* loaded from: classes.dex */
public class ResponseMetadata {

    /* renamed from: a */
    public final Map<String, String> f80a;

    public ResponseMetadata(Map<String, String> map) {
        this.f80a = map;
    }

    /* renamed from: a */
    public String m66a() {
        return this.f80a.get("AWS_REQUEST_ID");
    }

    public String toString() {
        Map<String, String> map = this.f80a;
        return map == null ? "{}" : map.toString();
    }
}

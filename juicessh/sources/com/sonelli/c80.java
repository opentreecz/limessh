package com.sonelli;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class c80 extends d80 {

    /* renamed from: O */
    public final List<v70<?>> f1888O;

    public c80(List<v70<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f1888O = list;
    }
}

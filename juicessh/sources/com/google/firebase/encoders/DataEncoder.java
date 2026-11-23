package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.Writer;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes.dex */
public interface DataEncoder {
    /* renamed from: a */
    void mo1850a(@NonNull Object obj, @NonNull Writer writer) throws IOException;

    @NonNull
    /* renamed from: b */
    String mo1851b(@NonNull Object obj);
}

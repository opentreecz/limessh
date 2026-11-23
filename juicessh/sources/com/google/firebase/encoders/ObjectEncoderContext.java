package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes.dex */
public interface ObjectEncoderContext {
    @NonNull
    /* renamed from: a */
    ObjectEncoderContext mo1853a(@NonNull String str, boolean z) throws IOException;

    @NonNull
    /* renamed from: b */
    ObjectEncoderContext mo1854b(@NonNull String str, long j) throws IOException;

    @NonNull
    /* renamed from: c */
    ObjectEncoderContext mo1855c(@NonNull String str, int i) throws IOException;

    @NonNull
    /* renamed from: f */
    ObjectEncoderContext mo1856f(@NonNull String str, @Nullable Object obj) throws IOException;
}

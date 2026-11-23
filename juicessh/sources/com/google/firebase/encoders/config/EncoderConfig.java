package com.google.firebase.encoders.config;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes.dex */
public interface EncoderConfig<T extends EncoderConfig<T>> {
    @NonNull
    /* renamed from: a */
    <U> T mo1860a(@NonNull Class<U> cls, @NonNull ObjectEncoder<? super U> objectEncoder);
}

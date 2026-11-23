package com.sonelli;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class ad0 implements ValueEncoder {

    /* renamed from: a */
    public static final ad0 f1368a = new ad0();

    /* renamed from: b */
    public static ValueEncoder m2044b() {
        return f1368a;
    }

    @Override // com.google.firebase.encoders.Encoder
    /* renamed from: a */
    public void mo1852a(Object obj, ValueEncoderContext valueEncoderContext) {
        valueEncoderContext.mo1858e(((Boolean) obj).booleanValue());
    }
}

package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes.dex */
public interface Destination {
    @Nullable
    byte[] getExtras();

    @NonNull
    String getName();
}

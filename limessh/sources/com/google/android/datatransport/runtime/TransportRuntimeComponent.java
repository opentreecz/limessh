package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import cz.opentree.C1483l0;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes.dex */
public abstract class TransportRuntimeComponent implements Closeable {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes.dex */
    public interface Builder {
        /* renamed from: a */
        TransportRuntimeComponent mo745a();

        /* renamed from: b */
        Builder mo746b(Context context);
    }

    /* renamed from: a */
    public abstract EventStore mo743a();

    /* renamed from: b */
    public abstract C1483l0 mo744b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        mo743a().close();
    }
}

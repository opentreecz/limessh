package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import cz.opentree.AbstractC1841s0;
import cz.opentree.C2252x;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
@Keep
/* loaded from: classes.dex */
public class CctBackendFactory implements BackendFactory {
    @Override // com.google.android.datatransport.runtime.backends.BackendFactory
    public TransportBackend create(AbstractC1841s0 abstractC1841s0) {
        return new C2252x(abstractC1841s0.mo7162b(), abstractC1841s0.mo7165e(), abstractC1841s0.mo7164d());
    }
}

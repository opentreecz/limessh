package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
/* loaded from: classes.dex */
public interface RequestHandler {
    /* renamed from: a */
    void mo136a(Request<?> request);

    /* renamed from: b */
    void mo137b(Request<?> request, Object obj, TimingInfo timingInfo);

    /* renamed from: c */
    void mo131c(Request<?> request, Exception exc);
}

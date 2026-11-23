package com.sun.jna.win32;

import com.sun.jna.Callback;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;

/* loaded from: classes.dex */
public interface StdCallLibrary extends Library, StdCall {
    public static final FunctionMapper FUNCTION_MAPPER = new StdCallFunctionMapper();
    public static final int STDCALL_CONVENTION = 63;

    /* loaded from: classes.dex */
    public interface StdCallCallback extends Callback, StdCall {
    }
}

package com.sun.jna.win32;

import com.sun.jna.Library;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public interface W32APIOptions extends StdCallLibrary {
    public static final Map<String, Object> UNICODE_OPTIONS = Collections.unmodifiableMap(new C2470a());
    public static final Map<String, Object> ASCII_OPTIONS = Collections.unmodifiableMap(new C2471b());
    public static final Map<String, Object> DEFAULT_OPTIONS = Boolean.getBoolean("w32.ascii") ? ASCII_OPTIONS : UNICODE_OPTIONS;

    /* renamed from: com.sun.jna.win32.W32APIOptions$a */
    /* loaded from: classes.dex */
    public static class C2470a extends HashMap<String, Object> {
        public C2470a() {
            put(Library.OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
            put(Library.OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
        }
    }

    /* renamed from: com.sun.jna.win32.W32APIOptions$b */
    /* loaded from: classes.dex */
    public static class C2471b extends HashMap<String, Object> {
        public C2471b() {
            put(Library.OPTION_TYPE_MAPPER, W32APITypeMapper.ASCII);
            put(Library.OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.ASCII);
        }
    }
}

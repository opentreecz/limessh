package com.sun.jna.win32;

import com.sun.jna.Library;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public interface W32APIOptions extends StdCallLibrary {
    public static final Map<String, Object> ASCII_OPTIONS;
    public static final Map<String, Object> DEFAULT_OPTIONS;
    public static final Map<String, Object> UNICODE_OPTIONS;

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

    static {
        Map<String, Object> unmodifiableMap = Collections.unmodifiableMap(new C2470a());
        UNICODE_OPTIONS = unmodifiableMap;
        Map<String, Object> unmodifiableMap2 = Collections.unmodifiableMap(new C2471b());
        ASCII_OPTIONS = unmodifiableMap2;
        if (Boolean.getBoolean("w32.ascii")) {
            unmodifiableMap = unmodifiableMap2;
        }
        DEFAULT_OPTIONS = unmodifiableMap;
    }
}

package com.ochafik.lang.jnaerator.runtime;

import cz.opentree.pg0;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallFunctionMapper;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class MangledFunctionMapper implements FunctionMapper {
    public static final Map<Object, Object> DEFAULT_OPTIONS;
    public List<FunctionMapper> mappers;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Library.OPTION_FUNCTION_MAPPER, new MangledFunctionMapper(Platform.isWindows() ? new FunctionMapper[]{new StdCallFunctionMapper()} : null));
        DEFAULT_OPTIONS = Collections.unmodifiableMap(hashMap);
    }

    public MangledFunctionMapper(FunctionMapper... functionMapperArr) {
        if (functionMapperArr != null) {
            this.mappers = Arrays.asList(functionMapperArr);
        }
    }

    @Override // com.sun.jna.FunctionMapper
    public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
        pg0 pg0Var = (pg0) method.getAnnotation(pg0.class);
        if (pg0Var != null) {
            for (String str : pg0Var.value()) {
                if (nativeLibrary.getGlobalVariableAddress(str) != null) {
                    return str;
                }
                if (str.startsWith("_")) {
                    String substring = str.substring(1);
                    if (nativeLibrary.getGlobalVariableAddress(substring) != null) {
                        return substring;
                    }
                } else {
                    continue;
                }
            }
        }
        List<FunctionMapper> list = this.mappers;
        if (list != null) {
            Iterator<FunctionMapper> it = list.iterator();
            while (it.hasNext()) {
                String functionName = it.next().getFunctionName(nativeLibrary, method);
                if (functionName != null && nativeLibrary.getGlobalVariableAddress(functionName) != null) {
                    return functionName;
                }
            }
        }
        return method.getName();
    }
}

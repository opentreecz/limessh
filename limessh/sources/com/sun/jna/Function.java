package com.sun.jna;

import com.sun.jna.Structure;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class Function extends Pointer {
    public static final int ALT_CONVENTION = 63;
    public static final int C_CONVENTION = 0;
    private static final int MASK_CC = 63;
    public static final int MAX_NARGS = 256;
    public static final String OPTION_INVOKING_METHOD = "invoking-method";
    public static final int THROW_LAST_ERROR = 64;
    public static final int USE_VARARGS = 384;
    public final int callFlags;
    public final String encoding;
    private final String functionName;
    private NativeLibrary library;
    public final Map<String, ?> options;
    public static final Integer INTEGER_TRUE = -1;
    public static final Integer INTEGER_FALSE = 0;
    private static final VarArgsChecker IS_VARARGS = VarArgsChecker.create();

    /* loaded from: classes.dex */
    public static class NativeMappedArray extends Memory implements PostCallRead {
        private final NativeMapped[] original;

        public NativeMappedArray(NativeMapped[] nativeMappedArr) {
            super(Native.getNativeSize(nativeMappedArr.getClass(), nativeMappedArr));
            this.original = nativeMappedArr;
            setValue(0L, nativeMappedArr, nativeMappedArr.getClass());
        }

        @Override // com.sun.jna.Function.PostCallRead
        public void read() {
            getValue(0L, this.original.getClass(), this.original);
        }
    }

    /* loaded from: classes.dex */
    public static class PointerArray extends Memory implements PostCallRead {
        private final Pointer[] original;

        public PointerArray(Pointer[] pointerArr) {
            super(Native.POINTER_SIZE * (pointerArr.length + 1));
            this.original = pointerArr;
            for (int i = 0; i < pointerArr.length; i++) {
                setPointer(Native.POINTER_SIZE * i, pointerArr[i]);
            }
            setPointer(Native.POINTER_SIZE * pointerArr.length, null);
        }

        @Override // com.sun.jna.Function.PostCallRead
        public void read() {
            Pointer[] pointerArr = this.original;
            read(0L, pointerArr, 0, pointerArr.length);
        }
    }

    /* loaded from: classes.dex */
    public interface PostCallRead {
        void read();
    }

    public Function(NativeLibrary nativeLibrary, String str, int i, String str2) {
        checkCallingConvention(i & 63);
        Objects.requireNonNull(str, "Function name must not be null");
        this.library = nativeLibrary;
        this.functionName = str;
        this.callFlags = i;
        this.options = nativeLibrary.options;
        this.encoding = str2 == null ? Native.getDefaultStringEncoding() : str2;
        try {
            this.peer = nativeLibrary.getSymbolAddress(str);
        } catch (UnsatisfiedLinkError e) {
            throw new UnsatisfiedLinkError("Error looking up function '" + str + "': " + e.getMessage());
        }
    }

    public Function(Pointer pointer, int i, String str) {
        checkCallingConvention(i & 63);
        if (pointer == null || pointer.peer == 0) {
            throw new NullPointerException("Function address may not be null");
        }
        this.functionName = pointer.toString();
        this.callFlags = i;
        this.peer = pointer.peer;
        this.options = Collections.EMPTY_MAP;
        this.encoding = str == null ? Native.getDefaultStringEncoding() : str;
    }

    private void checkCallingConvention(int i) throws IllegalArgumentException {
        if ((i & 63) == i) {
            return;
        }
        throw new IllegalArgumentException("Unrecognized calling convention: " + i);
    }

    public static Object[] concatenateVarArgs(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return objArr;
        }
        Object obj = objArr[objArr.length - 1];
        Class<?> cls = obj != null ? obj.getClass() : null;
        if (cls == null || !cls.isArray()) {
            return objArr;
        }
        Object[] objArr2 = (Object[]) obj;
        for (int i = 0; i < objArr2.length; i++) {
            if (objArr2[i] instanceof Float) {
                objArr2[i] = Double.valueOf(((Float) objArr2[i]).floatValue());
            }
        }
        int length = objArr.length + objArr2.length;
        Object[] objArr3 = new Object[length];
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length - 1);
        System.arraycopy(objArr2, 0, objArr3, objArr.length - 1, objArr2.length);
        objArr3[length - 1] = null;
        return objArr3;
    }

    private Object convertArgument(Object[] objArr, int i, Method method, TypeMapper typeMapper, boolean z, Class<?> cls) {
        Object obj = objArr[i];
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            ToNativeConverter nativeMappedConverter = NativeMapped.class.isAssignableFrom(cls2) ? NativeMappedConverter.getInstance(cls2) : typeMapper != null ? typeMapper.getToNativeConverter(cls2) : null;
            if (nativeMappedConverter != null) {
                obj = nativeMappedConverter.toNative(obj, method != null ? new MethodParameterContext(this, objArr, i, method) : new FunctionParameterContext(this, objArr, i));
            }
        }
        if (obj == null || isPrimitiveArray(obj.getClass())) {
            return obj;
        }
        Class<?> cls3 = obj.getClass();
        if (obj instanceof Structure) {
            Structure structure = (Structure) obj;
            structure.autoWrite();
            if (structure instanceof Structure.ByValue) {
                Class<?> cls4 = structure.getClass();
                if (method != null) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!IS_VARARGS.isVarArgs(method)) {
                        cls4 = parameterTypes[i];
                    } else if (i < parameterTypes.length - 1) {
                        cls4 = parameterTypes[i];
                    } else {
                        Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
                        if (componentType != Object.class) {
                            cls4 = componentType;
                        }
                    }
                }
                if (Structure.ByValue.class.isAssignableFrom(cls4)) {
                    return structure;
                }
            }
            return structure.getPointer();
        }
        if (obj instanceof Callback) {
            return CallbackReference.getFunctionPointer((Callback) obj);
        }
        if (obj instanceof String) {
            return new NativeString((String) obj, false).getPointer();
        }
        if (obj instanceof WString) {
            return new NativeString(obj.toString(), true).getPointer();
        }
        if (obj instanceof Boolean) {
            return Boolean.TRUE.equals(obj) ? INTEGER_TRUE : INTEGER_FALSE;
        }
        if (String[].class == cls3) {
            return new StringArray((String[]) obj, this.encoding);
        }
        if (WString[].class == cls3) {
            return new StringArray((WString[]) obj);
        }
        if (Pointer[].class == cls3) {
            return new PointerArray((Pointer[]) obj);
        }
        if (NativeMapped[].class.isAssignableFrom(cls3)) {
            return new NativeMappedArray((NativeMapped[]) obj);
        }
        if (!Structure[].class.isAssignableFrom(cls3)) {
            if (cls3.isArray()) {
                throw new IllegalArgumentException("Unsupported array argument type: " + cls3.getComponentType());
            }
            if (z || Native.isSupportedNativeType(obj.getClass())) {
                return obj;
            }
            throw new IllegalArgumentException("Unsupported argument type " + obj.getClass().getName() + " at parameter " + i + " of function " + getName());
        }
        Structure[] structureArr = (Structure[]) obj;
        Class<?> componentType2 = cls3.getComponentType();
        boolean isAssignableFrom = Structure.ByReference.class.isAssignableFrom(componentType2);
        if (cls != null && !Structure.ByReference[].class.isAssignableFrom(cls)) {
            if (isAssignableFrom) {
                throw new IllegalArgumentException("Function " + getName() + " declared Structure[] at parameter " + i + " but array of " + componentType2 + " was passed");
            }
            for (int i2 = 0; i2 < structureArr.length; i2++) {
                if (structureArr[i2] instanceof Structure.ByReference) {
                    throw new IllegalArgumentException("Function " + getName() + " declared Structure[] at parameter " + i + " but element " + i2 + " is of Structure.ByReference type");
                }
            }
        }
        if (isAssignableFrom) {
            Structure.autoWrite(structureArr);
            Pointer[] pointerArr = new Pointer[structureArr.length + 1];
            for (int i3 = 0; i3 < structureArr.length; i3++) {
                pointerArr[i3] = structureArr[i3] != null ? structureArr[i3].getPointer() : null;
            }
            return new PointerArray(pointerArr);
        }
        if (structureArr.length == 0) {
            throw new IllegalArgumentException("Structure array must have non-zero length");
        }
        if (structureArr[0] == null) {
            Structure.newInstance(componentType2).toArray(structureArr);
            return structureArr[0].getPointer();
        }
        Structure.autoWrite(structureArr);
        return structureArr[0].getPointer();
    }

    public static int fixedArgs(Method method) {
        return IS_VARARGS.fixedArgs(method);
    }

    public static Function getFunction(Pointer pointer) {
        return getFunction(pointer, 0, (String) null);
    }

    public static Function getFunction(Pointer pointer, int i) {
        return getFunction(pointer, i, (String) null);
    }

    public static Function getFunction(Pointer pointer, int i, String str) {
        return new Function(pointer, i, str);
    }

    public static Function getFunction(String str, String str2) {
        return NativeLibrary.getInstance(str).getFunction(str2);
    }

    public static Function getFunction(String str, String str2, int i) {
        return NativeLibrary.getInstance(str).getFunction(str2, i, null);
    }

    public static Function getFunction(String str, String str2, int i, String str3) {
        return NativeLibrary.getInstance(str).getFunction(str2, i, str3);
    }

    private Pointer invokePointer(int i, Object[] objArr) {
        long invokePointer = Native.invokePointer(this, this.peer, i, objArr);
        if (invokePointer == 0) {
            return null;
        }
        return new Pointer(invokePointer);
    }

    private String invokeString(int i, Object[] objArr, boolean z) {
        Pointer invokePointer = invokePointer(i, objArr);
        if (invokePointer != null) {
            return z ? invokePointer.getWideString(0L) : invokePointer.getString(0L, this.encoding);
        }
        return null;
    }

    private boolean isPrimitiveArray(Class<?> cls) {
        return cls.isArray() && cls.getComponentType().isPrimitive();
    }

    public static boolean isVarArgs(Method method) {
        return IS_VARARGS.isVarArgs(method);
    }

    public static Boolean valueOf(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // com.sun.jna.Pointer
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Function function = (Function) obj;
        return function.callFlags == this.callFlags && function.options.equals(this.options) && function.peer == this.peer;
    }

    public int getCallingConvention() {
        return this.callFlags & 63;
    }

    public String getName() {
        return this.functionName;
    }

    @Override // com.sun.jna.Pointer
    public int hashCode() {
        return this.callFlags + this.options.hashCode() + super.hashCode();
    }

    public Object invoke(Class<?> cls, Object[] objArr) {
        return invoke(cls, objArr, this.options);
    }

    public Object invoke(Class<?> cls, Object[] objArr, Map<String, ?> map) {
        Method method = (Method) map.get(OPTION_INVOKING_METHOD);
        return invoke(method, method != null ? method.getParameterTypes() : null, cls, objArr, map);
    }

    public Object invoke(Method method, Class<?>[] clsArr, Class<?> cls, Object[] objArr, Map<String, ?> map) {
        Object[] objArr2;
        FromNativeConverter fromNativeConverter;
        Class<?> cls2;
        FromNativeConverter fromNativeConverter2;
        Object[] objArr3 = new Object[0];
        if (objArr == null) {
            objArr2 = objArr3;
        } else {
            if (objArr.length > 256) {
                throw new UnsupportedOperationException("Maximum argument count is 256");
            }
            int length = objArr.length;
            Object[] objArr4 = new Object[length];
            System.arraycopy(objArr, 0, objArr4, 0, length);
            objArr2 = objArr4;
        }
        TypeMapper typeMapper = (TypeMapper) map.get(Library.OPTION_TYPE_MAPPER);
        boolean equals = Boolean.TRUE.equals(map.get(Library.OPTION_ALLOW_OBJECTS));
        boolean isVarArgs = (objArr2.length <= 0 || method == null) ? false : isVarArgs(method);
        int fixedArgs = (objArr2.length <= 0 || method == null) ? 0 : fixedArgs(method);
        int i = 0;
        while (true) {
            fromNativeConverter = null;
            if (i >= objArr2.length) {
                break;
            }
            int i2 = i;
            objArr2[i2] = convertArgument(objArr2, i, method, typeMapper, equals, method != null ? (!isVarArgs || i < clsArr.length + (-1)) ? clsArr[i] : clsArr[clsArr.length - 1].getComponentType() : null);
            i = i2 + 1;
            fixedArgs = fixedArgs;
        }
        int i3 = fixedArgs;
        if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            cls2 = nativeMappedConverter.nativeType();
            fromNativeConverter2 = nativeMappedConverter;
        } else {
            if (typeMapper != null) {
                FromNativeConverter fromNativeConverter3 = typeMapper.getFromNativeConverter(cls);
                fromNativeConverter = fromNativeConverter3;
                if (fromNativeConverter3 != null) {
                    cls2 = fromNativeConverter3.nativeType();
                    fromNativeConverter2 = fromNativeConverter3;
                }
            }
            cls2 = cls;
            fromNativeConverter2 = fromNativeConverter;
        }
        Object invoke = invoke(objArr2, cls2, equals, i3);
        if (fromNativeConverter2 != null) {
            invoke = fromNativeConverter2.fromNative(invoke, method != null ? new MethodResultContext(cls, this, objArr, method) : new FunctionResultContext(cls, this, objArr));
        }
        if (objArr != null) {
            for (int i4 = 0; i4 < objArr.length; i4++) {
                Object obj = objArr[i4];
                if (obj != null) {
                    if (obj instanceof Structure) {
                        if (!(obj instanceof Structure.ByValue)) {
                            ((Structure) obj).autoRead();
                        }
                    } else if (objArr2[i4] instanceof PostCallRead) {
                        ((PostCallRead) objArr2[i4]).read();
                        if (objArr2[i4] instanceof PointerArray) {
                            PointerArray pointerArray = (PointerArray) objArr2[i4];
                            if (Structure.ByReference[].class.isAssignableFrom(obj.getClass())) {
                                Class<?> componentType = obj.getClass().getComponentType();
                                Structure[] structureArr = (Structure[]) obj;
                                for (int i5 = 0; i5 < structureArr.length; i5++) {
                                    structureArr[i5] = Structure.updateStructureByReference(componentType, structureArr[i5], pointerArray.getPointer(Native.POINTER_SIZE * i5));
                                }
                            }
                        }
                    } else if (Structure[].class.isAssignableFrom(obj.getClass())) {
                        Structure.autoRead((Structure[]) obj);
                    }
                }
            }
        }
        return invoke;
    }

    public Object invoke(Object[] objArr, Class<?> cls, boolean z) {
        return invoke(objArr, cls, z, 0);
    }

    public Object invoke(Object[] objArr, Class<?> cls, boolean z, int i) {
        int i2 = this.callFlags | ((i & 3) << 7);
        if (cls == null || cls == Void.TYPE || cls == Void.class) {
            Native.invokeVoid(this, this.peer, i2, objArr);
            return null;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return valueOf(Native.invokeInt(this, this.peer, i2, objArr) != 0);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return Byte.valueOf((byte) Native.invokeInt(this, this.peer, i2, objArr));
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return Short.valueOf((short) Native.invokeInt(this, this.peer, i2, objArr));
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return Character.valueOf((char) Native.invokeInt(this, this.peer, i2, objArr));
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return Integer.valueOf(Native.invokeInt(this, this.peer, i2, objArr));
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return Long.valueOf(Native.invokeLong(this, this.peer, i2, objArr));
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return Float.valueOf(Native.invokeFloat(this, this.peer, i2, objArr));
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return Double.valueOf(Native.invokeDouble(this, this.peer, i2, objArr));
        }
        if (cls == String.class) {
            return invokeString(i2, objArr, false);
        }
        if (cls == WString.class) {
            String invokeString = invokeString(i2, objArr, true);
            if (invokeString != null) {
                return new WString(invokeString);
            }
            return null;
        }
        if (Pointer.class.isAssignableFrom(cls)) {
            return invokePointer(i2, objArr);
        }
        if (Structure.class.isAssignableFrom(cls)) {
            if (Structure.ByValue.class.isAssignableFrom(cls)) {
                Structure invokeStructure = Native.invokeStructure(this, this.peer, i2, objArr, Structure.newInstance(cls));
                invokeStructure.autoRead();
                return invokeStructure;
            }
            Pointer invokePointer = invokePointer(i2, objArr);
            if (invokePointer == null) {
                return invokePointer;
            }
            Structure newInstance = Structure.newInstance((Class<Structure>) cls, invokePointer);
            newInstance.conditionalAutoRead();
            return newInstance;
        }
        if (Callback.class.isAssignableFrom(cls)) {
            Pointer invokePointer2 = invokePointer(i2, objArr);
            return invokePointer2 != null ? CallbackReference.getCallback(cls, invokePointer2) : invokePointer2;
        }
        if (cls == String[].class) {
            Pointer invokePointer3 = invokePointer(i2, objArr);
            if (invokePointer3 != null) {
                return invokePointer3.getStringArray(0L, this.encoding);
            }
            return null;
        }
        if (cls == WString[].class) {
            Pointer invokePointer4 = invokePointer(i2, objArr);
            if (invokePointer4 == null) {
                return null;
            }
            String[] wideStringArray = invokePointer4.getWideStringArray(0L);
            WString[] wStringArr = new WString[wideStringArray.length];
            for (int i3 = 0; i3 < wideStringArray.length; i3++) {
                wStringArr[i3] = new WString(wideStringArray[i3]);
            }
            return wStringArr;
        }
        if (cls == Pointer[].class) {
            Pointer invokePointer5 = invokePointer(i2, objArr);
            if (invokePointer5 != null) {
                return invokePointer5.getPointerArray(0L);
            }
            return null;
        }
        if (!z) {
            throw new IllegalArgumentException("Unsupported return type " + cls + " in function " + getName());
        }
        Object invokeObject = Native.invokeObject(this, this.peer, i2, objArr);
        if (invokeObject == null || cls.isAssignableFrom(invokeObject.getClass())) {
            return invokeObject;
        }
        throw new ClassCastException("Return type " + cls + " does not match result " + invokeObject.getClass());
    }

    public void invoke(Object[] objArr) {
        invoke(Void.class, objArr);
    }

    public double invokeDouble(Object[] objArr) {
        return ((Double) invoke(Double.class, objArr)).doubleValue();
    }

    public float invokeFloat(Object[] objArr) {
        return ((Float) invoke(Float.class, objArr)).floatValue();
    }

    public int invokeInt(Object[] objArr) {
        return ((Integer) invoke(Integer.class, objArr)).intValue();
    }

    public long invokeLong(Object[] objArr) {
        return ((Long) invoke(Long.class, objArr)).longValue();
    }

    public Object invokeObject(Object[] objArr) {
        return invoke(Object.class, objArr);
    }

    public Pointer invokePointer(Object[] objArr) {
        return (Pointer) invoke(Pointer.class, objArr);
    }

    public String invokeString(Object[] objArr, boolean z) {
        Object invoke = invoke(z ? WString.class : String.class, objArr);
        if (invoke != null) {
            return invoke.toString();
        }
        return null;
    }

    public void invokeVoid(Object[] objArr) {
        invoke(Void.class, objArr);
    }

    @Override // com.sun.jna.Pointer
    public String toString() {
        if (this.library == null) {
            return "native function@0x" + Long.toHexString(this.peer);
        }
        return "native function " + this.functionName + "(" + this.library.getName() + ")@0x" + Long.toHexString(this.peer);
    }
}

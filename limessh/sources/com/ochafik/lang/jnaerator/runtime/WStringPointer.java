package com.ochafik.lang.jnaerator.runtime;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import java.util.Arrays;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class WStringPointer extends Structure<WStringPointer, ByValue, ByReference> {
    public WString value;

    /* loaded from: classes.dex */
    public static class ByReference extends WStringPointer implements Structure.ByReference {
        @Override // com.ochafik.lang.jnaerator.runtime.WStringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByReference() {
            return super.newByReference();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.WStringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByValue() {
            return super.newByValue();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.WStringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ WStringPointer newInstance() {
            return super.newInstance();
        }
    }

    /* loaded from: classes.dex */
    public static class ByValue extends WStringPointer implements Structure.ByValue {
        @Override // com.ochafik.lang.jnaerator.runtime.WStringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByReference() {
            return super.newByReference();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.WStringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByValue() {
            return super.newByValue();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.WStringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ WStringPointer newInstance() {
            return super.newInstance();
        }
    }

    public WStringPointer() {
    }

    public WStringPointer(Pointer pointer) {
        this(pointer, 0);
    }

    public WStringPointer(Pointer pointer, int i) {
        useMemory(pointer, i);
        read();
    }

    public WStringPointer(PointerType pointerType) {
        this(pointerType.getPointer(), 0);
    }

    public WStringPointer(WString wString) {
        this.value = wString;
    }

    public WStringPointer(String str) {
        this.value = new WString(str);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("value");
    }

    @Override // com.ochafik.lang.jnaerator.runtime.Structure
    public ByReference newByReference() {
        return new ByReference();
    }

    @Override // com.ochafik.lang.jnaerator.runtime.Structure
    public ByValue newByValue() {
        return new ByValue();
    }

    @Override // com.ochafik.lang.jnaerator.runtime.Structure
    public WStringPointer newInstance() {
        return new WStringPointer();
    }

    @Override // com.sun.jna.Structure
    public String toString() {
        return this.value.toString();
    }
}

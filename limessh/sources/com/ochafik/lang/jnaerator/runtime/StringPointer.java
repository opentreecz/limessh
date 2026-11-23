package com.ochafik.lang.jnaerator.runtime;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class StringPointer extends Structure<StringPointer, ByValue, ByReference> {
    public String value;

    /* loaded from: classes.dex */
    public static class ByReference extends StringPointer implements Structure.ByReference {
        @Override // com.ochafik.lang.jnaerator.runtime.StringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByReference() {
            return super.newByReference();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.StringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByValue() {
            return super.newByValue();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.StringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ StringPointer newInstance() {
            return super.newInstance();
        }
    }

    /* loaded from: classes.dex */
    public static class ByValue extends StringPointer implements Structure.ByValue {
        @Override // com.ochafik.lang.jnaerator.runtime.StringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByReference() {
            return super.newByReference();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.StringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ Structure newByValue() {
            return super.newByValue();
        }

        @Override // com.ochafik.lang.jnaerator.runtime.StringPointer, com.ochafik.lang.jnaerator.runtime.Structure
        public /* bridge */ /* synthetic */ StringPointer newInstance() {
            return super.newInstance();
        }
    }

    public StringPointer() {
    }

    public StringPointer(Pointer pointer) {
        this(pointer, 0);
    }

    public StringPointer(Pointer pointer, int i) {
        useMemory(pointer, i);
        read();
    }

    public StringPointer(PointerType pointerType) {
        this(pointerType.getPointer(), 0);
    }

    public StringPointer(String str) {
        this.value = str;
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ochafik.lang.jnaerator.runtime.Structure
    public StringPointer newInstance() {
        return new StringPointer();
    }

    @Override // com.sun.jna.Structure
    public String toString() {
        return this.value;
    }
}

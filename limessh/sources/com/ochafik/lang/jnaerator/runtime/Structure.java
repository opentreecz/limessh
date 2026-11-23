package com.ochafik.lang.jnaerator.runtime;

import com.ochafik.lang.jnaerator.runtime.Structure;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.lang.ref.WeakReference;
import java.nio.Buffer;

/* loaded from: classes.dex */
public abstract class Structure<S extends Structure<S, V, R>, V extends S, R extends S> extends com.sun.jna.Structure implements Comparable<Structure<S, V, R>>, StructureType, StructureTypeDependent {
    public transient WeakReference<StructureType> dependency;

    /* loaded from: classes.dex */
    public interface ByReference extends Structure.ByReference, StructureTypeDependent {
        /* synthetic */ void setDependency(StructureType structureType);
    }

    /* loaded from: classes.dex */
    public interface ByValue extends Structure.ByValue, StructureTypeDependent {
        /* synthetic */ void setDependency(StructureType structureType);
    }

    public Structure() {
    }

    public Structure(Pointer pointer) {
        super(pointer);
    }

    public static <S extends Structure> S[] newArray(Class<S> cls, int i) {
        try {
            S newInstance = cls.newInstance();
            int size = newInstance.size();
            Memory memory = new Memory(i * size);
            newInstance.m10764use(memory);
            S[] sArr = (S[]) newInstance.castToArray(i);
            for (int i2 = 1; i2 < i; i2++) {
                S newInstance2 = cls.newInstance();
                newInstance2.use(memory, i2 * size);
                sArr[i2] = newInstance2;
            }
            return sArr;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Incorrect return type in method signature: ()TR; */
    public Structure byReference() {
        return setupClone(newByReference(), this);
    }

    /* JADX WARN: Incorrect return type in method signature: ()TV; */
    public Structure byValue() {
        return setupClone(newByValue(), this);
    }

    public S[] castToArray() {
        return castToArray(1);
    }

    public S[] castToArray(int i) {
        return (S[]) ((Structure[]) super.toArray(i));
    }

    public S[] castToArray(com.sun.jna.Structure[] structureArr) {
        return (S[]) ((Structure[]) super.toArray(structureArr));
    }

    /* JADX WARN: Incorrect return type in method signature: ()[TR; */
    public Structure[] castToReferenceArray() {
        return castToReferenceArray(1);
    }

    /* JADX WARN: Incorrect return type in method signature: (I)[TR; */
    public Structure[] castToReferenceArray(int i) {
        return byReference().toArray(i);
    }

    /* JADX WARN: Incorrect return type in method signature: ()[TV; */
    public Structure[] castToValueArray() {
        return castToValueArray(1);
    }

    /* JADX WARN: Incorrect return type in method signature: (I)[TV; */
    public Structure[] castToValueArray(int i) {
        return byValue().toArray(i);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public S m10763clone() {
        return (S) setupClone(newInstance(), this);
    }

    @Override // java.lang.Comparable
    public int compareTo(Structure<S, V, R> structure) {
        if (structure == this) {
            return 0;
        }
        if (!(structure instanceof Structure)) {
            return 1;
        }
        int size = size();
        int size2 = size - structure.size();
        if (size2 != 0) {
            return size2;
        }
        if (getPointer().equals(structure.getPointer())) {
            return 0;
        }
        write();
        structure.write();
        byte[] byteArray = getPointer().getByteArray(0L, size);
        byte[] byteArray2 = structure.getPointer().getByteArray(0L, size);
        for (int i = 0; i < size; i++) {
            byte b = byteArray[i];
            byte b2 = byteArray2[i];
            if (b != b2) {
                return b < b2 ? -1 : 1;
            }
        }
        return 0;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TR; */
    public abstract Structure newByReference();

    /* JADX WARN: Incorrect return type in method signature: ()TV; */
    public abstract Structure newByValue();

    public abstract S newInstance();

    @Override // com.sun.jna.Structure, com.ochafik.lang.jnaerator.runtime.StructureType
    public void read() {
        super.read();
        readDependency();
    }

    public void readDependency() {
        StructureType structureType;
        WeakReference<StructureType> weakReference = this.dependency;
        if (weakReference == null || (structureType = weakReference.get()) == null) {
            return;
        }
        structureType.read();
    }

    public void setDependency(StructureType structureType) {
        this.dependency = structureType == null ? null : new WeakReference<>(structureType);
    }

    public <T extends Structure<S, V, R>> T setupClone(T t, StructureType structureType) {
        write();
        t.m10764use(getPointer());
        t.setDependency(this);
        return t;
    }

    public <T extends Union<?, ?, ?>> T setupClone(T t) {
        write();
        t.use(getPointer());
        return t;
    }

    @Deprecated
    public S[] toArray() {
        return toArray(1);
    }

    @Override // com.sun.jna.Structure
    @Deprecated
    public S[] toArray(int i) {
        return (S[]) ((Structure[]) super.toArray(i));
    }

    @Override // com.sun.jna.Structure
    @Deprecated
    public S[] toArray(com.sun.jna.Structure[] structureArr) {
        return (S[]) ((Structure[]) super.toArray(structureArr));
    }

    /* JADX WARN: Incorrect return type in method signature: ()[TR; */
    @Deprecated
    public Structure[] toReferenceArray() {
        return toReferenceArray(1);
    }

    /* JADX WARN: Incorrect return type in method signature: (I)[TR; */
    @Deprecated
    public Structure[] toReferenceArray(int i) {
        return byReference().toArray(i);
    }

    /* JADX WARN: Incorrect return type in method signature: ()[TV; */
    @Deprecated
    public Structure[] toValueArray() {
        return toValueArray(1);
    }

    /* JADX WARN: Incorrect return type in method signature: (I)[TV; */
    @Deprecated
    public Structure[] toValueArray(int i) {
        return byValue().toArray(i);
    }

    /* renamed from: use, reason: merged with bridge method [inline-methods] */
    public S m10764use(Pointer pointer) {
        return use(pointer, 0L);
    }

    public S use(Pointer pointer, long j) {
        useMemory(pointer, (int) j);
        read();
        return this;
    }

    public S use(Buffer buffer) {
        return use(buffer, 0L);
    }

    public S use(Buffer buffer, long j) {
        useMemory(Native.getDirectBufferPointer(buffer), (int) j);
        return this;
    }

    @Override // com.sun.jna.Structure
    public void write() {
        super.write();
        readDependency();
    }
}

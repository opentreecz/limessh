package com.ochafik.lang.jnaerator.runtime;

import com.ochafik.lang.jnaerator.runtime.Union;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.lang.ref.WeakReference;
import java.nio.Buffer;

/* loaded from: classes.dex */
public abstract class Union<S extends Union<S, V, R>, V extends S, R extends S> extends com.sun.jna.Union implements StructureType, StructureTypeDependent {
    public transient WeakReference<StructureType> dependency;

    /* loaded from: classes.dex */
    public interface ByReference extends Structure.ByReference, StructureTypeDependent {
        /* synthetic */ void setDependency(StructureType structureType);
    }

    /* loaded from: classes.dex */
    public interface ByValue extends Structure.ByValue, StructureTypeDependent {
        /* synthetic */ void setDependency(StructureType structureType);
    }

    public Union() {
    }

    public Union(Pointer pointer) {
        super(pointer);
    }

    public static <S extends Union> S[] newArray(Class<S> cls, int i) {
        try {
            S newInstance = cls.newInstance();
            int size = newInstance.size();
            Memory memory = new Memory(i * size);
            newInstance.use(memory);
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
    public Union byReference() {
        return setupClone(newByReference());
    }

    /* JADX WARN: Incorrect return type in method signature: ()TV; */
    public Union byValue() {
        return setupClone(newByValue());
    }

    public S[] castToArray() {
        return castToArray(1);
    }

    public S[] castToArray(int i) {
        return (S[]) ((Union[]) super.toArray(i));
    }

    public S[] castToArray(com.sun.jna.Structure[] structureArr) {
        return (S[]) ((Union[]) super.toArray(structureArr));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public S m10765clone() {
        return (S) setupClone(newInstance());
    }

    /* JADX WARN: Incorrect return type in method signature: ()TR; */
    public abstract Union newByReference();

    /* JADX WARN: Incorrect return type in method signature: ()TV; */
    public abstract Union newByValue();

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
        return (S[]) ((Union[]) super.toArray(i));
    }

    @Override // com.sun.jna.Structure
    @Deprecated
    public S[] toArray(com.sun.jna.Structure[] structureArr) {
        return (S[]) ((Union[]) super.toArray(structureArr));
    }

    public S use(Pointer pointer) {
        return use(pointer, 0L);
    }

    public S use(Pointer pointer, long j) {
        useMemory(pointer, (int) j);
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

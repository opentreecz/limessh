package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class pa0<E> implements List<E>, RandomAccess {

    /* renamed from: O */
    public final List<E> f5644O;

    public pa0(List<E> list) {
        this.f5644O = Collections.unmodifiableList(list);
    }

    @NonNull
    /* renamed from: e */
    public static <E> pa0<E> m7255e(@NonNull List<E> list) {
        return new pa0<>(list);
    }

    @NonNull
    /* renamed from: f */
    public static <E> pa0<E> m7256f(E... eArr) {
        return new pa0<>(Arrays.asList(eArr));
    }

    @Override // java.util.List
    public void add(int i, @NonNull E e) {
        this.f5644O.add(i, e);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NonNull E e) {
        return this.f5644O.add(e);
    }

    @Override // java.util.List
    public boolean addAll(int i, @NonNull Collection<? extends E> collection) {
        return this.f5644O.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.f5644O.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f5644O.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.f5644O.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f5644O.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        return this.f5644O.equals(obj);
    }

    @Override // java.util.List
    @NonNull
    public E get(int i) {
        return this.f5644O.get(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f5644O.hashCode();
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.f5644O.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f5644O.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.f5644O.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.f5644O.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        return this.f5644O.listIterator();
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i) {
        return this.f5644O.listIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        return this.f5644O.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.f5644O.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f5644O.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f5644O.retainAll(collection);
    }

    @Override // java.util.List
    @NonNull
    public E set(int i, @NonNull E e) {
        return this.f5644O.set(i, e);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f5644O.size();
    }

    @Override // java.util.List
    @NonNull
    public List<E> subList(int i, int i2) {
        return this.f5644O.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @Nullable
    public Object[] toArray() {
        return this.f5644O.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(@Nullable T[] tArr) {
        return (T[]) this.f5644O.toArray(tArr);
    }
}

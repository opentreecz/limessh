package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: classes.dex */
public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5460708106909626233L;
    private transient CloseableIterator<T> lastIterator;

    public LazyForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        super(dao, obj, obj2, fieldType, str, z);
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public void closeLastIterator() throws SQLException {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection, com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        try {
            return iteratorThrow();
        } catch (SQLException e) {
            throw new IllegalStateException("Could not build lazy iterator for " + this.dao.getDataClass(), e);
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        CloseableIterator<T> it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                    } catch (SQLException unused) {
                    }
                    return false;
                }
            } finally {
                try {
                    it.close();
                } catch (SQLException unused2) {
                }
            }
        } while (!it.next().equals(obj));
        return true;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet(collection);
        CloseableIterator<T> it = iterator();
        while (it.hasNext()) {
            try {
                hashSet.remove(it.next());
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return hashSet.isEmpty();
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable() {
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() { // from class: com.j256.ormlite.dao.LazyForeignCollection.1
            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return LazyForeignCollection.this.seperateIteratorThrow();
                } catch (Exception e) {
                    throw new IllegalStateException("Could not build lazy iterator for " + LazyForeignCollection.this.dao.getDataClass(), e);
                }
            }

            @Override // java.lang.Iterable
            public CloseableIterator<T> iterator() {
                return closeableIterator();
            }
        });
    }

    @Override // java.util.Collection
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public boolean isEager() {
        return false;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        CloseableIterator<T> it = iterator();
        try {
            return !it.hasNext();
        } finally {
            try {
                it.close();
            } catch (SQLException unused) {
            }
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return closeableIterator();
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow() throws SQLException {
        CloseableIterator<T> seperateIteratorThrow = seperateIteratorThrow();
        this.lastIterator = seperateIteratorThrow;
        return seperateIteratorThrow;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public int refreshAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public int refreshCollection() {
        return 0;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean remove(Object obj) {
        CloseableIterator<T> it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                    } catch (SQLException unused) {
                    }
                    return false;
                }
            } finally {
                try {
                    it.close();
                } catch (SQLException unused2) {
                }
            }
        } while (!it.next().equals(obj));
        it.remove();
        return true;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        CloseableIterator<T> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            try {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return z;
    }

    public CloseableIterator<T> seperateIteratorThrow() throws SQLException {
        Dao<T, ID> dao = this.dao;
        if (dao != null) {
            return dao.iterator(getPreparedQuery());
        }
        throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
    }

    @Override // java.util.Collection
    public int size() {
        CloseableIterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            try {
                it.moveToNext();
                i++;
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return i;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator<T> it = iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next());
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return arrayList.toArray();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        CloseableIterator<T> it = iterator();
        int i = 0;
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                T next = it.next();
                if (i >= eArr.length) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        for (E e : eArr) {
                            arrayList.add(e);
                        }
                    }
                    arrayList.add(next);
                } else {
                    eArr[i] = next;
                }
                i++;
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        if (arrayList != null) {
            return (E[]) arrayList.toArray(eArr);
        }
        if (i < eArr.length - 1) {
            eArr[i] = 0;
        }
        return eArr;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public int updateAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }
}

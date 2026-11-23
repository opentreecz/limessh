package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class EagerForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, CloseableWrappedIterable<T>, Serializable {
    private static final long serialVersionUID = -2523335606983317721L;
    private List<T> results;

    public EagerForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) throws SQLException {
        super(dao, obj, obj2, fieldType, str, z);
        if (obj2 == null) {
            this.results = new ArrayList();
        } else {
            this.results = dao.query(getPreparedQuery());
        }
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection, java.util.Collection
    public boolean add(T t) {
        if (this.results.add(t)) {
            return super.add(t);
        }
        return false;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        if (this.results.addAll(collection)) {
            return super.addAll(collection);
        }
        return false;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public void clear() {
        this.results.clear();
        super.clear();
    }

    @Override // com.j256.ormlite.dao.CloseableWrappedIterable
    public void close() {
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public void closeLastIterator() {
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection, com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return iteratorThrow();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.results.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.results.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj instanceof EagerForeignCollection) {
            return this.results.equals(((EagerForeignCollection) obj).results);
        }
        return false;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable() {
        return this;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.results.hashCode();
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public boolean isEager() {
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.results.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return iteratorThrow();
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow() {
        return new CloseableIterator<T>() { // from class: com.j256.ormlite.dao.EagerForeignCollection.1
            private int offset = -1;

            @Override // com.j256.ormlite.dao.CloseableIterator
            public void close() {
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public void closeQuietly() {
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T current() {
                if (this.offset < 0) {
                    this.offset = 0;
                }
                if (this.offset >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T first() {
                this.offset = 0;
                if (EagerForeignCollection.this.results.size() <= 0) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(0);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public DatabaseResults getRawResults() {
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.offset + 1 < EagerForeignCollection.this.results.size();
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T moveRelative(int i) {
                int i2 = this.offset + i;
                this.offset = i2;
                if (i2 < 0 || i2 >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public void moveToNext() {
                this.offset++;
            }

            @Override // java.util.Iterator
            public T next() {
                this.offset++;
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T nextThrow() {
                int i = this.offset + 1;
                this.offset = i;
                if (i >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T previous() {
                int i = this.offset - 1;
                this.offset = i;
                if (i < 0 || i >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public void remove() {
                int i = this.offset;
                if (i < 0) {
                    throw new IllegalStateException("next() must be called before remove()");
                }
                if (i >= EagerForeignCollection.this.results.size()) {
                    throw new IllegalStateException("current results position (" + this.offset + ") is out of bounds");
                }
                Object remove = EagerForeignCollection.this.results.remove(this.offset);
                Dao<T, ID> dao = EagerForeignCollection.this.dao;
                if (dao != 0) {
                    try {
                        dao.delete((Dao<T, ID>) remove);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public int refreshAll() throws SQLException {
        Iterator<T> it = this.results.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += this.dao.refresh(it.next());
        }
        return i;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public int refreshCollection() throws SQLException {
        List<T> query = this.dao.query(getPreparedQuery());
        this.results = query;
        return query.size();
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean remove(Object obj) {
        Dao<T, ID> dao;
        if (!this.results.remove(obj) || (dao = this.dao) == null) {
            return false;
        }
        try {
            return dao.delete((Dao<T, ID>) obj) == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Could not delete data element from dao", e);
        }
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return this.results.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.results.toArray();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.results.toArray(eArr);
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection
    public int updateAll() throws SQLException {
        Iterator<T> it = this.results.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += this.dao.update((Dao<T, ID>) it.next());
        }
        return i;
    }
}

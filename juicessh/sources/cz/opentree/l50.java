package cz.opentree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzaq;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l50 implements DataLayer.zzc {

    /* renamed from: f */
    public static final String f4745f = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");

    /* renamed from: a */
    public final Executor f4746a;

    /* renamed from: b */
    public final Context f4747b;

    /* renamed from: c */
    public o50 f4748c;

    /* renamed from: d */
    public Clock f4749d;

    /* renamed from: e */
    public int f4750e;

    public l50(Context context) {
        this(context, C0921ec.m3474d(), "google_tagmanager.db", RecyclerView.MAX_SCROLL_DURATION, C0935ei.m3501a().mo1218a(C1111hi.f3159a));
    }

    public l50(Context context, Clock clock, String str, int i, Executor executor) {
        this.f4747b = context;
        this.f4749d = clock;
        this.f4750e = RecyclerView.MAX_SCROLL_DURATION;
        this.f4746a = executor;
        this.f4748c = new o50(this, context, str);
    }

    /* renamed from: c */
    public static Object m6069c(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (IOException unused) {
            objectInputStream = null;
        } catch (ClassNotFoundException unused2) {
            objectInputStream = null;
        } catch (Throwable th2) {
            objectInputStream = null;
            th = th2;
        }
        try {
            Object readObject = objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException unused3) {
            }
            return readObject;
        } catch (IOException unused4) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused5) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (ClassNotFoundException unused6) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused7) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused8) {
                    throw th;
                }
            }
            byteArrayInputStream.close();
            throw th;
        }
    }

    /* renamed from: i */
    public static byte[] m6073i(Object obj) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return byteArray;
            } catch (IOException unused2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                        return null;
                    }
                }
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException unused5) {
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    /* renamed from: a */
    public final void mo1532a(zzaq zzaqVar) {
        this.f4746a.execute(new n50(this, zzaqVar));
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    /* renamed from: b */
    public final void mo1533b(List<DataLayer.C0453a> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.C0453a c0453a : list) {
            arrayList.add(new p50(c0453a.f1061a, m6073i(c0453a.f1062b)));
        }
        this.f4746a.execute(new m50(this, arrayList, j));
    }

    /* renamed from: f */
    public final SQLiteDatabase m6075f(String str) {
        try {
            return this.f4748c.getWritableDatabase();
        } catch (SQLiteException unused) {
            v50.m9167b(str);
            return null;
        }
    }

    /* renamed from: h */
    public final synchronized void m6076h(List<p50> list, long j) {
        SQLiteDatabase m6075f;
        try {
            long mo1177a = this.f4749d.mo1177a();
            m6081o(mo1177a);
            int m6079l = (m6079l() - this.f4750e) + list.size();
            if (m6079l > 0) {
                List<String> m6082p = m6082p(m6079l);
                int size = m6082p.size();
                StringBuilder sb = new StringBuilder(64);
                sb.append("DataLayer store full, deleting ");
                sb.append(size);
                sb.append(" entries to make room.");
                v50.m9169d(sb.toString());
                String[] strArr = (String[]) m6082p.toArray(new String[0]);
                if (strArr != null && strArr.length != 0 && (m6075f = m6075f("Error opening database for deleteEntries.")) != null) {
                    try {
                        m6075f.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
                    } catch (SQLiteException unused) {
                        String valueOf = String.valueOf(Arrays.toString(strArr));
                        v50.m9167b(valueOf.length() != 0 ? "Error deleting entries ".concat(valueOf) : new String("Error deleting entries "));
                    }
                }
            }
            long j2 = mo1177a + j;
            SQLiteDatabase m6075f2 = m6075f("Error opening database for writeEntryToDatabase.");
            if (m6075f2 != null) {
                for (p50 p50Var : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("expires", Long.valueOf(j2));
                    contentValues.put("key", p50Var.f5627a);
                    contentValues.put("value", p50Var.f5628b);
                    m6075f2.insert("datalayer", null, contentValues);
                }
            }
        } finally {
            m6080m();
        }
    }

    /* renamed from: j */
    public final List<DataLayer.C0453a> m6077j() {
        try {
            m6081o(this.f4749d.mo1177a());
            List<p50> m6078k = m6078k();
            ArrayList arrayList = new ArrayList();
            for (p50 p50Var : m6078k) {
                arrayList.add(new DataLayer.C0453a(p50Var.f5627a, m6069c(p50Var.f5628b)));
            }
            return arrayList;
        } finally {
            m6080m();
        }
    }

    /* renamed from: k */
    public final List<p50> m6078k() {
        SQLiteDatabase m6075f = m6075f("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (m6075f == null) {
            return arrayList;
        }
        Cursor query = m6075f.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new p50(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public final int m6079l() {
        SQLiteDatabase m6075f = m6075f("Error opening database for getNumStoredEntries.");
        if (m6075f == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = m6075f.rawQuery("SELECT COUNT(*) from datalayer", null);
                r1 = cursor.moveToFirst() ? (int) cursor.getLong(0) : 0;
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException unused) {
                v50.m9167b("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            }
            return r1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: m */
    public final void m6080m() {
        try {
            this.f4748c.close();
        } catch (SQLiteException unused) {
        }
    }

    /* renamed from: o */
    public final void m6081o(long j) {
        SQLiteDatabase m6075f = m6075f("Error opening database for deleteOlderThan.");
        if (m6075f == null) {
            return;
        }
        try {
            int delete = m6075f.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
            StringBuilder sb = new StringBuilder(33);
            sb.append("Deleted ");
            sb.append(delete);
            sb.append(" expired items");
            v50.m9166a(sb.toString());
        } catch (SQLiteException unused) {
            v50.m9167b("Error deleting old entries.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r2.moveToFirst() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r1.add(java.lang.String.valueOf(r2.getLong(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r2.moveToNext() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
    
        return r1;
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> m6082p(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "ID"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r14 > 0) goto Lf
            java.lang.String r14 = "Invalid maxEntries specified. Skipping."
            cz.opentree.v50.m9167b(r14)
            return r1
        Lf:
            java.lang.String r2 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r3 = r13.m6075f(r2)
            if (r3 != 0) goto L18
            return r1
        L18:
            r2 = 0
            java.lang.String r4 = "datalayer"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "%s ASC"
            r11 = 1
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r12 = 0
            r11[r12] = r0     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r11 = java.lang.Integer.toString(r14)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            boolean r14 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            if (r14 == 0) goto L4e
        L3d:
            long r3 = r2.getLong(r12)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r14 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r1.add(r14)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            boolean r14 = r2.moveToNext()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            if (r14 != 0) goto L3d
        L4e:
            if (r2 == 0) goto L79
            r2.close()
            goto L79
        L54:
            r14 = move-exception
            goto L7a
        L56:
            r14 = move-exception
            java.lang.String r0 = "Error in peekEntries fetching entryIds: "
            java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> L54
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L54
            int r3 = r14.length()     // Catch: java.lang.Throwable -> L54
            if (r3 == 0) goto L6c
            java.lang.String r14 = r0.concat(r14)     // Catch: java.lang.Throwable -> L54
            goto L71
        L6c:
            java.lang.String r14 = new java.lang.String     // Catch: java.lang.Throwable -> L54
            r14.<init>(r0)     // Catch: java.lang.Throwable -> L54
        L71:
            cz.opentree.v50.m9167b(r14)     // Catch: java.lang.Throwable -> L54
            if (r2 == 0) goto L79
            r2.close()
        L79:
            return r1
        L7a:
            if (r2 == 0) goto L7f
            r2.close()
        L7f:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.l50.m6082p(int):java.util.List");
    }
}

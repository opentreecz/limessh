package cz.opentree;

import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class z80 {

    /* renamed from: a */
    public final String f8467a;

    /* renamed from: b */
    public final FileStore f8468b;

    public z80(String str, FileStore fileStore) {
        this.f8467a = str;
        this.f8468b = fileStore;
    }

    /* renamed from: a */
    public boolean m10402a() {
        try {
            return m10403b().createNewFile();
        } catch (IOException e) {
            m80.m6375f().m6380e("Error creating marker: " + this.f8467a, e);
            return false;
        }
    }

    /* renamed from: b */
    public final File m10403b() {
        return new File(this.f8468b.mo1828b(), this.f8467a);
    }

    /* renamed from: c */
    public boolean m10404c() {
        return m10403b().exists();
    }

    /* renamed from: d */
    public boolean m10405d() {
        return m10403b().delete();
    }
}

package cz.opentree;

import android.content.Context;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class mb0 implements FileStore {

    /* renamed from: a */
    public final Context f5015a;

    public mb0(Context context) {
        this.f5015a = context;
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    /* renamed from: a */
    public String mo1827a() {
        return new File(this.f5015a.getFilesDir(), ".com.google.firebase.crashlytics").getPath();
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    /* renamed from: b */
    public File mo1828b() {
        return m6395c(new File(this.f5015a.getFilesDir(), ".com.google.firebase.crashlytics"));
    }

    /* renamed from: c */
    public File m6395c(File file) {
        if (file == null) {
            m80.m6375f().m6377b("Null File");
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        m80.m6375f().m6383i("Couldn't create file");
        return null;
    }
}

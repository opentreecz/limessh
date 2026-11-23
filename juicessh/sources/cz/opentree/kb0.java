package cz.opentree;

import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class kb0 implements FilenameFilter {

    /* renamed from: a */
    public static final kb0 f4512a = new kb0();

    /* renamed from: a */
    public static FilenameFilter m5865a() {
        return f4512a;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean startsWith;
        startsWith = str.startsWith(NotificationCompat.CATEGORY_EVENT);
        return startsWith;
    }
}

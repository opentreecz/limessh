package cz.opentree;

import java.io.File;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class jb0 implements Comparator {

    /* renamed from: a */
    public static final jb0 f3533a = new jb0();

    /* renamed from: a */
    public static Comparator m5099a() {
        return f3533a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((File) obj2).getName().compareTo(((File) obj).getName());
        return compareTo;
    }
}

package cz.opentree;

import com.google.firebase.crashlytics.internal.ndk.BinaryImagesConverter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class ab0 implements BinaryImagesConverter.FileIdStrategy {
    /* renamed from: b */
    public static String m2035b(String str) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                String m9419F = w80.m9419F(bufferedInputStream2);
                w80.m9427f(bufferedInputStream2);
                return m9419F;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                w80.m9427f(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.ndk.BinaryImagesConverter.FileIdStrategy
    /* renamed from: a */
    public String mo1826a(File file) throws IOException {
        return m2035b(file.getPath());
    }
}

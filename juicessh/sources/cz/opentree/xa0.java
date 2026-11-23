package cz.opentree;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.ndk.BinaryImagesConverter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class xa0 {
    @NonNull
    /* renamed from: a */
    public static byte[] m9752a(@Nullable File file, @NonNull Context context) throws IOException {
        if (file == null || !file.exists()) {
            return new byte[0];
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            try {
                byte[] m1821a = new BinaryImagesConverter(context, new ab0()).m1821a(bufferedReader2);
                w80.m9427f(bufferedReader2);
                return m1821a;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                w80.m9427f(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

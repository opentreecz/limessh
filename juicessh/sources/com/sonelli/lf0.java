package com.sonelli;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class lf0 {

    /* renamed from: a */
    public final FileChannel f4792a;

    /* renamed from: b */
    public final FileLock f4793b;

    public lf0(FileChannel fileChannel, FileLock fileLock) {
        this.f4792a = fileChannel;
        this.f4793b = fileLock;
    }

    /* renamed from: a */
    public static lf0 m6155a(Context context, String str) {
        FileChannel fileChannel;
        FileLock fileLock;
        try {
            fileChannel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLock = fileChannel.lock();
            } catch (IOException e) {
                e = e;
                fileLock = null;
            }
        } catch (IOException e2) {
            e = e2;
            fileChannel = null;
            fileLock = null;
        }
        try {
            return new lf0(fileChannel, fileLock);
        } catch (IOException e3) {
            e = e3;
            Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused2) {
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    public void m6156b() {
        try {
            this.f4793b.release();
            this.f4792a.close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }
}

package com.sonelli;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: AssetInstaller.java */
/* loaded from: classes.dex */
public class ri0 {
    /* renamed from: a */
    public static int m7912a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + ":version", -1);
    }

    /* renamed from: b */
    public static void m7913b(Context context, String str, int i) throws IOException {
        if (!m7914c(context, str)) {
            return;
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            throw new IOException("Failed to determine " + str + " installation path");
        }
        gj0.m4141b("AssetInstaller", "Installing " + str + " to: " + filesDir.getAbsolutePath());
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(context.getResources().openRawResource(i)));
        byte[] bArr = new byte[1024];
        context.getFilesDir();
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                m7915d(context, str, pi0.m7333l(context));
                gj0.m4141b("AssetInstaller", "Successfully installed " + str);
                return;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                gj0.m4141b("AssetInstaller", "Creating directory: " + name);
                new File(filesDir.getAbsolutePath() + "/" + name).mkdirs();
            } else {
                gj0.m4141b("AssetInstaller", "Deploying: " + name);
                FileOutputStream fileOutputStream = new FileOutputStream(filesDir.getAbsolutePath() + "/" + name);
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                fileOutputStream.close();
                zipInputStream.closeEntry();
            }
        }
    }

    /* renamed from: c */
    public static boolean m7914c(Context context, String str) {
        return m7912a(context, str) < pi0.m7333l(context);
    }

    /* renamed from: d */
    public static void m7915d(Context context, String str, int i) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + ":version", i);
        edit.commit();
    }
}

package com.sonelli;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Transformation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class bm0 {

    /* renamed from: a */
    public static final StringBuilder f1772a = new StringBuilder();

    /* compiled from: Utils.java */
    @TargetApi(11)
    /* renamed from: com.sonelli.bm0$a */
    /* loaded from: classes.dex */
    public static class C0784a {
        /* renamed from: a */
        public static int m2583a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* compiled from: Utils.java */
    @TargetApi(12)
    /* renamed from: com.sonelli.bm0$b */
    /* loaded from: classes.dex */
    public static class C0785b {
        /* renamed from: a */
        public static int m2584a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.sonelli.bm0$c */
    /* loaded from: classes.dex */
    public static class C0786c {
        /* renamed from: a */
        public static Downloader m2585a(Context context) {
            return new rl0(context);
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.sonelli.bm0$d */
    /* loaded from: classes.dex */
    public static class C0787d extends Thread {
        public C0787d(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.sonelli.bm0$e */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0788e implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0787d(runnable);
        }
    }

    /* renamed from: a */
    public static long m2560a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCount() * statFs.getBlockSize()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800L), 5242880L);
    }

    /* renamed from: b */
    public static int m2561b(Context context) {
        ActivityManager activityManager = (ActivityManager) m2574o(context, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = C0784a.m2583a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    /* renamed from: c */
    public static void m2562c() {
        if (!m2577r()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* renamed from: d */
    public static void m2563d() {
        if (m2577r()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    /* renamed from: e */
    public static void m2564e(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: f */
    public static File m2565f(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: g */
    public static Downloader m2566g(Context context) {
        boolean z;
        boolean z2 = true;
        try {
            Class.forName("com.squareup.okhttp.OkUrlFactory");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
        } catch (ClassNotFoundException unused2) {
            z2 = false;
        }
        if (z2 == z) {
            return z2 ? C0786c.m2585a(context) : new am0(context);
        }
        throw new RuntimeException("Picasso detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Picasso, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
    }

    /* renamed from: h */
    public static String m2567h(ul0 ul0Var) {
        StringBuilder sb = f1772a;
        String m2568i = m2568i(ul0Var, sb);
        sb.setLength(0);
        return m2568i;
    }

    /* renamed from: i */
    public static String m2568i(ul0 ul0Var, StringBuilder sb) {
        Uri uri = ul0Var.f6998c;
        if (uri != null) {
            String uri2 = uri.toString();
            sb.ensureCapacity(uri2.length() + 50);
            sb.append(uri2);
        } else {
            sb.ensureCapacity(50);
            sb.append(ul0Var.f6999d);
        }
        sb.append('\n');
        if (ul0Var.f7005j != 0.0f) {
            sb.append("rotation:");
            sb.append(ul0Var.f7005j);
            if (ul0Var.f7008m) {
                sb.append('@');
                sb.append(ul0Var.f7006k);
                sb.append('x');
                sb.append(ul0Var.f7007l);
            }
            sb.append('\n');
        }
        if (ul0Var.f7001f != 0) {
            sb.append("resize:");
            sb.append(ul0Var.f7001f);
            sb.append('x');
            sb.append(ul0Var.f7002g);
            sb.append('\n');
        }
        if (ul0Var.f7003h) {
            sb.append("centerCrop\n");
        } else if (ul0Var.f7004i) {
            sb.append("centerInside\n");
        }
        List<Transformation> list = ul0Var.f7000e;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(ul0Var.f7000e.get(i).mo8917b());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    /* renamed from: j */
    public static int m2569j(Bitmap bitmap) {
        int m2584a = Build.VERSION.SDK_INT >= 12 ? C0785b.m2584a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (m2584a >= 0) {
            return m2584a;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    /* renamed from: k */
    public static String m2570k(fl0 fl0Var) {
        return m2571l(fl0Var, "");
    }

    /* renamed from: l */
    public static String m2571l(fl0 fl0Var, String str) {
        StringBuilder sb = new StringBuilder(str);
        dl0 m3791j = fl0Var.m3791j();
        if (m3791j != null) {
            sb.append(m3791j.f2233b.m8921d());
        }
        List<dl0> m3792k = fl0Var.m3792k();
        if (m3792k != null) {
            int size = m3792k.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || m3791j != null) {
                    sb.append(", ");
                }
                sb.append(m3792k.get(i).f2233b.m8921d());
            }
        }
        return sb.toString();
    }

    /* renamed from: m */
    public static int m2572m(Resources resources, ul0 ul0Var) throws FileNotFoundException {
        Uri uri;
        int i = ul0Var.f6999d;
        if (i != 0 || (uri = ul0Var.f6998c) == null) {
            return i;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + ul0Var.f6998c);
        }
        List<String> pathSegments = ul0Var.f6998c.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + ul0Var.f6998c);
        }
        if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + ul0Var.f6998c);
            }
        }
        if (pathSegments.size() == 2) {
            return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        }
        throw new FileNotFoundException("More than two path segments: " + ul0Var.f6998c);
    }

    /* renamed from: n */
    public static Resources m2573n(Context context, ul0 ul0Var) throws FileNotFoundException {
        Uri uri;
        if (ul0Var.f6999d != 0 || (uri = ul0Var.f6998c) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + ul0Var.f6998c);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + ul0Var.f6998c);
        }
    }

    /* renamed from: o */
    public static <T> T m2574o(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    /* renamed from: p */
    public static boolean m2575p(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: q */
    public static boolean m2576q(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    /* renamed from: r */
    public static boolean m2577r() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: s */
    public static boolean m2578s(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    /* renamed from: t */
    public static void m2579t(String str, String str2, String str3) {
        m2580u(str, str2, str3, "");
    }

    /* renamed from: u */
    public static void m2580u(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    /* renamed from: v */
    public static boolean m2581v(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if ("CONDITIONAL_CACHE".equals(split[0])) {
                return Integer.parseInt(split[1]) == 304;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* renamed from: w */
    public static byte[] m2582w(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}

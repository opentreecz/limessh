package cz.opentree;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class w80 {

    /* renamed from: a */
    public static final char[] f7630a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static long f7631b = -1;

    /* renamed from: c */
    public static final Comparator<File> f7632c = new C2205a();

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.w80$a */
    /* loaded from: classes.dex */
    public class C2205a implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.w80$b */
    /* loaded from: classes.dex */
    public enum EnumC2206b {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;


        /* renamed from: Y */
        public static final Map<String, EnumC2206b> f7643Y;

        static {
            EnumC2206b enumC2206b = X86_32;
            EnumC2206b enumC2206b2 = ARMV6;
            EnumC2206b enumC2206b3 = ARMV7;
            EnumC2206b enumC2206b4 = ARM64;
            HashMap hashMap = new HashMap(4);
            f7643Y = hashMap;
            hashMap.put("armeabi-v7a", enumC2206b3);
            hashMap.put("armeabi", enumC2206b2);
            hashMap.put("arm64-v8a", enumC2206b4);
            hashMap.put("x86", enumC2206b);
        }

        /* renamed from: f */
        public static EnumC2206b m9449f() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                m80.m6375f().m6377b("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            EnumC2206b enumC2206b = f7643Y.get(str.toLowerCase(Locale.US));
            return enumC2206b == null ? UNKNOWN : enumC2206b;
        }
    }

    /* renamed from: A */
    public static boolean m9414A() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    /* renamed from: B */
    public static boolean m9415B(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str = Build.PRODUCT;
        return "sdk".equals(str) || "google_sdk".equals(str) || string == null;
    }

    /* renamed from: C */
    public static boolean m9416C(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: D */
    public static boolean m9417D(Context context) {
        boolean m9415B = m9415B(context);
        String str = Build.TAGS;
        if ((m9415B || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !m9415B && new File("/system/xbin/su").exists();
        }
        return true;
    }

    /* renamed from: E */
    public static String m9418E(Context context) {
        int m9440s = m9440s(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (m9440s == 0) {
            return null;
        }
        String string = context.getResources().getString(m9440s);
        m80.m6375f().m6377b("Unity Editor version is: " + string);
        return string;
    }

    /* renamed from: F */
    public static String m9419F(InputStream inputStream) {
        return m9444w(inputStream, "SHA-1");
    }

    /* renamed from: G */
    public static String m9420G(String str) {
        return m9445x(str, "SHA-1");
    }

    /* renamed from: H */
    public static String m9421H(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    /* renamed from: a */
    public static long m9422a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: b */
    public static long m9423b(String str) {
        long blockSize = new StatFs(str).getBlockSize();
        return (r0.getBlockCount() * blockSize) - (blockSize * r0.getAvailableBlocks());
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: c */
    public static boolean m9424c(Context context) {
        if (!m9425d(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: d */
    public static boolean m9425d(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: e */
    public static void m9426e(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                m80.m6375f().m6380e(str, e);
            }
        }
    }

    /* renamed from: f */
    public static void m9427f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: g */
    public static long m9428g(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * i;
    }

    /* renamed from: h */
    public static String m9429h(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return m9420G(sb2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        r2 = r3[1];
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m9430i(java.io.File r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "Failed to close system file reader."
            boolean r1 = r6.exists()
            r2 = 0
            if (r1 == 0) goto L5f
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
        L15:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            if (r3 == 0) goto L36
            java.lang.String r4 = "\\s*:\\s*"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            r5 = 2
            java.lang.String[] r3 = r4.split(r3, r5)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            int r4 = r3.length     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            r5 = 1
            if (r4 <= r5) goto L15
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            boolean r4 = r4.equals(r7)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            if (r4 == 0) goto L15
            r6 = r3[r5]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            r2 = r6
        L36:
            m9426e(r1, r0)
            goto L5f
        L3a:
            r7 = move-exception
            goto L40
        L3c:
            r6 = move-exception
            goto L5b
        L3e:
            r7 = move-exception
            r1 = r2
        L40:
            cz.opentree.m80 r3 = cz.opentree.m80.m6375f()     // Catch: java.lang.Throwable -> L59
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = "Error parsing "
            r4.append(r5)     // Catch: java.lang.Throwable -> L59
            r4.append(r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L59
            r3.m6380e(r6, r7)     // Catch: java.lang.Throwable -> L59
            goto L36
        L59:
            r6 = move-exception
            r2 = r1
        L5b:
            m9426e(r2, r0)
            throw r6
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.w80.m9430i(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: j */
    public static void m9431j(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                m80.m6375f().m6380e(str, e);
            }
        }
    }

    /* renamed from: k */
    public static ActivityManager.RunningAppProcessInfo m9432k(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: l */
    public static boolean m9433l(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int m9440s = m9440s(context, str, "bool");
            if (m9440s > 0) {
                return resources.getBoolean(m9440s);
            }
            int m9440s2 = m9440s(context, str, "string");
            if (m9440s2 > 0) {
                return Boolean.parseBoolean(context.getString(m9440s2));
            }
        }
        return z;
    }

    /* renamed from: m */
    public static int m9434m() {
        return EnumC2206b.m9449f().ordinal();
    }

    /* renamed from: n */
    public static int m9435n(Context context) {
        int i = m9415B(context) ? 1 : 0;
        if (m9417D(context)) {
            i |= 2;
        }
        return m9414A() ? i | 4 : i;
    }

    /* renamed from: o */
    public static SharedPreferences m9436o(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* renamed from: p */
    public static String m9437p(Context context) {
        int m9440s = m9440s(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (m9440s == 0) {
            m9440s = m9440s(context, "com.crashlytics.android.build_id", "string");
        }
        if (m9440s != 0) {
            return context.getResources().getString(m9440s);
        }
        return null;
    }

    /* renamed from: q */
    public static boolean m9438q(Context context) {
        return (m9415B(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    /* renamed from: r */
    public static String m9439r(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i <= 0) {
            return context.getPackageName();
        }
        try {
            return context.getResources().getResourcePackageName(i);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    /* renamed from: s */
    public static int m9440s(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m9439r(context));
    }

    /* renamed from: t */
    public static SharedPreferences m9441t(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    /* renamed from: u */
    public static String m9442u(Context context, String str) {
        int m9440s = m9440s(context, str, "string");
        return m9440s > 0 ? context.getString(m9440s) : "";
    }

    /* renamed from: v */
    public static synchronized long m9443v() {
        long j;
        synchronized (w80.class) {
            if (f7631b == -1) {
                long j2 = 0;
                String m9430i = m9430i(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(m9430i)) {
                    String upperCase = m9430i.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j2 = m9428g(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            j2 = m9428g(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            j2 = m9428g(upperCase, "GB", 1073741824);
                        } else {
                            m80.m6375f().m6377b("Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e) {
                        m80.m6375f().m6380e("Unexpected meminfo format while computing RAM: " + upperCase, e);
                    }
                }
                f7631b = j2;
            }
            j = f7631b;
        }
        return j;
    }

    /* renamed from: w */
    public static String m9444w(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return m9447z(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e) {
            m80.m6375f().m6380e("Could not calculate hash for app icon.", e);
            return "";
        }
    }

    /* renamed from: x */
    public static String m9445x(String str, String str2) {
        return m9446y(str.getBytes(), str2);
    }

    /* renamed from: y */
    public static String m9446y(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return m9447z(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            m80.m6375f().m6380e("Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    /* renamed from: z */
    public static String m9447z(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f7630a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }
}

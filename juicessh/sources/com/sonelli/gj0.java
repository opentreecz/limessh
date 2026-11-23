package com.sonelli;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.sonelli.juicessh.models.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* compiled from: Log.java */
/* loaded from: classes.dex */
public class gj0 {

    /* renamed from: a */
    public static final ArrayList<String> f2882a = new ArrayList<>();

    /* renamed from: b */
    public static final Object f2883b = new Object();

    /* renamed from: a */
    public static void m4140a(String str, String str2, String str3) {
        ArrayList<String> arrayList;
        if (str3 == null || str3.length() < 1) {
            return;
        }
        Object obj = f2883b;
        synchronized (obj) {
            arrayList = f2882a;
            if (arrayList.size() >= 500) {
                arrayList.remove(0);
            }
        }
        String format = SimpleDateFormat.getDateTimeInstance(3, 3).format(new Date());
        synchronized (obj) {
            arrayList.add(format + ": " + str3);
        }
    }

    /* renamed from: b */
    public static void m4141b(String str, String str2) {
        if (str2 == null || str2.length() < 1) {
            return;
        }
        Log.d("JuiceSSH/" + str, str2);
        m4140a("debug", "JuiceSSH/" + str, str2);
    }

    /* renamed from: c */
    public static void m4142c(String str, String str2) {
        if (str2 == null || str2.length() < 1) {
            return;
        }
        Log.e("JuiceSSH/" + str, str2);
        m4140a("error", "JuiceSSH/" + str, str2);
    }

    /* renamed from: d */
    public static ArrayList<String> m4143d(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("JuiceSSH Version: " + kj0.m5920d(context));
        arrayList.add("Device Manufacturer: " + Build.MANUFACTURER);
        arrayList.add("Device Model: " + Build.MODEL);
        arrayList.add("Device Board: " + Build.BOARD);
        arrayList.add("Device Bootloader: " + Build.BOOTLOADER);
        arrayList.add("Android Version: " + Build.VERSION.CODENAME + " " + Build.VERSION.RELEASE + " (sdk:" + Build.VERSION.SDK_INT + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("CPU ABI: ");
        sb.append(Build.CPU_ABI);
        arrayList.add(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CPU ABI2: ");
        sb2.append(Build.CPU_ABI2);
        arrayList.add(sb2.toString());
        arrayList.add("Account: " + User.m5525s(context));
        arrayList.add("Account Hash: " + User.m5526t(context));
        Iterator<String> it = f2882a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* renamed from: e */
    public static void m4144e(String str, String str2) {
        if (str2 == null || str2.length() < 1) {
            return;
        }
        Log.i("JuiceSSH/" + str, str2);
        m4140a("info", "JuiceSSH/" + str, str2);
    }

    /* renamed from: f */
    public static void m4145f(String str, String str2) {
        if (str2 == null || str2.length() < 1) {
            return;
        }
        Log.v("JuiceSSH/", str2);
        m4140a("verbose", "JuiceSSH/" + str, str2);
    }
}

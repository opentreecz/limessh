package com.google.ase;

import java.io.FileDescriptor;

/* loaded from: classes.dex */
public class Exec {

    /* renamed from: a */
    public static int f1093a = 9;

    /* renamed from: b */
    public static int f1094b = 15;

    /* renamed from: c */
    public static int f1095c = 18;

    /* renamed from: d */
    public static int f1096d = 19;

    static {
        System.loadLibrary("com_google_ase_Exec");
    }

    public static native FileDescriptor createSubprocess(String str, String str2, String str3, String str4, int[] iArr);

    public static native int kill(int i, int i2);

    public static native void setPtyWindowSize(FileDescriptor fileDescriptor, int i, int i2, int i3, int i4);

    public static native int setenv(String str, String str2);

    public static native int waitFor(int i);
}

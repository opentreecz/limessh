package com.sonelli;

import java.io.PrintWriter;

/* compiled from: StatsSnapshot.java */
/* loaded from: classes.dex */
public class yl0 {

    /* renamed from: a */
    public final int f8261a;

    /* renamed from: b */
    public final int f8262b;

    /* renamed from: c */
    public final long f8263c;

    /* renamed from: d */
    public final long f8264d;

    /* renamed from: e */
    public final long f8265e;

    /* renamed from: f */
    public final long f8266f;

    /* renamed from: g */
    public final long f8267g;

    /* renamed from: h */
    public final long f8268h;

    /* renamed from: i */
    public final long f8269i;

    /* renamed from: j */
    public final long f8270j;

    /* renamed from: k */
    public final int f8271k;

    /* renamed from: l */
    public final int f8272l;

    /* renamed from: m */
    public final int f8273m;

    /* renamed from: n */
    public final long f8274n;

    public yl0(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f8261a = i;
        this.f8262b = i2;
        this.f8263c = j;
        this.f8264d = j2;
        this.f8265e = j3;
        this.f8266f = j4;
        this.f8267g = j5;
        this.f8268h = j6;
        this.f8269i = j7;
        this.f8270j = j8;
        this.f8271k = i3;
        this.f8272l = i4;
        this.f8273m = i5;
        this.f8274n = j9;
    }

    /* renamed from: a */
    public void m10189a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f8261a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f8262b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f8262b / this.f8261a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f8263c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f8264d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f8271k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f8265e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f8268h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f8272l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f8266f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f8273m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f8267g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f8269i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f8270j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f8261a + ", size=" + this.f8262b + ", cacheHits=" + this.f8263c + ", cacheMisses=" + this.f8264d + ", downloadCount=" + this.f8271k + ", totalDownloadSize=" + this.f8265e + ", averageDownloadSize=" + this.f8268h + ", totalOriginalBitmapSize=" + this.f8266f + ", totalTransformedBitmapSize=" + this.f8267g + ", averageOriginalBitmapSize=" + this.f8269i + ", averageTransformedBitmapSize=" + this.f8270j + ", originalBitmapCount=" + this.f8272l + ", transformedBitmapCount=" + this.f8273m + ", timeStamp=" + this.f8274n + '}';
    }
}

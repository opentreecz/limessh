package com.sonelli;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class r90 {

    /* renamed from: a */
    public static final FilenameFilter f6193a = new C1805a();

    /* renamed from: b */
    public static final ExecutorService f6194b = f90.m3694c("awaitEvenIfOnMainThread task continuation executor");

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.r90$a */
    /* loaded from: classes.dex */
    public class C1805a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.r90$b */
    /* loaded from: classes.dex */
    public class C1806b<T> implements Continuation<T, Void> {

        /* renamed from: a */
        public final /* synthetic */ k60 f6195a;

        public C1806b(k60 k60Var) {
            this.f6195a = k60Var;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void mo1552a(@NonNull j60<T> j60Var) throws Exception {
            if (j60Var.mo2701n()) {
                this.f6195a.m5846e(j60Var.mo2697j());
                return null;
            }
            this.f6195a.m5845d(j60Var.mo2696i());
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.r90$c */
    /* loaded from: classes.dex */
    public class RunnableC1807c implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Callable f6196O;

        /* renamed from: P */
        public final /* synthetic */ k60 f6197P;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* renamed from: com.sonelli.r90$c$a */
        /* loaded from: classes.dex */
        public class a<T> implements Continuation<T, Void> {
            public a() {
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void mo1552a(@NonNull j60<T> j60Var) throws Exception {
                if (j60Var.mo2701n()) {
                    RunnableC1807c.this.f6197P.m5844c(j60Var.mo2697j());
                    return null;
                }
                RunnableC1807c.this.f6197P.m5843b(j60Var.mo2696i());
                return null;
            }
        }

        public RunnableC1807c(Callable callable, k60 k60Var) {
            this.f6196O = callable;
            this.f6197P = k60Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ((j60) this.f6196O.call()).mo2693f(new a());
            } catch (Exception e) {
                this.f6197P.m5843b(e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.r90$d */
    /* loaded from: classes.dex */
    public class C1808d<T> implements Continuation<T, Object> {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f6199a;

        public C1808d(CountDownLatch countDownLatch) {
            this.f6199a = countDownLatch;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Object mo1552a(@NonNull j60<T> j60Var) throws Exception {
            this.f6199a.countDown();
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m7891a(j60<T> j60Var) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        j60Var.mo2694g(f6194b, new C1808d(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (j60Var.mo2700m()) {
            return j60Var.mo2697j();
        }
        throw new TimeoutException();
    }

    /* renamed from: b */
    public static <T> j60<T> m7892b(Executor executor, Callable<j60<T>> callable) {
        k60 k60Var = new k60();
        executor.execute(new RunnableC1807c(callable, k60Var));
        return k60Var.m5842a();
    }

    /* renamed from: c */
    public static int m7893c(File file, int i, Comparator<File> comparator) {
        return m7894d(file, f6193a, i, comparator);
    }

    /* renamed from: d */
    public static int m7894d(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        return m7895e(Arrays.asList(listFiles), i, comparator);
    }

    /* renamed from: e */
    public static int m7895e(List<File> list, int i, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File file : list) {
            if (size <= i) {
                return size;
            }
            m7898h(file);
            size--;
        }
        return size;
    }

    /* renamed from: f */
    public static int m7896f(File file, File file2, int i, Comparator<File> comparator) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        File[] listFiles2 = file2.listFiles(f6193a);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        arrayList.addAll(Arrays.asList(listFiles));
        arrayList.addAll(Arrays.asList(listFiles2));
        return m7895e(arrayList, i, comparator);
    }

    /* renamed from: g */
    public static <T> j60<T> m7897g(j60<T> j60Var, j60<T> j60Var2) {
        k60 k60Var = new k60();
        C1806b c1806b = new C1806b(k60Var);
        j60Var.mo2693f(c1806b);
        j60Var2.mo2693f(c1806b);
        return k60Var.m5842a();
    }

    /* renamed from: h */
    public static void m7898h(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m7898h(file2);
            }
        }
        file.delete();
    }
}

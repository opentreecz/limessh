package com.sonelli;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.io.File;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class n80 implements CrashlyticsNativeComponent {

    /* renamed from: a */
    public static final NativeSessionFileProvider f5241a = new C1593b();

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.n80$b */
    /* loaded from: classes.dex */
    public static final class C1593b implements NativeSessionFileProvider {
        public C1593b() {
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        /* renamed from: a */
        public File mo1619a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        /* renamed from: b */
        public File mo1620b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        /* renamed from: c */
        public File mo1621c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        /* renamed from: d */
        public File mo1622d() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        /* renamed from: e */
        public File mo1623e() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        /* renamed from: f */
        public File mo1624f() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        /* renamed from: g */
        public File mo1625g() {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    /* renamed from: a */
    public boolean mo1611a(@NonNull String str) {
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    @NonNull
    /* renamed from: b */
    public NativeSessionFileProvider mo1612b(@NonNull String str) {
        return f5241a;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    /* renamed from: c */
    public void mo1613c(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z, int i3, @NonNull String str3, @NonNull String str4) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    /* renamed from: d */
    public void mo1614d(@NonNull String str, @NonNull String str2, long j) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    /* renamed from: e */
    public boolean mo1615e(@NonNull String str) {
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    /* renamed from: f */
    public void mo1616f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    /* renamed from: g */
    public void mo1617g(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    /* renamed from: h */
    public boolean mo1618h(@NonNull String str) {
        return true;
    }
}

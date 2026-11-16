# LimeSSH ProGuard rules

# Keep SSHJ classes (reflection-heavy)
-keep class net.schmizz.sshj.** { *; }
-keep class com.hierynomus.sshj.** { *; }

# Keep BouncyCastle providers
-keep class org.bouncycastle.** { *; }
-dontwarn org.bouncycastle.**

# SSHJ also contains desktop GSS/Kerberos authentication. Android has no JAAS/
# JGSS implementation, and limessh exposes password, key and interactive auth only.
-dontwarn javax.security.auth.login.LoginContext
-dontwarn org.ietf.jgss.**

# Tink's Error Prone annotations describe compile-time checks, not runtime APIs.
-dontwarn com.google.errorprone.annotations.CanIgnoreReturnValue
-dontwarn com.google.errorprone.annotations.CheckReturnValue
-dontwarn com.google.errorprone.annotations.Immutable
-dontwarn com.google.errorprone.annotations.RestrictedApi

# Keep Room entities
-keep class cz.opentree.limessh.data.local.entity.** { *; }

# Keep AIDL/Parcelable for future plugin SDK
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

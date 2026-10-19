# LimeSSH ProGuard rules

# Keep SSHJ classes (reflection-heavy)
-keep class net.schmizz.sshj.** { *; }
-keep class com.hierynomus.sshj.** { *; }

# Keep BouncyCastle providers
-keep class org.bouncycastle.** { *; }
-dontwarn org.bouncycastle.**

# Keep Room entities
-keep class cz.opentree.limessh.data.local.entity.** { *; }

# Keep AIDL/Parcelable for future plugin SDK
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

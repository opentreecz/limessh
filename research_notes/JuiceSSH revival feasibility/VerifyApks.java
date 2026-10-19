import com.android.apksig.ApkVerifier;
import java.io.File;
import java.security.MessageDigest;
import java.util.HexFormat;

/** Static Android APK signature verification using Google's apksig library. */
class VerifyApks {
    public static void main(String[] args) throws Exception {
        for (String path : args) {
            var result = new ApkVerifier.Builder(new File(path)).build().verify();
            System.out.println(path);
            System.out.printf("verified=%s v1=%s v2=%s v3=%s%n", result.isVerified(),
                result.isVerifiedUsingV1Scheme(), result.isVerifiedUsingV2Scheme(),
                result.isVerifiedUsingV3Scheme());
            for (var cert : result.getSignerCertificates()) {
                System.out.println("cert-sha256=" + HexFormat.of().formatHex(
                    MessageDigest.getInstance("SHA-256").digest(cert.getEncoded())));
            }
            System.out.println("errors=" + result.getErrors());
            System.out.println("warnings=" + result.getWarnings());
        }
    }
}

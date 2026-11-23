package com.amazonaws.internal.config;

import androidx.core.app.NotificationCompat;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class InternalConfig {

    /* renamed from: g */
    public static final Log f159g = LogFactory.m237c(InternalConfig.class);

    /* renamed from: a */
    public final SignerConfig f160a = m219f();

    /* renamed from: c */
    public final Map<String, SignerConfig> f162c = m216c();

    /* renamed from: d */
    public final Map<String, SignerConfig> f163d = m218e();

    /* renamed from: b */
    public final Map<String, SignerConfig> f161b = m217d();

    /* renamed from: e */
    public final Map<String, HttpClientConfig> f164e = m215b();

    /* renamed from: f */
    public final List<HostRegexToRegionMapping> f165f = m214a();

    /* loaded from: classes.dex */
    public static class Factory {

        /* renamed from: a */
        public static final InternalConfig f166a;

        static {
            try {
                f166a = new InternalConfig();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new IllegalStateException("Fatal: Failed to load the internal config for AWS Android SDK", e2);
            }
        }

        /* renamed from: a */
        public static InternalConfig m223a() {
            return f166a;
        }
    }

    /* renamed from: a */
    public static List<HostRegexToRegionMapping> m214a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HostRegexToRegionMapping("(.+\\.)?s3\\.amazonaws\\.com", "us-east-1"));
        arrayList.add(new HostRegexToRegionMapping("(.+\\.)?s3-external-1\\.amazonaws\\.com", "us-east-1"));
        arrayList.add(new HostRegexToRegionMapping("(.+\\.)?s3-fips-us-gov-west-1\\.amazonaws\\.com", "us-gov-west-1"));
        return arrayList;
    }

    /* renamed from: b */
    public static Map<String, HttpClientConfig> m215b() {
        HashMap hashMap = new HashMap();
        hashMap.put("AmazonCloudWatchClient", new HttpClientConfig("monitoring"));
        hashMap.put("AmazonCloudWatchLogsClient", new HttpClientConfig("logs"));
        hashMap.put("AmazonCognitoIdentityClient", new HttpClientConfig("cognito-identity"));
        hashMap.put("AmazonCognitoIdentityProviderClient", new HttpClientConfig("cognito-idp"));
        hashMap.put("AmazonCognitoSyncClient", new HttpClientConfig("cognito-sync"));
        hashMap.put("AmazonComprehendClient", new HttpClientConfig("comprehend"));
        hashMap.put("AmazonConnectClient", new HttpClientConfig("connect"));
        hashMap.put("AmazonKinesisFirehoseClient", new HttpClientConfig("firehose"));
        hashMap.put("AWSKinesisVideoArchivedMediaClient", new HttpClientConfig("kinesisvideo"));
        hashMap.put("AWSKinesisVideoSignalingClient", new HttpClientConfig("kinesisvideo"));
        hashMap.put("AWSIotClient", new HttpClientConfig("execute-api"));
        hashMap.put("AmazonLexRuntimeClient", new HttpClientConfig("runtime.lex"));
        hashMap.put("AmazonPinpointClient", new HttpClientConfig("mobiletargeting"));
        hashMap.put("AmazonPinpointAnalyticsClient", new HttpClientConfig("mobileanalytics"));
        hashMap.put("AmazonSageMakerRuntimeClient", new HttpClientConfig("sagemaker"));
        hashMap.put("AmazonSimpleDBClient", new HttpClientConfig("sdb"));
        hashMap.put("AmazonSimpleEmailServiceClient", new HttpClientConfig(NotificationCompat.CATEGORY_EMAIL));
        hashMap.put("AWSSecurityTokenServiceClient", new HttpClientConfig("sts"));
        hashMap.put("AmazonTextractClient", new HttpClientConfig("textract"));
        hashMap.put("AmazonTranscribeClient", new HttpClientConfig("transcribe"));
        hashMap.put("AmazonTranslateClient", new HttpClientConfig("translate"));
        return hashMap;
    }

    /* renamed from: c */
    public static Map<String, SignerConfig> m216c() {
        HashMap hashMap = new HashMap();
        hashMap.put("eu-central-1", new SignerConfig("AWS4SignerType"));
        hashMap.put("cn-north-1", new SignerConfig("AWS4SignerType"));
        return hashMap;
    }

    /* renamed from: d */
    public static Map<String, SignerConfig> m217d() {
        HashMap hashMap = new HashMap();
        hashMap.put("s3/eu-central-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/cn-north-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/us-east-2", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/ca-central-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/ap-south-1", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/ap-northeast-2", new SignerConfig("AWSS3V4SignerType"));
        hashMap.put("s3/eu-west-2", new SignerConfig("AWSS3V4SignerType"));
        return hashMap;
    }

    /* renamed from: e */
    public static Map<String, SignerConfig> m218e() {
        HashMap hashMap = new HashMap();
        hashMap.put("ec2", new SignerConfig("QueryStringSignerType"));
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, new SignerConfig("AWS3SignerType"));
        hashMap.put("s3", new SignerConfig("S3SignerType"));
        hashMap.put("sdb", new SignerConfig("QueryStringSignerType"));
        hashMap.put("runtime.lex", new SignerConfig("AmazonLexV4Signer"));
        hashMap.put("polly", new SignerConfig("AmazonPollyCustomPresigner"));
        return hashMap;
    }

    /* renamed from: f */
    public static SignerConfig m219f() {
        return new SignerConfig("AWS4SignerType");
    }

    /* renamed from: g */
    public List<HostRegexToRegionMapping> m220g() {
        return Collections.unmodifiableList(this.f165f);
    }

    /* renamed from: h */
    public HttpClientConfig m221h(String str) {
        return this.f164e.get(str);
    }

    /* renamed from: i */
    public SignerConfig m222i(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (str2 != null) {
            SignerConfig signerConfig = this.f161b.get(str + "/" + str2);
            if (signerConfig != null) {
                return signerConfig;
            }
            SignerConfig signerConfig2 = this.f162c.get(str2);
            if (signerConfig2 != null) {
                return signerConfig2;
            }
        }
        SignerConfig signerConfig3 = this.f163d.get(str);
        return signerConfig3 == null ? this.f160a : signerConfig3;
    }
}

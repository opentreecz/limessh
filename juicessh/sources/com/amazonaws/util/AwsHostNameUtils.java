package com.amazonaws.util;

import com.amazonaws.internal.config.HostRegexToRegionMapping;
import com.amazonaws.internal.config.InternalConfig;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AwsHostNameUtils {

    /* renamed from: a */
    public static final Pattern f473a = Pattern.compile("^(?:.+\\.)?s3[.-]([a-z0-9-]+)$");

    /* renamed from: a */
    public static String m637a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("hostname cannot be null");
        }
        String m638b = m638b(str);
        if (m638b != null) {
            return m638b;
        }
        if (str.endsWith(".amazonaws.com")) {
            return m640d(str.substring(0, str.length() - 14));
        }
        if (str.endsWith(".amazonaws.com.cn")) {
            return m640d(str.substring(0, str.length() - 17));
        }
        if (str2 == null) {
            return "us-east-1";
        }
        Matcher matcher = Pattern.compile("^(?:.+\\.)?" + Pattern.quote(str2) + "[.-]([a-z0-9-]+)\\.").matcher(str);
        return matcher.find() ? matcher.group(1) : "us-east-1";
    }

    /* renamed from: b */
    public static String m638b(String str) {
        for (HostRegexToRegionMapping hostRegexToRegionMapping : InternalConfig.Factory.m223a().m220g()) {
            if (str.matches(hostRegexToRegionMapping.m211a())) {
                return hostRegexToRegionMapping.m212b();
            }
        }
        return null;
    }

    @Deprecated
    /* renamed from: c */
    public static String m639c(URI uri) {
        String host = uri.getHost();
        if (host.endsWith(".amazonaws.com")) {
            String substring = host.substring(0, host.indexOf(".amazonaws.com"));
            return (substring.endsWith(".s3") || f473a.matcher(substring).matches()) ? "s3" : substring.indexOf(46) == -1 ? substring : substring.substring(0, substring.indexOf(46));
        }
        throw new IllegalArgumentException("Cannot parse a service name from an unrecognized endpoint (" + host + ").");
    }

    /* renamed from: d */
    public static String m640d(String str) {
        Matcher matcher = f473a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "us-east-1";
        }
        String substring = str.substring(lastIndexOf + 1);
        return "us-gov".equals(substring) ? "us-gov-west-1" : substring;
    }
}

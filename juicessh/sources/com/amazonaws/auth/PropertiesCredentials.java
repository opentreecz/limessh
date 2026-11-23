package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* loaded from: classes.dex */
public class PropertiesCredentials implements AWSCredentials {

    /* renamed from: a */
    public final String f97a;

    /* renamed from: b */
    public final String f98b;

    public PropertiesCredentials(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            if (properties.getProperty("accessKey") != null && properties.getProperty("secretKey") != null) {
                this.f97a = properties.getProperty("accessKey");
                this.f98b = properties.getProperty("secretKey");
            } else {
                throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.amazonaws.auth.AWSCredentials
    /* renamed from: a */
    public String mo96a() {
        return this.f97a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    /* renamed from: b */
    public String mo97b() {
        return this.f98b;
    }
}

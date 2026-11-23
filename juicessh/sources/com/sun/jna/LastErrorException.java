package com.sun.jna;

/* loaded from: classes.dex */
public class LastErrorException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private int errorCode;

    public LastErrorException(int i) {
        this(i, formatMessage(i));
    }

    public LastErrorException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public LastErrorException(String str) {
        super(parseMessage(str.trim()));
        try {
            this.errorCode = Integer.parseInt(str.startsWith("[") ? str.substring(1, str.indexOf("]")) : str);
        } catch (NumberFormatException unused) {
            this.errorCode = -1;
        }
    }

    private static String formatMessage(int i) {
        StringBuilder sb;
        String str;
        if (Platform.isWindows()) {
            sb = new StringBuilder();
            str = "GetLastError() returned ";
        } else {
            sb = new StringBuilder();
            str = "errno was ";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    private static String parseMessage(String str) {
        try {
            return formatMessage(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}

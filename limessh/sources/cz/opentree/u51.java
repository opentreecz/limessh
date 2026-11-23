package cz.opentree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class u51 extends BufferedReader {
    public u51(Reader reader) {
        super(reader);
    }

    /* renamed from: a */
    public final t51 m8854a(String str) throws IOException {
        String readLine;
        String str2 = "-----END " + str;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = readLine();
            if (readLine == null) {
                break;
            }
            if (readLine.indexOf(":") >= 0) {
                int indexOf = readLine.indexOf(58);
                arrayList.add(new s51(readLine.substring(0, indexOf), readLine.substring(indexOf + 1).trim()));
            } else {
                if (readLine.indexOf(str2) != -1) {
                    break;
                }
                stringBuffer.append(readLine.trim());
            }
        }
        if (readLine != null) {
            return new t51(str, arrayList, k51.m5841a(stringBuffer.toString()));
        }
        throw new IOException(str2 + " not found");
    }

    /* renamed from: b */
    public t51 m8855b() throws IOException {
        String readLine;
        String substring;
        int indexOf;
        do {
            readLine = readLine();
            if (readLine == null) {
                break;
            }
        } while (!readLine.startsWith("-----BEGIN "));
        if (readLine == null || (indexOf = (substring = readLine.substring(11)).indexOf(45)) <= 0 || !substring.endsWith("-----") || substring.length() - indexOf != 5) {
            return null;
        }
        return m8854a(substring.substring(0, indexOf));
    }
}

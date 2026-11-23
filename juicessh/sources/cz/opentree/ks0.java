package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public class ks0 {

    /* renamed from: a */
    public static final long f4646a = Runtime.getRuntime().maxMemory();

    /* renamed from: a */
    public static int m5992a(int i) {
        int i2 = 1;
        if (i > 127) {
            int i3 = 1;
            while (true) {
                i >>>= 8;
                if (i == 0) {
                    break;
                }
                i3++;
            }
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: b */
    public static int m5993b(int i) throws IOException {
        if (i < 31) {
            return 1;
        }
        if (i < 128) {
            return 2;
        }
        byte[] bArr = new byte[5];
        int i2 = 4;
        do {
            i >>= 7;
            i2--;
            bArr[i2] = (byte) ((i & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
        } while (i > 127);
        return 1 + (5 - i2);
    }

    /* renamed from: c */
    public static int m5994c(InputStream inputStream) {
        if (inputStream instanceof is0) {
            return ((is0) inputStream).m4916a();
        }
        if (inputStream instanceof wp0) {
            return ((wp0) inputStream).m9627f();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j = f4646a;
        return j > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) j;
    }
}

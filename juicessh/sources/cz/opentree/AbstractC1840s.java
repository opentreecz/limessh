package cz.opentree;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.Reader;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.s */
/* loaded from: classes.dex */
public abstract class AbstractC1840s {
    @NonNull
    /* renamed from: b */
    public static AbstractC1840s m8288b(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader.peek() == JsonToken.STRING ? new C1531m(Long.parseLong(jsonReader.nextString())) : new C1531m(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    /* renamed from: a */
    public abstract long mo6326a();
}

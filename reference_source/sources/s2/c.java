package s2;

import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c {
    public static void a(InputStream inputStream) {
        while (inputStream.available() != 0) {
            try {
                inputStream.skip(inputStream.available());
            } catch (IOException unused) {
                return;
            }
        }
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\'');
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '\'') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append('\'');
        return sb.toString();
    }

    public static boolean c() {
        return Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
    }
}

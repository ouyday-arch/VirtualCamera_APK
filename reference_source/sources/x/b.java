package x;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public class b extends Writer {

    /* renamed from: b, reason: collision with root package name */
    private final String f6459b;

    /* renamed from: c, reason: collision with root package name */
    private StringBuilder f6460c = new StringBuilder(128);

    public b(String str) {
        this.f6459b = str;
    }

    private void i() {
        if (this.f6460c.length() > 0) {
            Log.d(this.f6459b, this.f6460c.toString());
            StringBuilder sb = this.f6460c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        i();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        i();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            char c5 = cArr[i4 + i6];
            if (c5 == '\n') {
                i();
            } else {
                this.f6460c.append(c5);
            }
        }
    }
}

package b4;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface e0 extends Closeable, Flushable {
    void F(d dVar, long j4);

    h0 b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}

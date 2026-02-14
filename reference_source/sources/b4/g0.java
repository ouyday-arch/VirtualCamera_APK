package b4;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface g0 extends Closeable {
    h0 b();

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close();

    long u(d dVar, long j4);
}

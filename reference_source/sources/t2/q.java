package t2;

import java.io.Closeable;
import java.io.OutputStream;

/* loaded from: classes.dex */
interface q extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
    }

    void g(OutputStream outputStream);
}

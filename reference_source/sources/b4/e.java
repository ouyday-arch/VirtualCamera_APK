package b4;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface e extends e0, WritableByteChannel {
    e A(g gVar);

    e B(int i4);

    d a();

    e c(byte[] bArr);

    e d(byte[] bArr, int i4, int i5);

    @Override // b4.e0, java.io.Flushable
    void flush();

    e h(String str, int i4, int i5);

    e j(long j4);

    e q(int i4);

    e r(int i4);

    e t(int i4);

    e x(String str);
}

package b4;

import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class k0 {
    public static final byte[] a(String str) {
        e3.f.e(str, "<this>");
        byte[] bytes = str.getBytes(j3.d.f4249b);
        e3.f.d(bytes, "getBytes(...)");
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        e3.f.e(bArr, "<this>");
        return new String(bArr, j3.d.f4249b);
    }
}

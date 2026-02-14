package b4;

import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public final class q extends h {

    /* renamed from: f, reason: collision with root package name */
    private final RandomAccessFile f2386f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(boolean z4, RandomAccessFile randomAccessFile) {
        super(z4);
        e3.f.e(randomAccessFile, "randomAccessFile");
        this.f2386f = randomAccessFile;
    }

    @Override // b4.h
    protected synchronized void M() {
        this.f2386f.close();
    }

    @Override // b4.h
    protected synchronized int N(long j4, byte[] bArr, int i4, int i5) {
        e3.f.e(bArr, "array");
        this.f2386f.seek(j4);
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                break;
            }
            int read = this.f2386f.read(bArr, i4, i5 - i6);
            if (read != -1) {
                i6 += read;
            } else if (i6 == 0) {
                return -1;
            }
        }
        return i6;
    }

    @Override // b4.h
    protected synchronized long O() {
        return this.f2386f.length();
    }
}

package i2;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f4130a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4131b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4132c;

    public b(int i4, int i5) {
        this.f4130a = (byte[][]) Array.newInstance((Class<?>) byte.class, i5, i4);
        this.f4131b = i4;
        this.f4132c = i5;
    }

    public void a(byte b5) {
        for (byte[] bArr : this.f4130a) {
            Arrays.fill(bArr, b5);
        }
    }

    public byte b(int i4, int i5) {
        return this.f4130a[i5][i4];
    }

    public byte[][] c() {
        return this.f4130a;
    }

    public int d() {
        return this.f4132c;
    }

    public int e() {
        return this.f4131b;
    }

    public void f(int i4, int i5, int i6) {
        this.f4130a[i5][i4] = (byte) i6;
    }

    public void g(int i4, int i5, boolean z4) {
        this.f4130a[i5][i4] = z4 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f4131b * 2 * this.f4132c) + 2);
        for (int i4 = 0; i4 < this.f4132c; i4++) {
            byte[] bArr = this.f4130a[i4];
            for (int i5 = 0; i5 < this.f4131b; i5++) {
                byte b5 = bArr[i5];
                sb.append(b5 != 0 ? b5 != 1 ? "  " : " 1" : " 0");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

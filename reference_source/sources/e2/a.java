package e2;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f3592a;

    /* renamed from: b, reason: collision with root package name */
    private int f3593b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3594c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3595d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i4, int i5) {
        b[] bVarArr = new b[i4];
        this.f3592a = bVarArr;
        int length = bVarArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f3592a[i6] = new b(((i5 + 4) * 17) + 1);
        }
        this.f3595d = i5 * 17;
        this.f3594c = i4;
        this.f3593b = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a() {
        return this.f3592a[this.f3593b];
    }

    public byte[][] b(int i4, int i5) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f3594c * i5, this.f3595d * i4);
        int i6 = this.f3594c * i5;
        for (int i7 = 0; i7 < i6; i7++) {
            bArr[(i6 - i7) - 1] = this.f3592a[i7 / i5].b(i4);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f3593b++;
    }
}

package b4;

import b4.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2291a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f2292b;

    static {
        g.a aVar = g.f2337e;
        f2291a = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").f();
        f2292b = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").f();
    }

    public static final String a(byte[] bArr, byte[] bArr2) {
        e3.f.e(bArr, "<this>");
        e3.f.e(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i4 + 1;
            byte b5 = bArr[i4];
            int i7 = i6 + 1;
            byte b6 = bArr[i6];
            int i8 = i7 + 1;
            byte b7 = bArr[i7];
            int i9 = i5 + 1;
            bArr3[i5] = bArr2[(b5 & 255) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            int i11 = i10 + 1;
            bArr3[i10] = bArr2[((b6 & 15) << 2) | ((b7 & 255) >> 6)];
            i5 = i11 + 1;
            bArr3[i11] = bArr2[b7 & 63];
            i4 = i8;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b8 = bArr[i4];
            int i12 = i5 + 1;
            bArr3[i5] = bArr2[(b8 & 255) >> 2];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[(b8 & 3) << 4];
            bArr3[i13] = 61;
            bArr3[i13 + 1] = 61;
        } else if (length2 == 2) {
            int i14 = i4 + 1;
            byte b9 = bArr[i4];
            byte b10 = bArr[i14];
            int i15 = i5 + 1;
            bArr3[i5] = bArr2[(b9 & 255) >> 2];
            int i16 = i15 + 1;
            bArr3[i15] = bArr2[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            bArr3[i16] = bArr2[(b10 & 15) << 2];
            bArr3[i16 + 1] = 61;
        }
        return k0.c(bArr3);
    }

    public static /* synthetic */ String b(byte[] bArr, byte[] bArr2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bArr2 = f2291a;
        }
        return a(bArr, bArr2);
    }
}

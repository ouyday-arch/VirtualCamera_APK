package b4;

/* loaded from: classes.dex */
public final class i0 {
    public static final long a(String str, int i4, int i5) {
        int i6;
        e3.f.e(str, "<this>");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (!(i5 >= i4)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
        }
        if (!(i5 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + str.length()).toString());
        }
        long j4 = 0;
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt < 128) {
                j4++;
            } else {
                if (charAt < 2048) {
                    i6 = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i6 = 3;
                } else {
                    int i7 = i4 + 1;
                    char charAt2 = i7 < i5 ? str.charAt(i7) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j4++;
                        i4 = i7;
                    } else {
                        j4 += 4;
                        i4 += 2;
                    }
                }
                j4 += i6;
            }
            i4++;
        }
        return j4;
    }

    public static /* synthetic */ long b(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return a(str, i4, i5);
    }
}

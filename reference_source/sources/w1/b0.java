package w1;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public final class b0 extends z {
    @Override // w1.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + y.s(a0.t(str));
            } catch (g1.h e4) {
                throw new IllegalArgumentException(e4);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!y.j(a0.t(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (g1.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        s.c(str);
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i4 = a0.f6356k[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int b5 = s.b(zArr, 0, y.f6406d, true);
        for (int i5 = 1; i5 <= 6; i5++) {
            int digit2 = Character.digit(str.charAt(i5), 10);
            if (((i4 >> (6 - i5)) & 1) == 1) {
                digit2 += 10;
            }
            b5 += s.b(zArr, b5, y.f6410h[digit2], false);
        }
        s.b(zArr, b5, y.f6408f, false);
        return zArr;
    }

    @Override // w1.s
    protected Collection<g1.a> f() {
        return Collections.singleton(g1.a.UPC_E);
    }
}

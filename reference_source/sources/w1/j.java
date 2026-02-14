package w1;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public final class j extends z {
    @Override // w1.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + y.s(str);
            } catch (g1.h e4) {
                throw new IllegalArgumentException(e4);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!y.j(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (g1.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        s.c(str);
        int i4 = i.f6378j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int b5 = s.b(zArr, 0, y.f6406d, true) + 0;
        for (int i5 = 1; i5 <= 6; i5++) {
            int digit = Character.digit(str.charAt(i5), 10);
            if (((i4 >> (6 - i5)) & 1) == 1) {
                digit += 10;
            }
            b5 += s.b(zArr, b5, y.f6410h[digit], false);
        }
        int b6 = b5 + s.b(zArr, b5, y.f6407e, false);
        for (int i6 = 7; i6 <= 12; i6++) {
            b6 += s.b(zArr, b6, y.f6409g[Character.digit(str.charAt(i6), 10)], true);
        }
        s.b(zArr, b6, y.f6406d, true);
        return zArr;
    }

    @Override // w1.s
    protected Collection<g1.a> f() {
        return Collections.singleton(g1.a.EAN_13);
    }
}

package w1;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public final class l extends z {
    @Override // w1.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + y.s(str);
            } catch (g1.h e4) {
                throw new IllegalArgumentException(e4);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got ".concat(String.valueOf(length)));
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
        boolean[] zArr = new boolean[67];
        int b5 = s.b(zArr, 0, y.f6406d, true) + 0;
        for (int i4 = 0; i4 <= 3; i4++) {
            b5 += s.b(zArr, b5, y.f6409g[Character.digit(str.charAt(i4), 10)], false);
        }
        int b6 = b5 + s.b(zArr, b5, y.f6407e, false);
        for (int i5 = 4; i5 <= 7; i5++) {
            b6 += s.b(zArr, b6, y.f6409g[Character.digit(str.charAt(i5), 10)], true);
        }
        s.b(zArr, b6, y.f6406d, true);
        return zArr;
    }

    @Override // w1.s
    protected Collection<g1.a> f() {
        return Collections.singleton(g1.a.EAN_8);
    }
}

package t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements g {
    private static char c(char c5, int i4) {
        int i5 = c5 + ((i4 * 149) % 255) + 1;
        return i5 <= 255 ? (char) i5 : (char) (i5 - 256);
    }

    @Override // t1.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.i()) {
                break;
            }
            sb.append(hVar.c());
            hVar.f5926f++;
            if (j.n(hVar.d(), hVar.f5926f, b()) != b()) {
                hVar.o(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a5 = hVar.a() + length + 1;
        hVar.q(a5);
        boolean z4 = hVar.g().a() - a5 > 0;
        if (hVar.i() || z4) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i4 = 0; i4 < length2; i4++) {
            hVar.r(c(sb.charAt(i4), hVar.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}

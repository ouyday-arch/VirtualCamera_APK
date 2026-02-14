package t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements g {
    private static void b(char c5, StringBuilder sb) {
        if (c5 >= ' ' && c5 <= '?') {
            sb.append(c5);
        } else if (c5 < '@' || c5 > '^') {
            j.e(c5);
        } else {
            sb.append((char) (c5 - '@'));
        }
    }

    private static String c(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int charAt = (charSequence.charAt(0) << 18) + ((length >= 2 ? charSequence.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(3) : (char) 0);
        char c5 = (char) ((charAt >> 16) & 255);
        char c6 = (char) ((charAt >> 8) & 255);
        char c7 = (char) (charAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c5);
        if (length >= 2) {
            sb.append(c6);
        }
        if (length >= 3) {
            sb.append(c7);
        }
        return sb.toString();
    }

    private static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z4 = true;
            if (length == 1) {
                hVar.p();
                int a5 = hVar.g().a() - hVar.a();
                int f4 = hVar.f();
                if (f4 > a5) {
                    hVar.q(hVar.a() + 1);
                    a5 = hVar.g().a() - hVar.a();
                }
                if (f4 <= a5 && a5 <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i4 = length - 1;
            String c5 = c(charSequence);
            if (!(!hVar.i()) || i4 > 2) {
                z4 = false;
            }
            if (i4 <= 2) {
                hVar.q(hVar.a() + i4);
                if (hVar.g().a() - hVar.a() >= 3) {
                    hVar.q(hVar.a() + c5.length());
                    z4 = false;
                }
            }
            if (z4) {
                hVar.k();
                hVar.f5926f -= i4;
            } else {
                hVar.s(c5);
            }
        } finally {
            hVar.o(0);
        }
    }

    @Override // t1.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            b(hVar.c(), sb);
            hVar.f5926f++;
            if (sb.length() >= 4) {
                hVar.s(c(sb));
                sb.delete(0, 4);
                if (j.n(hVar.d(), hVar.f5926f, d()) != d()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(hVar, sb);
    }

    public int d() {
        return 4;
    }
}

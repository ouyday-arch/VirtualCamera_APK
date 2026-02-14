package t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends c {
    @Override // t1.c, t1.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c5 = hVar.c();
            hVar.f5926f++;
            c(c5, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                if (j.n(hVar.d(), hVar.f5926f, e()) != e()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // t1.c
    int c(char c5, StringBuilder sb) {
        char c6;
        int i4;
        if (c5 == '\r') {
            c6 = 0;
        } else {
            if (c5 != ' ') {
                if (c5 == '*') {
                    sb.append((char) 1);
                } else if (c5 != '>') {
                    if (c5 >= '0' && c5 <= '9') {
                        i4 = (c5 - '0') + 4;
                    } else if (c5 < 'A' || c5 > 'Z') {
                        j.e(c5);
                    } else {
                        i4 = (c5 - 'A') + 14;
                    }
                    c6 = (char) i4;
                } else {
                    c6 = 2;
                }
                return 1;
            }
            c6 = 3;
        }
        sb.append(c6);
        return 1;
    }

    @Override // t1.c
    public int e() {
        return 3;
    }

    @Override // t1.c
    void f(h hVar, StringBuilder sb) {
        hVar.p();
        int a5 = hVar.g().a() - hVar.a();
        hVar.f5926f -= sb.length();
        if (hVar.f() > 1 || a5 > 1 || hVar.f() != a5) {
            hVar.r((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.o(0);
        }
    }
}

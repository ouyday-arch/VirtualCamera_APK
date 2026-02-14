package t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements g {
    private static char b(char c5, char c6) {
        if (j.f(c5) && j.f(c6)) {
            return (char) (((c5 - '0') * 10) + (c6 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c5 + c6);
    }

    @Override // t1.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f5926f) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f5926f), hVar.d().charAt(hVar.f5926f + 1)));
            hVar.f5926f += 2;
            return;
        }
        char c5 = hVar.c();
        int n4 = j.n(hVar.d(), hVar.f5926f, c());
        if (n4 == c()) {
            if (!j.g(c5)) {
                hVar.r((char) (c5 + 1));
                hVar.f5926f++;
                return;
            } else {
                hVar.r((char) 235);
                hVar.r((char) ((c5 - 128) + 1));
                hVar.f5926f++;
                return;
            }
        }
        if (n4 == 1) {
            hVar.r((char) 230);
            hVar.o(1);
            return;
        }
        if (n4 == 2) {
            hVar.r((char) 239);
            hVar.o(2);
            return;
        }
        if (n4 == 3) {
            hVar.r((char) 238);
            hVar.o(3);
        } else if (n4 == 4) {
            hVar.r((char) 240);
            hVar.o(4);
        } else {
            if (n4 != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(n4)));
            }
            hVar.r((char) 231);
            hVar.o(5);
        }
    }

    public int c() {
        return 0;
    }
}

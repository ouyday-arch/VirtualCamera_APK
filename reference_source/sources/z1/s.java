package z1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final n1.a f6686a;

    /* renamed from: b, reason: collision with root package name */
    private final m f6687b = new m();

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f6688c = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(n1.a aVar) {
        this.f6686a = aVar;
    }

    private n b(int i4) {
        char c5;
        int f4 = f(i4, 5);
        if (f4 == 15) {
            return new n(i4 + 5, '$');
        }
        if (f4 >= 5 && f4 < 15) {
            return new n(i4 + 5, (char) ((f4 + 48) - 5));
        }
        int f5 = f(i4, 6);
        if (f5 >= 32 && f5 < 58) {
            return new n(i4 + 6, (char) (f5 + 33));
        }
        switch (f5) {
            case m0.k.A4 /* 58 */:
                c5 = '*';
                break;
            case m0.k.B4 /* 59 */:
                c5 = ',';
                break;
            case m0.k.C4 /* 60 */:
                c5 = '-';
                break;
            case m0.k.D4 /* 61 */:
                c5 = '.';
                break;
            case 62:
                c5 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(f5)));
        }
        return new n(i4 + 6, c5);
    }

    private n d(int i4) {
        char c5;
        int f4 = f(i4, 5);
        if (f4 == 15) {
            return new n(i4 + 5, '$');
        }
        if (f4 >= 5 && f4 < 15) {
            return new n(i4 + 5, (char) ((f4 + 48) - 5));
        }
        int f5 = f(i4, 7);
        if (f5 >= 64 && f5 < 90) {
            return new n(i4 + 7, (char) (f5 + 1));
        }
        if (f5 >= 90 && f5 < 116) {
            return new n(i4 + 7, (char) (f5 + 7));
        }
        switch (f(i4, 8)) {
            case 232:
                c5 = '!';
                break;
            case 233:
                c5 = '\"';
                break;
            case 234:
                c5 = '%';
                break;
            case 235:
                c5 = '&';
                break;
            case 236:
                c5 = '\'';
                break;
            case 237:
                c5 = '(';
                break;
            case 238:
                c5 = ')';
                break;
            case 239:
                c5 = '*';
                break;
            case 240:
                c5 = '+';
                break;
            case 241:
                c5 = ',';
                break;
            case 242:
                c5 = '-';
                break;
            case 243:
                c5 = '.';
                break;
            case 244:
                c5 = '/';
                break;
            case 245:
                c5 = ':';
                break;
            case 246:
                c5 = ';';
                break;
            case 247:
                c5 = '<';
                break;
            case 248:
                c5 = '=';
                break;
            case 249:
                c5 = '>';
                break;
            case 250:
                c5 = '?';
                break;
            case 251:
                c5 = '_';
                break;
            case 252:
                c5 = ' ';
                break;
            default:
                throw g1.h.a();
        }
        return new n(i4 + 8, c5);
    }

    private p e(int i4) {
        int i5 = i4 + 7;
        if (i5 > this.f6686a.l()) {
            int f4 = f(i4, 4);
            return f4 == 0 ? new p(this.f6686a.l(), 10, 10) : new p(this.f6686a.l(), f4 - 1, 10);
        }
        int f5 = f(i4, 7) - 8;
        return new p(i5, f5 / 11, f5 % 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(n1.a aVar, int i4, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (aVar.g(i4 + i7)) {
                i6 |= 1 << ((i5 - i7) - 1);
            }
        }
        return i6;
    }

    private boolean h(int i4) {
        int i5 = i4 + 3;
        if (i5 > this.f6686a.l()) {
            return false;
        }
        while (i4 < i5) {
            if (this.f6686a.g(i4)) {
                return false;
            }
            i4++;
        }
        return true;
    }

    private boolean i(int i4) {
        int i5;
        if (i4 + 1 > this.f6686a.l()) {
            return false;
        }
        for (int i6 = 0; i6 < 5 && (i5 = i6 + i4) < this.f6686a.l(); i6++) {
            if (i6 == 2) {
                if (!this.f6686a.g(i4 + 2)) {
                    return false;
                }
            } else if (this.f6686a.g(i5)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i4) {
        int i5;
        if (i4 + 1 > this.f6686a.l()) {
            return false;
        }
        for (int i6 = 0; i6 < 4 && (i5 = i6 + i4) < this.f6686a.l(); i6++) {
            if (this.f6686a.g(i5)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i4) {
        int f4;
        if (i4 + 5 > this.f6686a.l()) {
            return false;
        }
        int f5 = f(i4, 5);
        if (f5 < 5 || f5 >= 16) {
            return i4 + 6 <= this.f6686a.l() && (f4 = f(i4, 6)) >= 16 && f4 < 63;
        }
        return true;
    }

    private boolean l(int i4) {
        int f4;
        if (i4 + 5 > this.f6686a.l()) {
            return false;
        }
        int f5 = f(i4, 5);
        if (f5 >= 5 && f5 < 16) {
            return true;
        }
        if (i4 + 7 > this.f6686a.l()) {
            return false;
        }
        int f6 = f(i4, 7);
        if (f6 < 64 || f6 >= 116) {
            return i4 + 8 <= this.f6686a.l() && (f4 = f(i4, 8)) >= 232 && f4 < 253;
        }
        return true;
    }

    private boolean m(int i4) {
        if (i4 + 7 > this.f6686a.l()) {
            return i4 + 4 <= this.f6686a.l();
        }
        int i5 = i4;
        while (true) {
            int i6 = i4 + 3;
            if (i5 >= i6) {
                return this.f6686a.g(i6);
            }
            if (this.f6686a.g(i5)) {
                return true;
            }
            i5++;
        }
    }

    private l n() {
        while (k(this.f6687b.a())) {
            n b5 = b(this.f6687b.a());
            this.f6687b.h(b5.a());
            if (b5.c()) {
                return new l(new o(this.f6687b.a(), this.f6688c.toString()), true);
            }
            this.f6688c.append(b5.b());
        }
        if (h(this.f6687b.a())) {
            this.f6687b.b(3);
            this.f6687b.g();
        } else if (i(this.f6687b.a())) {
            if (this.f6687b.a() + 5 < this.f6686a.l()) {
                this.f6687b.b(5);
            } else {
                this.f6687b.h(this.f6686a.l());
            }
            this.f6687b.f();
        }
        return new l(false);
    }

    private o o() {
        l n4;
        boolean b5;
        do {
            int a5 = this.f6687b.a();
            n4 = this.f6687b.c() ? n() : this.f6687b.d() ? p() : q();
            b5 = n4.b();
            if (!(a5 != this.f6687b.a()) && !b5) {
                break;
            }
        } while (!b5);
        return n4.a();
    }

    private l p() {
        while (l(this.f6687b.a())) {
            n d5 = d(this.f6687b.a());
            this.f6687b.h(d5.a());
            if (d5.c()) {
                return new l(new o(this.f6687b.a(), this.f6688c.toString()), true);
            }
            this.f6688c.append(d5.b());
        }
        if (h(this.f6687b.a())) {
            this.f6687b.b(3);
            this.f6687b.g();
        } else if (i(this.f6687b.a())) {
            if (this.f6687b.a() + 5 < this.f6686a.l()) {
                this.f6687b.b(5);
            } else {
                this.f6687b.h(this.f6686a.l());
            }
            this.f6687b.e();
        }
        return new l(false);
    }

    private l q() {
        while (m(this.f6687b.a())) {
            p e4 = e(this.f6687b.a());
            this.f6687b.h(e4.a());
            if (e4.d()) {
                return new l(e4.e() ? new o(this.f6687b.a(), this.f6688c.toString()) : new o(this.f6687b.a(), this.f6688c.toString(), e4.c()), true);
            }
            this.f6688c.append(e4.b());
            if (e4.e()) {
                return new l(new o(this.f6687b.a(), this.f6688c.toString()), true);
            }
            this.f6688c.append(e4.c());
        }
        if (j(this.f6687b.a())) {
            this.f6687b.e();
            this.f6687b.b(4);
        }
        return new l(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(StringBuilder sb, int i4) {
        String str = null;
        while (true) {
            o c5 = c(i4, str);
            String a5 = r.a(c5.b());
            if (a5 != null) {
                sb.append(a5);
            }
            String valueOf = c5.d() ? String.valueOf(c5.c()) : null;
            if (i4 == c5.a()) {
                return sb.toString();
            }
            i4 = c5.a();
            str = valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o c(int i4, String str) {
        this.f6688c.setLength(0);
        if (str != null) {
            this.f6688c.append(str);
        }
        this.f6687b.h(i4);
        o o4 = o();
        return (o4 == null || !o4.d()) ? new o(this.f6687b.a(), this.f6688c.toString()) : new o(this.f6687b.a(), this.f6688c.toString(), o4.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i4, int i5) {
        return g(this.f6686a, i4, i5);
    }
}

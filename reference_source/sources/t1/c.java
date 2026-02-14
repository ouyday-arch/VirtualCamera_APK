package t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g {
    private int b(h hVar, StringBuilder sb, StringBuilder sb2, int i4) {
        int length = sb.length();
        sb.delete(length - i4, length);
        hVar.f5926f--;
        int c5 = c(hVar.c(), sb2);
        hVar.k();
        return c5;
    }

    private static String d(CharSequence charSequence) {
        int charAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(h hVar, StringBuilder sb) {
        hVar.s(d(sb));
        sb.delete(0, 3);
    }

    @Override // t1.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c5 = hVar.c();
            hVar.f5926f++;
            int c6 = c(c5, sb);
            int a5 = hVar.a() + ((sb.length() / 3) << 1);
            hVar.q(a5);
            int a6 = hVar.g().a() - a5;
            if (!hVar.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && a6 != 2) {
                    c6 = b(hVar, sb, sb2, c6);
                }
                while (sb.length() % 3 == 1) {
                    if (c6 > 3) {
                        c6 = b(hVar, sb, sb2, c6);
                    } else if (a6 == 1) {
                        break;
                    } else {
                        c6 = b(hVar, sb, sb2, c6);
                    }
                }
            } else if (sb.length() % 3 == 0 && j.n(hVar.d(), hVar.f5926f, e()) != e()) {
                hVar.o(0);
                break;
            }
        }
        f(hVar, sb);
    }

    int c(char c5, StringBuilder sb) {
        int i4;
        int i5;
        char c6;
        if (c5 == ' ') {
            c6 = 3;
        } else {
            if (c5 >= '0' && c5 <= '9') {
                i5 = (c5 - '0') + 4;
            } else {
                if (c5 < 'A' || c5 > 'Z') {
                    if (c5 < ' ') {
                        sb.append((char) 0);
                    } else {
                        if (c5 <= '/') {
                            sb.append((char) 1);
                            i4 = c5 - '!';
                        } else if (c5 <= '@') {
                            sb.append((char) 1);
                            i4 = (c5 - ':') + 15;
                        } else if (c5 <= '_') {
                            sb.append((char) 1);
                            i4 = (c5 - '[') + 22;
                        } else {
                            if (c5 > 127) {
                                sb.append("\u0001\u001e");
                                return c((char) (c5 - 128), sb) + 2;
                            }
                            sb.append((char) 2);
                            i4 = c5 - '`';
                        }
                        c5 = (char) i4;
                    }
                    sb.append(c5);
                    return 2;
                }
                i5 = (c5 - 'A') + 14;
            }
            c6 = (char) i5;
        }
        sb.append(c6);
        return 1;
    }

    public int e() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        if (r8.i() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r8.i() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void f(t1.h r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 3
            int r0 = r0 / r1
            r2 = 1
            int r0 = r0 << r2
            int r3 = r9.length()
            int r3 = r3 % r1
            int r4 = r8.a()
            int r4 = r4 + r0
            r8.q(r4)
            t1.k r0 = r8.g()
            int r0 = r0.a()
            int r0 = r0 - r4
            r4 = 0
            r5 = 254(0xfe, float:3.56E-43)
            r6 = 2
            if (r3 != r6) goto L3b
            r9.append(r4)
        L27:
            int r0 = r9.length()
            if (r0 < r1) goto L31
            g(r8, r9)
            goto L27
        L31:
            boolean r9 = r8.i()
            if (r9 == 0) goto L6d
        L37:
            r8.r(r5)
            goto L6d
        L3b:
            if (r0 != r2) goto L58
            if (r3 != r2) goto L58
        L3f:
            int r0 = r9.length()
            if (r0 < r1) goto L49
            g(r8, r9)
            goto L3f
        L49:
            boolean r9 = r8.i()
            if (r9 == 0) goto L52
            r8.r(r5)
        L52:
            int r9 = r8.f5926f
            int r9 = r9 - r2
            r8.f5926f = r9
            goto L6d
        L58:
            if (r3 != 0) goto L71
        L5a:
            int r2 = r9.length()
            if (r2 < r1) goto L64
            g(r8, r9)
            goto L5a
        L64:
            if (r0 > 0) goto L37
            boolean r9 = r8.i()
            if (r9 == 0) goto L6d
            goto L37
        L6d:
            r8.o(r4)
            return
        L71:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Unexpected case. Please report!"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.c.f(t1.h, java.lang.StringBuilder):void");
    }
}
